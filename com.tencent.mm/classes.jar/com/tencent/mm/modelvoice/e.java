package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bb;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends q
  implements m
{
  private static bb mjN;
  private static List<c> mjO;
  private i callback;
  private String fPV;
  public String fileName;
  private MTimerHandler lAo;
  private String mjM;
  private boolean mjP;
  private boolean mjQ;
  public int retCode;
  private d rr;
  
  static
  {
    AppMethodBeat.i(148415);
    mjN = null;
    mjO = new ArrayList();
    AppMethodBeat.o(148415);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(148408);
    this.retCode = 0;
    this.mjP = false;
    this.mjQ = false;
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
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
      this.mjM = paramr.mjM;
      this.fPV = paramr.fPV;
      Log.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice[%s]:  file[%s] voiceFormat[%s] user[%s]", new Object[] { toString(), this.fileName, this.mjM, this.fPV });
      AppMethodBeat.o(148408);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(bb parambb)
  {
    if (mjN == null) {
      mjN = parambb;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(148405);
    if (!mjO.contains(paramc)) {
      mjO.add(paramc);
    }
    AppMethodBeat.o(148405);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148406);
    mjO.remove(paramc);
    AppMethodBeat.o(148406);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(148407);
    final ca localca = s.YK(this.fileName);
    if (localca != null)
    {
      if (mjN != null) {
        mjN.a(localca);
      }
      Iterator localIterator = mjO.iterator();
      while (localIterator.hasNext()) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148403);
            this.mjR.ap(localca);
            AppMethodBeat.o(148403);
          }
        });
      }
    }
    AppMethodBeat.o(148407);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(148409);
    this.callback = parami;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    parami = s.YL(this.fileName);
    if ((parami == null) || (!parami.brD()))
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    Log.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + parami.mhS);
    if (!s.YB(this.fileName))
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Yb(this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    int i = parami.mgq - parami.mhM;
    if (i <= 0)
    {
      if (parami.status == 5)
      {
        this.mjQ = true;
        Log.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + parami.mgq + " Local:" + parami.mhM);
        this.retCode = (f.getLine() + 10000);
        AppMethodBeat.o(148409);
        return -1;
      }
      s.a(this.fileName, parami.mhM, null);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    if (parami.lAW == parami.mgq) {
      this.mjP = true;
    }
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new aii();
    ((d.a)localObject).lBV = new aij();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((d.a)localObject).funcId = 128;
    ((d.a)localObject).lBW = 20;
    ((d.a)localObject).respCmdId = 1000000020;
    this.rr = ((d.a)localObject).bgN();
    localObject = (aii)d.b.b(this.rr.lBR);
    ((aii)localObject).RJQ = parami.clientId;
    ((aii)localObject).HlH = parami.fNu;
    ((aii)localObject).RVD = i;
    ((aii)localObject).Sat = parami.mhM;
    if (ab.Lj(this.fPV))
    {
      ((aii)localObject).RIi = this.fPV;
      ((aii)localObject).Stb = parami.mkY;
    }
    Log.i("MicroMsg.NetSceneDownloadVoice", "[%s]doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { toString(), ((aii)localObject).RJQ, Integer.valueOf(((aii)localObject).HlE), Long.valueOf(((aii)localObject).HlH), Integer.valueOf(((aii)localObject).RVD), Integer.valueOf(((aii)localObject).Sat), ((aii)localObject).RIi, Long.valueOf(((aii)localObject).Stb) });
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(148409);
    return i;
  }
  
  public final int getType()
  {
    return 128;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148413);
    Log.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd[" + toString() + "] file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (aij)d.c.b(((d)params).lBS);
    if (paramArrayOfByte.Stc == 1)
    {
      Log.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.YG(this.fileName);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt3 == -22)
    {
      s.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.IzE.idkeyStat(111L, 231L, 1L, false);
      s.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.IzE.idkeyStat(111L, 230L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + params.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    Log.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.Hnc.Ufv + " fileOff:" + paramArrayOfByte.Sat);
    if (paramArrayOfByte.Hnc.Tkb == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    params = paramArrayOfByte.Hnc.Tkb.toByteArray();
    if (params.length == 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramInt1 = s.bH(this.mjM, this.fileName).A(params, params.length, paramArrayOfByte.Sat);
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    s.a(this.fileName, params, params.length);
    Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.mjM);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd[" + toString() + "] : file:%s ret:%s", new Object[] { this.fileName, Integer.valueOf(paramInt1) });
    if (paramInt1 < 0)
    {
      h.IzE.idkeyStat(111L, 229L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
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
    if (this.mjP) {
      l = 0L;
    }
    this.lAo.startTimer(l);
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
      h.IzE.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(148412);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(148410);
    params = (aii)d.b.b(((d)params).lBR);
    if ((params.HlH == 0L) || (params.RJQ == null) || (params.RJQ.length() == 0) || (params.RVD <= 0) || (params.Sat < 0))
    {
      s.Yb(this.fileName);
      params = q.b.lCy;
      AppMethodBeat.o(148410);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(148410);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148411);
    h.IzE.idkeyStat(111L, 233L, 1L, false);
    s.Yb(this.fileName);
    AppMethodBeat.o(148411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */