package com.tencent.mm.aw;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.i.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;

public final class o
  extends n
  implements k
{
  private f callback;
  private int gwQ;
  private g hZh;
  private a ibR;
  private final b rr;
  
  public o(int paramInt, dsz paramdsz, g paramg, d paramd, a parama)
  {
    this(paramInt, paramdsz, paramg, paramd, parama, (byte)0);
    AppMethodBeat.i(150717);
    AppMethodBeat.o(150717);
  }
  
  private o(int paramInt, dsz paramdsz, g paramg, d paramd, a parama, byte paramByte)
  {
    AppMethodBeat.i(195288);
    b.a locala = new b.a();
    locala.hNM = new dsz();
    locala.hNN = new dta();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.hNO = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.aDC();
    this.ibR = parama;
    this.gwQ = paramInt;
    this.hZh = paramg;
    parama = (dsz)this.rr.hNK.hNQ;
    parama.Fvi = paramdsz.Fvi;
    parama.Fvj = paramdsz.Fvj;
    parama.HFH = paramdsz.HFH;
    parama.ugm = paramdsz.ugm;
    parama.Fvn = paramdsz.Fvn;
    parama.FOK = paramdsz.FOK;
    paramg = com.tencent.mm.sdk.platformtools.g.aQc(q.aIF().o(paramg.hZy, "", ""));
    if (paramg != null)
    {
      paramInt = paramg.outWidth;
      parama.HFP = paramInt;
      if (paramg == null) {
        break label607;
      }
      paramInt = paramg.outHeight;
      label209:
      parama.HFO = paramInt;
      parama.HFM = paramd.field_fileId;
      parama.HFN = paramd.field_thumbimgLength;
      parama.xcK = paramd.field_thumbimgLength;
      parama.xcL = 0;
      parama.xcM = paramd.field_thumbimgLength;
      parama.xcN = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parama.iht = paramdsz.iht;
      parama.Fss = paramdsz.Fss;
      parama.Fsu = paramdsz.Fsu;
      parama.Fst = paramdsz.Fst;
      parama.FOI = 1;
      parama.HbB = null;
      if (!paramd.XO()) {
        break label612;
      }
      ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.Hqi = 1;
      parama.FOH = "";
      parama.GJN = "";
      label407:
      parama.GAB = paramdsz.GAB;
      if (paramdsz.GAB != 1) {
        break label635;
      }
      parama.HFK = ((int)paramd.field_fileLength);
      parama.HFL = paramd.field_midimgLength;
      parama.HFI = paramd.field_fileId;
    }
    for (parama.HFJ = paramd.field_fileId;; parama.HFJ = paramd.field_fileId)
    {
      parama.FOJ = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      if (((r)com.tencent.mm.kernel.g.ad(r.class)).ifAddTicketByActionFlag(z.a(paramdsz.Fvj))) {
        parama.FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(z.a(paramdsz.Fvj));
      }
      ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.FOK), Integer.valueOf(parama.Hqi), bt.aRp(parama.FOH), Integer.valueOf(parama.FOJ) });
      AppMethodBeat.o(195288);
      return;
      paramInt = 0;
      break;
      label607:
      paramInt = 0;
      break label209;
      label612:
      parama.FOH = paramd.field_aesKey;
      parama.GJN = paramd.field_aesKey;
      break label407;
      label635:
      parama.HFK = 0;
      parama.HFL = ((int)paramd.field_fileLength);
      parama.HFI = "";
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150718);
    ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((dsz)(dsz)this.rr.hNK.hNQ).toString() });
    this.callback = paramf;
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
    paramString = (dta)((b)paramq).hNL.hNQ;
    ad.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.xbt) });
    if ((paramString != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((r)com.tencent.mm.kernel.g.ad(r.class)).setEnSendMsgActionFlag(paramString.FOM);
    }
    if (this.ibR != null) {
      this.ibR.a(paramString.xbt, paramString.CreateTime, paramInt2, paramInt3, paramString.Fvn);
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
 * Qualified Name:     com.tencent.mm.aw.o
 * JD-Core Version:    0.7.0.1
 */