package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.m.e;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "checkValid", "", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "rvFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabType", "fakeData", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "handle", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class c
  implements f
{
  public static final a rTn;
  
  static
  {
    AppMethodBeat.i(201655);
    rTn = new a((byte)0);
    AppMethodBeat.o(201655);
  }
  
  public final boolean a(m.f paramf)
  {
    AppMethodBeat.i(201652);
    p.h(paramf, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cJS().value()).intValue() > 0) && (paramf.czy().dvm == 1) && (paramf.rQD > 0))
    {
      localObject1 = new asf();
      Object localObject2 = new asd();
      ((asd)localObject2).GIB = 111L;
      ((asd)localObject2).GII = false;
      ((asd)localObject2).GIC = "热门有更多推荐";
      ((asd)localObject2).DUV = "热门推荐";
      ((asd)localObject2).sgH = 2;
      ((asd)localObject2).object.addAll((Collection)paramf.object.subList(0, Math.min(paramf.object.size(), paramf.rQD)));
      ((asf)localObject1).GIN.add(localObject2);
      localObject2 = ((asf)localObject1).GIO;
      Object localObject3 = paramf.object.subList(0, paramf.rQD);
      p.g(localObject3, "resp.`object`.subList(0, resp.streamSize)");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((FinderObject)((Iterator)localObject4).next()).id));
      }
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      ((asf)localObject1).GIO.add(1, Long.valueOf(111L));
      paramf.sjP = ((asf)localObject1);
    }
    AppMethodBeat.o(201652);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201653);
    p.h(paramb, "loadedInfo");
    Object localObject1 = paramb.sjP;
    Object localObject2 = (List)paramb.sjH;
    int k = paramb.dvm;
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
    int j;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKE().value()).intValue() == 0) {
      if (localObject1 != null)
      {
        localObject3 = ((asf)localObject1).GIN;
        if (localObject3 != null)
        {
          localObject3 = (List)localObject3;
          i = 0;
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext()) {
            if (((asd)((Iterator)localObject3).next()).sgH == 2)
            {
              j = 1;
              label116:
              if (j == 0) {
                break label157;
              }
              label120:
              if (i < 0) {
                break label174;
              }
              i = -6;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label346;
      }
      ae.w("Finder.HandleLayoutInfoInterceptor", "[handle] ret=".concat(String.valueOf(i)));
      AppMethodBeat.o(201653);
      return false;
      j = 0;
      break label116;
      label157:
      i += 1;
      break;
      i = -1;
      break label120;
      i = -1;
      break label120;
      label174:
      if ((k != 1) && (k != 3))
      {
        i = -5;
      }
      else if (localObject1 == null)
      {
        i = -1;
      }
      else if (((List)localObject2).isEmpty())
      {
        i = -2;
      }
      else if (((asf)localObject1).GIO.isEmpty())
      {
        i = -3;
      }
      else if ((((asf)localObject1).GIN.isEmpty()) && (((asf)localObject1).GIM.isEmpty()))
      {
        i = -4;
      }
      else
      {
        localObject2 = ((asf)localObject1).GIN;
        p.g(localObject2, "layoutInfo.card");
        if (!((Collection)localObject2).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label341;
          }
          localObject1 = ((asf)localObject1).GIN;
          p.g(localObject1, "layoutInfo.card");
          if (((asd)((LinkedList)localObject1).getFirst()).object.size() >= 3) {
            break label341;
          }
          i = -6;
          break;
        }
        label341:
        i = 0;
      }
    }
    label346:
    localObject1 = paramb.sjP;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject2 = (List)paramb.sjH;
    int i = 0;
    localObject2 = ((List)localObject2).iterator();
    label415:
    label422:
    LinkedList localLinkedList1;
    if (((Iterator)localObject2).hasNext()) {
      if (((am)((Iterator)localObject2).next()).lP() == paramb.rQE)
      {
        j = 1;
        if (j == 0) {
          break label659;
        }
        k = i;
        if (paramb.rQD <= 0) {
          break label672;
        }
        localLinkedList1 = new LinkedList((Collection)paramb.sjH.subList(0, paramb.rQD));
        label453:
        if (paramb.rQD > 0) {
          break label684;
        }
        localObject2 = new LinkedList((Collection)paramb.sjH);
      }
    }
    LinkedList localLinkedList2;
    LinkedList localLinkedList3;
    LinkedList localLinkedList4;
    Object localObject6;
    for (;;)
    {
      localLinkedList2 = new LinkedList((Collection)paramb.sjH);
      localLinkedList3 = ((asf)localObject1).GIN;
      localLinkedList4 = ((asf)localObject1).GIM;
      localObject3 = new StringBuilder("[handle] dividerObjects=");
      p.g(localLinkedList4, "dividerObjects");
      localObject5 = (Iterable)localLinkedList4;
      localObject4 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (ase)((Iterator)localObject5).next();
        p.g(localObject6, "it");
        p.h(localObject6, "$this$print");
        ((Collection)localObject4).add(((ase)localObject6).GIB + '_' + ((ase)localObject6).GIL + '_' + ((ase)localObject6).dyI);
      }
      j = 0;
      break label415;
      label659:
      i += 1;
      break;
      k = -1;
      break label422;
      label672:
      localLinkedList1 = new LinkedList();
      break label453;
      label684:
      if (k >= 0) {
        localObject2 = new LinkedList((Collection)paramb.sjH.subList(k + 1, paramb.sjH.size()));
      } else {
        localObject2 = new LinkedList();
      }
    }
    localObject3 = ((StringBuilder)localObject3).append((List)localObject4).append(" cardObjects=");
    p.g(localLinkedList3, "cardObjects");
    Object localObject5 = (Iterable)localLinkedList3;
    Object localObject4 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (asd)((Iterator)localObject5).next();
      p.g(localObject6, "it");
      p.h(localObject6, "$this$print");
      ((Collection)localObject4).add(((asd)localObject6).GIB + '_' + ((asd)localObject6).object.size() + '_' + ((asd)localObject6).GIC + '_' + ((asd)localObject6).DUV);
    }
    ae.i("Finder.HandleLayoutInfoInterceptor", (List)localObject4);
    localObject3 = (List)localLinkedList4;
    i = 0;
    localObject3 = ((List)localObject3).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ase)((Iterator)localObject3).next();
      if ((((ase)localObject4).GIL == 2) || (((ase)localObject4).GIL == 1))
      {
        j = 1;
        label982:
        if (j == 0) {
          break label1392;
        }
        label986:
        if (i < 0) {
          break label1404;
        }
        i = 1;
        label992:
        if ((i != 0) && (((LinkedList)localObject2).isEmpty()))
        {
          d.a.j.c((List)localLinkedList4, (d.g.a.b)b.yVJ);
          ae.e("Finder.HandleLayoutInfoInterceptor", "[handle] fallback remove history divider");
        }
        paramb.sjH.clear();
        localObject1 = ((asf)localObject1).GIO;
        p.g(localObject1, "layoutInfo.layoutIds");
        localObject4 = ((Iterable)localObject1).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      label1063:
      if (!((Iterator)localObject4).hasNext()) {
        break label1524;
      }
      localObject5 = (Long)((Iterator)localObject4).next();
      localObject3 = ((Iterable)localLinkedList1).iterator();
      long l;
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          l = ((am)localObject1).lP();
          if (localObject5 == null)
          {
            label1133:
            j = 0;
            label1135:
            if (j == 0) {
              continue;
            }
            label1139:
            localObject3 = (am)localObject1;
            if (localObject3 != null) {
              break label1459;
            }
            localObject3 = ((Iterable)localLinkedList3).iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                localObject1 = ((Iterator)localObject3).next();
                l = ((asd)localObject1).GIB;
                if (localObject5 == null)
                {
                  label1197:
                  j = 0;
                  label1199:
                  if (j == 0) {
                    continue;
                  }
                  label1203:
                  localObject1 = (asd)localObject1;
                  if (localObject1 == null) {
                    break label1453;
                  }
                  localObject3 = d.a((asd)localObject1, paramb.dvm);
                  label1226:
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject3 = ((Iterable)localLinkedList4).iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject3).hasNext())
                      {
                        localObject1 = ((Iterator)localObject3).next();
                        l = ((ase)localObject1).GIB;
                        if (localObject5 == null)
                        {
                          label1281:
                          j = 0;
                          label1283:
                          if (j == 0) {
                            continue;
                          }
                          label1287:
                          localObject1 = (ase)localObject1;
                          if (localObject1 == null) {
                            break label1505;
                          }
                          p.h(localObject1, "$this$toRVFeed");
                          switch (((ase)localObject1).GIL)
                          {
                          default: 
                            localObject1 = (am)new com.tencent.mm.plugin.finder.feed.w((ase)localObject1);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label1511;
        }
        ae.e("Finder.HandleLayoutInfoInterceptor", "[handle] this id[" + localObject5 + "] not match any.");
        break label1063;
        j = 0;
        break label982;
        label1392:
        i += 1;
        break;
        i = -1;
        break label986;
        label1404:
        i = 0;
        break label992;
        if (l != ((Long)localObject5).longValue()) {
          break label1133;
        }
        j = 1;
        break label1135;
        localObject1 = null;
        break label1139;
        if (l != ((Long)localObject5).longValue()) {
          break label1197;
        }
        j = 1;
        break label1199;
        localObject1 = null;
        break label1203;
        label1453:
        localObject3 = null;
        break label1226;
        label1459:
        i += 1;
        break label1226;
        if (l != ((Long)localObject5).longValue()) {
          break label1281;
        }
        j = 1;
        break label1283;
        localObject1 = null;
        break label1287;
        localObject1 = (am)new com.tencent.mm.plugin.finder.model.w((ase)localObject1);
        continue;
        label1505:
        localObject1 = null;
      }
      label1511:
      paramb.sjH.add(localObject1);
    }
    label1524:
    if (i != localLinkedList1.size())
    {
      localObject1 = new StringBuilder("[handle] checkCount[").append(i).append("] != streamList.size[").append(localLinkedList1.size()).append("] rawObjects.size[").append(localLinkedList2.size()).append("] historyList.size[").append(((LinkedList)localObject2).size()).append(']');
      localObject4 = (Iterable)localLinkedList1;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        localObject6 = (am)localObject5;
        Object localObject7 = (List)paramb.sjH;
        j = 0;
        localObject7 = ((List)localObject7).iterator();
        int m;
        if (((Iterator)localObject7).hasNext()) {
          if (((am)((Iterator)localObject7).next()).lP() == ((am)localObject6).lP())
          {
            m = 1;
            if (m == 0) {
              break label1743;
            }
            if (j >= 0) {
              break label1755;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label1758;
          }
          ((Collection)localObject3).add(localObject5);
          break;
          m = 0;
          break label1709;
          j += 1;
          break label1670;
          j = -1;
          break label1714;
        }
      }
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((am)((Iterator)localObject4).next()).lP()));
      }
      ae.e("Finder.HandleLayoutInfoInterceptor", (List)localObject3);
      if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) {
        com.tencent.mm.ac.c.h((a)c.DqN);
      }
      paramb.sjH.clear();
      paramb.sjH.addAll((Collection)localLinkedList2);
    }
    for (;;)
    {
      label1670:
      label1709:
      label1714:
      label1743:
      label1755:
      label1758:
      ae.i("Finder.HandleLayoutInfoInterceptor", "[handle] checkCount[" + i + "] dividerCount[" + localLinkedList4.size() + "] cardCount[" + localLinkedList3.size() + "] streamCount=" + localLinkedList1.size() + " historyCount=" + ((LinkedList)localObject2).size() + " result=" + paramb.sjH.size() + " historyIndex=" + k);
      break;
      paramb.sjH.addAll((Collection)localObject2);
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201654);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201654);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final b yVJ;
    
    static
    {
      AppMethodBeat.i(224275);
      yVJ = new b();
      AppMethodBeat.o(224275);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    public static final c DqN;
    
    static
    {
      AppMethodBeat.i(224277);
      DqN = new c();
      AppMethodBeat.o(224277);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.c
 * JD-Core Version:    0.7.0.1
 */