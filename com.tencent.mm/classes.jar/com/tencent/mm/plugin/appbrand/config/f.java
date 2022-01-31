package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.a;

public final class f
  extends b
{
  private final String[] hiB;
  
  private f()
  {
    AppMethodBeat.i(129827);
    this.hiB = new String[] { "wx308bd2aeb83d3345" };
    AppMethodBeat.o(129827);
  }
  
  public static f ayv()
  {
    try
    {
      f localf = (f)bCQ;
      return localf;
    }
    finally {}
  }
  
  public static void init()
  {
    AppMethodBeat.i(129828);
    try
    {
      bCQ = new f();
      q.ayA().add(bCQ);
      return;
    }
    finally
    {
      AppMethodBeat.o(129828);
    }
  }
  
  public final AppBrandInitConfigWC Aa(String paramString)
  {
    AppMethodBeat.i(129829);
    paramString = (AppBrandInitConfigWC)super.cb(paramString);
    AppMethodBeat.o(129829);
    return paramString;
  }
  
  public final AppBrandInitConfigWC b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(129830);
    AppBrandInitConfigLU localAppBrandInitConfigLU = super.a(paramWxaAttributes);
    AppBrandInitConfigWC localAppBrandInitConfigWC = null;
    if (localAppBrandInitConfigLU != null)
    {
      localAppBrandInitConfigWC = new AppBrandInitConfigWC(localAppBrandInitConfigLU.ayu());
      if (((!paramWxaAttributes.ayC().ayH()) && (paramWxaAttributes.ayC().fmF != 7)) || ((!com.tencent.mm.plugin.appbrand.f.atc()) && (a.contains(this.hiB, localAppBrandInitConfigWC.appId)))) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      localAppBrandInitConfigWC.hiD = bool;
      AppMethodBeat.o(129830);
      return localAppBrandInitConfigWC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.f
 * JD-Core Version:    0.7.0.1
 */