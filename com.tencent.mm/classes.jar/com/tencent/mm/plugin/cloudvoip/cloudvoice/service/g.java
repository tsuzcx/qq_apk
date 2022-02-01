package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.s;

public final class g
{
  boolean isStart;
  final Object wTX;
  a wTY;
  f.a wTZ;
  
  public g()
  {
    AppMethodBeat.i(90793);
    this.wTX = new Object();
    this.isStart = false;
    this.wTZ = new f.a();
    this.wTY = new a();
    AppMethodBeat.o(90793);
  }
  
  public final int a(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(90794);
    Log.v("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.wTX)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(90794);
        return -1;
      }
      Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      a locala = this.wTY;
      s.u(paramb, "devCallBack");
      if (locala.wTy == null)
      {
        locala.wTy = new c();
        localc = locala.wTy;
        if (localc != null) {
          localc.ac(paramInt1, paramInt2, paramInt3, 0);
        }
      }
      c localc = locala.wTy;
      if (localc != null) {
        localc.R(MMApplicationContext.getContext(), false);
      }
      localc = locala.wTy;
      if (localc != null) {
        localc.UvX = paramb;
      }
      paramb = locala.wTy;
      if (paramb == null)
      {
        paramInt1 = i;
        this.wTZ.lYS = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.wTZ.aPY());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
        this.isStart = true;
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(90794);
        return paramInt1;
      }
      paramInt1 = paramb.hVD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.g
 * JD-Core Version:    0.7.0.1
 */