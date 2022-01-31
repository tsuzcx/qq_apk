package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.appbrand.dynamic.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

final class IPCDynamicPageView$2
  implements Runnable
{
  IPCDynamicPageView$2(IPCDynamicPageView paramIPCDynamicPageView) {}
  
  public final void run()
  {
    Object localObject1 = IPCDynamicPageView.e(this.fXO);
    if (bk.bl((String)localObject1))
    {
      y.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
      return;
    }
    IPCDynamicPageView.b(this.fXO, true);
    Object localObject2 = IPCDynamicPageView.f(this.fXO);
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      y.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
      localObject2 = e.aeV();
      if (!bk.bl((String)localObject1)) {
        break label271;
      }
      y.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
    }
    for (;;)
    {
      this.fXO.cleanup();
      IPCDynamicPageView.a(this.fXO, null);
      IPCDynamicPageView.a(this.fXO, null);
      IPCDynamicPageView.a(this.fXO, null);
      IPCDynamicPageView.a(this.fXO, false);
      IPCDynamicPageView.d(this.fXO).adD();
      IPCDynamicPageView.d(this.fXO).setTraceId(null);
      return;
      y.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
      Bundle localBundle = new Bundle();
      localBundle.putString("id", (String)localObject1);
      f.a(i.aeX().sX((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
      localObject2 = j.aeZ();
      if (!((j)localObject2).fTT.containsKey(localObject1))
      {
        b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
        break;
      }
      ((j)localObject2).fTT.remove(localObject1);
      break;
      label271:
      localObject1 = (WeakReference)((e)localObject2).fTR.remove(localObject1);
      if (localObject1 != null) {
        ((WeakReference)localObject1).get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.2
 * JD-Core Version:    0.7.0.1
 */