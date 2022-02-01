package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.ecj;

public final class d
{
  public static ecj b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    ecj localecj = null;
    AppMethodBeat.i(147319);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147319);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.jDQ)
    {
      localecj = new ecj();
      localecj.DPF = paramAppBrandLaunchReferrer.appId;
      localecj.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(147319);
    return localecj;
  }
  
  public static ebf c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    ebf localebf1 = null;
    AppMethodBeat.i(147320);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147320);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.jDQ)
    {
      localebf1 = new ebf();
      localebf1.FbF = paramAppBrandLaunchReferrer.appId;
      localebf1.Fbw = paramAppBrandLaunchReferrer.sourceType;
      localebf1.GgQ = paramAppBrandLaunchReferrer.jDS;
    }
    ebf localebf2 = localebf1;
    if (paramAppBrandLaunchReferrer.sourceType != 0)
    {
      localebf2 = localebf1;
      if (localebf1 == null) {
        localebf2 = new ebf();
      }
      localebf2.Fbw = paramAppBrandLaunchReferrer.sourceType;
    }
    AppMethodBeat.o(147320);
    return localebf2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.d
 * JD-Core Version:    0.7.0.1
 */