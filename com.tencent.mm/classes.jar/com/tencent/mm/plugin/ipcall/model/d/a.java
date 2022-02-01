package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.LinkedList;

public final class a
{
  public v2protocal uYf;
  private aq uYg;
  private boolean uYh;
  public boolean uYi;
  public boolean uYj;
  public a uYk;
  
  public a()
  {
    AppMethodBeat.i(25438);
    this.uYh = false;
    this.uYi = false;
    this.uYj = false;
    this.uYk = null;
    this.uYg = new aq(Looper.getMainLooper())
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
        ae.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        switch (paramAnonymousMessage.arg1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25437);
          return;
          paramAnonymousMessage = a.this;
          ae.d("MicroMsg.IPCallEngineManager", "channel connect!");
          if (paramAnonymousMessage.uYi)
          {
            ae.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(25437);
            return;
          }
          int i = paramAnonymousMessage.uYf.startEngine();
          ae.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramAnonymousMessage.uYf.Cxt = 0;; paramAnonymousMessage.uYf.Cxt = 1)
          {
            paramAnonymousMessage.uYf.setInactive();
            paramAnonymousMessage.uYi = true;
            if (paramAnonymousMessage.uYk != null) {
              paramAnonymousMessage.uYk.dfV();
            }
            AppMethodBeat.o(25437);
            return;
          }
          ae.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
          AppMethodBeat.o(25437);
          return;
          ae.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
          paramAnonymousMessage = a.this;
          ae.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
          if (paramAnonymousMessage.uYk != null) {
            paramAnonymousMessage.uYk.dfU();
          }
          AppMethodBeat.o(25437);
          return;
          ae.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            ae.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
            a.a(a.this, 34);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 1)
          {
            ae.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
            a.a(a.this, 20);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 5)
          {
            ae.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
            a.a(a.this, 30);
            AppMethodBeat.o(25437);
            return;
            ae.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
            AppMethodBeat.o(25437);
            return;
            ae.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
            ae.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
            paramAnonymousMessage = i.dgy();
            ae.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
            if (paramAnonymousMessage.dFa)
            {
              ae.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
              AppMethodBeat.o(25437);
              return;
            }
            paramAnonymousMessage.uWx = true;
            if (paramAnonymousMessage.uWv != null)
            {
              paramAnonymousMessage.uWv.kKR = 2;
              o localo = new o(paramAnonymousMessage.uWv.roomId, paramAnonymousMessage.uWv.uXg, paramAnonymousMessage.uWv.dgO(), paramAnonymousMessage.uWv.uXh, true);
              bc.ajj().a(localo, 0);
            }
            paramAnonymousMessage.IZ(2);
          }
        }
      }
    };
    this.uYf = new v2protocal(this.uYg);
    AppMethodBeat.o(25438);
  }
  
  public final void Ja(int paramInt)
  {
    AppMethodBeat.i(25441);
    if (!this.uYi)
    {
      AppMethodBeat.o(25441);
      return;
    }
    ae.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.uYf.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      ae.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(25441);
  }
  
  public final void dgS()
  {
    AppMethodBeat.i(25439);
    ae.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.uYi) {
      ae.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.uYf.setActive();
    AppMethodBeat.o(25439);
  }
  
  public final void dgT()
  {
    AppMethodBeat.i(25440);
    if (this.uYh)
    {
      ae.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(25440);
      return;
    }
    ae.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    Object localObject1 = i.dgy().uWv;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs != null)
      {
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs);
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD);
        localObject2 = new eaa();
        ((eaa)localObject2).nMX = 0;
        ((eaa)localObject2).CsO = 0;
        ((eaa)localObject2).CsN = 0;
        ((eaa)localObject2).userName = "";
        ((eaa)localObject2).dyO = "";
      }
      ae.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.uYf.CwL = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXy;
      this.uYf.CxV = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXB;
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXC != null) {
        this.uYf.CxW = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXC.toByteArray();
      }
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXz != null) {
        this.uYf.CwM = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXz.toByteArray();
      }
      this.uYf.roomId = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).roomId;
      this.uYf.uXg = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXg;
      this.uYf.uXn = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXn;
      this.uYf.CwO = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXw;
      this.uYf.CwN = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXx;
      this.uYf.CwP = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXE;
      if (this.uYf.CwM != null) {
        break label540;
      }
      i = 0;
      i = this.uYf.setConfigInfo(this.uYf.CwG, this.uYf.roomId, this.uYf.uXn, this.uYf.uXg, this.uYf.field_peerId, 1, this.uYf.CwN, this.uYf.CwO, this.uYf.CwL, i, this.uYf.CwM, this.uYf.CwP, 0, 0, this.uYf.CxV, this.uYf.CxW, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
      ae.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        break label628;
      }
      Object localObject2 = new ctv();
      ((ctv)localObject2).Gvr = 0;
      ((ctv)localObject2).Gvs = "";
      ((ctv)localObject2).Gvt = "";
      ((ctv)localObject2).Gvu = 4;
      ((ctv)localObject2).Gvv = 4;
      ((ctv)localObject2).Gvw = 2;
      ((ctv)localObject2).HEP = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs);
      ((ctv)localObject2).HEQ = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD);
      localObject1 = new ctw();
      ((ctw)localObject1).HER = 1;
      ((ctw)localObject1).HES = new LinkedList();
      ((ctw)localObject1).HES.add(localObject2);
    }
    for (;;)
    {
      try
      {
        this.uYf.Cyk = ((ctw)localObject1).toByteArray();
        if (this.uYf.Cyk == null)
        {
          f.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
          if (this.uYk != null) {
            this.uYk.IU(21);
          }
          this.uYh = true;
          AppMethodBeat.o(25440);
          return;
          label540:
          i = this.uYf.CwM.length;
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
        continue;
        i = this.uYf.AddNewRelayConns(this.uYf.Cyk, this.uYf.Cyk.length, 0);
        if (i >= 0) {
          continue;
        }
        f.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(i)));
        if (this.uYk == null) {
          continue;
        }
        this.uYk.IU(21);
        continue;
      }
      label628:
      if (i < 0)
      {
        ae.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.uYk != null) {
          this.uYk.IU(21);
        }
      }
    }
  }
  
  public final void resetStatus()
  {
    this.uYi = false;
    this.uYh = false;
    this.uYj = false;
  }
  
  public static abstract interface a
  {
    public abstract void IU(int paramInt);
    
    public abstract void dfU();
    
    public abstract void dfV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.a
 * JD-Core Version:    0.7.0.1
 */