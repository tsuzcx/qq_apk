package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "init", "", "isAvailable", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "unInit", "Companion", "cloudvoice_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a oVY;
  public b ixy;
  public boolean oVW;
  public com.tencent.mm.plugin.voip.model.c oVX;
  
  static
  {
    AppMethodBeat.i(190965);
    oVY = new a.a((byte)0);
    AppMethodBeat.o(190965);
  }
  
  public a()
  {
    AppMethodBeat.i(190964);
    this.ixy = new b(aj.getContext());
    init();
    AppMethodBeat.o(190964);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(190961);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.VM("openvoice");
    locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.bGK().nrR.unRegisterBroadcasts();
    AppMethodBeat.o(190961);
  }
  
  public final void hC(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(190963);
    super.hC(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(190963);
      return;
    case 2: 
      bool1 = this.oVW;
      this.oVW = (jH(false) & bool1);
      AppMethodBeat.o(190963);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.oVW &= jH(true);
      AppMethodBeat.o(190963);
      return;
    case 9: 
      ad.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(xn(4)) });
      if (!xn(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.oVW;
      this.oVW = (jH(bool1) & bool2);
      AppMethodBeat.o(190963);
      return;
      ad.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(xn(4)) });
      bool1 = this.oVW;
      this.oVW = (jH(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(190960);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.bGK().nrR.registerBroadcasts();
    com.tencent.mm.plugin.audio.d.a.bGM();
    com.tencent.mm.plugin.audio.d.c.bGM();
    locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(190960);
  }
  
  public final boolean jH(boolean paramBoolean)
  {
    AppMethodBeat.i(190962);
    ad.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    iq(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.oVX;
    if ((localc != null) && (!localc.isPlaying()))
    {
      localc = this.oVX;
      if (localc == null) {
        p.gfZ();
      }
      paramBoolean = localc.tb(paramBoolean);
      AppMethodBeat.o(190962);
      return paramBoolean;
    }
    AppMethodBeat.o(190962);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
 * JD-Core Version:    0.7.0.1
 */