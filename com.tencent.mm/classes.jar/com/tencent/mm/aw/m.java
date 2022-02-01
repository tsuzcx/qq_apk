package com.tencent.mm.aw;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.i.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bg;

public final class m
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private int fYA;
  private e hix;
  private a hiy;
  private final b rr;
  
  public m(int paramInt, dht paramdht, e parame, d paramd, a parama)
  {
    AppMethodBeat.i(150717);
    b.a locala = new b.a();
    locala.gUU = new dht();
    locala.gUV = new dhu();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.reqCmdId = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.atI();
    this.hiy = parama;
    this.fYA = paramInt;
    this.hix = parame;
    parama = (dht)this.rr.gUS.gUX;
    parama.Cxx = paramdht.Cxx;
    parama.Cxy = paramdht.Cxy;
    parama.ExR = paramdht.ExR;
    parama.saz = paramdht.saz;
    parama.CxC = paramdht.CxC;
    parama.COS = paramdht.COS;
    parame = f.aFf(o.ayF().p(parame.hgl, "", ""));
    if (parame != null)
    {
      paramInt = parame.outWidth;
      parama.ExZ = paramInt;
      if (parame == null) {
        break label601;
      }
      paramInt = parame.outHeight;
      label209:
      parama.ExY = paramInt;
      parama.ExW = paramd.field_fileId;
      parama.ExX = paramd.field_thumbimgLength;
      parama.uKQ = paramd.field_thumbimgLength;
      parama.uKR = 0;
      parama.uKS = paramd.field_thumbimgLength;
      parama.uKT = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parama.hnC = paramdht.hnC;
      parama.CuS = paramdht.CuS;
      parama.CuU = paramdht.CuU;
      parama.CuT = paramdht.CuT;
      parama.COQ = 1;
      if (!paramd.UC()) {
        break label606;
      }
      ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.EiL = 1;
      parama.COP = "";
      parama.DET = "";
      label401:
      parama.DvO = paramdht.DvO;
      if (paramdht.DvO != 1) {
        break label629;
      }
      parama.ExU = ((int)paramd.field_fileLength);
      parama.ExV = paramd.field_midimgLength;
      parama.ExS = paramd.field_fileId;
    }
    for (parama.ExT = paramd.field_fileId;; parama.ExT = paramd.field_fileId)
    {
      parama.COR = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(z.a(paramdht.Cxy))) {
        parama.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(z.a(paramdht.Cxy));
      }
      ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.COS), Integer.valueOf(parama.EiL), bt.aGs(parama.COP), Integer.valueOf(parama.COR) });
      AppMethodBeat.o(150717);
      return;
      paramInt = 0;
      break;
      label601:
      paramInt = 0;
      break label209;
      label606:
      parama.COP = paramd.field_aesKey;
      parama.DET = paramd.field_aesKey;
      break label401;
      label629:
      parama.ExU = 0;
      parama.ExV = ((int)paramd.field_fileLength);
      parama.ExS = "";
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150718);
    ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((dht)(dht)this.rr.gUS.gUX).toString() });
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150718);
    return i;
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150719);
    ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (dhu)((b)paramq).gUT.gUX;
    ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.uKZ) });
    if ((paramString != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramString.COU);
    }
    if (this.hiy != null) {
      this.hiy.a(paramString.uKZ, paramString.CreateTime, paramInt2, paramInt3, paramString.CxC);
    }
    this.callback.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(150719);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.m
 * JD-Core Version:    0.7.0.1
 */