package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends m
  implements k
{
  com.tencent.mm.ai.f callback;
  private int endFlag;
  private int fXX;
  private boolean fZu;
  private int fZy;
  long fZz;
  public String fileName;
  ap frx;
  public int retCode;
  private com.tencent.mm.ai.b rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(116578);
    this.retCode = 0;
    this.fXX = 0;
    this.fZu = false;
    this.endFlag = 0;
    this.frx = new ap(new f.1(this), true);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      ab.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.fZy = paramInt;
      AppMethodBeat.o(116578);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(116579);
    this.callback = paramf;
    this.fZu = false;
    if (this.fileName == null)
    {
      ab.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      AppMethodBeat.o(116579);
      return -1;
    }
    r localr = s.vT(this.fileName);
    if ((localr == null) || (!localr.amw()))
    {
      ab.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      AppMethodBeat.o(116579);
      return -1;
    }
    ab.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.fXz);
    if (!s.vJ(this.fileName))
    {
      ab.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.vk(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      AppMethodBeat.o(116579);
      return -1;
    }
    paramf = new g();
    int k;
    int j;
    int i;
    Object localObject1;
    if (localr.status == 8)
    {
      ab.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      k = 1;
      this.endFlag = 0;
      s.vP(localr.fileName);
      j = 0;
      int m = localr.gaD;
      ab.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.vU(this.fileName);
        ab.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.mq(this.fXX);
          ab.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new b.a();
      ((b.a)localObject1).fsX = new cpa();
      ((b.a)localObject1).fsY = new cpb();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((b.a)localObject1).funcId = 127;
      ((b.a)localObject1).reqCmdId = 19;
      ((b.a)localObject1).respCmdId = 1000000019;
      this.rr = ((b.a)localObject1).ado();
      localObject1 = (cpa)this.rr.fsV.fta;
      ((cpa)localObject1).num = com.tencent.mm.model.r.Zn();
      ((cpa)localObject1).nul = localr.cDt;
      ((cpa)localObject1).wzS = localr.fWa;
      ((cpa)localObject1).wpS = localr.clientId;
      ((cpa)localObject1).wAr = i;
      ((cpa)localObject1).fKi = this.endFlag;
      ((cpa)localObject1).pIG = localr.cFn;
      ((cpa)localObject1).wPU = k;
      ((cpa)localObject1).xXP = this.fZy;
      ((cpa)localObject1).woU = bh.aaR();
      ((cpa)localObject1).woU = a.a.Ky().F(localr.cDt, localr.fXy);
      ((cpa)localObject1).xrK = j;
      if (k == 1) {
        break label2022;
      }
      ((cpa)localObject1).pIA = new SKBuiltinBuffer_t().setBuffer(paramf.buf, 0, paramf.ckj);
    }
    for (((cpa)localObject1).wyT = paramf.ckj;; ((cpa)localObject1).wyT = 1)
    {
      ab.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.cFn);
      ab.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((cpa)localObject1).pIG + " user:" + ((cpa)localObject1).nul + " offset:" + ((cpa)localObject1).wzS + " dataLen:" + ((cpa)localObject1).pIA.getILen() + " endFlag:" + ((cpa)localObject1).fKi);
      ab.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.cFn + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + paramf.ckj + " neTTTOff:" + localr.fWa + " neWWWOff:" + this.fXX + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.fZz = System.currentTimeMillis();
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(116579);
      return i;
      if (localr.status == 3) {
        this.fZu = true;
      }
      Object localObject2 = s.vK(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        ab.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(116579);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      ab.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      paramf = ((b)localObject2).cJ(localr.fWa, 6000);
      ab.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + localr.fWa + " line:" + com.tencent.mm.compatible.util.g.getLine());
      if (paramf.ret < 0)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 241L, 1L, false);
        ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + localr.fWa);
        s.vk(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        AppMethodBeat.o(116579);
        return -1;
      }
      this.fXX = paramf.fXX;
      if ((this.fXX < localr.fWa) || (this.fXX >= 469000))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 240L, 1L, false);
        ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.fXX + " OldtOff:" + localr.fWa);
        s.vk(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        AppMethodBeat.o(116579);
        return -1;
      }
      this.endFlag = 0;
      if ((paramf.ckj == 0) && (!this.fZu))
      {
        ab.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        AppMethodBeat.o(116579);
        return -1;
      }
      if (this.fZu)
      {
        if (localr.fsd <= 0)
        {
          ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.fsd);
          s.vk(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          AppMethodBeat.o(116579);
          return -1;
        }
        if ((localr.fsd > this.fXX) && (paramf.ckj < 6000))
        {
          ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + localr.fWa + " totalLen:" + localr.fsd);
          s.vk(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          AppMethodBeat.o(116579);
          return -1;
        }
        if (localr.fsd <= this.fXX)
        {
          localObject1 = (Integer)s.gaI.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.gaJ.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).cJ(0, i);
            k = s.c(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).ckj);
            if (((Integer)localObject1).intValue() != k)
            {
              ab.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).ckj) });
              ab.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + localr.fWa + " totalLen:" + localr.fsd);
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 173L, 1L, false);
              s.gaI.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.gaK.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.b(0, ((g)localObject2).buf, ((g)localObject2).ckj);
                if (((Integer)localObject1).intValue() != i)
                {
                  ab.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.vk(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 174L, 1L, false);
                  AppMethodBeat.o(116579);
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
      label2022:
      ((cpa)localObject1).pIA = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bv.b.bL(new byte[1]));
    }
  }
  
  public final int getType()
  {
    return 127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116583);
    ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cpa)((com.tencent.mm.ai.b)paramq).fsV.fta;
    paramq = (cpb)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.vl(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116583);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.vk(this.fileName);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116583);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 236L, 1L, false);
      ab.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116583);
      return;
    }
    ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + paramq.pIG + " toUser:" + paramArrayOfByte.nul);
    if ((paramq.pIG <= 0L) && (!ad.nM(paramArrayOfByte.nul)))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 235L, 1L, false);
      ab.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + paramq.pIG + " netoff:" + paramq.wzS);
      s.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116583);
      return;
    }
    ab.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramq.pIG), Integer.valueOf(ae.gkL) });
    if ((10007 == ae.gkK) && (ae.gkL != 0))
    {
      paramq.pIG = ae.gkL;
      ae.gkL = 0;
    }
    paramInt1 = s.a(this.fileName, this.fXX, paramq.pIG, paramq.wpS, this.endFlag, this.fZy);
    ab.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.pIG + " clientId:" + paramq.wpS + " neWWOff:" + this.fXX + " neTTTT:" + paramq.wyT + " forwardflag:" + this.fZy);
    if (paramInt1 < 0)
    {
      s.vk(this.fileName);
      ab.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116583);
      return;
    }
    if (paramInt1 == 1)
    {
      ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      paramq = s.vT(this.fileName);
      paramq = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(paramq.fXy);
      com.tencent.mm.modelstat.b.fRu.j(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116583);
      return;
    }
    if (this.fZu) {}
    for (long l = 0L;; l = 500L)
    {
      ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.frx.ag(l, l);
      AppMethodBeat.o(116583);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(116581);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(116581);
    return bool;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(116580);
    paramq = (cpa)((com.tencent.mm.ai.b)paramq).fsV.fta;
    ab.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + paramq.pIG + " offset:" + paramq.wzS + " dataLen:" + paramq.pIA.getILen() + " endFlag:" + paramq.fKi);
    if (((paramq.pIG == 0L) && (paramq.wzS != 0)) || (((paramq.pIA == null) || (paramq.pIA.getILen() == 0)) && (paramq.fKi != 1) && (paramq.wPU != 1)))
    {
      paramq = m.b.ftv;
      AppMethodBeat.o(116580);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(116580);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(116582);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 238L, 1L, false);
    s.vk(this.fileName);
    AppMethodBeat.o(116582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */