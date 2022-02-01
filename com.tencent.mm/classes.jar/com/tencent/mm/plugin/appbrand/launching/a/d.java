package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fez;

public final class d
{
  public static fez b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    fez localfez = null;
    AppMethodBeat.i(147319);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147319);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.leo)
    {
      localfez = new fez();
      localfez.KGX = paramAppBrandLaunchReferrer.appId;
      localfez.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(147319);
    return localfez;
  }
  
  public static fds c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    fds localfds1 = null;
    AppMethodBeat.i(147320);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147320);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.leo)
    {
      localfds1 = new fds();
      localfds1.MjN = paramAppBrandLaunchReferrer.appId;
      localfds1.LEg = paramAppBrandLaunchReferrer.sourceType;
      localfds1.Nzn = paramAppBrandLaunchReferrer.leq;
    }
    fds localfds2 = localfds1;
    if (paramAppBrandLaunchReferrer.sourceType != 0)
    {
      localfds2 = localfds1;
      if (localfds1 == null) {
        localfds2 = new fds();
      }
      localfds2.LEg = paramAppBrandLaunchReferrer.sourceType;
    }
    AppMethodBeat.o(147320);
    return localfds2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.d
 * JD-Core Version:    0.7.0.1
 */