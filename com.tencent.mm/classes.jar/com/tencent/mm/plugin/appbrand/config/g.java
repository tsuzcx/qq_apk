package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import org.apache.commons.b.a;

public final class g
  extends b
{
  private final String[] jXs;
  
  private g()
  {
    AppMethodBeat.i(44827);
    this.jXs = new String[] { "wx308bd2aeb83d3345" };
    AppMethodBeat.o(44827);
  }
  
  public static g bdW()
  {
    try
    {
      g localg = (g)cml;
      return localg;
    }
    finally {}
  }
  
  public static void init()
  {
    AppMethodBeat.i(44828);
    try
    {
      cml = new g();
      return;
    }
    finally
    {
      AppMethodBeat.o(44828);
    }
  }
  
  public final AppBrandInitConfigWC Nl(String paramString)
  {
    AppMethodBeat.i(44829);
    paramString = (AppBrandInitConfigWC)super.df(paramString);
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
      localAppBrandInitConfigWC = new AppBrandInitConfigWC(((AppBrandInitConfigLU)localObject2).bdU());
      if ((!???.bel().ber()) || ((!h.aVH()) && (a.contains(this.jXs, localAppBrandInitConfigWC.appId)))) {
        break label151;
      }
      bool = true;
    }
    for (;;)
    {
      localAppBrandInitConfigWC.jXu = bool;
      if (localAppBrandInitConfigWC != null) {
        localAppBrandInitConfigWC.jXF = ???.bem().jZH.jZN;
      }
      if ((localAppBrandInitConfigWC != null) && (!TextUtils.isEmpty(localAppBrandInitConfigWC.appId)))
      {
        localObject2 = localAppBrandInitConfigWC.appId;
        ad.i("Luggage.WXA.AppBrandInitConfigHelper", "clearByAppId %s", new Object[] { localObject2 });
      }
      synchronized (this.cmm)
      {
        this.cmm.remove(localObject2);
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