package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements d.a
{
  public final boolean cqg()
  {
    AppMethodBeat.i(327775);
    int i = ((c)h.ax(c.class)).a(c.a.yGK, 0);
    Log.i("MicroMsg.Audio.AudioInterruptionExptImpl", "audio_open_interruption_event:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(327775);
      return true;
    }
    AppMethodBeat.o(327775);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */