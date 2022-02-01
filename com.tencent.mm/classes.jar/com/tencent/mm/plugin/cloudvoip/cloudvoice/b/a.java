package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "init", "", "isAvailable", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "unInit", "Companion", "cloudvoice_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a osC;
  public b ied;
  public boolean osA;
  public com.tencent.mm.plugin.voip.model.c osB;
  
  static
  {
    AppMethodBeat.i(200793);
    osC = new a.a((byte)0);
    AppMethodBeat.o(200793);
  }
  
  public a()
  {
    AppMethodBeat.i(200792);
    this.ied = new b(ai.getContext());
    init();
    AppMethodBeat.o(200792);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(200789);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.So("openvoice");
    locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.bCC().mRs.unRegisterBroadcasts();
    AppMethodBeat.o(200789);
  }
  
  public final void hv(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(200791);
    super.hv(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(200791);
      return;
    case 2: 
      bool1 = this.osA;
      this.osA = (jw(false) & bool1);
      AppMethodBeat.o(200791);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.osA &= jw(true);
      AppMethodBeat.o(200791);
      return;
    case 9: 
      ac.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(wH(4)) });
      if (!wH(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.osA;
      this.osA = (jw(bool1) & bool2);
      AppMethodBeat.o(200791);
      return;
      ac.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(wH(4)) });
      bool1 = this.osA;
      this.osA = (jw(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(210379);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.bCC().mRs.registerBroadcasts();
    com.tencent.mm.plugin.audio.d.a.bCE();
    com.tencent.mm.plugin.audio.d.c.bCE();
    locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(210379);
  }
  
  public final boolean jw(boolean paramBoolean)
  {
    AppMethodBeat.i(200790);
    ac.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ih(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.osB;
    if ((localc != null) && (!localc.isPlaying()))
    {
      localc = this.osB;
      if (localc == null) {
        k.fOy();
      }
      paramBoolean = localc.ss(paramBoolean);
      AppMethodBeat.o(200790);
      return paramBoolean;
    }
    AppMethodBeat.o(200790);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
 * JD-Core Version:    0.7.0.1
 */