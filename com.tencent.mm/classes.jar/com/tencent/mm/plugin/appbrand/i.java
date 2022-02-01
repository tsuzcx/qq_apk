package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/AppBrandProcessSharedPersistentRuntimeStore;", "", "()V", "TAG", "", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "contains", "", "runtime", "isAllEquals", "array", "", "objectToMatch", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "isEmpty", "poll", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "pollOrCreate", "remotePop", "", "remove", "stash", "plugin-appbrand-integration_release"})
public final class i
{
  private static final ConcurrentHashMap<String, o> jdo;
  public static final i jdp;
  
  static
  {
    AppMethodBeat.i(50146);
    jdp = new i();
    jdo = new ConcurrentHashMap();
    AppMethodBeat.o(50146);
  }
  
  public static final o a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(175099);
    k.h(paramAppBrandInitConfigWC, "cfg");
    k.h(paramAppBrandRuntimeContainerWC, "container");
    o localo = (o)jdo.remove(paramAppBrandInitConfigWC.appId);
    if (localo != null)
    {
      e(localo);
      Boolean[] arrayOfBoolean = new Boolean[4];
      if (localo.aTK() == paramAppBrandInitConfigWC.jDv)
      {
        bool1 = true;
        arrayOfBoolean[0] = Boolean.valueOf(bool1);
        arrayOfBoolean[1] = Boolean.valueOf(localo.aSJ());
        if (localo.isFinishing()) {
          break label196;
        }
        bool1 = true;
        label94:
        arrayOfBoolean[2] = Boolean.valueOf(bool1);
        if (localo.isDestroyed()) {
          break label201;
        }
      }
      label196:
      label201:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        arrayOfBoolean[3] = Boolean.valueOf(bool1);
        ac.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "pollOrCreate, existed runtime[" + localo.getAppId() + "], conditions[" + org.apache.commons.b.a.toString(arrayOfBoolean) + ']');
        if (!a(arrayOfBoolean, Boolean.TRUE)) {
          break label206;
        }
        localo.a((ai)paramAppBrandRuntimeContainerWC);
        AppMethodBeat.o(175099);
        return localo;
        bool1 = false;
        break;
        bool1 = false;
        break label94;
      }
    }
    label206:
    AppMethodBeat.o(175099);
    return null;
  }
  
  private static boolean a(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(50138);
    int i = 0;
    while (i < 4)
    {
      if ((k.g(paramArrayOfObject[i], paramObject) ^ true))
      {
        AppMethodBeat.o(50138);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(50138);
    return true;
  }
  
  public static final o b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(175100);
    k.h(paramAppBrandInitConfigWC, "cfg");
    k.h(paramAppBrandRuntimeContainerWC, "container");
    o localo = a(paramAppBrandInitConfigWC, paramAppBrandRuntimeContainerWC);
    paramAppBrandInitConfigWC = localo;
    if (localo == null) {
      paramAppBrandInitConfigWC = new o(paramAppBrandRuntimeContainerWC);
    }
    AppMethodBeat.o(175100);
    return paramAppBrandInitConfigWC;
  }
  
  public static final void c(o paramo)
  {
    AppMethodBeat.i(50142);
    k.h(paramo, "runtime");
    ac.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash ".concat(String.valueOf(paramo)));
    paramo.a(null);
    Object localObject1 = (Map)jdo;
    Object localObject2 = paramo.getAppId();
    k.g(localObject2, "runtime.appId");
    ((Map)localObject1).put(localObject2, paramo);
    localObject1 = paramo.getAppId();
    localObject2 = g.agO().agp();
    k.g(localObject2, "MMKernel.process().current()");
    XIPCInvoker.a("com.tencent.mm", new IPC_PARAM_stashPersistentApp((String)localObject1, ((h)localObject2).getProcessName(), paramo.jge), ag.class);
    AppMethodBeat.o(50142);
  }
  
  public static final boolean d(o paramo)
  {
    AppMethodBeat.i(50143);
    k.h(paramo, "runtime");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = jdo.remove(paramo.getAppId(), paramo);
    }
    for (;;)
    {
      if (bool) {
        e(paramo);
      }
      AppMethodBeat.o(50143);
      return bool;
      k.h(paramo, "runtime");
      if (jdo.containsValue(paramo))
      {
        jdo.remove(paramo.getAppId());
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private static void e(o paramo)
  {
    AppMethodBeat.i(50145);
    ((d.g.a.a)new a(paramo)).invoke();
    AppMethodBeat.o(50145);
  }
  
  public static final boolean isEmpty()
  {
    AppMethodBeat.i(50139);
    boolean bool = jdo.isEmpty();
    AppMethodBeat.o(50139);
    return bool;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<IPCVoid>
  {
    a(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i
 * JD-Core Version:    0.7.0.1
 */