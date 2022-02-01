package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$threadPool$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$g
  implements j
{
  d$g(String paramString, a<ah> parama, boolean paramBoolean) {}
  
  public final String getKey()
  {
    return this.mHI;
  }
  
  public final boolean isLogging()
  {
    return this.mHJ;
  }
  
  public final void run()
  {
    AppMethodBeat.i(233426);
    this.$block.invoke();
    AppMethodBeat.o(233426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ae.d.g
 * JD-Core Version:    0.7.0.1
 */