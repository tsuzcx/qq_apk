package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.protocal.c.uk;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends m
  implements k
{
  private static ao eJQ = null;
  private static List<c> eJR = new ArrayList();
  private String bVI;
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private String eJP;
  private boolean eJS = false;
  private boolean eJT = false;
  private am ebj = new am(new e.2(this), false);
  public String fileName;
  public int retCode = 0;
  
  public e(p paramp)
  {
    if (paramp != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fileName = paramp.fileName;
      if (this.fileName == null) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.eJP = paramp.eJP;
      this.bVI = paramp.bVI;
      y.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", new Object[] { this.fileName, this.eJP, this.bVI });
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(ao paramao)
  {
    if (eJQ == null) {
      eJQ = paramao;
    }
  }
  
  public static void a(c paramc)
  {
    if (!eJR.contains(paramc)) {
      eJR.add(paramc);
    }
  }
  
  public static void b(c paramc)
  {
    eJR.remove(paramc);
  }
  
  private void doNotify()
  {
    bi localbi = q.oF(this.fileName);
    if (localbi != null)
    {
      if (eJQ != null) {
        eJQ.a(localbi);
      }
      Iterator localIterator = eJR.iterator();
      while (localIterator.hasNext()) {
        ai.d(new e.1(this, (c)localIterator.next(), localbi));
      }
    }
  }
  
  protected final int Ka()
  {
    return 100;
  }
  
  public final boolean Ky()
  {
    boolean bool = super.Ky();
    if (bool) {
      h.nFQ.a(111L, 232L, 1L, false);
    }
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    if (this.fileName == null)
    {
      y.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (g.getLine() + 10000);
      return -1;
    }
    paramf = q.oG(this.fileName);
    if ((paramf == null) || (!paramf.Tj()))
    {
      y.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (g.getLine() + 10000);
      return -1;
    }
    y.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + paramf.eHJ);
    if (!q.ow(this.fileName))
    {
      y.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      q.nX(this.fileName);
      this.retCode = (g.getLine() + 10000);
      return -1;
    }
    int i = paramf.eGk - paramf.eHC;
    if (i <= 0)
    {
      if (paramf.status == 5)
      {
        this.eJT = true;
        y.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + paramf.eGk + " Local:" + paramf.eHC);
        this.retCode = (g.getLine() + 10000);
        return -1;
      }
      q.a(this.fileName, paramf.eHC, null);
      this.retCode = (g.getLine() + 10000);
      return -1;
    }
    if (paramf.ebK == paramf.eGk) {
      this.eJS = true;
    }
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new uj();
    ((b.a)localObject).ecI = new uk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((b.a)localObject).ecG = 128;
    ((b.a)localObject).ecJ = 20;
    ((b.a)localObject).ecK = 1000000020;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (uj)this.dmK.ecE.ecN;
    ((uj)localObject).swQ = paramf.clientId;
    ((uj)localObject).ndp = paramf.bXr;
    ((uj)localObject).sRd = i;
    ((uj)localObject).sDT = paramf.eHC;
    if (s.fn(this.bVI))
    {
      ((uj)localObject).svm = this.bVI;
      ((uj)localObject).sRe = paramf.eKY;
    }
    y.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { ((uj)localObject).swQ, Integer.valueOf(((uj)localObject).ndm), Long.valueOf(((uj)localObject).ndp), Integer.valueOf(((uj)localObject).sRd), Integer.valueOf(((uj)localObject).sDT), ((uj)localObject).svm, Long.valueOf(((uj)localObject).sRe) });
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (uk)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramArrayOfByte.sRg == 1)
    {
      y.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      q.oB(this.fileName);
      return;
    }
    if (paramInt3 == -22)
    {
      q.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.nFQ.a(111L, 231L, 1L, false);
      q.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.nFQ.a(111L, 230L, 1L, false);
      y.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + paramq.HF().spN);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.ndi.tFK + " fileOff:" + paramArrayOfByte.sDT);
    if (paramArrayOfByte.ndi.tFM == null)
    {
      y.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      q.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = paramArrayOfByte.ndi.tFM.toByteArray();
    if (paramq.length == 0)
    {
      y.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      q.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramInt1 = q.aI(this.eJP, this.fileName).write(paramq, paramq.length, paramArrayOfByte.sDT);
    if (paramInt1 < 0)
    {
      y.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      q.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    q.c(this.fileName, paramq, paramq.length);
    y.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.eJP);
    paramInt1 = q.a(this.fileName, paramInt1, null);
    if (paramInt1 < 0)
    {
      h.nFQ.a(111L, 229L, 1L, false);
      y.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramInt1 == 1)
    {
      doNotify();
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    long l = 1000L;
    if (this.eJS) {
      l = 0L;
    }
    this.ebj.S(l, l);
  }
  
  protected final void a(m.a parama)
  {
    h.nFQ.a(111L, 233L, 1L, false);
    q.nX(this.fileName);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    paramq = (uj)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    if ((paramq.ndp == 0L) || (paramq.swQ == null) || (paramq.swQ.length() == 0) || (paramq.sRd <= 0) || (paramq.sDT < 0))
    {
      q.nX(this.fileName);
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */