package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final LinkedHashMap<String, o> gOG;
  public static int gOH;
  private static final Map<String, o> gOI;
  
  static
  {
    AppMethodBeat.i(128924);
    ah.getContext().registerComponentCallbacks(new a.1());
    gOG = new a.2();
    gOH = 4;
    gOI = new HashMap();
    AppMethodBeat.o(128924);
  }
  
  public static boolean a(o paramo)
  {
    AppMethodBeat.i(154311);
    synchronized (gOI)
    {
      boolean bool = gOG.containsValue(paramo);
      AppMethodBeat.o(154311);
      return bool;
    }
  }
  
  static void b(o paramo)
  {
    AppMethodBeat.i(128919);
    if (bo.isNullOrNil(paramo.mAppId))
    {
      ab.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      AppMethodBeat.o(128919);
      return;
    }
    synchronized (gOI)
    {
      o localo = (o)gOI.get(paramo.mAppId);
      if ((localo == null) || (localo == paramo))
      {
        gOI.remove(paramo.mAppId);
        gOG.remove(paramo.mAppId);
        AppMethodBeat.o(128919);
        return;
      }
      ab.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { bo.l(new Throwable()) });
    }
  }
  
  public static void c(i parami)
  {
    AppMethodBeat.i(143029);
    LinkedList localLinkedList = new LinkedList();
    synchronized (gOI)
    {
      Iterator localIterator = gOI.values().iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if ((localo != null) && (localo.vY()) && (localo != parami)) {
          localLinkedList.add(localo);
        }
      }
    }
    parami = localLinkedList.iterator();
    while (parami.hasNext()) {
      ((o)parami.next()).atX();
    }
    AppMethodBeat.o(143029);
  }
  
  static void c(o paramo)
  {
    AppMethodBeat.i(128920);
    if (bo.isNullOrNil(paramo.mAppId))
    {
      ab.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
      AppMethodBeat.o(128920);
      return;
    }
    synchronized (gOI)
    {
      gOI.put(paramo.mAppId, paramo);
      gOG.put(paramo.mAppId, paramo);
      if (paramo.atS() != null) {
        f.br(paramo.mAppId, paramo.atS().bCV);
      }
      AppMethodBeat.o(128920);
      return;
    }
  }
  
  public static o xL(String paramString)
  {
    AppMethodBeat.i(128921);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(128921);
      return null;
    }
    synchronized (gOI)
    {
      paramString = (o)gOI.get(paramString);
      AppMethodBeat.o(128921);
      return paramString;
    }
  }
  
  @Deprecated
  public static AppBrandSysConfigWC xM(String paramString)
  {
    AppMethodBeat.i(128922);
    paramString = xL(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(128922);
      return null;
    }
    paramString = paramString.atR();
    AppMethodBeat.o(128922);
    return paramString;
  }
  
  @Deprecated
  public static AppBrandStatObject xN(String paramString)
  {
    AppMethodBeat.i(128923);
    paramString = xL(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(128923);
      return null;
    }
    paramString = paramString.wS().bDh;
    AppMethodBeat.o(128923);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a
 * JD-Core Version:    0.7.0.1
 */