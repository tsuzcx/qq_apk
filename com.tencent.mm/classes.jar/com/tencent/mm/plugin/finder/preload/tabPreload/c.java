package com.tencent.mm.plugin.finder.preload.tabPreload;

import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.lk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "homeTabStateVM$delegate", "Lkotlin/Lazy;", "lastTargetEnterTabType", "", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1;", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getServerConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "supportTabPreload", "", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "clearPreloadCache", "", "T", "clazz", "Ljava/lang/Class;", "enterFinderLoad", "intent", "Landroid/content/Intent;", "getAlivePreloadWorker", "getInnerTime", "", "tabType", "isRedDot", "", "getOuterTime", "getServer", "getTargetEnterTabType", "isAutoRefresh", "isEnable", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "isNewMode", "onAppBackground", "activity", "", "onAppForeground", "onChanged", "result", "onEnterFinder", "onExitFinder", "onRedDotRevoke", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "performConfigChange", "setup", "Companion", "plugin-finder_release"})
public final class c
  extends i<PluginFinder>
  implements s<h.a>, o
{
  public static final a zLj;
  public final List<g> zLf;
  private final kotlin.f zLg;
  public final c zLh;
  private int zLi;
  
  static
  {
    AppMethodBeat.i(288544);
    zLj = new a((byte)0);
    AppMethodBeat.o(288544);
  }
  
  public c()
  {
    AppMethodBeat.i(288543);
    this.zLf = j.listOf(new g[] { (g)new f(this), (g)new d(this), (g)new e(this) });
    this.zLg = kotlin.g.ar((kotlin.g.a.a)b.zLk);
    this.zLh = new c(this);
    this.zLi = -1;
    AppMethodBeat.o(288543);
  }
  
  public static long OP(int paramInt)
  {
    AppMethodBeat.i(288542);
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
      AppMethodBeat.o(288542);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dVx().aSr()).intValue() >= 0)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.AjH;
        l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVx().aSr()).intValue();
      }
      else
      {
        l = dMJ().SUn * 1000L;
        continue;
        locald = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dVy().aSr()).intValue() >= 0)
        {
          locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVy().aSr()).intValue();
        }
        else
        {
          l = dMJ().SUo * 1000L;
          continue;
          locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dVz().aSr()).intValue() >= 0)
          {
            locald = com.tencent.mm.plugin.finder.storage.d.AjH;
            l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVz().aSr()).intValue();
          }
          else
          {
            l = dMJ().SUp * 1000L;
            continue;
            locald = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dVA().aSr()).intValue() >= 0)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.AjH;
              l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVA().aSr()).intValue();
            }
            else
            {
              l = dMJ().SUq * 1000L;
            }
          }
        }
      }
    }
    AppMethodBeat.o(288542);
    return l;
  }
  
  public static boolean a(g.c paramc)
  {
    AppMethodBeat.i(288538);
    p.k(paramc, "source");
    if (!((PluginFinder)h.ag(PluginFinder.class)).showFinderEntry())
    {
      Log.i("Finder.StreamTabPreloadCore", "finder entry close then return");
      AppMethodBeat.o(288538);
      return false;
    }
    if (paramc == g.c.zLL)
    {
      paramc = com.tencent.mm.plugin.finder.storage.d.AjH;
      boolean bool = com.tencent.mm.plugin.finder.storage.d.dXc();
      AppMethodBeat.o(288538);
      return bool;
    }
    if ((z.bde() & 0x0) != 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.StreamTabPreloadCore", "finder find more ui entry close then return");
      AppMethodBeat.o(288538);
      return false;
    }
    paramc = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (!com.tencent.mm.plugin.finder.storage.d.dTA())
    {
      Log.i("Finder.StreamTabPreloadCore", "isEnablePreloadStreamRefresh false then return");
      AppMethodBeat.o(288538);
      return false;
    }
    AppMethodBeat.o(288538);
    return true;
  }
  
  public static long an(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(288541);
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
      AppMethodBeat.o(288541);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.d locald;
      if (!paramBoolean)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dVp().aSr()).intValue() >= 0)
        {
          locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVp().aSr()).intValue();
        }
        else
        {
          l = dMJ().SUf * 1000L;
        }
      }
      else
      {
        locald = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dVl().aSr()).intValue() >= 0)
        {
          locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVl().aSr()).intValue();
        }
        else
        {
          l = dMJ().SUb * 1000L;
          continue;
          if (!paramBoolean)
          {
            locald = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dVq().aSr()).intValue() >= 0)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.AjH;
              l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVq().aSr()).intValue();
            }
            else
            {
              l = dMJ().SUg * 1000L;
            }
          }
          else
          {
            locald = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dVm().aSr()).intValue() >= 0)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.AjH;
              l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVm().aSr()).intValue();
            }
            else
            {
              l = dMJ().SUc * 1000L;
              continue;
              if (!paramBoolean)
              {
                locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.dVr().aSr()).intValue() >= 0)
                {
                  locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVr().aSr()).intValue();
                }
                else
                {
                  l = dMJ().SUh * 1000L;
                }
              }
              else
              {
                locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.dVn().aSr()).intValue() >= 0)
                {
                  locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                  l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVn().aSr()).intValue();
                }
                else
                {
                  l = dMJ().SUd * 1000L;
                  continue;
                  if (!paramBoolean)
                  {
                    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                    if (((Number)com.tencent.mm.plugin.finder.storage.d.dVs().aSr()).intValue() >= 0)
                    {
                      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVs().aSr()).intValue();
                    }
                    else
                    {
                      l = dMJ().SUi * 1000L;
                    }
                  }
                  else
                  {
                    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                    if (((Number)com.tencent.mm.plugin.finder.storage.d.dVo().aSr()).intValue() >= 0)
                    {
                      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
                      l = ((Number)com.tencent.mm.plugin.finder.storage.d.dVo().aSr()).intValue();
                    }
                    else
                    {
                      l = dMJ().SUe * 1000L;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(288541);
    return l;
  }
  
  public static bju dMJ()
  {
    AppMethodBeat.i(288539);
    bju localbju = new bju();
    try
    {
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VzY, "");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(288539);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Finder.StreamTabPreloadCore", (Throwable)localException, "", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(288539);
      return localbju;
      localbju.parseFrom(Util.decodeHexString((String)localException));
    }
  }
  
  public static boolean dMK()
  {
    AppMethodBeat.i(288540);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dVC().aSr()).intValue() >= 0)
    {
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dVC().aSr()).intValue() == 1)
      {
        AppMethodBeat.o(288540);
        return true;
      }
      AppMethodBeat.o(288540);
      return false;
    }
    if (dMJ().SUu == 1)
    {
      AppMethodBeat.o(288540);
      return true;
    }
    AppMethodBeat.o(288540);
    return false;
  }
  
  public final g OM(int paramInt)
  {
    AppMethodBeat.i(288534);
    Iterator localIterator = ((Iterable)this.zLf).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((g)localObject).fEH == paramInt)
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
      localObject = (g)localObject;
      AppMethodBeat.o(288534);
      return localObject;
      i = 0;
      break label51;
      label71:
      break;
      localObject = null;
    }
  }
  
  public final void ON(int paramInt)
  {
    AppMethodBeat.i(288535);
    bju localbju = dMJ();
    Iterator localIterator = ((Iterable)this.zLf).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt, localbju);
    }
    AppMethodBeat.o(288535);
  }
  
  public final boolean OO(int paramInt)
  {
    AppMethodBeat.i(288536);
    boolean bool = dMI().OO(paramInt);
    AppMethodBeat.o(288536);
    return bool;
  }
  
  public final <T extends g> void aJ(Class<T> paramClass)
  {
    AppMethodBeat.i(288529);
    p.k(paramClass, "clazz");
    Iterator localIterator = ((Iterable)this.zLf).iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (p.h(localg.getClass(), paramClass)) {
        localg.pV(true);
      }
    }
    AppMethodBeat.o(288529);
  }
  
  public final void c(com.tencent.mm.plugin.finder.extension.reddot.l paraml)
  {
    AppMethodBeat.i(288537);
    p.k(paraml, "ctrInfo");
    int i;
    switch (paraml.field_ctrInfo.type)
    {
    default: 
      i = 0;
      paraml = OM(i);
      if (paraml == null) {
        break;
      }
    }
    for (boolean bool = paraml.pV(true);; bool = false)
    {
      Log.i("Finder.StreamTabPreloadCore", "[onRedDotRevoke] tabType=".concat(String.valueOf(i)));
      if (bool)
      {
        paraml = b.zLe;
        b.c(0, 3, 3, false, 115);
      }
      AppMethodBeat.o(288537);
      return;
      i = 3;
      break;
      i = 1;
      break;
      i = 1;
      break;
      i = 4;
      break;
      i = 2;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.finder.viewmodel.b dMI()
  {
    AppMethodBeat.i(288530);
    com.tencent.mm.plugin.finder.viewmodel.b localb = (com.tencent.mm.plugin.finder.viewmodel.b)this.zLg.getValue();
    AppMethodBeat.o(288530);
    return localb;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(288533);
    paramString = ((Iterable)this.zLf).iterator();
    while (paramString.hasNext())
    {
      Object localObject = (g)paramString.next();
      if ((((g)localObject).zLu.compareAndSet(false, true)) && (((g)localObject).zLv.get()) && (!((g)localObject).zLs))
      {
        Log.i(((g)localObject).TAG, "[performBackground] in FindMoreFriendTab ");
        a locala = ((g)localObject).zLt;
        localObject = ((g)localObject).zLx;
        p.k(localObject, "runnable");
        locala.zLd.set(localObject);
        locala.zBc.removeCallbacks((Runnable)localObject);
        long l = cm.bfE() - ((a.a)localObject).time;
        ((a.a)localObject).delay -= l;
        Log.i(locala.TAG, "[pause] has cost=" + l + "ms delay=" + ((a.a)localObject).delay + "ms hash=" + ((a.a)localObject).hashCode());
      }
    }
    AppMethodBeat.o(288533);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(288532);
    paramString = ((Iterable)this.zLf).iterator();
    label214:
    while (paramString.hasNext())
    {
      g localg = (g)paramString.next();
      if ((localg.zLu.compareAndSet(true, false)) && (localg.zLv.get()) && (!localg.zLs))
      {
        Log.i(localg.TAG, "[performForeground] in FindMoreFriendTab");
        a locala = localg.zLt;
        a.a locala1 = (a.a)locala.zLd.getAndSet(null);
        if (locala1 != null)
        {
          locala.zBc.removeCallbacks((Runnable)locala1);
          locala.a(locala1, locala1.delay, "resume");
          Log.i(locala.TAG, "[resume] delay=" + locala1.delay + "ms hash=" + locala1.hashCode());
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label214;
          }
          localg.zLt.a(localg.zLx, localg.dMN(), "performForeground");
          break;
          Log.i(locala.TAG, "[resume] failure. runnable is null");
        }
      }
    }
    AppMethodBeat.o(288532);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.b>
  {
    public static final b zLk;
    
    static
    {
      AppMethodBeat.i(263515);
      zLk = new b();
      AppMethodBeat.o(263515);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<lk>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.c
 * JD-Core Version:    0.7.0.1
 */