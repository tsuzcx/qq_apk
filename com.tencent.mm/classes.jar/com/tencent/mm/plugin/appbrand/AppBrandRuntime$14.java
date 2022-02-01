package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

final class AppBrandRuntime$14
  implements Runnable
{
  AppBrandRuntime$14(AppBrandRuntime paramAppBrandRuntime, aj paramaj, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(134456);
    this.iEk.iHS = this.iEl;
    this.iEk.iHR = this.iEm;
    int i;
    if (AppBrandRuntime.v(this.iEc).get(this.iEk.iHR) != null)
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
    }
    label118:
    for (Object localObject = (Set)AppBrandRuntime.v(this.iEc).get(this.iEk.iHR);; localObject = new CopyOnWriteArraySet())
    {
      ((Set)localObject).add(this.iEk);
      if (i == 0) {
        AppBrandRuntime.v(this.iEc).put(this.iEk.iHR, localObject);
      }
      AppMethodBeat.o(134456);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.14
 * JD-Core Version:    0.7.0.1
 */