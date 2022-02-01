package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.fot;
import com.tencent.mm.protocal.protobuf.fqa;

public final class e
{
  public static fqa b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    fqa localfqa = null;
    AppMethodBeat.i(147319);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147319);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.nYB)
    {
      localfqa = new fqa();
      localfqa.Uhg = paramAppBrandLaunchReferrer.appId;
      localfqa.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(147319);
    return localfqa;
  }
  
  public static fot c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    fot localfot1 = null;
    AppMethodBeat.i(147320);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(147320);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.nYB)
    {
      localfot1 = new fot();
      localfot1.TuC = paramAppBrandLaunchReferrer.appId;
      localfot1.SEl = paramAppBrandLaunchReferrer.sourceType;
      localfot1.UMQ = paramAppBrandLaunchReferrer.nYD;
    }
    fot localfot2 = localfot1;
    if (paramAppBrandLaunchReferrer.sourceType != 0)
    {
      localfot2 = localfot1;
      if (localfot1 == null) {
        localfot2 = new fot();
      }
      localfot2.SEl = paramAppBrandLaunchReferrer.sourceType;
    }
    AppMethodBeat.o(147320);
    return localfot2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.e
 * JD-Core Version:    0.7.0.1
 */