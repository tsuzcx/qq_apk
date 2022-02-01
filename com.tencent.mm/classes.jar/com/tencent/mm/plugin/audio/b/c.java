package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class c
  extends a
{
  public static final c.a oHY;
  
  static
  {
    AppMethodBeat.i(223959);
    oHY = new c.a((byte)0);
    AppMethodBeat.o(223959);
  }
  
  private final boolean z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(223958);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    if (!a.a.ags("music"))
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      if (!a.a.ags("openvoice"))
      {
        Log.i("MicroMsg.BaseMusicAudioManager", "current not running a type as MUSIC");
        AppMethodBeat.o(223958);
        return false;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    Log.printInfoStack("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker:%b -> %b  ", new Object[] { Boolean.valueOf(a.a.cea().isSpeakerphoneOn()), Boolean.valueOf(paramBoolean1) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.BaseMusicAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(223958);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if ((com.tencent.mm.plugin.audio.d.b.ceb()) || (this.gCW))
    {
      Log.i("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      b(0, null);
      AppMethodBeat.o(223958);
      return false;
    }
    if ((ae.gKu.gDA) && (ae.gKu.anX()))
    {
      if (paramBoolean1)
      {
        if (ae.gKu.aod()) {
          super.cV(true);
        }
        localObject = ae.gKu;
        p.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aoc() >= 0)
        {
          localObject = ae.gKu;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((com.tencent.mm.compatible.deviceinfo.b)localObject).aoc(), null);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(223958);
        return paramBoolean1;
        if (ae.gKu.aof()) {
          super.cV(false);
        }
        localObject = ae.gKu;
        p.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aoe() >= 0)
        {
          localObject = ae.gKu;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((com.tencent.mm.compatible.deviceinfo.b)localObject).aoe(), null);
        }
      }
    }
    if (paramBoolean1) {}
    for (i = 0;; i = 3)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      if (!a.a.cea().cdW())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.oIh;
        localObject = com.tencent.mm.plugin.audio.d.b.oIo;
        if (!com.tencent.mm.plugin.audio.d.b.ceb()) {}
      }
      else
      {
        i = 0;
      }
      b(i, null);
      super.cV(paramBoolean1);
      AppMethodBeat.o(223958);
      return paramBoolean1;
    }
  }
  
  public final boolean jp(boolean paramBoolean)
  {
    AppMethodBeat.i(223956);
    paramBoolean = z(paramBoolean, false);
    AppMethodBeat.o(223956);
    return paramBoolean;
  }
  
  public final boolean ju(boolean paramBoolean)
  {
    AppMethodBeat.i(223957);
    paramBoolean = z(paramBoolean, false);
    AppMethodBeat.o(223957);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.c
 * JD-Core Version:    0.7.0.1
 */