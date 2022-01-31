package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$8
  implements Runnable
{
  k$8(k paramk, i parami1, i parami2, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(86717);
    boolean bool = this.gQD.i(this.bFh);
    if (this.gQJ != null) {
      this.gQJ.a(this.bFh.wZ(), null);
    }
    this.gQK.run();
    if ((bool) && (this.gQJ != null) && (this.gQD.bFa)) {
      this.gQJ.atw();
    }
    if (this.gQJ == null) {}
    for (String str = "null";; str = this.gQJ.mAppId)
    {
      d.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(this.gQD.bFa) });
      AppMethodBeat.o(86717);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.8
 * JD-Core Version:    0.7.0.1
 */