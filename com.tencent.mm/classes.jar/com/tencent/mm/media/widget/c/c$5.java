package com.tencent.mm.media.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.y;

final class c$5
  implements b<Boolean, y>
{
  c$5(c paramc) {}
  
  private y c(Boolean arg1)
  {
    AppMethodBeat.i(209895);
    if (!???.booleanValue())
    {
      ??? = d.gWO;
      d.arO();
    }
    synchronized (c.avq())
    {
      try
      {
        c.avq().notifyAll();
        AppMethodBeat.o(209895);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] initSurfaceLock notify error", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c.5
 * JD-Core Version:    0.7.0.1
 */