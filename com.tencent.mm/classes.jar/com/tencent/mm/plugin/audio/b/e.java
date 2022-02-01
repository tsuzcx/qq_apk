package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import d.g.b.v.c;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class e
  extends a
{
  public static final e.a mpn;
  
  static
  {
    AppMethodBeat.i(189236);
    mpn = new e.a((byte)0);
    AppMethodBeat.o(189236);
  }
  
  private final boolean z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(189235);
    int i = this.audioManager.getMode();
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    boolean bool = a.a.bvB().isSpeakerphoneOn();
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    ad.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b  %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), a.a.bvB().bvA() });
    if (bc.NY())
    {
      ad.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(189235);
      return false;
    }
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      if ((com.tencent.mm.plugin.audio.d.a.bvC()) || (this.fyP))
      {
        ad.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
        ad.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        a(3, null);
        AppMethodBeat.o(189235);
        return false;
      }
    }
    if (ae.fFx.fzm)
    {
      if (ae.fFx.Wo())
      {
        if (ae.fFx.fzo >= 0) {
          a(ae.fFx.fzo, null);
        }
        for (;;)
        {
          if (ae.fFx.fzq > 0) {
            super.ck(paramBoolean1);
          }
          AppMethodBeat.o(189235);
          return paramBoolean1;
          if (ae.fFx.fzp >= 0) {
            if (paramBoolean1) {
              a(0, null);
            } else {
              a(2, null);
            }
          }
        }
      }
      if (ae.fFx.Wp())
      {
        if (paramBoolean1)
        {
          if (ae.fFx.Ws()) {
            super.ck(true);
          }
          localObject = ae.fFx;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).Wr() >= 0)
          {
            localObject = ae.fFx;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            a(((b)localObject).Wr(), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(189235);
          return paramBoolean1;
          if (ae.fFx.Wu()) {
            super.ck(false);
          }
          localObject = ae.fFx;
          d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
          if (((b)localObject).Wt() >= 0)
          {
            localObject = ae.fFx;
            d.g.b.k.g(localObject, "SrvDeviceInfo.mAudioInfo");
            a(((b)localObject).Wt(), null);
          }
        }
      }
    }
    if (paramBoolean1)
    {
      localObject = new v.c();
      ((v.c)localObject).Jhu = 3;
      if (ae.fFx.fzM >= 0) {
        ((v.c)localObject).Jhu = ae.fFx.fzM;
      }
      ad.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(((v.c)localObject).Jhu), Integer.valueOf(this.audioManager.getMode()) });
      if (((v.c)localObject).Jhu != this.audioManager.getMode()) {
        a(((v.c)localObject).Jhu, (d.g.a.a)new b(this, (v.c)localObject));
      }
      ad.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.ck(true);
    }
    for (;;)
    {
      AppMethodBeat.o(189235);
      return paramBoolean1;
      localObject = new v.c();
      ((v.c)localObject).Jhu = 3;
      if ((com.tencent.mm.compatible.util.k.Ua()) && (2 == ae.fFH.fCa)) {
        ((v.c)localObject).Jhu = 2;
      }
      if (ae.fFx.fzN >= 0) {
        ((v.c)localObject).Jhu = ae.fFx.fzN;
      }
      ad.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(((v.c)localObject).Jhu), Integer.valueOf(this.audioManager.getMode()) });
      if (((v.c)localObject).Jhu != this.audioManager.getMode()) {
        a(((v.c)localObject).Jhu, (d.g.a.a)new c(this, (v.c)localObject));
      }
      ad.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.audioManager.isSpeakerphoneOn()) });
      super.ck(false);
    }
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(189234);
    int i = this.audioManager.getStreamMaxVolume(paramInt);
    ad.d("MicroMsg.VoIPAudioManager", "maxVolume:".concat(String.valueOf(i)));
    i /= 3;
    int j = this.audioManager.getStreamVolume(paramInt);
    if (j < i) {
      com.tencent.mm.compatible.b.a.b(this.audioManager, paramInt, i);
    }
    ad.i("MicroMsg.VoIPAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean1 = z(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(189234);
    return paramBoolean1;
  }
  
  public final boolean hJ(boolean paramBoolean)
  {
    AppMethodBeat.i(189233);
    paramBoolean = z(paramBoolean, false);
    AppMethodBeat.o(189233);
    return paramBoolean;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(e parame, v.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(e parame, v.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.e
 * JD-Core Version:    0.7.0.1
 */