package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.s.m;

final class e$1
  implements Runnable
{
  e$1(e parame, c paramc, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(102126);
    m.runOnUiThread(new e.1.1(this, AppBrandPerformanceManager.g(this.iam.wj())));
    AppMethodBeat.o(102126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.e.1
 * JD-Core Version:    0.7.0.1
 */