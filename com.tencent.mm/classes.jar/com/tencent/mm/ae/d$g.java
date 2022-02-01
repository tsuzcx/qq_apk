package com.tencent.mm.ae;

import com.tencent.e.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$threadPoolTagDelayed$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
public final class d$g
  implements j
{
  d$g(String paramString, a parama) {}
  
  public final String getKey()
  {
    return this.khp;
  }
  
  public final boolean isLogging()
  {
    return this.kho;
  }
  
  public final void run()
  {
    AppMethodBeat.i(243414);
    this.$block.invoke();
    AppMethodBeat.o(243414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.d.g
 * JD-Core Version:    0.7.0.1
 */