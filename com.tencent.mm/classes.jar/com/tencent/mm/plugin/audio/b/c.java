package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class c
  extends a
{
  public static final c.a nrM;
  
  static
  {
    AppMethodBeat.i(199750);
    nrM = new c.a((byte)0);
    AppMethodBeat.o(199750);
  }
  
  private final boolean iw(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(199749);
    int j = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    if (!a.a.VL("music"))
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      if (!a.a.VL("openvoice"))
      {
        ad.i("MicroMsg.BaseMusicAudioManager", "current not running a type as MUSIC");
        AppMethodBeat.o(199749);
        return false;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    boolean bool = a.a.bGC().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    ad.m("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bGC().bGB() });
    if (bc.PD())
    {
      ad.v("MicroMsg.BaseMusicAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(199749);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if ((com.tencent.mm.plugin.audio.d.a.bGD()) || (this.fVK))
    {
      ad.i("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      b(0, null);
      AppMethodBeat.o(199749);
      return false;
    }
    if ((ae.gcF.fWh) && (ae.gcF.ZP()))
    {
      if (paramBoolean)
      {
        if (ae.gcF.ZV()) {
          super.cn(true);
        }
        localObject = ae.gcF;
        p.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).ZU() >= 0)
        {
          localObject = ae.gcF;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((b)localObject).ZU(), null);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(199749);
        return paramBoolean;
        if (ae.gcF.ZX()) {
          super.cn(false);
        }
        localObject = ae.gcF;
        p.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).ZW() >= 0)
        {
          localObject = ae.gcF;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((b)localObject).ZW(), null);
        }
      }
    }
    if (paramBoolean) {
      i = 0;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    if (!a.a.bGC().bGx())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      if (!com.tencent.mm.plugin.audio.d.a.bGD()) {}
    }
    else
    {
      i = 0;
    }
    b(i, null);
    super.cn(paramBoolean);
    AppMethodBeat.o(199749);
    return paramBoolean;
  }
  
  public final boolean iq(boolean paramBoolean)
  {
    AppMethodBeat.i(199747);
    paramBoolean = iw(paramBoolean);
    AppMethodBeat.o(199747);
    return paramBoolean;
  }
  
  public final boolean iv(boolean paramBoolean)
  {
    AppMethodBeat.i(199748);
    paramBoolean = iw(paramBoolean);
    AppMethodBeat.o(199748);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.c
 * JD-Core Version:    0.7.0.1
 */