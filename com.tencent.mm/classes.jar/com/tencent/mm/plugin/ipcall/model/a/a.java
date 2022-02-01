package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", "startRecord", "stopRecord", "unInit", "Companion", "OnDeviceChangeCallback", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a uXc;
  public final com.tencent.mm.compatible.util.b iAr;
  public b uWY;
  public com.tencent.mm.plugin.ipcall.model.c.a uWZ;
  public com.tencent.mm.plugin.ipcall.model.c.c uXa;
  private boolean uXb;
  
  static
  {
    AppMethodBeat.i(188250);
    uXc = new a.a((byte)0);
    AppMethodBeat.o(188250);
  }
  
  public a()
  {
    AppMethodBeat.i(188249);
    this.iAr = new com.tencent.mm.compatible.util.b(ak.getContext());
    com.tencent.mm.plugin.audio.d.a.bHI();
    com.tencent.mm.plugin.audio.d.c.bHI();
    this.iAr.requestFocus();
    this.uWZ = new com.tencent.mm.plugin.ipcall.model.c.a(this);
    this.uXa = new com.tencent.mm.plugin.ipcall.model.c.c();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "ipcall");
    AppMethodBeat.o(188249);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(188244);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.Wy("ipcall");
    AppMethodBeat.o(188244);
  }
  
  public final void bkx()
  {
    AppMethodBeat.i(188247);
    com.tencent.mm.plugin.ipcall.model.c.c localc = this.uXa;
    if (localc != null)
    {
      localc.bkx();
      AppMethodBeat.o(188247);
      return;
    }
    AppMethodBeat.o(188247);
  }
  
  public final void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(188245);
    com.tencent.mm.plugin.ipcall.model.c.a locala = this.uWZ;
    if (locala != null) {
      locala.nN(paramBoolean);
    }
    this.uXb = isSpeakerphoneOn();
    AppMethodBeat.o(188245);
  }
  
  public final void dgK()
  {
    AppMethodBeat.i(188246);
    cn(this.uXb);
    AppMethodBeat.o(188246);
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(188248);
    super.hE(paramInt);
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
              AppMethodBeat.o(188248);
              return;
              localObject = com.tencent.mm.plugin.audio.c.a.nxo;
              localObject = com.tencent.mm.plugin.audio.d.a.nxr;
            } while ((!com.tencent.mm.plugin.audio.d.a.bHz()) || (this.uWY == null));
            localObject = this.uWY;
            if (localObject != null)
            {
              ((b)localObject).nM(true);
              AppMethodBeat.o(188248);
              return;
            }
            AppMethodBeat.o(188248);
            return;
          } while (xs(3));
          localObject = this.uWY;
          if (localObject != null)
          {
            ((b)localObject).nM(false);
            AppMethodBeat.o(188248);
            return;
          }
          AppMethodBeat.o(188248);
          return;
          ae.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
        } while (xs(4));
        localObject = this.uWY;
        if (localObject != null)
        {
          ((b)localObject).nL(true);
          AppMethodBeat.o(188248);
          return;
        }
        AppMethodBeat.o(188248);
        return;
        ae.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
      } while (xs(4));
      localObject = this.uWY;
    } while (localObject == null);
    ((b)localObject).nL(false);
    AppMethodBeat.o(188248);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"})
  public static abstract interface b
  {
    public abstract void nL(boolean paramBoolean);
    
    public abstract void nM(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a.a
 * JD-Core Version:    0.7.0.1
 */