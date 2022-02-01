package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "", "isAcceptCgiBack", "", "source", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "intent", "Landroid/content/Intent;", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "plugin-finder_release"})
public final class d
  extends f
{
  public d(FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    super(4, paramFinderStreamTabPreloadCore);
    AppMethodBeat.i(249587);
    AppMethodBeat.o(249587);
  }
  
  public final void a(int paramInt, bcy parambcy)
  {
    boolean bool2 = true;
    AppMethodBeat.i(249583);
    p.h(parambcy, "serverConfig");
    super.a(paramInt, parambcy);
    c localc = c.vCb;
    int i = ((Number)c.duu().value()).intValue();
    boolean bool1 = parambcy.LMv;
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
      if ((paramInt == this.dLS) || (!bool1) || (!this.uVa)) {
        break label302;
      }
      bool3 = this.uVh.JN(this.dLS);
      if (this.uVg.uVi == null) {
        break label268;
      }
      bool1 = true;
      l = FinderStreamTabPreloadCore.JO(this.dLS);
      if (cl.aWA() - this.uVg.hwQ < FinderStreamTabPreloadCore.JO(this.dLS)) {
        break label274;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "[performConfigChange] isAutoRefresh=" + bool3 + " isLoading=" + this.isLoading + " isOverTime=" + bool2 + " expired=" + l + " debugValue=" + i + " hasCache=" + bool1);
      if ((!bool3) || (this.isLoading) || (!bool2)) {
        break label280;
      }
      this.uVb.aut("performServerConfigChanged");
      this.uVb.a((a.a)new a(this), 0L, "performConfigChange");
      AppMethodBeat.o(249583);
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
    AppMethodBeat.o(249583);
    return;
    label302:
    Log.i(this.TAG, "[performConfigChange] not need to check hot preload. debugValue=" + i + " fromTabType=" + paramInt);
    AppMethodBeat.o(249583);
  }
  
  public final void a(f.c paramc, Intent paramIntent, kotlin.g.a.b<? super f.d, x> paramb)
  {
    AppMethodBeat.i(249585);
    p.h(paramc, "source");
    p.h(paramb, "call");
    if ((FinderStreamTabPreloadCore.a(paramc)) && (f.a(this, paramc)) && (paramc != f.c.uVt))
    {
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = p.j(((e)localObject).azQ().get(ar.a.Okf, Integer.valueOf(0)), Integer.valueOf(0));
      localObject = c.vCb;
      int i = ((Number)c.duH().value()).intValue();
      if ((i > 0) && (bool) && (SystemClock.uptimeMillis() % i != 0L))
      {
        Log.i(this.TAG, "[isValid] isFirst but not hit, random=".concat(String.valueOf(i)));
        paramb.invoke(f.d.uVx);
        AppMethodBeat.o(249585);
        return;
      }
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).azQ().set(ar.a.Okf, Integer.valueOf(1));
    }
    super.a(paramc, paramIntent, paramb);
    AppMethodBeat.o(249585);
  }
  
  public final boolean a(f.c paramc, aa.f paramf)
  {
    int i = 1;
    AppMethodBeat.i(249584);
    p.h(paramc, "source");
    p.h(paramf, "resp");
    if (paramc == f.c.uVt)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is finder enter load.");
      AppMethodBeat.o(249584);
      return true;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    if (((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).wtW == 4)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is In hot tab.");
      AppMethodBeat.o(249584);
      return false;
    }
    if (paramc == f.c.uVs) {
      if (cl.aWA() - this.uVg.hwQ < FinderStreamTabPreloadCore.al(this.dLS, false)) {}
    }
    while (i == 0)
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is not over time. lastTime=" + this.uVg.hwQ);
      AppMethodBeat.o(249584);
      return false;
      i = 0;
      continue;
      if (cl.aWA() - this.uVg.hwQ < FinderStreamTabPreloadCore.JO(this.dLS)) {
        i = 0;
      }
    }
    if ((paramc == f.c.uVs) && (this.uVa))
    {
      Log.i(this.TAG, "[isAcceptCgiBack] is form outside but now is in finder.");
      AppMethodBeat.o(249584);
      return false;
    }
    boolean bool = super.a(paramc, paramf);
    AppMethodBeat.o(249584);
    return bool;
  }
  
  public final boolean a(f.c paramc, String paramString)
  {
    AppMethodBeat.i(249586);
    p.h(paramc, "source");
    p.h(paramString, "log");
    boolean bool1;
    boolean bool3;
    if (this.uVh.dlH().dHR() == 4)
    {
      bool1 = true;
      bool3 = this.uVh.JN(this.dLS);
      if (((paramc == f.c.uVq) || (paramc == f.c.uVs) || (paramc == f.c.uVt)) && (((!bool1) || (!bool3)) && ((paramc != f.c.uVr) || (!this.uVa)))) {
        break label160;
      }
    }
    label160:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!super.a(paramc, ", ret=" + bool2 + " targetEnterHot=" + bool1 + " isAutoRefresh=" + bool3)) || (!bool2)) {
        break label166;
      }
      AppMethodBeat.o(249586);
      return true;
      bool1 = false;
      break;
    }
    label166:
    AppMethodBeat.o(249586);
    return false;
  }
  
  public final f.c dlJ()
  {
    return f.c.uVs;
  }
  
  public final long dlK()
  {
    AppMethodBeat.i(249581);
    long l = FinderStreamTabPreloadCore.al(this.dLS, false);
    AppMethodBeat.o(249581);
    return l;
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249582);
    super.gc(paramInt1, paramInt2);
    boolean bool = ((PluginFinder)g.ah(PluginFinder.class)).isInFinder();
    Log.i(this.TAG, "[performChangeEnterTargetTab] isInFinder=".concat(String.valueOf(bool)));
    if (paramInt2 != this.dLS)
    {
      this.uVb.aut("performChangeEnterTargetTab");
      AppMethodBeat.o(249582);
      return;
    }
    if (!bool)
    {
      Log.i(this.TAG, "[performChangeEnterTargetTab] clearCache lastTab=" + paramInt1 + " targetTab=" + paramInt2);
      nM(true);
      this.uVb.a(this.uVf, dlK(), "performChangeEnterTargetTab");
    }
    AppMethodBeat.o(249582);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker$performServerConfigChanged$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class a
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(249580);
      this.uUX.a(f.c.uVr, null, (kotlin.g.a.b)a.uUY);
      AppMethodBeat.o(249580);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<f.d, x>
    {
      public static final a uUY;
      
      static
      {
        AppMethodBeat.i(249579);
        uUY = new a();
        AppMethodBeat.o(249579);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.d
 * JD-Core Version:    0.7.0.1
 */