package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends a
{
  public static final b.a uVc;
  
  static
  {
    AppMethodBeat.i(263796);
    uVc = new b.a((byte)0);
    AppMethodBeat.o(263796);
  }
  
  public final boolean lN(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(263830);
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    Log.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b", new Object[] { Boolean.valueOf(a.a.cTW().cTU()), Boolean.valueOf(paramBoolean) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
      AppMethodBeat.o(263830);
      return false;
    }
    if (af.lXZ.lSk) {
      if (paramBoolean) {
        if (af.lXZ.lSl < 0) {
          break label582;
        }
      }
    }
    label582:
    for (i = af.lXZ.lSl;; i = 3)
    {
      Log.d("MicroMsg.IPCallAudioManager", s.X("IPCall doShiftSpeaker useSpeakerMode:", Integer.valueOf(i)));
      if (i != this.audioManager.getMode()) {
        a.a((a)this, i);
      }
      if (!this.audioManager.isSpeakerphoneOn()) {
        super.ee(true);
      }
      for (;;)
      {
        AppMethodBeat.o(263830);
        return paramBoolean;
        if (af.lXZ.lSm >= 0) {
          i = af.lXZ.lSm;
        }
        Log.d("MicroMsg.IPCallAudioManager", s.X("IPCall doShiftSpeaker usePhoneMode:", Integer.valueOf(i)));
        locala = com.tencent.mm.plugin.audio.c.a.uVi;
        if (i != a.a.cTW().audioManager.getMode())
        {
          locala = com.tencent.mm.plugin.audio.c.a.uVi;
          a.a(a.a.cTW(), i);
        }
        if (this.audioManager.isSpeakerphoneOn()) {
          super.ee(false);
        }
      }
      if (af.lXZ.lQS)
      {
        if (af.lXZ.aOv())
        {
          if (af.lXZ.lQU >= 0) {
            a.a((a)this, af.lXZ.lQU);
          }
          for (;;)
          {
            if (af.lXZ.lQW > 0) {
              super.ee(paramBoolean);
            }
            AppMethodBeat.o(263830);
            return paramBoolean;
            if (af.lXZ.lQV >= 0) {
              if (paramBoolean) {
                a.a((a)this, 0);
              } else {
                a.a((a)this, 2);
              }
            }
          }
        }
        if (af.lXZ.aOw())
        {
          if (paramBoolean)
          {
            if (af.lXZ.aOz()) {
              super.ee(true);
            }
            if (af.lXZ.aOy() >= 0) {
              a.a((a)this, af.lXZ.aOy());
            }
          }
          for (;;)
          {
            AppMethodBeat.o(263830);
            return paramBoolean;
            if (af.lXZ.aOB()) {
              super.lQ(true);
            }
            if (af.lXZ.aOA() >= 0) {
              a.a((a)this, af.lXZ.aOA());
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (af.lXZ.lRw >= 0) {
          i = af.lXZ.lRw;
        }
        Log.d("MicroMsg.IPCallAudioManager", s.X("IPCall doShiftSpeaker useSpeakerMode:", Integer.valueOf(i)));
        locala = com.tencent.mm.plugin.audio.c.a.uVi;
        if (i != a.a.cTW().audioManager.getMode())
        {
          locala = com.tencent.mm.plugin.audio.c.a.uVi;
          a.a(a.a.cTW(), i);
        }
        super.ee(true);
      }
      for (;;)
      {
        AppMethodBeat.o(263830);
        return paramBoolean;
        int j = i;
        if (l.isSamsung())
        {
          j = i;
          if (2 == af.lYj.lUf) {
            j = 2;
          }
        }
        if (af.lXZ.lRx >= 0) {
          j = af.lXZ.lRx;
        }
        Log.d("MicroMsg.IPCallAudioManager", s.X("IPCall doShiftSpeaker usePhoneMode:", Integer.valueOf(j)));
        locala = com.tencent.mm.plugin.audio.c.a.uVi;
        if (j != a.a.cTW().audioManager.getMode())
        {
          locala = com.tencent.mm.plugin.audio.c.a.uVi;
          a.a(a.a.cTW(), j);
        }
        super.ee(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.b
 * JD-Core Version:    0.7.0.1
 */