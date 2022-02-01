package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends a
{
  public static final c.a uVd;
  
  static
  {
    AppMethodBeat.i(263787);
    uVd = new c.a((byte)0);
    AppMethodBeat.o(263787);
  }
  
  private final boolean J(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    AppMethodBeat.i(263782);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    if (!a.a.aht("music"))
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      if (!a.a.aht("openvoice"))
      {
        Log.i("MicroMsg.BaseMusicAudioManager", "current not running a type as MUSIC");
        AppMethodBeat.o(263782);
        return false;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    Log.printInfoStack("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker:%b -> %b  ", new Object[] { Boolean.valueOf(a.a.cTW().cTU()), Boolean.valueOf(paramBoolean1) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.BaseMusicAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(263782);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    if ((com.tencent.mm.plugin.audio.d.b.cTX()) || (cTK()))
    {
      Log.i("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      a.a((a)this, 0);
      AppMethodBeat.o(263782);
      return false;
    }
    if ((af.lXZ.lQS) && (af.lXZ.aOx()))
    {
      if (paramBoolean1)
      {
        if (af.lXZ.aOD()) {
          super.ee(true);
        }
        if (af.lXZ.aOC() >= 0) {
          a.a((a)this, af.lXZ.aOC());
        }
      }
      for (;;)
      {
        AppMethodBeat.o(263782);
        return paramBoolean1;
        if (af.lXZ.aOF()) {
          super.ee(false);
        }
        if (af.lXZ.aOE() >= 0) {
          a.a((a)this, af.lXZ.aOE());
        }
      }
    }
    if (paramBoolean1)
    {
      i = 0;
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      j = k;
      if (!a.a.cTW().cTQ())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.uVi;
        localObject = com.tencent.mm.plugin.audio.d.b.uVo;
        if (!com.tencent.mm.plugin.audio.d.b.cTX()) {
          break label341;
        }
      }
    }
    label341:
    for (int j = k;; j = i)
    {
      a.a((a)this, j);
      super.ee(paramBoolean1);
      AppMethodBeat.o(263782);
      return paramBoolean1;
      i = 3;
      break;
    }
  }
  
  public final boolean lN(boolean paramBoolean)
  {
    AppMethodBeat.i(263797);
    paramBoolean = J(paramBoolean, false);
    AppMethodBeat.o(263797);
    return paramBoolean;
  }
  
  public final boolean lT(boolean paramBoolean)
  {
    AppMethodBeat.i(263806);
    paramBoolean = J(paramBoolean, false);
    AppMethodBeat.o(263806);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.c
 * JD-Core Version:    0.7.0.1
 */