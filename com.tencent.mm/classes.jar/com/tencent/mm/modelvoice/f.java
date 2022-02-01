package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eyp;
import com.tencent.mm.protocal.protobuf.eyq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private int endFlag;
  public String fileName;
  MTimerHandler lAo;
  private int miv;
  private boolean mjP;
  private int mjT;
  private long mjU;
  public int retCode;
  private d rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(148417);
    this.retCode = 0;
    this.miv = 0;
    this.mjP = false;
    this.endFlag = 0;
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148416);
        r localr = s.YL(f.a(f.this));
        if ((localr == null) || (!localr.brE()))
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.a(f.this));
          f.a(f.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.b(f.this).onSceneEnd(3, -1, "doScene failed", f.this);
          AppMethodBeat.o(148416);
          return false;
        }
        if ((3 != localr.status) && (8 != localr.status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localr.mhP > 30L)
          {
            Log.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.a(f.this));
            f.a(f.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
            f.b(f.this).onSceneEnd(3, -1, "doScene failed", f.this);
            AppMethodBeat.o(148416);
            return false;
          }
          if (l - f.c(f.this) < 2000L)
          {
            Log.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.a(f.this) + " but last send time:" + (l - f.c(f.this)));
            AppMethodBeat.o(148416);
            return true;
          }
          g localg = s.YC(f.a(f.this)).dY(localr.mgq, 6000);
          Log.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.a(f.this) + " readByte:" + localg.fsR + " stat:" + localr.status);
          if (localg.fsR < 2000)
          {
            AppMethodBeat.o(148416);
            return true;
          }
        }
        if (f.this.doScene(f.d(f.this), f.b(f.this)) == -1)
        {
          f.a(f.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.b(f.this).onSceneEnd(3, -1, "doScene failed", f.this);
        }
        AppMethodBeat.o(148416);
        return false;
      }
    }, true);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      Log.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.mjT = paramInt;
      AppMethodBeat.o(148417);
      return;
      bool = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(148418);
    this.callback = parami;
    this.mjP = false;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    r localr = s.YL(this.fileName);
    if ((localr == null) || (!localr.brE()))
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.mhS);
    if (!s.YB(this.fileName))
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Yb(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    parami = new g();
    int j;
    int k;
    int i;
    Object localObject1;
    if (localr.status == 8)
    {
      Log.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      this.endFlag = 0;
      s.YH(localr.fileName);
      j = 0;
      k = 1;
      int m = localr.mkW;
      Log.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.YM(this.fileName);
        Log.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.xi(this.miv);
          Log.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new d.a();
      ((d.a)localObject1).lBU = new eyp();
      ((d.a)localObject1).lBV = new eyq();
      ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((d.a)localObject1).funcId = 127;
      ((d.a)localObject1).lBW = 19;
      ((d.a)localObject1).respCmdId = 1000000019;
      this.rr = ((d.a)localObject1).bgN();
      localObject1 = (eyp)d.b.b(this.rr.lBR);
      ((eyp)localObject1).CRR = z.bcZ();
      ((eyp)localObject1).CRQ = localr.fPV;
      ((eyp)localObject1).Sat = localr.mgq;
      ((eyp)localObject1).RJQ = localr.clientId;
      ((eyp)localObject1).RYC = i;
      ((eyp)localObject1).lVs = this.endFlag;
      ((eyp)localObject1).HlH = localr.fNu;
      ((eyp)localObject1).Stc = k;
      ((eyp)localObject1).UyS = this.mjT;
      ((eyp)localObject1).RII = bs.beZ();
      if (((v)com.tencent.mm.kernel.h.ag(v.class)).ifAddTicketByActionFlag(localr.fPV)) {
        ((eyp)localObject1).ScZ = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bws(localr.fPV);
      }
      ((eyp)localObject1).RII = a.a.atD().ac(localr.fPV, localr.mhR);
      ((eyp)localObject1).TDg = j;
      if (k == 1) {
        break label2072;
      }
      ((eyp)localObject1).Hnc = new eae().ag(parami.buf, parami.fsR);
    }
    for (((eyp)localObject1).RVD = parami.fsR;; ((eyp)localObject1).RVD = 1)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.fNu);
      Log.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((eyp)localObject1).HlH + " user:" + ((eyp)localObject1).CRQ + " offset:" + ((eyp)localObject1).Sat + " dataLen:" + ((eyp)localObject1).Hnc.Ufv + " endFlag:" + ((eyp)localObject1).lVs);
      Log.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.fNu + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + parami.fsR + " neTTTOff:" + localr.mgq + " neWWWOff:" + this.miv + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.mjU = System.currentTimeMillis();
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
      if (localr.status == 3) {
        this.mjP = true;
      }
      Object localObject2 = s.YC(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        Log.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      Log.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      parami = ((b)localObject2).dY(localr.mgq, 6000);
      Log.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + localr.mgq + " line:" + com.tencent.mm.compatible.util.f.getLine());
      if (parami.ret < 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 241L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + localr.mgq);
        s.Yb(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.miv = parami.miv;
      if ((this.miv < localr.mgq) || (this.miv >= 469000))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 240L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.miv + " OldtOff:" + localr.mgq);
        s.Yb(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.endFlag = 0;
      if ((parami.fsR == 0) && (!this.mjP))
      {
        Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      if (this.mjP)
      {
        if (localr.lAW <= 0)
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.lAW);
          s.Yb(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if ((localr.lAW > this.miv) && (parami.fsR < 6000))
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + localr.mgq + " totalLen:" + localr.lAW);
          s.Yb(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if (localr.lAW <= this.miv)
        {
          localObject1 = (Integer)s.mlc.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.mld.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).dY(0, i);
            k = s.c(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).fsR);
            if (((Integer)localObject1).intValue() != k)
            {
              Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).fsR) });
              Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + localr.mgq + " totalLen:" + localr.lAW);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 173L, 1L, false);
              s.mlc.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.mle.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.b(0, ((g)localObject2).buf, ((g)localObject2).fsR);
                if (((Integer)localObject1).intValue() != i)
                {
                  Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.Yb(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 174L, 1L, false);
                  AppMethodBeat.o(148418);
                  return -1;
                }
              }
            }
          }
          this.endFlag = 1;
        }
      }
      k = 0;
      break;
      label2072:
      ((eyp)localObject1).Hnc = new eae().g(com.tencent.mm.cd.b.cU(new byte[1]));
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
    paramArrayOfByte = (eyp)d.b.b(((d)params).lBR);
    params = (eyq)d.c.b(((d)params).lBS);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.ag(v.class)).setEnSendMsgActionFlag(params.Sda);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.Yc(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.Yb(this.fileName);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 236L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + params.HlH + " toUser:" + paramArrayOfByte.CRQ);
    if ((params.HlH <= 0L) && (!as.PY(paramArrayOfByte.CRQ)))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 235L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + params.HlH + " netoff:" + params.Sat);
      s.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(params.HlH), Integer.valueOf(ac.mFN) });
    if ((10007 == ac.mFM) && (ac.mFN != 0))
    {
      params.HlH = ac.mFN;
      ac.mFN = 0;
    }
    paramInt1 = s.a(this.fileName, this.miv, params.HlH, params.RJQ, this.endFlag, this.mjT);
    Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + params.HlH + " clientId:" + params.RJQ + " neWWOff:" + this.miv + " neTTTT:" + params.RVD + " forwardflag:" + this.mjT);
    if (paramInt1 < 0)
    {
      s.Yb(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (paramInt1 == 1)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      params = s.YL(this.fileName);
      params = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(params.mhR);
      com.tencent.mm.modelstat.b.mcf.u(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (this.mjP) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.lAo.startTimer(l);
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
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(148420);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(148419);
    params = (eyp)d.b.b(((d)params).lBR);
    Log.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + params.HlH + " offset:" + params.Sat + " dataLen:" + params.Hnc.Ufv + " endFlag:" + params.lVs);
    if (((params.HlH == 0L) && (params.Sat != 0)) || (((params.Hnc == null) || (params.Hnc.Ufv == 0)) && (params.lVs != 1) && (params.Stc != 1)))
    {
      params = q.b.lCy;
      AppMethodBeat.o(148419);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(148419);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148421);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 238L, 1L, false);
    s.Yb(this.fileName);
    AppMethodBeat.o(148421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */