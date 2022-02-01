package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "init", "", "isAvailable", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "tryRequestBluetoothDevice", "unInit", "Companion", "cloudvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a wTw;
  public com.tencent.mm.compatible.util.b peV;
  public boolean wTx;
  public com.tencent.mm.plugin.voip.model.c wTy;
  
  static
  {
    AppMethodBeat.i(268254);
    wTw = new a.a((byte)0);
    AppMethodBeat.o(268254);
  }
  
  public a()
  {
    AppMethodBeat.i(268247);
    this.peV = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    init();
    AppMethodBeat.o(268247);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(268250);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.ahu("openvoice");
    locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.cUe().uVj.unRegisterBroadcasts();
    AppMethodBeat.o(268250);
  }
  
  public final void init()
  {
    AppMethodBeat.i(268259);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.cUc();
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
    locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(268259);
  }
  
  public final boolean isAvailable()
  {
    return this.wTy != null;
  }
  
  public final void nW(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(268273);
    super.nW(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(268273);
      return;
    case 2: 
      bool1 = this.wTx;
      this.wTx = (nq(false) & bool1);
      AppMethodBeat.o(268273);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.wTx &= nq(true);
      AppMethodBeat.o(268273);
      return;
    case 9: 
      Log.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Fa(4)) });
      if (!Fa(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.wTx;
      this.wTx = (nq(bool1) & bool2);
      AppMethodBeat.o(268273);
      return;
      Log.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Fa(4)) });
      bool1 = this.wTx;
      this.wTx = (nq(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final boolean nq(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(268263);
    Log.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    lN(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.wTy;
    if ((localc != null) && (!localc.UvL)) {}
    while (i != 0)
    {
      localc = this.wTy;
      s.checkNotNull(localc);
      paramBoolean = localc.Gj(paramBoolean);
      AppMethodBeat.o(268263);
      return paramBoolean;
      i = 0;
    }
    AppMethodBeat.o(268263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
 * JD-Core Version:    0.7.0.1
 */