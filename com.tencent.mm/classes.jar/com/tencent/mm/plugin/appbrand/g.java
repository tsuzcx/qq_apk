package com.tencent.mm.plugin.appbrand;

import a.f.b.j;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/AppBrandProcessSharedPersistentRuntimeStore;", "", "()V", "TAG", "", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "contains", "", "runtime", "isAllEquals", "array", "", "objectToMatch", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "isEmpty", "pollOrCreate", "activity", "Landroid/app/Activity;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "remotePop", "", "remove", "stash", "resetBaseContext", "base", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class g
{
  private static final ConcurrentHashMap<String, o> gPr;
  public static final g gPs;
  
  static
  {
    AppMethodBeat.i(143724);
    gPs = new g();
    gPr = new ConcurrentHashMap();
    AppMethodBeat.o(143724);
  }
  
  public static final o a(Activity paramActivity, AppBrandInitConfigWC paramAppBrandInitConfigWC, l paraml)
  {
    boolean bool2 = true;
    AppMethodBeat.i(143719);
    j.q(paramActivity, "activity");
    j.q(paramAppBrandInitConfigWC, "cfg");
    j.q(paraml, "container");
    paramAppBrandInitConfigWC = (o)gPr.remove(paramAppBrandInitConfigWC.appId);
    if (paramAppBrandInitConfigWC != null)
    {
      f(paramAppBrandInitConfigWC);
      Boolean[] arrayOfBoolean = new Boolean[3];
      arrayOfBoolean[0] = Boolean.valueOf(paramAppBrandInitConfigWC.atp());
      if (!paramAppBrandInitConfigWC.isFinishing())
      {
        bool1 = true;
        arrayOfBoolean[1] = Boolean.valueOf(bool1);
        if (paramAppBrandInitConfigWC.finished()) {
          break label181;
        }
      }
      label181:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        arrayOfBoolean[2] = Boolean.valueOf(bool1);
        ab.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "pollOrCreate, existed runtime[" + paramAppBrandInitConfigWC.getAppId() + "], conditions[" + org.apache.commons.b.a.toString(arrayOfBoolean) + ']');
        if (!b(arrayOfBoolean, Boolean.TRUE)) {
          break label186;
        }
        a(paramAppBrandInitConfigWC, (Context)paramActivity);
        paramAppBrandInitConfigWC.a((ad)paraml);
        AppMethodBeat.o(143719);
        return paramAppBrandInitConfigWC;
        bool1 = false;
        break;
      }
    }
    label186:
    paramActivity = new o((Context)com.tencent.mm.plugin.appbrand.ui.g.dc((Context)paramActivity), (ad)paraml);
    AppMethodBeat.o(143719);
    return paramActivity;
  }
  
  private static void a(o paramo, Context paramContext)
  {
    AppMethodBeat.i(143722);
    if (paramo == null)
    {
      paramo = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntime");
      AppMethodBeat.o(143722);
      throw paramo;
    }
    Context localContext = ((i)paramo).mContext;
    if (localContext == null)
    {
      paramo = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.AppBrandRuntimePersistentContextWrapper");
      AppMethodBeat.o(143722);
      throw paramo;
    }
    ((com.tencent.mm.plugin.appbrand.ui.g)localContext).setBaseContext(paramContext);
    paramo = paramo.atU();
    if (paramo != null)
    {
      paramo = paramo.aLy();
      if (paramo != null)
      {
        paramo.ap(paramContext);
        AppMethodBeat.o(143722);
        return;
      }
    }
    AppMethodBeat.o(143722);
  }
  
  private static boolean b(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(143717);
    int i = 0;
    while (i < 3)
    {
      if ((j.e(paramArrayOfObject[i], paramObject) ^ true))
      {
        AppMethodBeat.o(143717);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(143717);
    return true;
  }
  
  public static final void d(o paramo)
  {
    AppMethodBeat.i(143720);
    j.q(paramo, "runtime");
    Object localObject1 = ah.getContext();
    j.p(localObject1, "MMApplicationContext.getContext()");
    a(paramo, (Context)localObject1);
    paramo.a(null);
    localObject1 = (Map)gPr;
    Object localObject2 = paramo.getAppId();
    j.p(localObject2, "runtime.appId");
    ((Map)localObject1).put(localObject2, paramo);
    localObject1 = paramo.getAppId();
    localObject2 = com.tencent.mm.kernel.g.RI().Rj();
    j.p(localObject2, "MMKernel.process().current()");
    XIPCInvoker.a("com.tencent.mm", new IPC_PARAM_stashPersistentApp((String)localObject1, ((h)localObject2).getProcessName(), paramo.gRl), ac.class);
    AppMethodBeat.o(143720);
  }
  
  public static final boolean e(o paramo)
  {
    AppMethodBeat.i(143721);
    j.q(paramo, "runtime");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = gPr.remove(paramo.getAppId(), paramo);
    }
    for (;;)
    {
      if (bool) {
        f(paramo);
      }
      AppMethodBeat.o(143721);
      return bool;
      j.q(paramo, "runtime");
      if (gPr.containsValue(paramo))
      {
        gPr.remove(paramo.getAppId());
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private static void f(o paramo)
  {
    AppMethodBeat.i(143723);
    ((a.f.a.a)new g.a(paramo)).invoke();
    AppMethodBeat.o(143723);
  }
  
  public static final boolean isEmpty()
  {
    AppMethodBeat.i(143718);
    boolean bool = gPr.isEmpty();
    AppMethodBeat.o(143718);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */