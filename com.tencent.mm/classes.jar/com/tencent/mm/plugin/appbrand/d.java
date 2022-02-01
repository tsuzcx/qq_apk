package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d
{
  private static final LinkedHashMap<String, t> nsu;
  private static final Map<String, t> nsv;
  
  static
  {
    AppMethodBeat.i(43783);
    MMApplicationContext.getContext().registerComponentCallbacks(new com.tencent.mm.plugin.appbrand.utils.k()
    {
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(43771);
        Log.i("MicroMsg.AppBrandBridge", "onTrimMemory level=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(43771);
          return;
        }
        synchronized (d.nsv)
        {
          Iterator localIterator = new LinkedList(d.bBM().values()).iterator();
          while (localIterator.hasNext())
          {
            t localt = (t)localIterator.next();
            if (!localt.mResumed)
            {
              d.bBM().remove(localt.mAppId);
              localt.bCy();
            }
          }
        }
        AppMethodBeat.o(43771);
      }
    });
    nsu = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(final Map.Entry paramAnonymousEntry)
      {
        AppMethodBeat.i(43773);
        if (size() >= d.Yx()) {}
        for (boolean bool = true;; bool = false)
        {
          if (bool)
          {
            paramAnonymousEntry = (t)paramAnonymousEntry.getValue();
            Log.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", new Object[] { paramAnonymousEntry.toString() });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43772);
                paramAnonymousEntry.bCy();
                AppMethodBeat.o(43772);
              }
            });
          }
          AppMethodBeat.o(43773);
          return bool;
        }
      }
    };
    nsv = new HashMap();
    AppMethodBeat.o(43783);
  }
  
  public static boolean a(t paramt)
  {
    AppMethodBeat.i(43774);
    synchronized (nsv)
    {
      boolean bool = nsu.containsValue(paramt);
      AppMethodBeat.o(43774);
      return bool;
    }
  }
  
  public static t abA(String paramString)
  {
    AppMethodBeat.i(43779);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43779);
      return null;
    }
    synchronized (nsv)
    {
      paramString = (t)nsv.get(paramString);
      AppMethodBeat.o(43779);
      return paramString;
    }
  }
  
  @Deprecated
  public static AppBrandSysConfigWC abB(String paramString)
  {
    AppMethodBeat.i(43781);
    paramString = abA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43781);
      return null;
    }
    paramString = paramString.bDx();
    AppMethodBeat.o(43781);
    return paramString;
  }
  
  @Deprecated
  public static AppBrandStatObject abC(String paramString)
  {
    AppMethodBeat.i(43782);
    paramString = abA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43782);
      return null;
    }
    paramString = paramString.Sk().cxf;
    AppMethodBeat.o(43782);
    return paramString;
  }
  
  static void b(t paramt)
  {
    AppMethodBeat.i(43777);
    if (Util.isNullOrNil(paramt.mAppId))
    {
      Log.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      AppMethodBeat.o(43777);
      return;
    }
    synchronized (nsv)
    {
      t localt = (t)nsv.get(paramt.mAppId);
      if ((localt == null) || (localt == paramt))
      {
        nsv.remove(paramt.mAppId);
        nsu.remove(paramt.mAppId);
        AppMethodBeat.o(43777);
        return;
      }
      Log.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { Util.stackTraceToString(new Throwable()) });
    }
  }
  
  public static boolean bBK()
  {
    AppMethodBeat.i(43776);
    synchronized (nsv)
    {
      Iterator localIterator = nsv.values().iterator();
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        if ((localt != null) && (localt.Qv()))
        {
          AppMethodBeat.o(43776);
          return true;
        }
      }
      AppMethodBeat.o(43776);
      return false;
    }
  }
  
  public static int bBL()
  {
    AppMethodBeat.i(43780);
    synchronized (nsv)
    {
      int i = nsv.size();
      AppMethodBeat.o(43780);
      return i;
    }
  }
  
  public static void e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(43775);
    Log.i("MicroMsg.AppBrandBridge", "clearRunningGames(exclude:%s)", new Object[] { paramAppBrandRuntime.mAppId });
    LinkedList localLinkedList = new LinkedList();
    synchronized (nsv)
    {
      Iterator localIterator = nsv.values().iterator();
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        if ((localt != null) && (localt.Qv()) && (localt != paramAppBrandRuntime)) {
          localLinkedList.add(localt);
        }
      }
    }
    paramAppBrandRuntime = localLinkedList.iterator();
    while (paramAppBrandRuntime.hasNext()) {
      ((t)paramAppBrandRuntime.next()).bDE();
    }
    AppMethodBeat.o(43775);
  }
  
  static void setRuntime(t paramt)
  {
    AppMethodBeat.i(43778);
    if (Util.isNullOrNil(paramt.mAppId))
    {
      Log.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
      AppMethodBeat.o(43778);
      return;
    }
    synchronized (nsv)
    {
      nsv.put(paramt.mAppId, paramt);
      nsu.put(paramt.mAppId, paramt);
      if (paramt.bDy() != null) {
        com.tencent.mm.plugin.appbrand.report.k.cF(paramt.mAppId, paramt.bDy().cwR);
      }
      AppMethodBeat.o(43778);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d
 * JD-Core Version:    0.7.0.1
 */