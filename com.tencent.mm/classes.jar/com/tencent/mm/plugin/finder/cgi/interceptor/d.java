package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.ae.g;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.cgi.aa.e;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "checkValid", "", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "rvFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabType", "containLiveList", "", "fakeData", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "handle", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class d
  implements f
{
  public static final a xfE;
  
  static
  {
    AppMethodBeat.i(285235);
    xfE = new a((byte)0);
    AppMethodBeat.o(285235);
  }
  
  public final boolean a(aa.f paramf)
  {
    AppMethodBeat.i(285231);
    p.k(paramf, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.dUS().aSr()).intValue() > 0) && (paramf.dnK().fEH == 1) && (paramf.xbB > 0))
    {
      localObject1 = new bjt();
      Object localObject2 = new bjp();
      ((bjp)localObject2).zAO = 111L;
      ((bjp)localObject2).zAC = false;
      ((bjp)localObject2).STH = "热门有更多推荐";
      ((bjp)localObject2).PAf = "热门推荐";
      ((bjp)localObject2).xBI = 0;
      ((bjp)localObject2).object.addAll((Collection)paramf.object.subList(0, Math.min(paramf.object.size(), paramf.xbB)));
      ((bjt)localObject1).SIf.add(localObject2);
      localObject2 = ((bjt)localObject1).SUa;
      Object localObject3 = paramf.object.subList(0, paramf.xbB);
      p.j(localObject3, "resp.`object`.subList(0, resp.streamSize)");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((FinderObject)((Iterator)localObject4).next()).id));
      }
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      ((bjt)localObject1).SUa.add(1, Long.valueOf(111L));
      paramf.xFN = ((bjt)localObject1);
    }
    AppMethodBeat.o(285231);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.d paramd)
  {
    AppMethodBeat.i(285233);
    p.k(paramd, "loadedInfo");
    Object localObject2 = paramd.xFN;
    int i = paramd.fEH;
    Object localObject4;
    if (aj.a(aj.AGc, i, 0, 2)) {
      if (localObject2 != null)
      {
        localObject1 = ((bjt)localObject2).STB;
        if (localObject1 != null)
        {
          localObject1 = (bjr)j.lp((List)localObject1);
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((bjr)localObject1).STx);
            if (localObject2 == null) {
              break label246;
            }
            localObject2 = ((bjt)localObject2).SIf;
            if (localObject2 == null) {
              break label246;
            }
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (bjp)((Iterator)localObject2).next();
              if (((bjp)localObject3).xBI == 1)
              {
                localObject4 = new StringBuilder("containLiveList ");
                localObject2 = localObject3;
                if (localObject3 == null) {
                  localObject2 = "";
                }
                Log.i("Finder.HandleLayoutInfoInterceptor", g.bN(localObject2));
                i = 1;
                label186:
                if (i != 0) {
                  break label261;
                }
                if (localObject1 != null) {
                  break label251;
                }
                label195:
                if (localObject1 != null) {
                  break label266;
                }
                if (localObject1 != null) {
                  break label279;
                }
                label205:
                if (localObject1 != null) {
                  break label292;
                }
                label210:
                i = -6;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label213:
      if (i >= 0) {
        break label386;
      }
      Log.w("Finder.HandleLayoutInfoInterceptor", "[handle] ret=".concat(String.valueOf(i)));
      AppMethodBeat.o(285233);
      return false;
      localObject1 = null;
      break;
      label246:
      i = 0;
      break label186;
      label251:
      if (((Integer)localObject1).intValue() != 9) {
        break label195;
      }
      for (;;)
      {
        label261:
        i = 0;
        break label213;
        label266:
        if (((Integer)localObject1).intValue() != 8)
        {
          break;
          label279:
          if (((Integer)localObject1).intValue() != 10)
          {
            break label205;
            label292:
            if (((Integer)localObject1).intValue() != 11) {
              break label210;
            }
          }
        }
      }
      if ((i != 1) && (i != 3) && (i != 2)) {
        i = -5;
      } else if (localObject2 == null) {
        i = -1;
      } else if (((bjt)localObject2).SUa.isEmpty()) {
        i = -3;
      } else if ((((bjt)localObject2).SIf.isEmpty()) && (((bjt)localObject2).STB.isEmpty())) {
        i = -4;
      } else {
        i = 0;
      }
    }
    label386:
    Object localObject7 = paramd.xFN;
    if (localObject7 == null) {
      p.iCn();
    }
    Object localObject1 = (List)paramd.xFF;
    i = 0;
    localObject1 = ((List)localObject1).iterator();
    label455:
    int k;
    label462:
    label493:
    LinkedList localLinkedList;
    if (((Iterator)localObject1).hasNext()) {
      if (((bu)((Iterator)localObject1).next()).mf() == paramd.xbC)
      {
        j = 1;
        if (j == 0) {
          break label651;
        }
        k = i;
        if (paramd.xbB <= 0) {
          break label664;
        }
        localObject4 = new LinkedList((Collection)paramd.xFF.subList(0, paramd.xbB));
        if (paramd.xbB > 0) {
          break label676;
        }
        localObject1 = new LinkedList((Collection)paramd.xFF);
        label516:
        localLinkedList = new LinkedList((Collection)paramd.xFF);
        localObject2 = ((bjt)localObject7).SIf;
        p.j(localObject2, "layoutInfo.card");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
    }
    label575:
    label729:
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label731;
      }
      localObject5 = ((Iterator)localObject3).next();
      localObject6 = (bjp)localObject5;
      if ((((bjp)localObject6).xBI == 2) || (((bjp)localObject6).xBI == 0) || (((bjp)localObject6).xBI == 1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label729;
        }
        ((Collection)localObject2).add(localObject5);
        break label575;
        j = 0;
        break label455;
        i += 1;
        break;
        k = -1;
        break label462;
        localObject4 = new LinkedList();
        break label493;
        if (k >= 0)
        {
          localObject1 = new LinkedList((Collection)paramd.xFF.subList(k + 1, paramd.xFF.size()));
          break label516;
        }
        localObject1 = new LinkedList();
        break label516;
      }
    }
    label651:
    label664:
    label676:
    label731:
    Object localObject5 = (List)localObject2;
    Object localObject6 = ((bjt)localObject7).STB;
    localObject2 = new StringBuilder("[handle] dividerObjects=");
    p.j(localObject6, "dividerObjects");
    Object localObject8 = (Iterable)localObject6;
    Object localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject8, 10));
    localObject8 = ((Iterable)localObject8).iterator();
    Object localObject9;
    while (((Iterator)localObject8).hasNext())
    {
      localObject9 = (bjr)((Iterator)localObject8).next();
      p.j(localObject9, "it");
      p.k(localObject9, "$this$print");
      ((Collection)localObject3).add(((bjr)localObject9).zAO + '_' + ((bjr)localObject9).STx + '_' + ((bjr)localObject9).wording);
    }
    localObject2 = ((StringBuilder)localObject2).append((List)localObject3).append(" cardObjects=");
    localObject8 = (Iterable)localObject5;
    localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject8, 10));
    localObject8 = ((Iterable)localObject8).iterator();
    while (((Iterator)localObject8).hasNext())
    {
      localObject9 = (bjp)((Iterator)localObject8).next();
      p.j(localObject9, "it");
      ((Collection)localObject3).add(e.a((bjp)localObject9));
    }
    Log.i("Finder.HandleLayoutInfoInterceptor", (List)localObject3);
    localObject2 = (List)localObject6;
    i = 0;
    localObject2 = ((List)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bjr)((Iterator)localObject2).next();
      if ((((bjr)localObject3).STx == 2) || (((bjr)localObject3).STx == 1))
      {
        j = 1;
        label1071:
        if (j == 0) {
          break label1439;
        }
        label1075:
        if (i < 0) {
          break label1451;
        }
        i = 1;
        label1081:
        if ((i != 0) && (((LinkedList)localObject1).isEmpty()))
        {
          j.c((List)localObject6, (kotlin.g.a.b)b.xfF);
          Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] fallback remove history divider");
        }
        paramd.xFF.clear();
        localObject2 = ((bjt)localObject7).SUa;
        p.j(localObject2, "layoutInfo.layoutIds");
        localObject8 = ((Iterable)localObject2).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      label1153:
      if (!((Iterator)localObject8).hasNext()) {
        break label1554;
      }
      localObject9 = (Long)((Iterator)localObject8).next();
      localObject3 = ((Iterable)localObject4).iterator();
      label1187:
      long l;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((Iterator)localObject3).next();
        l = ((bu)localObject2).mf();
        if (localObject9 == null)
        {
          label1223:
          j = 0;
          label1225:
          if (j == 0) {
            break label1470;
          }
          label1229:
          localObject2 = (bu)localObject2;
          if (localObject2 != null) {
            break label1506;
          }
          localObject3 = ((Iterable)localObject5).iterator();
          label1253:
          if (!((Iterator)localObject3).hasNext()) {
            break label1494;
          }
          localObject2 = ((Iterator)localObject3).next();
          l = ((bjp)localObject2).zAO;
          if (localObject9 != null) {
            break label1478;
          }
          label1287:
          j = 0;
          label1289:
          if (j == 0) {
            break label1492;
          }
          label1293:
          localObject2 = (bjp)localObject2;
          if (localObject2 == null) {
            break label1500;
          }
          localObject2 = e.b((bjp)localObject2, paramd.fEH);
          label1316:
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = ((Iterable)localObject6).iterator();
            label1337:
            if (!((Iterator)localObject3).hasNext()) {
              break label1529;
            }
            localObject2 = ((Iterator)localObject3).next();
            l = ((bjr)localObject2).zAO;
            if (localObject9 != null) {
              break label1513;
            }
            label1371:
            j = 0;
            label1373:
            if (j == 0) {
              break label1527;
            }
            label1377:
            localObject2 = (bjr)localObject2;
            if (localObject2 == null) {
              break label1535;
            }
          }
        }
      }
      label1439:
      label1451:
      label1470:
      label1478:
      label1492:
      label1494:
      label1500:
      label1506:
      label1513:
      label1527:
      label1529:
      label1535:
      for (localObject3 = e.a((bjr)localObject2);; localObject3 = null)
      {
        if (localObject3 != null) {
          break label1541;
        }
        Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] this id[" + localObject9 + "] not match any.");
        break label1153;
        j = 0;
        break label1071;
        i += 1;
        break;
        i = -1;
        break label1075;
        i = 0;
        break label1081;
        if (l != ((Long)localObject9).longValue()) {
          break label1223;
        }
        j = 1;
        break label1225;
        break label1187;
        localObject2 = null;
        break label1229;
        if (l != ((Long)localObject9).longValue()) {
          break label1287;
        }
        j = 1;
        break label1289;
        break label1253;
        localObject2 = null;
        break label1293;
        localObject2 = null;
        break label1316;
        i += 1;
        break label1316;
        if (l != ((Long)localObject9).longValue()) {
          break label1371;
        }
        j = 1;
        break label1373;
        break label1337;
        localObject2 = null;
        break label1377;
      }
      label1541:
      paramd.xFF.add(localObject3);
    }
    label1554:
    localObject3 = ((Iterable)paramd.xFF).iterator();
    int j = 0;
    int m;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      m = j + 1;
      if (j < 0) {
        j.iBO();
      }
      localObject2 = (bu)localObject2;
      if ((localObject2 instanceof bl)) {
        if (((bl)localObject2).xzB.STx == 10)
        {
          if (j - 1 >= 0)
          {
            localObject8 = paramd.xFF.get(j - 1);
            p.j(localObject8, "loadedInfo.incrementList[index - 1 ]");
            localObject9 = (bu)localObject8;
            if ((localObject9 instanceof BaseFinderFeed))
            {
              ((BaseFinderFeed)localObject9).streamDivider = ((bl)localObject2).xzB;
              localObject8 = new StringBuilder("[handle] has divider ").append(((bl)localObject2).xzB.STx).append(' ').append("wording=").append(((bl)localObject2).xzB.wording).append(" nickname=");
              localObject2 = ((BaseFinderFeed)localObject9).contact;
              if (localObject2 != null) {}
              for (localObject2 = ((i)localObject2).getNickname();; localObject2 = null)
              {
                Log.i("Finder.HandleLayoutInfoInterceptor", (String)localObject2);
                j = m;
                break;
              }
            }
          }
        }
        else if (j + 1 < paramd.xFF.size())
        {
          localObject8 = paramd.xFF.get(j + 1);
          p.j(localObject8, "loadedInfo.incrementList[index + 1]");
          localObject9 = (bu)localObject8;
          if ((localObject9 instanceof BaseFinderFeed))
          {
            ((BaseFinderFeed)localObject9).streamDivider = ((bl)localObject2).xzB;
            localObject8 = new StringBuilder("[handle] has divider ").append(((bl)localObject2).xzB.STx).append(' ').append("wording=").append(((bl)localObject2).xzB.wording).append(" nickname=");
            localObject2 = ((BaseFinderFeed)localObject9).contact;
            if (localObject2 == null) {
              break label1961;
            }
          }
        }
      }
      label1961:
      for (localObject2 = ((i)localObject2).getNickname();; localObject2 = null)
      {
        Log.i("Finder.HandleLayoutInfoInterceptor", (String)localObject2);
        j = m;
        break;
      }
    }
    j.c((List)paramd.xFF, (kotlin.g.a.b)c.xfG);
    if (i != ((LinkedList)localObject4).size())
    {
      localObject2 = new StringBuilder("[handle] checkCount[").append(i).append("] != streamList.size[").append(((LinkedList)localObject4).size()).append("] rawObjects.size[").append(localLinkedList.size()).append("] historyList.size[").append(((LinkedList)localObject1).size()).append(']');
      localObject3 = ((bjt)localObject7).SUa;
      p.j(localObject3, "layoutInfo.layoutIds");
      localObject7 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject7, 10));
      localObject7 = ((Iterable)localObject7).iterator();
      while (((Iterator)localObject7).hasNext())
      {
        localObject8 = (Long)((Iterator)localObject7).next();
        p.j(localObject8, "it");
        ((Collection)localObject3).add(com.tencent.mm.ae.d.Fw(((Long)localObject8).longValue()));
      }
      localObject2 = ((StringBuilder)localObject2).append((List)localObject3).append(' ');
      localObject7 = (Iterable)localObject4;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject7, 10));
      localObject7 = ((Iterable)localObject7).iterator();
      while (((Iterator)localObject7).hasNext()) {
        ((Collection)localObject3).add(com.tencent.mm.ae.d.Fw(((bu)((Iterator)localObject7).next()).mf()));
      }
      localObject2 = ((StringBuilder)localObject2).append((List)localObject3).append('}');
      localObject7 = (Iterable)localObject4;
      localObject3 = (Collection)new ArrayList();
      localObject7 = ((Iterable)localObject7).iterator();
      label2337:
      label2376:
      label2381:
      label2410:
      label2422:
      label2425:
      while (((Iterator)localObject7).hasNext())
      {
        localObject8 = ((Iterator)localObject7).next();
        localObject9 = (bu)localObject8;
        Object localObject10 = (List)paramd.xFF;
        j = 0;
        localObject10 = ((List)localObject10).iterator();
        if (((Iterator)localObject10).hasNext()) {
          if (((bu)((Iterator)localObject10).next()).mf() == ((bu)localObject9).mf())
          {
            m = 1;
            if (m == 0) {
              break label2410;
            }
            if (j >= 0) {
              break label2422;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label2425;
          }
          ((Collection)localObject3).add(localObject8);
          break;
          m = 0;
          break label2376;
          j += 1;
          break label2337;
          j = -1;
          break label2381;
        }
      }
      localObject7 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject7, 10));
      localObject7 = ((Iterable)localObject7).iterator();
      while (((Iterator)localObject7).hasNext()) {
        ((Collection)localObject3).add(com.tencent.mm.ae.d.Fw(((bu)((Iterator)localObject7).next()).mf()));
      }
      localObject2 = (List)localObject3;
      Log.e("Finder.HandleLayoutInfoInterceptor", (String)localObject2);
      f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "layoutIdError", true, (a)new d((String)localObject2));
      if (BuildInfo.IS_FLAVOR_PURPLE) {
        com.tencent.mm.ae.d.uiThread((a)e.xfI);
      }
      paramd.xFF.clear();
      paramd.xFF.addAll((Collection)localLinkedList);
    }
    for (;;)
    {
      Log.i("Finder.HandleLayoutInfoInterceptor", "[handle] checkCount[" + i + "] dividerCount[" + ((LinkedList)localObject6).size() + "] cardCount[" + ((List)localObject5).size() + "] streamCount=" + ((LinkedList)localObject4).size() + " historyCount=" + ((LinkedList)localObject1).size() + " result=" + paramd.xFF.size() + " historyIndex=" + k);
      break;
      paramd.xFF.addAll((Collection)localObject1);
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
  {
    AppMethodBeat.i(285234);
    p.k(paramd, "loadedInfo");
    AppMethodBeat.o(285234);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<bjr, Boolean>
  {
    public static final b xfF;
    
    static
    {
      AppMethodBeat.i(220607);
      xfF = new b();
      AppMethodBeat.o(220607);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<bu, Boolean>
  {
    public static final c xfG;
    
    static
    {
      AppMethodBeat.i(287795);
      xfG = new c();
      AppMethodBeat.o(287795);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<String>
  {
    d(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    public static final e xfI;
    
    static
    {
      AppMethodBeat.i(279267);
      xfI = new e();
      AppMethodBeat.o(279267);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.d
 * JD-Core Version:    0.7.0.1
 */