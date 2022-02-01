package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "homeTabStateVM$delegate", "Lkotlin/Lazy;", "lastTargetEnterTabType", "", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1;", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getServerConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "supportTabPreload", "", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "getInnerTime", "", "tabType", "isRedDot", "", "getOuterTime", "getServer", "getTargetEnterTabType", "isAutoRefresh", "isEnable", "onAppBackground", "", "activity", "", "onAppForeground", "onChanged", "result", "onEnterFinder", "onExitFinder", "onRedDotRevoke", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "performConfigChange", "setup", "Companion", "plugin-finder_release"})
public final class FinderStreamTabPreloadCore
  extends UIComponentPlugin<PluginFinder>
  implements Observer<g.a>, n
{
  public static final a INm;
  public final List<f> INi;
  private final d.f INj;
  public final c INk;
  private int INl;
  
  static
  {
    AppMethodBeat.i(221494);
    INm = new a((byte)0);
    AppMethodBeat.o(221494);
  }
  
  public FinderStreamTabPreloadCore()
  {
    AppMethodBeat.i(221493);
    this.INi = j.listOf(new f[] { (f)new d(this), (f)new b(this), (f)new c(this), (f)new e(this) });
    this.INj = d.g.O((d.g.a.a)b.INn);
    this.INk = new c(this);
    this.INl = -1;
    AppMethodBeat.o(221493);
  }
  
  public static long Gn(int paramInt)
  {
    AppMethodBeat.i(221492);
    long l;
    switch (paramInt)
    {
    default: 
      l = 9223372036854775807L;
    }
    for (;;)
    {
      ad.i("Finder.StreamTabPreloadCore", "[getInnerTime] tabType=" + paramInt + " withRedDot=false time=" + l + 's');
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(221492);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.dRe().value()).intValue() >= 0)
      {
        localb = com.tencent.mm.plugin.finder.storage.b.sxa;
        l = ((Number)com.tencent.mm.plugin.finder.storage.b.dRe().value()).intValue();
      }
      else
      {
        l = bEf().GpH * 1000L;
        continue;
        localb = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.dSc().value()).intValue() >= 0)
        {
          localb = com.tencent.mm.plugin.finder.storage.b.sxa;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.dSc().value()).intValue();
        }
        else
        {
          l = bEf().GpI * 1000L;
          continue;
          localb = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.dSf().value()).intValue() >= 0)
          {
            localb = com.tencent.mm.plugin.finder.storage.b.sxa;
            l = ((Number)com.tencent.mm.plugin.finder.storage.b.dSf().value()).intValue();
          }
          else
          {
            l = bEf().GpJ * 1000L;
            continue;
            localb = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.dSg().value()).intValue() >= 0)
            {
              localb = com.tencent.mm.plugin.finder.storage.b.sxa;
              l = ((Number)com.tencent.mm.plugin.finder.storage.b.dSg().value()).intValue();
            }
            else
            {
              l = bEf().GpK * 1000L;
            }
          }
        }
      }
    }
    AppMethodBeat.o(221492);
    return l;
  }
  
  public static arr bEf()
  {
    AppMethodBeat.i(221490);
    arr localarr = new arr();
    try
    {
      Object localObject = com.tencent.mm.kernel.g.ajC();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IHz, "");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(221490);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("Finder.StreamTabPreloadCore", (Throwable)localException, "", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(221490);
      return localarr;
      localarr.parseFrom(bt.aRa((String)localException));
    }
  }
  
  public static long bu(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221491);
    long l;
    switch (paramInt)
    {
    default: 
      l = 9223372036854775807L;
    }
    for (;;)
    {
      ad.i("Finder.StreamTabPreloadCore", "[getOuterTime] tabType=" + paramInt + " withRedDot=" + paramBoolean + " time=" + l + "s ");
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(221491);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.b localb;
      if (!paramBoolean)
      {
        localb = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cOh().value()).intValue() >= 0)
        {
          localb = com.tencent.mm.plugin.finder.storage.b.sxa;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.cOh().value()).intValue();
        }
        else
        {
          l = bEf().Gpz * 1000L;
        }
      }
      else
      {
        localb = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cHT().value()).intValue() >= 0)
        {
          localb = com.tencent.mm.plugin.finder.storage.b.sxa;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.cHT().value()).intValue();
        }
        else
        {
          l = bEf().Gpv * 1000L;
          continue;
          if (!paramBoolean)
          {
            localb = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cOi().value()).intValue() >= 0)
            {
              localb = com.tencent.mm.plugin.finder.storage.b.sxa;
              l = ((Number)com.tencent.mm.plugin.finder.storage.b.cOi().value()).intValue();
            }
            else
            {
              l = bEf().GpA * 1000L;
            }
          }
          else
          {
            localb = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cNk().value()).intValue() >= 0)
            {
              localb = com.tencent.mm.plugin.finder.storage.b.sxa;
              l = ((Number)com.tencent.mm.plugin.finder.storage.b.cNk().value()).intValue();
            }
            else
            {
              l = bEf().Gpw * 1000L;
              continue;
              if (!paramBoolean)
              {
                localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                if (((Number)com.tencent.mm.plugin.finder.storage.b.cOj().value()).intValue() >= 0)
                {
                  localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.b.cOj().value()).intValue();
                }
                else
                {
                  l = bEf().GpB * 1000L;
                }
              }
              else
              {
                localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                if (((Number)com.tencent.mm.plugin.finder.storage.b.cOe().value()).intValue() >= 0)
                {
                  localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.b.cOe().value()).intValue();
                }
                else
                {
                  l = bEf().Gpx * 1000L;
                  continue;
                  if (!paramBoolean)
                  {
                    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                    if (((Number)com.tencent.mm.plugin.finder.storage.b.cOk().value()).intValue() >= 0)
                    {
                      localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.b.cOk().value()).intValue();
                    }
                    else
                    {
                      l = bEf().GpC * 1000L;
                    }
                  }
                  else
                  {
                    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                    if (((Number)com.tencent.mm.plugin.finder.storage.b.cOg().value()).intValue() >= 0)
                    {
                      localb = com.tencent.mm.plugin.finder.storage.b.sxa;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.b.cOg().value()).intValue();
                    }
                    else
                    {
                      l = bEf().Gpy * 1000L;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(221491);
    return l;
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(221489);
    if (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showFinderEntry())
    {
      ad.i("Finder.StreamTabPreloadCore", "finder entry close then return");
      AppMethodBeat.o(221489);
      return false;
    }
    if ((u.aAr() & 0x0) != 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.i("Finder.StreamTabPreloadCore", "finder find more ui entry close then return");
      AppMethodBeat.o(221489);
      return false;
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (!com.tencent.mm.plugin.finder.storage.b.cGI())
    {
      ad.i("Finder.StreamTabPreloadCore", "isEnablePreloadStreamRefresh false then return");
      AppMethodBeat.o(221489);
      return false;
    }
    AppMethodBeat.o(221489);
    return true;
  }
  
  public final f EQ(int paramInt)
  {
    AppMethodBeat.i(221486);
    Iterator localIterator = ((Iterable)this.INi).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((f)localObject).duh == paramInt)
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
      AppMethodBeat.o(221486);
      return localObject;
      i = 0;
      break label51;
      label71:
      break;
      localObject = null;
    }
  }
  
  public final boolean Gg(int paramInt)
  {
    AppMethodBeat.i(221488);
    boolean bool = bEe().Gg(paramInt);
    AppMethodBeat.o(221488);
    return bool;
  }
  
  public final void Gm(int paramInt)
  {
    AppMethodBeat.i(221487);
    arr localarr = bEf();
    Iterator localIterator = ((Iterable)this.INi).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(paramInt, localarr);
    }
    AppMethodBeat.o(221487);
  }
  
  final FinderHomeTabStateVM bEe()
  {
    AppMethodBeat.i(221482);
    FinderHomeTabStateVM localFinderHomeTabStateVM = (FinderHomeTabStateVM)this.INj.getValue();
    AppMethodBeat.o(221482);
    return localFinderHomeTabStateVM;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(221485);
    paramString = ((Iterable)this.INi).iterator();
    while (paramString.hasNext())
    {
      Object localObject = (f)paramString.next();
      if ((((f)localObject).INt.compareAndSet(false, true)) && (!((f)localObject).INr))
      {
        ad.i(((f)localObject).TAG, "[performBackground]");
        a locala = ((f)localObject).INs;
        localObject = ((f)localObject).INw;
        p.h(localObject, "runnable");
        locala.INh.set(localObject);
        locala.skw.removeCallbacks((Runnable)localObject);
        long l = System.currentTimeMillis() - ((a.a)localObject).time;
        ((a.a)localObject).gW -= l;
        ad.i(locala.TAG, "[pause] has cost=" + l + "ms delay=" + ((a.a)localObject).gW + "ms hash=" + ((a.a)localObject).hashCode());
      }
    }
    AppMethodBeat.o(221485);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(221484);
    paramString = ((Iterable)this.INi).iterator();
    label214:
    while (paramString.hasNext())
    {
      f localf = (f)paramString.next();
      if (localf.INt.compareAndSet(true, false))
      {
        ad.i(localf.TAG, "[performForeground]");
        a locala = localf.INs;
        a.a locala1 = (a.a)locala.INh.getAndSet(null);
        if (locala1 != null)
        {
          locala.skw.removeCallbacks((Runnable)locala1);
          locala.a(locala1, locala1.gW, "resume");
          ad.i(locala.TAG, "[resume] delay=" + locala1.gW + "ms hash=" + locala1.hashCode());
        }
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (!localf.INu.get()) || (localf.INr)) {
            break label214;
          }
          localf.INs.a(localf.INw, localf.bEh(), "performForeground");
          break;
          ad.i(locala.TAG, "[resume] failure. runnable is null");
        }
      }
    }
    AppMethodBeat.o(221484);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<FinderHomeTabStateVM>
  {
    public static final b INn;
    
    static
    {
      AppMethodBeat.i(221480);
      INn = new b();
      AppMethodBeat.o(221480);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<kd>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore
 * JD-Core Version:    0.7.0.1
 */