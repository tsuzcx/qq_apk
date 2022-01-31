package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.appbrand.dynamic.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;

final class IPCDynamicPageView$2
  implements Runnable
{
  IPCDynamicPageView$2(IPCDynamicPageView paramIPCDynamicPageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(11038);
    Object localObject1 = IPCDynamicPageView.e(this.hro);
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
      AppMethodBeat.o(11038);
      return;
    }
    IPCDynamicPageView.b(this.hro, true);
    Object localObject2 = IPCDynamicPageView.f(this.hro);
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      ab.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
      localObject2 = e.azy();
      if (!bo.isNullOrNil((String)localObject1)) {
        break label289;
      }
      ab.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
    }
    for (;;)
    {
      this.hro.cleanup();
      IPCDynamicPageView.a(this.hro, null);
      IPCDynamicPageView.a(this.hro, null);
      IPCDynamicPageView.a(this.hro, null);
      IPCDynamicPageView.a(this.hro, false);
      IPCDynamicPageView.d(this.hro).axV();
      IPCDynamicPageView.d(this.hro).setTraceId(null);
      AppMethodBeat.o(11038);
      return;
      ab.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
      Bundle localBundle = new Bundle();
      localBundle.putString("id", (String)localObject1);
      f.a(i.azB().AY((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
      localObject2 = j.azD();
      if (!((j)localObject2).hnv.containsKey(localObject1))
      {
        b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
        break;
      }
      ((j)localObject2).hnv.remove(localObject1);
      break;
      label289:
      localObject1 = (WeakReference)((e)localObject2).hnt.remove(localObject1);
      if (localObject1 != null) {
        ((WeakReference)localObject1).get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.2
 * JD-Core Version:    0.7.0.1
 */