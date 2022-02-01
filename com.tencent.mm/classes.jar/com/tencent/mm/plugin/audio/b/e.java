package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class e
  extends a
{
  public static final e.a rJP;
  
  static
  {
    AppMethodBeat.i(257653);
    rJP = new e.a((byte)0);
    AppMethodBeat.o(257653);
  }
  
  private final boolean D(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(257652);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b", new Object[] { Boolean.valueOf(a.a.crn().crl()), Boolean.valueOf(paramBoolean1) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(257652);
      return false;
    }
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      if ((com.tencent.mm.plugin.audio.d.b.cro()) || (this.jnc))
      {
        Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
        Log.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        a.a(this, 3);
        AppMethodBeat.o(257652);
        return false;
      }
    }
    if (af.juI.jnK)
    {
      if (af.juI.atY())
      {
        if (af.juI.jnM >= 0) {
          a.a(this, af.juI.jnM);
        }
        for (;;)
        {
          if (af.juI.jnO > 0) {
            super.ds(paramBoolean1);
          }
          AppMethodBeat.o(257652);
          return paramBoolean1;
          if (af.juI.jnN >= 0) {
            if (paramBoolean1) {
              a.a(this, 0);
            } else {
              a.a(this, 2);
            }
          }
        }
      }
      if (af.juI.atZ())
      {
        if (paramBoolean1)
        {
          if (af.juI.auc()) {
            super.ds(true);
          }
          localObject = af.juI;
          p.j(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aub() >= 0)
          {
            localObject = af.juI;
            p.j(localObject, "SrvDeviceInfo.mAudioInfo");
            a.a(this, ((com.tencent.mm.compatible.deviceinfo.b)localObject).aub());
          }
        }
        for (;;)
        {
          AppMethodBeat.o(257652);
          return paramBoolean1;
          if (af.juI.aue()) {
            super.ds(false);
          }
          localObject = af.juI;
          p.j(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aud() >= 0)
          {
            localObject = af.juI;
            p.j(localObject, "SrvDeviceInfo.mAudioInfo");
            a.a(this, ((com.tencent.mm.compatible.deviceinfo.b)localObject).aud());
          }
        }
      }
    }
    if (paramBoolean1)
    {
      localObject = new aa.d();
      ((aa.d)localObject).aaBA = 3;
      if (af.juI.joo >= 0) {
        ((aa.d)localObject).aaBA = af.juI.joo;
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(((aa.d)localObject).aaBA), Integer.valueOf(this.audioManager.getMode()) });
      if (((aa.d)localObject).aaBA != this.audioManager.getMode()) {
        b(((aa.d)localObject).aaBA, (kotlin.g.a.a)new b(this, (aa.d)localObject));
      }
      Log.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.ds(true);
    }
    for (;;)
    {
      AppMethodBeat.o(257652);
      return paramBoolean1;
      localObject = new aa.d();
      ((aa.d)localObject).aaBA = 3;
      if ((com.tencent.mm.compatible.util.k.are()) && (2 == af.juS.jqR)) {
        ((aa.d)localObject).aaBA = 2;
      }
      if (af.juI.jop >= 0) {
        ((aa.d)localObject).aaBA = af.juI.jop;
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(((aa.d)localObject).aaBA), Integer.valueOf(this.audioManager.getMode()) });
      if (((aa.d)localObject).aaBA != this.audioManager.getMode()) {
        b(((aa.d)localObject).aaBA, (kotlin.g.a.a)new c(this, (aa.d)localObject));
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.ds(false);
    }
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(257650);
    int i = this.audioManager.getStreamMaxVolume(paramInt);
    Log.d("MicroMsg.VoIPAudioManager", "maxVolume:".concat(String.valueOf(i)));
    i /= 3;
    int j = this.audioManager.getStreamVolume(paramInt);
    if (j < i) {
      com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, i, 0);
    }
    Log.i("MicroMsg.VoIPAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean1 = D(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(257650);
    return paramBoolean1;
  }
  
  public final boolean kA(boolean paramBoolean)
  {
    AppMethodBeat.i(257649);
    paramBoolean = D(paramBoolean, false);
    AppMethodBeat.o(257649);
    return paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(e parame, aa.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(e parame, aa.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.e
 * JD-Core Version:    0.7.0.1
 */