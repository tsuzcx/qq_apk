package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/AppBrandProcessSharedPersistentRuntimeStore;", "", "()V", "TAG", "", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "contains", "", "runtime", "isAllEquals", "array", "", "objectToMatch", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "isEmpty", "onRuntimeFinish", "", "appId", "poll", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "pollOrCreate", "remotePop", "remove", "stash", "plugin-appbrand-integration_release"})
public final class k
{
  private static final ConcurrentHashMap<String, q> kAg;
  public static final k kAh;
  
  static
  {
    AppMethodBeat.i(50146);
    kAh = new k();
    kAg = new ConcurrentHashMap();
    AppMethodBeat.o(50146);
  }
  
  public static final void Ue(String paramString)
  {
    AppMethodBeat.i(227894);
    p.h(paramString, "appId");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "onRuntimeFinish appId =".concat(String.valueOf(paramString)));
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPC_PARAM_onRuntimeFinish(paramString), ag.class, null);
    AppMethodBeat.o(227894);
  }
  
  public static final q a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(175099);
    p.h(paramAppBrandInitConfigWC, "cfg");
    p.h(paramAppBrandRuntimeContainerWC, "container");
    q localq = (q)kAg.remove(paramAppBrandInitConfigWC.appId);
    if (localq != null)
    {
      f(localq);
      Boolean[] arrayOfBoolean = new Boolean[4];
      if (localq.bss() == paramAppBrandInitConfigWC.ldK)
      {
        bool1 = true;
        arrayOfBoolean[0] = Boolean.valueOf(bool1);
        arrayOfBoolean[1] = Boolean.valueOf(localq.brt());
        if (localq.isFinishing()) {
          break label196;
        }
        bool1 = true;
        label94:
        arrayOfBoolean[2] = Boolean.valueOf(bool1);
        if (localq.isDestroyed()) {
          break label201;
        }
      }
      label196:
      label201:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        arrayOfBoolean[3] = Boolean.valueOf(bool1);
        Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "pollOrCreate, existed runtime[" + localq.getAppId() + "], conditions[" + org.apache.commons.b.a.toString(arrayOfBoolean) + ']');
        if (!a(arrayOfBoolean, Boolean.TRUE)) {
          break label206;
        }
        localq.a((ak)paramAppBrandRuntimeContainerWC);
        AppMethodBeat.o(175099);
        return localq;
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
      if ((p.j(paramArrayOfObject[i], paramObject) ^ true))
      {
        AppMethodBeat.o(50138);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(50138);
    return true;
  }
  
  public static final void c(q paramq)
  {
    AppMethodBeat.i(50142);
    p.h(paramq, "runtime");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash ".concat(String.valueOf(paramq)));
    paramq.a(null);
    Object localObject = (Map)kAg;
    String str = paramq.getAppId();
    p.g(str, "runtime.appId");
    ((Map)localObject).put(str, paramq);
    try
    {
      localObject = paramq.kDi;
      p.g(localObject, "runtime.mRemoteController");
      if (((AppBrandRemoteTaskController)localObject).getAppId() == null)
      {
        Log.e("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash, null == runtime.mRemoteController.appId, updateRuntimeProps(" + paramq + ')');
        paramq.kDi.M(paramq);
      }
      localObject = MainProcessIPCService.dkO;
      str = paramq.getAppId();
      com.tencent.mm.kernel.b.g localg = com.tencent.mm.kernel.g.aAe().azG();
      p.g(localg, "MMKernel.process().current()");
      XIPCInvoker.a((String)localObject, new IPC_PARAM_stashPersistentApp(str, ((h)localg).getProcessName(), paramq.kDi), ai.class);
      AppMethodBeat.o(50142);
      return;
    }
    catch (c paramq)
    {
      AppMethodBeat.o(50142);
    }
  }
  
  public static final boolean d(q paramq)
  {
    AppMethodBeat.i(227893);
    if (paramq == null)
    {
      AppMethodBeat.o(227893);
      return false;
    }
    boolean bool = kAg.containsValue(paramq);
    AppMethodBeat.o(227893);
    return bool;
  }
  
  public static final boolean e(q paramq)
  {
    AppMethodBeat.i(50143);
    p.h(paramq, "runtime");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = kAg.remove(paramq.getAppId(), paramq);
    }
    for (;;)
    {
      if (bool) {
        f(paramq);
      }
      AppMethodBeat.o(50143);
      return bool;
      if (d(paramq))
      {
        kAg.remove(paramq.getAppId());
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private static void f(q paramq)
  {
    AppMethodBeat.i(50145);
    kotlin.g.a.a locala = (kotlin.g.a.a)new a(paramq);
    try
    {
      locala.invoke();
      AppMethodBeat.o(50145);
      return;
    }
    catch (c localc)
    {
      Log.e("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "remotePop runtime:" + paramq + ", exception:" + localc);
      AppMethodBeat.o(50145);
    }
  }
  
  public static final boolean isEmpty()
  {
    AppMethodBeat.i(50139);
    boolean bool = kAg.isEmpty();
    AppMethodBeat.o(50139);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<IPCVoid>
  {
    a(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */