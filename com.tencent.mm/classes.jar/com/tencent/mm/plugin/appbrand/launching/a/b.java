package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dbs;

public final class b
{
  public static dbs b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    dbs localdbs = null;
    AppMethodBeat.i(102110);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(102110);
      return null;
    }
    if (2 == paramAppBrandLaunchReferrer.hiK)
    {
      localdbs = new dbs();
      localdbs.woB = paramAppBrandLaunchReferrer.appId;
      localdbs.Url = paramAppBrandLaunchReferrer.url;
    }
    AppMethodBeat.o(102110);
    return localdbs;
  }
  
  public static das c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    das localdas1 = null;
    AppMethodBeat.i(102111);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(102111);
      return null;
    }
    if (1 == paramAppBrandLaunchReferrer.hiK)
    {
      localdas1 = new das();
      localdas1.xmJ = paramAppBrandLaunchReferrer.appId;
      localdas1.xmA = paramAppBrandLaunchReferrer.cpG;
      localdas1.yhb = paramAppBrandLaunchReferrer.hiM;
    }
    das localdas2 = localdas1;
    if (paramAppBrandLaunchReferrer.cpG != 0)
    {
      localdas2 = localdas1;
      if (localdas1 == null) {
        localdas2 = new das();
      }
      localdas2.xmA = paramAppBrandLaunchReferrer.cpG;
    }
    AppMethodBeat.o(102111);
    return localdas2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */