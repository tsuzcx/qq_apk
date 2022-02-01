package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
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
  private static ba juj;
  private static List<c> juk;
  private i callback;
  private String dWq;
  public String fileName;
  private MTimerHandler iKj;
  private String jui;
  private boolean jul;
  private boolean jum;
  public int retCode;
  private d rr;
  
  static
  {
    AppMethodBeat.i(148415);
    juj = null;
    juk = new ArrayList();
    AppMethodBeat.o(148415);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(148408);
    this.retCode = 0;
    this.jul = false;
    this.jum = false;
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
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
      this.jui = paramr.jui;
      this.dWq = paramr.dWq;
      Log.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice[%s]:  file[%s] voiceFormat[%s] user[%s]", new Object[] { toString(), this.fileName, this.jui, this.dWq });
      AppMethodBeat.o(148408);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(ba paramba)
  {
    if (juj == null) {
      juj = paramba;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(148405);
    if (!juk.contains(paramc)) {
      juk.add(paramc);
    }
    AppMethodBeat.o(148405);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148406);
    juk.remove(paramc);
    AppMethodBeat.o(148406);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(148407);
    final ca localca = s.Rn(this.fileName);
    if (localca != null)
    {
      if (juj != null) {
        juj.a(localca);
      }
      Iterator localIterator = juk.iterator();
      while (localIterator.hasNext()) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148403);
            this.jun.ah(localca);
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
    parami = s.Ro(this.fileName);
    if ((parami == null) || (!parami.bif()))
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    Log.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + parami.jsp);
    if (!s.Re(this.fileName))
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.QE(this.fileName);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    int i = parami.jqP - parami.jsj;
    if (i <= 0)
    {
      if (parami.status == 5)
      {
        this.jum = true;
        Log.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + parami.jqP + " Local:" + parami.jsj);
        this.retCode = (f.getLine() + 10000);
        AppMethodBeat.o(148409);
        return -1;
      }
      s.a(this.fileName, parami.jsj, null);
      this.retCode = (f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    if (parami.iKP == parami.jqP) {
      this.jul = true;
    }
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ahx();
    ((d.a)localObject).iLO = new ahy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((d.a)localObject).funcId = 128;
    ((d.a)localObject).iLP = 20;
    ((d.a)localObject).respCmdId = 1000000020;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ahx)this.rr.iLK.iLR;
    ((ahx)localObject).KIz = parami.clientId;
    ((ahx)localObject).Brn = parami.dTS;
    ((ahx)localObject).KUy = i;
    ((ahx)localObject).KZk = parami.jsj;
    if (ab.Eq(this.dWq))
    {
      ((ahx)localObject).KGO = this.dWq;
      ((ahx)localObject).LrE = parami.jvv;
    }
    Log.i("MicroMsg.NetSceneDownloadVoice", "[%s]doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { toString(), ((ahx)localObject).KIz, Integer.valueOf(((ahx)localObject).Brl), Long.valueOf(((ahx)localObject).Brn), Integer.valueOf(((ahx)localObject).KUy), Integer.valueOf(((ahx)localObject).KZk), ((ahx)localObject).KGO, Long.valueOf(((ahx)localObject).LrE) });
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
    paramArrayOfByte = (ahy)((d)params).iLL.iLR;
    if (paramArrayOfByte.LrF == 1)
    {
      Log.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.Rj(this.fileName);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt3 == -22)
    {
      s.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.CyF.idkeyStat(111L, 231L, 1L, false);
      s.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.CyF.idkeyStat(111L, 230L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + params.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    Log.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.BsI.getILen() + " fileOff:" + paramArrayOfByte.KZk);
    if (paramArrayOfByte.BsI.getBuffer() == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    params = paramArrayOfByte.BsI.getBuffer().toByteArray();
    if (params.length == 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramInt1 = s.bE(this.jui, this.fileName).write(params, params.length, paramArrayOfByte.KZk);
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    s.a(this.fileName, params, params.length);
    Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.jui);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd[" + toString() + "] : file:%s ret:%s", new Object[] { this.fileName, Integer.valueOf(paramInt1) });
    if (paramInt1 < 0)
    {
      h.CyF.idkeyStat(111L, 229L, 1L, false);
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
    if (this.jul) {
      l = 0L;
    }
    this.iKj.startTimer(l);
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
      h.CyF.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(148412);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(148410);
    params = (ahx)((d)params).iLK.iLR;
    if ((params.Brn == 0L) || (params.KIz == null) || (params.KIz.length() == 0) || (params.KUy <= 0) || (params.KZk < 0))
    {
      s.QE(this.fileName);
      params = q.b.iMr;
      AppMethodBeat.o(148410);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(148410);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148411);
    h.CyF.idkeyStat(111L, 233L, 1L, false);
    s.QE(this.fileName);
    AppMethodBeat.o(148411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */