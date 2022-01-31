package com.tencent.mm.plugin.appbrand.game.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.game.b.a.a;
import com.tencent.mm.plugin.appbrand.game.b.a.b;
import com.tencent.mm.plugin.appbrand.game.b.a.c;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

 enum i
{
  private static k.a hsL;
  private static k.a hsM;
  
  static
  {
    AppMethodBeat.i(130107);
    hsN = new i[0];
    hsL = new i.1();
    hsM = new i.2();
    AppMethodBeat.o(130107);
  }
  
  public static b Bv(String paramString)
  {
    AppMethodBeat.i(130102);
    if (g.auS() != null)
    {
      paramString = g.auS().Bv(paramString);
      AppMethodBeat.o(130102);
      return paramString;
    }
    AppMethodBeat.o(130102);
    return null;
  }
  
  public static AppBrandRecentTaskInfo Bw(String paramString)
  {
    AppMethodBeat.i(130103);
    if (g.auK() == null)
    {
      AppMethodBeat.o(130103);
      return null;
    }
    paramString = g.auK().zx(paramString);
    AppMethodBeat.o(130103);
    return paramString;
  }
  
  private static a a(AppBrandRecentTaskInfo paramAppBrandRecentTaskInfo)
  {
    AppMethodBeat.i(130104);
    if (paramAppBrandRecentTaskInfo == null)
    {
      AppMethodBeat.o(130104);
      return null;
    }
    a locala = new a();
    locala.ese = paramAppBrandRecentTaskInfo.ese;
    locala.fKw = paramAppBrandRecentTaskInfo.appId;
    locala.ntp = paramAppBrandRecentTaskInfo.appName;
    locala.IconUrl = paramAppBrandRecentTaskInfo.hcc;
    locala.jJA = paramAppBrandRecentTaskInfo.cmx;
    locala.gXd = paramAppBrandRecentTaskInfo.gXd;
    AppMethodBeat.o(130104);
    return locala;
  }
  
  public static List<b> aAA()
  {
    AppMethodBeat.i(130101);
    if (g.auS() == null)
    {
      AppMethodBeat.o(130101);
      return null;
    }
    Object localObject1 = new LinkedList();
    if (g.auK() != null)
    {
      localObject2 = g.auK().nx(10000);
      if (!bo.es((List)localObject2)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (!((AppBrandRecentTaskInfo)((Iterator)localObject2).next()).vY()) {
        ((Iterator)localObject2).remove();
      }
    }
    if (!bo.es((List)localObject1))
    {
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject2).add(a((AppBrandRecentTaskInfo)((Iterator)localObject1).next()));
      }
      g.auS().b((List)localObject2, false);
      ab.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandRecentTaskInfo convert to MiniGameStorage, size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
    }
    ab.i("MicroMsg.SearchMiniGameQueryLogic", "updateMiniGameList");
    localObject1 = g.auS().aAB();
    AppMethodBeat.o(130101);
    return localObject1;
  }
  
  public static void c(k.a parama)
  {
    AppMethodBeat.i(130099);
    if (g.auS() != null) {
      g.auS().add(parama);
    }
    AppMethodBeat.o(130099);
  }
  
  public static void d(k.a parama)
  {
    AppMethodBeat.i(130100);
    if (g.auS() != null) {
      g.auS().remove(parama);
    }
    AppMethodBeat.o(130100);
  }
  
  public static void onCreate()
  {
    AppMethodBeat.i(130097);
    q.ayA().add(hsL, e.aNS().oNc.getLooper());
    if (g.auK() != null) {
      g.auK().add(hsM);
    }
    AppMethodBeat.o(130097);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(130098);
    q.ayA().remove(hsL);
    if (g.auK() != null) {
      g.auK().remove(hsM);
    }
    AppMethodBeat.o(130098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.i
 * JD-Core Version:    0.7.0.1
 */