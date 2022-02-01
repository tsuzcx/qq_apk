package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  extends a
{
  public static final e.a uVe;
  
  static
  {
    AppMethodBeat.i(263817);
    uVe = new e.a((byte)0);
    AppMethodBeat.o(263817);
  }
  
  private final boolean J(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(263798);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b", new Object[] { Boolean.valueOf(a.a.cTW().cTU()), Boolean.valueOf(paramBoolean1) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(263798);
      return false;
    }
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      if ((com.tencent.mm.plugin.audio.d.b.cTX()) || (cTK()))
      {
        Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
        Log.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        a.a((a)this, 3);
        AppMethodBeat.o(263798);
        return false;
      }
    }
    if (af.lXZ.lQS)
    {
      if (af.lXZ.aOv())
      {
        if (af.lXZ.lQU >= 0) {
          a.a((a)this, af.lXZ.lQU);
        }
        for (;;)
        {
          if (af.lXZ.lQW > 0) {
            super.ee(paramBoolean1);
          }
          AppMethodBeat.o(263798);
          return paramBoolean1;
          if (af.lXZ.lQV >= 0) {
            if (paramBoolean1) {
              a.a((a)this, 0);
            } else {
              a.a((a)this, 2);
            }
          }
        }
      }
      if (af.lXZ.aOw())
      {
        if (paramBoolean1)
        {
          if (af.lXZ.aOz()) {
            super.ee(true);
          }
          if (af.lXZ.aOy() >= 0) {
            a.a((a)this, af.lXZ.aOy());
          }
        }
        for (;;)
        {
          AppMethodBeat.o(263798);
          return paramBoolean1;
          if (af.lXZ.aOB()) {
            super.ee(false);
          }
          if (af.lXZ.aOA() >= 0) {
            a.a((a)this, af.lXZ.aOA());
          }
        }
      }
    }
    if (paramBoolean1)
    {
      localObject = new ah.d();
      ((ah.d)localObject).aixb = 3;
      if (af.lXZ.lRw >= 0) {
        ((ah.d)localObject).aixb = af.lXZ.lRw;
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(((ah.d)localObject).aixb), Integer.valueOf(this.audioManager.getMode()) });
      if (((ah.d)localObject).aixb != this.audioManager.getMode()) {
        b(((ah.d)localObject).aixb, (kotlin.g.a.a)new b((ah.d)localObject, this));
      }
      Log.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.ee(true);
    }
    for (;;)
    {
      AppMethodBeat.o(263798);
      return paramBoolean1;
      localObject = new ah.d();
      ((ah.d)localObject).aixb = 3;
      if ((l.isSamsung()) && (2 == af.lYj.lUf)) {
        ((ah.d)localObject).aixb = 2;
      }
      if (af.lXZ.lRx >= 0) {
        ((ah.d)localObject).aixb = af.lXZ.lRx;
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(((ah.d)localObject).aixb), Integer.valueOf(this.audioManager.getMode()) });
      if (((ah.d)localObject).aixb != this.audioManager.getMode()) {
        b(((ah.d)localObject).aixb, (kotlin.g.a.a)new c((ah.d)localObject, this));
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.ee(false);
    }
  }
  
  private static final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(263809);
    s.u(parame, "this$0");
    int i = parame.audioManager.getStreamMaxVolume(paramInt);
    Log.d("MicroMsg.VoIPAudioManager", s.X("maxVolume:", Integer.valueOf(i)));
    i /= 3;
    int j = parame.audioManager.getStreamVolume(paramInt);
    if (j < i) {
      com.tencent.mm.compatible.b.a.a(parame.audioManager, paramInt, i, 0);
    }
    Log.i("MicroMsg.VoIPAudioManager", "StreamType:" + paramInt + "  current:" + j);
    AppMethodBeat.o(263809);
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(263838);
    h.ahAA.bm(new e..ExternalSyntheticLambda0(this, paramInt));
    paramBoolean1 = J(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(263838);
    return paramBoolean1;
  }
  
  public final boolean lN(boolean paramBoolean)
  {
    AppMethodBeat.i(263831);
    paramBoolean = J(paramBoolean, false);
    AppMethodBeat.o(263831);
    return paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(ah.d paramd, e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ah.d paramd, e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.e
 * JD-Core Version:    0.7.0.1
 */