package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;

public final class q
{
  private static final q nKf;
  public String appId;
  public int appType;
  public int appVersion;
  public int dCv;
  public com.tencent.mm.plugin.appbrand.q kBw;
  public String method;
  public final boolean nIR;
  public int nKg;
  public int nKh;
  public int nKi;
  public String networkType;
  public String pageUrl;
  public String referer;
  public int statusCode;
  public String url;
  
  static
  {
    AppMethodBeat.i(180359);
    nKf = new q(true);
    AppMethodBeat.o(180359);
  }
  
  private q(boolean paramBoolean)
  {
    this.nIR = paramBoolean;
  }
  
  public static q G(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(180357);
    q localq = new q(false);
    localq.appId = paramq.mAppId;
    localq.kBw = paramq;
    if (paramq.bsB() == null) {
      localq.dCv = (paramq.kAq.eix + 1);
    }
    for (localq.appVersion = paramq.bsC().appVersion;; localq.appVersion = paramq.bsB().leE.pkgVersion)
    {
      AppMethodBeat.o(180357);
      return localq;
      localq.dCv = (paramq.bsB().leE.kNW + 1);
    }
  }
  
  public static q bUX()
  {
    return nKf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180358);
    String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", appType=" + this.appType + ", networkType='" + this.networkType + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.nKg + ", receivedSize=" + this.nKh + ", statusCode=" + this.statusCode + ", visitType=" + this.nKi + ", referer='" + this.referer + '\'' + '}';
    AppMethodBeat.o(180358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.q
 * JD-Core Version:    0.7.0.1
 */