package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.kernel.g;

final class e$1
  extends j.a
{
  e$1()
  {
    AppMethodBeat.i(111508);
    AppMethodBeat.o(111508);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(151887);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new hc();
        paramString.cwd.coO = 1;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(151887);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(151886);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new hc();
        paramString.cwd.coO = 2;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(151886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e.1
 * JD-Core Version:    0.7.0.1
 */