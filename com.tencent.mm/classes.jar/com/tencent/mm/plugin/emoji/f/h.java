package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.h.a;
import java.io.IOException;

public final class h
  extends m
  implements k
{
  private f eGj;
  public int gxQ;
  private int liC;
  public byte[] liD;
  private int liE;
  private String liF;
  private int liG;
  private final b rr;
  
  public h(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53114);
    b.a locala = new b.a();
    locala.fsX = new ajo();
    locala.fsY = new ajp();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.gxQ = paramInt1;
    this.liC = paramInt2;
    this.liE = paramInt3;
    this.liF = paramString;
    this.liD = paramArrayOfByte;
    this.liG = paramInt4;
    AppMethodBeat.o(53114);
  }
  
  public final ajp blC()
  {
    if (this.rr == null) {
      return null;
    }
    return (ajp)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53116);
    this.eGj = paramf;
    ajo localajo = (ajo)this.rr.fsV.fta;
    if (this.liD != null)
    {
      localajo.xaZ = aa.ac(this.liD);
      if (localajo.xaZ != null) {
        break label139;
      }
    }
    label139:
    for (paramf = "Buf is NULL";; paramf = localajo.xaZ.toString())
    {
      ab.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", paramf);
      localajo.DesignerUin = this.liC;
      localajo.OpCode = this.gxQ;
      localajo.wQm = this.liE;
      localajo.xba = this.liF;
      localajo.xbb = this.liG;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(53116);
      return i;
      localajo.xaZ = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public final int getType()
  {
    return 821;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53115);
    ab.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    Object localObject;
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.liD == null) || (this.liD.length <= 0)) && (this.gxQ != 3)))
    {
      paramArrayOfByte = ((d)com.tencent.mm.kernel.g.G(d.class)).getEmojiStorageMgr().yNt;
      str = this.liC;
      localObject = blC();
      if ((!bo.isNullOrNil(str)) && (localObject != null)) {
        break label200;
      }
      ab.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      paramq = (ajp)((b)paramq).fsW.fta;
      if (paramq.xaZ != null) {
        this.liD = aa.a(paramq.xaZ);
      }
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53115);
      return;
      try
      {
        label200:
        com.tencent.mm.storage.emotion.g localg = new com.tencent.mm.storage.emotion.g();
        localg.field_designerIDAndType = (str + h.a.yQa.value);
        localg.field_content = ((ajp)localObject).toByteArray();
        localObject = localg.convertTo();
        new StringBuilder().append(str).append(h.a.yQa.value).toString();
        if (paramArrayOfByte.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label348;
        }
        ab.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        ab.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bo.l(paramArrayOfByte) });
      }
      continue;
      label348:
      ab.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */