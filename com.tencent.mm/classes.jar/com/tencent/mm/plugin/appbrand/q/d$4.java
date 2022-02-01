package com.tencent.mm.plugin.appbrand.q;

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
      this.kVc.run();
      return;
    }
    finally
    {
      this.kUV.kUN.remove(this.juK);
      AppMethodBeat.o(175391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.4
 * JD-Core Version:    0.7.0.1
 */