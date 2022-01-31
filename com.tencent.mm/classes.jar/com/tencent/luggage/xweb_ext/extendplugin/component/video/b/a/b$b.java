package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

final class b$b
  implements a, g.a
{
  private b$b(b paramb) {}
  
  public final void a(j paramj, Format paramFormat, IOException paramIOException)
  {
    AppMethodBeat.i(139941);
    ab.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException", new Object[0]);
    AppMethodBeat.o(139941);
  }
  
  public final void oM()
  {
    AppMethodBeat.i(139938);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted");
    AppMethodBeat.o(139938);
  }
  
  public final void oN()
  {
    AppMethodBeat.i(139939);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted");
    AppMethodBeat.o(139939);
  }
  
  public final void oO()
  {
    AppMethodBeat.i(139940);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled");
    AppMethodBeat.o(139940);
  }
  
  public final void oP()
  {
    AppMethodBeat.i(139942);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onDownstreamFormatChanged");
    AppMethodBeat.o(139942);
  }
  
  public final void oQ()
  {
    AppMethodBeat.i(139943);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
    AppMethodBeat.o(139943);
  }
  
  public final void onLoadError(IOException paramIOException)
  {
    AppMethodBeat.i(139944);
    ab.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError2, IOException", new Object[0]);
    AppMethodBeat.o(139944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */