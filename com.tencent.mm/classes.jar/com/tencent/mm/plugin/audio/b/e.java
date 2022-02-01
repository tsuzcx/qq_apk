package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class e
  extends a
{
  public static final e.a oHZ;
  
  static
  {
    AppMethodBeat.i(223965);
    oHZ = new e.a((byte)0);
    AppMethodBeat.o(223965);
  }
  
  private final boolean z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(223964);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b", new Object[] { Boolean.valueOf(a.a.cea().isSpeakerphoneOn()), Boolean.valueOf(paramBoolean1) });
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(223964);
      return false;
    }
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      if ((com.tencent.mm.plugin.audio.d.b.ceb()) || (this.gCW))
      {
        Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
        Log.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        b(3, null);
        AppMethodBeat.o(223964);
        return false;
      }
    }
    if (ae.gKu.gDA)
    {
      if (ae.gKu.anV())
      {
        if (ae.gKu.gDC >= 0) {
          b(ae.gKu.gDC, null);
        }
        for (;;)
        {
          if (ae.gKu.gDE > 0) {
            super.cV(paramBoolean1);
          }
          AppMethodBeat.o(223964);
          return paramBoolean1;
          if (ae.gKu.gDD >= 0) {
            if (paramBoolean1) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (ae.gKu.anW())
      {
        if (paramBoolean1)
        {
          if (ae.gKu.anZ()) {
            super.cV(true);
          }
          localObject = ae.gKu;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).anY() >= 0)
          {
            localObject = ae.gKu;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).anY(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(223964);
          return paramBoolean1;
          if (ae.gKu.aob()) {
            super.cV(false);
          }
          localObject = ae.gKu;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((com.tencent.mm.compatible.deviceinfo.b)localObject).aoa() >= 0)
          {
            localObject = ae.gKu;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((com.tencent.mm.compatible.deviceinfo.b)localObject).aoa(), null);
          }
        }
      }
    }
    if (paramBoolean1)
    {
      localObject = new z.d();
      ((z.d)localObject).SYE = 3;
      if (ae.gKu.gEe >= 0) {
        ((z.d)localObject).SYE = ae.gKu.gEe;
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(((z.d)localObject).SYE), Integer.valueOf(this.audioManager.getMode()) });
      if (((z.d)localObject).SYE != this.audioManager.getMode()) {
        b(((z.d)localObject).SYE, (kotlin.g.a.a)new b(this, (z.d)localObject));
      }
      Log.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cV(true);
    }
    for (;;)
    {
      AppMethodBeat.o(223964);
      return paramBoolean1;
      localObject = new z.d();
      ((z.d)localObject).SYE = 3;
      if ((com.tencent.mm.compatible.util.k.alh()) && (2 == ae.gKE.gGF)) {
        ((z.d)localObject).SYE = 2;
      }
      if (ae.gKu.gEf >= 0) {
        ((z.d)localObject).SYE = ae.gKu.gEf;
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(((z.d)localObject).SYE), Integer.valueOf(this.audioManager.getMode()) });
      if (((z.d)localObject).SYE != this.audioManager.getMode()) {
        b(((z.d)localObject).SYE, (kotlin.g.a.a)new c(this, (z.d)localObject));
      }
      Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cV(false);
    }
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(223963);
    int i = this.audioManager.getStreamMaxVolume(paramInt);
    Log.d("MicroMsg.VoIPAudioManager", "maxVolume:".concat(String.valueOf(i)));
    i /= 3;
    int j = this.audioManager.getStreamVolume(paramInt);
    if (j < i) {
      com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, i, 0);
    }
    Log.i("MicroMsg.VoIPAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean1 = z(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(223963);
    return paramBoolean1;
  }
  
  public final boolean jp(boolean paramBoolean)
  {
    AppMethodBeat.i(223962);
    paramBoolean = z(paramBoolean, false);
    AppMethodBeat.o(223962);
    return paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(e parame, z.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(e parame, z.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.e
 * JD-Core Version:    0.7.0.1
 */