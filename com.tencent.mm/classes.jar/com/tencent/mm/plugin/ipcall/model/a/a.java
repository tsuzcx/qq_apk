package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", "startRecord", "stopRecord", "unInit", "Companion", "OnDeviceChangeCallback", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a tIC;
  public final com.tencent.mm.compatible.util.b ied;
  public com.tencent.mm.plugin.ipcall.model.c.c tIA;
  private boolean tIB;
  public b tIy;
  public com.tencent.mm.plugin.ipcall.model.c.a tIz;
  
  static
  {
    AppMethodBeat.i(196991);
    tIC = new a.a((byte)0);
    AppMethodBeat.o(196991);
  }
  
  public a()
  {
    AppMethodBeat.i(196990);
    this.ied = new com.tencent.mm.compatible.util.b(ai.getContext());
    com.tencent.mm.plugin.audio.d.a.bCE();
    com.tencent.mm.plugin.audio.d.c.bCE();
    this.ied.requestFocus();
    this.tIz = new com.tencent.mm.plugin.ipcall.model.c.a(this);
    this.tIA = new com.tencent.mm.plugin.ipcall.model.c.c();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "ipcall");
    AppMethodBeat.o(196990);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(196985);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.So("ipcall");
    AppMethodBeat.o(196985);
  }
  
  public final void bgk()
  {
    AppMethodBeat.i(196988);
    com.tencent.mm.plugin.ipcall.model.c.c localc = this.tIA;
    if (localc != null)
    {
      localc.bgk();
      AppMethodBeat.o(196988);
      return;
    }
    AppMethodBeat.o(196988);
  }
  
  public final void cUH()
  {
    AppMethodBeat.i(196987);
    cm(this.tIB);
    AppMethodBeat.o(196987);
  }
  
  public final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(196986);
    com.tencent.mm.plugin.ipcall.model.c.a locala = this.tIz;
    if (locala != null) {
      locala.np(paramBoolean);
    }
    this.tIB = isSpeakerphoneOn();
    AppMethodBeat.o(196986);
  }
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(196989);
    super.hv(paramInt);
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
              AppMethodBeat.o(196989);
              return;
              localObject = com.tencent.mm.plugin.audio.c.a.mRw;
              localObject = com.tencent.mm.plugin.audio.d.a.mRz;
            } while ((!com.tencent.mm.plugin.audio.d.a.bCy()) || (this.tIy == null));
            localObject = this.tIy;
            if (localObject != null)
            {
              ((b)localObject).no(true);
              AppMethodBeat.o(196989);
              return;
            }
            AppMethodBeat.o(196989);
            return;
          } while (wH(3));
          localObject = this.tIy;
          if (localObject != null)
          {
            ((b)localObject).no(false);
            AppMethodBeat.o(196989);
            return;
          }
          AppMethodBeat.o(196989);
          return;
          ac.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
        } while (wH(4));
        localObject = this.tIy;
        if (localObject != null)
        {
          ((b)localObject).nn(true);
          AppMethodBeat.o(196989);
          return;
        }
        AppMethodBeat.o(196989);
        return;
        ac.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
      } while (wH(4));
      localObject = this.tIy;
    } while (localObject == null);
    ((b)localObject).nn(false);
    AppMethodBeat.o(196989);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"})
  public static abstract interface b
  {
    public abstract void nn(boolean paramBoolean);
    
    public abstract void no(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a.a
 * JD-Core Version:    0.7.0.1
 */