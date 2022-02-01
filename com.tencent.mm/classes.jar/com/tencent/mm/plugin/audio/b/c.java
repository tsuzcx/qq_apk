package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.bd;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class c
  extends a
{
  public static final c.a nxf;
  
  static
  {
    AppMethodBeat.i(201062);
    nxf = new c.a((byte)0);
    AppMethodBeat.o(201062);
  }
  
  private final boolean iu(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(201061);
    int j = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    if (!a.a.Wx("music"))
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      if (!a.a.Wx("openvoice"))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseMusicAudioManager", "current not running a type as MUSIC");
        AppMethodBeat.o(201061);
        return false;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    boolean bool = a.a.bHy().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bHy().bHx() });
    if (bd.PC())
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BaseMusicAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(201061);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if ((com.tencent.mm.plugin.audio.d.a.bHz()) || (this.fXQ))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      b(0, null);
      AppMethodBeat.o(201061);
      return false;
    }
    if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYn) && (com.tencent.mm.compatible.deviceinfo.ae.geN.ZY()))
    {
      if (paramBoolean)
      {
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.aae()) {
          super.cn(true);
        }
        localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
        p.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).aad() >= 0)
        {
          localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((b)localObject).aad(), null);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(201061);
        return paramBoolean;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.aag()) {
          super.cn(false);
        }
        localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
        p.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).aaf() >= 0)
        {
          localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((b)localObject).aaf(), null);
        }
      }
    }
    if (paramBoolean) {
      i = 0;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    if (!a.a.bHy().bHt())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      if (!com.tencent.mm.plugin.audio.d.a.bHz()) {}
    }
    else
    {
      i = 0;
    }
    b(i, null);
    super.cn(paramBoolean);
    AppMethodBeat.o(201061);
    return paramBoolean;
  }
  
  public final boolean io(boolean paramBoolean)
  {
    AppMethodBeat.i(201059);
    paramBoolean = iu(paramBoolean);
    AppMethodBeat.o(201059);
    return paramBoolean;
  }
  
  public final boolean it(boolean paramBoolean)
  {
    AppMethodBeat.i(201060);
    paramBoolean = iu(paramBoolean);
    AppMethodBeat.o(201060);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.c
 * JD-Core Version:    0.7.0.1
 */