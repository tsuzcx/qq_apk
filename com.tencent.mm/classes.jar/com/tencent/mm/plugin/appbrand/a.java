package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.utils.i;
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

public final class a
{
  private static final LinkedHashMap<String, q> kzj;
  private static final Map<String, q> kzk;
  
  static
  {
    AppMethodBeat.i(43783);
    MMApplicationContext.getContext().registerComponentCallbacks(new i()
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
        synchronized (a.kzk)
        {
          Iterator localIterator = new LinkedList(a.bqW().values()).iterator();
          while (localIterator.hasNext())
          {
            q localq = (q)localIterator.next();
            if (!localq.mResumed)
            {
              a.bqW().remove(localq.mAppId);
              localq.brJ();
            }
          }
        }
        AppMethodBeat.o(43771);
      }
    });
    kzj = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(final Map.Entry paramAnonymousEntry)
      {
        AppMethodBeat.i(43773);
        if (size() >= a.Tp()) {}
        for (boolean bool = true;; bool = false)
        {
          if (bool)
          {
            paramAnonymousEntry = (q)paramAnonymousEntry.getValue();
            Log.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", new Object[] { paramAnonymousEntry.toString() });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43772);
                paramAnonymousEntry.brJ();
                AppMethodBeat.o(43772);
              }
            });
          }
          AppMethodBeat.o(43773);
          return bool;
        }
      }
    };
    kzk = new HashMap();
    AppMethodBeat.o(43783);
  }
  
  public static q TQ(String paramString)
  {
    AppMethodBeat.i(43779);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43779);
      return null;
    }
    synchronized (kzk)
    {
      paramString = (q)kzk.get(paramString);
      AppMethodBeat.o(43779);
      return paramString;
    }
  }
  
  @Deprecated
  public static AppBrandSysConfigWC TR(String paramString)
  {
    AppMethodBeat.i(43781);
    paramString = TQ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43781);
      return null;
    }
    paramString = paramString.bsB();
    AppMethodBeat.o(43781);
    return paramString;
  }
  
  @Deprecated
  public static AppBrandStatObject TS(String paramString)
  {
    AppMethodBeat.i(43782);
    paramString = TQ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43782);
      return null;
    }
    paramString = paramString.ON().cyA;
    AppMethodBeat.o(43782);
    return paramString;
  }
  
  public static boolean a(q paramq)
  {
    AppMethodBeat.i(43774);
    synchronized (kzk)
    {
      boolean bool = kzj.containsValue(paramq);
      AppMethodBeat.o(43774);
      return bool;
    }
  }
  
  static void b(q paramq)
  {
    AppMethodBeat.i(43777);
    if (Util.isNullOrNil(paramq.mAppId))
    {
      Log.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      AppMethodBeat.o(43777);
      return;
    }
    synchronized (kzk)
    {
      q localq = (q)kzk.get(paramq.mAppId);
      if ((localq == null) || (localq == paramq))
      {
        kzk.remove(paramq.mAppId);
        kzj.remove(paramq.mAppId);
        AppMethodBeat.o(43777);
        return;
      }
      Log.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { Util.stackTraceToString(new Throwable()) });
    }
  }
  
  public static boolean bqU()
  {
    AppMethodBeat.i(43776);
    synchronized (kzk)
    {
      Iterator localIterator = kzk.values().iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if ((localq != null) && (localq.NA()))
        {
          AppMethodBeat.o(43776);
          return true;
        }
      }
      AppMethodBeat.o(43776);
      return false;
    }
  }
  
  public static int bqV()
  {
    AppMethodBeat.i(43780);
    synchronized (kzk)
    {
      int i = kzk.size();
      AppMethodBeat.o(43780);
      return i;
    }
  }
  
  public static void e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(43775);
    LinkedList localLinkedList = new LinkedList();
    synchronized (kzk)
    {
      Iterator localIterator = kzk.values().iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if ((localq != null) && (localq.NA()) && (localq != paramAppBrandRuntime)) {
          localLinkedList.add(localq);
        }
      }
    }
    paramAppBrandRuntime = localLinkedList.iterator();
    while (paramAppBrandRuntime.hasNext()) {
      ((q)paramAppBrandRuntime.next()).bsH();
    }
    AppMethodBeat.o(43775);
  }
  
  static void setRuntime(q paramq)
  {
    AppMethodBeat.i(43778);
    if (Util.isNullOrNil(paramq.mAppId))
    {
      Log.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
      AppMethodBeat.o(43778);
      return;
    }
    synchronized (kzk)
    {
      kzk.put(paramq.mAppId, paramq);
      kzj.put(paramq.mAppId, paramq);
      if (paramq.bsC() != null) {
        j.cg(paramq.mAppId, paramq.bsC().cyo);
      }
      AppMethodBeat.o(43778);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a
 * JD-Core Version:    0.7.0.1
 */