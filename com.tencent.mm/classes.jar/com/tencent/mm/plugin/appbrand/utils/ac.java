package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageLargeScreenUtil;", "", "()V", "isLargeScreenWindow", "", "ctx", "Landroid/content/Context;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac urj;
  
  static
  {
    AppMethodBeat.i(317326);
    urj = new ac();
    AppMethodBeat.o(317326);
  }
  
  public static final boolean fo(Context paramContext)
  {
    AppMethodBeat.i(317325);
    s.u(paramContext, "ctx");
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    double d = Math.pow(localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi, 2.0D);
    d = Math.sqrt(Math.pow(localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi, 2.0D) + d);
    if (((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) && (d >= 7.5D))
    {
      AppMethodBeat.o(317325);
      return true;
    }
    AppMethodBeat.o(317325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ac
 * JD-Core Version:    0.7.0.1
 */