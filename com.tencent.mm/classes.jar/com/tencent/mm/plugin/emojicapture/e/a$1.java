package com.tencent.mm.plugin.emojicapture.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class a$1
  implements Runnable
{
  public static final 1 rqL;
  
  static
  {
    AppMethodBeat.i(316);
    rqL = new 1();
    AppMethodBeat.o(316);
  }
  
  public final void run()
  {
    AppMethodBeat.i(315);
    Log.i("MicroMsg.CapturePresenter", "proxy connected");
    AppMethodBeat.o(315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.1
 * JD-Core Version:    0.7.0.1
 */