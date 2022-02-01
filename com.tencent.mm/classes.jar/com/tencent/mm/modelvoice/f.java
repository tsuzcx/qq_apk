package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.al.g callback;
  private int endFlag;
  public String fileName;
  av gTs;
  private int hAL;
  private boolean hCh;
  private int hCl;
  long hCm;
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
    this.hAL = 0;
    this.hCh = false;
    this.endFlag = 0;
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148416);
        r localr = s.AG(f.this.fileName);
        if ((localr == null) || (!localr.aDC()))
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
          if (l / 1000L - localr.hAg > 30L)
          {
            ad.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fileName);
            f.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
            AppMethodBeat.o(148416);
            return false;
          }
          if (l - f.this.hCm < 2000L)
          {
            ad.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fileName + " but last send time:" + (l - f.this.hCm));
            AppMethodBeat.o(148416);
            return true;
          }
          g localg = s.Ax(f.this.fileName).dp(localr.hyM, 6000);
          ad.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fileName + " readByte:" + localg.cZc + " stat:" + localr.status);
          if (localg.cZc < 2000)
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
      this.hCl = paramInt;
      AppMethodBeat.o(148417);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(148418);
    this.callback = paramg;
    this.hCh = false;
    if (this.fileName == null)
    {
      ad.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    r localr = s.AG(this.fileName);
    if ((localr == null) || (!localr.aDC()))
    {
      ad.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148418);
      return -1;
    }
    ad.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localr.hAj);
    if (!s.Aw(this.fileName))
    {
      ad.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.zV(this.fileName);
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
      ad.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      this.endFlag = 0;
      s.AC(localr.fileName);
      j = 0;
      k = 1;
      int m = localr.hDp;
      ad.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = s.AH(this.fileName);
        ad.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = s.oZ(this.hAL);
          ad.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new b.a();
      ((b.a)localObject1).gUU = new dig();
      ((b.a)localObject1).gUV = new dih();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((b.a)localObject1).funcId = 127;
      ((b.a)localObject1).reqCmdId = 19;
      ((b.a)localObject1).respCmdId = 1000000019;
      this.rr = ((b.a)localObject1).atI();
      localObject1 = (dig)this.rr.gUS.gUX;
      ((dig)localObject1).sdQ = u.aqG();
      ((dig)localObject1).sdP = localr.dtV;
      ((dig)localObject1).CNt = localr.hyM;
      ((dig)localObject1).CyF = localr.clientId;
      ((dig)localObject1).CLA = i;
      ((dig)localObject1).hno = this.endFlag;
      ((dig)localObject1).uKZ = localr.drA;
      ((dig)localObject1).DcP = k;
      ((dig)localObject1).Eyw = this.hCl;
      ((dig)localObject1).CxC = bk.asn();
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localr.dtV)) {
        ((dig)localObject1).COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(localr.dtV);
      }
      ((dig)localObject1).CxC = a.a.Wh().F(localr.dtV, localr.hAi);
      ((dig)localObject1).DMv = j;
      if (k == 1) {
        break label2073;
      }
      ((dig)localObject1).uKT = new SKBuiltinBuffer_t().setBuffer(paramg.buf, 0, paramg.cZc);
    }
    for (((dig)localObject1).CJI = paramg.cZc;; ((dig)localObject1).CJI = 1)
    {
      ad.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localr.drA);
      ad.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((dig)localObject1).uKZ + " user:" + ((dig)localObject1).sdP + " offset:" + ((dig)localObject1).CNt + " dataLen:" + ((dig)localObject1).uKT.getILen() + " endFlag:" + ((dig)localObject1).hno);
      ad.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localr.drA + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + paramg.cZc + " neTTTOff:" + localr.hyM + " neWWWOff:" + this.hAL + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localr.status + " voiceLen:" + i);
      this.hCm = System.currentTimeMillis();
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(148418);
      return i;
      if (localr.status == 3) {
        this.hCh = true;
      }
      Object localObject2 = s.Ax(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        ad.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        AppMethodBeat.o(148418);
        return -1;
      }
      j = ((b)localObject2).getFormat();
      ad.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(j)));
      paramg = ((b)localObject2).dp(localr.hyM, 6000);
      ad.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + localr.hyM + " line:" + com.tencent.mm.compatible.util.f.getLine());
      if (paramg.ret < 0)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 241L, 1L, false);
        ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + localr.hyM);
        s.zV(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.hAL = paramg.hAL;
      if ((this.hAL < localr.hyM) || (this.hAL >= 469000))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 240L, 1L, false);
        ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.hAL + " OldtOff:" + localr.hyM);
        s.zV(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      this.endFlag = 0;
      if ((paramg.cZc == 0) && (!this.hCh))
      {
        ad.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148418);
        return -1;
      }
      if (this.hCh)
      {
        if (localr.gTY <= 0)
        {
          ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localr.gTY);
          s.zV(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if ((localr.gTY > this.hAL) && (paramg.cZc < 6000))
        {
          ad.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + localr.hyM + " totalLen:" + localr.gTY);
          s.zV(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(148418);
          return -1;
        }
        if (localr.gTY <= this.hAL)
        {
          localObject1 = (Integer)s.hDu.get(s.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)s.hDv.get(s.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).dp(0, i);
            k = s.c(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).cZc);
            if (((Integer)localObject1).intValue() != k)
            {
              ad.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).cZc) });
              ad.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + localr.hyM + " totalLen:" + localr.gTY);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 173L, 1L, false);
              s.hDu.put(s.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)s.hDw.get(s.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = s.b(0, ((g)localObject2).buf, ((g)localObject2).cZc);
                if (((Integer)localObject1).intValue() != i)
                {
                  ad.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  s.zV(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 174L, 1L, false);
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
      ((dig)localObject1).uKT = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bx.b.cd(new byte[1]));
    }
  }
  
  public final int getType()
  {
    return 127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148422);
    ad.i("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dig)((com.tencent.mm.al.b)paramq).gUS.gUX;
    paramq = (dih)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.COU);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      s.zW(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      s.zV(this.fileName);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 237L, 1L, false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 236L, 1L, false);
      ad.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ad.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + paramq.uKZ + " toUser:" + paramArrayOfByte.sdP);
    if ((paramq.uKZ <= 0L) && (!af.st(paramArrayOfByte.sdP)))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 235L, 1L, false);
      ad.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + paramq.uKZ + " netoff:" + paramq.CNt);
      s.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    ad.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramq.uKZ), Integer.valueOf(ab.hVD) });
    if ((10007 == ab.hVC) && (ab.hVD != 0))
    {
      paramq.uKZ = ab.hVD;
      ab.hVD = 0;
    }
    paramInt1 = s.a(this.fileName, this.hAL, paramq.uKZ, paramq.CyF, this.endFlag, this.hCl);
    ad.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.uKZ + " clientId:" + paramq.CyF + " neWWOff:" + this.hAL + " neTTTT:" + paramq.CJI + " forwardflag:" + this.hCl);
    if (paramInt1 < 0)
    {
      s.zV(this.fileName);
      ad.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (paramInt1 == 1)
    {
      ad.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      paramq = s.AG(this.fileName);
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramq.hAi);
      com.tencent.mm.modelstat.b.huc.q(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148422);
      return;
    }
    if (this.hCh) {}
    for (long l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.gTs.av(l, l);
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
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 239L, 1L, false);
    }
    AppMethodBeat.o(148420);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(148419);
    paramq = (dig)((com.tencent.mm.al.b)paramq).gUS.gUX;
    ad.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + paramq.uKZ + " offset:" + paramq.CNt + " dataLen:" + paramq.uKT.getILen() + " endFlag:" + paramq.hno);
    if (((paramq.uKZ == 0L) && (paramq.CNt != 0)) || (((paramq.uKT == null) || (paramq.uKT.getILen() == 0)) && (paramq.hno != 1) && (paramq.DcP != 1)))
    {
      paramq = n.b.gVC;
      AppMethodBeat.o(148419);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(148419);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148421);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 238L, 1L, false);
    s.zV(this.fileName);
    AppMethodBeat.o(148421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */