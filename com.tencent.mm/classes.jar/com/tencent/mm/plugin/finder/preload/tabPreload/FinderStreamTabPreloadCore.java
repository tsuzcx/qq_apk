package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "homeTabStateVM$delegate", "Lkotlin/Lazy;", "lastTargetEnterTabType", "", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1;", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getServerConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "supportTabPreload", "", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "clearPreloadCache", "", "T", "clazz", "Ljava/lang/Class;", "enterFinderLoad", "intent", "Landroid/content/Intent;", "getAlivePreloadWorker", "getInnerTime", "", "tabType", "isRedDot", "", "getOuterTime", "getServer", "getTargetEnterTabType", "isAutoRefresh", "isEnable", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "onAppBackground", "activity", "", "onAppForeground", "onChanged", "result", "onEnterFinder", "onExitFinder", "onRedDotRevoke", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "performConfigChange", "setup", "Companion", "plugin-finder_release"})
public final class FinderStreamTabPreloadCore
  extends UIComponentPlugin<PluginFinder>
  implements Observer<h.a>, o
{
  public static final a uUR;
  public final List<f> uUN;
  private final kotlin.f uUO;
  public final c uUP;
  private int uUQ;
  
  static
  {
    AppMethodBeat.i(249571);
    uUR = new a((byte)0);
    AppMethodBeat.o(249571);
  }
  
  public FinderStreamTabPreloadCore()
  {
    AppMethodBeat.i(249570);
    this.uUN = j.listOf(new f[] { (f)new d(this), (f)new b(this), (f)new c(this), (f)new e(this) });
    this.uUO = kotlin.g.ah((kotlin.g.a.a)b.uUS);
    this.uUP = new c(this);
    this.uUQ = -1;
    AppMethodBeat.o(249570);
  }
  
  public static long JO(int paramInt)
  {
    AppMethodBeat.i(249569);
    long l;
    switch (paramInt)
    {
    default: 
      l = 9223372036854775807L;
    }
    for (;;)
    {
      Log.i("Finder.StreamTabPreloadCore", "[getInnerTime] tabType=" + paramInt + " withRedDot=false time=" + l + 's');
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(249569);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.duq().value()).intValue() >= 0)
      {
        localc = com.tencent.mm.plugin.finder.storage.c.vCb;
        l = ((Number)com.tencent.mm.plugin.finder.storage.c.duq().value()).intValue();
      }
      else
      {
        l = dlI().LMr * 1000L;
        continue;
        localc = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dur().value()).intValue() >= 0)
        {
          localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          l = ((Number)com.tencent.mm.plugin.finder.storage.c.dur().value()).intValue();
        }
        else
        {
          l = dlI().LMs * 1000L;
          continue;
          localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (((Number)com.tencent.mm.plugin.finder.storage.c.dus().value()).intValue() >= 0)
          {
            localc = com.tencent.mm.plugin.finder.storage.c.vCb;
            l = ((Number)com.tencent.mm.plugin.finder.storage.c.dus().value()).intValue();
          }
          else
          {
            l = dlI().LMt * 1000L;
            continue;
            localc = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (((Number)com.tencent.mm.plugin.finder.storage.c.dut().value()).intValue() >= 0)
            {
              localc = com.tencent.mm.plugin.finder.storage.c.vCb;
              l = ((Number)com.tencent.mm.plugin.finder.storage.c.dut().value()).intValue();
            }
            else
            {
              l = dlI().LMu * 1000L;
            }
          }
        }
      }
    }
    AppMethodBeat.o(249569);
    return l;
  }
  
  public static boolean a(f.c paramc)
  {
    AppMethodBeat.i(249566);
    p.h(paramc, "source");
    if (!((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).showFinderEntry())
    {
      Log.i("Finder.StreamTabPreloadCore", "finder entry close then return");
      AppMethodBeat.o(249566);
      return false;
    }
    if (paramc == f.c.uVt)
    {
      paramc = com.tencent.mm.plugin.finder.storage.c.vCb;
      boolean bool = com.tencent.mm.plugin.finder.storage.c.dwY();
      AppMethodBeat.o(249566);
      return bool;
    }
    if ((z.aUd() & 0x0) != 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.StreamTabPreloadCore", "finder find more ui entry close then return");
      AppMethodBeat.o(249566);
      return false;
    }
    paramc = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (!com.tencent.mm.plugin.finder.storage.c.dsl())
    {
      Log.i("Finder.StreamTabPreloadCore", "isEnablePreloadStreamRefresh false then return");
      AppMethodBeat.o(249566);
      return false;
    }
    AppMethodBeat.o(249566);
    return true;
  }
  
  public static long al(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(249568);
    long l;
    switch (paramInt)
    {
    default: 
      l = 9223372036854775807L;
    }
    for (;;)
    {
      Log.i("Finder.StreamTabPreloadCore", "[getOuterTime] tabType=" + paramInt + " withRedDot=" + paramBoolean + " time=" + l + "s ");
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(249568);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.c localc;
      if (!paramBoolean)
      {
        localc = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dui().value()).intValue() >= 0)
        {
          localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          l = ((Number)com.tencent.mm.plugin.finder.storage.c.dui().value()).intValue();
        }
        else
        {
          l = dlI().LMj * 1000L;
        }
      }
      else
      {
        localc = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.due().value()).intValue() >= 0)
        {
          localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          l = ((Number)com.tencent.mm.plugin.finder.storage.c.due().value()).intValue();
        }
        else
        {
          l = dlI().LMf * 1000L;
          continue;
          if (!paramBoolean)
          {
            localc = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (((Number)com.tencent.mm.plugin.finder.storage.c.duj().value()).intValue() >= 0)
            {
              localc = com.tencent.mm.plugin.finder.storage.c.vCb;
              l = ((Number)com.tencent.mm.plugin.finder.storage.c.duj().value()).intValue();
            }
            else
            {
              l = dlI().LMk * 1000L;
            }
          }
          else
          {
            localc = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (((Number)com.tencent.mm.plugin.finder.storage.c.duf().value()).intValue() >= 0)
            {
              localc = com.tencent.mm.plugin.finder.storage.c.vCb;
              l = ((Number)com.tencent.mm.plugin.finder.storage.c.duf().value()).intValue();
            }
            else
            {
              l = dlI().LMg * 1000L;
              continue;
              if (!paramBoolean)
              {
                localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (((Number)com.tencent.mm.plugin.finder.storage.c.duk().value()).intValue() >= 0)
                {
                  localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.c.duk().value()).intValue();
                }
                else
                {
                  l = dlI().LMl * 1000L;
                }
              }
              else
              {
                localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (((Number)com.tencent.mm.plugin.finder.storage.c.dug().value()).intValue() >= 0)
                {
                  localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.c.dug().value()).intValue();
                }
                else
                {
                  l = dlI().LMh * 1000L;
                  continue;
                  if (!paramBoolean)
                  {
                    localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (((Number)com.tencent.mm.plugin.finder.storage.c.dul().value()).intValue() >= 0)
                    {
                      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.c.dul().value()).intValue();
                    }
                    else
                    {
                      l = dlI().LMm * 1000L;
                    }
                  }
                  else
                  {
                    localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (((Number)com.tencent.mm.plugin.finder.storage.c.duh().value()).intValue() >= 0)
                    {
                      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.c.duh().value()).intValue();
                    }
                    else
                    {
                      l = dlI().LMi * 1000L;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(249568);
    return l;
  }
  
  public static bcy dlI()
  {
    AppMethodBeat.i(249567);
    bcy localbcy = new bcy();
    try
    {
      Object localObject = com.tencent.mm.kernel.g.aAh();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.Old, "");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(249567);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Finder.StreamTabPreloadCore", (Throwable)localException, "", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(249567);
      return localbcy;
      localbcy.parseFrom(Util.decodeHexString((String)localException));
    }
  }
  
  public final f JL(int paramInt)
  {
    AppMethodBeat.i(249562);
    Iterator localIterator = ((Iterable)this.uUN).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((f)localObject).dLS == paramInt)
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
      AppMethodBeat.o(249562);
      return localObject;
      i = 0;
      break label51;
      label71:
      break;
      localObject = null;
    }
  }
  
  public final void JM(int paramInt)
  {
    AppMethodBeat.i(249563);
    bcy localbcy = dlI();
    Iterator localIterator = ((Iterable)this.uUN).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(paramInt, localbcy);
    }
    AppMethodBeat.o(249563);
  }
  
  public final boolean JN(int paramInt)
  {
    AppMethodBeat.i(249564);
    boolean bool = dlH().JN(paramInt);
    AppMethodBeat.o(249564);
    return bool;
  }
  
  public final <T extends f> void aM(Class<T> paramClass)
  {
    AppMethodBeat.i(249557);
    p.h(paramClass, "clazz");
    Iterator localIterator = ((Iterable)this.uUN).iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (p.j(localf.getClass(), paramClass)) {
        localf.nM(true);
      }
    }
    AppMethodBeat.o(249557);
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(249565);
    p.h(paramk, "ctrInfo");
    int i;
    switch (paramk.field_ctrInfo.type)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramk = JL(i);
      if (paramk != null) {
        paramk.nM(true);
      }
      Log.i("Finder.StreamTabPreloadCore", "[onRedDotRevoke] tabType=".concat(String.valueOf(i)));
      AppMethodBeat.o(249565);
      return;
      i = 3;
      continue;
      i = 1;
      continue;
      i = 4;
      continue;
      i = 2;
    }
  }
  
  public final FinderHomeTabStateVM dlH()
  {
    AppMethodBeat.i(249558);
    FinderHomeTabStateVM localFinderHomeTabStateVM = (FinderHomeTabStateVM)this.uUO.getValue();
    AppMethodBeat.o(249558);
    return localFinderHomeTabStateVM;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(249561);
    paramString = ((Iterable)this.uUN).iterator();
    while (paramString.hasNext())
    {
      Object localObject = (f)paramString.next();
      if ((((f)localObject).uVc.compareAndSet(false, true)) && (!((f)localObject).uVa))
      {
        Log.i(((f)localObject).TAG, "[performBackground]");
        a locala = ((f)localObject).uVb;
        localObject = ((f)localObject).uVf;
        p.h(localObject, "runnable");
        locala.uUM.set(localObject);
        locala.uOI.removeCallbacks((Runnable)localObject);
        long l = System.currentTimeMillis() - ((a.a)localObject).time;
        ((a.a)localObject).gY -= l;
        Log.i(locala.TAG, "[pause] has cost=" + l + "ms delay=" + ((a.a)localObject).gY + "ms hash=" + ((a.a)localObject).hashCode());
      }
    }
    AppMethodBeat.o(249561);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(249560);
    paramString = ((Iterable)this.uUN).iterator();
    label214:
    while (paramString.hasNext())
    {
      f localf = (f)paramString.next();
      if (localf.uVc.compareAndSet(true, false))
      {
        Log.i(localf.TAG, "[performForeground]");
        a locala = localf.uVb;
        a.a locala1 = (a.a)locala.uUM.getAndSet(null);
        if (locala1 != null)
        {
          locala.uOI.removeCallbacks((Runnable)locala1);
          locala.a(locala1, locala1.gY, "resume");
          Log.i(locala.TAG, "[resume] delay=" + locala1.gY + "ms hash=" + locala1.hashCode());
        }
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (!localf.uVd.get()) || (localf.uVa)) {
            break label214;
          }
          localf.uVb.a(localf.uVf, localf.dlK(), "performForeground");
          break;
          Log.i(locala.TAG, "[resume] failure. runnable is null");
        }
      }
    }
    AppMethodBeat.o(249560);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<FinderHomeTabStateVM>
  {
    public static final b uUS;
    
    static
    {
      AppMethodBeat.i(249555);
      uUS = new b();
      AppMethodBeat.o(249555);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<kt>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore
 * JD-Core Version:    0.7.0.1
 */