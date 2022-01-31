package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class g$3
  implements Runnable
{
  g$3(g paramg, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(18447);
    int i = 0;
    while (i < g.a(this.jOT).size())
    {
      ((g.a)g.a(this.jOT).get(i)).rO(this.gKf);
      i += 1;
    }
    AppMethodBeat.o(18447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.g.3
 * JD-Core Version:    0.7.0.1
 */