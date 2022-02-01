package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "isAcceptCgiBack", "", "source", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "", "performServerConfigChanged", "", "fromTabType", "", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "intent", "Landroid/content/Intent;", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends g
{
  public f(c paramc)
  {
    super(4, paramc);
    AppMethodBeat.i(346187);
    AppMethodBeat.o(346187);
  }
  
  public final void a(int paramInt, bwf parambwf)
  {
    boolean bool2 = true;
    AppMethodBeat.i(346216);
    s.u(parambwf, "serverConfig");
    super.a(paramInt, parambwf);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eTU().bmg()).intValue();
    boolean bool1 = parambwf.aaez;
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
      if ((paramInt == this.hJx) || (!bool1) || (!this.EWd)) {
        break label305;
      }
      bool3 = this.EWb.Rp(this.hJx);
      if (this.EWk.BeG == null) {
        break label271;
      }
      bool1 = true;
      l = c.Rr(this.hJx);
      if (cn.bDw() - this.EWk.mJI < c.Rr(this.hJx)) {
        break label277;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "[performConfigChange] isAutoRefresh=" + bool3 + " isLoading=" + this.EWm + " isOverTime=" + bool2 + " expired=" + l + " debugValue=" + i + " hasCache=" + bool1);
      if ((!bool3) || (this.EWm.isLoading) || (!bool2)) {
        break label283;
      }
      this.EWe.azn("performServerConfigChanged");
      this.EWe.a((a.a)new a(this), 0L, "performConfigChange");
      AppMethodBeat.o(346216);
      return;
      bool1 = false;
      break;
      label271:
      bool1 = false;
      break label102;
      label277:
      bool2 = false;
    }
    label283:
    Log.i(this.TAG, s.X("[performConfigChange] not need to preload. debugValue=", Integer.valueOf(i)));
    AppMethodBeat.o(346216);
    return;
    label305:
    Log.i(this.TAG, "[performConfigChange] not need to check hot preload. debugValue=" + i + " fromTabType=" + paramInt);
    AppMethodBeat.o(346216);
  }
  
  public final void a(g.g paramg, Intent paramIntent, kotlin.g.a.b<? super g.h, ah> paramb)
  {
    AppMethodBeat.i(346240);
    s.u(paramg, "source");
    s.u(paramb, "call");
    if ((c.a(paramg)) && (g.a((g)this, paramg)) && (paramg != g.g.EWE))
    {
      boolean bool = s.p(h.baE().ban().get(at.a.adax, Integer.valueOf(0)), Integer.valueOf(0));
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eUq().bmg()).intValue();
      if ((i > 0) && (bool) && (SystemClock.uptimeMillis() % i != 0L))
      {
        Log.i(this.TAG, s.X("[isValid] isFirst but not hit, random=", Integer.valueOf(i)));
        paramb.invoke(g.h.EWK);
        AppMethodBeat.o(346240);
        return;
      }
      h.baE().ban().set(at.a.adax, Integer.valueOf(1));
    }
    super.a(paramg, paramIntent, paramb);
    AppMethodBeat.o(346240);
  }
  
  public final boolean a(g.g paramg, aq.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(346227);
    s.u(paramg, "source");
    s.u(paramd, "resp");
    if (paramg == g.g.EWE)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is finder enter load.");
      AppMethodBeat.o(346227);
      return true;
    }
    k localk = k.aeZF;
    if (((com.tencent.mm.plugin.finder.viewmodel.d)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).GKp == 4)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is In hot tab.");
      AppMethodBeat.o(346227);
      return false;
    }
    boolean bool2;
    if ((paramg == g.g.EWD) || (paramg == g.g.EWz))
    {
      long l1 = cn.bDw();
      long l2 = this.EWk.mJI;
      int j = this.hJx;
      if (paramg == g.g.EWz)
      {
        bool1 = true;
        if (this.EWk.BeG == null) {
          break label207;
        }
        bool2 = true;
        label148:
        if (l1 - l2 < c.i(j, bool1, bool2)) {
          break label213;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label245;
      }
      Log.i(this.TAG, s.X("[isAcceptCgiBack] is not over time. lastTime=", Long.valueOf(this.EWk.mJI)));
      AppMethodBeat.o(346227);
      return false;
      bool1 = false;
      break;
      label207:
      bool2 = false;
      break label148;
      label213:
      i = 0;
      continue;
      if (cn.bDw() - this.EWk.mJI < c.Rr(this.hJx)) {
        i = 0;
      }
    }
    label245:
    if (((paramg == g.g.EWD) || (paramg == g.g.EWz)) && (this.EWd))
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is form outside but now is in finder.");
      AppMethodBeat.o(346227);
      return false;
    }
    boolean bool1 = super.a(paramg, paramd);
    AppMethodBeat.o(346227);
    return bool1;
  }
  
  public final boolean a(g.g paramg, String paramString)
  {
    AppMethodBeat.i(346255);
    s.u(paramg, "source");
    s.u(paramString, "log");
    boolean bool1;
    boolean bool3;
    if (this.EWb.eHM().fmM() == 4)
    {
      bool1 = true;
      bool3 = this.EWb.Rp(this.hJx);
      if (((paramg == g.g.EWz) || (paramg == g.g.EWB) || (paramg == g.g.EWD) || (paramg == g.g.EWE)) && (((!bool1) || (!bool3)) && (((paramg != g.g.EWC) && (paramg != g.g.EWF)) || (!this.EWd)))) {
        break label174;
      }
    }
    label174:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!super.a(paramg, ", ret=" + bool2 + " targetEnterHot=" + bool1 + " isAutoRefresh=" + bool3)) || (!bool2)) {
        break label180;
      }
      AppMethodBeat.o(346255);
      return true;
      bool1 = false;
      break;
    }
    label180:
    AppMethodBeat.o(346255);
    return false;
  }
  
  public final g.g eHO()
  {
    return g.g.EWD;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker$performServerConfigChanged$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends a.a
  {
    a(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(346213);
      g.a((g)this.EVY, g.g.EWC, (kotlin.g.a.b)a.EVZ);
      AppMethodBeat.o(346213);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<g.h, ah>
    {
      public static final a EVZ;
      
      static
      {
        AppMethodBeat.i(346220);
        EVZ = new a();
        AppMethodBeat.o(346220);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.f
 * JD-Core Version:    0.7.0.1
 */