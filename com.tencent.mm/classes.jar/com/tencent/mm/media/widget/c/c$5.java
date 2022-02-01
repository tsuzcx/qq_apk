package com.tencent.mm.media.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.x;

final class c$5
  implements b<Boolean, x>
{
  c$5(c paramc) {}
  
  private x g(Boolean arg1)
  {
    AppMethodBeat.i(260928);
    if (!???.booleanValue())
    {
      ??? = f.laB;
      f.aWh();
    }
    synchronized (c.access$600())
    {
      try
      {
        c.access$600().notifyAll();
        AppMethodBeat.o(260928);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] initSurfaceLock notify error", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c.5
 * JD-Core Version:    0.7.0.1
 */