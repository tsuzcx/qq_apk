package com.tencent.mm.ac;

import com.tencent.f.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/kt/CommonKt$threadPoolTagDelayed$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
public final class d$f
  implements j
{
  public d$f(String paramString, a parama) {}
  
  public final boolean axI()
  {
    return this.hvq;
  }
  
  public final String getKey()
  {
    return this.hvr;
  }
  
  public final void run()
  {
    AppMethodBeat.i(204378);
    this.hvp.invoke();
    AppMethodBeat.o(204378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.d.f
 * JD-Core Version:    0.7.0.1
 */