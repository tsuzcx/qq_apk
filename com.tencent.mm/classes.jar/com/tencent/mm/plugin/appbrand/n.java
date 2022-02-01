package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.e.d;
import com.tencent.luggage.sdk.processes.main.LuggageOnRuntimeFinishTask;
import com.tencent.luggage.sdk.processes.main.LuggagePopRuntimeTask;
import com.tencent.luggage.sdk.processes.main.LuggageStashRuntimeTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.apache.commons.b.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandProcessSharedPersistentRuntimeStore;", "", "()V", "TAG", "", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "contains", "", "runtime", "isAllEquals", "array", "", "objectToMatch", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "isEmpty", "onRuntimeFinish", "", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "poll", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "pollOrCreate", "remotePop", "remove", "stash", "plugin-appbrand-integration_release"})
public final class n
{
  private static final ConcurrentHashMap<String, t> ntr;
  public static final n nts;
  
  static
  {
    AppMethodBeat.i(50146);
    nts = new n();
    ntr = new ConcurrentHashMap();
    AppMethodBeat.o(50146);
  }
  
  public static final t a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(175099);
    p.k(paramAppBrandInitConfigWC, "cfg");
    p.k(paramAppBrandRuntimeContainerWC, "container");
    t localt = (t)ntr.remove(paramAppBrandInitConfigWC.appId);
    if (localt != null)
    {
      e((d)localt);
      Boolean[] arrayOfBoolean = new Boolean[4];
      if (localt.bDm() == paramAppBrandInitConfigWC.nXY)
      {
        bool1 = true;
        arrayOfBoolean[0] = Boolean.valueOf(bool1);
        arrayOfBoolean[1] = Boolean.valueOf(localt.bCj());
        if (localt.isFinishing()) {
          break label199;
        }
        bool1 = true;
        label97:
        arrayOfBoolean[2] = Boolean.valueOf(bool1);
        if (localt.isDestroyed()) {
          break label204;
        }
      }
      label199:
      label204:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        arrayOfBoolean[3] = Boolean.valueOf(bool1);
        Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "pollOrCreate, existed runtime[" + localt.getAppId() + "], conditions[" + a.cG(arrayOfBoolean) + ']');
        if (!a(arrayOfBoolean, Boolean.TRUE)) {
          break label209;
        }
        localt.a((ak)paramAppBrandRuntimeContainerWC);
        AppMethodBeat.o(175099);
        return localt;
        bool1 = false;
        break;
        bool1 = false;
        break label97;
      }
    }
    label209:
    AppMethodBeat.o(175099);
    return null;
  }
  
  private static boolean a(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(50138);
    int i = 0;
    while (i < 4)
    {
      if ((p.h(paramArrayOfObject[i], paramObject) ^ true))
      {
        AppMethodBeat.o(50138);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(50138);
    return true;
  }
  
  public static final void c(t paramt)
  {
    AppMethodBeat.i(50142);
    p.k(paramt, "runtime");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash ".concat(String.valueOf(paramt)));
    paramt.a(null);
    Map localMap = (Map)ntr;
    String str = paramt.getAppId();
    p.j(str, "runtime.appId");
    localMap.put(str, paramt);
    try
    {
      new LuggageStashRuntimeTask((d)paramt).bPu();
      AppMethodBeat.o(50142);
      return;
    }
    catch (c localc)
    {
      Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash: stash fail, give up");
      ntr.remove(paramt.getAppId());
      AppMethodBeat.o(50142);
    }
  }
  
  public static final boolean d(t paramt)
  {
    AppMethodBeat.i(279524);
    if (paramt == null)
    {
      AppMethodBeat.o(279524);
      return false;
    }
    boolean bool = ntr.containsValue(paramt);
    AppMethodBeat.o(279524);
    return bool;
  }
  
  private static void e(d paramd)
  {
    AppMethodBeat.i(279526);
    try
    {
      new LuggagePopRuntimeTask(paramd).bPu();
      AppMethodBeat.o(279526);
      return;
    }
    catch (c localc)
    {
      Log.e("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "remotePop runtime:" + paramd + ", exception:" + localc);
      AppMethodBeat.o(279526);
    }
  }
  
  public static final boolean e(t paramt)
  {
    AppMethodBeat.i(50143);
    p.k(paramt, "runtime");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "remove: ".concat(String.valueOf(paramt)));
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = ntr.remove(paramt.getAppId(), paramt);
    }
    for (;;)
    {
      if (bool) {
        e((d)paramt);
      }
      AppMethodBeat.o(50143);
      return bool;
      if (d(paramt))
      {
        ntr.remove(paramt.getAppId());
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static final void f(d paramd)
  {
    AppMethodBeat.i(279527);
    p.k(paramd, "rt");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "onRuntimeFinish appId =" + paramd.getAppId());
    new LuggageOnRuntimeFinishTask(paramd).bsM();
    AppMethodBeat.o(279527);
  }
  
  public static final boolean isEmpty()
  {
    AppMethodBeat.i(50139);
    boolean bool = ntr.isEmpty();
    AppMethodBeat.o(50139);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */