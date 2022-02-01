package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderHomeActionReporter;", "", "()V", "CHANGE_VERSION", "", "TAG", "", "enterTabType", "isFirstResume", "", "isOnHomePage", "tabActionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/report/FinderHomeActionReporter$ActionData;", "tabDataMap", "Lcom/tencent/mm/plugin/finder/report/FinderHomeActionReporter$TabData;", "tabType", "disable", "getAction", "actionType", "getCostTime", "", "endAction", "startAction", "getPairType", "first", "second", "getTabData", "notifyCgi", "", "isBegin", "isAuto", "cgiStatus", "onCgiEnd", "onCgiStart", "onDestroy", "onEnterList", "context", "Landroid/content/Context;", "curPosition", "onEnterPage", "onLeaveList", "onLeavePage", "onLoadMoreEnd", "itemCount", "onLoadMoreStart", "onLoadingDisposed", "isTop", "onLoadingExposed", "onPause", "onRefreshEnd", "onRefreshStart", "onResume", "report", "actionPair", "Lkotlin/Pair;", "hasCgi", "setLoadingExposedListener", "view", "Landroid/view/View;", "updateAction", "updateTabData", "isLoading", "ActionData", "ActionType", "CgiStatus", "TabData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static int APX;
  public static boolean AuP;
  public static final o FpJ;
  public static boolean FpK;
  public static final ConcurrentHashMap<Integer, b> FpL;
  public static final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, a>> FpM;
  public static int hJx;
  
  static
  {
    AppMethodBeat.i(331620);
    FpJ = new o();
    AuP = true;
    FpL = new ConcurrentHashMap();
    FpM = new ConcurrentHashMap();
    AppMethodBeat.o(331620);
  }
  
  public static void B(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(331499);
    a locala = ic(paramInt1, paramInt2);
    locala.hzA = System.currentTimeMillis();
    locala.actionType = paramInt2;
    locala.AAc = paramBoolean;
    AppMethodBeat.o(331499);
  }
  
  private static b Si(int paramInt)
  {
    AppMethodBeat.i(331487);
    b localb = (b)FpL.get(Integer.valueOf(paramInt));
    if (localb == null)
    {
      localb = new b();
      ((Map)FpL).put(Integer.valueOf(paramInt), localb);
      AppMethodBeat.o(331487);
      return localb;
    }
    AppMethodBeat.o(331487);
    return localb;
  }
  
  public static long a(Context paramContext, int paramInt, r<Integer, Integer> paramr, boolean paramBoolean)
  {
    AppMethodBeat.i(331580);
    JSONObject localJSONObject = new JSONObject();
    Object localObject = Si(paramInt);
    localJSONObject.put("curPosition", ((b)localObject).CVo);
    localJSONObject.put("itemCount", ((b)localObject).bUo);
    localJSONObject.put("isExposed", ((b)localObject).AMQ);
    localJSONObject.put("isLoading", ((b)localObject).isLoading);
    localJSONObject.put("isTop", ((b)localObject).FpN);
    localJSONObject.put("cgiStatus", ((b)localObject).FpO);
    localObject = ic(paramInt, ((Number)paramr.bsC).intValue());
    localJSONObject.put("actionType", ((a)localObject).actionType);
    localJSONObject.put("actionTime", ((a)localObject).hzA);
    localJSONObject.put("isAuto", ((a)localObject).AAc);
    localJSONObject.put("pairType", ie(((Number)paramr.bsC).intValue(), ((Number)paramr.bsD).intValue()));
    long l = a((a)localObject, ic(paramInt, ((Number)paramr.bsD).intValue()));
    localJSONObject.put("pairTime", l);
    if (paramBoolean) {
      localJSONObject.put("cgiTime", a(ic(paramInt, 12), ic(paramInt, 11)));
    }
    localJSONObject.put("tabType", paramInt);
    localJSONObject.put("enterTabType", APX);
    paramr = as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.fou();
      if (paramContext != null)
      {
        paramr = c.FnB;
        c.a(paramContext, ((a)localObject).hzA, localJSONObject);
      }
    }
    AppMethodBeat.o(331580);
    return l;
  }
  
  private static long a(a parama1, a parama2)
  {
    AppMethodBeat.i(331567);
    if (parama2.hzA > 0L)
    {
      if (parama1.hzA > parama2.hzA)
      {
        l1 = parama1.hzA;
        l2 = parama2.hzA;
        AppMethodBeat.o(331567);
        return l1 - l2;
      }
      long l1 = System.currentTimeMillis();
      long l2 = parama2.hzA;
      AppMethodBeat.o(331567);
      return l1 - l2;
    }
    AppMethodBeat.o(331567);
    return 0L;
  }
  
  public static void c(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(331511);
    b localb = Si(paramInt1);
    localb.bUo = paramInt2;
    localb.isLoading = paramBoolean;
    localb.CVo = paramInt3;
    AppMethodBeat.o(331511);
  }
  
  public static boolean cng()
  {
    AppMethodBeat.i(331595);
    d locald = d.FAy;
    if (((Number)d.eXy().bmg()).intValue() == 0)
    {
      AppMethodBeat.o(331595);
      return true;
    }
    AppMethodBeat.o(331595);
    return false;
  }
  
  public static void e(View paramView, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(331549);
    if (cng())
    {
      AppMethodBeat.o(331549);
      return;
    }
    if (paramView != null) {
      f.a(paramView, (e.b)new c(paramInt, paramBoolean));
    }
    AppMethodBeat.o(331549);
  }
  
  public static void g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331525);
    s.u(paramContext, "context");
    if (cng())
    {
      AppMethodBeat.o(331525);
      return;
    }
    Log.i("Finder.HomeActionReporter", "[onLeaveList] tabType:" + paramInt1 + " curPosition:" + paramInt2);
    hJx = paramInt1;
    Si(paramInt1).CVo = paramInt2;
    B(paramInt1, 4, false);
    a(paramContext, paramInt1, new r(Integer.valueOf(4), Integer.valueOf(3)), true);
    AppMethodBeat.o(331525);
  }
  
  private static a ic(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331493);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)FpM.get(Integer.valueOf(paramInt1));
    if (localConcurrentHashMap == null)
    {
      localConcurrentHashMap = new ConcurrentHashMap();
      ((Map)FpM).put(Integer.valueOf(paramInt1), localConcurrentHashMap);
    }
    for (;;)
    {
      a locala = (a)localConcurrentHashMap.get(Integer.valueOf(paramInt2));
      if (locala == null)
      {
        locala = new a();
        ((Map)localConcurrentHashMap).put(Integer.valueOf(paramInt2), locala);
        AppMethodBeat.o(331493);
        return locala;
      }
      AppMethodBeat.o(331493);
      return locala;
    }
  }
  
  private static String ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331518);
    String str = paramInt1 + '-' + paramInt2;
    AppMethodBeat.o(331518);
    return str;
  }
  
  private static void j(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(331532);
    Log.i("Finder.HomeActionReporter", "[onCgiStart] tabType:" + paramInt1 + " isAuto:" + paramBoolean + " cgiStatus:" + paramInt2);
    B(paramInt1, 11, paramBoolean);
    Si(paramInt1).FpO = paramInt2;
    AppMethodBeat.o(331532);
  }
  
  private static void k(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(331540);
    Log.i("Finder.HomeActionReporter", "[onCgiEnd] tabType:" + paramInt1 + " isAuto:" + paramBoolean + " cgiStatus:" + paramInt2);
    B(paramInt1, 12, paramBoolean);
    Si(paramInt1).FpO = paramInt2;
    AppMethodBeat.o(331540);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(331636);
    if (cng())
    {
      AppMethodBeat.o(331636);
      return;
    }
    if (!FpK)
    {
      AppMethodBeat.o(331636);
      return;
    }
    if (paramBoolean1)
    {
      j(paramInt1, paramBoolean2, paramInt2);
      AppMethodBeat.o(331636);
      return;
    }
    k(paramInt1, paramBoolean2, paramInt2);
    AppMethodBeat.o(331636);
  }
  
  public final void f(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331627);
    s.u(paramContext, "context");
    if (cng())
    {
      AppMethodBeat.o(331627);
      return;
    }
    Log.i("Finder.HomeActionReporter", "[onEnterList] tabType:" + paramInt1 + " curPosition:" + paramInt2);
    hJx = paramInt1;
    Si(paramInt1).CVo = paramInt2;
    B(paramInt1, 3, false);
    a(paramContext, paramInt1, new r(Integer.valueOf(3), Integer.valueOf(0)), false);
    AppMethodBeat.o(331627);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderHomeActionReporter$ActionData;", "", "()V", "actionTime", "", "getActionTime", "()J", "setActionTime", "(J)V", "actionType", "", "getActionType", "()I", "setActionType", "(I)V", "isAuto", "", "()Z", "setAuto", "(Z)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    boolean AAc;
    int actionType;
    long hzA;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderHomeActionReporter$TabData;", "", "()V", "cgiStatus", "", "getCgiStatus", "()I", "setCgiStatus", "(I)V", "curPosition", "getCurPosition", "setCurPosition", "isExposed", "", "()Z", "setExposed", "(Z)V", "isLoading", "setLoading", "isTop", "setTop", "itemCount", "getItemCount", "setItemCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    boolean AMQ;
    int CVo;
    boolean FpN;
    int FpO;
    int bUo;
    boolean isLoading;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderHomeActionReporter$setLoadingExposedListener$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e.b
  {
    c(int paramInt, boolean paramBoolean) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(331243);
      s.u(paramView, "view");
      if (paramBoolean)
      {
        localo = o.FpJ;
        paramView = paramView.getContext();
        s.s(paramView, "view.context");
        o.a(localo, paramView, this.AEa, paramBoolean);
        AppMethodBeat.o(331243);
        return;
      }
      o localo = o.FpJ;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      o.b(localo, paramView, this.AEa, paramBoolean);
      AppMethodBeat.o(331243);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.o
 * JD-Core Version:    0.7.0.1
 */