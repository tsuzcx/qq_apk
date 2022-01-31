package com.tencent.mm.at;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private int eDw;
  private e fFX;
  private a fFY;
  private final b rr;
  
  public m(int paramInt, con paramcon, e parame, com.tencent.mm.i.d paramd, a parama)
  {
    AppMethodBeat.i(78354);
    b.a locala = new b.a();
    locala.fsX = new con();
    locala.fsY = new coo();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.reqCmdId = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.ado();
    this.fFY = parama;
    this.eDw = paramInt;
    this.fFX = parame;
    parama = (con)this.rr.fsV.fta;
    parama.woP = paramcon.woP;
    parama.woQ = paramcon.woQ;
    parama.xXk = paramcon.xXk;
    parama.nqW = paramcon.nqW;
    parama.woU = paramcon.woU;
    parama.wDr = paramcon.wDr;
    parame = com.tencent.mm.sdk.platformtools.d.aoT(o.ahC().q(parame.fDO, "", ""));
    if (parame != null)
    {
      paramInt = parame.outWidth;
      parama.xXs = paramInt;
      if (parame == null) {
        break label545;
      }
      paramInt = parame.outHeight;
      label209:
      parama.xXr = paramInt;
      parama.xXp = paramd.field_fileId;
      parama.xXq = paramd.field_thumbimgLength;
      parama.pIx = paramd.field_thumbimgLength;
      parama.pIy = 0;
      parama.pIz = paramd.field_thumbimgLength;
      parama.pIA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parama.fKw = paramcon.fKw;
      parama.wmD = paramcon.wmD;
      parama.wmF = paramcon.wmF;
      parama.wmE = paramcon.wmE;
      parama.wDp = 1;
      if (!paramd.Jm()) {
        break label550;
      }
      ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.xKZ = 1;
      parama.wDo = "";
      parama.xlh = "";
      label401:
      parama.xdn = paramcon.xdn;
      if (paramcon.xdn != 1) {
        break label573;
      }
      parama.xXn = paramd.field_fileLength;
      parama.xXo = paramd.field_midimgLength;
      parama.xXl = paramd.field_fileId;
    }
    for (parama.xXm = paramd.field_fileId;; parama.xXm = paramd.field_fileId)
    {
      parama.wDq = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.wDr), Integer.valueOf(parama.xKZ), bo.aqg(parama.wDo), Integer.valueOf(parama.wDq) });
      AppMethodBeat.o(78354);
      return;
      paramInt = 0;
      break;
      label545:
      paramInt = 0;
      break label209;
      label550:
      parama.wDo = paramd.field_aesKey;
      parama.xlh = paramd.field_aesKey;
      break label401;
      label573:
      parama.xXn = 0;
      parama.xXo = paramd.field_fileLength;
      parama.xXl = "";
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78355);
    ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((con)(con)this.rr.fsV.fta).toString() });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78355);
    return i;
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78356);
    ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (coo)((b)paramq).fsW.fta;
    ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.pIG) });
    if (this.fFY != null) {
      this.fFY.a(paramString.pIG, paramString.CreateTime, paramInt2, paramInt3);
    }
    this.callback.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(78356);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.m
 * JD-Core Version:    0.7.0.1
 */