package com.tencent.mm.av;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.i.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bj;

public final class m
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private int gdg;
  private e hJa;
  private a hJb;
  private final b rr;
  
  public m(int paramInt, dni paramdni, e parame, d paramd, a parama)
  {
    AppMethodBeat.i(150717);
    b.a locala = new b.a();
    locala.hvt = new dni();
    locala.hvu = new dnj();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.reqCmdId = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.aAz();
    this.hJb = parama;
    this.gdg = paramInt;
    this.hJa = parame;
    parama = (dni)this.rr.hvr.hvw;
    parama.DPT = paramdni.DPT;
    parama.DPU = paramdni.DPU;
    parama.FUT = paramdni.FUT;
    parama.tit = paramdni.tit;
    parama.DPY = paramdni.DPY;
    parama.EhD = paramdni.EhD;
    parame = f.aKw(o.aFx().p(parame.hGO, "", ""));
    if (parame != null)
    {
      paramInt = parame.outWidth;
      parama.FVb = paramInt;
      if (parame == null) {
        break label601;
      }
      paramInt = parame.outHeight;
      label209:
      parama.FVa = paramInt;
      parama.FUY = paramd.field_fileId;
      parama.FUZ = paramd.field_thumbimgLength;
      parama.vTH = paramd.field_thumbimgLength;
      parama.vTI = 0;
      parama.vTJ = paramd.field_thumbimgLength;
      parama.vTK = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parama.hOf = paramdni.hOf;
      parama.DNn = paramdni.DNn;
      parama.DNp = paramdni.DNp;
      parama.DNo = paramdni.DNo;
      parama.EhB = 1;
      if (!paramd.Vx()) {
        break label606;
      }
      ac.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.FFJ = 1;
      parama.EhA = "";
      parama.Fao = "";
      label401:
      parama.ERj = paramdni.ERj;
      if (paramdni.ERj != 1) {
        break label629;
      }
      parama.FUW = ((int)paramd.field_fileLength);
      parama.FUX = paramd.field_midimgLength;
      parama.FUU = paramd.field_fileId;
    }
    for (parama.FUV = paramd.field_fileId;; parama.FUV = paramd.field_fileId)
    {
      parama.EhC = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(z.a(paramdni.DPU))) {
        parama.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(z.a(paramdni.DPU));
      }
      ac.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.EhD), Integer.valueOf(parama.FFJ), bs.aLJ(parama.EhA), Integer.valueOf(parama.EhC) });
      AppMethodBeat.o(150717);
      return;
      paramInt = 0;
      break;
      label601:
      paramInt = 0;
      break label209;
      label606:
      parama.EhA = paramd.field_aesKey;
      parama.Fao = paramd.field_aesKey;
      break label401;
      label629:
      parama.FUW = 0;
      parama.FUX = ((int)paramd.field_fileLength);
      parama.FUU = "";
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150718);
    ac.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((dni)(dni)this.rr.hvr.hvw).toString() });
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
    ac.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (dnj)((b)paramq).hvs.hvw;
    ac.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.vTQ) });
    if ((paramString != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramString.EhF);
    }
    if (this.hJb != null) {
      this.hJb.a(paramString.vTQ, paramString.CreateTime, paramInt2, paramInt3, paramString.DPY);
    }
    this.callback.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(150719);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.m
 * JD-Core Version:    0.7.0.1
 */