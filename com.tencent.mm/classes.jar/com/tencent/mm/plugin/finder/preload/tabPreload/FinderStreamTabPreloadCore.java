package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "homeTabStateVM$delegate", "Lkotlin/Lazy;", "lastTargetEnterTabType", "", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1;", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getServerConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "supportTabPreload", "", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "getAlivePreloadWorker", "getInnerTime", "", "tabType", "isRedDot", "", "getOuterTime", "getServer", "getTargetEnterTabType", "isAutoRefresh", "isEnable", "onAppBackground", "", "activity", "", "onAppForeground", "onChanged", "result", "onEnterFinder", "onExitFinder", "onRedDotRevoke", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "performConfigChange", "setup", "Companion", "plugin-finder_release"})
public final class FinderStreamTabPreloadCore
  extends UIComponentPlugin<PluginFinder>
  implements Observer<g.a>, o
{
  public static final FinderStreamTabPreloadCore.a suE;
  public final List<f> suA;
  private final d.f suB;
  public final c suC;
  private int suD;
  
  static
  {
    AppMethodBeat.i(203559);
    suE = new FinderStreamTabPreloadCore.a((byte)0);
    AppMethodBeat.o(203559);
  }
  
  public FinderStreamTabPreloadCore()
  {
    AppMethodBeat.i(203558);
    this.suA = j.listOf(new f[] { (f)new d(this), (f)new b(this), (f)new c(this), (f)new e(this) });
    this.suB = d.g.O((d.g.a.a)b.suF);
    this.suC = new c(this);
    this.suD = -1;
    AppMethodBeat.o(203558);
  }
  
  public static long EY(int paramInt)
  {
    AppMethodBeat.i(203557);
    long l;
    switch (paramInt)
    {
    default: 
      l = 9223372036854775807L;
    }
    for (;;)
    {
      ae.i("Finder.StreamTabPreloadCore", "[getInnerTime] tabType=" + paramInt + " withRedDot=false time=" + l + 's');
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(203557);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cKw().value()).intValue() >= 0)
      {
        localb = com.tencent.mm.plugin.finder.storage.b.sHP;
        l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKw().value()).intValue();
      }
      else
      {
        l = cER().GJb * 1000L;
        continue;
        localb = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cKx().value()).intValue() >= 0)
        {
          localb = com.tencent.mm.plugin.finder.storage.b.sHP;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKx().value()).intValue();
        }
        else
        {
          l = cER().GJc * 1000L;
          continue;
          localb = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cKy().value()).intValue() >= 0)
          {
            localb = com.tencent.mm.plugin.finder.storage.b.sHP;
            l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKy().value()).intValue();
          }
          else
          {
            l = cER().GJd * 1000L;
            continue;
            localb = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cKz().value()).intValue() >= 0)
            {
              localb = com.tencent.mm.plugin.finder.storage.b.sHP;
              l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKz().value()).intValue();
            }
            else
            {
              l = cER().GJe * 1000L;
            }
          }
        }
      }
    }
    AppMethodBeat.o(203557);
    return l;
  }
  
  public static long ag(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203556);
    long l;
    switch (paramInt)
    {
    default: 
      l = 9223372036854775807L;
    }
    for (;;)
    {
      ae.i("Finder.StreamTabPreloadCore", "[getOuterTime] tabType=" + paramInt + " withRedDot=" + paramBoolean + " time=" + l + "s ");
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(203556);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.b localb;
      if (!paramBoolean)
      {
        localb = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cKo().value()).intValue() >= 0)
        {
          localb = com.tencent.mm.plugin.finder.storage.b.sHP;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKo().value()).intValue();
        }
        else
        {
          l = cER().GIT * 1000L;
        }
      }
      else
      {
        localb = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cKk().value()).intValue() >= 0)
        {
          localb = com.tencent.mm.plugin.finder.storage.b.sHP;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKk().value()).intValue();
        }
        else
        {
          l = cER().GIP * 1000L;
          continue;
          if (!paramBoolean)
          {
            localb = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cKp().value()).intValue() >= 0)
            {
              localb = com.tencent.mm.plugin.finder.storage.b.sHP;
              l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKp().value()).intValue();
            }
            else
            {
              l = cER().GIU * 1000L;
            }
          }
          else
          {
            localb = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cKl().value()).intValue() >= 0)
            {
              localb = com.tencent.mm.plugin.finder.storage.b.sHP;
              l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKl().value()).intValue();
            }
            else
            {
              l = cER().GIQ * 1000L;
              continue;
              if (!paramBoolean)
              {
                localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                if (((Number)com.tencent.mm.plugin.finder.storage.b.cKq().value()).intValue() >= 0)
                {
                  localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKq().value()).intValue();
                }
                else
                {
                  l = cER().GIV * 1000L;
                }
              }
              else
              {
                localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                if (((Number)com.tencent.mm.plugin.finder.storage.b.cKm().value()).intValue() >= 0)
                {
                  localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKm().value()).intValue();
                }
                else
                {
                  l = cER().GIR * 1000L;
                  continue;
                  if (!paramBoolean)
                  {
                    localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKr().value()).intValue() >= 0)
                    {
                      localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKr().value()).intValue();
                    }
                    else
                    {
                      l = cER().GIW * 1000L;
                    }
                  }
                  else
                  {
                    localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKn().value()).intValue() >= 0)
                    {
                      localb = com.tencent.mm.plugin.finder.storage.b.sHP;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.b.cKn().value()).intValue();
                    }
                    else
                    {
                      l = cER().GIS * 1000L;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(203556);
    return l;
  }
  
  public static asg cER()
  {
    AppMethodBeat.i(203555);
    asg localasg = new asg();
    try
    {
      Object localObject = com.tencent.mm.kernel.g.ajR();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.Jcc, "");
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(203555);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("Finder.StreamTabPreloadCore", (Throwable)localException, "", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(203555);
      return localasg;
      localasg.parseFrom(bu.aSx((String)localException));
    }
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(203554);
    if (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showFinderEntry())
    {
      ae.i("Finder.StreamTabPreloadCore", "finder entry close then return");
      AppMethodBeat.o(203554);
      return false;
    }
    if ((com.tencent.mm.model.v.aAH() & 0x0) != 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.i("Finder.StreamTabPreloadCore", "finder find more ui entry close then return");
      AppMethodBeat.o(203554);
      return false;
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (!com.tencent.mm.plugin.finder.storage.b.cIF())
    {
      ae.i("Finder.StreamTabPreloadCore", "isEnablePreloadStreamRefresh false then return");
      AppMethodBeat.o(203554);
      return false;
    }
    AppMethodBeat.o(203554);
    return true;
  }
  
  public final f EV(int paramInt)
  {
    AppMethodBeat.i(203551);
    Iterator localIterator = ((Iterable)this.suA).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((f)localObject).dvm == paramInt)
      {
        i = 1;
        label51:
        if (i == 0) {
          break label71;
        }
      }
    }
    for (;;)
    {
      localObject = (f)localObject;
      AppMethodBeat.o(203551);
      return localObject;
      i = 0;
      break label51;
      label71:
      break;
      localObject = null;
    }
  }
  
  public final void EW(int paramInt)
  {
    AppMethodBeat.i(203552);
    asg localasg = cER();
    Iterator localIterator = ((Iterable)this.suA).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(paramInt, localasg);
    }
    AppMethodBeat.o(203552);
  }
  
  public final boolean EX(int paramInt)
  {
    AppMethodBeat.i(203553);
    boolean bool = cEQ().EX(paramInt);
    AppMethodBeat.o(203553);
    return bool;
  }
  
  final FinderHomeTabStateVM cEQ()
  {
    AppMethodBeat.i(203547);
    FinderHomeTabStateVM localFinderHomeTabStateVM = (FinderHomeTabStateVM)this.suB.getValue();
    AppMethodBeat.o(203547);
    return localFinderHomeTabStateVM;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(203550);
    paramString = ((Iterable)this.suA).iterator();
    while (paramString.hasNext())
    {
      Object localObject = (f)paramString.next();
      if ((((f)localObject).suP.compareAndSet(false, true)) && (!((f)localObject).suN))
      {
        ae.i(((f)localObject).TAG, "[performBackground]");
        a locala = ((f)localObject).suO;
        localObject = ((f)localObject).suS;
        p.h(localObject, "runnable");
        locala.suz.set(localObject);
        locala.stt.removeCallbacks((Runnable)localObject);
        long l = System.currentTimeMillis() - ((a.a)localObject).time;
        ((a.a)localObject).gW -= l;
        ae.i(locala.TAG, "[pause] has cost=" + l + "ms delay=" + ((a.a)localObject).gW + "ms hash=" + ((a.a)localObject).hashCode());
      }
    }
    AppMethodBeat.o(203550);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(203549);
    paramString = ((Iterable)this.suA).iterator();
    label214:
    while (paramString.hasNext())
    {
      f localf = (f)paramString.next();
      if (localf.suP.compareAndSet(true, false))
      {
        ae.i(localf.TAG, "[performForeground]");
        a locala = localf.suO;
        a.a locala1 = (a.a)locala.suz.getAndSet(null);
        if (locala1 != null)
        {
          locala.stt.removeCallbacks((Runnable)locala1);
          locala.a(locala1, locala1.gW, "resume");
          ae.i(locala.TAG, "[resume] delay=" + locala1.gW + "ms hash=" + locala1.hashCode());
        }
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (!localf.suQ.get()) || (localf.suN)) {
            break label214;
          }
          localf.suO.a(localf.suS, localf.cET(), "performForeground");
          break;
          ae.i(locala.TAG, "[resume] failure. runnable is null");
        }
      }
    }
    AppMethodBeat.o(203549);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<FinderHomeTabStateVM>
  {
    public static final b suF;
    
    static
    {
      AppMethodBeat.i(203545);
      suF = new b();
      AppMethodBeat.o(203545);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<ke>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore
 * JD-Core Version:    0.7.0.1
 */