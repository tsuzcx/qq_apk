package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;

public final class f
{
  boolean isStart;
  final Object pcY;
  a pcZ;
  f.a pda;
  
  public f()
  {
    AppMethodBeat.i(90793);
    this.pcY = new Object();
    this.isStart = false;
    this.pda = new f.a();
    this.pcZ = new a();
    AppMethodBeat.o(90793);
  }
  
  public final int a(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(90794);
    ae.v("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.pcY)
    {
      if (this.isStart)
      {
        ae.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(90794);
        return -1;
      }
      ae.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      a locala = this.pcZ;
      p.h(paramb, "devCallBack");
      if (locala.pcA == null)
      {
        locala.pcA = new c();
        localc = locala.pcA;
        if (localc != null) {
          localc.M(paramInt1, paramInt2, paramInt3, 0);
        }
      }
      c localc = locala.pcA;
      if (localc != null) {
        localc.C(ak.getContext(), false);
      }
      localc = locala.pcA;
      if (localc != null) {
        localc.Cpm = paramb;
      }
      paramb = locala.pcA;
      paramInt1 = i;
      if (paramb != null) {
        paramInt1 = paramb.eyy();
      }
      this.pda.gfF = SystemClock.elapsedRealtime();
      ae.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.pda.abs());
      ae.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
      this.isStart = true;
      ae.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(90794);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f
 * JD-Core Version:    0.7.0.1
 */