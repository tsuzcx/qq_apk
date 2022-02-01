package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "init", "", "isAvailable", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "tryRequestBluetoothDevice", "unInit", "Companion", "cloudvoice_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a tQi;
  public com.tencent.mm.compatible.util.b mlj;
  public boolean tQg;
  public com.tencent.mm.plugin.voip.model.c tQh;
  
  static
  {
    AppMethodBeat.i(203772);
    tQi = new a.a((byte)0);
    AppMethodBeat.o(203772);
  }
  
  public a()
  {
    AppMethodBeat.i(203771);
    this.mlj = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    init();
    AppMethodBeat.o(203771);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(203766);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.anX("openvoice");
    locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.crv().rJT.unRegisterBroadcasts();
    AppMethodBeat.o(203766);
  }
  
  public final void init()
  {
    AppMethodBeat.i(203764);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.crv().rJT.registerBroadcasts();
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
    locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(203764);
  }
  
  public final boolean isAvailable()
  {
    return this.tQh != null;
  }
  
  public final void ko(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(203769);
    super.ko(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(203769);
      return;
    case 2: 
      bool1 = this.tQg;
      this.tQg = (lV(false) & bool1);
      AppMethodBeat.o(203769);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.tQg &= lV(true);
      AppMethodBeat.o(203769);
      return;
    case 9: 
      Log.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Ez(4)) });
      if (!Ez(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.tQg;
      this.tQg = (lV(bool1) & bool2);
      AppMethodBeat.o(203769);
      return;
      Log.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Ez(4)) });
      bool1 = this.tQg;
      this.tQg = (lV(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final boolean lV(boolean paramBoolean)
  {
    AppMethodBeat.i(203767);
    Log.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    kA(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.tQh;
    if ((localc != null) && (!localc.isPlaying()))
    {
      localc = this.tQh;
      if (localc == null) {
        p.iCn();
      }
      paramBoolean = localc.AK(paramBoolean);
      AppMethodBeat.o(203767);
      return paramBoolean;
    }
    AppMethodBeat.o(203767);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
 * JD-Core Version:    0.7.0.1
 */