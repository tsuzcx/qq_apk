package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public final class a
{
  public v2protocal uMs;
  private ap uMt;
  private boolean uMu;
  public boolean uMv;
  public boolean uMw;
  public a uMx;
  
  public a()
  {
    AppMethodBeat.i(25438);
    this.uMu = false;
    this.uMv = false;
    this.uMw = false;
    this.uMx = null;
    this.uMt = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25437);
        if ((paramAnonymousMessage == null) || (paramAnonymousMessage.what != 59998))
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(25437);
          return;
        }
        ad.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        switch (paramAnonymousMessage.arg1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25437);
          return;
          paramAnonymousMessage = a.this;
          ad.d("MicroMsg.IPCallEngineManager", "channel connect!");
          if (paramAnonymousMessage.uMv)
          {
            ad.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(25437);
            return;
          }
          int i = paramAnonymousMessage.uMs.startEngine();
          ad.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramAnonymousMessage.uMs.CfS = 0;; paramAnonymousMessage.uMs.CfS = 1)
          {
            paramAnonymousMessage.uMs.setInactive();
            paramAnonymousMessage.uMv = true;
            if (paramAnonymousMessage.uMx != null) {
              paramAnonymousMessage.uMx.ddd();
            }
            AppMethodBeat.o(25437);
            return;
          }
          ad.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
          AppMethodBeat.o(25437);
          return;
          ad.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
          paramAnonymousMessage = a.this;
          ad.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
          if (paramAnonymousMessage.uMx != null) {
            paramAnonymousMessage.uMx.ddc();
          }
          AppMethodBeat.o(25437);
          return;
          ad.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            ad.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
            a.a(a.this, 34);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 1)
          {
            ad.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
            a.a(a.this, 20);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 5)
          {
            ad.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
            a.a(a.this, 30);
            AppMethodBeat.o(25437);
            return;
            ad.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
            AppMethodBeat.o(25437);
            return;
            ad.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
            ad.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
            paramAnonymousMessage = i.ddG();
            ad.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
            if (paramAnonymousMessage.dDV)
            {
              ad.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
              AppMethodBeat.o(25437);
              return;
            }
            paramAnonymousMessage.uKK = true;
            if (paramAnonymousMessage.uKI != null)
            {
              paramAnonymousMessage.uKI.kHC = 2;
              o localo = new o(paramAnonymousMessage.uKI.roomId, paramAnonymousMessage.uKI.uLt, paramAnonymousMessage.uKI.ddW(), paramAnonymousMessage.uKI.uLu, true);
              ba.aiU().a(localo, 0);
            }
            paramAnonymousMessage.IB(2);
          }
        }
      }
    };
    this.uMs = new v2protocal(this.uMt);
    AppMethodBeat.o(25438);
  }
  
  public final void IC(int paramInt)
  {
    AppMethodBeat.i(25441);
    if (!this.uMv)
    {
      AppMethodBeat.o(25441);
      return;
    }
    ad.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.uMs.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      ad.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(25441);
  }
  
  public final void dea()
  {
    AppMethodBeat.i(25439);
    ad.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.uMv) {
      ad.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.uMs.setActive();
    AppMethodBeat.o(25439);
  }
  
  public final void deb()
  {
    AppMethodBeat.i(25440);
    if (this.uMu)
    {
      ad.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(25440);
      return;
    }
    ad.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    Object localObject1 = i.ddG().uKI;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX != null)
      {
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX);
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ);
        localObject2 = new dyj();
        ((dyj)localObject2).nHv = 0;
        ((dyj)localObject2).Cbn = 0;
        ((dyj)localObject2).Cbm = 0;
        ((dyj)localObject2).userName = "";
        ((dyj)localObject2).dxJ = "";
      }
      ad.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.uMs.Cfk = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLL;
      this.uMs.Cgu = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLO;
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLP != null) {
        this.uMs.Cgv = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLP.toByteArray();
      }
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLM != null) {
        this.uMs.Cfl = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLM.toByteArray();
      }
      this.uMs.roomId = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).roomId;
      this.uMs.uLt = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLt;
      this.uMs.uLA = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLA;
      this.uMs.Cfn = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLJ;
      this.uMs.Cfm = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLK;
      this.uMs.Cfo = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLR;
      if (this.uMs.Cfl != null) {
        break label540;
      }
      i = 0;
      i = this.uMs.setConfigInfo(this.uMs.Cff, this.uMs.roomId, this.uMs.uLA, this.uMs.uLt, this.uMs.field_peerId, 1, this.uMs.Cfm, this.uMs.Cfn, this.uMs.Cfk, i, this.uMs.Cfl, this.uMs.Cfo, 0, 0, this.uMs.Cgu, this.uMs.Cgv, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
      ad.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        break label628;
      }
      Object localObject2 = new ctb();
      ((ctb)localObject2).GcK = 0;
      ((ctb)localObject2).GcL = "";
      ((ctb)localObject2).GcM = "";
      ((ctb)localObject2).GcN = 4;
      ((ctb)localObject2).GcO = 4;
      ((ctb)localObject2).GcP = 2;
      ((ctb)localObject2).Hlp = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX);
      ((ctb)localObject2).Hlq = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ);
      localObject1 = new ctc();
      ((ctc)localObject1).Hlr = 1;
      ((ctc)localObject1).Hls = new LinkedList();
      ((ctc)localObject1).Hls.add(localObject2);
    }
    for (;;)
    {
      try
      {
        this.uMs.CgJ = ((ctc)localObject1).toByteArray();
        if (this.uMs.CgJ == null)
        {
          f.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
          if (this.uMx != null) {
            this.uMx.Iw(21);
          }
          this.uMu = true;
          AppMethodBeat.o(25440);
          return;
          label540:
          i = this.uMs.Cfl.length;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
        continue;
        i = this.uMs.AddNewRelayConns(this.uMs.CgJ, this.uMs.CgJ.length, 0);
        if (i >= 0) {
          continue;
        }
        f.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(i)));
        if (this.uMx == null) {
          continue;
        }
        this.uMx.Iw(21);
        continue;
      }
      label628:
      if (i < 0)
      {
        ad.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.uMx != null) {
          this.uMx.Iw(21);
        }
      }
    }
  }
  
  public final void resetStatus()
  {
    this.uMv = false;
    this.uMu = false;
    this.uMw = false;
  }
  
  public static abstract interface a
  {
    public abstract void Iw(int paramInt);
    
    public abstract void ddc();
    
    public abstract void ddd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.a
 * JD-Core Version:    0.7.0.1
 */