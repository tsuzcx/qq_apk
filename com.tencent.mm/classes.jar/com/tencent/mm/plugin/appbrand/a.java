package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final LinkedHashMap<String, o> jvF;
  public static int jvG;
  private static final Map<String, o> jvH;
  
  static
  {
    AppMethodBeat.i(43783);
    aj.getContext().registerComponentCallbacks(new h()
    {
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(43771);
        ad.i("MicroMsg.AppBrandBridge", "onTrimMemory level=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(43771);
          return;
        }
        synchronized (a.jvH)
        {
          Iterator localIterator = new LinkedList(a.aVA().values()).iterator();
          while (localIterator.hasNext())
          {
            o localo = (o)localIterator.next();
            if (!localo.mResumed)
            {
              a.aVA().remove(localo.mAppId);
              localo.aWl();
            }
          }
        }
        AppMethodBeat.o(43771);
      }
    });
    jvF = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(final Map.Entry paramAnonymousEntry)
      {
        AppMethodBeat.i(43773);
        if (size() > a.jvG) {}
        for (boolean bool = true;; bool = false)
        {
          if (bool)
          {
            paramAnonymousEntry = (o)paramAnonymousEntry.getValue();
            ad.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", new Object[] { paramAnonymousEntry.toString() });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43772);
                paramAnonymousEntry.aWl();
                AppMethodBeat.o(43772);
              }
            });
          }
          AppMethodBeat.o(43773);
          return bool;
        }
      }
    };
    jvG = 4;
    jvH = new HashMap();
    AppMethodBeat.o(43783);
  }
  
  public static o Kj(String paramString)
  {
    AppMethodBeat.i(43779);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43779);
      return null;
    }
    synchronized (jvH)
    {
      paramString = (o)jvH.get(paramString);
      AppMethodBeat.o(43779);
      return paramString;
    }
  }
  
  @Deprecated
  public static AppBrandSysConfigWC Kk(String paramString)
  {
    AppMethodBeat.i(43781);
    paramString = Kj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43781);
      return null;
    }
    paramString = paramString.aXb();
    AppMethodBeat.o(43781);
    return paramString;
  }
  
  @Deprecated
  public static AppBrandStatObject Kl(String paramString)
  {
    AppMethodBeat.i(43782);
    paramString = Kj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43782);
      return null;
    }
    paramString = paramString.Fb().cmC;
    AppMethodBeat.o(43782);
    return paramString;
  }
  
  public static boolean a(o paramo)
  {
    AppMethodBeat.i(43774);
    synchronized (jvH)
    {
      boolean bool = jvF.containsValue(paramo);
      AppMethodBeat.o(43774);
      return bool;
    }
  }
  
  public static boolean aVy()
  {
    AppMethodBeat.i(43776);
    synchronized (jvH)
    {
      Iterator localIterator = jvH.values().iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if ((localo != null) && (localo.Eb()))
        {
          AppMethodBeat.o(43776);
          return true;
        }
      }
      AppMethodBeat.o(43776);
      return false;
    }
  }
  
  public static int aVz()
  {
    AppMethodBeat.i(43780);
    synchronized (jvH)
    {
      int i = jvH.size();
      AppMethodBeat.o(43780);
      return i;
    }
  }
  
  static void b(o paramo)
  {
    AppMethodBeat.i(43777);
    if (bt.isNullOrNil(paramo.mAppId))
    {
      ad.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      AppMethodBeat.o(43777);
      return;
    }
    synchronized (jvH)
    {
      o localo = (o)jvH.get(paramo.mAppId);
      if ((localo == null) || (localo == paramo))
      {
        jvH.remove(paramo.mAppId);
        jvF.remove(paramo.mAppId);
        AppMethodBeat.o(43777);
        return;
      }
      ad.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { bt.n(new Throwable()) });
    }
  }
  
  public static void e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(43775);
    LinkedList localLinkedList = new LinkedList();
    synchronized (jvH)
    {
      Iterator localIterator = jvH.values().iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if ((localo != null) && (localo.Eb()) && (localo != paramAppBrandRuntime)) {
          localLinkedList.add(localo);
        }
      }
    }
    paramAppBrandRuntime = localLinkedList.iterator();
    while (paramAppBrandRuntime.hasNext()) {
      ((o)paramAppBrandRuntime.next()).aXg();
    }
    AppMethodBeat.o(43775);
  }
  
  static void setRuntime(o paramo)
  {
    AppMethodBeat.i(43778);
    if (bt.isNullOrNil(paramo.mAppId))
    {
      ad.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
      AppMethodBeat.o(43778);
      return;
    }
    synchronized (jvH)
    {
      jvH.put(paramo.mAppId, paramo);
      jvF.put(paramo.mAppId, paramo);
      if (paramo.aXc() != null) {
        i.bT(paramo.mAppId, paramo.aXc().cmr);
      }
      AppMethodBeat.o(43778);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a
 * JD-Core Version:    0.7.0.1
 */