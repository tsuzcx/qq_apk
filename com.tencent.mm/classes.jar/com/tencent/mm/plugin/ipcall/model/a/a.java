package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.ipcall.model.c.c.2;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", "startRecord", "stopRecord", "unInit", "Companion", "OnDeviceChangeCallback", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a JGN;
  public b JGO;
  public com.tencent.mm.plugin.ipcall.model.c.a JGP;
  public com.tencent.mm.plugin.ipcall.model.c.c JGQ;
  private boolean JGR;
  public final com.tencent.mm.compatible.util.b peV;
  
  static
  {
    AppMethodBeat.i(303693);
    JGN = new a.a((byte)0);
    AppMethodBeat.o(303693);
  }
  
  public a()
  {
    AppMethodBeat.i(303690);
    this.peV = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
    this.peV.requestFocus();
    this.JGP = new com.tencent.mm.plugin.ipcall.model.c.a(this);
    this.JGQ = new com.tencent.mm.plugin.ipcall.model.c.c();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "ipcall");
    AppMethodBeat.o(303690);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(303692);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.ahu("ipcall");
    AppMethodBeat.o(303692);
  }
  
  public final void dpe()
  {
    AppMethodBeat.i(303697);
    com.tencent.mm.plugin.ipcall.model.c.c localc = this.JGQ;
    if (localc != null)
    {
      if (localc.isStart)
      {
        Log.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
        AppMethodBeat.o(303697);
        return;
      }
      Log.i("MicroMsg.IPCallRecorder", "start record");
      localc.isStart = true;
      localc.JHI = h.fRt().JHB.JGP.JHz;
      if (localc.JHI <= 10)
      {
        if (localc.JHI <= 0)
        {
          Log.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
          h.fRs().fRP();
        }
        localc.JHI = 92;
      }
      synchronized (localc.hvC)
      {
        ThreadPool.post(new c.2(localc), "IPCallRecorder_startRecord");
        AppMethodBeat.o(303697);
        return;
      }
    }
    AppMethodBeat.o(303697);
  }
  
  public final void ee(boolean paramBoolean)
  {
    AppMethodBeat.i(303694);
    com.tencent.mm.plugin.ipcall.model.c.a locala = this.JGP;
    com.tencent.mm.plugin.ipcall.model.d.a locala1;
    if (locala != null)
    {
      Log.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(locala.JHA), Boolean.valueOf(paramBoolean) });
      locala.JHB.lN(paramBoolean);
      locala1 = h.fRr();
      if (!paramBoolean) {
        break label149;
      }
    }
    label149:
    for (int i = locala1.JHR.setAppCmd(401);; i = locala1.JHR.setAppCmd(402))
    {
      if (i < 0) {
        Log.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != locala.JHA)
      {
        locala.JHA = paramBoolean;
        if ((locala.wTy != null) && (locala.wTy.UvL)) {
          locala.wTy.Gj(paramBoolean);
        }
      }
      this.JGR = cTU();
      AppMethodBeat.o(303694);
      return;
    }
  }
  
  public final void fRC()
  {
    AppMethodBeat.i(303696);
    ee(this.JGR);
    AppMethodBeat.o(303696);
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(303698);
    super.nW(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(303698);
      return;
      Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      if ((com.tencent.mm.plugin.audio.d.b.cTX()) && (this.JGO != null))
      {
        localObject = this.JGO;
        if (localObject != null)
        {
          ((b)localObject).xI(true);
          AppMethodBeat.o(303698);
          return;
          if (!Fa(3))
          {
            localObject = this.JGO;
            if (localObject != null)
            {
              ((b)localObject).xI(false);
              AppMethodBeat.o(303698);
              return;
              Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
              if (!Fa(4))
              {
                localObject = this.JGO;
                if (localObject != null)
                {
                  ((b)localObject).xH(true);
                  AppMethodBeat.o(303698);
                  return;
                  Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
                  if (!Fa(4))
                  {
                    localObject = this.JGO;
                    if (localObject != null) {
                      ((b)localObject).xH(false);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void xH(boolean paramBoolean);
    
    public abstract void xI(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a.a
 * JD-Core Version:    0.7.0.1
 */