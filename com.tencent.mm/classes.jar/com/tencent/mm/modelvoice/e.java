package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.at;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends n
  implements k
{
  private static at icG;
  private static List<c> icH;
  private g callback;
  private String drG;
  public String fileName;
  private au htR;
  private String icF;
  private boolean icI;
  private boolean icJ;
  public int retCode;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(148415);
    icG = null;
    icH = new ArrayList();
    AppMethodBeat.o(148415);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(148408);
    this.retCode = 0;
    this.icI = false;
    this.icJ = false;
    this.htR = new au(new au.a()
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
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.icF = paramr.icF;
      this.drG = paramr.drG;
      ac.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice[%s]:  file[%s] voiceFormat[%s] user[%s]", new Object[] { toString(), this.fileName, this.icF, this.drG });
      AppMethodBeat.o(148408);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(at paramat)
  {
    if (icG == null) {
      icG = paramat;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(148405);
    if (!icH.contains(paramc)) {
      icH.add(paramc);
    }
    AppMethodBeat.o(148405);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148406);
    icH.remove(paramc);
    AppMethodBeat.o(148406);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(148407);
    final bo localbo = s.EK(this.fileName);
    if (localbo != null)
    {
      if (icG != null) {
        icG.a(localbo);
      }
      Iterator localIterator = icH.iterator();
      while (localIterator.hasNext()) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148403);
            this.icK.V(localbo);
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
      ac.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    paramg = s.EL(this.fileName);
    if ((paramg == null) || (!paramg.aKs()))
    {
      ac.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    ac.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + paramg.iaK);
    if (!s.EB(this.fileName))
    {
      ac.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Ea(this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    int i = paramg.hZn - paramg.iaE;
    if (i <= 0)
    {
      if (paramg.status == 5)
      {
        this.icJ = true;
        ac.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + paramg.hZn + " Local:" + paramg.iaE);
        this.retCode = (f.getLine() + 10000);
        AppMethodBeat.o(148409);
        return -1;
      }
      s.a(this.fileName, paramg.iaE, null);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    if (paramg.hux == paramg.hZn) {
      this.icI = true;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new adg();
    ((b.a)localObject).hvu = new adh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((b.a)localObject).funcId = 128;
    ((b.a)localObject).reqCmdId = 20;
    ((b.a)localObject).respCmdId = 1000000020;
    this.rr = ((b.a)localObject).aAz();
    localObject = (adg)this.rr.hvr.hvw;
    ((adg)localObject).DRb = paramg.clientId;
    ((adg)localObject).vTQ = paramg.dpl;
    ((adg)localObject).Eck = i;
    ((adg)localObject).EfV = paramg.iaE;
    if (w.sQ(this.drG))
    {
      ((adg)localObject).DPx = this.drG;
      ((adg)localObject).EvV = paramg.idT;
    }
    ac.i("MicroMsg.NetSceneDownloadVoice", "[%s]doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { toString(), ((adg)localObject).DRb, Integer.valueOf(((adg)localObject).vTO), Long.valueOf(((adg)localObject).vTQ), Integer.valueOf(((adg)localObject).Eck), Integer.valueOf(((adg)localObject).EfV), ((adg)localObject).DPx, Long.valueOf(((adg)localObject).EvV) });
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
    ac.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd[" + toString() + "] file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (adh)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (paramArrayOfByte.EvW == 1)
    {
      ac.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.EG(this.fileName);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt3 == -22)
    {
      s.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.wUl.idkeyStat(111L, 231L, 1L, false);
      s.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.wUl.idkeyStat(111L, 230L, 1L, false);
      ac.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + paramq.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    ac.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.vTK.getILen() + " fileOff:" + paramArrayOfByte.EfV);
    if (paramArrayOfByte.vTK.getBuffer() == null)
    {
      ac.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramq = paramArrayOfByte.vTK.getBuffer().toByteArray();
    if (paramq.length == 0)
    {
      ac.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramInt1 = s.bz(this.icF, this.fileName).write(paramq, paramq.length, paramArrayOfByte.EfV);
    if (paramInt1 < 0)
    {
      ac.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    s.a(this.fileName, paramq, paramq.length);
    ac.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.icF);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    ac.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd[" + toString() + "] : file:%s ret:%s", new Object[] { this.fileName, Integer.valueOf(paramInt1) });
    if (paramInt1 < 0)
    {
      h.wUl.idkeyStat(111L, 229L, 1L, false);
      ac.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
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
    if (this.icI) {
      l = 0L;
    }
    this.htR.au(l, l);
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
      h.wUl.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(148412);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(148410);
    paramq = (adg)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    if ((paramq.vTQ == 0L) || (paramq.DRb == null) || (paramq.DRb.length() == 0) || (paramq.Eck <= 0) || (paramq.EfV < 0))
    {
      s.Ea(this.fileName);
      paramq = n.b.hwb;
      AppMethodBeat.o(148410);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(148410);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148411);
    h.wUl.idkeyStat(111L, 233L, 1L, false);
    s.Ea(this.fileName);
    AppMethodBeat.o(148411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */