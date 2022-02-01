package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "init", "", "isAvailable", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "unInit", "Companion", "cloudvoice_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a qrA;
  public com.tencent.mm.compatible.util.b jvG;
  public boolean qry;
  public com.tencent.mm.plugin.voip.model.c qrz;
  
  static
  {
    AppMethodBeat.i(186812);
    qrA = new a.a((byte)0);
    AppMethodBeat.o(186812);
  }
  
  public a()
  {
    AppMethodBeat.i(186811);
    this.jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    init();
    AppMethodBeat.o(186811);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(186808);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.agt("openvoice");
    locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.cei().oId.unRegisterBroadcasts();
    AppMethodBeat.o(186808);
  }
  
  public final void iY(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(186810);
    super.iY(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(186810);
      return;
    case 2: 
      bool1 = this.qry;
      this.qry = (kJ(false) & bool1);
      AppMethodBeat.o(186810);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.qry &= kJ(true);
      AppMethodBeat.o(186810);
      return;
    case 9: 
      Log.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(AY(4)) });
      if (!AY(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.qry;
      this.qry = (kJ(bool1) & bool2);
      AppMethodBeat.o(186810);
      return;
      Log.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(AY(4)) });
      bool1 = this.qry;
      this.qry = (kJ(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(186807);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.cei().oId.registerBroadcasts();
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(186807);
  }
  
  public final boolean isAvailable()
  {
    return this.qrz != null;
  }
  
  public final boolean kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(186809);
    Log.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    jp(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.qrz;
    if ((localc != null) && (!localc.isPlaying()))
    {
      localc = this.qrz;
      if (localc == null) {
        p.hyc();
      }
      paramBoolean = localc.wS(paramBoolean);
      AppMethodBeat.o(186809);
      return paramBoolean;
    }
    AppMethodBeat.o(186809);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
 * JD-Core Version:    0.7.0.1
 */