package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "checkValid", "", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "rvFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabType", "containLiveList", "", "fakeData", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "handle", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements g
{
  public static final a AEZ;
  
  static
  {
    AppMethodBeat.i(336752);
    AEZ = new a((byte)0);
    AppMethodBeat.o(336752);
  }
  
  private static boolean a(bwe parambwe)
  {
    AppMethodBeat.i(336744);
    if (parambwe != null)
    {
      parambwe = parambwe.ZLJ;
      if (parambwe != null)
      {
        parambwe = ((Iterable)parambwe).iterator();
        while (parambwe.hasNext())
        {
          bwa localbwa = (bwa)parambwe.next();
          if (localbwa.AYX == 1)
          {
            parambwe = localbwa;
            if (localbwa == null) {
              parambwe = "";
            }
            Log.i("Finder.HandleLayoutInfoInterceptor", s.X("containLiveList ", com.tencent.mm.ae.f.dg(parambwe)));
            AppMethodBeat.o(336744);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(336744);
    return false;
  }
  
  public final boolean a(aq.d paramd, int paramInt)
  {
    AppMethodBeat.i(336765);
    s.u(paramd, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eTr().bmg()).intValue() > 0) && (paramd.dVm().hJx == 1) && (paramd.AAs > 0))
    {
      localObject1 = new bwe();
      Object localObject2 = new bwa();
      ((bwa)localObject2).ECY = 111L;
      ((bwa)localObject2).ECL = false;
      ((bwa)localObject2).aadM = "热门有更多推荐";
      ((bwa)localObject2).Wqu = "热门推荐";
      ((bwa)localObject2).AYX = 0;
      ((bwa)localObject2).object.addAll((Collection)paramd.object.subList(0, Math.min(paramd.object.size(), paramd.AAs)));
      ((bwe)localObject1).ZLJ.add(localObject2);
      localObject2 = ((bwe)localObject1).aaeh;
      Object localObject3 = paramd.object.subList(0, paramd.AAs);
      s.s(localObject3, "resp.`object`.subList(0, resp.streamSize)");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((FinderObject)((Iterator)localObject4).next()).id));
      }
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      ((bwe)localObject1).aaeh.add(1, Long.valueOf(111L));
      localObject2 = ah.aiuX;
      paramd.BeF = ((bwe)localObject1);
    }
    AppMethodBeat.o(336765);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.d paramd)
  {
    AppMethodBeat.i(336816);
    s.u(paramd, "loadedInfo");
    Object localObject2 = paramd.BeF;
    int j = paramd.hJx;
    if (localObject2 == null) {}
    Object localObject4;
    label106:
    Object localObject5;
    for (int i = -1; i < 0; i = 0)
    {
      Log.w("Finder.HandleLayoutInfoInterceptor", s.X("[handle] ret=", Integer.valueOf(i)));
      AppMethodBeat.o(336816);
      return false;
      localObject1 = ((bwe)localObject2).aadF;
      if (localObject1 == null)
      {
        localObject1 = (List)ab.aivy;
        localObject4 = (Iterable)localObject1;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
      }
      label212:
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          break label214;
        }
        localObject5 = ((Iterator)localObject4).next();
        localObject6 = (bwc)localObject5;
        if ((a((bwe)localObject2)) || (((bwc)localObject6).aadB == 9) || (((bwc)localObject6).aadB == 8) || (((bwc)localObject6).aadB == 10) || (((bwc)localObject6).aadB == 11)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label212;
          }
          ((Collection)localObject3).add(localObject5);
          break label106;
          localObject1 = (List)localObject1;
          break;
        }
      }
      label214:
      localObject3 = (List)localObject3;
      if (((List)localObject3).size() != ((List)localObject1).size())
      {
        localObject4 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        label322:
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          if (!((List)localObject3).contains((bwc)localObject5)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label322;
            }
            ((Collection)localObject1).add(localObject5);
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject4 = new StringBuilder("[checkValid] tabType=").append(j).append(" inValidList=");
        localObject6 = (Iterable)localObject1;
        localObject5 = (Collection)new ArrayList(p.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(Integer.valueOf(((bwc)((Iterator)localObject6).next()).aadB));
        }
        Log.e("Finder.HandleLayoutInfoInterceptor", (List)localObject5);
        localObject4 = ((bwe)localObject2).aadF;
        if (localObject4 != null) {
          ((LinkedList)localObject4).clear();
        }
        localObject4 = ((bwe)localObject2).aadF;
        if (localObject4 != null) {
          ((LinkedList)localObject4).addAll((Collection)localObject3);
        }
        localObject2 = ((bwe)localObject2).aaeh;
        if (localObject2 != null) {
          p.e((List)localObject2, (kotlin.g.a.b)new b((List)localObject1));
        }
      }
    }
    Object localObject8 = paramd.BeF;
    s.checkNotNull(localObject8);
    Object localObject1 = (List)paramd.Bex;
    i = 0;
    localObject1 = ((List)localObject1).iterator();
    label587:
    int k;
    if (((Iterator)localObject1).hasNext()) {
      if (((cc)((Iterator)localObject1).next()).bZA() == paramd.AAt)
      {
        j = 1;
        if (j == 0) {
          break label783;
        }
        k = i;
        label594:
        if (paramd.AAs <= 0) {
          break label796;
        }
        localObject4 = new LinkedList((Collection)paramd.Bex.subList(0, paramd.AAs));
        label625:
        if (paramd.AAs > 0) {
          break label808;
        }
        localObject1 = new LinkedList((Collection)paramd.Bex);
        label648:
        localObject5 = new LinkedList((Collection)paramd.Bex);
        localObject2 = ((bwe)localObject8).ZLJ;
        s.s(localObject2, "layoutInfo.card");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
    }
    label707:
    label861:
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label863;
      }
      localObject6 = ((Iterator)localObject3).next();
      localObject7 = (bwa)localObject6;
      if ((((bwa)localObject7).AYX == 2) || (((bwa)localObject7).AYX == 0) || (((bwa)localObject7).AYX == 1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label861;
        }
        ((Collection)localObject2).add(localObject6);
        break label707;
        j = 0;
        break label587;
        i += 1;
        break;
        k = -1;
        break label594;
        localObject4 = new LinkedList();
        break label625;
        if (k >= 0)
        {
          localObject1 = new LinkedList((Collection)paramd.Bex.subList(k + 1, paramd.Bex.size()));
          break label648;
        }
        localObject1 = new LinkedList();
        break label648;
      }
    }
    label783:
    label796:
    label808:
    label863:
    Object localObject6 = (List)localObject2;
    Object localObject7 = ((bwe)localObject8).aadF;
    localObject2 = new StringBuilder("[handle] dividerObjects=");
    s.s(localObject7, "dividerObjects");
    Object localObject9 = (Iterable)localObject7;
    Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject9, 10));
    localObject9 = ((Iterable)localObject9).iterator();
    Object localObject10;
    while (((Iterator)localObject9).hasNext())
    {
      localObject10 = (bwc)((Iterator)localObject9).next();
      s.s(localObject10, "it");
      s.u(localObject10, "<this>");
      ((Collection)localObject3).add(((bwc)localObject10).ECY + '_' + ((bwc)localObject10).aadB + '_' + ((bwc)localObject10).wording);
    }
    localObject2 = ((StringBuilder)localObject2).append((List)localObject3).append(" cardObjects=");
    localObject9 = (Iterable)localObject6;
    localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject9, 10));
    localObject9 = ((Iterable)localObject9).iterator();
    while (((Iterator)localObject9).hasNext())
    {
      localObject10 = (bwa)((Iterator)localObject9).next();
      s.s(localObject10, "it");
      ((Collection)localObject3).add(f.a((bwa)localObject10));
    }
    Log.i("Finder.HandleLayoutInfoInterceptor", (List)localObject3);
    localObject2 = (List)localObject7;
    i = 0;
    localObject2 = ((List)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bwc)((Iterator)localObject2).next();
      if ((((bwc)localObject3).aadB == 2) || (((bwc)localObject3).aadB == 1))
      {
        j = 1;
        label1202:
        if (j == 0) {
          break label1556;
        }
        label1206:
        if (i < 0) {
          break label1568;
        }
        i = 1;
        label1212:
        if ((i != 0) && (((LinkedList)localObject1).isEmpty()))
        {
          p.e((List)localObject7, (kotlin.g.a.b)c.AFb);
          Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] fallback remove history divider");
        }
        paramd.Bex.clear();
        localObject2 = ((bwe)localObject8).aaeh;
        s.s(localObject2, "layoutInfo.layoutIds");
        localObject9 = ((Iterable)localObject2).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      label1283:
      if (!((Iterator)localObject9).hasNext()) {
        break label1683;
      }
      localObject10 = (Long)((Iterator)localObject9).next();
      localObject3 = ((Iterable)localObject4).iterator();
      label1317:
      long l;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((Iterator)localObject3).next();
        l = ((cc)localObject2).bZA();
        if (localObject10 == null)
        {
          label1353:
          j = 0;
          label1355:
          if (j == 0) {
            break label1587;
          }
          label1359:
          localObject2 = (cc)localObject2;
          if (localObject2 != null) {
            break label1631;
          }
          localObject3 = ((Iterable)localObject6).iterator();
          label1383:
          if (!((Iterator)localObject3).hasNext()) {
            break label1611;
          }
          localObject2 = ((Iterator)localObject3).next();
          l = ((bwa)localObject2).ECY;
          if (localObject10 != null) {
            break label1595;
          }
          label1417:
          j = 0;
          label1419:
          if (j == 0) {
            break label1609;
          }
          label1423:
          localObject2 = (bwa)localObject2;
          if (localObject2 != null) {
            break label1617;
          }
          localObject2 = null;
          label1438:
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = ((Iterable)localObject7).iterator();
            label1459:
            if (!((Iterator)localObject3).hasNext()) {
              break label1654;
            }
            localObject2 = ((Iterator)localObject3).next();
            l = ((bwc)localObject2).ECY;
            if (localObject10 != null) {
              break label1638;
            }
            label1493:
            j = 0;
            label1495:
            if (j == 0) {
              break label1652;
            }
            label1499:
            localObject2 = (bwc)localObject2;
            if (localObject2 != null) {
              break label1660;
            }
          }
        }
      }
      label1556:
      label1568:
      label1587:
      label1595:
      label1609:
      label1611:
      label1617:
      label1631:
      label1638:
      label1652:
      label1654:
      label1660:
      for (localObject3 = null;; localObject3 = f.a((bwc)localObject2))
      {
        if (localObject3 != null) {
          break label1670;
        }
        Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] this id[" + localObject10 + "] not match any.");
        break label1283;
        j = 0;
        break label1202;
        i += 1;
        break;
        i = -1;
        break label1206;
        i = 0;
        break label1212;
        if (l != ((Long)localObject10).longValue()) {
          break label1353;
        }
        j = 1;
        break label1355;
        break label1317;
        localObject2 = null;
        break label1359;
        if (l != ((Long)localObject10).longValue()) {
          break label1417;
        }
        j = 1;
        break label1419;
        break label1383;
        localObject2 = null;
        break label1423;
        localObject2 = f.b((bwa)localObject2, paramd.hJx);
        break label1438;
        i += 1;
        break label1438;
        if (l != ((Long)localObject10).longValue()) {
          break label1493;
        }
        j = 1;
        break label1495;
        break label1459;
        localObject2 = null;
        break label1499;
      }
      label1670:
      paramd.Bex.add(localObject3);
    }
    label1683:
    localObject3 = ((Iterable)paramd.Bex).iterator();
    j = 0;
    int m;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      m = j + 1;
      if (j < 0) {
        p.kkW();
      }
      localObject2 = (cc)localObject2;
      if ((localObject2 instanceof bp)) {
        if (((bp)localObject2).AWZ.aadB == 10)
        {
          if (j - 1 >= 0)
          {
            localObject9 = paramd.Bex.get(j - 1);
            s.s(localObject9, "loadedInfo.incrementList[index - 1 ]");
            localObject10 = (cc)localObject9;
            if ((localObject10 instanceof BaseFinderFeed))
            {
              ((BaseFinderFeed)localObject10).streamDivider = ((bp)localObject2).AWZ;
              localObject9 = new StringBuilder("[handle] has divider ").append(((bp)localObject2).AWZ.aadB).append(" wording=").append(((bp)localObject2).AWZ.wording).append(" nickname=");
              localObject2 = ((BaseFinderFeed)localObject10).contact;
              if (localObject2 == null) {}
              for (localObject2 = null;; localObject2 = ((m)localObject2).getNickname())
              {
                Log.i("Finder.HandleLayoutInfoInterceptor", localObject2);
                j = m;
                break;
              }
            }
          }
        }
        else if (j + 1 < paramd.Bex.size())
        {
          localObject9 = paramd.Bex.get(j + 1);
          s.s(localObject9, "loadedInfo.incrementList[index + 1]");
          localObject10 = (cc)localObject9;
          if ((localObject10 instanceof BaseFinderFeed))
          {
            ((BaseFinderFeed)localObject10).streamDivider = ((bp)localObject2).AWZ;
            localObject9 = new StringBuilder("[handle] has divider ").append(((bp)localObject2).AWZ.aadB).append(" wording=").append(((bp)localObject2).AWZ.wording).append(" nickname=");
            localObject2 = ((BaseFinderFeed)localObject10).contact;
            if (localObject2 != null) {
              break label2074;
            }
          }
        }
      }
      label2074:
      for (localObject2 = null;; localObject2 = ((m)localObject2).getNickname())
      {
        Log.i("Finder.HandleLayoutInfoInterceptor", localObject2);
        j = m;
        break;
      }
    }
    p.e((List)paramd.Bex, (kotlin.g.a.b)d.AFc);
    if (i != ((LinkedList)localObject4).size())
    {
      localObject2 = new StringBuilder("[handle] checkCount[").append(i).append("] != streamList.size[").append(((LinkedList)localObject4).size()).append("] rawObjects.size[").append(((LinkedList)localObject5).size()).append("] historyList.size[").append(((LinkedList)localObject1).size()).append(']');
      localObject3 = ((bwe)localObject8).aaeh;
      s.s(localObject3, "layoutInfo.layoutIds");
      localObject8 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject8, 10));
      localObject8 = ((Iterable)localObject8).iterator();
      while (((Iterator)localObject8).hasNext())
      {
        localObject9 = (Long)((Iterator)localObject8).next();
        s.s(localObject9, "it");
        ((Collection)localObject3).add(com.tencent.mm.ae.d.hF(((Long)localObject9).longValue()));
      }
      localObject2 = ((StringBuilder)localObject2).append((List)localObject3).append(' ');
      localObject8 = (Iterable)localObject4;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject8, 10));
      localObject8 = ((Iterable)localObject8).iterator();
      while (((Iterator)localObject8).hasNext()) {
        ((Collection)localObject3).add(com.tencent.mm.ae.d.hF(((cc)((Iterator)localObject8).next()).bZA()));
      }
      localObject2 = ((StringBuilder)localObject2).append((List)localObject3).append('}');
      localObject8 = (Iterable)localObject4;
      localObject3 = (Collection)new ArrayList();
      localObject8 = ((Iterable)localObject8).iterator();
      label2454:
      label2493:
      label2498:
      label2527:
      label2539:
      label2542:
      while (((Iterator)localObject8).hasNext())
      {
        localObject9 = ((Iterator)localObject8).next();
        localObject10 = (cc)localObject9;
        Object localObject11 = (List)paramd.Bex;
        j = 0;
        localObject11 = ((List)localObject11).iterator();
        if (((Iterator)localObject11).hasNext()) {
          if (((cc)((Iterator)localObject11).next()).bZA() == ((cc)localObject10).bZA())
          {
            m = 1;
            if (m == 0) {
              break label2527;
            }
            if (j >= 0) {
              break label2539;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label2542;
          }
          ((Collection)localObject3).add(localObject9);
          break;
          m = 0;
          break label2493;
          j += 1;
          break label2454;
          j = -1;
          break label2498;
        }
      }
      localObject8 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject8, 10));
      localObject8 = ((Iterable)localObject8).iterator();
      while (((Iterator)localObject8).hasNext()) {
        ((Collection)localObject3).add(com.tencent.mm.ae.d.hF(((cc)((Iterator)localObject8).next()).bZA()));
      }
      Log.e("Finder.HandleLayoutInfoInterceptor", (List)localObject3);
      paramd.Bex.clear();
      paramd.Bex.addAll((Collection)localObject5);
    }
    for (;;)
    {
      Log.i("Finder.HandleLayoutInfoInterceptor", "[handle] checkCount[" + i + "] dividerCount[" + ((LinkedList)localObject7).size() + "] cardCount[" + ((List)localObject6).size() + "] streamCount=" + ((LinkedList)localObject4).size() + " historyCount=" + ((LinkedList)localObject1).size() + " result=" + paramd.Bex.size() + " historyIndex=" + k);
      break;
      paramd.Bex.addAll((Collection)localObject1);
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
  {
    AppMethodBeat.i(336827);
    s.u(paramd, "loadedInfo");
    AppMethodBeat.o(336827);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "id", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Long, Boolean>
  {
    b(List<? extends bwc> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<bwc, Boolean>
  {
    public static final c AFb;
    
    static
    {
      AppMethodBeat.i(336747);
      AFb = new c();
      AppMethodBeat.o(336747);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<cc, Boolean>
  {
    public static final d AFc;
    
    static
    {
      AppMethodBeat.i(336748);
      AFc = new d();
      AppMethodBeat.o(336748);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.e
 * JD-Core Version:    0.7.0.1
 */