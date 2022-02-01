package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ak.g callback;
  private int endFlag;
  public String fileName;
  au htR;
  private int ibm;
  private boolean icI;
  private int icM;
  long icN;
  public int retCode;
  private com.tencent.mm.ak.b rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(148417);
    this.retCode = 0;
    this.ibm = 0;
    this.icI = false;
    this.endFlag = 0;
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148416);
        r localr = s.EL(f.this.fileName);
        if ((localr == null) || (!localr.aKt()))
        {
          ac.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.this.fileName);
          f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
          AppMethodBeat.o(148416);
          return false;
        }
        if ((3 != localr.status) && (8 != localr.status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localr.iaH > 30L)
          {
            ac.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fileName);
            f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
            AppMethodBeat.o(148416);
            return false;
          }
          if (l - f.this.icN < 2000L)
          {
            ac.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fileName + " but last send time:" + (l - f.this.icN));
            AppMethodBeat.o(148416);
            return true;
          }
          g localg = s.EC(f.this.fileName).dp(localr.hZn, 6000);
          ac.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fileName + " readByte:" + localg.cWy + " stat:" + localr.status);
          if (localg.cWy < 2000)
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
      ac.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.icM = paramInt;
      AppMethodBeat.o(148417);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(148418);
    this.callback = paramg;
    this.icI = false;
    if (this.fileName == null)
    {
      ac.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    r localr = s.EL(this.fileName);
    if ((localr == null) || (!localr.aKt()))
    {
      ac.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    ac.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.iaK);
    if (!s.EB(this.fileName))
    {
      ac.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Ea(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    paramg = new g();
    int j;
    int k;
    int i;
    Object localObject1;
    if (localr.status == 8)
    {
      ac.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      this.endFlag = 0;
      s.EH(localr.fileName);
      j = 0;
      k = 1;
      int m = localr.idR;
      ac.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.EM(this.fileName);
        ac.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.pO(this.ibm);
          ac.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new b.a();
      ((b.a)localObject1).hvt = new dnv();
      ((b.a)localObject1).hvu = new dnw();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((b.a)localObject1).funcId = 127;
      ((b.a)localObject1).reqCmdId = 19;
      ((b.a)localObject1).respCmdId = 1000000019;
      this.rr = ((b.a)localObject1).aAz();
      localObject1 = (dnv)this.rr.hvr.hvw;
      ((dnv)localObject1).tlK = u.axw();
      ((dnv)localObject1).tlJ = localr.drG;
      ((dnv)localObject1).EfV = localr.hZn;
      ((dnv)localObject1).DRb = localr.clientId;
      ((dnv)localObject1).Eed = i;
      ((dnv)localObject1).hNR = this.endFlag;
      ((dnv)localObject1).vTQ = localr.dpl;
      ((dnv)localObject1).EvW = k;
      ((dnv)localObject1).FVy = this.icM;
      ((dnv)localObject1).DPY = bk.aze();
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localr.drG)) {
        ((dnv)localObject1).EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(localr.drG);
      }
      ((dnv)localObject1).DPY = a.a.Xf().F(localr.drG, localr.iaJ);
      ((dnv)localObject1).FiL = j;
      if (k == 1) {
        break label2073;
      }
      ((dnv)localObject1).vTK = new SKBuiltinBuffer_t().setBuffer(paramg.buf, 0, paramg.cWy);
    }
    for (((dnv)localObject1).Eck = paramg.cWy;; ((dnv)localObject1).Eck = 1)
    {
      ac.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.dpl);
      ac.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((dnv)localObject1).vTQ + " user:" + ((dnv)localObject1).tlJ + " offset:" + ((dnv)localObject1).EfV + " dataLen:" + ((dnv)localObject1).vTK.getILen() + " endFlag:" + ((dnv)localObject1).hNR);
      ac.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.dpl + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + paramg.cWy + " neTTTOff:" + localr.hZn + " neWWWOff:" + this.ibm + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.icN = System.currentTimeMillis();
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
      if (localr.status == 3) {
        this.icI = true;
      }
      Object localObject2 = s.EC(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        ac.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      ac.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      paramg = ((b)localObject2).dp(localr.hZn, 6000);
      ac.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + localr.hZn + " line:" + com.tencent.mm.compatible.util.f.getLine());
      if (paramg.ret < 0)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 241L, 1L, false);
        ac.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + localr.hZn);
        s.Ea(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.ibm = paramg.ibm;
      if ((this.ibm < localr.hZn) || (this.ibm >= 469000))
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 240L, 1L, false);
        ac.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.ibm + " OldtOff:" + localr.hZn);
        s.Ea(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.endFlag = 0;
      if ((paramg.cWy == 0) && (!this.icI))
      {
        ac.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      if (this.icI)
      {
        if (localr.hux <= 0)
        {
          ac.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.hux);
          s.Ea(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if ((localr.hux > this.ibm) && (paramg.cWy < 6000))
        {
          ac.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + localr.hZn + " totalLen:" + localr.hux);
          s.Ea(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if (localr.hux <= this.ibm)
        {
          localObject1 = (Integer)s.idW.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.idX.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).dp(0, i);
            k = s.c(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).cWy);
            if (((Integer)localObject1).intValue() != k)
            {
              ac.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).cWy) });
              ac.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + localr.hZn + " totalLen:" + localr.hux);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 173L, 1L, false);
              s.idW.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.idY.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.b(0, ((g)localObject2).buf, ((g)localObject2).cWy);
                if (((Integer)localObject1).intValue() != i)
                {
                  ac.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.Ea(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 174L, 1L, false);
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
      ((dnv)localObject1).vTK = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cc(new byte[1]));
    }
  }
  
  public final int getType()
  {
    return 127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148422);
    ac.i("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dnv)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    paramq = (dnw)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.EhF);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.Eb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.Ea(this.fileName);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 236L, 1L, false);
      ac.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ac.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + paramq.vTQ + " toUser:" + paramArrayOfByte.tlJ);
    if ((paramq.vTQ <= 0L) && (!ai.ww(paramArrayOfByte.tlJ)))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 235L, 1L, false);
      ac.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + paramq.vTQ + " netoff:" + paramq.EfV);
      s.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ac.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramq.vTQ), Integer.valueOf(ab.ivH) });
    if ((10007 == ab.ivG) && (ab.ivH != 0))
    {
      paramq.vTQ = ab.ivH;
      ab.ivH = 0;
    }
    paramInt1 = s.a(this.fileName, this.ibm, paramq.vTQ, paramq.DRb, this.endFlag, this.icM);
    ac.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.vTQ + " clientId:" + paramq.DRb + " neWWOff:" + this.ibm + " neTTTT:" + paramq.Eck + " forwardflag:" + this.icM);
    if (paramInt1 < 0)
    {
      s.Ea(this.fileName);
      ac.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (paramInt1 == 1)
    {
      ac.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      paramq = s.EL(this.fileName);
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramq.iaJ);
      com.tencent.mm.modelstat.b.hUE.q(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (this.icI) {}
    for (long l = 0L;; l = 500L)
    {
      ac.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.htR.au(l, l);
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
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(148420);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(148419);
    paramq = (dnv)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    ac.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + paramq.vTQ + " offset:" + paramq.EfV + " dataLen:" + paramq.vTK.getILen() + " endFlag:" + paramq.hNR);
    if (((paramq.vTQ == 0L) && (paramq.EfV != 0)) || (((paramq.vTK == null) || (paramq.vTK.getILen() == 0)) && (paramq.hNR != 1) && (paramq.EvW != 1)))
    {
      paramq = n.b.hwb;
      AppMethodBeat.o(148419);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(148419);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148421);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 238L, 1L, false);
    s.Ea(this.fileName);
    AppMethodBeat.o(148421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */