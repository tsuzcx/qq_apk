package com.tencent.mm.as;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.j.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.protocal.c.cbi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private int dFU;
  private final b dmK;
  private f dmL;
  private e epx;
  private m.a epy;
  
  public m(int paramInt, cbh paramcbh, e parame, d paramd, m.a parama)
  {
    b.a locala = new b.a();
    locala.ecH = new cbh();
    locala.ecI = new cbi();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.ecG = 110;
    locala.ecJ = 9;
    locala.ecK = 1000000009;
    this.dmK = locala.Kt();
    this.epy = parama;
    this.dFU = paramInt;
    this.epx = parame;
    parama = (cbh)this.dmK.ecE.ecN;
    parama.svF = paramcbh.svF;
    parama.svG = paramcbh.svG;
    parama.tQp = paramcbh.tQp;
    parama.kSW = paramcbh.kSW;
    parama.svK = paramcbh.svK;
    parama.sGT = paramcbh.sGT;
    parame = c.YU(o.OJ().o(parame.ens, "", ""));
    if (parame != null)
    {
      paramInt = parame.outWidth;
      parama.tQx = paramInt;
      if (parame == null) {
        break label535;
      }
      paramInt = parame.outHeight;
      label204:
      parama.tQw = paramInt;
      parama.tQu = paramd.field_fileId;
      parama.tQv = paramd.field_thumbimgLength;
      parama.ndf = paramd.field_thumbimgLength;
      parama.ndg = 0;
      parama.ndh = paramd.field_thumbimgLength;
      parama.ndi = new bmk().bs(new byte[0]);
      parama.euK = paramcbh.euK;
      parama.sua = paramcbh.sua;
      parama.suc = paramcbh.suc;
      parama.sub = paramcbh.sub;
      parama.sGR = 1;
      if (!paramd.wV()) {
        break label540;
      }
      y.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.tHc = 1;
      parama.sGQ = "";
      parama.tlO = "";
      label396:
      parama.tfc = paramcbh.tfc;
      if (paramcbh.tfc != 1) {
        break label563;
      }
      parama.tQs = paramd.field_fileLength;
      parama.tQt = paramd.field_midimgLength;
      parama.tQq = paramd.field_fileId;
    }
    for (parama.tQr = paramd.field_fileId;; parama.tQr = paramd.field_fileId)
    {
      parama.sGS = paramd.field_filecrc;
      parama.jnU = paramd.field_filemd5;
      y.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.sGT), Integer.valueOf(parama.tHc), bk.aac(parama.sGQ), Integer.valueOf(parama.sGS) });
      return;
      paramInt = 0;
      break;
      label535:
      paramInt = 0;
      break label204;
      label540:
      parama.sGQ = paramd.field_aesKey;
      parama.tlO = paramd.field_aesKey;
      break label396;
      label563:
      parama.tQs = 0;
      parama.tQt = paramd.field_fileLength;
      parama.tQq = "";
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((cbh)(cbh)this.dmK.ecE.ecN).toString() });
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (cbi)((b)paramq).ecF.ecN;
    y.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.mPL), Long.valueOf(paramString.ndp) });
    if (this.epy != null) {
      this.epy.a(paramString.ndp, paramString.mPL, paramInt2, paramInt3);
    }
    this.dmL.onSceneEnd(0, 0, "", this);
  }
  
  public final int getType()
  {
    return 110;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.m
 * JD-Core Version:    0.7.0.1
 */