package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.at;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends n
  implements k
{
  private static at hCf;
  private static List<c> hCg;
  private g callback;
  private String dtV;
  public String fileName;
  private av gTs;
  private String hCe;
  private boolean hCh;
  private boolean hCi;
  public int retCode;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(148415);
    hCf = null;
    hCg = new ArrayList();
    AppMethodBeat.o(148415);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(148408);
    this.retCode = 0;
    this.hCh = false;
    this.hCi = false;
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148404);
        if (e.this.doScene(e.a(e.this), e.b(e.this)) == -1) {
          e.b(e.this).onSceneEnd(3, -1, "doScene failed", e.this);
        }
        AppMethodBeat.o(148404);
        return false;
      }
    }, false);
    if (paramr != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fileName = paramr.fileName;
      if (this.fileName == null) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.hCe = paramr.hCe;
      this.dtV = paramr.dtV;
      ad.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", new Object[] { this.fileName, this.hCe, this.dtV });
      AppMethodBeat.o(148408);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(at paramat)
  {
    if (hCf == null) {
      hCf = paramat;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(148405);
    if (!hCg.contains(paramc)) {
      hCg.add(paramc);
    }
    AppMethodBeat.o(148405);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148406);
    hCg.remove(paramc);
    AppMethodBeat.o(148406);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(148407);
    final bl localbl = s.AF(this.fileName);
    if (localbl != null)
    {
      if (hCf != null) {
        hCf.a(localbl);
      }
      Iterator localIterator = hCg.iterator();
      while (localIterator.hasNext()) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148403);
            this.hCj.V(localbl);
            AppMethodBeat.o(148403);
          }
        });
      }
    }
    AppMethodBeat.o(148407);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(148409);
    this.callback = paramg;
    if (this.fileName == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    paramg = s.AG(this.fileName);
    if ((paramg == null) || (!paramg.aDB()))
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    ad.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + paramg.hAj);
    if (!s.Aw(this.fileName))
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.zV(this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    int i = paramg.hyM - paramg.hAd;
    if (i <= 0)
    {
      if (paramg.status == 5)
      {
        this.hCi = true;
        ad.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + paramg.hyM + " Local:" + paramg.hAd);
        this.retCode = (f.getLine() + 10000);
        AppMethodBeat.o(148409);
        return -1;
      }
      s.a(this.fileName, paramg.hAd, null);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    if (paramg.gTY == paramg.hyM) {
      this.hCh = true;
    }
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ach();
    ((b.a)localObject).gUV = new aci();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((b.a)localObject).funcId = 128;
    ((b.a)localObject).reqCmdId = 20;
    ((b.a)localObject).respCmdId = 1000000020;
    this.rr = ((b.a)localObject).atI();
    localObject = (ach)this.rr.gUS.gUX;
    ((ach)localObject).CyF = paramg.clientId;
    ((ach)localObject).uKZ = paramg.drA;
    ((ach)localObject).CJI = i;
    ((ach)localObject).CNt = paramg.hAd;
    if (w.pF(this.dtV))
    {
      ((ach)localObject).Cxb = this.dtV;
      ((ach)localObject).DcO = paramg.hDr;
    }
    ad.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { ((ach)localObject).CyF, Integer.valueOf(((ach)localObject).uKX), Long.valueOf(((ach)localObject).uKZ), Integer.valueOf(((ach)localObject).CJI), Integer.valueOf(((ach)localObject).CNt), ((ach)localObject).Cxb, Long.valueOf(((ach)localObject).DcO) });
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(148409);
    return i;
  }
  
  public final int getType()
  {
    return 128;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148413);
    ad.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (aci)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramArrayOfByte.DcP == 1)
    {
      ad.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.AB(this.fileName);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt3 == -22)
    {
      s.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.vKh.idkeyStat(111L, 231L, 1L, false);
      s.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.vKh.idkeyStat(111L, 230L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + paramq.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    ad.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.uKT.getILen() + " fileOff:" + paramArrayOfByte.CNt);
    if (paramArrayOfByte.uKT.getBuffer() == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramq = paramArrayOfByte.uKT.getBuffer().toByteArray();
    if (paramq.length == 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramInt1 = s.br(this.hCe, this.fileName).write(paramq, paramq.length, paramArrayOfByte.CNt);
    if (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    s.a(this.fileName, paramq, paramq.length);
    ad.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.hCe);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    if (paramInt1 < 0)
    {
      h.vKh.idkeyStat(111L, 229L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt1 == 1)
    {
      doNotify();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    long l = 1000L;
    if (this.hCh) {
      l = 0L;
    }
    this.gTs.av(l, l);
    AppMethodBeat.o(148413);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(148412);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      h.vKh.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(148412);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(148410);
    paramq = (ach)((com.tencent.mm.al.b)paramq).gUS.gUX;
    if ((paramq.uKZ == 0L) || (paramq.CyF == null) || (paramq.CyF.length() == 0) || (paramq.CJI <= 0) || (paramq.CNt < 0))
    {
      s.zV(this.fileName);
      paramq = n.b.gVC;
      AppMethodBeat.o(148410);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(148410);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148411);
    h.vKh.idkeyStat(111L, 233L, 1L, false);
    s.zV(this.fileName);
    AppMethodBeat.o(148411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */