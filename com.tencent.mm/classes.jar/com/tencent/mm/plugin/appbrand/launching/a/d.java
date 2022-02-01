package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.protocal.protobuf.dws;

public final class d
{
  public static dws b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    dws localdws = null;
    AppMethodBeat.i(147319);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147319);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.jdC)
    {
      localdws = new dws();
      localdws.Cxj = paramAppBrandLaunchReferrer.appId;
      localdws.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(147319);
    return localdws;
  }
  
  public static dvo c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    dvo localdvo1 = null;
    AppMethodBeat.i(147320);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147320);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.jdC)
    {
      localdvo1 = new dvo();
      localdvo1.DGl = paramAppBrandLaunchReferrer.appId;
      localdvo1.DGc = paramAppBrandLaunchReferrer.sourceType;
      localdvo1.EJE = paramAppBrandLaunchReferrer.jdE;
    }
    dvo localdvo2 = localdvo1;
    if (paramAppBrandLaunchReferrer.sourceType != 0)
    {
      localdvo2 = localdvo1;
      if (localdvo1 == null) {
        localdvo2 = new dvo();
      }
      localdvo2.DGc = paramAppBrandLaunchReferrer.sourceType;
    }
    AppMethodBeat.o(147320);
    return localdvo2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.d
 * JD-Core Version:    0.7.0.1
 */