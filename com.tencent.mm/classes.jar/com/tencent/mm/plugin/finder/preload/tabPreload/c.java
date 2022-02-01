package com.tencent.mm.plugin.finder.preload.tabPreload;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.n;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "homeTabStateVM$delegate", "Lkotlin/Lazy;", "lastTargetEnterTabType", "", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1;", "noClearCacheFlag", "getNoClearCacheFlag", "()I", "setNoClearCacheFlag", "(I)V", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getServerConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "supportTabPreload", "", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "clearAllInsidePreloadCache", "", "clearAllPreloadCache", "clearPreloadCache", "T", "clazz", "Ljava/lang/Class;", "enterFinderLoad", "intent", "Landroid/content/Intent;", "getAlivePreloadWorker", "getCacheValidTime", "", "tabType", "getInnerTime", "isRedDot", "", "getNewRedDotPreloadInterval", "getOutsideIntervalTime", "isRedDotPreload", "hasCache", "getServer", "getTargetEnterTabType", "getTimeOutPreloadInterval", "isAutoRefresh", "isEnable", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "onAppBackground", "activity", "", "onAppForeground", "onChanged", "result", "onFinderBackground", "onFinderForeground", "onRedDotRevoke", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "checkIsInFinder", "performConfigChange", "performInsidePreload", "setup", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends n<PluginFinder>
  implements y<l.a>, q
{
  public static final a EVQ;
  public final List<g> EVR;
  public int EVS;
  private final j EVT;
  private final FinderStreamTabPreloadCore.mainUiIndexChangeListener.1 EVU;
  private int EVV;
  
  static
  {
    AppMethodBeat.i(346305);
    EVQ = new a((byte)0);
    AppMethodBeat.o(346305);
  }
  
  public c()
  {
    AppMethodBeat.i(346188);
    this.EVR = kotlin.a.p.listOf(new g[] { (g)new f(this), (g)new d(this), (g)new e(this) });
    this.EVS = 100;
    this.EVT = k.cm((kotlin.g.a.a)b.EVW);
    this.EVU = new FinderStreamTabPreloadCore.mainUiIndexChangeListener.1(this, com.tencent.mm.app.f.hfK);
    this.EVV = -1;
    AppMethodBeat.o(346188);
  }
  
  public static long Rq(int paramInt)
  {
    AppMethodBeat.i(346246);
    long l;
    switch (paramInt)
    {
    default: 
      l = 0L;
    }
    for (;;)
    {
      Log.i("Finder.StreamTabPreloadCore", "[getCacheValidTime] tabType=" + paramInt + " time=" + l + "ms ");
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(346246);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTZ().bmg()).intValue() >= 0)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTZ().bmg()).intValue();
      }
      else
      {
        l = eHN().aaeH * 1000L;
        continue;
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eUa().bmg()).intValue() >= 0)
        {
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          l = ((Number)com.tencent.mm.plugin.finder.storage.d.eUa().bmg()).intValue();
        }
        else
        {
          l = eHN().aaeI * 1000L;
          continue;
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eUb().bmg()).intValue() >= 0)
          {
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            l = ((Number)com.tencent.mm.plugin.finder.storage.d.eUb().bmg()).intValue();
          }
          else
          {
            l = eHN().aaeJ * 1000L;
            continue;
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eUc().bmg()).intValue() >= 0)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.FAy;
              l = ((Number)com.tencent.mm.plugin.finder.storage.d.eUc().bmg()).intValue();
            }
            else
            {
              l = eHN().aaeK * 1000L;
            }
          }
        }
      }
    }
    AppMethodBeat.o(346246);
    return l;
  }
  
  public static long Rr(int paramInt)
  {
    AppMethodBeat.i(346282);
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
      AppMethodBeat.o(346282);
      return 9223372036854775807L;
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTQ().bmg()).intValue() >= 0)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTQ().bmg()).intValue();
      }
      else
      {
        l = eHN().aaev * 1000L;
        continue;
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eTR().bmg()).intValue() >= 0)
        {
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTR().bmg()).intValue();
        }
        else
        {
          l = eHN().aaew * 1000L;
          continue;
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eTS().bmg()).intValue() >= 0)
          {
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTS().bmg()).intValue();
          }
          else
          {
            l = eHN().aaex * 1000L;
            continue;
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eTT().bmg()).intValue() >= 0)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.FAy;
              l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTT().bmg()).intValue();
            }
            else
            {
              l = eHN().aaey * 1000L;
            }
          }
        }
      }
    }
    AppMethodBeat.o(346282);
    return l;
  }
  
  private static final void a(c paramc, l.a parama)
  {
    AppMethodBeat.i(346293);
    s.u(paramc, "this$0");
    if (!parama.hBY)
    {
      AppMethodBeat.o(346293);
      return;
    }
    parama = parama.ASh;
    if (parama != null) {
      paramc.b(parama, true);
    }
    AppMethodBeat.o(346293);
  }
  
  public static boolean a(g.g paramg)
  {
    AppMethodBeat.i(346219);
    s.u(paramg, "source");
    if (!((PluginFinder)h.az(PluginFinder.class)).showFinderEntry())
    {
      Log.i("Finder.StreamTabPreloadCore", "finder entry close then return");
      AppMethodBeat.o(346219);
      return false;
    }
    if (paramg == g.g.EWE)
    {
      paramg = com.tencent.mm.plugin.finder.storage.d.FAy;
      boolean bool = com.tencent.mm.plugin.finder.storage.d.eVQ();
      AppMethodBeat.o(346219);
      return bool;
    }
    if ((z.bAR() & 0x0) != 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.StreamTabPreloadCore", "finder find more ui entry close then return");
      AppMethodBeat.o(346219);
      return false;
    }
    paramg = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eRP())
    {
      Log.i("Finder.StreamTabPreloadCore", "isEnablePreloadStreamRefresh false then return");
      AppMethodBeat.o(346219);
      return false;
    }
    AppMethodBeat.o(346219);
    return true;
  }
  
  private void b(com.tencent.mm.plugin.finder.extension.reddot.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(346200);
    s.u(paramp, "ctrInfo");
    int i;
    switch (paramp.field_ctrInfo.type)
    {
    default: 
      i = 0;
      paramp = Rn(i);
      if (paramp == null) {
        paramBoolean = false;
      }
      break;
    }
    for (;;)
    {
      Log.i("Finder.StreamTabPreloadCore", s.X("[onRedDotRevoke] tabType=", Integer.valueOf(i)));
      if (paramBoolean)
      {
        paramp = b.EVP;
        b.c(0, 3, 3, false, 115);
      }
      AppMethodBeat.o(346200);
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
      int j;
      if ((!paramBoolean) || (paramp.EWd))
      {
        j = 1;
        label164:
        if (j == 0) {
          break label184;
        }
      }
      for (;;)
      {
        if (paramp != null) {
          break label189;
        }
        paramBoolean = false;
        break;
        j = 0;
        break label164;
        label184:
        paramp = null;
      }
      label189:
      paramBoolean = paramp.ta(true);
    }
  }
  
  public static bwf eHN()
  {
    AppMethodBeat.i(346230);
    bwf localbwf = new bwf();
    try
    {
      Object localObject = h.baE().ban().get(at.a.adcn, "");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(346230);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Finder.StreamTabPreloadCore", (Throwable)localException, "", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(346230);
      return localbwf;
      localbwf.parseFrom(Util.decodeHexString((String)localException));
    }
  }
  
  public static long i(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(346271);
    long l1;
    long l2;
    com.tencent.mm.plugin.finder.storage.d locald;
    if (paramBoolean1)
    {
      switch (paramInt)
      {
      default: 
        l1 = 0L;
      }
      for (;;)
      {
        Log.i("Finder.StreamTabPreloadCore", "[getNewRedDotPreloadInterval] tabType=" + paramInt + " time=" + l1 + "ms ");
        l2 = l1;
        if (l1 <= 0L) {
          l2 = 9223372036854775807L;
        }
        Log.i("Finder.StreamTabPreloadCore", "[getOutsideIntervalTime] tabType=" + paramInt + " isRedDotPreload=" + paramBoolean1 + " hasCache = " + paramBoolean2 + ", time=" + l2 + "ms ");
        if (l2 > 0L) {
          break;
        }
        AppMethodBeat.o(346271);
        return 9223372036854775807L;
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eTV().bmg()).intValue() >= 0)
        {
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTV().bmg()).intValue();
        }
        else
        {
          l1 = eHN().aaeD * 1000L;
          continue;
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eTW().bmg()).intValue() >= 0)
          {
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTW().bmg()).intValue();
          }
          else
          {
            l1 = eHN().aaeE * 1000L;
            continue;
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eTX().bmg()).intValue() >= 0)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.FAy;
              l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTX().bmg()).intValue();
            }
            else
            {
              l1 = eHN().aaeF * 1000L;
              continue;
              locald = com.tencent.mm.plugin.finder.storage.d.FAy;
              if (((Number)com.tencent.mm.plugin.finder.storage.d.eTY().bmg()).intValue() >= 0)
              {
                locald = com.tencent.mm.plugin.finder.storage.d.FAy;
                l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTY().bmg()).intValue();
              }
              else
              {
                l1 = eHN().aaeG * 1000L;
              }
            }
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      l1 = 0L;
    }
    for (;;)
    {
      long l3 = l1;
      if (l1 == 0L)
      {
        l3 = l1;
        if (paramBoolean2) {
          l3 = Rq(paramInt);
        }
      }
      Log.i("Finder.StreamTabPreloadCore", "[getTimeOutPreloadInterval] tabType=" + paramInt + " originInterval=" + l3 + "ms ");
      l2 = l3;
      if (l3 > 0L) {
        break;
      }
      l2 = 9223372036854775807L;
      break;
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTI().bmg()).intValue() >= 0)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTI().bmg()).intValue();
      }
      else
      {
        l1 = eHN().aaen * 1000L;
        continue;
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eTJ().bmg()).intValue() >= 0)
        {
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTJ().bmg()).intValue();
        }
        else
        {
          l1 = eHN().aaeo * 1000L;
          continue;
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eTK().bmg()).intValue() >= 0)
          {
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTK().bmg()).intValue();
          }
          else
          {
            l1 = eHN().aaep * 1000L;
            continue;
            locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eTL().bmg()).intValue() >= 0)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.FAy;
              l1 = ((Number)com.tencent.mm.plugin.finder.storage.d.eTL().bmg()).intValue();
            }
            else
            {
              l1 = eHN().aaeq * 1000L;
            }
          }
        }
      }
    }
    AppMethodBeat.o(346271);
    return l2;
  }
  
  public final g Rn(int paramInt)
  {
    AppMethodBeat.i(346377);
    Iterator localIterator = ((Iterable)this.EVR).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((g)localObject).hJx == paramInt)
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
      AppMethodBeat.o(346377);
      return localObject;
      i = 0;
      break label51;
      label71:
      break;
      localObject = null;
    }
  }
  
  public final void Ro(int paramInt)
  {
    AppMethodBeat.i(346390);
    bwf localbwf = eHN();
    Iterator localIterator = ((Iterable)this.EVR).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt, localbwf);
    }
    AppMethodBeat.o(346390);
  }
  
  public final boolean Rp(int paramInt)
  {
    AppMethodBeat.i(346400);
    boolean bool = eHM().Rp(paramInt);
    AppMethodBeat.o(346400);
    return bool;
  }
  
  public final com.tencent.mm.plugin.finder.viewmodel.d eHM()
  {
    AppMethodBeat.i(346340);
    com.tencent.mm.plugin.finder.viewmodel.d locald = (com.tencent.mm.plugin.finder.viewmodel.d)this.EVT.getValue();
    AppMethodBeat.o(346340);
    return locald;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(346369);
    paramString = ((Iterable)this.EVR).iterator();
    while (paramString.hasNext())
    {
      g localg = (g)paramString.next();
      if ((localg.EWf.compareAndSet(false, true)) && (localg.EWg.get()) && (!localg.EWd))
      {
        Log.i(localg.TAG, "[performBackground] in FindMoreFriendTab ");
        localg.EWe.azn("performBackground");
      }
    }
    AppMethodBeat.o(346369);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(346359);
    paramString = ((Iterable)this.EVR).iterator();
    while (paramString.hasNext())
    {
      g localg = (g)paramString.next();
      if ((localg.EWf.compareAndSet(true, false)) && (localg.EWg.get()) && (!localg.EWd))
      {
        Log.i(localg.TAG, "[performForeground] in FindMoreFriendTab");
        int i = localg.EWb.eHM().fmM();
        if (localg.hJx == i) {
          localg.EWe.a(localg.EWj, localg.eHQ(), "performForeground");
        }
      }
    }
    AppMethodBeat.o(346359);
  }
  
  public final void setup()
  {
    AppMethodBeat.i(346330);
    this.EVU.alive();
    Object localObject = l.ARA;
    com.tencent.mm.ae.d.b((LiveData)l.dZC(), (y)this);
    AppForegroundDelegate.heY.a((q)this);
    localObject = new c..ExternalSyntheticLambda0(this);
    l locall = l.ARA;
    com.tencent.mm.ae.d.b((LiveData)l.dZI(), (y)localObject);
    locall = l.ARA;
    com.tencent.mm.ae.d.b((LiveData)l.dZJ(), (y)localObject);
    locall = l.ARA;
    com.tencent.mm.ae.d.b((LiveData)l.dZL(), (y)localObject);
    AppMethodBeat.o(346330);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.d>
  {
    public static final b EVW;
    
    static
    {
      AppMethodBeat.i(346148);
      EVW = new b();
      AppMethodBeat.o(346148);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.c
 * JD-Core Version:    0.7.0.1
 */