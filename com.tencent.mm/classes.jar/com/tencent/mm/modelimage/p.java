package com.tencent.mm.modelimage;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.g.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.ftv;
import com.tencent.mm.protocal.protobuf.ftw;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int mxO;
  private h oGb;
  private a oIK;
  private final c rr;
  
  public p(int paramInt, ftv paramftv, h paramh, d paramd, a parama)
  {
    this(paramInt, paramftv, paramh, paramd, parama, (byte)0);
    AppMethodBeat.i(150717);
    AppMethodBeat.o(150717);
  }
  
  private p(int paramInt, ftv paramftv, h paramh, d paramd, a parama, byte paramByte)
  {
    AppMethodBeat.i(238985);
    c.a locala = new c.a();
    locala.otE = new ftv();
    locala.otF = new ftw();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.otG = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.bEF();
    this.oIK = parama;
    this.mxO = paramInt;
    this.oGb = paramh;
    parama = (ftv)c.b.b(this.rr.otB);
    parama.YFE = paramftv.YFE;
    parama.YFF = paramftv.YFF;
    parama.abRT = paramftv.abRT;
    parama.IIs = paramftv.IIs;
    parama.YFJ = paramftv.YFJ;
    parama.ZaQ = paramftv.ZaQ;
    paramh = BitmapUtil.getImageOptions(r.bKa().v(paramh.oGt, "", ""));
    if (paramh != null)
    {
      paramInt = paramh.outWidth;
      parama.abzF = paramInt;
      if (paramh == null) {
        break label604;
      }
      paramInt = paramh.outHeight;
      label206:
      parama.abzE = paramInt;
      parama.abRY = paramd.field_fileId;
      parama.abzD = paramd.field_thumbimgLength;
      parama.NkN = paramd.field_thumbimgLength;
      parama.NkO = 0;
      parama.NkP = paramd.field_thumbimgLength;
      parama.NkQ = new gol().df(new byte[0]);
      parama.oOI = paramftv.oOI;
      parama.YCm = paramftv.YCm;
      parama.YCo = paramftv.YCo;
      parama.YCn = paramftv.YCn;
      parama.ZaO = 1;
      parama.abge = null;
      if (!paramd.aLG()) {
        break label609;
      }
      Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.abzb = 1;
      parama.ZaN = "";
      parama.aaGp = "";
      label404:
      parama.aava = paramftv.aava;
      if (paramftv.aava != 1) {
        break label632;
      }
      parama.abRW = ((int)paramd.field_fileLength);
      parama.abRX = paramd.field_midimgLength;
      parama.abRU = paramd.field_fileId;
    }
    for (parama.abRV = paramd.field_fileId;; parama.abRV = paramd.field_fileId)
    {
      parama.ZaP = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      if (((v)com.tencent.mm.kernel.h.az(v.class)).ifAddTicketByActionFlag(w.a(paramftv.YFF))) {
        parama.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(w.a(paramftv.YFF));
      }
      Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.ZaQ), Integer.valueOf(parama.abzb), Util.secPrint(parama.ZaN), Integer.valueOf(parama.ZaP) });
      AppMethodBeat.o(238985);
      return;
      paramInt = 0;
      break;
      label604:
      paramInt = 0;
      break label206;
      label609:
      parama.ZaN = paramd.field_aesKey;
      parama.aaGp = paramd.field_aesKey;
      break label404;
      label632:
      parama.abRW = 0;
      parama.abRX = ((int)paramd.field_fileLength);
      parama.abRU = "";
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150718);
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((ftv)c.b.b(this.rr.otB)).toString() });
    this.callback = paramh;
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
    paramString = (ftw)c.c.b(((c)params).otC);
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.Njv) });
    if ((paramString != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.az(v.class)).setEnSendMsgActionFlag(paramString.ZaS);
    }
    if (this.oIK != null) {
      this.oIK.a(paramString.Njv, paramString.CreateTime, paramInt2, paramInt3, paramString.YFJ);
    }
    this.callback.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(150719);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.p
 * JD-Core Version:    0.7.0.1
 */