package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  com.tencent.mm.ak.f callback;
  private int endFlag;
  public String fileName;
  aw hPc;
  private int ixC;
  private boolean iyX;
  private int izb;
  long izc;
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
    this.ixC = 0;
    this.iyX = false;
    this.endFlag = 0;
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148416);
        r localr = s.IC(f.this.fileName);
        if ((localr == null) || (!localr.aOa()))
        {
          ae.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.this.fileName);
          f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
          AppMethodBeat.o(148416);
          return false;
        }
        if ((3 != localr.status) && (8 != localr.status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localr.iwX > 30L)
          {
            ae.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fileName);
            f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
            AppMethodBeat.o(148416);
            return false;
          }
          if (l - f.this.izc < 2000L)
          {
            ae.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fileName + " but last send time:" + (l - f.this.izc));
            AppMethodBeat.o(148416);
            return true;
          }
          g localg = s.It(f.this.fileName).dr(localr.ivD, 6000);
          ae.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fileName + " readByte:" + localg.diR + " stat:" + localr.status);
          if (localg.diR < 2000)
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
      ae.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.izb = paramInt;
      AppMethodBeat.o(148417);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(148418);
    this.callback = paramf;
    this.iyX = false;
    if (this.fileName == null)
    {
      ae.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    r localr = s.IC(this.fileName);
    if ((localr == null) || (!localr.aOa()))
    {
      ae.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    ae.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.ixa);
    if (!s.Is(this.fileName))
    {
      ae.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.HR(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    paramf = new g();
    int j;
    int k;
    int i;
    Object localObject1;
    if (localr.status == 8)
    {
      ae.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      this.endFlag = 0;
      s.Iy(localr.fileName);
      j = 0;
      k = 1;
      int m = localr.iAf;
      ae.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.ID(this.fileName);
        ae.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.qt(this.ixC);
          ae.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new b.a();
      ((b.a)localObject1).hQF = new duj();
      ((b.a)localObject1).hQG = new duk();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((b.a)localObject1).funcId = 127;
      ((b.a)localObject1).hQH = 19;
      ((b.a)localObject1).respCmdId = 1000000019;
      this.rr = ((b.a)localObject1).aDS();
      localObject1 = (duj)this.rr.hQD.hQJ;
      ((duj)localObject1).uvG = v.aAC();
      ((duj)localObject1).uvF = localr.dED;
      ((duj)localObject1).GeT = localr.ivD;
      ((duj)localObject1).FOR = localr.clientId;
      ((duj)localObject1).Gdb = i;
      ((duj)localObject1).ijY = this.endFlag;
      ((duj)localObject1).xrk = localr.dCd;
      ((duj)localObject1).GvZ = k;
      ((duj)localObject1).HZZ = this.izb;
      ((duj)localObject1).FNL = bn.aCy();
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(localr.dED)) {
        ((duj)localObject1).Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(localr.dED);
      }
      ((duj)localObject1).FNL = a.a.ZP().J(localr.dED, localr.iwZ);
      ((duj)localObject1).HlN = j;
      if (k == 1) {
        break label2073;
      }
      ((duj)localObject1).xsE = new SKBuiltinBuffer_t().setBuffer(paramf.buf, 0, paramf.diR);
    }
    for (((duj)localObject1).GaC = paramf.diR;; ((duj)localObject1).GaC = 1)
    {
      ae.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.dCd);
      ae.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((duj)localObject1).xrk + " user:" + ((duj)localObject1).uvF + " offset:" + ((duj)localObject1).GeT + " dataLen:" + ((duj)localObject1).xsE.getILen() + " endFlag:" + ((duj)localObject1).ijY);
      ae.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.dCd + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + paramf.diR + " neTTTOff:" + localr.ivD + " neWWWOff:" + this.ixC + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.izc = System.currentTimeMillis();
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
      if (localr.status == 3) {
        this.iyX = true;
      }
      Object localObject2 = s.It(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        ae.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      ae.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      paramf = ((b)localObject2).dr(localr.ivD, 6000);
      ae.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + localr.ivD + " line:" + com.tencent.mm.compatible.util.f.getLine());
      if (paramf.ret < 0)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 241L, 1L, false);
        ae.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + localr.ivD);
        s.HR(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.ixC = paramf.ixC;
      if ((this.ixC < localr.ivD) || (this.ixC >= 469000))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 240L, 1L, false);
        ae.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.ixC + " OldtOff:" + localr.ivD);
        s.HR(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.endFlag = 0;
      if ((paramf.diR == 0) && (!this.iyX))
      {
        ae.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      if (this.iyX)
      {
        if (localr.hPI <= 0)
        {
          ae.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.hPI);
          s.HR(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if ((localr.hPI > this.ixC) && (paramf.diR < 6000))
        {
          ae.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + localr.ivD + " totalLen:" + localr.hPI);
          s.HR(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if (localr.hPI <= this.ixC)
        {
          localObject1 = (Integer)s.iAk.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.iAl.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).dr(0, i);
            k = s.c(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).diR);
            if (((Integer)localObject1).intValue() != k)
            {
              ae.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).diR) });
              ae.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + localr.ivD + " totalLen:" + localr.hPI);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 173L, 1L, false);
              s.iAk.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.iAm.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.b(0, ((g)localObject2).buf, ((g)localObject2).diR);
                if (((Integer)localObject1).intValue() != i)
                {
                  ae.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.HR(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 174L, 1L, false);
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
      ((duj)localObject1).xsE = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cm(new byte[1]));
    }
  }
  
  public final int getType()
  {
    return 127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148422);
    ae.i("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (duj)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    paramq = (duk)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramq.Ghl);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.HS(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.HR(this.fileName);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 236L, 1L, false);
      ae.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ae.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + paramq.xrk + " toUser:" + paramArrayOfByte.uvF);
    if ((paramq.xrk <= 0L) && (!an.Ac(paramArrayOfByte.uvF)))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 235L, 1L, false);
      ae.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + paramq.xrk + " netoff:" + paramq.GeT);
      s.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ae.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramq.xrk), Integer.valueOf(ac.iRI) });
    if ((10007 == ac.iRH) && (ac.iRI != 0))
    {
      paramq.xrk = ac.iRI;
      ac.iRI = 0;
    }
    paramInt1 = s.a(this.fileName, this.ixC, paramq.xrk, paramq.FOR, this.endFlag, this.izb);
    ae.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.xrk + " clientId:" + paramq.FOR + " neWWOff:" + this.ixC + " neTTTT:" + paramq.GaC + " forwardflag:" + this.izb);
    if (paramInt1 < 0)
    {
      s.HR(this.fileName);
      ae.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (paramInt1 == 1)
    {
      ae.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      paramq = s.IC(this.fileName);
      paramq = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramq.iwZ);
      com.tencent.mm.modelstat.b.iqT.q(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (this.iyX) {}
    for (long l = 0L;; l = 500L)
    {
      ae.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.hPc.ay(l, l);
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
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(148420);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(148419);
    paramq = (duj)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    ae.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + paramq.xrk + " offset:" + paramq.GeT + " dataLen:" + paramq.xsE.getILen() + " endFlag:" + paramq.ijY);
    if (((paramq.xrk == 0L) && (paramq.GeT != 0)) || (((paramq.xsE == null) || (paramq.xsE.getILen() == 0)) && (paramq.ijY != 1) && (paramq.GvZ != 1)))
    {
      paramq = n.b.hRj;
      AppMethodBeat.o(148419);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(148419);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148421);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 238L, 1L, false);
    s.HR(this.fileName);
    AppMethodBeat.o(148421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */