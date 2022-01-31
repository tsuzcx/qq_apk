package com.tencent.mm.media.widget.b;

import a.f.a.b;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$4
  implements b<Boolean, y>
{
  c$4(c paramc) {}
  
  private static y c(Boolean arg0)
  {
    AppMethodBeat.i(12742);
    if (!???.booleanValue())
    {
      ??? = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VH();
    }
    synchronized (c.EA())
    {
      try
      {
        c.EA().notifyAll();
        AppMethodBeat.o(12742);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "initSurfaceLock notify error", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c.4
 * JD-Core Version:    0.7.0.1
 */