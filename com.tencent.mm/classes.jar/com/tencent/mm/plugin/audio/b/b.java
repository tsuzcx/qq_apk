package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"})
public class b
  extends a
{
  public static final b.a oHX;
  
  static
  {
    AppMethodBeat.i(223955);
    oHX = new b.a((byte)0);
    AppMethodBeat.o(223955);
  }
  
  public final boolean jp(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(223954);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    Log.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b", new Object[] { Boolean.valueOf(a.a.cea().isSpeakerphoneOn()), Boolean.valueOf(paramBoolean) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
      AppMethodBeat.o(223954);
      return false;
    }
    if (ae.gKu.gES)
    {
      if (paramBoolean)
      {
        i = 3;
        if (ae.gKu.gET >= 0) {
          i = ae.gKu.gET;
        }
        Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
        if (i != this.audioManager.getMode()) {
          b(i, null);
        }
        if (!this.audioManager.isSpeakerphoneOn()) {
          super.cV(true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(223954);
        return paramBoolean;
        i = 3;
        if (ae.gKu.gEU >= 0) {
          i = ae.gKu.gEU;
        }
        Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
        localObject = com.tencent.mm.plugin.audio.c.a.oIh;
        if (i != a.a.getMode())
        {
          localObject = com.tencent.mm.plugin.audio.c.a.oIh;
          a.a.cea().b(i, null);
        }
        if (this.audioManager.isSpeakerphoneOn()) {
          super.cV(false);
        }
      }
    }
    if (ae.gKu.gDA)
    {
      if (ae.gKu.anV())
      {
        if (ae.gKu.gDC >= 0) {
          b(ae.gKu.gDC, null);
        }
        for (;;)
        {
          if (ae.gKu.gDE > 0) {
            super.cV(paramBoolean);
          }
          AppMethodBeat.o(223954);
          return paramBoolean;
          if (ae.gKu.gDD >= 0) {
            if (paramBoolean) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (ae.gKu.anW())
      {
        if (paramBoolean)
        {
          if (ae.gKu.anZ()) {
            super.cV(true);
          }
          localObject = ae.gKu;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).anY() >= 0)
          {
            localObject = ae.gKu;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).anY(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(223954);
          return paramBoolean;
          if (ae.gKu.aob()) {
            super.js(true);
          }
          localObject = ae.gKu;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aoa() >= 0)
          {
            localObject = ae.gKu;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).aoa(), null);
          }
        }
      }
    }
    if (paramBoolean)
    {
      i = 3;
      if (ae.gKu.gEe >= 0) {
        i = ae.gKu.gEe;
      }
      Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      if (i != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.oIh;
        a.a.cea().b(i, null);
      }
      super.cV(true);
      AppMethodBeat.o(223954);
      return paramBoolean;
    }
    if ((com.tencent.mm.compatible.util.k.alh()) && (2 == ae.gKE.gGF)) {}
    for (;;)
    {
      if (ae.gKu.gEf >= 0) {
        i = ae.gKu.gEf;
      }
      Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      if (i != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.oIh;
        a.a.cea().b(i, null);
      }
      super.cV(paramBoolean);
      break;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.b
 * JD-Core Version:    0.7.0.1
 */