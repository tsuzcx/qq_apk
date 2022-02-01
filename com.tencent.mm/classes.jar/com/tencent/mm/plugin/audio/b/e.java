package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class e
  extends a
{
  public static final e.a nrN;
  
  static
  {
    AppMethodBeat.i(199756);
    nrN = new e.a((byte)0);
    AppMethodBeat.o(199756);
  }
  
  private final boolean A(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199755);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    boolean bool = a.a.bGC().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    ad.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), a.a.bGC().bGB() });
    if (bc.PD())
    {
      ad.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(199755);
      return false;
    }
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      if ((com.tencent.mm.plugin.audio.d.a.bGD()) || (this.fVK))
      {
        ad.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
        ad.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        b(3, null);
        AppMethodBeat.o(199755);
        return false;
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
            super.cn(paramBoolean1);
          }
          AppMethodBeat.o(199755);
          return paramBoolean1;
          if (ae.gcF.fWk >= 0) {
            if (paramBoolean1) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (ae.gcF.ZO())
      {
        if (paramBoolean1)
        {
          if (ae.gcF.ZR()) {
            super.cn(true);
          }
          localObject = ae.gcF;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).ZQ() >= 0)
          {
            localObject = ae.gcF;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((b)localObject).ZQ(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(199755);
          return paramBoolean1;
          if (ae.gcF.ZT()) {
            super.cn(false);
          }
          localObject = ae.gcF;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).ZS() >= 0)
          {
            localObject = ae.gcF;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((b)localObject).ZS(), null);
          }
        }
      }
    }
    if (paramBoolean1)
    {
      localObject = new y.d();
      ((y.d)localObject).MLT = 3;
      if (ae.gcF.fWH >= 0) {
        ((y.d)localObject).MLT = ae.gcF.fWH;
      }
      ad.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(((y.d)localObject).MLT), Integer.valueOf(this.audioManager.getMode()) });
      if (((y.d)localObject).MLT != this.audioManager.getMode()) {
        b(((y.d)localObject).MLT, (d.g.a.a)new b(this, (y.d)localObject));
      }
      ad.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cn(true);
    }
    for (;;)
    {
      AppMethodBeat.o(199755);
      return paramBoolean1;
      localObject = new y.d();
      ((y.d)localObject).MLT = 3;
      if ((com.tencent.mm.compatible.util.k.Xm()) && (2 == ae.gcP.fZg)) {
        ((y.d)localObject).MLT = 2;
      }
      if (ae.gcF.fWI >= 0) {
        ((y.d)localObject).MLT = ae.gcF.fWI;
      }
      ad.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(((y.d)localObject).MLT), Integer.valueOf(this.audioManager.getMode()) });
      if (((y.d)localObject).MLT != this.audioManager.getMode()) {
        b(((y.d)localObject).MLT, (d.g.a.a)new c(this, (y.d)localObject));
      }
      ad.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cn(false);
    }
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(199754);
    int i = this.audioManager.getStreamMaxVolume(paramInt);
    ad.d("MicroMsg.VoIPAudioManager", "maxVolume:".concat(String.valueOf(i)));
    i /= 3;
    int j = this.audioManager.getStreamVolume(paramInt);
    if (j < i) {
      com.tencent.mm.compatible.b.a.b(this.audioManager, paramInt, i);
    }
    ad.i("MicroMsg.VoIPAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean1 = A(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(199754);
    return paramBoolean1;
  }
  
  public final boolean iq(boolean paramBoolean)
  {
    AppMethodBeat.i(199753);
    paramBoolean = A(paramBoolean, false);
    AppMethodBeat.o(199753);
    return paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(e parame, y.d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(e parame, y.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.e
 * JD-Core Version:    0.7.0.1
 */