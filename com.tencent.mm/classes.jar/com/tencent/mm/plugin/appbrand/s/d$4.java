package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

final class d$4
  implements Runnable
{
  d$4(d paramd, Runnable paramRunnable, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(175391);
    try
    {
      this.niq.run();
      return;
    }
    finally
    {
      this.nij.nic.remove(this.lwt);
      AppMethodBeat.o(175391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.d.4
 * JD-Core Version:    0.7.0.1
 */