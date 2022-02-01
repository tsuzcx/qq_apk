package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.protocal.protobuf.ekg;

public final class d
{
  public static ekg b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    ekg localekg = null;
    AppMethodBeat.i(147319);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147319);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.kbg)
    {
      localekg = new ekg();
      localekg.FNs = paramAppBrandLaunchReferrer.appId;
      localekg.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(147319);
    return localekg;
  }
  
  public static eja c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    eja localeja1 = null;
    AppMethodBeat.i(147320);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147320);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.kbg)
    {
      localeja1 = new eja();
      localeja1.HeF = paramAppBrandLaunchReferrer.appId;
      localeja1.Hew = paramAppBrandLaunchReferrer.sourceType;
      localeja1.Imk = paramAppBrandLaunchReferrer.kbi;
    }
    eja localeja2 = localeja1;
    if (paramAppBrandLaunchReferrer.sourceType != 0)
    {
      localeja2 = localeja1;
      if (localeja1 == null) {
        localeja2 = new eja();
      }
      localeja2.Hew = paramAppBrandLaunchReferrer.sourceType;
    }
    AppMethodBeat.o(147320);
    return localeja2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.d
 * JD-Core Version:    0.7.0.1
 */