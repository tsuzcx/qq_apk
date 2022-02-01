package com.tencent.mm.plugin.appbrand.report.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebResourceRequest;
import java.util.Map;

public final class q
{
  private static final q qMr;
  public String appId;
  public int appType;
  public int appVersion;
  public int fvc;
  public String method;
  public String networkType;
  public com.tencent.mm.plugin.appbrand.t nuJ;
  public String pageUrl;
  private final boolean qLe;
  public int qMs;
  public int qMt;
  public int qMu;
  public String referer;
  public int statusCode;
  public String url;
  
  static
  {
    AppMethodBeat.i(180359);
    qMr = new q(true);
    AppMethodBeat.o(180359);
  }
  
  private q(boolean paramBoolean)
  {
    this.qLe = paramBoolean;
  }
  
  public static q H(com.tencent.mm.plugin.appbrand.t paramt)
  {
    AppMethodBeat.i(180357);
    q localq = new q(false);
    localq.appId = paramt.mAppId;
    localq.nuJ = paramt;
    if (paramt.bDx() == null) {
      localq.fvc = (paramt.ntz.cBI + 1);
    }
    for (localq.appVersion = paramt.bDy().appVersion;; localq.appVersion = paramt.bDx().nYR.pkgVersion)
    {
      AppMethodBeat.o(180357);
      return localq;
      localq.fvc = (paramt.bDx().nYR.nHY + 1);
    }
  }
  
  public static q cii()
  {
    return qMr;
  }
  
  private void report()
  {
    AppMethodBeat.i(283759);
    if (this.qLe)
    {
      AppMethodBeat.o(283759);
      return;
    }
    Log.i("MicroMsg.AppBrand.Report.kv_19358", "report " + toString());
    String str1 = this.appId;
    int i = this.appVersion;
    int j = this.fvc;
    int k = this.appType;
    String str2 = this.networkType;
    String str3 = this.pageUrl;
    String str4 = this.url;
    String str5 = this.method;
    int m = this.qMs;
    int n = this.qMt;
    int i1 = this.statusCode;
    int i2 = this.qMu;
    String str6 = this.referer;
    h.IzE.a(19358, com.tencent.mm.plugin.appbrand.report.t.j(new Object[] { str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str2, str3, str4, str5, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str6 }));
    AppMethodBeat.o(283759);
  }
  
  private void u(ah paramah)
  {
    AppMethodBeat.i(283756);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().bDx();
    if (localAppBrandSysConfigWC != null) {
      this.appVersion = localAppBrandSysConfigWC.nYR.pkgVersion;
    }
    this.networkType = j.getNetworkType(MMApplicationContext.getContext());
    paramah = paramah.getRuntime();
    if (paramah == null)
    {
      paramah = null;
      if (paramah == null) {
        break label87;
      }
      this.appType = paramah.cwR;
    }
    for (;;)
    {
      this.appType += 1000;
      AppMethodBeat.o(283756);
      return;
      paramah = paramah.bDy();
      break;
      label87:
      this.appType = k.amD(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.appType) });
    }
  }
  
  public final void a(ah paramah, String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(283755);
    if ((this.qLe) || (paramWebResourceRequest == null))
    {
      AppMethodBeat.o(283755);
      return;
    }
    this.pageUrl = paramString;
    this.url = paramWebResourceRequest.getUrl().toString();
    this.method = paramWebResourceRequest.getMethod();
    this.referer = ((String)paramWebResourceRequest.getRequestHeaders().get("Referer"));
    u(paramah);
    report();
    AppMethodBeat.o(283755);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180358);
    String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.fvc + ", appType=" + this.appType + ", networkType='" + this.networkType + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.qMs + ", receivedSize=" + this.qMt + ", statusCode=" + this.statusCode + ", visitType=" + this.qMu + ", referer='" + this.referer + '\'' + '}';
    AppMethodBeat.o(180358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.q
 * JD-Core Version:    0.7.0.1
 */