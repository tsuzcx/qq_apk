package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

final class AppBrandRuntime$15
  implements Runnable
{
  AppBrandRuntime$15(AppBrandRuntime paramAppBrandRuntime, aj paramaj) {}
  
  public final void run()
  {
    AppMethodBeat.i(134457);
    Set localSet = (Set)AppBrandRuntime.v(this.iEc).get(this.iEk.iHR);
    if (localSet != null) {
      localSet.remove(this.iEk);
    }
    AppMethodBeat.o(134457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.15
 * JD-Core Version:    0.7.0.1
 */