package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;

public final class f
{
  boolean isStart;
  final Object osZ;
  a ota;
  f.a otb;
  
  public f()
  {
    AppMethodBeat.i(90793);
    this.osZ = new Object();
    this.isStart = false;
    this.otb = new f.a();
    this.ota = new a();
    AppMethodBeat.o(90793);
  }
  
  public final int a(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(90794);
    ac.v("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.osZ)
    {
      if (this.isStart)
      {
        ac.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(90794);
        return -1;
      }
      ac.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      a locala = this.ota;
      k.h(paramb, "devCallBack");
      if (locala.osB == null)
      {
        locala.osB = new c();
        localc = locala.osB;
        if (localc != null) {
          localc.M(paramInt1, paramInt2, paramInt3, 0);
        }
      }
      c localc = locala.osB;
      if (localc != null) {
        localc.A(ai.getContext(), false);
      }
      localc = locala.osB;
      if (localc != null) {
        localc.Ayq = paramb;
      }
      paramb = locala.osB;
      paramInt1 = i;
      if (paramb != null) {
        paramInt1 = paramb.ehg();
      }
      this.otb.fJW = SystemClock.elapsedRealtime();
      ac.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.otb.YH());
      ac.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
      this.isStart = true;
      ac.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(90794);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f
 * JD-Core Version:    0.7.0.1
 */