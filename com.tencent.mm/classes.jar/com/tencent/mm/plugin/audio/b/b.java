package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"})
public class b
  extends a
{
  public static final b.a rJN;
  
  static
  {
    AppMethodBeat.i(257658);
    rJN = new b.a((byte)0);
    AppMethodBeat.o(257658);
  }
  
  public final boolean kA(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(257657);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    Log.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b", new Object[] { Boolean.valueOf(a.a.crn().crl()), Boolean.valueOf(paramBoolean) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
      AppMethodBeat.o(257657);
      return false;
    }
    if (af.juI.jpc)
    {
      if (paramBoolean)
      {
        if (af.juI.jpd >= 0) {
          i = af.juI.jpd;
        }
        Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
        if (i != this.audioManager.getMode()) {
          a.a(this, i);
        }
        if (!this.audioManager.isSpeakerphoneOn()) {
          super.ds(true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(257657);
        return paramBoolean;
        if (af.juI.jpe >= 0) {
          i = af.juI.jpe;
        }
        Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
        localObject = com.tencent.mm.plugin.audio.c.a.rJX;
        if (i != a.a.getMode())
        {
          localObject = com.tencent.mm.plugin.audio.c.a.rJX;
          a.a(a.a.crn(), i);
        }
        if (this.audioManager.isSpeakerphoneOn()) {
          super.ds(false);
        }
      }
    }
    if (af.juI.jnK)
    {
      if (af.juI.atY())
      {
        if (af.juI.jnM >= 0) {
          a.a(this, af.juI.jnM);
        }
        for (;;)
        {
          if (af.juI.jnO > 0) {
            super.ds(paramBoolean);
          }
          AppMethodBeat.o(257657);
          return paramBoolean;
          if (af.juI.jnN >= 0) {
            if (paramBoolean) {
              a.a(this, 0);
            } else {
              a.a(this, 2);
            }
          }
        }
      }
      if (af.juI.atZ())
      {
        if (paramBoolean)
        {
          if (af.juI.auc()) {
            super.ds(true);
          }
          localObject = af.juI;
          p.j(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aub() >= 0)
          {
            localObject = af.juI;
            p.j(localObject, "SrvDeviceInfo.mAudioInfo");
            a.a(this, ((com.tencent.mm.compatible.deviceinfo.b)localObject).aub());
          }
        }
        for (;;)
        {
          AppMethodBeat.o(257657);
          return paramBoolean;
          if (af.juI.aue()) {
            super.kD(true);
          }
          localObject = af.juI;
          p.j(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aud() >= 0)
          {
            localObject = af.juI;
            p.j(localObject, "SrvDeviceInfo.mAudioInfo");
            a.a(this, ((com.tencent.mm.compatible.deviceinfo.b)localObject).aud());
          }
        }
      }
    }
    if (paramBoolean)
    {
      if (af.juI.joo >= 0) {
        i = af.juI.joo;
      }
      Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      if (i != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.rJX;
        a.a(a.a.crn(), i);
      }
      super.ds(true);
    }
    for (;;)
    {
      AppMethodBeat.o(257657);
      return paramBoolean;
      int j = i;
      if (com.tencent.mm.compatible.util.k.are())
      {
        j = i;
        if (2 == af.juS.jqR) {
          j = 2;
        }
      }
      if (af.juI.jop >= 0) {
        j = af.juI.jop;
      }
      Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(j)));
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      if (j != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.rJX;
        a.a(a.a.crn(), j);
      }
      super.ds(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.b
 * JD-Core Version:    0.7.0.1
 */