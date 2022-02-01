package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/utils/CancelableRunnable;", "Ljava/lang/Runnable;", "runnable", "(Ljava/lang/Runnable;)V", "_hasRun", "", "hasRun", "getHasRun", "()Z", "isCanceled", "cancel", "", "run", "luggage-wxa-app_release"})
public final class i
  implements Runnable
{
  private Runnable cvK;
  private volatile boolean isCanceled;
  public volatile boolean lMl;
  
  public i(Runnable paramRunnable)
  {
    AppMethodBeat.i(194387);
    this.cvK = paramRunnable;
    AppMethodBeat.o(194387);
  }
  
  public final void run()
  {
    AppMethodBeat.i(194386);
    if (this.isCanceled)
    {
      ad.i("MicroMsg.AppBrand.CancelableRunnable", "run, isCanceled");
      AppMethodBeat.o(194386);
      return;
    }
    if (this.lMl)
    {
      ad.i("MicroMsg.AppBrand.CancelableRunnable", "run, hasRun");
      AppMethodBeat.o(194386);
      return;
    }
    this.cvK.run();
    this.lMl = true;
    AppMethodBeat.o(194386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.i
 * JD-Core Version:    0.7.0.1
 */