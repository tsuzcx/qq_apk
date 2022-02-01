package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bb;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"})
public class b
  extends a
{
  public static final b.a mRm;
  
  static
  {
    AppMethodBeat.i(198348);
    mRm = new b.a((byte)0);
    AppMethodBeat.o(198348);
  }
  
  public final boolean ih(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(198347);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    boolean bool = a.a.bCx().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    ac.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bCx().bCw() });
    if (bb.NU())
    {
      ac.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
      AppMethodBeat.o(198347);
      return false;
    }
    if (ae.fJe.fDW)
    {
      if (paramBoolean)
      {
        if (ae.fJe.fDX >= 0) {
          i = ae.fJe.fDX;
        }
        ac.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
        if (i != this.audioManager.getMode()) {
          b(i, null);
        }
        if (!this.audioManager.isSpeakerphoneOn()) {
          super.cm(true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198347);
        return paramBoolean;
        if (ae.fJe.fDY >= 0) {
          i = ae.fJe.fDY;
        }
        ac.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
        localObject = com.tencent.mm.plugin.audio.c.a.mRw;
        if (i != a.a.getMode())
        {
          localObject = com.tencent.mm.plugin.audio.c.a.mRw;
          a.a.bCx().b(i, null);
        }
        if (this.audioManager.isSpeakerphoneOn()) {
          super.cm(false);
        }
      }
    }
    if (ae.fJe.fCT)
    {
      if (ae.fJe.Xm())
      {
        if (ae.fJe.fCV >= 0) {
          b(ae.fJe.fCV, null);
        }
        for (;;)
        {
          if (ae.fJe.fCX > 0) {
            super.cm(paramBoolean);
          }
          AppMethodBeat.o(198347);
          return paramBoolean;
          if (ae.fJe.fCW >= 0) {
            if (paramBoolean) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (ae.fJe.Xn())
      {
        if (paramBoolean)
        {
          if (ae.fJe.Xq()) {
            super.cm(true);
          }
          localObject = ae.fJe;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).Xp() >= 0)
          {
            localObject = ae.fJe;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).Xp(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(198347);
          return paramBoolean;
          if (ae.fJe.Xs()) {
            super.ik(true);
          }
          localObject = ae.fJe;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).Xr() >= 0)
          {
            localObject = ae.fJe;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).Xr(), null);
          }
        }
      }
    }
    if (paramBoolean)
    {
      if (ae.fJe.fDt >= 0) {
        i = ae.fJe.fDt;
      }
      ac.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      if (i != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.mRw;
        a.a.bCx().b(i, null);
      }
      super.cm(true);
    }
    for (;;)
    {
      AppMethodBeat.o(198347);
      return paramBoolean;
      int j = i;
      if (com.tencent.mm.compatible.util.k.UV())
      {
        j = i;
        if (2 == ae.fJo.fFH) {
          j = 2;
        }
      }
      if (ae.fJe.fDu >= 0) {
        j = ae.fJe.fDu;
      }
      ac.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(j)));
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      if (j != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.mRw;
        a.a.bCx().b(j, null);
      }
      super.cm(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.b
 * JD-Core Version:    0.7.0.1
 */