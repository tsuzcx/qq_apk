package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "init", "", "isAvailable", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "unInit", "Companion", "cloudvoice_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a pcB;
  public b iAr;
  public com.tencent.mm.plugin.voip.model.c pcA;
  public boolean pcz;
  
  static
  {
    AppMethodBeat.i(211634);
    pcB = new a.a((byte)0);
    AppMethodBeat.o(211634);
  }
  
  public a()
  {
    AppMethodBeat.i(211633);
    this.iAr = new b(ak.getContext());
    init();
    AppMethodBeat.o(211633);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(211630);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.Wy("openvoice");
    locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.bHG().nxk.unRegisterBroadcasts();
    AppMethodBeat.o(211630);
  }
  
  public final void hE(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(211632);
    super.hE(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(211632);
      return;
    case 2: 
      bool1 = this.pcz;
      this.pcz = (jG(false) & bool1);
      AppMethodBeat.o(211632);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.pcz &= jG(true);
      AppMethodBeat.o(211632);
      return;
    case 9: 
      ae.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(xs(4)) });
      if (!xs(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.pcz;
      this.pcz = (jG(bool1) & bool2);
      AppMethodBeat.o(211632);
      return;
      ae.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(xs(4)) });
      bool1 = this.pcz;
      this.pcz = (jG(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(211629);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.bHG().nxk.registerBroadcasts();
    com.tencent.mm.plugin.audio.d.a.bHI();
    com.tencent.mm.plugin.audio.d.c.bHI();
    locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(211629);
  }
  
  public final boolean jG(boolean paramBoolean)
  {
    AppMethodBeat.i(211631);
    ae.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    io(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.pcA;
    if ((localc != null) && (!localc.isPlaying()))
    {
      localc = this.pcA;
      if (localc == null) {
        p.gkB();
      }
      paramBoolean = localc.ti(paramBoolean);
      AppMethodBeat.o(211631);
      return paramBoolean;
    }
    AppMethodBeat.o(211631);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
 * JD-Core Version:    0.7.0.1
 */