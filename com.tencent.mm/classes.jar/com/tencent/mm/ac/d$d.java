package com.tencent.mm.ac;

import com.tencent.f.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/kt/CommonKt$threadPool$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
public final class d$d
  implements j
{
  d$d(String paramString, a parama, boolean paramBoolean) {}
  
  public final boolean axI()
  {
    return this.hvq;
  }
  
  public final String getKey()
  {
    return this.hvo;
  }
  
  public final void run()
  {
    AppMethodBeat.i(204375);
    this.hvp.invoke();
    AppMethodBeat.o(204375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.d.d
 * JD-Core Version:    0.7.0.1
 */