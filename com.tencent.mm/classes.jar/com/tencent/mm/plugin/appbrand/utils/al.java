package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/RunnableWithState;", "Ljava/lang/Runnable;", "realRunnable", "(Ljava/lang/Runnable;)V", "_hasRun", "", "hasRun", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  implements Runnable
{
  private final Runnable urJ;
  public volatile boolean urv;
  
  public al(Runnable paramRunnable)
  {
    AppMethodBeat.i(317354);
    this.urJ = paramRunnable;
    AppMethodBeat.o(317354);
  }
  
  public final void run()
  {
    AppMethodBeat.i(317359);
    this.urJ.run();
    this.urv = true;
    AppMethodBeat.o(317359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.al
 * JD-Core Version:    0.7.0.1
 */