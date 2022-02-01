package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class a
{
  private static final LinkedHashMap<String, p> jyA;
  public static int jyB;
  private static final Map<String, p> jyC;
  
  static
  {
    AppMethodBeat.i(43783);
    ak.getContext().registerComponentCallbacks(new com.tencent.mm.plugin.appbrand.utils.i()
    {
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(43771);
        ae.i("MicroMsg.AppBrandBridge", "onTrimMemory level=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(43771);
          return;
        }
        synchronized (a.jyC)
        {
          Iterator localIterator = new LinkedList(a.aVZ().values()).iterator();
          while (localIterator.hasNext())
          {
            p localp = (p)localIterator.next();
            if (!localp.mResumed)
            {
              a.aVZ().remove(localp.mAppId);
              localp.aWM();
            }
          }
        }
        AppMethodBeat.o(43771);
      }
    });
    jyA = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(final Map.Entry paramAnonymousEntry)
      {
        AppMethodBeat.i(43773);
        if (size() > a.jyB) {}
        for (boolean bool = true;; bool = false)
        {
          if (bool)
          {
            paramAnonymousEntry = (p)paramAnonymousEntry.getValue();
            ae.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", new Object[] { paramAnonymousEntry.toString() });
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43772);
                paramAnonymousEntry.aWM();
                AppMethodBeat.o(43772);
              }
            });
          }
          AppMethodBeat.o(43773);
          return bool;
        }
      }
    };
    jyB = 4;
    jyC = new HashMap();
    AppMethodBeat.o(43783);
  }
  
  public static p KI(String paramString)
  {
    AppMethodBeat.i(43779);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43779);
      return null;
    }
    synchronized (jyC)
    {
      paramString = (p)jyC.get(paramString);
      AppMethodBeat.o(43779);
      return paramString;
    }
  }
  
  @Deprecated
  public static AppBrandSysConfigWC KJ(String paramString)
  {
    AppMethodBeat.i(43781);
    paramString = KI(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43781);
      return null;
    }
    paramString = paramString.aXw();
    AppMethodBeat.o(43781);
    return paramString;
  }
  
  @Deprecated
  public static AppBrandStatObject KK(String paramString)
  {
    AppMethodBeat.i(43782);
    paramString = KI(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43782);
      return null;
    }
    paramString = paramString.Fg().cmE;
    AppMethodBeat.o(43782);
    return paramString;
  }
  
  public static boolean a(p paramp)
  {
    AppMethodBeat.i(43774);
    synchronized (jyC)
    {
      boolean bool = jyA.containsValue(paramp);
      AppMethodBeat.o(43774);
      return bool;
    }
  }
  
  public static boolean aVX()
  {
    AppMethodBeat.i(43776);
    synchronized (jyC)
    {
      Iterator localIterator = jyC.values().iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        if ((localp != null) && (localp.Ee()))
        {
          AppMethodBeat.o(43776);
          return true;
        }
      }
      AppMethodBeat.o(43776);
      return false;
    }
  }
  
  public static int aVY()
  {
    AppMethodBeat.i(43780);
    synchronized (jyC)
    {
      int i = jyC.size();
      AppMethodBeat.o(43780);
      return i;
    }
  }
  
  static void b(p paramp)
  {
    AppMethodBeat.i(43777);
    if (bu.isNullOrNil(paramp.mAppId))
    {
      ae.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      AppMethodBeat.o(43777);
      return;
    }
    synchronized (jyC)
    {
      p localp = (p)jyC.get(paramp.mAppId);
      if ((localp == null) || (localp == paramp))
      {
        jyC.remove(paramp.mAppId);
        jyA.remove(paramp.mAppId);
        AppMethodBeat.o(43777);
        return;
      }
      ae.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { bu.o(new Throwable()) });
    }
  }
  
  public static void e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(43775);
    LinkedList localLinkedList = new LinkedList();
    synchronized (jyC)
    {
      Iterator localIterator = jyC.values().iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        if ((localp != null) && (localp.Ee()) && (localp != paramAppBrandRuntime)) {
          localLinkedList.add(localp);
        }
      }
    }
    paramAppBrandRuntime = localLinkedList.iterator();
    while (paramAppBrandRuntime.hasNext()) {
      ((p)paramAppBrandRuntime.next()).aXB();
    }
    AppMethodBeat.o(43775);
  }
  
  static void setRuntime(p paramp)
  {
    AppMethodBeat.i(43778);
    if (bu.isNullOrNil(paramp.mAppId))
    {
      ae.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
      AppMethodBeat.o(43778);
      return;
    }
    synchronized (jyC)
    {
      jyC.put(paramp.mAppId, paramp);
      jyA.put(paramp.mAppId, paramp);
      if (paramp.aXx() != null) {
        com.tencent.mm.plugin.appbrand.report.i.bX(paramp.mAppId, paramp.aXx().cmt);
      }
      AppMethodBeat.o(43778);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a
 * JD-Core Version:    0.7.0.1
 */