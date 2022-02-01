package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.support.v4.e.l.a;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter;", "", "()V", "mInfoMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "mObjectPool", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "doCleanupJobOnRuntimeDestroyed", "", "doCleanupJobOnRuntimeSuspended", "report", "callbackId", "", "ret", "", "setJsApiInfo", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandBaseJsApi;", "data", "path", "getPermissionValue", "safeClear", "T", "safePut", "key", "value", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "safeRemoveReturnOld", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "JsApiInfoPool", "plugin-appbrand-integration_release"})
public final class a
{
  public final SparseArray<b> khW;
  public final a khX;
  
  public a()
  {
    AppMethodBeat.i(50666);
    this.khW = new SparseArray();
    this.khX = new a();
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
  
  public final void ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(50664);
    k.h(paramString, "ret");
    b localb = (b)b(this.khW, paramInt);
    if (localb == null)
    {
      AppMethodBeat.o(50664);
      return;
    }
    long l1 = bt.GC();
    long l2 = localb.startTime;
    Object localObject = localb.khZ;
    k.g(localObject, "info.component");
    String str1 = ((h)localObject).getAppId();
    String str2 = localb.path;
    localObject = localb.kia;
    k.g(localObject, "info.api");
    String str3 = ((com.tencent.mm.plugin.appbrand.jsapi.b)localObject).getName();
    String str4 = localb.data;
    localObject = localb.khZ;
    k.g(localObject, "this.component");
    AppBrandRuntime localAppBrandRuntime = ((h)localObject).getRuntime();
    localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof o)) {
      localObject = null;
    }
    localObject = (o)localObject;
    if (localObject != null)
    {
      localObject = ((o)localObject).DU();
      if (localObject == null) {}
    }
    for (paramInt = ((e)localObject).a((c)localb.khZ, localb.kia, localb.data, false);; paramInt = -1)
    {
      i.a(str1, str2, str3, str4, paramInt, l1 - l2, paramString);
      this.khX.a(localb);
      AppMethodBeat.o(50664);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "Landroid/support/v4/util/Pools$Pool;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "()V", "mQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "acquire", "clear", "", "release", "", "jsApiInfo", "plugin-appbrand-integration_release"})
  public static final class a
    implements l.a<b>
  {
    public final ConcurrentLinkedDeque<b> khY;
    
    public a()
    {
      AppMethodBeat.i(50663);
      this.khY = new ConcurrentLinkedDeque();
      AppMethodBeat.o(50663);
    }
    
    public final boolean a(b paramb)
    {
      AppMethodBeat.i(50661);
      k.h(paramb, "jsApiInfo");
      boolean bool = this.khY.offer(paramb);
      AppMethodBeat.o(50661);
      return bool;
    }
    
    public final b bbK()
    {
      AppMethodBeat.i(50659);
      b localb2 = (b)this.khY.poll();
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = new b();
      }
      AppMethodBeat.o(50659);
      return localb1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a
 * JD-Core Version:    0.7.0.1
 */