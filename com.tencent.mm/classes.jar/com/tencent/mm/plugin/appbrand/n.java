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
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.apache.commons.c.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandProcessSharedPersistentRuntimeStore;", "", "()V", "TAG", "", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "contains", "", "runtime", "isAllEquals", "array", "", "objectToMatch", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "isEmpty", "onRuntimeFinish", "", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "poll", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "pollOrCreate", "remotePop", "remove", "stash", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n qrZ;
  private static final ConcurrentHashMap<String, w> qsa;
  
  static
  {
    AppMethodBeat.i(50146);
    qrZ = new n();
    qsa = new ConcurrentHashMap();
    AppMethodBeat.o(50146);
  }
  
  public static final w a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(175099);
    s.u(paramAppBrandInitConfigWC, "cfg");
    s.u(paramAppBrandRuntimeContainerWC, "container");
    paramAppBrandInitConfigWC = (w)qsa.remove(paramAppBrandInitConfigWC.appId);
    if (paramAppBrandInitConfigWC != null)
    {
      e((d)paramAppBrandInitConfigWC);
      Boolean[] arrayOfBoolean = new Boolean[3];
      arrayOfBoolean[0] = Boolean.valueOf(paramAppBrandInitConfigWC.mInitialized);
      if (!paramAppBrandInitConfigWC.ccV)
      {
        bool1 = true;
        arrayOfBoolean[1] = Boolean.valueOf(bool1);
        if (paramAppBrandInitConfigWC.qsE.get()) {
          break label171;
        }
      }
      label171:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        arrayOfBoolean[2] = Boolean.valueOf(bool1);
        Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "pollOrCreate, existed runtime[" + paramAppBrandInitConfigWC.mAppId + "], conditions[" + a.ca(arrayOfBoolean) + ']');
        if (!a(arrayOfBoolean, Boolean.TRUE)) {
          break label176;
        }
        paramAppBrandInitConfigWC.a((ap)paramAppBrandRuntimeContainerWC);
        AppMethodBeat.o(175099);
        return paramAppBrandInitConfigWC;
        bool1 = false;
        break;
      }
    }
    label176:
    AppMethodBeat.o(175099);
    return null;
  }
  
  private static boolean a(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(50138);
    int i = 0;
    while (i < 3)
    {
      if (!s.p(paramArrayOfObject[i], paramObject))
      {
        AppMethodBeat.o(50138);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(50138);
    return true;
  }
  
  public static final void c(w paramw)
  {
    AppMethodBeat.i(50142);
    s.u(paramw, "runtime");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", s.X("stash ", paramw));
    paramw.a(null);
    Map localMap = (Map)qsa;
    String str = paramw.mAppId;
    s.s(str, "runtime.appId");
    localMap.put(str, paramw);
    try
    {
      new LuggageStashRuntimeTask((d)paramw).cpB();
      AppMethodBeat.o(50142);
      return;
    }
    catch (c localc)
    {
      Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash: stash fail, give up");
      qsa.remove(paramw.mAppId);
      AppMethodBeat.o(50142);
    }
  }
  
  public static final boolean d(w paramw)
  {
    AppMethodBeat.i(316833);
    if (paramw == null)
    {
      AppMethodBeat.o(316833);
      return false;
    }
    boolean bool = qsa.containsValue(paramw);
    AppMethodBeat.o(316833);
    return bool;
  }
  
  private static void e(d paramd)
  {
    AppMethodBeat.i(316839);
    try
    {
      new LuggagePopRuntimeTask(paramd).cpB();
      AppMethodBeat.o(316839);
      return;
    }
    catch (c localc)
    {
      Log.e("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "remotePop runtime:" + paramd + ", exception:" + localc);
      AppMethodBeat.o(316839);
    }
  }
  
  public static final boolean e(w paramw)
  {
    AppMethodBeat.i(50143);
    s.u(paramw, "runtime");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", s.X("remove: ", paramw));
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = qsa.remove(paramw.mAppId, paramw);
    }
    for (;;)
    {
      if (bool) {
        e((d)paramw);
      }
      AppMethodBeat.o(50143);
      return bool;
      if (d(paramw))
      {
        qsa.remove(paramw.mAppId);
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
    AppMethodBeat.i(316841);
    s.u(paramd, "rt");
    Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", s.X("onRuntimeFinish appId =", paramd.mAppId));
    new LuggageOnRuntimeFinishTask(paramd).bQt();
    AppMethodBeat.o(316841);
  }
  
  public static final boolean isEmpty()
  {
    AppMethodBeat.i(50139);
    boolean bool = qsa.isEmpty();
    AppMethodBeat.o(50139);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */