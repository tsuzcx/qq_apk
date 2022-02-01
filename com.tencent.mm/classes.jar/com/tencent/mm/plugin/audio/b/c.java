package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class c
  extends a
{
  public static final c.a mpm;
  
  static
  {
    AppMethodBeat.i(189230);
    mpm = new c.a((byte)0);
    AppMethodBeat.o(189230);
  }
  
  public final boolean hJ(boolean paramBoolean)
  {
    int j = 3;
    AppMethodBeat.i(189229);
    int k = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    k.h("music", "type");
    if ((k.g("music", a.a.bvG().mpu[0])) || (k.g(a.a.bvG().mpu[0], ""))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.i("MicroMsg.BaseMusicAudioManager", "current not running a type as MUSIC");
      AppMethodBeat.o(189229);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    boolean bool = a.a.bvB().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    ad.m("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bvB().bvA() });
    if (bc.NY())
    {
      ad.v("MicroMsg.BaseMusicAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(k) });
      AppMethodBeat.o(189229);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if ((com.tencent.mm.plugin.audio.d.a.bvC()) || (this.fyP))
    {
      ad.i("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      a(0, null);
      AppMethodBeat.o(189229);
      return false;
    }
    if ((ae.fFx.fzm) && (ae.fFx.Wq()))
    {
      if (paramBoolean)
      {
        if (ae.fFx.Ww()) {
          super.ck(true);
        }
        localObject = ae.fFx;
        k.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).Wv() >= 0)
        {
          localObject = ae.fFx;
          k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          a(((b)localObject).Wv(), null);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(189229);
        return paramBoolean;
        if (ae.fFx.Wy()) {
          super.ck(false);
        }
        localObject = ae.fFx;
        k.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).Wx() >= 0)
        {
          localObject = ae.fFx;
          k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          a(((b)localObject).Wx(), null);
        }
      }
    }
    i = j;
    if (paramBoolean) {
      i = 0;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    if (!a.a.bvB().bvw())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      if (!com.tencent.mm.plugin.audio.d.a.bvC()) {}
    }
    else
    {
      i = 0;
    }
    a(i, null);
    super.ck(paramBoolean);
    AppMethodBeat.o(189229);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.c
 * JD-Core Version:    0.7.0.1
 */