package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.util.SparseArray;
import androidx.core.f.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter;", "", "()V", "mInfoMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "mObjectPool", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "doCleanupJobOnRuntimeDestroyed", "", "doCleanupJobOnRuntimeSuspended", "report", "callbackId", "", "ret", "", "setJsApiInfo", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandBaseJsApi;", "data", "path", "setJsApiPermissionIndexValue", "permissionIndexValue", "safeClear", "T", "safeGet", "key", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "safePut", "value", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "safeRemoveReturnOld", "JsApiInfoPool", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final SparseArray<b> srT;
  public final a srU;
  
  public a()
  {
    AppMethodBeat.i(50666);
    this.srT = new SparseArray();
    this.srU = new a();
    AppMethodBeat.o(50666);
  }
  
  public static <T> T b(SparseArray<T> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(325968);
    try
    {
      Object localObject1 = paramSparseArray.get(paramInt, null);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(325968);
    }
  }
  
  private static <T> T c(SparseArray<T> paramSparseArray, int paramInt)
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
  
  public final void aA(int paramInt, String paramString)
  {
    AppMethodBeat.i(50664);
    s.u(paramString, "ret");
    b localb = (b)c(this.srT, paramInt);
    if (localb == null)
    {
      AppMethodBeat.o(50664);
      return;
    }
    long l1 = Util.currentTicks();
    long l2 = localb.startTime;
    Object localObject = localb.srW;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.jsapi.k)localObject).getAppId())
    {
      com.tencent.mm.plugin.appbrand.report.model.k.a((String)localObject, localb.path, localb.srX.getName(), localb.data, localb.srY, l1 - l2, paramString);
      this.srU.a(localb);
      AppMethodBeat.o(50664);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "Landroidx/core/util/Pools$Pool;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "()V", "mQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "acquire", "clear", "", "release", "", "jsApiInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements e.a<b>
  {
    public final ConcurrentLinkedDeque<b> srV;
    
    public a()
    {
      AppMethodBeat.i(50663);
      this.srV = new ConcurrentLinkedDeque();
      AppMethodBeat.o(50663);
    }
    
    public final boolean a(b paramb)
    {
      AppMethodBeat.i(50661);
      s.u(paramb, "jsApiInfo");
      boolean bool = this.srV.offer(paramb);
      AppMethodBeat.o(50661);
      return bool;
    }
    
    public final b cut()
    {
      AppMethodBeat.i(50659);
      b localb = (b)this.srV.poll();
      if (localb == null)
      {
        localb = new b();
        AppMethodBeat.o(50659);
        return localb;
      }
      AppMethodBeat.o(50659);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a
 * JD-Core Version:    0.7.0.1
 */