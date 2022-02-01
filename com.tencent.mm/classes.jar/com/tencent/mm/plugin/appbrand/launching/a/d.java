package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.ehj;
import com.tencent.mm.protocal.protobuf.eip;

public final class d
{
  public static eip b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    eip localeip = null;
    AppMethodBeat.i(147319);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147319);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.jXR)
    {
      localeip = new eip();
      localeip.FuU = paramAppBrandLaunchReferrer.appId;
      localeip.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(147319);
    return localeip;
  }
  
  public static ehj c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    ehj localehj1 = null;
    AppMethodBeat.i(147320);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147320);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.jXR)
    {
      localehj1 = new ehj();
      localehj1.GLe = paramAppBrandLaunchReferrer.appId;
      localehj1.GKV = paramAppBrandLaunchReferrer.sourceType;
      localehj1.HSd = paramAppBrandLaunchReferrer.jXT;
    }
    ehj localehj2 = localehj1;
    if (paramAppBrandLaunchReferrer.sourceType != 0)
    {
      localehj2 = localehj1;
      if (localehj1 == null) {
        localehj2 = new ehj();
      }
      localehj2.GKV = paramAppBrandLaunchReferrer.sourceType;
    }
    AppMethodBeat.o(147320);
    return localehj2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.d
 * JD-Core Version:    0.7.0.1
 */