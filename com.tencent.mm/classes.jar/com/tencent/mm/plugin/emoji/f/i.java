package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.protocal.protobuf.eae;
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
  private com.tencent.mm.an.i jQg;
  public int mWz;
  private final com.tencent.mm.an.d rr;
  private int uFS;
  public byte[] uFT;
  private int uFU;
  private String uFV;
  private int uFW;
  
  public i(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108686);
    d.a locala = new d.a();
    locala.lBU = new bto();
    locala.lBV = new btp();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.mWz = paramInt1;
    this.uFS = paramInt2;
    this.uFU = paramInt3;
    this.uFV = paramString;
    this.uFT = paramArrayOfByte;
    this.uFW = paramInt4;
    AppMethodBeat.o(108686);
  }
  
  public final btp cVb()
  {
    AppMethodBeat.i(258295);
    if (this.rr == null)
    {
      AppMethodBeat.o(258295);
      return null;
    }
    btp localbtp = (btp)d.c.b(this.rr.lBS);
    AppMethodBeat.o(258295);
    return localbtp;
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(108688);
    this.jQg = parami;
    bto localbto = (bto)d.b.b(this.rr.lBR);
    if (this.uFT != null)
    {
      localbto.TdH = z.aN(this.uFT);
      if (localbto.TdH != null) {
        break label139;
      }
    }
    label139:
    for (parami = "Buf is NULL";; parami = localbto.TdH.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", parami);
      localbto.TdG = this.uFS;
      localbto.RLe = this.mWz;
      localbto.StS = this.uFU;
      localbto.TdI = this.uFV;
      localbto.TdJ = this.uFW;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108688);
      return i;
      localbto.TdH = new eae();
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
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.uFT == null) || (this.uFT.length <= 0)) && (this.mWz != 3)))
    {
      paramArrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFN;
      str = this.uFS;
      localObject = cVb();
      if ((!Util.isNullOrNil(str)) && (localObject != null)) {
        break label200;
      }
      Log.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      params = (btp)d.c.b(((com.tencent.mm.an.d)params).lBS);
      if (params.TdH != null) {
        this.uFT = z.a(params.TdH);
      }
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108687);
      return;
      try
      {
        label200:
        j localj = new j();
        localj.field_designerIDAndType = (str + k.a.VIK.value);
        localj.field_content = ((btp)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(str).append(k.a.VIK.value).toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */