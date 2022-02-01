package com.tencent.luggage.sdk.b.a;

import com.tencent.luggage.m.a.g;
import com.tencent.mm.plugin.appbrand.appcache.s.a;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public abstract interface d
{
  public static final String eqM = "https://" + WeChatHosts.domainString(a.g.host_servicewechat_com) + "/";
  public static final String[] eqN = { "wxa_library/android.js", "wxa_library/android-webview.js", "wxa_library/webview_pf.js" };
  public static final String[] eqO = { "WAWebview.js", "WAVConsole.js", "WAPerf.js", "WARemoteDebug.js" };
  
  public static final class a
    extends s.a
  {
    public String eqP;
    public int eqQ;
    public String scriptName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d
 * JD-Core Version:    0.7.0.1
 */