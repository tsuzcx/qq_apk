package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class a
{
  public v2protocal DQH;
  private MMHandler DQI;
  private boolean DQJ;
  public boolean DQK;
  public boolean DQL;
  public a DQM;
  
  public a()
  {
    AppMethodBeat.i(25438);
    this.DQJ = false;
    this.DQK = false;
    this.DQL = false;
    this.DQM = null;
    this.DQI = new MMHandler(Looper.getMainLooper())
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
          if (paramAnonymousMessage.DQK)
          {
            Log.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(25437);
            return;
          }
          int i = paramAnonymousMessage.DQH.startEngine();
          Log.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramAnonymousMessage.DQH.NRt = 0;; paramAnonymousMessage.DQH.NRt = 1)
          {
            paramAnonymousMessage.DQH.setInactive();
            paramAnonymousMessage.DQK = true;
            if (paramAnonymousMessage.DQM != null) {
              paramAnonymousMessage.DQM.eIM();
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
          if (paramAnonymousMessage.DQM != null) {
            paramAnonymousMessage.DQM.eIL();
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
            paramAnonymousMessage = i.eJq();
            Log.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
            if (paramAnonymousMessage.fQy)
            {
              Log.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
              AppMethodBeat.o(25437);
              return;
            }
            paramAnonymousMessage.DPa = true;
            if (paramAnonymousMessage.DOY != null)
            {
              paramAnonymousMessage.DOY.oLS = 2;
              o localo = new o(paramAnonymousMessage.DOY.roomId, paramAnonymousMessage.DOY.DPJ, paramAnonymousMessage.DOY.eJG(), paramAnonymousMessage.DOY.DPK, true);
              bh.aGY().a(localo, 0);
            }
            paramAnonymousMessage.Vl(2);
          }
        }
      }
    };
    this.DQH = new v2protocal(this.DQI);
    AppMethodBeat.o(25438);
  }
  
  public final void Vm(int paramInt)
  {
    AppMethodBeat.i(25441);
    if (!this.DQK)
    {
      AppMethodBeat.o(25441);
      return;
    }
    Log.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.DQH.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      Log.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(25441);
  }
  
  public final void eJK()
  {
    AppMethodBeat.i(25439);
    Log.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.DQK) {
      Log.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.DQH.setActive();
    AppMethodBeat.o(25439);
  }
  
  public final void eJL()
  {
    AppMethodBeat.i(25440);
    if (this.DQJ)
    {
      Log.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(25440);
      return;
    }
    Log.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    Object localObject1 = i.eJq().DOY;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm != null)
      {
        com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm);
        com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg);
        localObject2 = new fes();
        ((fes)localObject2).rZU = 0;
        ((fes)localObject2).NMK = 0;
        ((fes)localObject2).NMJ = 0;
        ((fes)localObject2).userName = "";
        ((fes)localObject2).fJS = "";
      }
      Log.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.DQH.NQM = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQb;
      this.DQH.NRV = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQe;
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQf != null) {
        this.DQH.NRW = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQf.toByteArray();
      }
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQc != null) {
        this.DQH.NQN = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQc.toByteArray();
      }
      this.DQH.roomId = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).roomId;
      this.DQH.DPJ = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DPJ;
      this.DQH.DPQ = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DPQ;
      this.DQH.NQP = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DPZ;
      this.DQH.NQO = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQa;
      this.DQH.NQQ = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQh;
      if (this.DQH.NQN != null) {
        break label541;
      }
      i = 0;
      i = this.DQH.setConfigInfo(this.DQH.NQH, this.DQH.roomId, this.DQH.DPQ, this.DQH.DPJ, this.DQH.field_peerId, 1, this.DQH.NQO, this.DQH.NQP, this.DQH.NQM, i, this.DQH.NQN, this.DQH.NQQ, 0, 0, this.DQH.NRV, this.DQH.NRW, 255, 0, 0, null, 0, 0, 0, 0, "", "", "");
      Log.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        break label629;
      }
      Object localObject2 = new dwc();
      ((dwc)localObject2).Ssu = 0;
      ((dwc)localObject2).Ssv = "";
      ((dwc)localObject2).Ssw = "";
      ((dwc)localObject2).Ssx = 4;
      ((dwc)localObject2).Ssy = 4;
      ((dwc)localObject2).Ssz = 2;
      ((dwc)localObject2).Ucb = com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm);
      ((dwc)localObject2).Ucc = com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg);
      localObject1 = new dwd();
      ((dwd)localObject1).Ucd = 1;
      ((dwd)localObject1).Uce = new LinkedList();
      ((dwd)localObject1).Uce.add(localObject2);
    }
    for (;;)
    {
      try
      {
        this.DQH.NSl = ((dwd)localObject1).toByteArray();
        if (this.DQH.NSl == null)
        {
          e.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
          if (this.DQM != null) {
            this.DQM.Vf(21);
          }
          this.DQJ = true;
          AppMethodBeat.o(25440);
          return;
          label541:
          i = this.DQH.NQN.length;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
        continue;
        i = this.DQH.AddNewRelayConns(this.DQH.NSl, this.DQH.NSl.length, 0);
        if (i >= 0) {
          continue;
        }
        e.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(i)));
        if (this.DQM == null) {
          continue;
        }
        this.DQM.Vf(21);
        continue;
      }
      label629:
      if (i < 0)
      {
        Log.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.DQM != null) {
          this.DQM.Vf(21);
        }
      }
    }
  }
  
  public final void resetStatus()
  {
    this.DQK = false;
    this.DQJ = false;
    this.DQL = false;
  }
  
  public static abstract interface a
  {
    public abstract void Vf(int paramInt);
    
    public abstract void eIL();
    
    public abstract void eIM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.a
 * JD-Core Version:    0.7.0.1
 */