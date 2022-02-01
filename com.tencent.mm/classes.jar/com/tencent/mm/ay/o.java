package com.tencent.mm.ay;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;

public final class o
  extends com.tencent.mm.an.q
  implements m
{
  private com.tencent.mm.an.i callback;
  private int jXU;
  private g lNs;
  private a lQa;
  private final com.tencent.mm.an.d rr;
  
  public o(int paramInt, eyc parameyc, g paramg, com.tencent.mm.i.d paramd, a parama)
  {
    this(paramInt, parameyc, paramg, paramd, parama, (byte)0);
    AppMethodBeat.i(150717);
    AppMethodBeat.o(150717);
  }
  
  private o(int paramInt, eyc parameyc, g paramg, com.tencent.mm.i.d paramd, a parama, byte paramByte)
  {
    AppMethodBeat.i(213672);
    d.a locala = new d.a();
    locala.lBU = new eyc();
    locala.lBV = new eyd();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.lBW = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.bgN();
    this.lQa = parama;
    this.jXU = paramInt;
    this.lNs = paramg;
    parama = (eyc)d.b.b(this.rr.lBR);
    parama.RID = parameyc.RID;
    parama.RIE = parameyc.RIE;
    parama.Uym = parameyc.Uym;
    parama.COi = parameyc.COi;
    parama.RII = parameyc.RII;
    parama.ScY = parameyc.ScY;
    paramg = BitmapUtil.getImageOptions(q.bmh().r(paramg.lNJ, "", ""));
    if (paramg != null)
    {
      paramInt = paramg.outWidth;
      parama.Uyu = paramInt;
      if (paramg == null) {
        break label607;
      }
      paramInt = paramg.outHeight;
      label209:
      parama.Uyt = paramInt;
      parama.Uyr = paramd.field_fileId;
      parama.Uys = paramd.field_thumbimgLength;
      parama.HmZ = paramd.field_thumbimgLength;
      parama.Hna = 0;
      parama.Hnb = paramd.field_thumbimgLength;
      parama.Hnc = new eae().dc(new byte[0]);
      parama.lVG = parameyc.lVG;
      parama.RFI = parameyc.RFI;
      parama.RFK = parameyc.RFK;
      parama.RFJ = parameyc.RFJ;
      parama.ScW = 1;
      parama.TPI = null;
      if (!paramd.arK()) {
        break label612;
      }
      Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.UhL = 1;
      parama.ScV = "";
      parama.Tse = "";
      label407:
      parama.ThK = parameyc.ThK;
      if (parameyc.ThK != 1) {
        break label635;
      }
      parama.Uyp = ((int)paramd.field_fileLength);
      parama.Uyq = paramd.field_midimgLength;
      parama.Uyn = paramd.field_fileId;
    }
    for (parama.Uyo = paramd.field_fileId;; parama.Uyo = paramd.field_fileId)
    {
      parama.ScX = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      if (((v)h.ag(v.class)).ifAddTicketByActionFlag(z.a(parameyc.RIE))) {
        parama.ScZ = ((n)h.ae(n.class)).bbL().bws(z.a(parameyc.RIE));
      }
      Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.ScY), Integer.valueOf(parama.UhL), Util.secPrint(parama.ScV), Integer.valueOf(parama.ScX) });
      AppMethodBeat.o(213672);
      return;
      paramInt = 0;
      break;
      label607:
      paramInt = 0;
      break label209;
      label612:
      parama.ScV = paramd.field_aesKey;
      parama.Tse = paramd.field_aesKey;
      break label407;
      label635:
      parama.Uyp = 0;
      parama.Uyq = ((int)paramd.field_fileLength);
      parama.Uyn = "";
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(150718);
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((eyc)(eyc)d.b.b(this.rr.lBR)).toString() });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150718);
    return i;
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150719);
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (eyd)d.c.b(((com.tencent.mm.an.d)params).lBS);
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.HlH) });
    if ((paramString != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)h.ag(v.class)).setEnSendMsgActionFlag(paramString.Sda);
    }
    if (this.lQa != null) {
      this.lQa.a(paramString.HlH, paramString.CreateTime, paramInt2, paramInt3, paramString.RII);
    }
    this.callback.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(150719);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.o
 * JD-Core Version:    0.7.0.1
 */