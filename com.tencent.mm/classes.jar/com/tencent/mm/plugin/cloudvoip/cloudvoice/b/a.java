package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "isAvailable", "onAudioDeviceStateChanged", "", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "unInit", "Companion", "cloudvoice_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a nPy;
  public b hDB;
  public boolean nPw;
  public com.tencent.mm.plugin.voip.model.c nPx;
  
  static
  {
    AppMethodBeat.i(191035);
    nPy = new a.a((byte)0);
    AppMethodBeat.o(191035);
  }
  
  public a()
  {
    AppMethodBeat.i(191034);
    this.hDB = new b(aj.getContext());
    com.tencent.mm.plugin.audio.d.a.bvI();
    com.tencent.mm.plugin.audio.d.c.bvI();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(191034);
  }
  
  public static void NX()
  {
    AppMethodBeat.i(191031);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.Oe("openvoice");
    AppMethodBeat.o(191031);
  }
  
  public final void hL(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(191033);
    super.hL(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(191033);
      return;
    case 2: 
      bool1 = this.nPw;
      this.nPw = (iT(false) & bool1);
      AppMethodBeat.o(191033);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.nPw &= iT(true);
      AppMethodBeat.o(191033);
      return;
    case 9: 
      ad.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(vQ(4)) });
      if (!vQ(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.nPw;
      this.nPw = (iT(bool1) & bool2);
      AppMethodBeat.o(191033);
      return;
      ad.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(vQ(4)) });
      bool1 = this.nPw;
      this.nPw = (iT(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final boolean iT(boolean paramBoolean)
  {
    AppMethodBeat.i(191032);
    ad.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    hJ(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.nPx;
    if ((localc != null) && (!localc.isPlaying()))
    {
      localc = this.nPx;
      if (localc == null) {
        k.fvU();
      }
      paramBoolean = localc.rr(paramBoolean);
      AppMethodBeat.o(191032);
      return paramBoolean;
    }
    AppMethodBeat.o(191032);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
 * JD-Core Version:    0.7.0.1
 */