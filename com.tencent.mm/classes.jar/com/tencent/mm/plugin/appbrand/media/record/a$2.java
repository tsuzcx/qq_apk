package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.sdk.platformtools.ac;

final class a$2
  implements b.a
{
  public final void onError()
  {
    AppMethodBeat.i(146136);
    ac.e("MicroMsg.Record.AudioRecorder", "onError");
    a.tU(-1);
    AppMethodBeat.o(146136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.2
 * JD-Core Version:    0.7.0.1
 */