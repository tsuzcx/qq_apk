package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends m
  implements k
{
  private static aq fZs;
  private static List<c> fZt;
  private String cDt;
  private f callback;
  private String fZr;
  private boolean fZu;
  private boolean fZv;
  public String fileName;
  private ap frx;
  public int retCode;
  private com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(116576);
    fZs = null;
    fZt = new ArrayList();
    AppMethodBeat.o(116576);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(116570);
    this.retCode = 0;
    this.fZu = false;
    this.fZv = false;
    this.frx = new ap(new e.2(this), false);
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
      this.fZr = paramr.fZr;
      this.cDt = paramr.cDt;
      ab.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", new Object[] { this.fileName, this.fZr, this.cDt });
      AppMethodBeat.o(116570);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(aq paramaq)
  {
    if (fZs == null) {
      fZs = paramaq;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(116567);
    if (!fZt.contains(paramc)) {
      fZt.add(paramc);
    }
    AppMethodBeat.o(116567);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(116568);
    fZt.remove(paramc);
    AppMethodBeat.o(116568);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(116569);
    bi localbi = s.vS(this.fileName);
    if (localbi != null)
    {
      if (fZs != null) {
        fZs.a(localbi);
      }
      Iterator localIterator = fZt.iterator();
      while (localIterator.hasNext()) {
        al.d(new e.1(this, (c)localIterator.next(), localbi));
      }
    }
    AppMethodBeat.o(116569);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(116571);
    this.callback = paramf;
    if (this.fileName == null)
    {
      ab.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (g.getLine() + 10000);
      AppMethodBeat.o(116571);
      return -1;
    }
    paramf = s.vT(this.fileName);
    if ((paramf == null) || (!paramf.amv()))
    {
      ab.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (g.getLine() + 10000);
      AppMethodBeat.o(116571);
      return -1;
    }
    ab.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + paramf.fXz);
    if (!s.vJ(this.fileName))
    {
      ab.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.vk(this.fileName);
      this.retCode = (g.getLine() + 10000);
      AppMethodBeat.o(116571);
      return -1;
    }
    int i = paramf.fWa - paramf.fXs;
    if (i <= 0)
    {
      if (paramf.status == 5)
      {
        this.fZv = true;
        ab.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + paramf.fWa + " Local:" + paramf.fXs);
        this.retCode = (g.getLine() + 10000);
        AppMethodBeat.o(116571);
        return -1;
      }
      s.a(this.fileName, paramf.fXs, null);
      this.retCode = (g.getLine() + 10000);
      AppMethodBeat.o(116571);
      return -1;
    }
    if (paramf.fsd == paramf.fWa) {
      this.fZu = true;
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new yw();
    ((b.a)localObject).fsY = new yx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((b.a)localObject).funcId = 128;
    ((b.a)localObject).reqCmdId = 20;
    ((b.a)localObject).respCmdId = 1000000020;
    this.rr = ((b.a)localObject).ado();
    localObject = (yw)this.rr.fsV.fta;
    ((yw)localObject).wpS = paramf.clientId;
    ((yw)localObject).pIG = paramf.cFn;
    ((yw)localObject).wyT = i;
    ((yw)localObject).wzS = paramf.fXs;
    if (t.lA(this.cDt))
    {
      ((yw)localObject).wot = this.cDt;
      ((yw)localObject).wPT = paramf.gaF;
    }
    ab.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { ((yw)localObject).wpS, Integer.valueOf(((yw)localObject).pIE), Long.valueOf(((yw)localObject).pIG), Integer.valueOf(((yw)localObject).wyT), Integer.valueOf(((yw)localObject).wzS), ((yw)localObject).wot, Long.valueOf(((yw)localObject).wPT) });
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(116571);
    return i;
  }
  
  public final int getType()
  {
    return 128;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116575);
    ab.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (yx)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramArrayOfByte.wPU == 1)
    {
      ab.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.vO(this.fileName);
      AppMethodBeat.o(116575);
      return;
    }
    if (paramInt3 == -22)
    {
      s.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.qsU.idkeyStat(111L, 231L, 1L, false);
      s.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.qsU.idkeyStat(111L, 230L, 1L, false);
      ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + paramq.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    ab.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.pIA.getILen() + " fileOff:" + paramArrayOfByte.wzS);
    if (paramArrayOfByte.pIA.getBuffer() == null)
    {
      ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    paramq = paramArrayOfByte.pIA.getBuffer().toByteArray();
    if (paramq.length == 0)
    {
      ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    paramInt1 = s.bb(this.fZr, this.fileName).write(paramq, paramq.length, paramArrayOfByte.wzS);
    if (paramInt1 < 0)
    {
      ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    s.c(this.fileName, paramq, paramq.length);
    ab.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.fZr);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    if (paramInt1 < 0)
    {
      h.qsU.idkeyStat(111L, 229L, 1L, false);
      ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    if (paramInt1 == 1)
    {
      doNotify();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116575);
      return;
    }
    long l = 1000L;
    if (this.fZu) {
      l = 0L;
    }
    this.frx.ag(l, l);
    AppMethodBeat.o(116575);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(116574);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      h.qsU.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(116574);
    return bool;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(116572);
    paramq = (yw)((com.tencent.mm.ai.b)paramq).fsV.fta;
    if ((paramq.pIG == 0L) || (paramq.wpS == null) || (paramq.wpS.length() == 0) || (paramq.wyT <= 0) || (paramq.wzS < 0))
    {
      s.vk(this.fileName);
      paramq = m.b.ftv;
      AppMethodBeat.o(116572);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(116572);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(116573);
    h.qsU.idkeyStat(111L, 233L, 1L, false);
    s.vk(this.fileName);
    AppMethodBeat.o(116573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */