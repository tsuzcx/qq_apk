package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(20994);
    c.d(this.mNQ);
    if (c.a(this.mNQ) != null) {
      c.a(this.mNQ).c(c.b(this.mNQ));
    }
    if (c.b(this.mNQ) == null)
    {
      ab.w(c.access$200(), "already callback");
      AppMethodBeat.o(20994);
      return;
    }
    c.c(this.mNQ);
    AppMethodBeat.o(20994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.c.2
 * JD-Core Version:    0.7.0.1
 */