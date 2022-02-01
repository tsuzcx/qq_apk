package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final LinkedHashMap<String, o> jcw;
  public static int jcx;
  private static final Map<String, o> jcy;
  
  static
  {
    AppMethodBeat.i(43783);
    ai.getContext().registerComponentCallbacks(new com.tencent.mm.plugin.appbrand.utils.h()
    {
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(43771);
        ac.i("MicroMsg.AppBrandBridge", "onTrimMemory level=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(43771);
          return;
        }
        synchronized (a.jcy)
        {
          Iterator localIterator = new LinkedList(a.aSo().values()).iterator();
          while (localIterator.hasNext())
          {
            o localo = (o)localIterator.next();
            if (!localo.mResumed)
            {
              a.aSo().remove(localo.mAppId);
              localo.aSX();
            }
          }
        }
        AppMethodBeat.o(43771);
      }
    });
    jcw = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(final Map.Entry paramAnonymousEntry)
      {
        AppMethodBeat.i(43773);
        if (size() > a.jcx) {}
        for (boolean bool = true;; bool = false)
        {
          if (bool)
          {
            paramAnonymousEntry = (o)paramAnonymousEntry.getValue();
            ac.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", new Object[] { paramAnonymousEntry.toString() });
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43772);
                paramAnonymousEntry.aSX();
                AppMethodBeat.o(43772);
              }
            });
          }
          AppMethodBeat.o(43773);
          return bool;
        }
      }
    };
    jcx = 4;
    jcy = new HashMap();
    AppMethodBeat.o(43783);
  }
  
  public static o GU(String paramString)
  {
    AppMethodBeat.i(43779);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43779);
      return null;
    }
    synchronized (jcy)
    {
      paramString = (o)jcy.get(paramString);
      AppMethodBeat.o(43779);
      return paramString;
    }
  }
  
  @Deprecated
  public static AppBrandSysConfigWC GV(String paramString)
  {
    AppMethodBeat.i(43781);
    paramString = GU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43781);
      return null;
    }
    paramString = paramString.aTR();
    AppMethodBeat.o(43781);
    return paramString;
  }
  
  @Deprecated
  public static AppBrandStatObject GW(String paramString)
  {
    AppMethodBeat.i(43782);
    paramString = GU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43782);
      return null;
    }
    paramString = paramString.DC().ccl;
    AppMethodBeat.o(43782);
    return paramString;
  }
  
  public static boolean a(o paramo)
  {
    AppMethodBeat.i(43774);
    synchronized (jcy)
    {
      boolean bool = jcw.containsValue(paramo);
      AppMethodBeat.o(43774);
      return bool;
    }
  }
  
  public static boolean aSm()
  {
    AppMethodBeat.i(43776);
    synchronized (jcy)
    {
      Iterator localIterator = jcy.values().iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if ((localo != null) && (localo.CC()))
        {
          AppMethodBeat.o(43776);
          return true;
        }
      }
      AppMethodBeat.o(43776);
      return false;
    }
  }
  
  public static int aSn()
  {
    AppMethodBeat.i(43780);
    synchronized (jcy)
    {
      int i = jcy.size();
      AppMethodBeat.o(43780);
      return i;
    }
  }
  
  static void b(o paramo)
  {
    AppMethodBeat.i(43777);
    if (bs.isNullOrNil(paramo.mAppId))
    {
      ac.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      AppMethodBeat.o(43777);
      return;
    }
    synchronized (jcy)
    {
      o localo = (o)jcy.get(paramo.mAppId);
      if ((localo == null) || (localo == paramo))
      {
        jcy.remove(paramo.mAppId);
        jcw.remove(paramo.mAppId);
        AppMethodBeat.o(43777);
        return;
      }
      ac.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { bs.m(new Throwable()) });
    }
  }
  
  public static void e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(43775);
    LinkedList localLinkedList = new LinkedList();
    synchronized (jcy)
    {
      Iterator localIterator = jcy.values().iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if ((localo != null) && (localo.CC()) && (localo != paramAppBrandRuntime)) {
          localLinkedList.add(localo);
        }
      }
    }
    paramAppBrandRuntime = localLinkedList.iterator();
    while (paramAppBrandRuntime.hasNext()) {
      ((o)paramAppBrandRuntime.next()).aTW();
    }
    AppMethodBeat.o(43775);
  }
  
  static void setRuntime(o paramo)
  {
    AppMethodBeat.i(43778);
    if (bs.isNullOrNil(paramo.mAppId))
    {
      ac.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
      AppMethodBeat.o(43778);
      return;
    }
    synchronized (jcy)
    {
      jcy.put(paramo.mAppId, paramo);
      jcw.put(paramo.mAppId, paramo);
      if (paramo.aTS() != null) {
        com.tencent.mm.plugin.appbrand.report.h.bQ(paramo.mAppId, paramo.aTS().cca);
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