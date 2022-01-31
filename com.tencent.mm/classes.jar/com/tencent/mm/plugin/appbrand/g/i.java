package com.tencent.mm.plugin.appbrand.g;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

 enum i
{
  private static final a hrT;
  
  static
  {
    AppMethodBeat.i(129991);
    hrU = new i[0];
    hrT = new a();
    AppMethodBeat.o(129991);
  }
  
  static AppBrandRecentTaskInfo Bq(String paramString)
  {
    AppMethodBeat.i(129988);
    if (g.auK() == null)
    {
      AppMethodBeat.o(129988);
      return null;
    }
    paramString = g.auK().zx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(129988);
      return null;
    }
    if ((paramString.vY()) && (com.tencent.mm.modelappbrand.a.acg()))
    {
      AppMethodBeat.o(129988);
      return null;
    }
    AppMethodBeat.o(129988);
    return paramString;
  }
  
  static List<AppBrandRecentTaskInfo> aAq()
  {
    AppMethodBeat.i(129987);
    LinkedList localLinkedList = new LinkedList();
    Object localObject;
    if (g.auK() != null)
    {
      localObject = g.auK().nx(10000);
      if (!bo.es((List)localObject)) {
        localLinkedList.addAll((Collection)localObject);
      }
    }
    if (com.tencent.mm.modelappbrand.a.acg())
    {
      localObject = localLinkedList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((AppBrandRecentTaskInfo)((Iterator)localObject).next()).vY()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    AppMethodBeat.o(129987);
    return localLinkedList;
  }
  
  static void c(k.a parama)
  {
    AppMethodBeat.i(129989);
    if (g.auK() != null) {
      g.auK().add(parama);
    }
    AppMethodBeat.o(129989);
  }
  
  static void d(k.a parama)
  {
    AppMethodBeat.i(129990);
    if (g.auK() != null) {
      g.auK().remove(parama);
    }
    AppMethodBeat.o(129990);
  }
  
  static void onCreate()
  {
    AppMethodBeat.i(129985);
    q.ayA().add(hrT, e.aNS().oNc.getLooper());
    AppMethodBeat.o(129985);
  }
  
  static void onDestroy()
  {
    AppMethodBeat.i(129986);
    q.ayA().remove(hrT);
    AppMethodBeat.o(129986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.i
 * JD-Core Version:    0.7.0.1
 */