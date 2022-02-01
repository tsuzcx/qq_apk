package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  private static final AtomicBoolean qqZ;
  private static final LinkedHashMap<String, w> qra;
  private static final Map<String, w> qrb;
  
  static
  {
    AppMethodBeat.i(43783);
    qqZ = new AtomicBoolean(false);
    qra = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(final Map.Entry<String, w> paramAnonymousEntry)
      {
        AppMethodBeat.i(43773);
        if (size() > d.access$200()) {}
        for (boolean bool = true;; bool = false)
        {
          if (bool)
          {
            paramAnonymousEntry = (w)paramAnonymousEntry.getValue();
            Log.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", new Object[] { paramAnonymousEntry.toString() });
            h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43772);
                paramAnonymousEntry.T(null);
                AppMethodBeat.o(43772);
              }
            });
          }
          AppMethodBeat.o(43773);
          return bool;
        }
      }
    };
    qrb = new HashMap();
    AppMethodBeat.o(43783);
  }
  
  public static w Uc(String paramString)
  {
    AppMethodBeat.i(43779);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43779);
      return null;
    }
    synchronized (qrb)
    {
      paramString = (w)qrb.get(paramString);
      AppMethodBeat.o(43779);
      return paramString;
    }
  }
  
  @Deprecated
  public static AppBrandSysConfigWC Ud(String paramString)
  {
    AppMethodBeat.i(43781);
    paramString = Uc(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43781);
      return null;
    }
    paramString = paramString.ccM();
    AppMethodBeat.o(43781);
    return paramString;
  }
  
  @Deprecated
  public static AppBrandStatObject Ue(String paramString)
  {
    AppMethodBeat.i(43782);
    paramString = Uc(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43782);
      return null;
    }
    paramString = paramString.asA().epn;
    AppMethodBeat.o(43782);
    return paramString;
  }
  
  public static boolean a(w paramw)
  {
    AppMethodBeat.i(43774);
    synchronized (qrb)
    {
      boolean bool = qra.containsValue(paramw);
      AppMethodBeat.o(43774);
      return bool;
    }
  }
  
  static void b(w paramw)
  {
    AppMethodBeat.i(43777);
    if (Util.isNullOrNil(paramw.mAppId))
    {
      Log.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      AppMethodBeat.o(43777);
      return;
    }
    synchronized (qrb)
    {
      w localw = (w)qrb.get(paramw.mAppId);
      if ((localw == null) || (localw == paramw))
      {
        qrb.remove(paramw.mAppId);
        qra.remove(paramw.mAppId);
        boolean bool = qrb.isEmpty();
        if (bool) {
          h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(316920);
              synchronized (d.aYC())
              {
                boolean bool = d.aYC().isEmpty();
                if (bool) {
                  AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.a.qBK);
                }
                AppMethodBeat.o(316920);
                return;
              }
            }
          }, 1000L);
        }
        AppMethodBeat.o(43777);
        return;
      }
      Log.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { Util.stackTraceToString(new Throwable()) });
    }
  }
  
  public static void cbf()
  {
    AppMethodBeat.i(316791);
    if (qqZ.getAndSet(true))
    {
      AppMethodBeat.o(316791);
      return;
    }
    MMApplicationContext.getContext().registerComponentCallbacks(new com.tencent.mm.plugin.appbrand.utils.o()
    {
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(43771);
        Log.i("MicroMsg.AppBrandBridge", "onTrimMemory level=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(43771);
          return;
          if (!com.tencent.mm.plugin.appbrand.task.o.cKb())
          {
            AppMethodBeat.o(43771);
            return;
          }
          synchronized (d.aYC())
          {
            Iterator localIterator = new LinkedList(d.cbi().values()).iterator();
            while (localIterator.hasNext())
            {
              w localw = (w)localIterator.next();
              if (!localw.mResumed)
              {
                d.cbi().remove(localw.mAppId);
                localw.T(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(316900);
                    synchronized (d.aYC())
                    {
                      boolean bool = d.aYC().isEmpty();
                      if (bool) {
                        AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.a.qBL);
                      }
                      AppMethodBeat.o(316900);
                      return;
                    }
                  }
                });
              }
            }
          }
          AppMethodBeat.o(43771);
          return;
          synchronized (d.aYC())
          {
            boolean bool = d.aYC().isEmpty();
            if ((!bool) || (!com.tencent.mm.plugin.appbrand.task.o.cKa())) {
              continue;
            }
            AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.a.qBM);
          }
        }
      }
    });
    AppMethodBeat.o(316791);
  }
  
  public static boolean cbg()
  {
    AppMethodBeat.i(43776);
    synchronized (qrb)
    {
      Iterator localIterator = qrb.values().iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if ((localw != null) && (localw.aqJ()))
        {
          AppMethodBeat.o(43776);
          return true;
        }
      }
      AppMethodBeat.o(43776);
      return false;
    }
  }
  
  public static int cbh()
  {
    AppMethodBeat.i(43780);
    synchronized (qrb)
    {
      int i = qrb.size();
      AppMethodBeat.o(43780);
      return i;
    }
  }
  
  public static void e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(43775);
    Log.i("MicroMsg.AppBrandBridge", "clearRunningGames(exclude:%s)", new Object[] { paramAppBrandRuntime.mAppId });
    LinkedList localLinkedList = new LinkedList();
    synchronized (qrb)
    {
      Iterator localIterator = qrb.values().iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if ((localw != null) && (localw.aqJ()) && (localw != paramAppBrandRuntime)) {
          localLinkedList.add(localw);
        }
      }
    }
    paramAppBrandRuntime = localLinkedList.iterator();
    while (paramAppBrandRuntime.hasNext()) {
      ((w)paramAppBrandRuntime.next()).ccR();
    }
    AppMethodBeat.o(43775);
  }
  
  static void setRuntime(w paramw)
  {
    AppMethodBeat.i(43778);
    if (Util.isNullOrNil(paramw.mAppId))
    {
      Log.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
      AppMethodBeat.o(43778);
      return;
    }
    synchronized (qrb)
    {
      qrb.put(paramw.mAppId, paramw);
      qra.put(paramw.mAppId, paramw);
      if (paramw.getInitConfig() != null) {
        k.df(paramw.mAppId, paramw.getInitConfig().appServiceType);
      }
      AppMethodBeat.o(43778);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d
 * JD-Core Version:    0.7.0.1
 */