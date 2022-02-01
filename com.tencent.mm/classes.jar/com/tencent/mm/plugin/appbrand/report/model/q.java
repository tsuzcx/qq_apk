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
  private static final q muh;
  public int aDD;
  public String appId;
  public int appType;
  public int dkg;
  public o jxG;
  public String method;
  public final boolean msS;
  public String msV;
  public int mui;
  public int muj;
  public int muk;
  public String pageUrl;
  public String referer;
  public int statusCode;
  public String url;
  
  static
  {
    AppMethodBeat.i(180359);
    muh = new q(true);
    AppMethodBeat.o(180359);
  }
  
  private q(boolean paramBoolean)
  {
    this.msS = paramBoolean;
  }
  
  public static q A(o paramo)
  {
    AppMethodBeat.i(180357);
    q localq = new q(false);
    localq.appId = paramo.mAppId;
    localq.jxG = paramo;
    if (paramo.aXb() == null) {
      localq.dkg = (paramo.jwG.dPf + 1);
    }
    for (localq.aDD = paramo.aXc().aDD;; localq.aDD = paramo.aXb().jYh.pkgVersion)
    {
      AppMethodBeat.o(180357);
      return localq;
      localq.dkg = (paramo.aXb().jYh.jIU + 1);
    }
  }
  
  public static q bxM()
  {
    return muh;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180358);
    String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dkg + ", appType=" + this.appType + ", networkType='" + this.msV + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.mui + ", receivedSize=" + this.muj + ", statusCode=" + this.statusCode + ", visitType=" + this.muk + ", referer='" + this.referer + '\'' + '}';
    AppMethodBeat.o(180358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.q
 * JD-Core Version:    0.7.0.1
 */