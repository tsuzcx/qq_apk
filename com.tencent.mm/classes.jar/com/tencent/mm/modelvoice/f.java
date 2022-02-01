package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.j.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.model.bt;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.fui;
import com.tencent.mm.protocal.protobuf.fuj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int endFlag;
  public String fileName;
  MTimerHandler orP;
  private int pbK;
  private boolean pdm;
  private int pdq;
  private long pdr;
  private boolean pds;
  private boolean pdt;
  private boolean pdu;
  private String pdv;
  private String pdw;
  private long pdx;
  private com.tencent.mm.modelcdntran.c<r> pdy;
  public int retCode;
  private com.tencent.mm.am.c rr;
  
  private f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(148417);
    this.retCode = 0;
    this.pbK = 0;
    this.pds = false;
    this.pdt = false;
    this.pdu = false;
    this.pdv = "";
    this.pdw = "";
    this.pdx = 0L;
    this.pdm = false;
    this.endFlag = 0;
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148416);
        r localr = s.QQ(f.a(f.this));
        if ((localr == null) || (!localr.bPk()))
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.a(f.this));
          f.a(f.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.b(f.this).onSceneEnd(3, -1, "doScene failed", f.this);
          AppMethodBeat.o(148416);
          return false;
        }
        if ((!f.c(f.this)) && (3 != localr.status) && (8 != localr.status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localr.pba > 30L)
          {
            Log.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.a(f.this));
            f.a(f.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
            f.b(f.this).onSceneEnd(3, -1, "doScene failed", f.this);
            AppMethodBeat.o(148416);
            return false;
          }
          if (l - f.d(f.this) < 2000L)
          {
            Log.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.a(f.this) + " but last send time:" + (l - f.d(f.this)));
            AppMethodBeat.o(148416);
            return true;
          }
          g localg = s.QH(f.a(f.this)).eQ(localr.oZm, 6000);
          Log.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.a(f.this) + " readByte:" + localg.hxg + " stat:" + localr.status);
          if (localg.hxg < 2000)
          {
            AppMethodBeat.o(148416);
            return true;
          }
        }
        if (f.this.doScene(f.e(f.this), f.b(f.this)) == -1)
        {
          f.a(f.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.b(f.this).onSceneEnd(3, -1, "doScene failed", f.this);
        }
        AppMethodBeat.o(148416);
        return false;
      }
    }, true);
    this.pdy = new f..ExternalSyntheticLambda0(this);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      Log.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.pdq = paramInt;
      AppMethodBeat.o(148417);
      return;
      bool = false;
    }
  }
  
  public f(String paramString, boolean paramBoolean)
  {
    this(paramString);
    this.pds = paramBoolean;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(148418);
    this.callback = paramh;
    this.pdm = false;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    r localr = s.QQ(this.fileName);
    if ((localr == null) || (!localr.bPk()))
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.pbd);
    if (!s.QG(this.fileName))
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Qf(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    paramh = new g();
    int j;
    if (localr.status == 8)
    {
      Log.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      this.endFlag = 0;
      s.QM(localr.fileName);
      j = 0;
    }
    int i;
    for (int k = 1;; k = 0)
    {
      int m = localr.peH;
      Log.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.QR(this.fileName);
        Log.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.xi(this.pbK);
          Log.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      if (!this.pds) {
        break label2033;
      }
      prepareDispatcher(paramg);
      if (!this.pdm) {
        break label2013;
      }
      this.orP.stopTimer();
      if (this.pdt) {
        break label1691;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 50L, 1L, false);
      Log.i("MicroMsg.NetSceneUploadVoice", "start voice cdn upload");
      paramg = new com.tencent.mm.g.g();
      paramg.field_fileType = 15;
      paramg.field_fullpath = s.getFullPath(this.fileName);
      paramg.field_mediaId = ("VoiceData" + this.fileName);
      paramg.field_totalLen = ((int)y.bEl(paramg.field_fullpath));
      if (com.tencent.mm.modelcdntran.b.b(paramg, this.pdy, localr) != null) {
        break;
      }
      AppMethodBeat.o(148418);
      return -1;
      if (localr.status == 3) {
        this.pdm = true;
      }
      Object localObject2 = s.QH(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        Log.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      Log.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      paramh = ((b)localObject2).eQ(localr.oZm, 6000);
      if (paramh == null)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 242L, 1L, false);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        Log.e("MicroMsg.NetSceneUploadVoice", "doScene: readRes is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      Log.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + paramh.ret + " readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + localr.oZm + " line:" + com.tencent.mm.compatible.util.f.getLine());
      if (paramh.ret < 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 241L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + paramh.ret + " readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + localr.oZm);
        s.Qf(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.pbK = paramh.pbK;
      if ((this.pbK < localr.oZm) || (this.pbK >= 469000))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 240L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.pbK + " OldtOff:" + localr.oZm);
        s.Qf(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.endFlag = 0;
      if ((paramh.hxg == 0) && (!this.pdm))
      {
        Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      if (this.pdm)
      {
        if (localr.osy <= 0)
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.osy);
          s.Qf(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if ((localr.osy > this.pbK) && (paramh.hxg < 6000))
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + localr.oZm + " totalLen:" + localr.osy);
          s.Qf(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if (localr.osy <= this.pbK)
        {
          localObject1 = (Integer)s.peO.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.peP.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).eQ(0, i);
            k = s.b(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).hxg);
            if (((Integer)localObject1).intValue() != k)
            {
              Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).hxg) });
              Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + localr.oZm + " totalLen:" + localr.osy);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 173L, 1L, false);
              s.peO.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.peQ.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.a(0, ((g)localObject2).buf, ((g)localObject2).hxg);
                if (((Integer)localObject1).intValue() != i)
                {
                  Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.Qf(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 174L, 1L, false);
                  AppMethodBeat.o(148418);
                  return -1;
                }
              }
            }
          }
          this.endFlag = 1;
        }
      }
    }
    this.pdt = true;
    AppMethodBeat.o(148418);
    return 0;
    label1691:
    if (this.pdu)
    {
      Log.i("MicroMsg.NetSceneUploadVoice", "start voice cgi");
      this.pbK = ((int)y.bEl(s.getFullPath(this.fileName)));
      this.endFlag = 1;
      paramh = new c.a();
      paramh.otE = new fui();
      paramh.otF = new fuj();
      paramh.uri = "/cgi-bin/micromsg-bin/uploadvoice";
      paramh.funcId = 127;
      paramh.otG = 19;
      paramh.respCmdId = 1000000019;
      this.rr = paramh.bEF();
      paramh = (fui)c.b.b(this.rr.otB);
      paramh.IMh = com.tencent.mm.model.z.bAM();
      paramh.IMg = localr.hVQ;
      paramh.YYs = localr.oZm;
      paramh.YHk = localr.clientId;
      paramh.YWB = i;
      paramh.oOu = this.endFlag;
      paramh.Njv = localr.hTh;
      paramh.Zsp = k;
      paramh.abSB = this.pdq;
      paramh.YFJ = bt.bCR();
      if (((v)com.tencent.mm.kernel.h.az(v.class)).ifAddTicketByActionFlag(localr.hVQ)) {
        paramh.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(localr.hVQ);
      }
      paramh.YFJ = a.a.aOb().al(localr.hVQ, localr.pbc);
      paramh.aaSO = j;
      paramh.aesKey = this.pdv;
      paramh.abSC = this.pdw;
      paramh.YYs = 0;
      paramh.YTh = this.pbK;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
    }
    AppMethodBeat.o(148418);
    return 0;
    label2013:
    this.orP.startTimer(500L, 500L);
    AppMethodBeat.o(148418);
    return 0;
    label2033:
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new fui();
    ((c.a)localObject1).otF = new fuj();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
    ((c.a)localObject1).funcId = 127;
    ((c.a)localObject1).otG = 19;
    ((c.a)localObject1).respCmdId = 1000000019;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (fui)c.b.b(this.rr.otB);
    ((fui)localObject1).IMh = com.tencent.mm.model.z.bAM();
    ((fui)localObject1).IMg = localr.hVQ;
    ((fui)localObject1).YYs = localr.oZm;
    ((fui)localObject1).YHk = localr.clientId;
    ((fui)localObject1).YWB = i;
    ((fui)localObject1).oOu = this.endFlag;
    ((fui)localObject1).Njv = localr.hTh;
    ((fui)localObject1).Zsp = k;
    ((fui)localObject1).abSB = this.pdq;
    ((fui)localObject1).YFJ = bt.bCR();
    if (((v)com.tencent.mm.kernel.h.az(v.class)).ifAddTicketByActionFlag(localr.hVQ)) {
      ((fui)localObject1).ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(localr.hVQ);
    }
    ((fui)localObject1).YFJ = a.a.aOb().al(localr.hVQ, localr.pbc);
    ((fui)localObject1).aaSO = j;
    if (k != 1) {
      ((fui)localObject1).NkQ = new gol().ah(paramh.buf, paramh.hxg);
    }
    for (((fui)localObject1).YTh = paramh.hxg;; ((fui)localObject1).YTh = 1)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.hTh);
      Log.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((fui)localObject1).Njv + " user:" + ((fui)localObject1).IMg + " offset:" + ((fui)localObject1).YYs + " dataLen:" + ((fui)localObject1).NkQ.abwJ + " endFlag:" + ((fui)localObject1).oOu);
      Log.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.hTh + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + paramh.hxg + " neTTTOff:" + localr.oZm + " neWWWOff:" + this.pbK + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.pdr = System.currentTimeMillis();
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
      ((fui)localObject1).NkQ = new gol().m(com.tencent.mm.bx.b.cX(new byte[1]));
    }
  }
  
  public final int getType()
  {
    return 127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148422);
    Log.i("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (fui)c.b.b(((com.tencent.mm.am.c)params).otB);
    params = (fuj)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.az(v.class)).setEnSendMsgActionFlag(params.ZaS);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.Qg(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.Qf(this.fileName);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 236L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + params.Njv + " toUser:" + paramArrayOfByte.IMg);
    if ((params.Njv <= 0L) && (!au.bwS(paramArrayOfByte.IMg)))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 235L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + params.Njv + " netoff:" + params.YYs);
      s.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(params.Njv), Integer.valueOf(com.tencent.mm.platformtools.z.pCn) });
    if ((10007 == com.tencent.mm.platformtools.z.pCm) && (com.tencent.mm.platformtools.z.pCn != 0))
    {
      params.Njv = com.tencent.mm.platformtools.z.pCn;
      com.tencent.mm.platformtools.z.pCn = 0;
    }
    paramInt1 = s.a(this.fileName, this.pbK, params.Njv, params.YHk, this.endFlag, this.pdq);
    Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + params.Njv + " clientId:" + params.YHk + " neWWOff:" + this.pbK + " neTTTT:" + params.YTh + " forwardflag:" + this.pdq);
    if (paramInt1 < 0)
    {
      s.Qf(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (paramInt1 == 1)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      params = s.QQ(this.fileName);
      params = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(params.pbc);
      com.tencent.mm.modelstat.b.oUZ.u(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (!this.pds) {
      if (!this.pdm) {
        break label882;
      }
    }
    label882:
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.orP.startTimer(l);
      AppMethodBeat.o(148422);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(148420);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(148420);
    return bool;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(148419);
    params = (fui)c.b.b(((com.tencent.mm.am.c)params).otB);
    if (!this.pds)
    {
      Log.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + params.Njv + " offset:" + params.YYs + " dataLen:" + params.NkQ.abwJ + " endFlag:" + params.oOu);
      if (((params.Njv == 0L) && (params.YYs != 0)) || (((params.NkQ == null) || (params.NkQ.abwJ == 0)) && (params.oOu != 1) && (params.Zsp != 1)))
      {
        params = p.b.oui;
        AppMethodBeat.o(148419);
        return params;
      }
    }
    params = p.b.ouh;
    AppMethodBeat.o(148419);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(148421);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 238L, 1L, false);
    s.Qf(this.fileName);
    AppMethodBeat.o(148421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */