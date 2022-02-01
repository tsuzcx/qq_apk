package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.glu;
import com.tencent.mm.protocal.protobuf.gnj;

public final class e
{
  public static gnj b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    gnj localgnj = null;
    AppMethodBeat.i(147319);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147319);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.qYE)
    {
      localgnj = new gnj();
      localgnj.abyJ = paramAppBrandLaunchReferrer.appId;
      localgnj.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(147319);
    return localgnj;
  }
  
  public static glu c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    glu localglu1 = null;
    AppMethodBeat.i(147320);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147320);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.qYE)
    {
      localglu1 = new glu();
      localglu1.aaJi = paramAppBrandLaunchReferrer.appId;
      localglu1.ZFJ = paramAppBrandLaunchReferrer.sourceType;
      localglu1.Zvp = paramAppBrandLaunchReferrer.qYG;
    }
    glu localglu2 = localglu1;
    if (paramAppBrandLaunchReferrer.sourceType != 0)
    {
      localglu2 = localglu1;
      if (localglu1 == null) {
        localglu2 = new glu();
      }
      localglu2.ZFJ = paramAppBrandLaunchReferrer.sourceType;
    }
    AppMethodBeat.o(147320);
    return localglu2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.e
 * JD-Core Version:    0.7.0.1
 */