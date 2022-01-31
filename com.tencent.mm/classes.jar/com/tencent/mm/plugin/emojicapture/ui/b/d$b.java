package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
public final class d$b
  implements Runnable
{
  public d$b(d paramd, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(3157);
    d.a(this.lAT).onSurfaceCreated(d.b(this.lAT), this.lAT.lAM);
    d.a(this.lAT).onSurfaceChanged(d.b(this.lAT), this.lAT.width, this.lAT.height);
    a locala = this.lAU;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(3157);
      return;
    }
    AppMethodBeat.o(3157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d.b
 * JD-Core Version:    0.7.0.1
 */