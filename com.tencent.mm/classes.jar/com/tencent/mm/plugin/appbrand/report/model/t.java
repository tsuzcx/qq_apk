package com.tencent.mm.plugin.appbrand.report.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.report.v;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebResourceRequest;
import java.util.Map;

public final class t
{
  private static final t tRb;
  public String appId;
  public int appType;
  public int appVersion;
  public int hzw;
  public String method;
  public String networkType;
  public String pageUrl;
  public w qts;
  public String referer;
  public int statusCode;
  private final boolean tPL;
  public int tRc;
  public int tRd;
  public int tRe;
  public String url;
  
  static
  {
    AppMethodBeat.i(180359);
    tRb = new t(true);
    AppMethodBeat.o(180359);
  }
  
  private t(boolean paramBoolean)
  {
    this.tPL = paramBoolean;
  }
  
  public static t R(w paramw)
  {
    AppMethodBeat.i(180357);
    t localt = new t(false);
    localt.appId = paramw.mAppId;
    localt.qts = paramw;
    if (paramw.ccM() == null) {
      localt.hzw = (paramw.qsh.eul + 1);
    }
    for (localt.appVersion = paramw.getInitConfig().appVersion;; localt.appVersion = paramw.ccM().qYY.pkgVersion)
    {
      AppMethodBeat.o(180357);
      return localt;
      localt.hzw = (paramw.ccM().qYY.qHO + 1);
    }
  }
  
  public static t cIZ()
  {
    return tRb;
  }
  
  private void report()
  {
    AppMethodBeat.i(321505);
    if (this.tPL)
    {
      AppMethodBeat.o(321505);
      return;
    }
    Log.i("MicroMsg.AppBrand.Report.kv_19358", "report " + toString());
    String str1 = this.appId;
    int i = this.appVersion;
    int j = this.hzw;
    int k = this.appType;
    String str2 = this.networkType;
    String str3 = this.pageUrl;
    String str4 = this.url;
    String str5 = this.method;
    int m = this.tRc;
    int n = this.tRd;
    int i1 = this.statusCode;
    int i2 = this.tRe;
    String str6 = this.referer;
    h.OAn.b(19358, v.l(new Object[] { str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str2, str3, str4, str5, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str6 }));
    AppMethodBeat.o(321505);
  }
  
  private void w(ah paramah)
  {
    AppMethodBeat.i(321503);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().ccM();
    if (localAppBrandSysConfigWC != null) {
      this.appVersion = localAppBrandSysConfigWC.qYY.pkgVersion;
    }
    this.networkType = j.getNetworkType(MMApplicationContext.getContext());
    paramah = paramah.getRuntime();
    if (paramah == null)
    {
      paramah = null;
      if (paramah == null) {
        break label87;
      }
      this.appType = paramah.appServiceType;
    }
    for (;;)
    {
      this.appType += 1000;
      AppMethodBeat.o(321503);
      return;
      paramah = paramah.getInitConfig();
      break;
      label87:
      this.appType = k.afP(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.appType) });
    }
  }
  
  public final void a(ah paramah, String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(321509);
    if ((this.tPL) || (paramWebResourceRequest == null))
    {
      AppMethodBeat.o(321509);
      return;
    }
    this.pageUrl = paramString;
    this.url = paramWebResourceRequest.getUrl().toString();
    this.method = paramWebResourceRequest.getMethod();
    this.referer = ((String)paramWebResourceRequest.getRequestHeaders().get("Referer"));
    w(paramah);
    report();
    AppMethodBeat.o(321509);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180358);
    String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.hzw + ", appType=" + this.appType + ", networkType='" + this.networkType + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.tRc + ", receivedSize=" + this.tRd + ", statusCode=" + this.statusCode + ", visitType=" + this.tRe + ", referer='" + this.referer + '\'' + '}';
    AppMethodBeat.o(180358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.t
 * JD-Core Version:    0.7.0.1
 */