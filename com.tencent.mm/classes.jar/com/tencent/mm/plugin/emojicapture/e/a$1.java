package com.tencent.mm.plugin.emojicapture.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class a$1
  implements Runnable
{
  public static final 1 pTj;
  
  static
  {
    AppMethodBeat.i(316);
    pTj = new 1();
    AppMethodBeat.o(316);
  }
  
  public final void run()
  {
    AppMethodBeat.i(315);
    ad.i("MicroMsg.CapturePresenter", "proxy connected");
    AppMethodBeat.o(315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.1
 * JD-Core Version:    0.7.0.1
 */