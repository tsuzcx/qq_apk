package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.dynamic.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.i;

public final class IPCDynamicPageView$3
  implements Runnable
{
  public IPCDynamicPageView$3(IPCDynamicPageView paramIPCDynamicPageView, String paramString1, Bundle paramBundle, z paramz, String paramString2) {}
  
  public final void run()
  {
    if ((IPCDynamicPageView.e(this.fXO) != null) && (!this.BD.equals(IPCDynamicPageView.e(this.fXO)))) {
      this.fXO.detach();
    }
    IPCDynamicPageView.a(this.fXO, this.BD);
    IPCDynamicPageView.d(this.fXO).setTraceId(IPCDynamicPageView.e(this.fXO));
    IPCDynamicPageView.a(this.fXO, this.fTr);
    IPCDynamicPageView.a(this.fXO, new aa(this.fXP));
    com.tencent.mm.plugin.appbrand.dynamic.a locala = IPCDynamicPageView.f(this.fXO);
    String str1 = this.BD;
    String str2 = this.val$appId;
    Bundle localBundle1 = this.fTr;
    locala.dIX = str1;
    String str3 = "Token#" + System.nanoTime();
    locala.fTo = str3;
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("id", str1);
    localBundle2.putString("appId", str2);
    if (localBundle1 != null)
    {
      localBundle2.putInt("scene", localBundle1.getInt("scene"));
      localBundle2.putInt("widgetType", localBundle1.getInt("widget_type"));
      localBundle2.putInt("serviceType", localBundle1.getInt("service_type"));
      localBundle2.putInt("wxaPkgType", localBundle1.getInt("msg_pkg_type"));
      localBundle2.putString("searchId", localBundle1.getString("search_id", ""));
      localBundle2.putInt("pkgVersion", localBundle1.getInt("pkg_version"));
      localBundle2.putString("preloadLaunchData", localBundle1.getString("preload_launch_data", ""));
      localBundle2.putString("preload_download_data", localBundle1.getString("preload_download_data", ""));
      localBundle2.putString("cache_key", localBundle1.getString("cache_key", ""));
    }
    localBundle2.putString("view_process_name", e.BV());
    u.i("MicroMsg.DynamicIPCJsBridge", " attach %s， process %s", new Object[] { str1, i.aeX().sX(str1) });
    f.a(i.aeX().sX(str1), localBundle2, a.c.class, new a.1(locala, str3, str1, str2, localBundle1));
    IPCDynamicPageView.b(this.fXO, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.3
 * JD-Core Version:    0.7.0.1
 */