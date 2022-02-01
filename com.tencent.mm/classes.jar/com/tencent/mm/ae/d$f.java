package com.tencent.mm.ae;

import com.tencent.e.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$threadPoolTag$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
public final class d$f
  implements j
{
  d$f(String paramString, a parama) {}
  
  public final String getKey()
  {
    AppMethodBeat.i(243394);
    String str = this.khp + "#" + this.$block.hashCode();
    AppMethodBeat.o(243394);
    return str;
  }
  
  public final boolean isLogging()
  {
    return this.kho;
  }
  
  public final void run()
  {
    AppMethodBeat.i(243395);
    this.$block.invoke();
    AppMethodBeat.o(243395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.d.f
 * JD-Core Version:    0.7.0.1
 */