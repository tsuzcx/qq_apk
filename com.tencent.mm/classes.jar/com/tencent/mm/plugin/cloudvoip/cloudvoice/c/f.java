package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class f
  implements com.tencent.mm.compatible.b.g.a, HeadsetPlugReceiver.a
{
  com.tencent.mm.compatible.util.b gaP;
  boolean isStart;
  c kJR;
  final Object kJS;
  HeadsetPlugReceiver kJT;
  boolean kJU;
  boolean kJV;
  private int kJW;
  com.tencent.mm.compatible.util.g.a kJX;
  boolean kJY;
  
  public f()
  {
    AppMethodBeat.i(135472);
    this.kJR = null;
    this.kJS = new Object();
    this.isStart = false;
    this.kJU = false;
    this.kJV = false;
    this.kJX = new com.tencent.mm.compatible.util.g.a();
    this.kJY = false;
    this.gaP = new com.tencent.mm.compatible.util.b(ah.getContext());
    this.kJT = new HeadsetPlugReceiver();
    AppMethodBeat.o(135472);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(135473);
    ab.v("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.kJS)
    {
      if (this.isStart)
      {
        ab.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(135473);
        return -1;
      }
      ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.kJR == null)
      {
        this.kJR = new c();
        this.kJR.F(paramInt1, paramInt2, paramInt3, 0);
      }
      this.kJR.x(ah.getContext(), false);
      this.kJR.ttu = paramb;
      this.kJX.etf = SystemClock.elapsedRealtime();
      paramInt1 = this.kJR.cLH();
      ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.kJX.Mm());
      ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
      this.isStart = true;
      ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(135473);
      return paramInt1;
    }
  }
  
  final boolean gi(boolean paramBoolean)
  {
    AppMethodBeat.i(135474);
    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    g.KC().bN(paramBoolean);
    if ((this.kJR != null) && (this.kJR.ttj))
    {
      paramBoolean = this.kJR.mJ(paramBoolean);
      AppMethodBeat.o(135474);
      return paramBoolean;
    }
    AppMethodBeat.o(135474);
    return false;
  }
  
  public final void gj(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(135475);
    if (this.kJU != paramBoolean)
    {
      this.kJU = paramBoolean;
      ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(this.kJU), Boolean.valueOf(this.kJV) });
      if (this.kJU) {
        break label91;
      }
      paramBoolean = bool2;
      if (!this.kJV) {
        break label96;
      }
      paramBoolean = bool1;
    }
    label91:
    label96:
    for (;;)
    {
      this.kJY &= gi(paramBoolean);
      AppMethodBeat.o(135475);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(135476);
    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.kJW = paramInt;
      AppMethodBeat.o(135476);
      return;
      this.kJV = true;
      g.KC().KE();
      continue;
      if (paramInt != this.kJW)
      {
        this.kJV = true;
        this.kJY &= gi(false);
        continue;
        if (paramInt != this.kJW)
        {
          this.kJV = false;
          this.kJY &= gi(true);
          continue;
          g.KC().KE();
          continue;
          if (paramInt != this.kJW)
          {
            this.kJV = false;
            g.KC().KF();
            this.kJY &= gi(true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.f
 * JD-Core Version:    0.7.0.1
 */