package com.tencent.luggage.sdk.b.a;

import com.tencent.luggage.l.a.g;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public abstract interface d
{
  public static final String cys = "https://" + WeChatHosts.domainString(a.g.host_servicewechat_com) + "/";
  public static final String[] cyt = { "wxa_library/android.js", "wxa_library/webview_pf.js" };
  public static final String[] cyu = { "WAWebview.js", "WAVConsole.js", "WAPerf.js", "WARemoteDebug.js" };
  
  public static final class a
    extends q.a
  {
    public String cyv;
    public int cyw;
    public String scriptName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d
 * JD-Core Version:    0.7.0.1
 */