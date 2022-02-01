package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"})
public class b
  extends a
{
  public static final b.a mpl;
  
  static
  {
    AppMethodBeat.i(189228);
    mpl = new b.a((byte)0);
    AppMethodBeat.o(189228);
  }
  
  public final boolean hJ(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(189227);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    boolean bool = a.a.bvB().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    ad.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bvB().bvA() });
    if (bc.NY())
    {
      ad.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
      AppMethodBeat.o(189227);
      return false;
    }
    if (ae.fFx.fAp)
    {
      if (paramBoolean)
      {
        if (ae.fFx.fAq >= 0) {
          i = ae.fFx.fAq;
        }
        ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
        if (i != this.audioManager.getMode()) {
          a(i, null);
        }
        if (!this.audioManager.isSpeakerphoneOn()) {
          super.ck(true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(189227);
        return paramBoolean;
        if (ae.fFx.fAr >= 0) {
          i = ae.fFx.fAr;
        }
        ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
        localObject = com.tencent.mm.plugin.audio.c.a.mpv;
        if (i != a.a.getMode())
        {
          localObject = com.tencent.mm.plugin.audio.c.a.mpv;
          a.a.bvB().a(i, null);
        }
        if (this.audioManager.isSpeakerphoneOn()) {
          super.ck(false);
        }
      }
    }
    if (ae.fFx.fzm)
    {
      if (ae.fFx.Wo())
      {
        if (ae.fFx.fzo >= 0) {
          a(ae.fFx.fzo, null);
        }
        for (;;)
        {
          if (ae.fFx.fzq > 0) {
            super.ck(paramBoolean);
          }
          AppMethodBeat.o(189227);
          return paramBoolean;
          if (ae.fFx.fzp >= 0) {
            if (paramBoolean) {
              a(0, null);
            } else {
              a(2, null);
            }
          }
        }
      }
      if (ae.fFx.Wp())
      {
        if (paramBoolean)
        {
          if (ae.fFx.Ws()) {
            super.ck(true);
          }
          localObject = ae.fFx;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).Wr() >= 0)
          {
            localObject = ae.fFx;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            a(((com.tencent.mm.compatible.deviceinfo.b)localObject).Wr(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(189227);
          return paramBoolean;
          if (ae.fFx.Wu()) {
            super.hM(true);
          }
          localObject = ae.fFx;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).Wt() >= 0)
          {
            localObject = ae.fFx;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            a(((com.tencent.mm.compatible.deviceinfo.b)localObject).Wt(), null);
          }
        }
      }
    }
    if (paramBoolean)
    {
      if (ae.fFx.fzM >= 0) {
        i = ae.fFx.fzM;
      }
      ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      if (i != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.mpv;
        a.a.bvB().a(i, null);
      }
      super.ck(true);
    }
    for (;;)
    {
      AppMethodBeat.o(189227);
      return paramBoolean;
      int j = i;
      if (com.tencent.mm.compatible.util.k.Ua())
      {
        j = i;
        if (2 == ae.fFH.fCa) {
          j = 2;
        }
      }
      if (ae.fFx.fzN >= 0) {
        j = ae.fFx.fzN;
      }
      ad.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(j)));
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      if (j != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.mpv;
        a.a.bvB().a(j, null);
      }
      super.ck(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.b
 * JD-Core Version:    0.7.0.1
 */