package com.tencent.mm.av;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;

public final class o
  extends com.tencent.mm.ak.q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private int hmk;
  private g iWX;
  private a iZF;
  private final com.tencent.mm.ak.d rr;
  
  public o(int paramInt, enu paramenu, g paramg, com.tencent.mm.i.d paramd, a parama)
  {
    this(paramInt, paramenu, paramg, paramd, parama, (byte)0);
    AppMethodBeat.i(150717);
    AppMethodBeat.o(150717);
  }
  
  private o(int paramInt, enu paramenu, g paramg, com.tencent.mm.i.d paramd, a parama, byte paramByte)
  {
    AppMethodBeat.i(223632);
    d.a locala = new d.a();
    locala.iLN = new enu();
    locala.iLO = new env();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.funcId = 110;
    locala.iLP = 9;
    locala.respCmdId = 1000000009;
    this.rr = locala.aXF();
    this.iZF = parama;
    this.hmk = paramInt;
    this.iWX = paramg;
    parama = (enu)this.rr.iLK.iLR;
    parama.KHl = paramenu.KHl;
    parama.KHm = paramenu.KHm;
    parama.NlB = paramenu.NlB;
    parama.xKb = paramenu.xKb;
    parama.KHq = paramenu.KHq;
    parama.LbM = paramenu.LbM;
    paramg = BitmapUtil.getImageOptions(q.bcR().o(paramg.iXo, "", ""));
    if (paramg != null)
    {
      paramInt = paramg.outWidth;
      parama.NlJ = paramInt;
      if (paramg == null) {
        break label607;
      }
      paramInt = paramg.outHeight;
      label209:
      parama.NlI = paramInt;
      parama.NlG = paramd.field_fileId;
      parama.NlH = paramd.field_thumbimgLength;
      parama.BsF = paramd.field_thumbimgLength;
      parama.BsG = 0;
      parama.BsH = paramd.field_thumbimgLength;
      parama.BsI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parama.jfi = paramenu.jfi;
      parama.KEq = paramenu.KEq;
      parama.KEs = paramenu.KEs;
      parama.KEr = paramenu.KEr;
      parama.LbK = 1;
      parama.MDZ = null;
      if (!paramd.alL()) {
        break label612;
      }
      Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey });
      parama.MVx = 1;
      parama.LbJ = "";
      parama.Mir = "";
      label407:
      parama.LYt = paramenu.LYt;
      if (paramenu.LYt != 1) {
        break label635;
      }
      parama.NlE = ((int)paramd.field_fileLength);
      parama.NlF = paramd.field_midimgLength;
      parama.NlC = paramd.field_fileId;
    }
    for (parama.NlD = paramd.field_fileId;; parama.NlD = paramd.field_fileId)
    {
      parama.LbL = paramd.field_filecrc;
      parama.Md5 = paramd.field_filemd5;
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(z.a(paramenu.KHm))) {
        parama.LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(z.a(paramenu.KHm));
      }
      Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.LbM), Integer.valueOf(parama.MVx), Util.secPrint(parama.LbJ), Integer.valueOf(parama.LbL) });
      AppMethodBeat.o(223632);
      return;
      paramInt = 0;
      break;
      label607:
      paramInt = 0;
      break label209;
      label612:
      parama.LbJ = paramd.field_aesKey;
      parama.Mir = paramd.field_aesKey;
      break label407;
      label635:
      parama.NlE = 0;
      parama.NlF = ((int)paramd.field_fileLength);
      parama.NlC = "";
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(150718);
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((enu)(enu)this.rr.iLK.iLR).toString() });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150718);
    return i;
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150719);
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (env)((com.tencent.mm.ak.d)params).iLL.iLR;
    Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.CreateTime), Long.valueOf(paramString.Brn) });
    if ((paramString != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramString.LbO);
    }
    if (this.iZF != null) {
      this.iZF.a(paramString.Brn, paramString.CreateTime, paramInt2, paramInt3, paramString.KHq);
    }
    this.callback.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(150719);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.o
 * JD-Core Version:    0.7.0.1
 */