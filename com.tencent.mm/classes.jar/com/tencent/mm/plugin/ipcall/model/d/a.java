package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.euh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class a
{
  public v2protocal yqF;
  private MMHandler yqG;
  private boolean yqH;
  public boolean yqI;
  public boolean yqJ;
  public a yqK;
  
  public a()
  {
    AppMethodBeat.i(25438);
    this.yqH = false;
    this.yqI = false;
    this.yqJ = false;
    this.yqK = null;
    this.yqG = new MMHandler(Looper.getMainLooper())
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
          if (paramAnonymousMessage.yqI)
          {
            Log.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(25437);
            return;
          }
          int i = paramAnonymousMessage.yqF.startEngine();
          Log.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramAnonymousMessage.yqF.Hbh = 0;; paramAnonymousMessage.yqF.Hbh = 1)
          {
            paramAnonymousMessage.yqF.setInactive();
            paramAnonymousMessage.yqI = true;
            if (paramAnonymousMessage.yqK != null) {
              paramAnonymousMessage.yqK.dZP();
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
          if (paramAnonymousMessage.yqK != null) {
            paramAnonymousMessage.yqK.dZO();
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
            paramAnonymousMessage = i.eas();
            Log.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
            if (paramAnonymousMessage.dWM)
            {
              Log.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
              AppMethodBeat.o(25437);
              return;
            }
            paramAnonymousMessage.yoY = true;
            if (paramAnonymousMessage.yoW != null)
            {
              paramAnonymousMessage.yoW.lPy = 2;
              o localo = new o(paramAnonymousMessage.yoW.roomId, paramAnonymousMessage.yoW.ypH, paramAnonymousMessage.yoW.eaI(), paramAnonymousMessage.yoW.ypI, true);
              bg.azz().a(localo, 0);
            }
            paramAnonymousMessage.Pc(2);
          }
        }
      }
    };
    this.yqF = new v2protocal(this.yqG);
    AppMethodBeat.o(25438);
  }
  
  public final void Pd(int paramInt)
  {
    AppMethodBeat.i(25441);
    if (!this.yqI)
    {
      AppMethodBeat.o(25441);
      return;
    }
    Log.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.yqF.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      Log.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(25441);
  }
  
  public final void eaM()
  {
    AppMethodBeat.i(25439);
    Log.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.yqI) {
      Log.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.yqF.setActive();
    AppMethodBeat.o(25439);
  }
  
  public final void eaN()
  {
    AppMethodBeat.i(25440);
    if (this.yqH)
    {
      Log.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(25440);
      return;
    }
    Log.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    Object localObject1 = i.eas().yoW;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr != null)
      {
        com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr);
        com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe);
        localObject2 = new euh();
        ((euh)localObject2).oXT = 0;
        ((euh)localObject2).GWx = 0;
        ((euh)localObject2).GWw = 0;
        ((euh)localObject2).userName = "";
        ((euh)localObject2).dQC = "";
      }
      Log.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.yqF.HaA = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).ypZ;
      this.yqF.HbJ = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqc;
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqd != null) {
        this.yqF.HbK = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqd.toByteArray();
      }
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqa != null) {
        this.yqF.HaB = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqa.toByteArray();
      }
      this.yqF.roomId = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).roomId;
      this.yqF.ypH = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).ypH;
      this.yqF.ypO = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).ypO;
      this.yqF.HaD = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).ypX;
      this.yqF.HaC = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).ypY;
      this.yqF.HaE = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqf;
      if (this.yqF.HaB != null) {
        break label540;
      }
      i = 0;
      i = this.yqF.setConfigInfo(this.yqF.Hav, this.yqF.roomId, this.yqF.ypO, this.yqF.ypH, this.yqF.field_peerId, 1, this.yqF.HaC, this.yqF.HaD, this.yqF.HaA, i, this.yqF.HaB, this.yqF.HaE, 0, 0, this.yqF.HbJ, this.yqF.HbK, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
      Log.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        break label628;
      }
      Object localObject2 = new dml();
      ((dml)localObject2).LqX = 0;
      ((dml)localObject2).LqY = "";
      ((dml)localObject2).LqZ = "";
      ((dml)localObject2).Lra = 4;
      ((dml)localObject2).Lrb = 4;
      ((dml)localObject2).Lrc = 2;
      ((dml)localObject2).MPX = com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr);
      ((dml)localObject2).MPY = com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe);
      localObject1 = new dmm();
      ((dmm)localObject1).MPZ = 1;
      ((dmm)localObject1).MQa = new LinkedList();
      ((dmm)localObject1).MQa.add(localObject2);
    }
    for (;;)
    {
      try
      {
        this.yqF.HbZ = ((dmm)localObject1).toByteArray();
        if (this.yqF.HbZ == null)
        {
          e.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
          if (this.yqK != null) {
            this.yqK.OX(21);
          }
          this.yqH = true;
          AppMethodBeat.o(25440);
          return;
          label540:
          i = this.yqF.HaB.length;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
        continue;
        i = this.yqF.AddNewRelayConns(this.yqF.HbZ, this.yqF.HbZ.length, 0);
        if (i >= 0) {
          continue;
        }
        e.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(i)));
        if (this.yqK == null) {
          continue;
        }
        this.yqK.OX(21);
        continue;
      }
      label628:
      if (i < 0)
      {
        Log.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.yqK != null) {
          this.yqK.OX(21);
        }
      }
    }
  }
  
  public final void resetStatus()
  {
    this.yqI = false;
    this.yqH = false;
    this.yqJ = false;
  }
  
  public static abstract interface a
  {
    public abstract void OX(int paramInt);
    
    public abstract void dZO();
    
    public abstract void dZP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.a
 * JD-Core Version:    0.7.0.1
 */