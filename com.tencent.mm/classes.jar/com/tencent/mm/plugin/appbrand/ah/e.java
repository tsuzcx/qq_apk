package com.tencent.mm.plugin.appbrand.ah;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC;", "Lcom/tencent/mm/plugin/appbrand/worker/V8EngineWorkerManagerLU;", "client", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;", "(Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;)V", "createJsRuntimeAddonExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "id", "", "engineRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getPackageMd5", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "getWasmCachePath", "reportEvaluateResult", "", "item", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManager$WorkerEvaluateDescriptor;", "startTimeMs", "", "endTimeMs", "userWorkerFirstId", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends d
{
  public static final e.a rHj;
  
  static
  {
    AppMethodBeat.i(277963);
    rHj = new e.a((byte)0);
    AppMethodBeat.o(277963);
  }
  
  public e(w paramw)
  {
    super(paramw);
  }
  
  protected final String RA()
  {
    AppMethodBeat.i(277958);
    String str = af.bOR();
    p.j(str, "V8WasmCachePathRetriever.retrieve()");
    AppMethodBeat.o(277958);
    return str;
  }
  
  public final o a(int paramInt, final WeakReference<m> paramWeakReference)
  {
    AppMethodBeat.i(277960);
    if (aa.nxO.ordinal() == paramInt)
    {
      paramWeakReference = (o)new b(this, paramWeakReference);
      AppMethodBeat.o(277960);
      return paramWeakReference;
    }
    paramWeakReference = super.a(paramInt, paramWeakReference);
    p.j(paramWeakReference, "super.createJsRuntimeAdd…Executable(id, engineRef)");
    AppMethodBeat.o(277960);
    return paramWeakReference;
  }
  
  public final int acq()
  {
    AppMethodBeat.i(277962);
    int i = aa.nxP.ordinal();
    AppMethodBeat.o(277962);
    return i;
  }
  
  protected final String c(f paramf)
  {
    AppMethodBeat.i(277957);
    p.k(paramf, "component");
    if ((paramf instanceof v))
    {
      paramf = ((v)paramf).getRuntime();
      if (paramf != null)
      {
        paramf = paramf.Sp();
        if (paramf != null)
        {
          paramf = paramf.nYR;
          if (paramf == null) {}
        }
      }
      for (paramf = paramf.md5;; paramf = null)
      {
        paramf = Util.nullAsNil(paramf);
        p.j(paramf, "Util.nullAsNil(component…sConfig?.appPkgInfo?.md5)");
        AppMethodBeat.o(277957);
        return paramf;
      }
    }
    AppMethodBeat.o(277957);
    return "";
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "script", "", "kotlin.jvm.PlatformType", "cb", "Landroid/webkit/ValueCallback;", "evaluateJavascript"})
  static final class b
    implements c
  {
    b(e parame, WeakReference paramWeakReference) {}
    
    public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(267978);
      e locale = this.rHk;
      WeakReference localWeakReference = paramWeakReference;
      if (localWeakReference == null) {
        p.iCn();
      }
      locale.a((m)localWeakReference.get(), paramString, paramValueCallback);
      AppMethodBeat.o(267978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.e
 * JD-Core Version:    0.7.0.1
 */