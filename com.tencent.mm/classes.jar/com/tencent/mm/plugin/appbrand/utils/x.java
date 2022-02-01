package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageLargeScreenUtil;", "", "()V", "isLargeScreenWindow", "", "ctx", "Landroid/content/Context;", "luggage-wxa-app_release"})
public final class x
{
  public static final x riW;
  
  static
  {
    AppMethodBeat.i(246216);
    riW = new x();
    AppMethodBeat.o(246216);
  }
  
  public static final boolean es(Context paramContext)
  {
    AppMethodBeat.i(246215);
    p.k(paramContext, "ctx");
    Object localObject = paramContext.getResources();
    p.j(localObject, "ctx.resources");
    localObject = ((Resources)localObject).getDisplayMetrics();
    double d = Math.pow(((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).xdpi, 2.0D);
    d = Math.sqrt(Math.pow(((DisplayMetrics)localObject).heightPixels / ((DisplayMetrics)localObject).ydpi, 2.0D) + d);
    paramContext = paramContext.getResources();
    p.j(paramContext, "ctx.resources");
    if (((paramContext.getConfiguration().screenLayout & 0xF) >= 3) && (d >= 7.5D))
    {
      AppMethodBeat.o(246215);
      return true;
    }
    AppMethodBeat.o(246215);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.x
 * JD-Core Version:    0.7.0.1
 */