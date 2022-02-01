package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.util.SparseArray;
import androidx.core.f.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter;", "", "()V", "mInfoMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "mObjectPool", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "doCleanupJobOnRuntimeDestroyed", "", "doCleanupJobOnRuntimeSuspended", "report", "callbackId", "", "ret", "", "setJsApiInfo", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandBaseJsApi;", "data", "path", "getPermissionValue", "safeClear", "T", "safePut", "key", "value", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "safeRemoveReturnOld", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "JsApiInfoPool", "plugin-appbrand-integration_release"})
public final class a
{
  public final SparseArray<b> pnd;
  public final a pne;
  
  public a()
  {
    AppMethodBeat.i(50666);
    this.pnd = new SparseArray();
    this.pne = new a();
    AppMethodBeat.o(50666);
  }
  
  private static <T> T b(SparseArray<T> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(50665);
    try
    {
      Object localObject1 = paramSparseArray.get(paramInt, null);
      if (localObject1 != null) {
        paramSparseArray.remove(paramInt);
      }
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(50665);
    }
  }
  
  public final void aq(int paramInt, String paramString)
  {
    AppMethodBeat.i(50664);
    p.k(paramString, "ret");
    b localb = (b)b(this.pnd, paramInt);
    if (localb == null)
    {
      AppMethodBeat.o(50664);
      return;
    }
    long l1 = Util.currentTicks();
    long l2 = localb.startTime;
    Object localObject = localb.png;
    p.j(localObject, "info.component");
    String str1 = ((j)localObject).getAppId();
    String str2 = localb.path;
    localObject = localb.pnh;
    p.j(localObject, "info.api");
    String str3 = ((com.tencent.mm.plugin.appbrand.jsapi.d)localObject).getName();
    String str4 = localb.data;
    localObject = localb.png;
    p.j(localObject, "this.component");
    AppBrandRuntime localAppBrandRuntime = ((j)localObject).getRuntime();
    localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof t)) {
      localObject = null;
    }
    localObject = (t)localObject;
    if (localObject != null)
    {
      localObject = ((t)localObject).Sf();
      if (localObject == null) {}
    }
    for (paramInt = ((com.tencent.mm.plugin.appbrand.permission.d)localObject).a((e)localb.png, localb.pnh, localb.data, false);; paramInt = -1)
    {
      i.a(str1, str2, str3, str4, paramInt, l1 - l2, paramString);
      this.pne.a(localb);
      AppMethodBeat.o(50664);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "Landroidx/core/util/Pools$Pool;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "()V", "mQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "acquire", "clear", "", "release", "", "jsApiInfo", "plugin-appbrand-integration_release"})
  public static final class a
    implements f.a<b>
  {
    public final ConcurrentLinkedDeque<b> pnf;
    
    public a()
    {
      AppMethodBeat.i(50663);
      this.pnf = new ConcurrentLinkedDeque();
      AppMethodBeat.o(50663);
    }
    
    public final boolean a(b paramb)
    {
      AppMethodBeat.i(50661);
      p.k(paramb, "jsApiInfo");
      boolean bool = this.pnf.offer(paramb);
      AppMethodBeat.o(50661);
      return bool;
    }
    
    public final b bUg()
    {
      AppMethodBeat.i(50659);
      b localb2 = (b)this.pnf.poll();
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = new b();
      }
      AppMethodBeat.o(50659);
      return localb1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.a
 * JD-Core Version:    0.7.0.1
 */