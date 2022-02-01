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
  private static final q lsw;
  public int aAS;
  public String appId;
  public int appType;
  public int dbs;
  public o iEx;
  public String jzG;
  public final boolean lrh;
  public String lrk;
  public int lsx;
  public int lsy;
  public int lsz;
  public String method;
  public String referer;
  public int statusCode;
  public String url;
  
  static
  {
    AppMethodBeat.i(180359);
    lsw = new q(true);
    AppMethodBeat.o(180359);
  }
  
  private q(boolean paramBoolean)
  {
    this.lrh = paramBoolean;
  }
  
  public static q J(o paramo)
  {
    AppMethodBeat.i(180357);
    q localq = new q(false);
    localq.appId = paramo.mAppId;
    localq.iEx = paramo;
    if (paramo.aNb() == null) {
      localq.dbs = (paramo.iDx.iOP + 1);
    }
    for (localq.aAS = paramo.aNc().aAS;; localq.aAS = paramo.aNb().jdS.pkgVersion)
    {
      AppMethodBeat.o(180357);
      return localq;
      localq.dbs = (paramo.aNb().jdS.iOQ + 1);
    }
  }
  
  public static q bmL()
  {
    return lsw;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180358);
    String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.aAS + ", appState=" + this.dbs + ", appType=" + this.appType + ", networkType='" + this.lrk + '\'' + ", pageUrl='" + this.jzG + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.lsx + ", receivedSize=" + this.lsy + ", statusCode=" + this.statusCode + ", visitType=" + this.lsz + ", referer='" + this.referer + '\'' + '}';
    AppMethodBeat.o(180358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.q
 * JD-Core Version:    0.7.0.1
 */