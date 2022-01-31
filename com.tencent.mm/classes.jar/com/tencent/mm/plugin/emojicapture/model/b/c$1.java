package com.tencent.mm.plugin.emojicapture.model.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.gif.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$1
  implements Runnable
{
  c$1(c paramc, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(2664);
    boolean bool = c.a(this.lur).init();
    ab.i(c.b(this.lur), "init encoder, outputGif: " + this.lus + " ret: " + bool);
    d locald;
    if (!bool)
    {
      if (!this.lus) {
        break label92;
      }
      locald = d.ltx;
      d.boj();
    }
    for (;;)
    {
      c.a(this.lur, bo.yB());
      AppMethodBeat.o(2664);
      return;
      label92:
      locald = d.ltx;
      d.boi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c.1
 * JD-Core Version:    0.7.0.1
 */