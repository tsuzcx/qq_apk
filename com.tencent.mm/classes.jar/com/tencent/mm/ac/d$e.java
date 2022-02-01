package com.tencent.mm.ac;

import com.tencent.f.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/kt/CommonKt$threadPoolTag$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
public final class d$e
  implements j
{
  d$e(String paramString, a parama) {}
  
  public final boolean axI()
  {
    return this.hvq;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(204376);
    String str = this.hvr + "#" + this.hvp.hashCode();
    AppMethodBeat.o(204376);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(204377);
    this.hvp.invoke();
    AppMethodBeat.o(204377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.d.e
 * JD-Core Version:    0.7.0.1
 */