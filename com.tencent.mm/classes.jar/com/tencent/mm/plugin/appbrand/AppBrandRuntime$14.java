package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

final class AppBrandRuntime$14
  implements Runnable
{
  AppBrandRuntime$14(AppBrandRuntime paramAppBrandRuntime, aj paramaj) {}
  
  public final void run()
  {
    AppMethodBeat.i(134456);
    Set localSet = (Set)AppBrandRuntime.v(this.jxm).get(this.jxt.jBc);
    if (localSet != null) {
      localSet.remove(this.jxt);
    }
    AppMethodBeat.o(134456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.14
 * JD-Core Version:    0.7.0.1
 */