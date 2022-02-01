package com.tencent.mm.plugin.finder.extension.reddot.nearby;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/nearby/FinderNearbyRedDotLogic;", "", "()V", "getNearbyAliveTabType", "", "removeFinderLiveEntrance", "", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "removeFinderLiveEntranceShowInfo", "source", "", "removeFinderLiveSquareTabEntrance", "removeNearByEntranceShowInfo", "removeNearbyEntrance", "removeNearbyEntryLiveShowInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ASI;
  
  static
  {
    AppMethodBeat.i(366887);
    ASI = new a();
    AppMethodBeat.o(366887);
  }
  
  public static void avL(String paramString)
  {
    AppMethodBeat.i(366825);
    s.u(paramString, "source");
    Log.i("Finder.RedDotManager", s.X("[removeNearByEntranceShowInfo] ", paramString));
    Iterator localIterator = ((Iterable)((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().dZr()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (p)localIterator.next();
      int i;
      if (((p)localObject1).field_ctrInfo.type != 1014)
      {
        paramString = ((p)localObject1).field_ctrInfo.aabA;
        if (paramString == null)
        {
          paramString = null;
          if (paramString == null) {
            break label272;
          }
          i = 1;
          label97:
          if (i == 0) {
            break label277;
          }
        }
      }
      Object localObject2;
      label272:
      label277:
      for (paramString = (String)localObject1;; paramString = null)
      {
        if (paramString == null) {
          break label280;
        }
        localObject1 = paramString.field_ctrInfo.aabA;
        if (localObject1 != null) {
          d.a((LinkedList)localObject1, (b)a.d.ASM);
        }
        localObject1 = paramString.field_ctrInfo.aabA;
        if (localObject1 == null) {
          break label331;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (s.p(((bxq)localObject3).Nnp, "NearbyEntrance")) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject2 = ((Iterable)paramString).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramString = ((Iterator)localObject2).next();
        } while (!s.p(((bxq)paramString).path, "NearbyEntrance"));
        for (;;)
        {
          paramString = (bxq)paramString;
          break;
          paramString = null;
        }
        i = 0;
        break label97;
      }
      label280:
      continue;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bxq)((Iterator)localObject1).next();
        ((bxq)localObject2).aagq = 1;
        ((bxq)localObject2).Nnp = "";
      }
      label331:
      localObject1 = new btw();
      ((btw)localObject1).parseFrom(paramString.field_ctrInfo.toByteArray());
      i.a(((PluginFinder)h.az(PluginFinder.class)).getRedDotManager(), (btw)localObject1, "removeNearByEntranceShowInfo", null, false, null, null, 0L, 124);
    }
    AppMethodBeat.o(366825);
  }
  
  public static void avM(String paramString)
  {
    AppMethodBeat.i(366838);
    s.u(paramString, "source");
    Log.i("Finder.RedDotManager", s.X("removeNearbyEntryLiveShowInfo ", paramString));
    Iterator localIterator = ((Iterable)((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().dZr()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (p)localIterator.next();
      Object localObject1;
      int i;
      if ((((p)localObject2).field_ctrInfo.type != 1014) && (((p)localObject2).field_ctrInfo.type != 1013))
      {
        localObject1 = ((p)localObject2).field_ctrInfo.aabA;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label309;
          }
          i = 1;
          label113:
          if (i == 0) {
            break label314;
          }
          localObject1 = localObject2;
          label119:
          if (localObject1 == null) {
            break label317;
          }
          localObject2 = ((p)localObject1).field_ctrInfo.aabA;
          if (localObject2 != null) {
            break label319;
          }
        }
      }
      Object localObject3;
      label309:
      label314:
      label317:
      label319:
      for (localObject2 = null;; localObject2 = Boolean.valueOf(d.a((LinkedList)localObject2, (b)f.ASO)))
      {
        Log.i("Finder.RedDotManager", "removeNearbyEntryLiveShowInfo " + paramString + "  result:" + localObject2);
        localObject2 = ((p)localObject1).field_ctrInfo.aabA;
        if (localObject2 == null) {
          break label385;
        }
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (s.p(((bxq)localObject4).Nnp, "NearbyEntrance")) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject3 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject3).next();
        } while (!s.p(((bxq)localObject1).path, "NearbyEntrance"));
        for (;;)
        {
          localObject1 = (bxq)localObject1;
          break;
          localObject1 = null;
        }
        i = 0;
        break label113;
        localObject1 = null;
        break label119;
        break;
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bxq)((Iterator)localObject2).next();
        ((bxq)localObject3).aagq = 1;
        ((bxq)localObject3).Nnp = "";
      }
      label385:
      localObject2 = new btw();
      ((btw)localObject2).parseFrom(((p)localObject1).field_ctrInfo.toByteArray());
      i.a(((PluginFinder)h.az(PluginFinder.class)).getRedDotManager(), (btw)localObject2, "removeNearByEntranceShowInfo", null, false, null, null, 0L, 124);
    }
    AppMethodBeat.o(366838);
  }
  
  public static void avN(String paramString)
  {
    AppMethodBeat.i(366852);
    s.u(paramString, "source");
    Log.i("Finder.RedDotManager", s.X("[removeFinderLiveEntranceShowInfo] ", paramString));
    Iterator localIterator = ((Iterable)((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().dZr()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (p)localIterator.next();
      Object localObject1 = ((p)localObject2).field_ctrInfo.aabA;
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label283;
        }
        i = 1;
        label87:
        if (i == 0) {
          break label288;
        }
        localObject1 = localObject2;
        label93:
        if (localObject1 == null) {
          break label291;
        }
        localObject2 = ((p)localObject1).field_ctrInfo.aabA;
        if (localObject2 != null) {
          break label293;
        }
      }
      Object localObject3;
      label283:
      label288:
      label291:
      label293:
      for (localObject2 = null;; localObject2 = Boolean.valueOf(d.a((LinkedList)localObject2, (b)b.ASK)))
      {
        Log.i("Finder.RedDotManager", "removeFinderLiveEntranceShowInfo " + paramString + " result:" + localObject2);
        localObject2 = ((p)localObject1).field_ctrInfo.aabA;
        if (localObject2 == null) {
          break label359;
        }
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (s.p(((bxq)localObject4).Nnp, "FinderLiveEntrance")) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject3 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject3).next();
        } while (!s.p(((bxq)localObject1).path, "FinderLiveEntrance"));
        for (;;)
        {
          localObject1 = (bxq)localObject1;
          break;
          localObject1 = null;
        }
        i = 0;
        break label87;
        localObject1 = null;
        break label93;
        break;
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bxq)((Iterator)localObject2).next();
        ((bxq)localObject3).aagq = 1;
        ((bxq)localObject3).Nnp = "";
      }
      label359:
      localObject2 = new btw();
      ((btw)localObject2).parseFrom(((p)localObject1).field_ctrInfo.toByteArray());
      i.a(((PluginFinder)h.az(PluginFinder.class)).getRedDotManager(), (btw)localObject2, "removeFinderLiveEntranceShowInfo", null, false, null, null, 0L, 124);
    }
    AppMethodBeat.o(366852);
  }
  
  public static int ebh()
  {
    AppMethodBeat.i(366810);
    p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("NearbyEntrance");
    if (localp != null)
    {
      if (localp.field_ctrInfo.type == 1014)
      {
        Log.i("Finder.RedDotManager", "[getNearbyAliveTabType] entrance red dot is foot print, jump to default tab");
        AppMethodBeat.o(366810);
        return -1;
      }
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      int i = i.d(localp);
      AppMethodBeat.o(366810);
      return i;
    }
    AppMethodBeat.o(366810);
    return -1;
  }
  
  public static void i(btw parambtw)
  {
    AppMethodBeat.i(366863);
    Object localObject1;
    boolean bool;
    if (parambtw == null)
    {
      localObject1 = null;
      if (parambtw != null) {
        break label136;
      }
      bool = false;
    }
    for (;;)
    {
      if (bool)
      {
        localObject2 = av.GiL;
        localObject2 = aw.Gjk;
        if ((parambtw != null) && (localObject1 != null))
        {
          localObject2 = w.FrV;
          w.a(p.a(new p(), parambtw), (bxq)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(366863);
      return;
      localObject1 = parambtw.aabA;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      Object localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
      } while (!s.p(((bxq)localObject1).path, "NearbyEntrance"));
      for (;;)
      {
        localObject1 = (bxq)localObject1;
        break;
        localObject1 = null;
      }
      label136:
      localObject2 = parambtw.aabA;
      if (localObject2 == null) {
        bool = false;
      } else {
        bool = d.a((LinkedList)localObject2, (b)e.ASN);
      }
    }
  }
  
  public static void j(btw parambtw)
  {
    AppMethodBeat.i(366874);
    Object localObject1;
    boolean bool;
    if (parambtw == null)
    {
      localObject1 = null;
      if (parambtw != null) {
        break label138;
      }
      bool = false;
    }
    for (;;)
    {
      if (bool)
      {
        localObject2 = av.GiL;
        localObject2 = aw.Gjk;
        if ((parambtw != null) && (localObject1 != null))
        {
          localObject2 = w.FrV;
          w.a(p.a(new p(), parambtw), (bxq)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(366874);
      return;
      localObject1 = parambtw.aabA;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      Object localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
      } while (!s.p(((bxq)localObject1).path, "FinderLiveEntrance"));
      for (;;)
      {
        localObject1 = (bxq)localObject1;
        break;
        localObject1 = null;
      }
      label138:
      localObject2 = parambtw.aabA;
      if (localObject2 == null) {
        bool = false;
      } else {
        bool = d.a((LinkedList)localObject2, (b)a.ASJ);
      }
    }
  }
  
  public static void k(btw parambtw)
  {
    AppMethodBeat.i(366880);
    Object localObject1;
    boolean bool;
    if (parambtw == null)
    {
      localObject1 = null;
      if (parambtw != null) {
        break label139;
      }
      bool = false;
    }
    for (;;)
    {
      if (bool)
      {
        localObject2 = av.GiL;
        localObject2 = aw.Gjk;
        if ((parambtw != null) && (localObject1 != null))
        {
          localObject2 = w.FrV;
          w.a(p.a(new p(), parambtw), (bxq)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(366880);
      return;
      localObject1 = parambtw.aabA;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      Object localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
      } while (!s.p(((bxq)localObject1).path, "NearbyLiveTab"));
      for (;;)
      {
        localObject1 = (bxq)localObject1;
        break;
        localObject1 = null;
      }
      label139:
      localObject2 = parambtw.aabA;
      if (localObject2 == null) {
        bool = false;
      } else {
        bool = d.a((LinkedList)localObject2, (b)c.ASL);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<bxq, Boolean>
  {
    public static final a ASJ;
    
    static
    {
      AppMethodBeat.i(366814);
      ASJ = new a();
      AppMethodBeat.o(366814);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<bxq, Boolean>
  {
    public static final b ASK;
    
    static
    {
      AppMethodBeat.i(366830);
      ASK = new b();
      AppMethodBeat.o(366830);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<bxq, Boolean>
  {
    public static final c ASL;
    
    static
    {
      AppMethodBeat.i(366846);
      ASL = new c();
      AppMethodBeat.o(366846);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<bxq, Boolean>
  {
    public static final e ASN;
    
    static
    {
      AppMethodBeat.i(366841);
      ASN = new e();
      AppMethodBeat.o(366841);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<bxq, Boolean>
  {
    public static final f ASO;
    
    static
    {
      AppMethodBeat.i(366842);
      ASO = new f();
      AppMethodBeat.o(366842);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.nearby.a
 * JD-Core Version:    0.7.0.1
 */