package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"})
public class b
  extends a
{
  public static final b.a nrL;
  
  static
  {
    AppMethodBeat.i(199746);
    nrL = new b.a((byte)0);
    AppMethodBeat.o(199746);
  }
  
  public final boolean iq(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(199745);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    boolean bool = a.a.bGC().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    ad.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bGC().bGB() });
    if (bc.PD())
    {
      ad.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
      AppMethodBeat.o(199745);
      return false;
    }
    if (ae.gcF.fXv)
    {
      if (paramBoolean)
      {
        if (ae.gcF.fXw >= 0) {
          i = ae.gcF.fXw;
        }
        ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
        if (i != this.audioManager.getMode()) {
          b(i, null);
        }
        if (!this.audioManager.isSpeakerphoneOn()) {
          super.cn(true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(199745);
        return paramBoolean;
        if (ae.gcF.fXx >= 0) {
          i = ae.gcF.fXx;
        }
        ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
        localObject = com.tencent.mm.plugin.audio.c.a.nrV;
        if (i != a.a.getMode())
        {
          localObject = com.tencent.mm.plugin.audio.c.a.nrV;
          a.a.bGC().b(i, null);
        }
        if (this.audioManager.isSpeakerphoneOn()) {
          super.cn(false);
        }
      }
    }
    if (ae.gcF.fWh)
    {
      if (ae.gcF.ZN())
      {
        if (ae.gcF.fWj >= 0) {
          b(ae.gcF.fWj, null);
        }
        for (;;)
        {
          if (ae.gcF.fWl > 0) {
            super.cn(paramBoolean);
          }
          AppMethodBeat.o(199745);
          return paramBoolean;
          if (ae.gcF.fWk >= 0) {
            if (paramBoolean) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (ae.gcF.ZO())
      {
        if (paramBoolean)
        {
          if (ae.gcF.ZR()) {
            super.cn(true);
          }
          localObject = ae.gcF;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).ZQ() >= 0)
          {
            localObject = ae.gcF;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).ZQ(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(199745);
          return paramBoolean;
          if (ae.gcF.ZT()) {
            super.it(true);
          }
          localObject = ae.gcF;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).ZS() >= 0)
          {
            localObject = ae.gcF;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).ZS(), null);
          }
        }
      }
    }
    if (paramBoolean)
    {
      if (ae.gcF.fWH >= 0) {
        i = ae.gcF.fWH;
      }
      ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      if (i != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.nrV;
        a.a.bGC().b(i, null);
      }
      super.cn(true);
    }
    for (;;)
    {
      AppMethodBeat.o(199745);
      return paramBoolean;
      int j = i;
      if (com.tencent.mm.compatible.util.k.Xm())
      {
        j = i;
        if (2 == ae.gcP.fZg) {
          j = 2;
        }
      }
      if (ae.gcF.fWI >= 0) {
        j = ae.gcF.fWI;
      }
      ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(j)));
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      if (j != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.nrV;
        a.a.bGC().b(j, null);
      }
      super.cn(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.b
 * JD-Core Version:    0.7.0.1
 */