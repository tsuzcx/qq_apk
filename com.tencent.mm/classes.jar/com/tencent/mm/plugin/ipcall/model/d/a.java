package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.gbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class a
{
  public v2protocal JHR;
  private MMHandler JHS;
  private boolean JHT;
  public boolean JHU;
  public boolean JHV;
  public a JHW;
  
  public a()
  {
    AppMethodBeat.i(25438);
    this.JHT = false;
    this.JHU = false;
    this.JHV = false;
    this.JHW = null;
    this.JHS = new MMHandler(Looper.getMainLooper())
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
        Log.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        switch (paramAnonymousMessage.arg1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25437);
          return;
          paramAnonymousMessage = a.this;
          Log.d("MicroMsg.IPCallEngineManager", "channel connect!");
          if (paramAnonymousMessage.JHU)
          {
            Log.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(25437);
            return;
          }
          int i = paramAnonymousMessage.JHR.startEngine();
          Log.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramAnonymousMessage.JHR.UEy = 0;; paramAnonymousMessage.JHR.UEy = 1)
          {
            paramAnonymousMessage.JHR.setInactive();
            paramAnonymousMessage.JHU = true;
            if (paramAnonymousMessage.JHW != null) {
              paramAnonymousMessage.JHW.fQM();
            }
            AppMethodBeat.o(25437);
            return;
          }
          Log.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
          AppMethodBeat.o(25437);
          return;
          Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
          paramAnonymousMessage = a.this;
          Log.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
          if (paramAnonymousMessage.JHW != null) {
            paramAnonymousMessage.JHW.fQL();
          }
          AppMethodBeat.o(25437);
          return;
          Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            Log.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
            a.a(a.this, 34);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 1)
          {
            Log.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
            a.a(a.this, 20);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 5)
          {
            Log.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
            a.a(a.this, 30);
            AppMethodBeat.o(25437);
            return;
            Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
            AppMethodBeat.o(25437);
            return;
            Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
            Log.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
            paramAnonymousMessage = h.fRq();
            Log.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
            if (paramAnonymousMessage.hWt)
            {
              Log.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
              AppMethodBeat.o(25437);
              return;
            }
            paramAnonymousMessage.JGp = true;
            if (paramAnonymousMessage.JGn != null)
            {
              paramAnonymousMessage.JGn.rPN = 2;
              o localo = new o(paramAnonymousMessage.JGn.roomId, paramAnonymousMessage.JGn.Hnt, paramAnonymousMessage.JGn.fRH(), paramAnonymousMessage.JGn.JGV, true);
              bh.aZW().a(localo, 0);
            }
            paramAnonymousMessage.Zg(2);
          }
        }
      }
    };
    this.JHR = new v2protocal(this.JHS);
    AppMethodBeat.o(25438);
  }
  
  public final void Zh(int paramInt)
  {
    AppMethodBeat.i(25441);
    if (!this.JHU)
    {
      AppMethodBeat.o(25441);
      return;
    }
    Log.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.JHR.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      Log.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(25441);
  }
  
  public final void fRK()
  {
    AppMethodBeat.i(25439);
    Log.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.JHU) {
      Log.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.JHR.setActive();
    AppMethodBeat.o(25439);
  }
  
  public final void fRL()
  {
    AppMethodBeat.i(25440);
    if (this.JHT)
    {
      Log.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(25440);
      return;
    }
    Log.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    Object localObject1 = h.fRq().JGn;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA != null)
      {
        com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA);
        com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr);
        localObject2 = new gbe();
        ((gbe)localObject2).vll = 0;
        ((gbe)localObject2).Uzy = 0;
        ((gbe)localObject2).Uzx = 0;
        ((gbe)localObject2).userName = "";
        ((gbe)localObject2).hPy = "";
      }
      Log.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.JHR.UDy = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHm;
      this.JHR.UFa = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHp;
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHq != null) {
        this.JHR.UFb = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHq.toByteArray();
      }
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHn != null) {
        this.JHR.UDz = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHn.toByteArray();
      }
      this.JHR.roomId = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).roomId;
      this.JHR.Hnt = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).Hnt;
      this.JHR.JHb = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHb;
      this.JHR.UDB = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHk;
      this.JHR.UDA = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHl;
      this.JHR.UDC = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHs;
      if (this.JHR.UDz != null) {
        break label541;
      }
      i = 0;
      i = this.JHR.setConfigInfo(this.JHR.UDt, this.JHR.roomId, this.JHR.JHb, this.JHR.Hnt, this.JHR.field_peerId, 1, this.JHR.UDA, this.JHR.UDB, this.JHR.UDy, i, this.JHR.UDz, this.JHR.UDC, 0, 0, this.JHR.UFa, this.JHR.UFb, 255, 0, 0, null, 0, 0, 0, 0, "", "", "");
      Log.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        break label629;
      }
      Object localObject2 = new epe();
      ((epe)localObject2).ZrC = 0;
      ((epe)localObject2).ZrD = "";
      ((epe)localObject2).ZrE = "";
      ((epe)localObject2).ZrF = 4;
      ((epe)localObject2).ZrG = 4;
      ((epe)localObject2).ZrH = 2;
      ((epe)localObject2).abto = com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA);
      ((epe)localObject2).abtp = com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr);
      localObject1 = new epf();
      ((epf)localObject1).abtq = 1;
      ((epf)localObject1).abtr = new LinkedList();
      ((epf)localObject1).abtr.add(localObject2);
    }
    for (;;)
    {
      try
      {
        this.JHR.UFq = ((epf)localObject1).toByteArray();
        if (this.JHR.UFq == null)
        {
          com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
          if (this.JHW != null) {
            this.JHW.Za(21);
          }
          this.JHT = true;
          AppMethodBeat.o(25440);
          return;
          label541:
          i = this.JHR.UDz.length;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
        continue;
        i = this.JHR.AddNewRelayConns(this.JHR.UFq, this.JHR.UFq.length, 0);
        if (i >= 0) {
          continue;
        }
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(i)));
        if (this.JHW == null) {
          continue;
        }
        this.JHW.Za(21);
        continue;
      }
      label629:
      if (i < 0)
      {
        Log.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.JHW != null) {
          this.JHW.Za(21);
        }
      }
    }
  }
  
  public final void resetStatus()
  {
    this.JHU = false;
    this.JHT = false;
    this.JHV = false;
  }
  
  public static abstract interface a
  {
    public abstract void Za(int paramInt);
    
    public abstract void fQL();
    
    public abstract void fQM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.a
 * JD-Core Version:    0.7.0.1
 */