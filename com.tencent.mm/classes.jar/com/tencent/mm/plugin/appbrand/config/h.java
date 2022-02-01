package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l;
import org.apache.commons.c.a;

public final class h
  extends b
{
  private final String[] qYb;
  
  private h()
  {
    AppMethodBeat.i(44827);
    this.qYb = new String[] { "wx308bd2aeb83d3345" };
    AppMethodBeat.o(44827);
  }
  
  public static h ckG()
  {
    try
    {
      h localh = (h)eoL;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void init()
  {
    AppMethodBeat.i(44828);
    try
    {
      eoL = new h();
      return;
    }
    finally
    {
      AppMethodBeat.o(44828);
    }
  }
  
  public final AppBrandInitConfigWC Xo(String paramString)
  {
    AppMethodBeat.i(44829);
    paramString = (AppBrandInitConfigWC)super.fd(paramString);
    AppMethodBeat.o(44829);
    return paramString;
  }
  
  public final AppBrandInitConfigWC b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(44830);
    AppBrandInitConfigLU localAppBrandInitConfigLU = super.a(paramWxaAttributes);
    AppBrandInitConfigWC localAppBrandInitConfigWC = null;
    if (localAppBrandInitConfigLU != null)
    {
      localAppBrandInitConfigWC = new AppBrandInitConfigWC(localAppBrandInitConfigLU.ckF());
      if ((!paramWxaAttributes.cld().clj()) || ((!l.cbn()) && (a.contains(this.qYb, localAppBrandInitConfigWC.appId)))) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localAppBrandInitConfigWC.qYd = bool;
      if (localAppBrandInitConfigWC != null) {
        localAppBrandInitConfigWC.qYo = paramWxaAttributes.cle().rbR.rca;
      }
      if ((localAppBrandInitConfigWC != null) && (!TextUtils.isEmpty(localAppBrandInitConfigWC.appId))) {
        super.fe(localAppBrandInitConfigWC.appId);
      }
      localAppBrandInitConfigWC.qAT.zE(localAppBrandInitConfigWC.appServiceType);
      AppMethodBeat.o(44830);
      return localAppBrandInitConfigWC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.h
 * JD-Core Version:    0.7.0.1
 */