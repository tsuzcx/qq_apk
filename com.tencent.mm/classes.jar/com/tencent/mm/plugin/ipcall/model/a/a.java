package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", "startRecord", "stopRecord", "unInit", "Companion", "OnDeviceChangeCallback", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a sAT;
  public final com.tencent.mm.compatible.util.b hDB;
  public b sAP;
  public com.tencent.mm.plugin.ipcall.model.c.a sAQ;
  public com.tencent.mm.plugin.ipcall.model.c.c sAR;
  private boolean sAS;
  
  static
  {
    AppMethodBeat.i(191870);
    sAT = new a.a((byte)0);
    AppMethodBeat.o(191870);
  }
  
  public a()
  {
    AppMethodBeat.i(191869);
    this.hDB = new com.tencent.mm.compatible.util.b(aj.getContext());
    com.tencent.mm.plugin.audio.d.a.bvI();
    com.tencent.mm.plugin.audio.d.c.bvI();
    this.hDB.requestFocus();
    this.sAQ = new com.tencent.mm.plugin.ipcall.model.c.a(this);
    this.sAR = new com.tencent.mm.plugin.ipcall.model.c.c();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "ipcall");
    AppMethodBeat.o(191869);
  }
  
  public static void NX()
  {
    AppMethodBeat.i(191864);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.Oe("ipcall");
    AppMethodBeat.o(191864);
  }
  
  public final void aZs()
  {
    AppMethodBeat.i(191867);
    com.tencent.mm.plugin.ipcall.model.c.c localc = this.sAR;
    if (localc != null)
    {
      localc.aZs();
      AppMethodBeat.o(191867);
      return;
    }
    AppMethodBeat.o(191867);
  }
  
  public final void cHw()
  {
    AppMethodBeat.i(191866);
    ck(this.sAS);
    AppMethodBeat.o(191866);
  }
  
  public final void ck(boolean paramBoolean)
  {
    AppMethodBeat.i(191865);
    com.tencent.mm.plugin.ipcall.model.c.a locala = this.sAQ;
    if (locala != null) {
      locala.mw(paramBoolean);
    }
    this.sAS = isSpeakerphoneOn();
    AppMethodBeat.o(191865);
  }
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(191868);
    super.hL(paramInt);
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
              AppMethodBeat.o(191868);
              return;
              localObject = com.tencent.mm.plugin.audio.c.a.mpv;
              localObject = com.tencent.mm.plugin.audio.d.a.mpy;
            } while ((!com.tencent.mm.plugin.audio.d.a.bvC()) || (this.sAP == null));
            localObject = this.sAP;
            if (localObject != null)
            {
              ((b)localObject).mv(true);
              AppMethodBeat.o(191868);
              return;
            }
            AppMethodBeat.o(191868);
            return;
          } while (vQ(3));
          localObject = this.sAP;
          if (localObject != null)
          {
            ((b)localObject).mv(false);
            AppMethodBeat.o(191868);
            return;
          }
          AppMethodBeat.o(191868);
          return;
          ad.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
        } while (vQ(4));
        localObject = this.sAP;
        if (localObject != null)
        {
          ((b)localObject).mu(true);
          AppMethodBeat.o(191868);
          return;
        }
        AppMethodBeat.o(191868);
        return;
        ad.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
      } while (vQ(4));
      localObject = this.sAP;
    } while (localObject == null);
    ((b)localObject).mu(false);
    AppMethodBeat.o(191868);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"})
  public static abstract interface b
  {
    public abstract void mu(boolean paramBoolean);
    
    public abstract void mv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a.a
 * JD-Core Version:    0.7.0.1
 */