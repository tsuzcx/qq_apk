package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.apache.commons.b.a;

public final class h
  extends b
{
  private final String[] ldL;
  
  private h()
  {
    AppMethodBeat.i(44827);
    this.ldL = new String[] { "wx308bd2aeb83d3345" };
    AppMethodBeat.o(44827);
  }
  
  public static h bzT()
  {
    try
    {
      h localh = (h)cyi;
      return localh;
    }
    finally {}
  }
  
  public static void init()
  {
    AppMethodBeat.i(44828);
    try
    {
      cyi = new h();
      return;
    }
    finally
    {
      AppMethodBeat.o(44828);
    }
  }
  
  public final AppBrandInitConfigWC Xa(String paramString)
  {
    AppMethodBeat.i(44829);
    paramString = (AppBrandInitConfigWC)super.dA(paramString);
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
      localAppBrandInitConfigWC = new AppBrandInitConfigWC(((AppBrandInitConfigLU)localObject2).bzR());
      if ((!???.bAn().bAt()) || ((!i.brb()) && (a.contains(this.ldL, localAppBrandInitConfigWC.appId)))) {
        break label151;
      }
      bool = true;
    }
    for (;;)
    {
      localAppBrandInitConfigWC.ldN = bool;
      if (localAppBrandInitConfigWC != null) {
        localAppBrandInitConfigWC.ldY = ???.bAo().lgD.lgJ;
      }
      if ((localAppBrandInitConfigWC != null) && (!TextUtils.isEmpty(localAppBrandInitConfigWC.appId)))
      {
        localObject2 = localAppBrandInitConfigWC.appId;
        Log.i("Luggage.WXA.AppBrandInitConfigHelper", "clearByAppId %s", new Object[] { localObject2 });
      }
      synchronized (this.cyj)
      {
        this.cyj.remove(localObject2);
        AppMethodBeat.o(44830);
        return localAppBrandInitConfigWC;
        label151:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.h
 * JD-Core Version:    0.7.0.1
 */