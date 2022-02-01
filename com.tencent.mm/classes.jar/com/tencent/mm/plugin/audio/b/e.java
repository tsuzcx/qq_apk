package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bb;
import d.g.b.v.d;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class e
  extends a
{
  public static final e.a mRo;
  
  static
  {
    AppMethodBeat.i(198358);
    mRo = new e.a((byte)0);
    AppMethodBeat.o(198358);
  }
  
  private final boolean A(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(198357);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    boolean bool = a.a.bCx().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    ac.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), a.a.bCx().bCw() });
    if (bb.NU())
    {
      ac.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(198357);
      return false;
    }
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      if ((com.tencent.mm.plugin.audio.d.a.bCy()) || (this.fCw))
      {
        ac.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
        ac.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        b(3, null);
        AppMethodBeat.o(198357);
        return false;
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
            super.cm(paramBoolean1);
          }
          AppMethodBeat.o(198357);
          return paramBoolean1;
          if (ae.fJe.fCW >= 0) {
            if (paramBoolean1) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (ae.fJe.Xn())
      {
        if (paramBoolean1)
        {
          if (ae.fJe.Xq()) {
            super.cm(true);
          }
          localObject = ae.fJe;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).Xp() >= 0)
          {
            localObject = ae.fJe;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((b)localObject).Xp(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(198357);
          return paramBoolean1;
          if (ae.fJe.Xs()) {
            super.cm(false);
          }
          localObject = ae.fJe;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).Xr() >= 0)
          {
            localObject = ae.fJe;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((b)localObject).Xr(), null);
          }
        }
      }
    }
    if (paramBoolean1)
    {
      localObject = new v.d();
      ((v.d)localObject).KUO = 0;
      if (ae.fJe.fDt >= 0) {
        ((v.d)localObject).KUO = ae.fJe.fDt;
      }
      ac.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(((v.d)localObject).KUO), Integer.valueOf(this.audioManager.getMode()) });
      if (((v.d)localObject).KUO != this.audioManager.getMode()) {
        b(((v.d)localObject).KUO, (d.g.a.a)new b(this, (v.d)localObject));
      }
      ac.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cm(true);
    }
    for (;;)
    {
      AppMethodBeat.o(198357);
      return paramBoolean1;
      localObject = new v.d();
      ((v.d)localObject).KUO = 3;
      if ((com.tencent.mm.compatible.util.k.UV()) && (2 == ae.fJo.fFH)) {
        ((v.d)localObject).KUO = 2;
      }
      if (ae.fJe.fDu >= 0) {
        ((v.d)localObject).KUO = ae.fJe.fDu;
      }
      ac.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(((v.d)localObject).KUO), Integer.valueOf(this.audioManager.getMode()) });
      if (((v.d)localObject).KUO != this.audioManager.getMode()) {
        b(((v.d)localObject).KUO, (d.g.a.a)new c(this, (v.d)localObject));
      }
      ac.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cm(false);
    }
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(198356);
    int i = this.audioManager.getStreamMaxVolume(paramInt);
    ac.d("MicroMsg.VoIPAudioManager", "maxVolume:".concat(String.valueOf(i)));
    i /= 3;
    int j = this.audioManager.getStreamVolume(paramInt);
    if (j < i) {
      com.tencent.mm.compatible.b.a.b(this.audioManager, paramInt, i);
    }
    ac.i("MicroMsg.VoIPAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean1 = A(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(198356);
    return paramBoolean1;
  }
  
  public final boolean ih(boolean paramBoolean)
  {
    AppMethodBeat.i(198355);
    paramBoolean = A(paramBoolean, false);
    AppMethodBeat.o(198355);
    return paramBoolean;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(e parame, v.d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(e parame, v.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.e
 * JD-Core Version:    0.7.0.1
 */