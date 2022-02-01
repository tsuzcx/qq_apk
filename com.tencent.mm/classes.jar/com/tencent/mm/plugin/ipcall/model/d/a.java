package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.LinkedList;

public final class a
{
  public v2protocal tJF;
  private ao tJG;
  private boolean tJH;
  public boolean tJI;
  public boolean tJJ;
  public a tJK;
  
  public a()
  {
    AppMethodBeat.i(25438);
    this.tJH = false;
    this.tJI = false;
    this.tJJ = false;
    this.tJK = null;
    this.tJG = new ao(Looper.getMainLooper())
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
        ac.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        switch (paramAnonymousMessage.arg1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25437);
          return;
          paramAnonymousMessage = a.this;
          ac.d("MicroMsg.IPCallEngineManager", "channel connect!");
          if (paramAnonymousMessage.tJI)
          {
            ac.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(25437);
            return;
          }
          int i = paramAnonymousMessage.tJF.startEngine();
          ac.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramAnonymousMessage.tJF.AGR = 0;; paramAnonymousMessage.tJF.AGR = 1)
          {
            paramAnonymousMessage.tJF.setInactive();
            paramAnonymousMessage.tJI = true;
            if (paramAnonymousMessage.tJK != null) {
              paramAnonymousMessage.tJK.cTS();
            }
            AppMethodBeat.o(25437);
            return;
          }
          ac.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
          AppMethodBeat.o(25437);
          return;
          ac.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
          paramAnonymousMessage = a.this;
          ac.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
          if (paramAnonymousMessage.tJK != null) {
            paramAnonymousMessage.tJK.cTR();
          }
          AppMethodBeat.o(25437);
          return;
          ac.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            ac.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
            a.a(a.this, 34);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 1)
          {
            ac.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
            a.a(a.this, 20);
            AppMethodBeat.o(25437);
            return;
          }
          if (paramAnonymousMessage.arg2 == 5)
          {
            ac.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
            a.a(a.this, 30);
            AppMethodBeat.o(25437);
            return;
            ac.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
            AppMethodBeat.o(25437);
            return;
            ac.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
            ac.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
            paramAnonymousMessage = i.cUv();
            ac.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
            if (paramAnonymousMessage.dsb)
            {
              ac.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
              AppMethodBeat.o(25437);
              return;
            }
            paramAnonymousMessage.tHX = true;
            if (paramAnonymousMessage.tHV != null)
            {
              paramAnonymousMessage.tHV.kmC = 2;
              o localo = new o(paramAnonymousMessage.tHV.roomId, paramAnonymousMessage.tHV.tIG, paramAnonymousMessage.tHV.cUL(), paramAnonymousMessage.tHV.tIH, true);
              az.agi().a(localo, 0);
            }
            paramAnonymousMessage.Hf(2);
          }
        }
      }
    };
    this.tJF = new v2protocal(this.tJG);
    AppMethodBeat.o(25438);
  }
  
  public final void Hg(int paramInt)
  {
    AppMethodBeat.i(25441);
    if (!this.tJI)
    {
      AppMethodBeat.o(25441);
      return;
    }
    ac.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.tJF.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      ac.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(25441);
  }
  
  public final void cUP()
  {
    AppMethodBeat.i(25439);
    ac.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.tJI) {
      ac.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.tJF.setActive();
    AppMethodBeat.o(25439);
  }
  
  public final void cUQ()
  {
    AppMethodBeat.i(25440);
    if (this.tJH)
    {
      ac.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(25440);
      return;
    }
    ac.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    Object localObject1 = i.cUv().tHV;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA != null)
      {
        com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA);
        com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd);
        localObject2 = new dsp();
        ((dsp)localObject2).ngZ = 0;
        ((dsp)localObject2).ACo = 0;
        ((dsp)localObject2).ACn = 0;
        ((dsp)localObject2).userName = "";
        ((dsp)localObject2).dlV = "";
      }
      ac.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.tJF.AGk = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tIY;
      this.tJF.AHt = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJb;
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJc != null) {
        this.tJF.AHu = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJc.toByteArray();
      }
      if (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tIZ != null) {
        this.tJF.AGl = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tIZ.toByteArray();
      }
      this.tJF.roomId = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).roomId;
      this.tJF.tIG = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tIG;
      this.tJF.tIN = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tIN;
      this.tJF.AGn = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tIW;
      this.tJF.AGm = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tIX;
      this.tJF.AGo = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJe;
      if (this.tJF.AGl != null) {
        break label540;
      }
      i = 0;
      i = this.tJF.setConfigInfo(this.tJF.AGf, this.tJF.roomId, this.tJF.tIN, this.tJF.tIG, this.tJF.field_peerId, 1, this.tJF.AGm, this.tJF.AGn, this.tJF.AGk, i, this.tJF.AGl, this.tJF.AGo, 0, 0, this.tJF.AHt, this.tJF.AHu, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
      ac.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i != 0) {
        break label628;
      }
      Object localObject2 = new cny();
      ((cny)localObject2).Evo = 0;
      ((cny)localObject2).Evp = "";
      ((cny)localObject2).Evq = "";
      ((cny)localObject2).Evr = 4;
      ((cny)localObject2).Evs = 4;
      ((cny)localObject2).Evt = 2;
      ((cny)localObject2).FBc = com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA);
      ((cny)localObject2).FBd = com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd);
      localObject1 = new cnz();
      ((cnz)localObject1).FBe = 1;
      ((cnz)localObject1).FBf = new LinkedList();
      ((cnz)localObject1).FBf.add(localObject2);
    }
    for (;;)
    {
      try
      {
        this.tJF.AHI = ((cnz)localObject1).toByteArray();
        if (this.tJF.AHI == null)
        {
          d.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
          if (this.tJK != null) {
            this.tJK.Ha(21);
          }
          this.tJH = true;
          AppMethodBeat.o(25440);
          return;
          label540:
          i = this.tJF.AGl.length;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
        continue;
        i = this.tJF.AddNewRelayConns(this.tJF.AHI, this.tJF.AHI.length, 0);
        if (i >= 0) {
          continue;
        }
        d.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(i)));
        if (this.tJK == null) {
          continue;
        }
        this.tJK.Ha(21);
        continue;
      }
      label628:
      if (i < 0)
      {
        ac.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.tJK != null) {
          this.tJK.Ha(21);
        }
      }
    }
  }
  
  public final void resetStatus()
  {
    this.tJI = false;
    this.tJH = false;
    this.tJJ = false;
  }
  
  public static abstract interface a
  {
    public abstract void Ha(int paramInt);
    
    public abstract void cTR();
    
    public abstract void cTS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.a
 * JD-Core Version:    0.7.0.1
 */