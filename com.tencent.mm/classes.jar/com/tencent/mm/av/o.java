package com.tencent.mm.av;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.i.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bq;

public final class o
  extends n
  implements k
{
  private f callback;
  private int gzx;
  private g ibZ;
  private a ieK;
  private final b rr;
  
  public o(int paramInt, dtw paramdtw, g paramg, d paramd, a parama)
  {
    this(paramInt, paramdtw, paramg, paramd, parama, (byte)0);
    AppMethodBeat.i(150717);
    AppMethodBeat.o(150717);
  }
  
  private o(int paramInt, dtw paramdtw, g paramg, d paramd, a parama, byte paramByte)
  {
    AppMethodBeat.i(218739);
    b.a locala = new b.a();
    locala.hQF = new dtw();
    locala.hQG = new dtx();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.hQH = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.aDS();
    this.ieK = parama;
    this.gzx = paramInt;
    this.ibZ = paramg;
    parama = (dtw)this.rr.hQD.hQJ;
    parama.FNG = paramdtw.FNG;
    parama.FNH = paramdtw.FNH;
    parama.HZu = paramdtw.HZu;
    parama.urJ = paramdtw.urJ;
    parama.FNL = paramdtw.FNL;
    parama.Ghj = paramdtw.Ghj;
    paramg = h.aRz(q.aIX().o(paramg.icq, "", ""));
    if (paramg != null)
    {
      paramInt = paramg.outWidth;
      parama.HZC = paramInt;
      if (paramg == null) {
        break label607;
      }
      paramInt = paramg.outHeight;
      label209:
      parama.HZB = paramInt;
      parama.HZz = paramd.field_fileId;
      parama.HZA = paramd.field_thumbimgLength;
      parama.xsB = paramd.field_thumbimgLength;
      parama.xsC = 0;
      parama.xsD = paramd.field_thumbimgLength;
      parama.xsE = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parama.ikm = paramdtw.ikm;
      parama.FKQ = paramdtw.FKQ;
      parama.FKS = paramdtw.FKS;
      parama.FKR = paramdtw.FKR;
      parama.Ghh = 1;
      parama.Hvb = null;
      if (!paramd.XY()) {
        break label612;
      }
      ae.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.HJK = 1;
      parama.Ghg = "";
      parama.Hdo = "";
      label407:
      parama.GUb = paramdtw.GUb;
      if (paramdtw.GUb != 1) {
        break label635;
      }
      parama.HZx = ((int)paramd.field_fileLength);
      parama.HZy = paramd.field_midimgLength;
      parama.HZv = paramd.field_fileId;
    }
    for (parama.HZw = paramd.field_fileId;; parama.HZw = paramd.field_fileId)
    {
      parama.Ghi = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      if (((s)com.tencent.mm.kernel.g.ad(s.class)).ifAddTicketByActionFlag(z.a(paramdtw.FNH))) {
        parama.Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(z.a(paramdtw.FNH));
      }
      ae.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.Ghj), Integer.valueOf(parama.HJK), bu.aSM(parama.Ghg), Integer.valueOf(parama.Ghi) });
      AppMethodBeat.o(218739);
      return;
      paramInt = 0;
      break;
      label607:
      paramInt = 0;
      break label209;
      label612:
      parama.Ghg = paramd.field_aesKey;
      parama.Hdo = paramd.field_aesKey;
      break label407;
      label635:
      parama.HZx = 0;
      parama.HZy = ((int)paramd.field_fileLength);
      parama.HZv = "";
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150718);
    ae.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((dtw)(dtw)this.rr.hQD.hQJ).toString() });
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
    ae.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (dtx)((b)paramq).hQE.hQJ;
    ae.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.xrk) });
    if ((paramString != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(paramString.Ghl);
    }
    if (this.ieK != null) {
      this.ieK.a(paramString.xrk, paramString.CreateTime, paramInt2, paramInt3, paramString.FNL);
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
 * Qualified Name:     com.tencent.mm.av.o
 * JD-Core Version:    0.7.0.1
 */