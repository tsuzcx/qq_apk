package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import org.apache.commons.b.a;

public final class g
  extends b
{
  private final String[] kaH;
  
  private g()
  {
    AppMethodBeat.i(44827);
    this.kaH = new String[] { "wx308bd2aeb83d3345" };
    AppMethodBeat.o(44827);
  }
  
  public static g beC()
  {
    try
    {
      g localg = (g)cmn;
      return localg;
    }
    finally {}
  }
  
  public static void init()
  {
    AppMethodBeat.i(44828);
    try
    {
      cmn = new g();
      return;
    }
    finally
    {
      AppMethodBeat.o(44828);
    }
  }
  
  public final AppBrandInitConfigWC NS(String paramString)
  {
    AppMethodBeat.i(44829);
    paramString = (AppBrandInitConfigWC)super.dk(paramString);
    AppMethodBeat.o(44829);
    return paramString;
  }
  
  public final AppBrandInitConfigWC c(WxaAttributes arg1)
  {
    AppMethodBeat.i(44830);
    Object localObject2 = super.a(???);
    AppBrandInitConfigWC localAppBrandInitConfigWC = null;
    boolean bool;
    if (localObject2 != null)
    {
      localAppBrandInitConfigWC = new AppBrandInitConfigWC(((AppBrandInitConfigLU)localObject2).beA());
      if ((!???.beT().beZ()) || ((!i.aWg()) && (a.contains(this.kaH, localAppBrandInitConfigWC.appId)))) {
        break label151;
      }
      bool = true;
    }
    for (;;)
    {
      localAppBrandInitConfigWC.kaJ = bool;
      if (localAppBrandInitConfigWC != null) {
        localAppBrandInitConfigWC.kaU = ???.beU().kcY.kde;
      }
      if ((localAppBrandInitConfigWC != null) && (!TextUtils.isEmpty(localAppBrandInitConfigWC.appId)))
      {
        localObject2 = localAppBrandInitConfigWC.appId;
        ae.i("Luggage.WXA.AppBrandInitConfigHelper", "clearByAppId %s", new Object[] { localObject2 });
      }
      synchronized (this.cmo)
      {
        this.cmo.remove(localObject2);
        AppMethodBeat.o(44830);
        return localAppBrandInitConfigWC;
        label151:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.g
 * JD-Core Version:    0.7.0.1
 */