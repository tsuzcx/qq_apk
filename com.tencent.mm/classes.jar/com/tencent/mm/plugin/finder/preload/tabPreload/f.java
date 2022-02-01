package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "", "isAcceptCgiBack", "", "source", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "intent", "Landroid/content/Intent;", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "plugin-finder_release"})
public final class f
  extends g
{
  public f(c paramc)
  {
    super(4, paramc);
    AppMethodBeat.i(270433);
    AppMethodBeat.o(270433);
  }
  
  public final void a(int paramInt, bju parambju)
  {
    boolean bool2 = true;
    AppMethodBeat.i(270429);
    p.k(parambju, "serverConfig");
    super.a(paramInt, parambju);
    d locald = d.AjH;
    int i = ((Number)d.dVB().aSr()).intValue();
    boolean bool1 = parambju.SUr;
    boolean bool3;
    label102:
    long l;
    if (i >= 0)
    {
      if (i == 1) {
        bool1 = true;
      }
    }
    else
    {
      if ((paramInt == this.fEH) || (!bool1) || (!this.zLs)) {
        break label302;
      }
      bool3 = this.zLz.OO(this.fEH);
      if (this.zLy.zLA == null) {
        break label268;
      }
      bool1 = true;
      l = c.OP(this.fEH);
      if (cm.bfE() - this.zLy.kje < c.OP(this.fEH)) {
        break label274;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "[performConfigChange] isAutoRefresh=" + bool3 + " isLoading=" + this.isLoading + " isOverTime=" + bool2 + " expired=" + l + " debugValue=" + i + " hasCache=" + bool1);
      if ((!bool3) || (this.isLoading) || (!bool2)) {
        break label280;
      }
      this.zLt.aDJ("performServerConfigChanged");
      this.zLt.a((a.a)new a(this), 0L, "performConfigChange");
      AppMethodBeat.o(270429);
      return;
      bool1 = false;
      break;
      label268:
      bool1 = false;
      break label102;
      label274:
      bool2 = false;
    }
    label280:
    Log.i(this.TAG, "[performConfigChange] not need to preload. debugValue=".concat(String.valueOf(i)));
    AppMethodBeat.o(270429);
    return;
    label302:
    Log.i(this.TAG, "[performConfigChange] not need to check hot preload. debugValue=" + i + " fromTabType=" + paramInt);
    AppMethodBeat.o(270429);
  }
  
  public final void a(g.c paramc, Intent paramIntent, kotlin.g.a.b<? super g.d, x> paramb)
  {
    AppMethodBeat.i(270431);
    p.k(paramc, "source");
    p.k(paramb, "call");
    if ((c.a(paramc)) && (g.a(this, paramc)) && (paramc != g.c.zLL))
    {
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      boolean bool = p.h(((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VyB, Integer.valueOf(0)), Integer.valueOf(0));
      localObject = d.AjH;
      int i = ((Number)d.dVO().aSr()).intValue();
      if ((i > 0) && (bool) && (SystemClock.uptimeMillis() % i != 0L))
      {
        Log.i(this.TAG, "[isValid] isFirst but not hit, random=".concat(String.valueOf(i)));
        paramb.invoke(g.d.zLP);
        AppMethodBeat.o(270431);
        return;
      }
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VyB, Integer.valueOf(1));
    }
    super.a(paramc, paramIntent, paramb);
    AppMethodBeat.o(270431);
  }
  
  public final boolean a(g.c paramc, aa.f paramf)
  {
    int i = 1;
    AppMethodBeat.i(270430);
    p.k(paramc, "source");
    p.k(paramf, "resp");
    if (paramc == g.c.zLL)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is finder enter load.");
      AppMethodBeat.o(270430);
      return true;
    }
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    if (((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).Bgp == 4)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is In hot tab.");
      AppMethodBeat.o(270430);
      return false;
    }
    if (paramc == g.c.zLK) {
      if (cm.bfE() - this.zLy.kje < c.an(this.fEH, false)) {}
    }
    while (i == 0)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is not over time. lastTime=" + this.zLy.kje);
      AppMethodBeat.o(270430);
      return false;
      i = 0;
      continue;
      if (cm.bfE() - this.zLy.kje < c.OP(this.fEH)) {
        i = 0;
      }
    }
    if ((paramc == g.c.zLK) && (this.zLs))
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is form outside but now is in finder.");
      AppMethodBeat.o(270430);
      return false;
    }
    boolean bool = super.a(paramc, paramf);
    AppMethodBeat.o(270430);
    return bool;
  }
  
  public final boolean a(g.c paramc, String paramString)
  {
    AppMethodBeat.i(270432);
    p.k(paramc, "source");
    p.k(paramString, "log");
    boolean bool1;
    boolean bool3;
    if (this.zLz.dMI().ekb() == 4)
    {
      bool1 = true;
      bool3 = this.zLz.OO(this.fEH);
      if (((paramc == g.c.zLI) || (paramc == g.c.zLK) || (paramc == g.c.zLL)) && (((!bool1) || (!bool3)) && ((paramc != g.c.zLJ) || (!this.zLs)))) {
        break label160;
      }
    }
    label160:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!super.a(paramc, ", ret=" + bool2 + " targetEnterHot=" + bool1 + " isAutoRefresh=" + bool3)) || (!bool2)) {
        break label166;
      }
      AppMethodBeat.o(270432);
      return true;
      bool1 = false;
      break;
    }
    label166:
    AppMethodBeat.o(270432);
    return false;
  }
  
  public final g.c dML()
  {
    return g.c.zLK;
  }
  
  public final long dMM()
  {
    AppMethodBeat.i(270427);
    long l = c.an(this.fEH, false);
    AppMethodBeat.o(270427);
    return l;
  }
  
  public final void gO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270428);
    super.gO(paramInt1, paramInt2);
    boolean bool = ((PluginFinder)h.ag(PluginFinder.class)).isInFinder();
    Log.i(this.TAG, "[performChangeEnterTargetTab] isInFinder=".concat(String.valueOf(bool)));
    if (bool)
    {
      AppMethodBeat.o(270428);
      return;
    }
    if (paramInt2 != this.fEH)
    {
      this.zLt.aDJ("performChangeEnterTargetTab");
      AppMethodBeat.o(270428);
      return;
    }
    if (!bool)
    {
      long l = dMN();
      bool = pV(true);
      Log.i(this.TAG, "[performChangeEnterTargetTab] clearCache lastTab=" + paramInt1 + " targetTab=" + paramInt2 + " delayed=" + l + " ms");
      this.zLt.a(this.zLx, l, "performChangeEnterTargetTab");
      if (bool)
      {
        b localb = b.zLe;
        b.c(0, 3, 3, false, 115);
      }
    }
    AppMethodBeat.o(270428);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker$performServerConfigChanged$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class a
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(279197);
      this.zLp.a(g.c.zLJ, null, (kotlin.g.a.b)a.zLq);
      AppMethodBeat.o(279197);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<g.d, x>
    {
      public static final a zLq;
      
      static
      {
        AppMethodBeat.i(287229);
        zLq = new a();
        AppMethodBeat.o(287229);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.f
 * JD-Core Version:    0.7.0.1
 */