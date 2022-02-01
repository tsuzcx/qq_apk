package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;

public final class g
{
  boolean isStart;
  final Object tQH;
  a tQI;
  f.a tQJ;
  
  public g()
  {
    AppMethodBeat.i(90793);
    this.tQH = new Object();
    this.isStart = false;
    this.tQJ = new f.a();
    this.tQI = new a();
    AppMethodBeat.o(90793);
  }
  
  public final int a(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(90794);
    Log.v("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.tQH)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(90794);
        return -1;
      }
      Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      a locala = this.tQI;
      p.k(paramb, "devCallBack");
      if (locala.tQh == null)
      {
        locala.tQh = new c();
        localc = locala.tQh;
        if (localc != null) {
          localc.S(paramInt1, paramInt2, paramInt3, 0);
        }
      }
      c localc = locala.tQh;
      if (localc != null) {
        localc.K(MMApplicationContext.getContext(), false);
      }
      localc = locala.tQh;
      if (localc != null) {
        localc.NJt = paramb;
      }
      paramb = locala.tQh;
      paramInt1 = i;
      if (paramb != null) {
        paramInt1 = paramb.gxB();
      }
      this.tQJ.jvB = SystemClock.elapsedRealtime();
      Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.tQJ.avE());
      Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
      this.isStart = true;
      Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(90794);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.g
 * JD-Core Version:    0.7.0.1
 */