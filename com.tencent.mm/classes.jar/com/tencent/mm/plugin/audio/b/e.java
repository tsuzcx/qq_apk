package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.bd;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class e
  extends a
{
  public static final e.a nxg;
  
  static
  {
    AppMethodBeat.i(201068);
    nxg = new e.a((byte)0);
    AppMethodBeat.o(201068);
  }
  
  private final boolean A(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201067);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    boolean bool = a.a.bHy().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), a.a.bHy().bHx() });
    if (bd.PC())
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(201067);
      return false;
    }
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      if ((com.tencent.mm.plugin.audio.d.a.bHz()) || (this.fXQ))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        b(3, null);
        AppMethodBeat.o(201067);
        return false;
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
            super.cn(paramBoolean1);
          }
          AppMethodBeat.o(201067);
          return paramBoolean1;
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYq >= 0) {
            if (paramBoolean1) {
              b(0, null);
            } else {
              b(2, null);
            }
          }
        }
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.ZX())
      {
        if (paramBoolean1)
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.aaa()) {
            super.cn(true);
          }
          localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).ZZ() >= 0)
          {
            localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((b)localObject).ZZ(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(201067);
          return paramBoolean1;
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.aac()) {
            super.cn(false);
          }
          localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
          p.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).aab() >= 0)
          {
            localObject = com.tencent.mm.compatible.deviceinfo.ae.geN;
            p.g(localObject, "SrvDeviceInfo.mAudioInfo");
            b(((b)localObject).aab(), null);
          }
        }
      }
    }
    if (paramBoolean1)
    {
      localObject = new y.d();
      ((y.d)localObject).NiW = 3;
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYN >= 0) {
        ((y.d)localObject).NiW = com.tencent.mm.compatible.deviceinfo.ae.geN.fYN;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(((y.d)localObject).NiW), Integer.valueOf(this.audioManager.getMode()) });
      if (((y.d)localObject).NiW != this.audioManager.getMode()) {
        b(((y.d)localObject).NiW, (d.g.a.a)new b(this, (y.d)localObject));
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cn(true);
    }
    for (;;)
    {
      AppMethodBeat.o(201067);
      return paramBoolean1;
      localObject = new y.d();
      ((y.d)localObject).NiW = 3;
      if ((com.tencent.mm.compatible.util.k.Xu()) && (2 == com.tencent.mm.compatible.deviceinfo.ae.geX.gbn)) {
        ((y.d)localObject).NiW = 2;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYO >= 0) {
        ((y.d)localObject).NiW = com.tencent.mm.compatible.deviceinfo.ae.geN.fYO;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(((y.d)localObject).NiW), Integer.valueOf(this.audioManager.getMode()) });
      if (((y.d)localObject).NiW != this.audioManager.getMode()) {
        b(((y.d)localObject).NiW, (d.g.a.a)new c(this, (y.d)localObject));
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.cn(false);
    }
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(201066);
    int i = this.audioManager.getStreamMaxVolume(paramInt);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoIPAudioManager", "maxVolume:".concat(String.valueOf(i)));
    i /= 3;
    int j = this.audioManager.getStreamVolume(paramInt);
    if (j < i) {
      com.tencent.mm.compatible.b.a.b(this.audioManager, paramInt, i);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIPAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean1 = A(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(201066);
    return paramBoolean1;
  }
  
  public final boolean io(boolean paramBoolean)
  {
    AppMethodBeat.i(201065);
    paramBoolean = A(paramBoolean, false);
    AppMethodBeat.o(201065);
    return paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(e parame, y.d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.e
 * JD-Core Version:    0.7.0.1
 */