package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.ViewModelProvider;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "", "isAcceptCgiBack", "", "source", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "plugin-finder_release"})
public final class d
  extends f
{
  public d(FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    super(4, paramFinderStreamTabPreloadCore);
    AppMethodBeat.i(203575);
    AppMethodBeat.o(203575);
  }
  
  public final void a(int paramInt, asg paramasg)
  {
    boolean bool2 = true;
    AppMethodBeat.i(203571);
    p.h(paramasg, "serverConfig");
    super.a(paramInt, paramasg);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cKA().value()).intValue();
    boolean bool1 = paramasg.GJf;
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
      if ((paramInt == this.dvm) || (!bool1) || (!this.suN)) {
        break label302;
      }
      bool3 = this.suV.EX(this.dvm);
      if (this.suU.suW == null) {
        break label268;
      }
      bool1 = true;
      l = FinderStreamTabPreloadCore.EY(this.dvm);
      if (ch.aDc() - this.suU.hiI < FinderStreamTabPreloadCore.EY(this.dvm)) {
        break label274;
      }
    }
    for (;;)
    {
      ae.i(this.TAG, "[performConfigChange] isAutoRefresh=" + bool3 + " isLoading=" + this.isLoading + " isOverTime=" + bool2 + " expired=" + l + " debugValue=" + i + " hasCache=" + bool1);
      if ((!bool3) || (this.isLoading) || (!bool2)) {
        break label280;
      }
      this.suO.aiE("performServerConfigChanged");
      this.suO.a((a.a)new a(this), 0L, "performConfigChange");
      AppMethodBeat.o(203571);
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
    ae.i(this.TAG, "[performConfigChange] not need to preload. debugValue=".concat(String.valueOf(i)));
    AppMethodBeat.o(203571);
    return;
    label302:
    ae.i(this.TAG, "[performConfigChange] not need to check hot preload. debugValue=" + i + " fromTabType=" + paramInt);
    AppMethodBeat.o(203571);
  }
  
  public final void a(f.c paramc, d.g.a.b<? super f.d, z> paramb)
  {
    AppMethodBeat.i(203573);
    p.h(paramc, "source");
    p.h(paramb, "call");
    if ((FinderStreamTabPreloadCore.isEnable()) && (f.a(this, paramc)))
    {
      Object localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = p.i(((e)localObject).ajA().get(am.a.Jbo, Integer.valueOf(0)), Integer.valueOf(0));
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cKM().value()).intValue();
      if ((i > 0) && (bool) && (SystemClock.uptimeMillis() % i != 0L))
      {
        ae.i(this.TAG, "[isValid] isFirst but not hit, random=".concat(String.valueOf(i)));
        paramb.invoke(f.d.svk);
        AppMethodBeat.o(203573);
        return;
      }
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).ajA().set(am.a.Jbo, Integer.valueOf(1));
    }
    super.a(paramc, paramb);
    AppMethodBeat.o(203573);
  }
  
  public final boolean a(f.c paramc, m.f paramf)
  {
    AppMethodBeat.i(203572);
    p.h(paramc, "source");
    p.h(paramf, "resp");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    if (((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).tku == 4)
    {
      ae.i(this.TAG, "[isAcceptCgiBack] is In hot tab.");
      AppMethodBeat.o(203572);
      return false;
    }
    int i;
    if (paramc == f.c.svg) {
      if (ch.aDc() - this.suU.hiI >= FinderStreamTabPreloadCore.ag(this.dvm, false)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      ae.i(this.TAG, "[isAcceptCgiBack] is not over time. lastTime=" + this.suU.hiI);
      AppMethodBeat.o(203572);
      return false;
      i = 0;
      continue;
      if (ch.aDc() - this.suU.hiI >= FinderStreamTabPreloadCore.EY(this.dvm)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramc == f.c.svg) && (this.suN))
    {
      ae.i(this.TAG, "[isAcceptCgiBack] is form outside but now is in finder.");
      AppMethodBeat.o(203572);
      return false;
    }
    boolean bool = super.a(paramc, paramf);
    AppMethodBeat.o(203572);
    return bool;
  }
  
  public final boolean a(f.c paramc, String paramString)
  {
    AppMethodBeat.i(203574);
    p.h(paramc, "source");
    p.h(paramString, "log");
    boolean bool1;
    boolean bool3;
    if (this.suV.cEQ().cQO() == 4)
    {
      bool1 = true;
      bool3 = this.suV.EX(this.dvm);
      if (((paramc == f.c.sve) || (paramc == f.c.svg)) && (((!bool1) || (!bool3)) && ((paramc != f.c.svf) || (!this.suN)))) {
        break label153;
      }
    }
    label153:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!super.a(paramc, ", ret=" + bool2 + " targetEnterHot=" + bool1 + " isAutoRefresh=" + bool3)) || (!bool2)) {
        break label159;
      }
      AppMethodBeat.o(203574);
      return true;
      bool1 = false;
      break;
    }
    label159:
    AppMethodBeat.o(203574);
    return false;
  }
  
  public final f.c cES()
  {
    return f.c.svg;
  }
  
  public final long cET()
  {
    AppMethodBeat.i(203569);
    long l = FinderStreamTabPreloadCore.ag(this.dvm, false);
    AppMethodBeat.o(203569);
    return l;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203570);
    super.fI(paramInt1, paramInt2);
    if (paramInt2 != this.dvm)
    {
      this.suO.aiE("performChangeEnterTargetTab");
      AppMethodBeat.o(203570);
      return;
    }
    this.suO.a(this.suS, cET(), "performChangeEnterTargetTab");
    AppMethodBeat.o(203570);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker$performServerConfigChanged$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class a
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(203568);
      this.suK.a(f.c.svf, (d.g.a.b)d.a.a.suL);
      AppMethodBeat.o(203568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.d
 * JD-Core Version:    0.7.0.1
 */