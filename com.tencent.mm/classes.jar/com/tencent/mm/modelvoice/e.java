package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bb;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.fzd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends p
  implements m
{
  private static bb pdk;
  private static List<c> pdl;
  private com.tencent.mm.am.h callback;
  public String fileName;
  private String hVQ;
  private com.tencent.mm.modelcdntran.c<r> oIg;
  private MTimerHandler orP;
  private String pdj;
  private boolean pdm;
  private boolean pdn;
  public int retCode;
  private com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(148415);
    pdk = null;
    pdl = new ArrayList();
    AppMethodBeat.o(148415);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(148408);
    this.retCode = 0;
    this.pdm = false;
    this.pdn = false;
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148404);
        if (e.this.doScene(e.a(e.this), e.b(e.this)) == -1) {
          e.b(e.this).onSceneEnd(3, -1, "doScene failed", e.this);
        }
        AppMethodBeat.o(148404);
        return false;
      }
    }, false);
    this.oIg = new e..ExternalSyntheticLambda0(this);
    if (paramr != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fileName = paramr.fileName;
      if (this.fileName == null) {
        break label153;
      }
    }
    label153:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.pdj = paramr.pdj;
      this.hVQ = paramr.hVQ;
      Log.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice[%s]:  file[%s] voiceFormat[%s] user[%s]", new Object[] { toString(), this.fileName, this.pdj, this.hVQ });
      AppMethodBeat.o(148408);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(bb parambb)
  {
    if (pdk == null) {
      pdk = parambb;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(148405);
    if (!pdl.contains(paramc)) {
      pdl.add(paramc);
    }
    AppMethodBeat.o(148405);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148406);
    pdl.remove(paramc);
    AppMethodBeat.o(148406);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(148407);
    final cc localcc = s.QP(this.fileName);
    if (localcc != null)
    {
      if (pdk != null) {
        pdk.a(localcc);
      }
      Iterator localIterator = pdl.iterator();
      while (localIterator.hasNext()) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148403);
            this.pdo.av(localcc);
            AppMethodBeat.o(148403);
          }
        });
      }
    }
    AppMethodBeat.o(148407);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(148409);
    this.callback = paramh;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    paramh = s.QQ(this.fileName);
    if ((paramh == null) || (!paramh.bPj()))
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    Log.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + paramh.pbd);
    if (!s.QG(this.fileName))
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Qf(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    int i = paramh.oZm - paramh.paX;
    if (i <= 0)
    {
      if (paramh.status == 5)
      {
        this.pdn = true;
        Log.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + paramh.oZm + " Local:" + paramh.paX);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148409);
        return -1;
      }
      s.a(this.fileName, paramh.paX, null);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    if (paramh.osy == paramh.oZm) {
      this.pdm = true;
    }
    if (i.aRC().getInt("VoiceCdnDownloadSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneDownloadVoice", "canUseCdnDownload %s", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (paramh.peM == null) || (Util.isNullOrNil(paramh.peM.mOI)) || (Util.isNullOrNil(paramh.peM.aesKey))) {
        break label587;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 56L, 1L, false);
      paramg = new com.tencent.mm.g.g();
      paramg.field_mediaId = ("VoiceData" + this.fileName);
      paramg.field_fullpath = s.getFullPath(this.fileName);
      paramg.field_fileType = 15;
      paramg.field_aesKey = paramh.peM.aesKey;
      paramg.field_fileId = paramh.peM.mOI;
      Log.i("MicroMsg.NetSceneDownloadVoice", "startCdnVoiceDownload %s %s %s %s", new Object[] { paramg.field_mediaId, paramg.field_fullpath, paramg.field_aesKey, paramg.field_fileId });
      if (com.tencent.mm.modelcdntran.b.a(paramg, this.oIg, paramh) != null) {
        break;
      }
      AppMethodBeat.o(148409);
      return -1;
    }
    AppMethodBeat.o(148409);
    return 0;
    label587:
    Object localObject = new c.a();
    ((c.a)localObject).otE = new alc();
    ((c.a)localObject).otF = new ald();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((c.a)localObject).funcId = 128;
    ((c.a)localObject).otG = 20;
    ((c.a)localObject).respCmdId = 1000000020;
    this.rr = ((c.a)localObject).bEF();
    localObject = (alc)c.b.b(this.rr.otB);
    ((alc)localObject).YHk = paramh.clientId;
    ((alc)localObject).Njv = paramh.hTh;
    ((alc)localObject).YTh = i;
    ((alc)localObject).YYs = paramh.paX;
    if (au.bwE(this.hVQ))
    {
      ((alc)localObject).YFk = this.hVQ;
      ((alc)localObject).Zso = paramh.peJ;
    }
    Log.i("MicroMsg.NetSceneDownloadVoice", "[%s]doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { toString(), ((alc)localObject).YHk, Integer.valueOf(((alc)localObject).Njs), Long.valueOf(((alc)localObject).Njv), Integer.valueOf(((alc)localObject).YTh), Integer.valueOf(((alc)localObject).YYs), ((alc)localObject).YFk, Long.valueOf(((alc)localObject).Zso) });
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(148409);
    return i;
  }
  
  public final int getType()
  {
    return 128;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148413);
    Log.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd[" + toString() + "] file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ald)c.c.b(((com.tencent.mm.am.c)params).otC);
    if (paramArrayOfByte.Zsp == 1)
    {
      Log.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.QL(this.fileName);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt3 == -22)
    {
      s.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 231L, 1L, false);
      s.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 230L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + params.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    Log.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.NkQ.abwJ + " fileOff:" + paramArrayOfByte.YYs);
    if (paramArrayOfByte.NkQ.aaxD == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    params = paramArrayOfByte.NkQ.aaxD.toByteArray();
    if ((params == null) || (params.length == 0))
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramInt1 = s.bT(this.pdj, this.fileName).y(params, params.length, paramArrayOfByte.YYs);
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    s.a(this.fileName, params, params.length);
    Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.pdj);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd[" + toString() + "] : file:%s ret:%s", new Object[] { this.fileName, Integer.valueOf(paramInt1) });
    if (paramInt1 < 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 229L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt1 == 1)
    {
      doNotify();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    long l = 1000L;
    if (this.pdm) {
      l = 0L;
    }
    this.orP.startTimer(l);
    AppMethodBeat.o(148413);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(148412);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(148412);
    return bool;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(148410);
    params = (alc)c.b.b(((com.tencent.mm.am.c)params).otB);
    if ((params.Njv == 0L) || (params.YHk == null) || (params.YHk.length() == 0) || (params.YTh <= 0) || (params.YYs < 0))
    {
      s.Qf(this.fileName);
      params = p.b.oui;
      AppMethodBeat.o(148410);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(148410);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(148411);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 233L, 1L, false);
    s.Qf(this.fileName);
    AppMethodBeat.o(148411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */