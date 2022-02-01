package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

final class AppBrandRuntime$13
  implements Runnable
{
  AppBrandRuntime$13(AppBrandRuntime paramAppBrandRuntime, aj paramaj, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(134455);
    this.jxt.jBd = this.jxu;
    this.jxt.jBc = this.jxv;
    int i;
    if (AppBrandRuntime.v(this.jxm).get(this.jxt.jBc) != null)
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
    }
    label118:
    for (Object localObject = (Set)AppBrandRuntime.v(this.jxm).get(this.jxt.jBc);; localObject = new CopyOnWriteArraySet())
    {
      ((Set)localObject).add(this.jxt);
      if (i == 0) {
        AppBrandRuntime.v(this.jxm).put(this.jxt.jBc, localObject);
      }
      AppMethodBeat.o(134455);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.13
 * JD-Core Version:    0.7.0.1
 */