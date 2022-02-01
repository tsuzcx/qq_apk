package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.m.e;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.feed.w;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import d.a.j;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "checkValid", "", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "rvFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabType", "fakeData", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "handle", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class c
  implements e
{
  public static final a rLa;
  
  static
  {
    AppMethodBeat.i(201230);
    rLa = new a((byte)0);
    AppMethodBeat.o(201230);
  }
  
  public final boolean a(m.f paramf)
  {
    AppMethodBeat.i(201227);
    p.h(paramf, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cHW().value()).intValue() > 0) && (paramf.cxX().duh == 1) && (paramf.rIs > 0))
    {
      localObject1 = new arq();
      Object localObject2 = new aro();
      ((aro)localObject2).Gpl = 111L;
      ((aro)localObject2).Gpm = "热门有更多推荐";
      ((aro)localObject2).DCX = "热门推荐";
      ((aro)localObject2).object.addAll((Collection)paramf.object.subList(0, Math.min(paramf.object.size(), paramf.rIs)));
      ((arq)localObject1).Gpt.add(localObject2);
      localObject2 = ((arq)localObject1).Gpu;
      Object localObject3 = paramf.object.subList(0, paramf.rIs);
      p.g(localObject3, "resp.`object`.subList(0, resp.streamSize)");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((FinderObject)((Iterator)localObject4).next()).id));
      }
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      ((arq)localObject1).Gpu.add(1, Long.valueOf(111L));
      paramf.sba = ((arq)localObject1);
    }
    AppMethodBeat.o(201227);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201228);
    p.h(paramb, "loadedInfo");
    Object localObject1 = paramb.sba;
    Object localObject2 = (List)paramb.saR;
    int i = paramb.duh;
    if ((i != 1) && (i != 3)) {
      i = -5;
    }
    while (i < 0)
    {
      ad.w("Finder.HandleLayoutInfoInterceptor", "[handle] ret=".concat(String.valueOf(i)));
      AppMethodBeat.o(201228);
      return false;
      if (localObject1 == null)
      {
        i = -1;
      }
      else if (((List)localObject2).isEmpty())
      {
        i = -2;
      }
      else if (((arq)localObject1).Gpu.isEmpty())
      {
        i = -3;
      }
      else if ((((arq)localObject1).Gpt.isEmpty()) && (((arq)localObject1).Gps.isEmpty()))
      {
        i = -4;
      }
      else
      {
        localObject2 = ((arq)localObject1).Gpt;
        p.g(localObject2, "layoutInfo.card");
        if (!((Collection)localObject2).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label216;
          }
          localObject1 = ((arq)localObject1).Gpt;
          p.g(localObject1, "layoutInfo.card");
          if (((aro)((LinkedList)localObject1).getFirst()).object.size() >= 3) {
            break label216;
          }
          i = -6;
          break;
        }
        label216:
        i = 0;
      }
    }
    localObject1 = paramb.sba;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject2 = (List)paramb.saR;
    i = 0;
    localObject2 = ((List)localObject2).iterator();
    int j;
    label290:
    int k;
    label297:
    LinkedList localLinkedList1;
    if (((Iterator)localObject2).hasNext()) {
      if (((al)((Iterator)localObject2).next()).lP() == paramb.rIt)
      {
        j = 1;
        if (j == 0) {
          break label534;
        }
        k = i;
        if (paramb.rIs <= 0) {
          break label547;
        }
        localLinkedList1 = new LinkedList((Collection)paramb.saR.subList(0, paramb.rIs));
        label328:
        if (paramb.rIs > 0) {
          break label559;
        }
        localObject2 = new LinkedList((Collection)paramb.saR);
      }
    }
    LinkedList localLinkedList2;
    LinkedList localLinkedList3;
    LinkedList localLinkedList4;
    Object localObject6;
    for (;;)
    {
      localLinkedList2 = new LinkedList((Collection)paramb.saR);
      localLinkedList3 = ((arq)localObject1).Gpt;
      localLinkedList4 = ((arq)localObject1).Gps;
      localObject3 = new StringBuilder("[handle] dividerObjects=");
      p.g(localLinkedList4, "dividerObjects");
      localObject5 = (Iterable)localLinkedList4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (arp)((Iterator)localObject5).next();
        p.g(localObject6, "it");
        p.h(localObject6, "$this$print");
        ((Collection)localObject4).add(((arp)localObject6).Gpl + '_' + ((arp)localObject6).Gpr + '_' + ((arp)localObject6).dxD);
      }
      j = 0;
      break label290;
      label534:
      i += 1;
      break;
      k = -1;
      break label297;
      label547:
      localLinkedList1 = new LinkedList();
      break label328;
      label559:
      if (k >= 0) {
        localObject2 = new LinkedList((Collection)paramb.saR.subList(k + 1, paramb.saR.size()));
      } else {
        localObject2 = new LinkedList();
      }
    }
    Object localObject3 = ((StringBuilder)localObject3).append((List)localObject4).append(" cardObjects=");
    p.g(localLinkedList3, "cardObjects");
    Object localObject5 = (Iterable)localLinkedList3;
    Object localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (aro)((Iterator)localObject5).next();
      p.g(localObject6, "it");
      p.h(localObject6, "$this$print");
      ((Collection)localObject4).add(((aro)localObject6).Gpl + '_' + ((aro)localObject6).object.size() + '_' + ((aro)localObject6).Gpm + '_' + ((aro)localObject6).DCX);
    }
    ad.i("Finder.HandleLayoutInfoInterceptor", (List)localObject4);
    paramb.saR.clear();
    localObject1 = ((arq)localObject1).Gpu;
    p.g(localObject1, "layoutInfo.layoutIds");
    localObject4 = ((Iterable)localObject1).iterator();
    i = 0;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Long)((Iterator)localObject4).next();
      localObject3 = ((Iterable)localLinkedList1).iterator();
      long l;
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          l = ((al)localObject1).lP();
          if (localObject5 == null)
          {
            label903:
            j = 0;
            label905:
            if (j == 0) {
              continue;
            }
            label909:
            localObject3 = (al)localObject1;
            if (localObject3 != null) {
              break label1201;
            }
            localObject3 = ((Iterable)localLinkedList3).iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                localObject1 = ((Iterator)localObject3).next();
                l = ((aro)localObject1).Gpl;
                if (localObject5 == null)
                {
                  label967:
                  j = 0;
                  label969:
                  if (j == 0) {
                    continue;
                  }
                  label973:
                  localObject1 = (aro)localObject1;
                  if (localObject1 == null) {
                    break label1195;
                  }
                  localObject3 = d.a((aro)localObject1);
                  label992:
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject3 = ((Iterable)localLinkedList4).iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject3).hasNext())
                      {
                        localObject1 = ((Iterator)localObject3).next();
                        l = ((arp)localObject1).Gpl;
                        if (localObject5 == null)
                        {
                          label1047:
                          j = 0;
                          label1049:
                          if (j == 0) {
                            continue;
                          }
                          label1053:
                          localObject1 = (arp)localObject1;
                          if (localObject1 == null) {
                            break label1247;
                          }
                          p.h(localObject1, "$this$toRVFeed");
                          switch (((arp)localObject1).Gpr)
                          {
                          default: 
                            localObject1 = (al)new w((arp)localObject1);
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
          break label1253;
        }
        ad.e("Finder.HandleLayoutInfoInterceptor", "[handle] this id[" + localObject5 + "] not match any.");
        break;
        if (l != ((Long)localObject5).longValue()) {
          break label903;
        }
        j = 1;
        break label905;
        localObject1 = null;
        break label909;
        if (l != ((Long)localObject5).longValue()) {
          break label967;
        }
        j = 1;
        break label969;
        localObject1 = null;
        break label973;
        label1195:
        localObject3 = null;
        break label992;
        label1201:
        i += 1;
        break label992;
        if (l != ((Long)localObject5).longValue()) {
          break label1047;
        }
        j = 1;
        break label1049;
        localObject1 = null;
        break label1053;
        localObject1 = (al)new v((arp)localObject1);
        continue;
        label1247:
        localObject1 = null;
      }
      label1253:
      paramb.saR.add(localObject1);
    }
    if (i != localLinkedList1.size())
    {
      localObject1 = new StringBuilder("[handle] checkCount[").append(i).append("] != streamList.size[").append(localLinkedList1.size()).append("] rawObjects.size[").append(localLinkedList2.size()).append("] historyList.size[").append(((LinkedList)localObject2).size()).append(']');
      localObject4 = (Iterable)localLinkedList1;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label1412:
      label1451:
      label1456:
      label1485:
      label1497:
      label1500:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        localObject6 = (al)localObject5;
        Object localObject7 = (List)paramb.saR;
        j = 0;
        localObject7 = ((List)localObject7).iterator();
        int m;
        if (((Iterator)localObject7).hasNext()) {
          if (((al)((Iterator)localObject7).next()).lP() == ((al)localObject6).lP())
          {
            m = 1;
            if (m == 0) {
              break label1485;
            }
            if (j >= 0) {
              break label1497;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label1500;
          }
          ((Collection)localObject3).add(localObject5);
          break;
          m = 0;
          break label1451;
          j += 1;
          break label1412;
          j = -1;
          break label1456;
        }
      }
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((al)((Iterator)localObject4).next()).lP()));
      }
      ad.e("Finder.HandleLayoutInfoInterceptor", (List)localObject3);
      if (i.IS_FLAVOR_PURPLE) {
        com.tencent.mm.ad.c.g((a)b.rLb);
      }
      paramb.saR.clear();
      paramb.saR.addAll((Collection)localLinkedList2);
    }
    for (;;)
    {
      ad.i("Finder.HandleLayoutInfoInterceptor", "[handle] checkCount[" + i + "] dividerCount[" + localLinkedList4.size() + "] cardCount[" + localLinkedList3.size() + "] streamCount=" + localLinkedList1.size() + " historyCount=" + ((LinkedList)localObject2).size() + " result=" + paramb.saR.size() + " historyIndex=" + k);
      break;
      paramb.saR.addAll((Collection)localObject2);
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201229);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201229);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    public static final b rLb;
    
    static
    {
      AppMethodBeat.i(201226);
      rLb = new b();
      AppMethodBeat.o(201226);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.c
 * JD-Core Version:    0.7.0.1
 */