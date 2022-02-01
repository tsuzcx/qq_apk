package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i heq;
  public int kfa;
  private int rcN;
  public byte[] rcO;
  private int rcP;
  private String rcQ;
  private int rcR;
  private final com.tencent.mm.ak.d rr;
  
  public i(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108686);
    d.a locala = new d.a();
    locala.iLN = new bmf();
    locala.iLO = new bmg();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.kfa = paramInt1;
    this.rcN = paramInt2;
    this.rcP = paramInt3;
    this.rcQ = paramString;
    this.rcO = paramArrayOfByte;
    this.rcR = paramInt4;
    AppMethodBeat.o(108686);
  }
  
  public final bmg cGs()
  {
    if (this.rr == null) {
      return null;
    }
    return (bmg)this.rr.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(108688);
    this.heq = parami;
    bmf localbmf = (bmf)this.rr.iLK.iLR;
    if (this.rcO != null)
    {
      localbmf.LUY = z.aC(this.rcO);
      if (localbmf.LUY != null) {
        break label139;
      }
    }
    label139:
    for (parami = "Buf is NULL";; parami = localbmf.LUY.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", parami);
      localbmf.DesignerUin = this.rcN;
      localbmf.OpCode = this.kfa;
      localbmf.Lst = this.rcP;
      localbmf.LUZ = this.rcQ;
      localbmf.LVa = this.rcR;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108688);
      return i;
      localbmf.LUY = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public final int getType()
  {
    return 821;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108687);
    Log.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    Object localObject;
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.rcO == null) || (this.rcO.length <= 0)) && (this.kfa != 3)))
    {
      paramArrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpT;
      str = this.rcN;
      localObject = cGs();
      if ((!Util.isNullOrNil(str)) && (localObject != null)) {
        break label200;
      }
      Log.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      params = (bmg)((com.tencent.mm.ak.d)params).iLL.iLR;
      if (params.LUY != null) {
        this.rcO = z.a(params.LUY);
      }
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108687);
      return;
      try
      {
        label200:
        j localj = new j();
        localj.field_designerIDAndType = (str + k.a.OsL.value);
        localj.field_content = ((bmg)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(str).append(k.a.OsL.value).toString();
        if (paramArrayOfByte.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label348;
        }
        Log.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      }
      continue;
      label348:
      Log.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */