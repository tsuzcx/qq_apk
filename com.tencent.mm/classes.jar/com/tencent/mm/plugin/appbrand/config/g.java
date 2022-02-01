package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import org.apache.commons.b.a;

public final class g
  extends b
{
  private final String[] jDw;
  
  private g()
  {
    AppMethodBeat.i(44827);
    this.jDw = new String[] { "wx308bd2aeb83d3345" };
    AppMethodBeat.o(44827);
  }
  
  public static g baw()
  {
    try
    {
      g localg = (g)cbU;
      return localg;
    }
    finally {}
  }
  
  public static void init()
  {
    AppMethodBeat.i(44828);
    try
    {
      cbU = new g();
      return;
    }
    finally
    {
      AppMethodBeat.o(44828);
    }
  }
  
  public final AppBrandInitConfigWC JS(String paramString)
  {
    AppMethodBeat.i(44829);
    paramString = (AppBrandInitConfigWC)super.cg(paramString);
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
      localAppBrandInitConfigWC = new AppBrandInitConfigWC(((AppBrandInitConfigLU)localObject2).bau());
      if ((!???.baL().baR()) || ((!h.aSv()) && (a.contains(this.jDw, localAppBrandInitConfigWC.appId)))) {
        break label151;
      }
      bool = true;
    }
    for (;;)
    {
      localAppBrandInitConfigWC.jDy = bool;
      if (localAppBrandInitConfigWC != null) {
        localAppBrandInitConfigWC.jDJ = ???.baM().jFC.jFI;
      }
      if ((localAppBrandInitConfigWC != null) && (!TextUtils.isEmpty(localAppBrandInitConfigWC.appId)))
      {
        localObject2 = localAppBrandInitConfigWC.appId;
        ac.i("Luggage.WXA.AppBrandInitConfigHelper", "clearByAppId %s", new Object[] { localObject2 });
      }
      synchronized (this.cbV)
      {
        this.cbV.remove(localObject2);
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