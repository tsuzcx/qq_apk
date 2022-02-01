package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.eoi;
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
  com.tencent.mm.ak.i callback;
  private int endFlag;
  public String fileName;
  MTimerHandler iKj;
  private int jsR;
  private boolean jul;
  private int jup;
  long juq;
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
    this.jsR = 0;
    this.jul = false;
    this.endFlag = 0;
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148416);
        r localr = s.Ro(f.this.fileName);
        if ((localr == null) || (!localr.big()))
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.this.fileName);
          f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
          AppMethodBeat.o(148416);
          return false;
        }
        if ((3 != localr.status) && (8 != localr.status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localr.jsm > 30L)
          {
            Log.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fileName);
            f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
            AppMethodBeat.o(148416);
            return false;
          }
          if (l - f.this.juq < 2000L)
          {
            Log.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fileName + " but last send time:" + (l - f.this.juq));
            AppMethodBeat.o(148416);
            return true;
          }
          g localg = s.Rf(f.this.fileName).dB(localr.jqP, 6000);
          Log.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fileName + " readByte:" + localg.dAc + " stat:" + localr.status);
          if (localg.dAc < 2000)
          {
            AppMethodBeat.o(148416);
            return true;
          }
        }
        if (f.this.doScene(f.this.dispatcher(), f.this.callback) == -1)
        {
          f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
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
      this.jup = paramInt;
      AppMethodBeat.o(148417);
      return;
      bool = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(148418);
    this.callback = parami;
    this.jul = false;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    r localr = s.Ro(this.fileName);
    if ((localr == null) || (!localr.big()))
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.jsp);
    if (!s.Re(this.fileName))
    {
      Log.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.QE(this.fileName);
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
      s.Rk(localr.fileName);
      j = 0;
      k = 1;
      int m = localr.jvt;
      Log.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.Rp(this.fileName);
        Log.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.ui(this.jsR);
          Log.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new d.a();
      ((d.a)localObject1).iLN = new eoh();
      ((d.a)localObject1).iLO = new eoi();
      ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((d.a)localObject1).funcId = 127;
      ((d.a)localObject1).iLP = 19;
      ((d.a)localObject1).respCmdId = 1000000019;
      this.rr = ((d.a)localObject1).aXF();
      localObject1 = (eoh)this.rr.iLK.iLR;
      ((eoh)localObject1).xNH = z.aTY();
      ((eoh)localObject1).xNG = localr.dWq;
      ((eoh)localObject1).KZk = localr.jqP;
      ((eoh)localObject1).KIz = localr.clientId;
      ((eoh)localObject1).KXq = i;
      ((eoh)localObject1).jeU = this.endFlag;
      ((eoh)localObject1).Brn = localr.dTS;
      ((eoh)localObject1).LrF = k;
      ((eoh)localObject1).Nmg = this.jup;
      ((eoh)localObject1).KHq = br.aVW();
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(localr.dWq)) {
        ((eoh)localObject1).LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(localr.dWq);
      }
      ((eoh)localObject1).KHq = a.a.anC().K(localr.dWq, localr.jso);
      ((eoh)localObject1).Msa = j;
      if (k == 1) {
        break label2073;
      }
      ((eoh)localObject1).BsI = new SKBuiltinBuffer_t().setBuffer(parami.buf, 0, parami.dAc);
    }
    for (((eoh)localObject1).KUy = parami.dAc;; ((eoh)localObject1).KUy = 1)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.dTS);
      Log.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((eoh)localObject1).Brn + " user:" + ((eoh)localObject1).xNG + " offset:" + ((eoh)localObject1).KZk + " dataLen:" + ((eoh)localObject1).BsI.getILen() + " endFlag:" + ((eoh)localObject1).jeU);
      Log.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.dTS + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + parami.dAc + " neTTTOff:" + localr.jqP + " neWWWOff:" + this.jsR + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.juq = System.currentTimeMillis();
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
      if (localr.status == 3) {
        this.jul = true;
      }
      Object localObject2 = s.Rf(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        Log.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      Log.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      parami = ((b)localObject2).dB(localr.jqP, 6000);
      Log.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + localr.jqP + " line:" + com.tencent.mm.compatible.util.f.getLine());
      if (parami.ret < 0)
      {
        h.CyF.idkeyStat(111L, 241L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + localr.jqP);
        s.QE(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.jsR = parami.jsR;
      if ((this.jsR < localr.jqP) || (this.jsR >= 469000))
      {
        h.CyF.idkeyStat(111L, 240L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.jsR + " OldtOff:" + localr.jqP);
        s.QE(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.endFlag = 0;
      if ((parami.dAc == 0) && (!this.jul))
      {
        Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      if (this.jul)
      {
        if (localr.iKP <= 0)
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.iKP);
          s.QE(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if ((localr.iKP > this.jsR) && (parami.dAc < 6000))
        {
          Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + localr.jqP + " totalLen:" + localr.iKP);
          s.QE(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if (localr.iKP <= this.jsR)
        {
          localObject1 = (Integer)s.jvz.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.jvA.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).dB(0, i);
            k = s.c(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).dAc);
            if (((Integer)localObject1).intValue() != k)
            {
              Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).dAc) });
              Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + localr.jqP + " totalLen:" + localr.iKP);
              h.CyF.idkeyStat(111L, 173L, 1L, false);
              s.jvz.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.jvB.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.b(0, ((g)localObject2).buf, ((g)localObject2).dAc);
                if (((Integer)localObject1).intValue() != i)
                {
                  Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.QE(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
                  h.CyF.idkeyStat(111L, 174L, 1L, false);
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
      label2073:
      ((eoh)localObject1).BsI = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cD(new byte[1]));
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
    paramArrayOfByte = (eoh)((d)params).iLK.iLR;
    params = (eoi)((d)params).iLL.iLR;
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(params.LbO);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.QF(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.QE(this.fileName);
      h.CyF.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.CyF.idkeyStat(111L, 236L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + params.Brn + " toUser:" + paramArrayOfByte.xNG);
    if ((params.Brn <= 0L) && (!as.IG(paramArrayOfByte.xNG)))
    {
      h.CyF.idkeyStat(111L, 235L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + params.Brn + " netoff:" + params.KZk);
      s.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(params.Brn), Integer.valueOf(ac.jOD) });
    if ((10007 == ac.jOC) && (ac.jOD != 0))
    {
      params.Brn = ac.jOD;
      ac.jOD = 0;
    }
    paramInt1 = s.a(this.fileName, this.jsR, params.Brn, params.KIz, this.endFlag, this.jup);
    Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + params.Brn + " clientId:" + params.KIz + " neWWOff:" + this.jsR + " neTTTT:" + params.KUy + " forwardflag:" + this.jup);
    if (paramInt1 < 0)
    {
      s.QE(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (paramInt1 == 1)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      params = s.Ro(this.fileName);
      params = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(params.jso);
      com.tencent.mm.modelstat.b.jmd.s(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (this.jul) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.iKj.startTimer(l);
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
      h.CyF.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(148420);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(148419);
    params = (eoh)((d)params).iLK.iLR;
    Log.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + params.Brn + " offset:" + params.KZk + " dataLen:" + params.BsI.getILen() + " endFlag:" + params.jeU);
    if (((params.Brn == 0L) && (params.KZk != 0)) || (((params.BsI == null) || (params.BsI.getILen() == 0)) && (params.jeU != 1) && (params.LrF != 1)))
    {
      params = q.b.iMr;
      AppMethodBeat.o(148419);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(148419);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148421);
    h.CyF.idkeyStat(111L, 238L, 1L, false);
    s.QE(this.fileName);
    AppMethodBeat.o(148421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */