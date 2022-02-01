package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class f$3
  implements Runnable
{
  f$3(f paramf, IOException paramIOException) {}
  
  public final void run()
  {
    AppMethodBeat.i(92645);
    this.bwj.bvK.onLoadError(this.bvu);
    AppMethodBeat.o(92645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f.3
 * JD-Core Version:    0.7.0.1
 */