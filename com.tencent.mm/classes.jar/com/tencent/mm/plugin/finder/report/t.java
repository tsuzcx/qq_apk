package com.tencent.mm.plugin.finder.report;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.dx;
import com.tencent.mm.autogen.mmdata.rpt.fc;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.service.g;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.finder.ui.FinderMultiTaskRouterUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI.b;
import com.tencent.mm.plugin.l;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderMultiTaskReporter;", "", "()V", "TAG", "", "registerLifecycleReport", "", "finder", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "report23850", "op", "Lcom/tencent/mm/plugin/finder/report/FinderMultiTaskReporter$Op;", "reportEnter", "isMainProcBackground", "", "isScreenOff", "reportEnterMultiTask", "Op", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t Fro;
  
  static
  {
    AppMethodBeat.i(331462);
    Fro = new t();
    AppMethodBeat.o(331462);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(331449);
    s.u(parama, "op");
    Object localObject1 = new fc();
    ((fc)localObject1).iGF = parama.type;
    ((fc)localObject1).iGG = ((fc)localObject1).F("opDesc", parama.desc, true);
    ((fc)localObject1).bMH();
    Object localObject2 = new StringBuilder("report23850: type = ").append(parama.type);
    label170:
    int i;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject1 = s.X(", desc = ", parama.desc);
      Log.i("FinderMultiTaskReporter", (String)localObject1);
      if (parama == a.Frz)
      {
        long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.adfe, 0L);
        if (l != 0L)
        {
          l = cn.bDw() - l;
          localObject1 = com.tencent.mm.kernel.h.ax(l.class);
          if (!(localObject1 instanceof g)) {
            break label381;
          }
          localObject1 = (g)localObject1;
          if (localObject1 != null) {
            break label387;
          }
          i = 0;
          label177:
          localObject1 = new dx();
          ((dx)localObject1).aIM();
          ((dx)localObject1).ixD = 10L;
          ((dx)localObject1).ob(String.valueOf(l));
          localObject2 = new i();
          ((i)localObject2).t("exitToReenterMultiTaskTime", l);
          ((i)localObject2).au("enterFinderTaskUISize", i);
          localObject2 = ((i)localObject2).toString();
          s.s(localObject2, "json.toString()");
          ((dx)localObject1).nZ(n.bV((String)localObject2, ",", ";"));
          ((dx)localObject1).bMH();
          Log.i("FinderMultiTaskReporter", s.X("report21680 reportEnterMultiTask:", ((dx)localObject1).aIF()));
        }
      }
      switch (b.$EnumSwitchMapping$0[parama.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(331449);
      return;
      localObject1 = "";
      break;
      label381:
      localObject1 = null;
      break label170;
      label387:
      i = ((g)localObject1).ePx();
      break label177;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 0L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 1L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 2L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 3L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 4L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 5L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 6L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 7L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 8L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 101L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 102L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 103L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 104L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 105L, 1L);
      AppMethodBeat.o(331449);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1767L, 106L, 1L);
    }
  }
  
  public static void e(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(331458);
    s.u(paramMMFinderUI, "finder");
    if ((paramMMFinderUI instanceof FinderMultiTaskRouterUI))
    {
      AppMethodBeat.o(331458);
      return;
    }
    Object localObject = com.tencent.mm.kernel.h.ax(l.class);
    if (localObject == null)
    {
      paramMMFinderUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.service.FinderMultiTaskService");
      AppMethodBeat.o(331458);
      throw paramMMFinderUI;
    }
    localObject = (g)localObject;
    if (((g)localObject).D((Activity)paramMMFinderUI)) {
      paramMMFinderUI.FVI = ((MMFinderUI.b)new c(paramMMFinderUI, (g)localObject));
    }
    AppMethodBeat.o(331458);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderMultiTaskReporter$Op;", "", "type", "", "desc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getType", "()I", "ENTER_FINDER_TOTAL", "ENTER_FINDER_TASK_TOTAL", "ENTER_FINDER_TASK_FROM_SYSTEM_UI", "ENTER_FINDER_TASK_FROM_WECHAT", "EXIT_FROM_FINDER_TASK", "ENTER_FINDER_TASK_FROM_SCREEN_OFF", "ENTER_FINDER_TASK_LIVE", "ENTER_NORMAL_TASK_LIVE", "ENTER_FINDER_TASK_FROM_LAUNCHER", "FINDER_TASK_ON_RESUME_TOTAL", "FINDER_TASK_ON_RESUME_UNKNOWN", "FINDER_TASK_ON_RESUME_FROM_ON_CREATE", "FINDER_TASK_ON_RESUME_FROM_NEW_INTENT", "FINDER_TASK_ON_RESUME_FROM_SCREEN_OFF", "FINDER_TASK_ON_RESUME_FROM_LAUNCHER", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    final String desc;
    final int type;
    
    static
    {
      AppMethodBeat.i(331038);
      Frp = new a("ENTER_FINDER_TOTAL", 0, 1, "进入视频号总量");
      Frq = new a("ENTER_FINDER_TASK_TOTAL", 1, 2, "进入视频号task总量");
      Frr = new a("ENTER_FINDER_TASK_FROM_SYSTEM_UI", 2, 3, "从系统多任务进入视频号task");
      Frs = new a("ENTER_FINDER_TASK_FROM_WECHAT", 3, 4, "从微信内进入视频号task");
      Frt = new a("EXIT_FROM_FINDER_TASK", 4, 5, "从视频号task退后台");
      Fru = new a("ENTER_FINDER_TASK_FROM_SCREEN_OFF", 5, 6, "从息屏到亮屏进入视频号task");
      Frv = new a("ENTER_FINDER_TASK_LIVE", 6, 7, "进入视频号task的直播间");
      Frw = new a("ENTER_NORMAL_TASK_LIVE", 7, 8, "进入主task的直播间");
      Frx = new a("ENTER_FINDER_TASK_FROM_LAUNCHER", 8, 9, "点击桌面微信icon进入视频号task");
      Fry = new a("FINDER_TASK_ON_RESUME_TOTAL", 9, 101, "OnResume总量");
      Frz = new a("FINDER_TASK_ON_RESUME_UNKNOWN", 10, 102, "未知来源OnResume(大概率多任务)");
      FrA = new a("FINDER_TASK_ON_RESUME_FROM_ON_CREATE", 11, 103, "OnResume来源为onCreate");
      FrB = new a("FINDER_TASK_ON_RESUME_FROM_NEW_INTENT", 12, 104, "OnResume来源为onNewIntent");
      FrC = new a("FINDER_TASK_ON_RESUME_FROM_SCREEN_OFF", 13, 105, "OnResume来源为息屏再开");
      FrD = new a("FINDER_TASK_ON_RESUME_FROM_LAUNCHER", 14, 106, "OnResume来源为从桌面点开");
      FrE = new a[] { Frp, Frq, Frr, Frs, Frt, Fru, Frv, Frw, Frx, Fry, Frz, FrA, FrB, FrC, FrD };
      AppMethodBeat.o(331038);
    }
    
    private a(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.desc = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderMultiTaskReporter$registerLifecycleReport$1", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$SimpleLifecycleCallback;", "hasReported", "", "getHasReported", "()Z", "setHasReported", "(Z)V", "reportKey", "Lcom/tencent/mm/plugin/finder/report/FinderMultiTaskReporter$Op;", "getReportKey", "()Lcom/tencent/mm/plugin/finder/report/FinderMultiTaskReporter$Op;", "setReportKey", "(Lcom/tencent/mm/plugin/finder/report/FinderMultiTaskReporter$Op;)V", "reportLifeCycle", "", "lifecycle", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MMFinderUI.b
  {
    private t.a FrF = t.a.Frz;
    private boolean FrG;
    
    c(MMFinderUI paramMMFinderUI, g paramg) {}
    
    public final void azK(String paramString)
    {
      AppMethodBeat.i(331037);
      s.u(paramString, "lifecycle");
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(331037);
        return;
        if (!paramString.equals("onCreate"))
        {
          AppMethodBeat.o(331037);
          return;
          if (paramString.equals("onNewIntent")) {
            break label425;
          }
          AppMethodBeat.o(331037);
          return;
          if (!paramString.equals("onPause"))
          {
            AppMethodBeat.o(331037);
            return;
            if (paramString.equals("onScreenOff")) {
              break label438;
            }
            AppMethodBeat.o(331037);
            return;
            if (paramString.equals("onResume")) {
              break label201;
            }
            AppMethodBeat.o(331037);
          }
        }
        else
        {
          if ((this.FrH.getIntent().getFlags() & 0x100000) > 0) {}
          for (paramString = t.a.Frz;; paramString = t.a.FrA)
          {
            this.FrF = paramString;
            AppMethodBeat.o(331037);
            return;
          }
        }
        this.FrF = t.a.Frz;
        this.FrG = false;
        AppMethodBeat.o(331037);
        return;
        label201:
        if (this.FrG)
        {
          AppMethodBeat.o(331037);
          return;
        }
        this.FrG = true;
        if (this.FrI.pFe.size() == 2)
        {
          paramString = this.FrI.pFe;
          s.s(paramString, "finderMultiTaskService.foregroundFinderActivity");
          Object localObject1 = (Iterable)paramString;
          paramString = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if ((localObject2 instanceof FinderMultiTaskRouterUI)) {
              paramString.add(localObject2);
            }
          }
          if (!((Collection)paramString).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label420;
            }
          }
        }
        label420:
        for (int i = 1;; i = 0)
        {
          if ((this.FrI.pFe.size() != 1) && (i == 0) && ((!s.p(this.FrH.getClass(), FinderHomeAffinityUI.class)) || (this.FrF != t.a.FrB))) {
            break label423;
          }
          if (i != 0) {
            this.FrF = t.a.FrD;
          }
          paramString = t.Fro;
          t.a(t.a.Fry);
          paramString = t.Fro;
          t.a(this.FrF);
          AppMethodBeat.o(331037);
          return;
          i = 0;
          break;
        }
        label423:
        continue;
        label425:
        this.FrF = t.a.FrB;
        AppMethodBeat.o(331037);
        return;
        label438:
        this.FrF = t.a.FrC;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.t
 * JD-Core Version:    0.7.0.1
 */