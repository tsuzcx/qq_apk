package com.tencent.mm.plugin.appbrand.ab;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ai;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.f.b;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.y.g;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC;", "Lcom/tencent/mm/plugin/appbrand/worker/V8EngineWorkerManagerLU;", "client", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;", "(Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;)V", "engineExtMapping", "Ljava/util/HashMap;", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$V8ContextEngineAddOn;", "Lkotlin/collections/HashMap;", "commonNativeGlobalBindTo", "", "androidContext", "Landroid/content/Context;", "engine", "convertToExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "reportEvaluateResult", "item", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManager$WorkerEvaluateDescriptor;", "startTimeMs", "", "endTimeMs", "terminate", "id", "", "Companion", "V8ContextEngineAddOn", "plugin-appbrand-integration_release"})
public final class d
  extends c
{
  public static final a nvo;
  private final HashMap<m, b> nvn;
  
  static
  {
    AppMethodBeat.i(224026);
    nvo = new a((byte)0);
    AppMethodBeat.o(224026);
  }
  
  public d(w paramw)
  {
    super(paramw);
    AppMethodBeat.i(224025);
    this.nvn = new HashMap(5);
    AppMethodBeat.o(224025);
  }
  
  public final void a(Context paramContext, final m paramm)
  {
    AppMethodBeat.i(224021);
    d.g.b.p.h(paramContext, "androidContext");
    d.g.b.p.h(paramm, "engine");
    e locale = new e();
    locale.context = paramContext;
    locale.ad(g.bCg());
    locale.cxC = ((d.g.a.a)new c(paramContext, paramm));
    locale.cxB = ((com.tencent.magicbrush.handler.a)new d(paramContext, paramm));
    locale.a((d.g.a.b)e.nvs);
    paramContext = com.tencent.mm.loader.j.b.asj();
    d.g.b.p.g(paramContext, "CConstants.DATAROOT_SDCARD_PATH()");
    locale.dE(paramContext);
    locale.bQ(true);
    locale.HA();
    locale.b(a.b.cAt);
    locale.HB();
    locale.bO(false);
    locale.bP(false);
    locale.cyj.a(f.cxA[27], Boolean.TRUE);
    paramContext = com.tencent.magicbrush.d.cxt;
    paramContext = com.tencent.magicbrush.d.a.b(locale);
    ((Map)this.nvn).put(paramm, new b(paramContext));
    AppMethodBeat.o(224021);
  }
  
  protected final void a(v.a parama)
  {
    AppMethodBeat.i(224024);
    d.g.b.p.h(parama, "item");
    Object localObject = parama.filePath;
    d.g.b.p.g(localObject, "item.filePath");
    if (!n.nG((String)localObject, "WAWorker.js"))
    {
      AppMethodBeat.o(224024);
      return;
    }
    parama = (c.a)parama;
    localObject = com.tencent.mm.plugin.appbrand.a.KI(parama.appId);
    if ((localObject == null) || (((com.tencent.mm.plugin.appbrand.p)localObject).isDestroyed()))
    {
      AppMethodBeat.o(224024);
      return;
    }
    com.tencent.mm.plugin.appbrand.report.quality.a.byG();
    com.tencent.mm.plugin.appbrand.report.quality.b.r(parama.nvm, parama.appId).rt("WAWorker.js").op(parama.script.length()).ru(((com.tencent.mm.plugin.appbrand.p)localObject).aWe().aZK()).Vp().aLH();
    AppMethodBeat.o(224024);
  }
  
  public final o b(final m paramm)
  {
    AppMethodBeat.i(224022);
    paramm = (o)new f(this, paramm);
    AppMethodBeat.o(224022);
    return paramm;
  }
  
  public final void terminate(int paramInt)
  {
    AppMethodBeat.i(224023);
    Object localObject = hz(paramInt);
    b localb;
    if (localObject != null)
    {
      localb = (b)this.nvn.remove(localObject);
      if (localb == null) {
        break label69;
      }
    }
    label69:
    for (localObject = localb.nvp;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = localb.nvp;
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        ((com.tencent.magicbrush.d)localObject).destroy();
      }
      super.terminate(paramInt);
      AppMethodBeat.o(224023);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$Companion;", "", "()V", "LIB_SCRIPT_NAME", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$V8ContextEngineAddOn;", "", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicBrush", "()Lcom/tencent/magicbrush/MagicBrush;", "setMagicBrush", "plugin-appbrand-integration_release"})
  static final class b
  {
    com.tencent.magicbrush.d nvp;
    
    public b(com.tencent.magicbrush.d paramd)
    {
      this.nvp = paramd;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke", "com/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$commonNativeGlobalBindTo$workerMagicBrushBuilder$1$1"})
  static final class c
    extends q
    implements d.g.a.a<ai>
  {
    c(Context paramContext, m paramm)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$commonNativeGlobalBindTo$workerMagicBrushBuilder$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "resumeLoopTasks", "plugin-appbrand-integration_release"})
  public static final class d
    implements com.tencent.magicbrush.handler.a
  {
    d(Context paramContext, m paramm) {}
    
    public final boolean Cw()
    {
      AppMethodBeat.i(224013);
      IJSRuntime localIJSRuntime = paramm.Nx();
      d.g.b.p.g(localIJSRuntime, "engine.jsRuntime");
      boolean bool = localIJSRuntime.Nk();
      AppMethodBeat.o(224013);
      return bool;
    }
    
    public final String Cx()
    {
      AppMethodBeat.i(224011);
      Object localObject = paramm.Nx();
      d.g.b.p.g(localObject, "engine.jsRuntime");
      localObject = ((IJSRuntime)localObject).Cx();
      AppMethodBeat.o(224011);
      return localObject;
    }
    
    public final void a(Runnable paramRunnable, boolean paramBoolean)
    {
      AppMethodBeat.i(224012);
      d.g.b.p.h(paramRunnable, "r");
      paramm.Nx().b(paramRunnable, paramBoolean);
      AppMethodBeat.o(224012);
    }
    
    public final boolean doInnerLoopTask()
    {
      AppMethodBeat.i(224014);
      boolean bool = paramm.Nx().doInnerLoopTask();
      AppMethodBeat.o(224014);
      return bool;
    }
    
    public final void resumeLoopTasks()
    {
      AppMethodBeat.i(224015);
      paramm.Nx().resumeLoopTasks();
      AppMethodBeat.o(224015);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<f.b, z>
  {
    public static final e nvs;
    
    static
    {
      AppMethodBeat.i(224017);
      nvs = new e();
      AppMethodBeat.o(224017);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$convertToExecutable$1", "Lcom/tencent/mm/plugin/appbrand/worker/IAppBrandWorkerInstanceWC;", "evaluateJavascript", "", "script", "", "cb", "Landroid/webkit/ValueCallback;", "getMBRuntime", "Lcom/tencent/magicbrush/MBRuntime;", "plugin-appbrand-integration_release"})
  public static final class f
    implements b
  {
    f(m paramm) {}
    
    public final MBRuntime bGI()
    {
      AppMethodBeat.i(224020);
      Object localObject = (d.b)((Map)d.a(this.nvt)).get(paramm);
      if (localObject != null) {}
      for (localObject = ((d.b)localObject).nvp;; localObject = null)
      {
        localObject = (MBRuntime)localObject;
        AppMethodBeat.o(224020);
        return localObject;
      }
    }
    
    public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(224019);
      m localm = paramm;
      if (localm != null)
      {
        localm.a(paramString, (m.b)new a(paramValueCallback));
        AppMethodBeat.o(224019);
        return;
      }
      AppMethodBeat.o(224019);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine$ExecuteDetails;", "onResult"})
    static final class a
      implements m.b
    {
      a(ValueCallback paramValueCallback) {}
      
      public final void a(String paramString, m.c paramc)
      {
        AppMethodBeat.i(224018);
        paramc = this.nvv;
        if (paramc != null)
        {
          paramc.onReceiveValue(paramString);
          AppMethodBeat.o(224018);
          return;
        }
        AppMethodBeat.o(224018);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.d
 * JD-Core Version:    0.7.0.1
 */