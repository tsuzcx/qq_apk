package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.c.cmu;
import com.tencent.mm.protocal.c.cnk;

public final class b
{
  public static cnk b(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    if (paramAppBrandLaunchReferrer == null) {}
    while (2 != paramAppBrandLaunchReferrer.fPF) {
      return null;
    }
    cnk localcnk = new cnk();
    localcnk.svu = paramAppBrandLaunchReferrer.appId;
    localcnk.kSC = paramAppBrandLaunchReferrer.url;
    return localcnk;
  }
  
  public static cmu c(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    if (paramAppBrandLaunchReferrer == null) {}
    while (1 != paramAppBrandLaunchReferrer.fPF) {
      return null;
    }
    cmu localcmu = new cmu();
    localcmu.tmS = paramAppBrandLaunchReferrer.appId;
    localcmu.tmL = paramAppBrandLaunchReferrer.bIl;
    localcmu.tZv = paramAppBrandLaunchReferrer.fPI;
    return localcmu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */