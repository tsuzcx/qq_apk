package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dtm;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  com.tencent.mm.al.f callback;
  private int endFlag;
  public String fileName;
  av hMj;
  private int iuI;
  private boolean iwe;
  private int iwi;
  long iwj;
  public int retCode;
  private com.tencent.mm.al.b rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(148417);
    this.retCode = 0;
    this.iuI = 0;
    this.iwe = false;
    this.endFlag = 0;
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148416);
        r localr = s.Ia(f.this.fileName);
        if ((localr == null) || (!localr.aNC()))
        {
          ad.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.this.fileName);
          f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
          AppMethodBeat.o(148416);
          return false;
        }
        if ((3 != localr.status) && (8 != localr.status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localr.iud > 30L)
          {
            ad.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fileName);
            f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
            AppMethodBeat.o(148416);
            return false;
          }
          if (l - f.this.iwj < 2000L)
          {
            ad.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fileName + " but last send time:" + (l - f.this.iwj));
            AppMethodBeat.o(148416);
            return true;
          }
          g localg = s.HR(f.this.fileName).dr(localr.isJ, 6000);
          ad.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fileName + " readByte:" + localg.dhO + " stat:" + localr.status);
          if (localg.dhO < 2000)
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
      ad.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.iwi = paramInt;
      AppMethodBeat.o(148417);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(148418);
    this.callback = paramf;
    this.iwe = false;
    if (this.fileName == null)
    {
      ad.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    r localr = s.Ia(this.fileName);
    if ((localr == null) || (!localr.aNC()))
    {
      ad.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    ad.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.iug);
    if (!s.HQ(this.fileName))
    {
      ad.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Hp(this.fileName);
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
      ad.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      this.endFlag = 0;
      s.HW(localr.fileName);
      j = 0;
      k = 1;
      int m = localr.ixm;
      ad.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.Ib(this.fileName);
        ad.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.qq(this.iuI);
          ad.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new b.a();
      ((b.a)localObject1).hNM = new dtm();
      ((b.a)localObject1).hNN = new dtn();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((b.a)localObject1).funcId = 127;
      ((b.a)localObject1).hNO = 19;
      ((b.a)localObject1).respCmdId = 1000000019;
      this.rr = ((b.a)localObject1).aDC();
      localObject1 = (dtm)this.rr.hNK.hNQ;
      ((dtm)localObject1).ukj = u.aAm();
      ((dtm)localObject1).uki = localr.dDy;
      ((dtm)localObject1).FMu = localr.isJ;
      ((dtm)localObject1).Fwt = localr.clientId;
      ((dtm)localObject1).FKC = i;
      ((dtm)localObject1).ihf = this.endFlag;
      ((dtm)localObject1).xbt = localr.dAY;
      ((dtm)localObject1).Gds = k;
      ((dtm)localObject1).HGm = this.iwi;
      ((dtm)localObject1).Fvn = bl.aCi();
      if (((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).ifAddTicketByActionFlag(localr.dDy)) {
        ((dtm)localObject1).FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(localr.dDy);
      }
      ((dtm)localObject1).Fvn = a.a.ZG().I(localr.dDy, localr.iuf);
      ((dtm)localObject1).GSm = j;
      if (k == 1) {
        break label2073;
      }
      ((dtm)localObject1).xcN = new SKBuiltinBuffer_t().setBuffer(paramf.buf, 0, paramf.dhO);
    }
    for (((dtm)localObject1).FIg = paramf.dhO;; ((dtm)localObject1).FIg = 1)
    {
      ad.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.dAY);
      ad.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((dtm)localObject1).xbt + " user:" + ((dtm)localObject1).uki + " offset:" + ((dtm)localObject1).FMu + " dataLen:" + ((dtm)localObject1).xcN.getILen() + " endFlag:" + ((dtm)localObject1).ihf);
      ad.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.dAY + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + paramf.dhO + " neTTTOff:" + localr.isJ + " neWWWOff:" + this.iuI + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.iwj = System.currentTimeMillis();
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
      if (localr.status == 3) {
        this.iwe = true;
      }
      Object localObject2 = s.HR(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        ad.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      ad.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      paramf = ((b)localObject2).dr(localr.isJ, 6000);
      ad.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.dhO + " newOff:" + paramf.iuI + " netOff:" + localr.isJ + " line:" + com.tencent.mm.compatible.util.f.getLine());
      if (paramf.ret < 0)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 241L, 1L, false);
        ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.dhO + " newOff:" + paramf.iuI + " netOff:" + localr.isJ);
        s.Hp(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.iuI = paramf.iuI;
      if ((this.iuI < localr.isJ) || (this.iuI >= 469000))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 240L, 1L, false);
        ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.iuI + " OldtOff:" + localr.isJ);
        s.Hp(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.endFlag = 0;
      if ((paramf.dhO == 0) && (!this.iwe))
      {
        ad.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      if (this.iwe)
      {
        if (localr.hMP <= 0)
        {
          ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.hMP);
          s.Hp(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if ((localr.hMP > this.iuI) && (paramf.dhO < 6000))
        {
          ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.dhO + " newOff:" + paramf.iuI + " netOff:" + localr.isJ + " totalLen:" + localr.hMP);
          s.Hp(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if (localr.hMP <= this.iuI)
        {
          localObject1 = (Integer)s.ixr.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.ixs.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).dr(0, i);
            k = s.c(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).dhO);
            if (((Integer)localObject1).intValue() != k)
            {
              ad.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).dhO) });
              ad.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + paramf.dhO + " newOff:" + paramf.iuI + " netOff:" + localr.isJ + " totalLen:" + localr.hMP);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 173L, 1L, false);
              s.ixr.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.ixt.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.b(0, ((g)localObject2).buf, ((g)localObject2).dhO);
                if (((Integer)localObject1).intValue() != i)
                {
                  ad.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.Hp(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 174L, 1L, false);
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
      ((dtm)localObject1).xcN = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bx.b.cj(new byte[1]));
    }
  }
  
  public final int getType()
  {
    return 127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148422);
    ad.i("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dtm)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    paramq = (dtn)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).setEnSendMsgActionFlag(paramq.FOM);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.Hq(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.Hp(this.fileName);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 236L, 1L, false);
      ad.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ad.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + paramq.xbt + " toUser:" + paramArrayOfByte.uki);
    if ((paramq.xbt <= 0L) && (!am.zs(paramArrayOfByte.uki)))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 235L, 1L, false);
      ad.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + paramq.xbt + " netoff:" + paramq.FMu);
      s.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ad.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramq.xbt), Integer.valueOf(ac.iOO) });
    if ((10007 == ac.iON) && (ac.iOO != 0))
    {
      paramq.xbt = ac.iOO;
      ac.iOO = 0;
    }
    paramInt1 = s.a(this.fileName, this.iuI, paramq.xbt, paramq.Fwt, this.endFlag, this.iwi);
    ad.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.xbt + " clientId:" + paramq.Fwt + " neWWOff:" + this.iuI + " neTTTT:" + paramq.FIg + " forwardflag:" + this.iwi);
    if (paramInt1 < 0)
    {
      s.Hp(this.fileName);
      ad.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (paramInt1 == 1)
    {
      ad.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      paramq = s.Ia(this.fileName);
      paramq = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramq.iuf);
      com.tencent.mm.modelstat.b.inZ.q(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (this.iwe) {}
    for (long l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.hMj.az(l, l);
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
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(148420);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(148419);
    paramq = (dtm)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    ad.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + paramq.xbt + " offset:" + paramq.FMu + " dataLen:" + paramq.xcN.getILen() + " endFlag:" + paramq.ihf);
    if (((paramq.xbt == 0L) && (paramq.FMu != 0)) || (((paramq.xcN == null) || (paramq.xcN.getILen() == 0)) && (paramq.ihf != 1) && (paramq.Gds != 1)))
    {
      paramq = n.b.hOq;
      AppMethodBeat.o(148419);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(148419);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148421);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 238L, 1L, false);
    s.Hp(this.fileName);
    AppMethodBeat.o(148421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */