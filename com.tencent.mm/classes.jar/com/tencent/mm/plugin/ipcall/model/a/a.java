package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.ipcall.model.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", "startRecord", "stopRecord", "unInit", "Companion", "OnDeviceChangeCallback", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a DPF;
  public b DPB;
  public com.tencent.mm.plugin.ipcall.model.c.a DPC;
  public c DPD;
  private boolean DPE;
  public final com.tencent.mm.compatible.util.b mlj;
  
  static
  {
    AppMethodBeat.i(292412);
    DPF = new a.a((byte)0);
    AppMethodBeat.o(292412);
  }
  
  public a()
  {
    AppMethodBeat.i(292411);
    this.mlj = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
    this.mlj.avy();
    this.DPC = new com.tencent.mm.plugin.ipcall.model.c.a(this);
    this.DPD = new c();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "ipcall");
    AppMethodBeat.o(292411);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(292406);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.anX("ipcall");
    AppMethodBeat.o(292406);
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(292409);
    c localc = this.DPD;
    if (localc != null)
    {
      localc.bRC();
      AppMethodBeat.o(292409);
      return;
    }
    AppMethodBeat.o(292409);
  }
  
  public final void ds(boolean paramBoolean)
  {
    AppMethodBeat.i(292407);
    com.tencent.mm.plugin.ipcall.model.c.a locala = this.DPC;
    if (locala != null) {
      locala.ty(paramBoolean);
    }
    this.DPE = crl();
    AppMethodBeat.o(292407);
  }
  
  public final void eJC()
  {
    AppMethodBeat.i(292408);
    ds(this.DPE);
    AppMethodBeat.o(292408);
  }
  
  public final void ko(int paramInt)
  {
    AppMethodBeat.i(292410);
    super.ko(paramInt);
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
              AppMethodBeat.o(292410);
              return;
              localObject = com.tencent.mm.plugin.audio.c.a.rJX;
              localObject = com.tencent.mm.plugin.audio.d.b.rKe;
            } while ((!com.tencent.mm.plugin.audio.d.b.cro()) || (this.DPB == null));
            localObject = this.DPB;
            if (localObject != null)
            {
              ((b)localObject).tx(true);
              AppMethodBeat.o(292410);
              return;
            }
            AppMethodBeat.o(292410);
            return;
          } while (Ez(3));
          localObject = this.DPB;
          if (localObject != null)
          {
            ((b)localObject).tx(false);
            AppMethodBeat.o(292410);
            return;
          }
          AppMethodBeat.o(292410);
          return;
          Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
        } while (Ez(4));
        localObject = this.DPB;
        if (localObject != null)
        {
          ((b)localObject).tw(true);
          AppMethodBeat.o(292410);
          return;
        }
        AppMethodBeat.o(292410);
        return;
        Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
      } while (Ez(4));
      localObject = this.DPB;
    } while (localObject == null);
    ((b)localObject).tw(false);
    AppMethodBeat.o(292410);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"})
  public static abstract interface b
  {
    public abstract void tw(boolean paramBoolean);
    
    public abstract void tx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a.a
 * JD-Core Version:    0.7.0.1
 */