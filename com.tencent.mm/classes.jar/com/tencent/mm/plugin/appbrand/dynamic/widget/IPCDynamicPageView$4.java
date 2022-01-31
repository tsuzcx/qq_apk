package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.dynamic.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

final class IPCDynamicPageView$4
  implements Runnable
{
  IPCDynamicPageView$4(IPCDynamicPageView paramIPCDynamicPageView, Bundle paramBundle, String paramString1, String paramString2) {}
  
  public final void run()
  {
    String str = "";
    if (this.fTr != null) {
      str = this.fTr.getString("cache_key", "");
    }
    u.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", new Object[] { this.BD, this.val$appId });
    IPCDynamicPageView.a(this.fXO, b.tl(this.BD));
    if (IPCDynamicPageView.g(this.fXO) == null) {
      IPCDynamicPageView.a(this.fXO, new g());
    }
    IPCDynamicPageView.g(this.fXO).field_id = this.BD;
    IPCDynamicPageView.g(this.fXO).field_cacheKey = str;
    IPCDynamicPageView.g(this.fXO).field_appId = u.jy(IPCDynamicPageView.e(this.fXO));
    this.fXO.getDrawContext().dIV.h("id", this.BD);
    Object localObject1 = e.aeV();
    str = this.BD;
    Object localObject2 = this.fXO;
    if (bk.bl(str)) {
      y.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
    }
    for (;;)
    {
      if (this.fTr != null) {
        this.fTr.putBundle("__env_args", IPCDynamicPageView.b(this.fXO, this.fTr));
      }
      IPCDynamicPageView.f(this.fXO);
      str = this.BD;
      localObject1 = this.val$appId;
      localObject2 = this.fTr;
      Bundle localBundle = new Bundle();
      localBundle.putString("id", str);
      localBundle.putString("appId", (String)localObject1);
      localBundle.putBundle("extData", (Bundle)localObject2);
      u.i("MicroMsg.DynamicIPCJsBridge", "before IPCInvoke_AttachTo invoke", new Object[0]);
      f.a(i.aeX().sX(str), localBundle, a.a.class, null);
      return;
      if (localObject2 == null)
      {
        y.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
      }
      else
      {
        localObject1 = (WeakReference)((e)localObject1).fTR.put(str, new WeakReference(localObject2));
        if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
          y.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[] { str });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.4
 * JD-Core Version:    0.7.0.1
 */