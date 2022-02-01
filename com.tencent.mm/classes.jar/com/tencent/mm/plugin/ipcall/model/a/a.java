package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.ipcall.model.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", "startRecord", "stopRecord", "unInit", "Companion", "OnDeviceChangeCallback", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a ypD;
  public final com.tencent.mm.compatible.util.b jvG;
  public com.tencent.mm.plugin.ipcall.model.c.a ypA;
  public c ypB;
  private boolean ypC;
  public b ypz;
  
  static
  {
    AppMethodBeat.i(230654);
    ypD = new a.a((byte)0);
    AppMethodBeat.o(230654);
  }
  
  public a()
  {
    AppMethodBeat.i(230653);
    this.jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    this.jvG.requestFocus();
    this.ypA = new com.tencent.mm.plugin.ipcall.model.c.a(this);
    this.ypB = new c();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "ipcall");
    AppMethodBeat.o(230653);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(230648);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.agt("ipcall");
    AppMethodBeat.o(230648);
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(230651);
    c localc = this.ypB;
    if (localc != null)
    {
      localc.bFT();
      AppMethodBeat.o(230651);
      return;
    }
    AppMethodBeat.o(230651);
  }
  
  public final void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(230649);
    com.tencent.mm.plugin.ipcall.model.c.a locala = this.ypA;
    if (locala != null) {
      locala.qw(paramBoolean);
    }
    this.ypC = isSpeakerphoneOn();
    AppMethodBeat.o(230649);
  }
  
  public final void eaE()
  {
    AppMethodBeat.i(230650);
    cV(this.ypC);
    AppMethodBeat.o(230650);
  }
  
  public final void iY(int paramInt)
  {
    AppMethodBeat.i(230652);
    super.iY(paramInt);
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
              AppMethodBeat.o(230652);
              return;
              localObject = com.tencent.mm.plugin.audio.c.a.oIh;
              localObject = com.tencent.mm.plugin.audio.d.b.oIo;
            } while ((!com.tencent.mm.plugin.audio.d.b.ceb()) || (this.ypz == null));
            localObject = this.ypz;
            if (localObject != null)
            {
              ((b)localObject).qv(true);
              AppMethodBeat.o(230652);
              return;
            }
            AppMethodBeat.o(230652);
            return;
          } while (AY(3));
          localObject = this.ypz;
          if (localObject != null)
          {
            ((b)localObject).qv(false);
            AppMethodBeat.o(230652);
            return;
          }
          AppMethodBeat.o(230652);
          return;
          Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
        } while (AY(4));
        localObject = this.ypz;
        if (localObject != null)
        {
          ((b)localObject).qu(true);
          AppMethodBeat.o(230652);
          return;
        }
        AppMethodBeat.o(230652);
        return;
        Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
      } while (AY(4));
      localObject = this.ypz;
    } while (localObject == null);
    ((b)localObject).qu(false);
    AppMethodBeat.o(230652);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"})
  public static abstract interface b
  {
    public abstract void qu(boolean paramBoolean);
    
    public abstract void qv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a.a
 * JD-Core Version:    0.7.0.1
 */