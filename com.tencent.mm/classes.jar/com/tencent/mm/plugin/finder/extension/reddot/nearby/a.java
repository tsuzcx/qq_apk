package com.tencent.mm.plugin.finder.extension.reddot.nearby;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/nearby/FinderNearbyRedDotLogic;", "", "()V", "getNearbyAliveTabType", "", "removeFinderLiveEntrance", "", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "removeFinderLiveEntranceShowInfo", "source", "", "removeNearByEntranceShowInfo", "removeNearbyEntrance", "removeNearbyEntryLiveShowInfo", "plugin-finder_release"})
public final class a
{
  public static final a xuX;
  
  static
  {
    AppMethodBeat.i(289046);
    xuX = new a();
    AppMethodBeat.o(289046);
  }
  
  public static void aBA(String paramString)
  {
    AppMethodBeat.i(289041);
    p.k(paramString, "source");
    Log.i("Finder.RedDotManager", "[removeNearByEntranceShowInfo] ".concat(String.valueOf(paramString)));
    paramString = h.ag(PluginFinder.class);
    p.j(paramString, "MMKernel.plugin(PluginFinder::class.java)");
    Iterator localIterator = ((Iterable)((PluginFinder)paramString).getRedDotManager().dqH()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.mm.plugin.finder.extension.reddot.l)localIterator.next();
      Object localObject2;
      label149:
      int i;
      if (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.type != 1014)
      {
        paramString = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.MFx;
        if (paramString != null)
        {
          localObject2 = ((Iterable)paramString).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramString = ((Iterator)localObject2).next();
            if (p.h(((bkn)paramString).path, "NearbyEntrance"))
            {
              paramString = (bkn)paramString;
              if (paramString == null) {
                break label283;
              }
              i = 1;
              label155:
              if (i == 0) {
                break label288;
              }
            }
          }
        }
      }
      label283:
      label288:
      for (paramString = (String)localObject1;; paramString = null)
      {
        if (paramString == null) {
          break label291;
        }
        localObject1 = paramString.field_ctrInfo.MFx;
        if (localObject1 != null) {
          d.a((LinkedList)localObject1, (b)c.xva);
        }
        localObject1 = paramString.field_ctrInfo.MFx;
        if (localObject1 == null) {
          break label342;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (p.h(((bkn)localObject3).HpB, "NearbyEntrance")) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        paramString = null;
        break;
        paramString = null;
        break label149;
        i = 0;
        break label155;
      }
      label291:
      continue;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bkn)((Iterator)localObject1).next();
        ((bkn)localObject2).SVs = 1;
        ((bkn)localObject2).HpB = "";
      }
      label342:
      localObject1 = new bhw();
      ((bhw)localObject1).parseFrom(paramString.field_ctrInfo.toByteArray());
      paramString = h.ag(PluginFinder.class);
      p.j(paramString, "MMKernel.plugin(PluginFinder::class.java)");
      f.a(((PluginFinder)paramString).getRedDotManager(), (bhw)localObject1, "removeNearByEntranceShowInfo", null, false, null, null, 60);
    }
    AppMethodBeat.o(289041);
  }
  
  public static void aBB(String paramString)
  {
    AppMethodBeat.i(289042);
    p.k(paramString, "source");
    Log.i("Finder.RedDotManager", "removeNearbyEntryLiveShowInfo ".concat(String.valueOf(paramString)));
    Object localObject1 = h.ag(PluginFinder.class);
    p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    Iterator localIterator = ((Iterable)((PluginFinder)localObject1).getRedDotManager().dqH()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (com.tencent.mm.plugin.finder.extension.reddot.l)localIterator.next();
      Object localObject3;
      label160:
      label165:
      int i;
      if ((((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).field_ctrInfo.type != 1014) && (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).field_ctrInfo.type != 1013))
      {
        localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).field_ctrInfo.MFx;
        if (localObject1 != null)
        {
          localObject3 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (p.h(((bkn)localObject1).path, "NearbyEntrance"))
            {
              localObject1 = (bkn)localObject1;
              if (localObject1 == null) {
                break label332;
              }
              i = 1;
              label171:
              if (i == 0) {
                break label337;
              }
              localObject1 = localObject2;
              label177:
              if (localObject1 == null) {
                break label340;
              }
              localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.MFx;
              if (localObject2 == null) {
                break label342;
              }
            }
          }
        }
      }
      label332:
      label337:
      label340:
      label342:
      for (localObject2 = Boolean.valueOf(d.a((LinkedList)localObject2, (b)e.KHY));; localObject2 = null)
      {
        Log.i("Finder.RedDotManager", "removeNearbyEntryLiveShowInfo " + paramString + "  result:" + localObject2);
        localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.MFx;
        if (localObject2 == null) {
          break label396;
        }
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (p.h(((bkn)localObject4).HpB, "NearbyEntrance")) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject1 = null;
        break label160;
        localObject1 = null;
        break label165;
        i = 0;
        break label171;
        localObject1 = null;
        break label177;
        break;
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bkn)((Iterator)localObject2).next();
        ((bkn)localObject3).SVs = 1;
        ((bkn)localObject3).HpB = "";
      }
      label396:
      localObject2 = new bhw();
      ((bhw)localObject2).parseFrom(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.toByteArray());
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      f.a(((PluginFinder)localObject1).getRedDotManager(), (bhw)localObject2, "removeNearByEntranceShowInfo", null, false, null, null, 60);
    }
    AppMethodBeat.o(289042);
  }
  
  public static void aBC(String paramString)
  {
    AppMethodBeat.i(289043);
    p.k(paramString, "source");
    Log.i("Finder.RedDotManager", "[removeFinderLiveEntranceShowInfo] ".concat(String.valueOf(paramString)));
    Object localObject1 = h.ag(PluginFinder.class);
    p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    Iterator localIterator = ((Iterable)((PluginFinder)localObject1).getRedDotManager().dqH()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (com.tencent.mm.plugin.finder.extension.reddot.l)localIterator.next();
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).field_ctrInfo.MFx;
      Object localObject3;
      label134:
      label139:
      int i;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          if (p.h(((bkn)localObject1).path, "FinderLiveEntrance"))
          {
            localObject1 = (bkn)localObject1;
            if (localObject1 == null) {
              break label306;
            }
            i = 1;
            label145:
            if (i == 0) {
              break label311;
            }
            localObject1 = localObject2;
            label151:
            if (localObject1 == null) {
              break label314;
            }
            localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.MFx;
            if (localObject2 == null) {
              break label316;
            }
          }
        }
      }
      label306:
      label311:
      label314:
      label316:
      for (localObject2 = Boolean.valueOf(d.a((LinkedList)localObject2, (b)b.KHW));; localObject2 = null)
      {
        Log.i("Finder.RedDotManager", "removeFinderLiveEntranceShowInfo " + paramString + " result:" + localObject2);
        localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.MFx;
        if (localObject2 == null) {
          break label370;
        }
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (p.h(((bkn)localObject4).HpB, "FinderLiveEntrance")) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject1 = null;
        break label134;
        localObject1 = null;
        break label139;
        i = 0;
        break label145;
        localObject1 = null;
        break label151;
        break;
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bkn)((Iterator)localObject2).next();
        ((bkn)localObject3).SVs = 1;
        ((bkn)localObject3).HpB = "";
      }
      label370:
      localObject2 = new bhw();
      ((bhw)localObject2).parseFrom(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo.toByteArray());
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      f.a(((PluginFinder)localObject1).getRedDotManager(), (bhw)localObject2, "removeFinderLiveEntranceShowInfo", null, false, null, null, 60);
    }
    AppMethodBeat.o(289043);
  }
  
  public static int dsl()
  {
    AppMethodBeat.i(289040);
    Object localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().aBf("NearbyEntrance");
    if (localObject != null)
    {
      if (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject).field_ctrInfo.type == 1014)
      {
        Log.i("Finder.RedDotManager", "[getNearbyAliveTabType] entrance red dot is foot print, jump to default tab");
        AppMethodBeat.o(289040);
        return -1;
      }
      com.tencent.mm.kernel.b.a locala = h.ag(PluginFinder.class);
      p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)locala).getRedDotManager();
      int i = f.a((com.tencent.mm.plugin.finder.extension.reddot.l)localObject);
      AppMethodBeat.o(289040);
      return i;
    }
    AppMethodBeat.o(289040);
    return -1;
  }
  
  public static void g(bhw parambhw)
  {
    AppMethodBeat.i(289044);
    Object localObject1;
    Object localObject2;
    if (parambhw != null)
    {
      localObject1 = parambhw.MFx;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (p.h(((bkn)localObject1).path, "NearbyEntrance"))
          {
            localObject1 = (bkn)localObject1;
            label64:
            if (parambhw == null) {
              break label145;
            }
            localObject2 = parambhw.MFx;
            if (localObject2 == null) {
              break label145;
            }
          }
        }
      }
    }
    label145:
    for (boolean bool = d.a((LinkedList)localObject2, (b)d.xvb);; bool = false)
    {
      if (bool)
      {
        localObject2 = aj.AGc;
        if ((parambhw != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
          com.tencent.mm.plugin.finder.report.l.a(new com.tencent.mm.plugin.finder.extension.reddot.l().e(parambhw), (bkn)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(289044);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label64;
    }
  }
  
  public static void h(bhw parambhw)
  {
    AppMethodBeat.i(289045);
    Object localObject1;
    Object localObject2;
    if (parambhw != null)
    {
      localObject1 = parambhw.MFx;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (p.h(((bkn)localObject1).path, "FinderLiveEntrance"))
          {
            localObject1 = (bkn)localObject1;
            label65:
            if (parambhw == null) {
              break label147;
            }
            localObject2 = parambhw.MFx;
            if (localObject2 == null) {
              break label147;
            }
          }
        }
      }
    }
    label147:
    for (boolean bool = d.a((LinkedList)localObject2, (b)a.xuY);; bool = false)
    {
      if (bool)
      {
        localObject2 = aj.AGc;
        if ((parambhw != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
          com.tencent.mm.plugin.finder.report.l.a(new com.tencent.mm.plugin.finder.extension.reddot.l().e(parambhw), (bkn)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(289045);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label65;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements b<bkn, Boolean>
  {
    public static final a xuY;
    
    static
    {
      AppMethodBeat.i(290235);
      xuY = new a();
      AppMethodBeat.o(290235);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements b<bkn, Boolean>
  {
    public static final b KHW;
    
    static
    {
      AppMethodBeat.i(293335);
      KHW = new b();
      AppMethodBeat.o(293335);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements b<bkn, Boolean>
  {
    public static final c xva;
    
    static
    {
      AppMethodBeat.i(283976);
      xva = new c();
      AppMethodBeat.o(283976);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements b<bkn, Boolean>
  {
    public static final d xvb;
    
    static
    {
      AppMethodBeat.i(279517);
      xvb = new d();
      AppMethodBeat.o(279517);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements b<bkn, Boolean>
  {
    public static final e KHY;
    
    static
    {
      AppMethodBeat.i(293371);
      KHY = new e();
      AppMethodBeat.o(293371);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.nearby.a
 * JD-Core Version:    0.7.0.1
 */