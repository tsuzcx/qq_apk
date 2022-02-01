package com.tencent.mm.plugin.appbrand.ai;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ae;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.n.af;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC;", "Lcom/tencent/mm/plugin/appbrand/worker/V8EngineWorkerManagerLU;", "client", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;", "(Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;)V", "createJsRuntimeAddonExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "id", "", "engineRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getPackageMd5", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "getWasmCachePath", "reportEvaluateResult", "", "item", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManager$WorkerEvaluateDescriptor;", "startTimeMs", "", "endTimeMs", "userWorkerFirstId", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d
{
  public static final e.a uSB;
  
  static
  {
    AppMethodBeat.i(317830);
    uSB = new e.a((byte)0);
    AppMethodBeat.o(317830);
  }
  
  public e(w paramw)
  {
    super(paramw);
  }
  
  private static final void a(e parame, WeakReference paramWeakReference, String paramString, ValueCallback paramValueCallback)
  {
    AppMethodBeat.i(317825);
    s.u(parame, "this$0");
    s.checkNotNull(paramWeakReference);
    parame.a((m)paramWeakReference.get(), paramString, paramValueCallback);
    AppMethodBeat.o(317825);
  }
  
  public final o a(int paramInt, WeakReference<m> paramWeakReference)
  {
    AppMethodBeat.i(317853);
    if (ae.qxc.ordinal() == paramInt)
    {
      paramWeakReference = (o)new e..ExternalSyntheticLambda0(this, paramWeakReference);
      AppMethodBeat.o(317853);
      return paramWeakReference;
    }
    paramWeakReference = super.a(paramInt, paramWeakReference);
    s.s(paramWeakReference, "super.createJsRuntimeAdd…Executable(id, engineRef)");
    AppMethodBeat.o(317853);
    return paramWeakReference;
  }
  
  public final int aEq()
  {
    AppMethodBeat.i(317857);
    int i = ae.qxd.ordinal();
    AppMethodBeat.o(317857);
    return i;
  }
  
  protected final String arO()
  {
    AppMethodBeat.i(317844);
    String str = af.cpf();
    s.s(str, "retrieve()");
    AppMethodBeat.o(317844);
    return str;
  }
  
  protected final String c(g paramg)
  {
    Object localObject1 = null;
    AppMethodBeat.i(317840);
    s.u(paramg, "component");
    if ((paramg instanceof y))
    {
      paramg = ((y)paramg).getRuntime();
      if (paramg == null) {
        paramg = localObject1;
      }
      for (;;)
      {
        paramg = Util.nullAsNil(paramg);
        s.s(paramg, "nullAsNil(component.runt…sConfig?.appPkgInfo?.md5)");
        AppMethodBeat.o(317840);
        return paramg;
        Object localObject2 = paramg.asG();
        paramg = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((n)localObject2).qYY;
          paramg = localObject1;
          if (localObject2 != null) {
            paramg = ((WxaPkgWrappingInfo)localObject2).md5;
          }
        }
      }
    }
    AppMethodBeat.o(317840);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai.e
 * JD-Core Version:    0.7.0.1
 */