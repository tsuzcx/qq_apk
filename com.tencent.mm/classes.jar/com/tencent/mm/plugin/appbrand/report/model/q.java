package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.p;

public final class q
{
  private static final q mze;
  public int aDD;
  public String appId;
  public int appType;
  public int dli;
  public p jAF;
  public String method;
  public final boolean mxP;
  public String mxS;
  public int mzf;
  public int mzg;
  public int mzh;
  public String pageUrl;
  public String referer;
  public int statusCode;
  public String url;
  
  static
  {
    AppMethodBeat.i(180359);
    mze = new q(true);
    AppMethodBeat.o(180359);
  }
  
  private q(boolean paramBoolean)
  {
    this.mxP = paramBoolean;
  }
  
  public static q B(p paramp)
  {
    AppMethodBeat.i(180357);
    q localq = new q(false);
    localq.appId = paramp.mAppId;
    localq.jAF = paramp;
    if (paramp.aXw() == null) {
      localq.dli = (paramp.jzC.dQv + 1);
    }
    for (localq.aDD = paramp.aXx().aDD;; localq.aDD = paramp.aXw().kbw.pkgVersion)
    {
      AppMethodBeat.o(180357);
      return localq;
      localq.dli = (paramp.aXw().kbw.jLV + 1);
    }
  }
  
  public static q byF()
  {
    return mze;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180358);
    String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dli + ", appType=" + this.appType + ", networkType='" + this.mxS + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.mzf + ", receivedSize=" + this.mzg + ", statusCode=" + this.statusCode + ", visitType=" + this.mzh + ", referer='" + this.referer + '\'' + '}';
    AppMethodBeat.o(180358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.q
 * JD-Core Version:    0.7.0.1
 */