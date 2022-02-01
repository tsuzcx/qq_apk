package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", "startRecord", "stopRecord", "unInit", "Companion", "OnDeviceChangeCallback", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a uLp;
  public final com.tencent.mm.compatible.util.b ixy;
  public b uLl;
  public com.tencent.mm.plugin.ipcall.model.c.a uLm;
  public com.tencent.mm.plugin.ipcall.model.c.c uLn;
  private boolean uLo;
  
  static
  {
    AppMethodBeat.i(194846);
    uLp = new a.a((byte)0);
    AppMethodBeat.o(194846);
  }
  
  public a()
  {
    AppMethodBeat.i(194845);
    this.ixy = new com.tencent.mm.compatible.util.b(aj.getContext());
    com.tencent.mm.plugin.audio.d.a.bGM();
    com.tencent.mm.plugin.audio.d.c.bGM();
    this.ixy.requestFocus();
    this.uLm = new com.tencent.mm.plugin.ipcall.model.c.a(this);
    this.uLn = new com.tencent.mm.plugin.ipcall.model.c.c();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "ipcall");
    AppMethodBeat.o(194845);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(194840);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.VM("ipcall");
    AppMethodBeat.o(194840);
  }
  
  public final void bjO()
  {
    AppMethodBeat.i(194843);
    com.tencent.mm.plugin.ipcall.model.c.c localc = this.uLn;
    if (localc != null)
    {
      localc.bjO();
      AppMethodBeat.o(194843);
      return;
    }
    AppMethodBeat.o(194843);
  }
  
  public final void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(194841);
    com.tencent.mm.plugin.ipcall.model.c.a locala = this.uLm;
    if (locala != null) {
      locala.nJ(paramBoolean);
    }
    this.uLo = isSpeakerphoneOn();
    AppMethodBeat.o(194841);
  }
  
  public final void ddS()
  {
    AppMethodBeat.i(194842);
    cn(this.uLo);
    AppMethodBeat.o(194842);
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(194844);
    super.hC(paramInt);
    switch (paramInt)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(194844);
              return;
              localObject = com.tencent.mm.plugin.audio.c.a.nrV;
              localObject = com.tencent.mm.plugin.audio.d.a.nrY;
            } while ((!com.tencent.mm.plugin.audio.d.a.bGD()) || (this.uLl == null));
            localObject = this.uLl;
            if (localObject != null)
            {
              ((b)localObject).nI(true);
              AppMethodBeat.o(194844);
              return;
            }
            AppMethodBeat.o(194844);
            return;
          } while (xn(3));
          localObject = this.uLl;
          if (localObject != null)
          {
            ((b)localObject).nI(false);
            AppMethodBeat.o(194844);
            return;
          }
          AppMethodBeat.o(194844);
          return;
          ad.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
        } while (xn(4));
        localObject = this.uLl;
        if (localObject != null)
        {
          ((b)localObject).nH(true);
          AppMethodBeat.o(194844);
          return;
        }
        AppMethodBeat.o(194844);
        return;
        ad.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
      } while (xn(4));
      localObject = this.uLl;
    } while (localObject == null);
    ((b)localObject).nH(false);
    AppMethodBeat.o(194844);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"})
  public static abstract interface b
  {
    public abstract void nH(boolean paramBoolean);
    
    public abstract void nI(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a.a
 * JD-Core Version:    0.7.0.1
 */