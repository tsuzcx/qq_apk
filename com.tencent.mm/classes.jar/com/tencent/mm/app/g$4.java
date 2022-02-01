package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ap;
import com.tencent.mm.network.g.a;
import com.tencent.mm.sdk.platformtools.aq;

final class g$4
  extends g.a
{
  g$4(g paramg) {}
  
  public final void hr(final int paramInt)
  {
    AppMethodBeat.i(131770);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131769);
        if (b.aiS() != null) {
          b.aiS().oq(paramInt);
        }
        AppMethodBeat.o(131769);
      }
    });
    AppMethodBeat.o(131770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.g.4
 * JD-Core Version:    0.7.0.1
 */