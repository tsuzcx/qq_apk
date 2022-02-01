package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;

public final class f
{
  boolean isStart;
  final Object oWv;
  a oWw;
  f.a oWx;
  
  public f()
  {
    AppMethodBeat.i(90793);
    this.oWv = new Object();
    this.isStart = false;
    this.oWx = new f.a();
    this.oWw = new a();
    AppMethodBeat.o(90793);
  }
  
  public final int a(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(90794);
    ad.v("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.oWv)
    {
      if (this.isStart)
      {
        ad.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(90794);
        return -1;
      }
      ad.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      a locala = this.oWw;
      p.h(paramb, "devCallBack");
      if (locala.oVX == null)
      {
        locala.oVX = new c();
        localc = locala.oVX;
        if (localc != null) {
          localc.M(paramInt1, paramInt2, paramInt3, 0);
        }
      }
      c localc = locala.oVX;
      if (localc != null) {
        localc.C(aj.getContext(), false);
      }
      localc = locala.oVX;
      if (localc != null) {
        localc.BXL = paramb;
      }
      paramb = locala.oVX;
      paramInt1 = i;
      if (paramb != null) {
        paramInt1 = paramb.euS();
      }
      this.oWx.gdx = SystemClock.elapsedRealtime();
      ad.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.oWx.abj());
      ad.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
      this.isStart = true;
      ad.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(90794);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f
 * JD-Core Version:    0.7.0.1
 */