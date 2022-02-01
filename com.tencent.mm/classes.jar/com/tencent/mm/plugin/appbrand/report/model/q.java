package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.o;

public final class q
{
  private static final q lUq;
  public int aBM;
  public String appId;
  public int appType;
  public int cYO;
  public o jez;
  public final boolean lTc;
  public String lTf;
  public int lUr;
  public int lUs;
  public int lUt;
  public String method;
  public String pageUrl;
  public String referer;
  public int statusCode;
  public String url;
  
  static
  {
    AppMethodBeat.i(180359);
    lUq = new q(true);
    AppMethodBeat.o(180359);
  }
  
  private q(boolean paramBoolean)
  {
    this.lTc = paramBoolean;
  }
  
  public static q J(o paramo)
  {
    AppMethodBeat.i(180357);
    q localq = new q(false);
    localq.appId = paramo.mAppId;
    localq.jez = paramo;
    if (paramo.aTR() == null) {
      localq.cYO = (paramo.jdx.joY + 1);
    }
    for (localq.aBM = paramo.aTS().aBM;; localq.aBM = paramo.aTR().jEg.pkgVersion)
    {
      AppMethodBeat.o(180357);
      return localq;
      localq.cYO = (paramo.aTR().jEg.jpa + 1);
    }
  }
  
  public static q btH()
  {
    return lUq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180358);
    String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.aBM + ", appState=" + this.cYO + ", appType=" + this.appType + ", networkType='" + this.lTf + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.lUr + ", receivedSize=" + this.lUs + ", statusCode=" + this.statusCode + ", visitType=" + this.lUt + ", referer='" + this.referer + '\'' + '}';
    AppMethodBeat.o(180358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.q
 * JD-Core Version:    0.7.0.1
 */