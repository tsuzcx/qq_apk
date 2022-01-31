package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cbu;
import com.tencent.mm.protocal.c.cbv;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import junit.framework.Assert;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  private int eIh = 0;
  private boolean eJS = false;
  private int eJW;
  long eJX;
  am ebj = new am(new f.1(this), true);
  private int endFlag = 0;
  public String fileName;
  public int retCode = 0;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      y.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:" + paramString);
      this.fileName = paramString;
      this.eJW = paramInt;
      return;
      bool = false;
    }
  }
  
  protected final int Ka()
  {
    return 60;
  }
  
  public final boolean Ky()
  {
    boolean bool = super.Ky();
    if (bool) {
      h.nFQ.a(111L, 239L, 1L, false);
    }
    return bool;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    this.eJS = false;
    if (this.fileName == null)
    {
      y.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      return -1;
    }
    p localp = q.oG(this.fileName);
    if ((localp == null) || (!localp.Tk()))
    {
      y.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      return -1;
    }
    y.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + localp.eHJ);
    if (!q.ow(this.fileName))
    {
      y.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      q.nX(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      return -1;
    }
    paramf = new g();
    int k;
    int j;
    int i;
    Object localObject1;
    if (localp.status == 8)
    {
      y.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
      k = 1;
      this.endFlag = 0;
      q.oC(localp.fileName);
      j = 0;
      int m = localp.eKW;
      y.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = q.oH(this.fileName);
        y.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = q.jx(this.eIh);
          y.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new cbu();
      ((b.a)localObject1).ecI = new cbv();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((b.a)localObject1).ecG = 127;
      ((b.a)localObject1).ecJ = 19;
      ((b.a)localObject1).ecK = 1000000019;
      this.dmK = ((b.a)localObject1).Kt();
      localObject1 = (cbu)this.dmK.ecE.ecN;
      ((cbu)localObject1).kWn = com.tencent.mm.model.q.Gj();
      ((cbu)localObject1).kWm = localp.bVI;
      ((cbu)localObject1).sDT = localp.eGk;
      ((cbu)localObject1).swQ = localp.clientId;
      ((cbu)localObject1).sRf = i;
      ((cbu)localObject1).euw = this.endFlag;
      ((cbu)localObject1).ndp = localp.bXr;
      ((cbu)localObject1).sRg = k;
      ((cbu)localObject1).tQV = this.eJW;
      ((cbu)localObject1).svK = bf.HS();
      ((cbu)localObject1).svK = a.a.yf().A(localp.bVI, localp.eHI);
      ((cbu)localObject1).trH = j;
      if (k == 1) {
        break label1966;
      }
      ((cbu)localObject1).ndi = new bmk().T(paramf.buf, paramf.bDu);
    }
    for (((cbu)localObject1).sRd = paramf.bDu;; ((cbu)localObject1).sRd = 1)
    {
      y.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localp.bXr);
      y.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((cbu)localObject1).ndp + " user:" + ((cbu)localObject1).kWm + " offset:" + ((cbu)localObject1).sDT + " dataLen:" + ((cbu)localObject1).ndi.tFK + " endFlag:" + ((cbu)localObject1).euw);
      y.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localp.bXr + " voiceFormat:" + j + " file:" + this.fileName + " readBytes:" + paramf.bDu + " neTTTOff:" + localp.eGk + " neWWWOff:" + this.eIh + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localp.status + " voiceLen:" + i);
      this.eJX = System.currentTimeMillis();
      return a(parame, this.dmK, this);
      if (localp.status == 3) {
        this.eJS = true;
      }
      Object localObject2 = q.ox(this.fileName);
      if (localObject2 == null)
      {
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        y.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fileName });
        return -1;
      }
      j = ((b)localObject2).getFormat();
      y.d("MicroMsg.NetSceneUploadVoice", "format " + j);
      paramf = ((b)localObject2).bz(localp.eGk, 6000);
      y.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + localp.eGk + " line:" + com.tencent.mm.compatible.util.g.getLine());
      if (paramf.ret < 0)
      {
        h.nFQ.a(111L, 241L, 1L, false);
        y.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + localp.eGk);
        q.nX(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        return -1;
      }
      this.eIh = paramf.eIh;
      if ((this.eIh < localp.eGk) || (this.eIh >= 469000))
      {
        h.nFQ.a(111L, 240L, 1L, false);
        y.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.eIh + " OldtOff:" + localp.eGk);
        q.nX(this.fileName);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        return -1;
      }
      this.endFlag = 0;
      if ((paramf.bDu == 0) && (!this.eJS))
      {
        y.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        return -1;
      }
      if (this.eJS)
      {
        if (localp.ebK <= 0)
        {
          y.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localp.ebK);
          q.nX(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          return -1;
        }
        if ((localp.ebK > this.eIh) && (paramf.bDu < 6000))
        {
          y.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + localp.eGk + " totalLen:" + localp.ebK);
          q.nX(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          return -1;
        }
        if (localp.ebK <= this.eIh)
        {
          localObject1 = (Integer)q.eLb.get(q.getFullPath(this.fileName));
          if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
          {
            i = ((Integer)q.eLc.get(q.getFullPath(this.fileName))).intValue();
            localObject2 = ((b)localObject2).bz(0, i);
            k = q.b(((Integer)localObject1).intValue() & 0xFF, ((g)localObject2).buf, ((g)localObject2).bDu);
            if (((Integer)localObject1).intValue() != k)
            {
              y.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Integer.valueOf(((g)localObject2).bDu) });
              y.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + localp.eGk + " totalLen:" + localp.ebK);
              h.nFQ.a(111L, 173L, 1L, false);
              q.eLb.put(q.getFullPath(this.fileName), Integer.valueOf(k));
              localObject1 = (Integer)q.eLd.get(q.getFullPath(this.fileName));
              if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0))
              {
                i = q.a(0, ((g)localObject2).buf, ((g)localObject2).bDu);
                if (((Integer)localObject1).intValue() != i)
                {
                  y.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[] { localObject1, Integer.valueOf(i) });
                  q.nX(this.fileName);
                  this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
                  h.nFQ.a(111L, 174L, 1L, false);
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
      label1966:
      ((cbu)localObject1).ndi = new bmk().b(com.tencent.mm.bv.b.bk(new byte[1]));
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cbu)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    paramq = (cbv)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      q.nY(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      q.nX(this.fileName);
      h.nFQ.a(111L, 237L, 1L, false);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.nFQ.a(111L, 236L, 1L, false);
      y.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + paramq.ndp + " toUser:" + paramArrayOfByte.kWm);
    if ((paramq.ndp <= 0L) && (!ad.hd(paramArrayOfByte.kWm)))
    {
      h.nFQ.a(111L, 235L, 1L, false);
      y.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + paramq.ndp + " netoff:" + paramq.sDT);
      q.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramq.ndp), Integer.valueOf(ae.eSQ) });
    if ((10007 == ae.eSP) && (ae.eSQ != 0))
    {
      paramq.ndp = ae.eSQ;
      ae.eSQ = 0;
    }
    paramInt1 = q.a(this.fileName, this.eIh, paramq.ndp, paramq.swQ, this.endFlag, this.eJW);
    y.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.ndp + " clientId:" + paramq.swQ + " neWWOff:" + this.eIh + " neTTTT:" + paramq.sRd + " forwardflag:" + this.eJW);
    if (paramInt1 < 0)
    {
      q.nX(this.fileName);
      y.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramInt1 == 1)
    {
      y.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
      paramq = q.oG(this.fileName);
      paramq = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramq.eHI);
      com.tencent.mm.modelstat.b.eBD.f(paramq);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.eJS) {}
    for (long l = 0L;; l = 500L)
    {
      y.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.ebj.S(l, l);
      return;
    }
  }
  
  protected final void a(m.a parama)
  {
    h.nFQ.a(111L, 238L, 1L, false);
    q.nX(this.fileName);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    paramq = (cbu)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    y.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + paramq.ndp + " offset:" + paramq.sDT + " dataLen:" + paramq.ndi.tFK + " endFlag:" + paramq.euw);
    if (((paramq.ndp == 0L) && (paramq.sDT != 0)) || (((paramq.ndi == null) || (paramq.ndi.tFK == 0)) && (paramq.euw != 1) && (paramq.sRg != 1))) {
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 127;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f
 * JD-Core Version:    0.7.0.1
 */