package com.tencent.mm.plugin.appbrand.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class e$4$1
  implements Runnable
{
  e$4$1(e.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(77406);
    this.jjt.jjq.removeView(this.jjt.jjs);
    Iterator localIterator = this.jjt.jjq.jjk.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(77406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.e.4.1
 * JD-Core Version:    0.7.0.1
 */