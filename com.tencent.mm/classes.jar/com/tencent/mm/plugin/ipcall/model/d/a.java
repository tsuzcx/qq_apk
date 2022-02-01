package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.dmy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public final class a
{
  public v2protocal sBX;
  private ap sBY;
  private boolean sBZ;
  public boolean sCa;
  public boolean sCb;
  public a sCc;
  
  public a()
  {
    AppMethodBeat.i(25438);
    this.sBZ = false;
    this.sCa = false;
    this.sCb = false;
    this.sCc = null;
    this.sBY = new ap(Looper.getMainLooper())
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
          if (paramAnonymousMessage.sCa)
          {
            ad.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(25437);
            return;
          }
          int i = paramAnonymousMessage.sBX.startEngine();
          ad.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramAnonymousMessage.sBX.zoc = 0;; paramAnonymousMessage.sBX.zoc = 1)
          {
            paramAnonymousMessage.sBX.setInactive();
            paramAnonymousMessage.sCa = true;
            if (paramAnonymousMessage.sCc != null) {
              paramAnonymousMessage.sCc.cGI();
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
          if (paramAnonymousMessage.sCc != null) {
            paramAnonymousMessage.sCc.cGH();
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
            paramAnonymousMessage = i.cHk();
            ad.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
            if (paramAnonymousMessage.duq)
            {
              ad.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
              AppMethodBeat.o(25437);
              return;
            }
            paramAnonymousMessage.sAn = true;
            if (paramAnonymousMessage.sAl != null)
            {
              paramAnonymousMessage.sAl.jMb = 2;
              o localo = new o(paramAnonymousMessage.sAl.roomId, paramAnonymousMessage.sAl.sAY, paramAnonymousMessage.sAl.cHA(), paramAnonymousMessage.sAl.sAZ, true);
              az.aeS().a(localo, 0);
            }
            paramAnonymousMessage.Fk(2);
          }
        }
      }
    };
    this.sBX = new v2protocal(this.sBY);
    AppMethodBeat.o(25438);
  }
  
  public final void Fl(int paramInt)
  {
    AppMethodBeat.i(25441);
    if (!this.sCa)
    {
      AppMethodBeat.o(25441);
      return;
    }
    ad.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.sBX.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      ad.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(25441);
  }
  
  public final void cHE()
  {
    AppMethodBeat.i(25439);
    ad.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.sCa) {
      ad.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.sBX.setActive();
    AppMethodBeat.o(25439);
  }
  
  public final void cHF()
  {
    AppMethodBeat.i(25440);
    if (this.sBZ)
    {
      ad.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(25440);
      return;
    }
    ad.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    Object localObject1 = i.cHk().sAl;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty != null)
      {
        com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty);
        com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv);
        localObject2 = new dmy();
        ((dmy)localObject2).mEU = 0;
        ((dmy)localObject2).zjE = 0;
        ((dmy)localObject2).zjD = 0;
        ((dmy)localObject2).userName = "";
        ((dmy)localObject2).dom = "";
      }
      ad.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.sBX.znw = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBq;
      this.sBX.zoE = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBt;
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBu != null) {
        this.sBX.zoF = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBu.toByteArray();
      }
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBr != null) {
        this.sBX.znx = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBr.toByteArray();
      }
      this.sBX.roomId = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).roomId;
      this.sBX.sAY = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sAY;
      this.sBX.sBf = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBf;
      this.sBX.znz = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBo;
      this.sBX.zny = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBp;
      this.sBX.znA = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBw;
      if (this.sBX.znx != null) {
        break label540;
      }
      i = 0;
      i = this.sBX.setConfigInfo(this.sBX.znr, this.sBX.roomId, this.sBX.sBf, this.sBX.sAY, this.sBX.field_peerId, 1, this.sBX.zny, this.sBX.znz, this.sBX.znw, i, this.sBX.znx, this.sBX.znA, 0, 0, this.sBX.zoE, this.sBX.zoF, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
      ad.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        break label628;
      }
      Object localObject2 = new cir();
      ((cir)localObject2).Dch = 0;
      ((cir)localObject2).Dci = "";
      ((cir)localObject2).Dcj = "";
      ((cir)localObject2).Dck = 4;
      ((cir)localObject2).Dcl = 4;
      ((cir)localObject2).Dcm = 2;
      ((cir)localObject2).Eec = com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty);
      ((cir)localObject2).Eed = com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv);
      localObject1 = new cis();
      ((cis)localObject1).Eee = 1;
      ((cis)localObject1).Eef = new LinkedList();
      ((cis)localObject1).Eef.add(localObject2);
    }
    for (;;)
    {
      try
      {
        this.sBX.zoT = ((cis)localObject1).toByteArray();
        if (this.sBX.zoT == null)
        {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
          if (this.sCc != null) {
            this.sCc.Ff(21);
          }
          this.sBZ = true;
          AppMethodBeat.o(25440);
          return;
          label540:
          i = this.sBX.znx.length;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
        continue;
        i = this.sBX.AddNewRelayConns(this.sBX.zoT, this.sBX.zoT.length, 0);
        if (i >= 0) {
          continue;
        }
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(i)));
        if (this.sCc == null) {
          continue;
        }
        this.sCc.Ff(21);
        continue;
      }
      label628:
      if (i < 0)
      {
        ad.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.sCc != null) {
          this.sCc.Ff(21);
        }
      }
    }
  }
  
  public final void resetStatus()
  {
    this.sCa = false;
    this.sBZ = false;
    this.sCb = false;
  }
  
  public static abstract interface a
  {
    public abstract void Ff(int paramInt);
    
    public abstract void cGH();
    
    public abstract void cGI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.a
 * JD-Core Version:    0.7.0.1
 */