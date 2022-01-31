package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.TimerTask;

final class c$2
  extends TimerTask
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(299);
    synchronized (c.b(this.mjD))
    {
      if (!c.c(this.mjD))
      {
        ab.w(c.access$300(), "hy: already stopped");
        cancel();
      }
      al.d(new c.2.1(this));
      AppMethodBeat.o(299);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c.2
 * JD-Core Version:    0.7.0.1
 */