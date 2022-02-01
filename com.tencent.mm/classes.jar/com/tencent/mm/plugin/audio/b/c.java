package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bb;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class c
  extends a
{
  public static final c.a mRn;
  
  static
  {
    AppMethodBeat.i(198352);
    mRn = new c.a((byte)0);
    AppMethodBeat.o(198352);
  }
  
  private final boolean in(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(198351);
    int j = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    if (!a.a.Sn("music"))
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      if (!a.a.Sn("openvoice"))
      {
        ac.i("MicroMsg.BaseMusicAudioManager", "current not running a type as MUSIC");
        AppMethodBeat.o(198351);
        return false;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    boolean bool = a.a.bCx().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    ac.m("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), a.a.bCx().bCw() });
    if (bb.NU())
    {
      ac.v("MicroMsg.BaseMusicAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(198351);
      return false;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if ((com.tencent.mm.plugin.audio.d.a.bCy()) || (this.fCw))
    {
      ac.i("MicroMsg.BaseMusicAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      b(0, null);
      AppMethodBeat.o(198351);
      return false;
    }
    if ((ae.fJe.fCT) && (ae.fJe.Xo()))
    {
      if (paramBoolean)
      {
        if (ae.fJe.Xu()) {
          super.cm(true);
        }
        localObject = ae.fJe;
        k.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).Xt() >= 0)
        {
          localObject = ae.fJe;
          k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((b)localObject).Xt(), null);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198351);
        return paramBoolean;
        if (ae.fJe.Xw()) {
          super.cm(false);
        }
        localObject = ae.fJe;
        k.g(localObject, "SrvDeviceInfo.mAudioInfo");
        if (((b)localObject).Xv() >= 0)
        {
          localObject = ae.fJe;
          k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          b(((b)localObject).Xv(), null);
        }
      }
    }
    if (paramBoolean) {
      i = 0;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    if (!a.a.bCx().bCs())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      if (!com.tencent.mm.plugin.audio.d.a.bCy()) {}
    }
    else
    {
      i = 0;
    }
    b(i, null);
    super.cm(paramBoolean);
    AppMethodBeat.o(198351);
    return paramBoolean;
  }
  
  public final boolean ih(boolean paramBoolean)
  {
    AppMethodBeat.i(198349);
    paramBoolean = in(paramBoolean);
    AppMethodBeat.o(198349);
    return paramBoolean;
  }
  
  public final boolean im(boolean paramBoolean)
  {
    AppMethodBeat.i(198350);
    paramBoolean = in(paramBoolean);
    AppMethodBeat.o(198350);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.c
 * JD-Core Version:    0.7.0.1
 */