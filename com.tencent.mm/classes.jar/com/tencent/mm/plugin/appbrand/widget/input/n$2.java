package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

final class n$2
  implements Runnable
{
  n$2(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(126664);
    ab.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(n.d(this.jmf).size()) });
    if (n.d(this.jmf).size() <= 0)
    {
      AppMethodBeat.o(126664);
      return;
    }
    n.a[] arrayOfa = new n.a[n.d(this.jmf).size()];
    n.d(this.jmf).toArray(arrayOfa);
    AppMethodBeat.o(126664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.n.2
 * JD-Core Version:    0.7.0.1
 */