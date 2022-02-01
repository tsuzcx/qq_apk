package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class c
  extends a
{
  public static final c.a rJO;
  
  static
  {
    AppMethodBeat.i(257607);
    rJO = new c.a((byte)0);
    AppMethodBeat.o(257607);
  }
  
  private final boolean D(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(257606);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    if (!a.a.anW("music"))
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      if (!a.a.anW("openvoice"))
      {
        Log.i("MicroMsg.BaseMusicAudioManager", "current not running a type as MUSIC");
        AppMethodBeat.o(257606);
        return false;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    Log.printInfoStack("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker:%b -> %b  ", new Object[] { Boolean.valueOf(a.a.crn().crl()), Boolean.valueOf(paramBoolean1) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.BaseMusicAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(257606);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if ((com.tencent.mm.plugin.audio.d.b.cro()) || (this.jnc))
    {
      Log.i("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      a.a(this, 0);
      AppMethodBeat.o(257606);
      return false;
    }
    if ((af.juI.jnK) && (af.juI.aua()))
    {
      if (paramBoolean1)
      {
        if (af.juI.aug()) {
          super.ds(true);
        }
        localObject = af.juI;
        p.j(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((com.tencent.mm.compatible.deviceinfo.b)localObject).auf() >= 0)
        {
          localObject = af.juI;
          p.j(localObject, "SrvDeviceInfo.mAudioInfo");
          a.a(this, ((com.tencent.mm.compatible.deviceinfo.b)localObject).auf());
        }
      }
      for (;;)
      {
        AppMethodBeat.o(257606);
        return paramBoolean1;
        if (af.juI.aui()) {
          super.ds(false);
        }
        localObject = af.juI;
        p.j(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((com.tencent.mm.compatible.deviceinfo.b)localObject).auh() >= 0)
        {
          localObject = af.juI;
          p.j(localObject, "SrvDeviceInfo.mAudioInfo");
          a.a(this, ((com.tencent.mm.compatible.deviceinfo.b)localObject).auh());
        }
      }
    }
    if (paramBoolean1) {}
    for (i = 0;; i = 3)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      if (!a.a.crn().crh())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.rJX;
        localObject = com.tencent.mm.plugin.audio.d.b.rKe;
        if (!com.tencent.mm.plugin.audio.d.b.cro()) {}
      }
      else
      {
        i = 0;
      }
      a.a(this, i);
      super.ds(paramBoolean1);
      AppMethodBeat.o(257606);
      return paramBoolean1;
    }
  }
  
  public final boolean kA(boolean paramBoolean)
  {
    AppMethodBeat.i(257604);
    paramBoolean = D(paramBoolean, false);
    AppMethodBeat.o(257604);
    return paramBoolean;
  }
  
  public final boolean kF(boolean paramBoolean)
  {
    AppMethodBeat.i(257605);
    paramBoolean = D(paramBoolean, false);
    AppMethodBeat.o(257605);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.c
 * JD-Core Version:    0.7.0.1
 */