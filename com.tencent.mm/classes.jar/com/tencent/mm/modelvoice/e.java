package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.x;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends n
  implements k
{
  private static com.tencent.mm.model.aw iyV;
  private static List<c> iyW;
  private com.tencent.mm.ak.f callback;
  private String dED;
  public String fileName;
  private com.tencent.mm.sdk.platformtools.aw hPc;
  private String iyU;
  private boolean iyX;
  private boolean iyY;
  public int retCode;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(148415);
    iyV = null;
    iyW = new ArrayList();
    AppMethodBeat.o(148415);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(148408);
    this.retCode = 0;
    this.iyX = false;
    this.iyY = false;
    this.hPc = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
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
      this.iyU = paramr.iyU;
      this.dED = paramr.dED;
      ae.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice[%s]:  file[%s] voiceFormat[%s] user[%s]", new Object[] { toString(), this.fileName, this.iyU, this.dED });
      AppMethodBeat.o(148408);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(com.tencent.mm.model.aw paramaw)
  {
    if (iyV == null) {
      iyV = paramaw;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(148405);
    if (!iyW.contains(paramc)) {
      iyW.add(paramc);
    }
    AppMethodBeat.o(148405);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148406);
    iyW.remove(paramc);
    AppMethodBeat.o(148406);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(148407);
    final bv localbv = s.IB(this.fileName);
    if (localbv != null)
    {
      if (iyV != null) {
        iyV.a(localbv);
      }
      Iterator localIterator = iyW.iterator();
      while (localIterator.hasNext()) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148403);
            this.iyZ.X(localbv);
            AppMethodBeat.o(148403);
          }
        });
      }
    }
    AppMethodBeat.o(148407);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(148409);
    this.callback = paramf;
    if (this.fileName == null)
    {
      ae.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    paramf = s.IC(this.fileName);
    if ((paramf == null) || (!paramf.aNZ()))
    {
      ae.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    ae.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + paramf.ixa);
    if (!s.Is(this.fileName))
    {
      ae.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.HR(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    int i = paramf.ivD - paramf.iwU;
    if (i <= 0)
    {
      if (paramf.status == 5)
      {
        this.iyY = true;
        ae.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + paramf.ivD + " Local:" + paramf.iwU);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148409);
        return -1;
      }
      s.a(this.fileName, paramf.iwU, null);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    if (paramf.hPI == paramf.ivD) {
      this.iyX = true;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new afq();
    ((b.a)localObject).hQG = new afr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((b.a)localObject).funcId = 128;
    ((b.a)localObject).hQH = 20;
    ((b.a)localObject).respCmdId = 1000000020;
    this.rr = ((b.a)localObject).aDS();
    localObject = (afq)this.rr.hQD.hQJ;
    ((afq)localObject).FOR = paramf.clientId;
    ((afq)localObject).xrk = paramf.dCd;
    ((afq)localObject).GaC = i;
    ((afq)localObject).GeT = paramf.iwU;
    if (x.wb(this.dED))
    {
      ((afq)localObject).FNj = this.dED;
      ((afq)localObject).GvY = paramf.iAh;
    }
    ae.i("MicroMsg.NetSceneDownloadVoice", "[%s]doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { toString(), ((afq)localObject).FOR, Integer.valueOf(((afq)localObject).xri), Long.valueOf(((afq)localObject).xrk), Integer.valueOf(((afq)localObject).GaC), Integer.valueOf(((afq)localObject).GeT), ((afq)localObject).FNj, Long.valueOf(((afq)localObject).GvY) });
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
    ae.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd[" + toString() + "] file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (afr)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramArrayOfByte.GvZ == 1)
    {
      ae.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.Ix(this.fileName);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt3 == -22)
    {
      s.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      g.yxI.idkeyStat(111L, 231L, 1L, false);
      s.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      g.yxI.idkeyStat(111L, 230L, 1L, false);
      ae.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + paramq.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    ae.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.xsE.getILen() + " fileOff:" + paramArrayOfByte.GeT);
    if (paramArrayOfByte.xsE.getBuffer() == null)
    {
      ae.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramq = paramArrayOfByte.xsE.getBuffer().toByteArray();
    if (paramq.length == 0)
    {
      ae.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramInt1 = s.bA(this.iyU, this.fileName).write(paramq, paramq.length, paramArrayOfByte.GeT);
    if (paramInt1 < 0)
    {
      ae.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    s.a(this.fileName, paramq, paramq.length);
    ae.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.iyU);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    ae.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd[" + toString() + "] : file:%s ret:%s", new Object[] { this.fileName, Integer.valueOf(paramInt1) });
    if (paramInt1 < 0)
    {
      g.yxI.idkeyStat(111L, 229L, 1L, false);
      ae.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
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
    if (this.iyX) {
      l = 0L;
    }
    this.hPc.ay(l, l);
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
      g.yxI.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(148412);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(148410);
    paramq = (afq)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    if ((paramq.xrk == 0L) || (paramq.FOR == null) || (paramq.FOR.length() == 0) || (paramq.GaC <= 0) || (paramq.GeT < 0))
    {
      s.HR(this.fileName);
      paramq = n.b.hRj;
      AppMethodBeat.o(148410);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(148410);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148411);
    g.yxI.idkeyStat(111L, 233L, 1L, false);
    s.HR(this.fileName);
    AppMethodBeat.o(148411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */