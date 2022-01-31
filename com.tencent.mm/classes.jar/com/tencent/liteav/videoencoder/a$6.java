package com.tencent.liteav.videoencoder;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;

class a$6
  implements Runnable
{
  a$6(a parama) {}
  
  public void run()
  {
    AppMethodBeat.i(67439);
    if (a.b(this.a) == null)
    {
      AppMethodBeat.o(67439);
      return;
    }
    try
    {
      a.b(this.a).signalEndOfInputStream();
      label31:
      while (a.c(this.a, 10) >= 0) {}
      a.a(this.a);
      AppMethodBeat.o(67439);
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.6
 * JD-Core Version:    0.7.0.1
 */