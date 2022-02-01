package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class am$a
  implements Runnable
{
  private final Runnable mRunnable;
  
  private am$a(am paramam, Runnable paramRunnable)
  {
    AppMethodBeat.i(175039);
    this.mRunnable = paramRunnable;
    am.b(paramam).add(this);
    AppMethodBeat.o(175039);
  }
  
  public final void run()
  {
    AppMethodBeat.i(175040);
    am.b(this.nsp).remove(this);
    this.mRunnable.run();
    AppMethodBeat.o(175040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am.a
 * JD-Core Version:    0.7.0.1
 */