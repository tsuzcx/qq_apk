package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.bd;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"})
public class b
  extends a
{
  public static final b.a nxe;
  
  static
  {
    AppMethodBeat.i(201058);
    nxe = new b.a((byte)0);
    AppMethodBeat.o(201058);
  }
  
  public final boolean io(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(201057);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    boolean bool = a.a.bHy().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bHy().bHx() });
    if (bd.PC())
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
      AppMethodBeat.o(201057);
      return false;
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZB)
    {
      if (paramBoolean)
      {
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZC >= 0) {
          i = com.tencent.mm.compatible.deviceinfo.ae.geN.fZC;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
        if (i != this.audioManager.getMode()) {
          b(i, null);
        }
        if (!this.audioManager.isSpeakerphoneOn()) {
          super.cn(true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(201057);
        return paramBoolean;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZD >= 0) {
          i = com.tencent.mm.compatible.deviceinfo.ae.geN.fZD;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
        localObject = com.tencent.mm.plugin.audio.c.a.nxo;
        if (i != a.a.getMode())
        {
          localObject = com.tencent.mm.plugin.audio.c.a.nxo;
          a.a.bHy().b(i, null);
        }
        if (this.audioManager.isSpeakerphoneOn()) {
          super.cn(false);
        }
      }
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYn)
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.ZW())
      {
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYp >= 0) {
          b(com.tencent.mm.compatible.deviceinfo.ae.geN.fYp, null);
        }
        for (;;)
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYr > 0) {
            super.cn(paramBoolean);
          }
          AppMethodBeat.o(201057);
          return paramBoolean;
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYq >= 0) {
            if (paramBoolean) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.ZX())
      {
        if (paramBoolean)
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.aaa()) {
            super.cn(true);
          }
          localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).ZZ() >= 0)
          {
            localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).ZZ(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(201057);
          return paramBoolean;
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.aac()) {
            super.ir(true);
          }
          localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aab() >= 0)
          {
            localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).aab(), null);
          }
        }
      }
    }
    if (paramBoolean)
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYN >= 0) {
        i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYN;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      if (i != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.nxo;
        a.a.bHy().b(i, null);
      }
      super.cn(true);
    }
    for (;;)
    {
      AppMethodBeat.o(201057);
      return paramBoolean;
      int j = i;
      if (com.tencent.mm.compatible.util.k.Xu())
      {
        j = i;
        if (2 == com.tencent.mm.compatible.deviceinfo.ae.geX.gbn) {
          j = 2;
        }
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYO >= 0) {
        j = com.tencent.mm.compatible.deviceinfo.ae.geN.fYO;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(j)));
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      if (j != a.a.getMode())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.nxo;
        a.a.bHy().b(j, null);
      }
      super.cn(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.b
 * JD-Core Version:    0.7.0.1
 */