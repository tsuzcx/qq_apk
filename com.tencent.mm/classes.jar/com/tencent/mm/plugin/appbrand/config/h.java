package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l;
import org.apache.commons.b.a;

public final class h
  extends b
{
  private final String[] nXZ;
  
  private h()
  {
    AppMethodBeat.i(44827);
    this.nXZ = new String[] { "wx308bd2aeb83d3345" };
    AppMethodBeat.o(44827);
  }
  
  public static h bLi()
  {
    try
    {
      h localh = (h)cwL;
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
      cwL = new h();
      return;
    }
    finally
    {
      AppMethodBeat.o(44828);
    }
  }
  
  public final AppBrandInitConfigWC aeM(String paramString)
  {
    AppMethodBeat.i(44829);
    paramString = (AppBrandInitConfigWC)super.dT(paramString);
    AppMethodBeat.o(44829);
    return paramString;
  }
  
  public final AppBrandInitConfigWC c(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(44830);
    AppBrandInitConfigLU localAppBrandInitConfigLU = super.a(paramWxaAttributes);
    AppBrandInitConfigWC localAppBrandInitConfigWC = null;
    if (localAppBrandInitConfigLU != null)
    {
      localAppBrandInitConfigWC = new AppBrandInitConfigWC(localAppBrandInitConfigLU.bLg());
      if ((!paramWxaAttributes.bLF().bLL()) || ((!l.bBR()) && (a.contains(this.nXZ, localAppBrandInitConfigWC.appId)))) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localAppBrandInitConfigWC.nYb = bool;
      if (localAppBrandInitConfigWC != null) {
        localAppBrandInitConfigWC.nYm = paramWxaAttributes.bLG().obf.obo;
      }
      if ((localAppBrandInitConfigWC != null) && (!TextUtils.isEmpty(localAppBrandInitConfigWC.appId))) {
        super.dU(localAppBrandInitConfigWC.appId);
      }
      localAppBrandInitConfigWC.nBE.zq(localAppBrandInitConfigWC.cwR);
      AppMethodBeat.o(44830);
      return localAppBrandInitConfigWC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.h
 * JD-Core Version:    0.7.0.1
 */