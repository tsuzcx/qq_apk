package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.aa.e;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.bg;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "checkValid", "", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "rvFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabType", "fakeData", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "handle", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class d
  implements f
{
  public static final a txC;
  
  static
  {
    AppMethodBeat.i(242631);
    txC = new a((byte)0);
    AppMethodBeat.o(242631);
  }
  
  public final boolean a(aa.f paramf)
  {
    AppMethodBeat.i(242628);
    p.h(paramf, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if ((((Number)com.tencent.mm.plugin.finder.storage.c.dtJ().value()).intValue() > 0) && (paramf.cXX().dLS == 1) && (paramf.ttV > 0))
    {
      localObject1 = new bcx();
      Object localObject2 = new bcu();
      ((bcu)localObject2).uOx = 111L;
      ((bcu)localObject2).uOm = false;
      ((bcu)localObject2).LLO = "热门有更多推荐";
      ((bcu)localObject2).IFO = "热门推荐";
      ((bcu)localObject2).tQR = 0;
      ((bcu)localObject2).object.addAll((Collection)paramf.object.subList(0, Math.min(paramf.object.size(), paramf.ttV)));
      ((bcx)localObject1).LEy.add(localObject2);
      localObject2 = ((bcx)localObject1).LMe;
      Object localObject3 = paramf.object.subList(0, paramf.ttV);
      p.g(localObject3, "resp.`object`.subList(0, resp.streamSize)");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((FinderObject)((Iterator)localObject4).next()).id));
      }
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      ((bcx)localObject1).LMe.add(1, Long.valueOf(111L));
      paramf.tUH = ((bcx)localObject1);
    }
    AppMethodBeat.o(242628);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(242629);
    p.h(paramb, "loadedInfo");
    Object localObject1 = paramb.tUH;
    int i = paramb.dLS;
    if (y.a(y.vXH, i, 0, 2)) {
      if (localObject1 != null)
      {
        localObject1 = ((bcx)localObject1).LLI;
        if (localObject1 != null)
        {
          localObject1 = (bcw)j.kt((List)localObject1);
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((bcw)localObject1).LLE);
            if (localObject1 != null) {
              break label120;
            }
            label84:
            i = -6;
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label211;
      }
      Log.w("Finder.HandleLayoutInfoInterceptor", "[handle] ret=".concat(String.valueOf(i)));
      AppMethodBeat.o(242629);
      return false;
      localObject1 = null;
      break;
      label120:
      if (((Integer)localObject1).intValue() != 9) {
        break label84;
      }
      do
      {
        i = 0;
        break;
        if ((i != 1) && (i != 3) && (i != 2))
        {
          i = -5;
          break;
        }
        if (localObject1 == null)
        {
          i = -1;
          break;
        }
        if (((bcx)localObject1).LMe.isEmpty())
        {
          i = -3;
          break;
        }
      } while ((!((bcx)localObject1).LEy.isEmpty()) || (!((bcx)localObject1).LLI.isEmpty()));
      i = -4;
    }
    label211:
    Object localObject5 = paramb.tUH;
    if (localObject5 == null) {
      p.hyc();
    }
    localObject1 = (List)paramb.tUz;
    i = 0;
    localObject1 = ((List)localObject1).iterator();
    label280:
    int k;
    label287:
    LinkedList localLinkedList2;
    label318:
    LinkedList localLinkedList1;
    label341:
    LinkedList localLinkedList3;
    if (((Iterator)localObject1).hasNext()) {
      if (((bo)((Iterator)localObject1).next()).lT() == paramb.ttW)
      {
        j = 1;
        if (j == 0) {
          break label476;
        }
        k = i;
        if (paramb.ttV <= 0) {
          break label489;
        }
        localLinkedList2 = new LinkedList((Collection)paramb.tUz.subList(0, paramb.ttV));
        if (paramb.ttV > 0) {
          break label501;
        }
        localLinkedList1 = new LinkedList((Collection)paramb.tUz);
        localLinkedList3 = new LinkedList((Collection)paramb.tUz);
        localObject1 = ((bcx)localObject5).LEy;
        p.g(localObject1, "layoutInfo.card");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    label400:
    label554:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label556;
      }
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (bcu)localObject3;
      if ((((bcu)localObject4).tQR == 2) || (((bcu)localObject4).tQR == 0) || (((bcu)localObject4).tQR == 1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label554;
        }
        ((Collection)localObject1).add(localObject3);
        break label400;
        j = 0;
        break label280;
        label476:
        i += 1;
        break;
        k = -1;
        break label287;
        label489:
        localLinkedList2 = new LinkedList();
        break label318;
        label501:
        if (k >= 0)
        {
          localLinkedList1 = new LinkedList((Collection)paramb.tUz.subList(k + 1, paramb.tUz.size()));
          break label341;
        }
        localLinkedList1 = new LinkedList();
        break label341;
      }
    }
    label556:
    Object localObject3 = (List)localObject1;
    Object localObject4 = ((bcx)localObject5).LLI;
    localObject1 = new StringBuilder("[handle] dividerObjects=");
    p.g(localObject4, "dividerObjects");
    Object localObject6 = (Iterable)localObject4;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
    localObject6 = ((Iterable)localObject6).iterator();
    Object localObject7;
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (bcw)((Iterator)localObject6).next();
      p.g(localObject7, "it");
      p.h(localObject7, "$this$print");
      ((Collection)localObject2).add(((bcw)localObject7).uOx + '_' + ((bcw)localObject7).LLE + '_' + ((bcw)localObject7).dQx);
    }
    localObject1 = ((StringBuilder)localObject1).append((List)localObject2).append(" cardObjects=");
    localObject6 = (Iterable)localObject3;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
    localObject6 = ((Iterable)localObject6).iterator();
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (bcu)((Iterator)localObject6).next();
      p.g(localObject7, "it");
      ((Collection)localObject2).add(e.a((bcu)localObject7));
    }
    Log.i("Finder.HandleLayoutInfoInterceptor", (List)localObject2);
    localObject1 = (List)localObject4;
    i = 0;
    localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bcw)((Iterator)localObject1).next();
      if ((((bcw)localObject2).LLE == 2) || (((bcw)localObject2).LLE == 1))
      {
        j = 1;
        label896:
        if (j == 0) {
          break label1317;
        }
        label900:
        if (i < 0) {
          break label1329;
        }
        i = 1;
        label906:
        if ((i != 0) && (localLinkedList1.isEmpty()))
        {
          j.c((List)localObject4, (kotlin.g.a.b)b.txD);
          Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] fallback remove history divider");
        }
        paramb.tUz.clear();
        localObject1 = ((bcx)localObject5).LMe;
        p.g(localObject1, "layoutInfo.layoutIds");
        localObject6 = ((Iterable)localObject1).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      label978:
      if (!((Iterator)localObject6).hasNext()) {
        break label1466;
      }
      localObject7 = (Long)((Iterator)localObject6).next();
      localObject2 = ((Iterable)localLinkedList2).iterator();
      long l;
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          l = ((bo)localObject1).lT();
          if (localObject7 == null)
          {
            label1048:
            j = 0;
            label1050:
            if (j == 0) {
              continue;
            }
            label1054:
            localObject2 = (bo)localObject1;
            if (localObject2 != null) {
              break label1384;
            }
            localObject2 = ((Iterable)localObject3).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject1 = ((Iterator)localObject2).next();
                l = ((bcu)localObject1).uOx;
                if (localObject7 == null)
                {
                  label1112:
                  j = 0;
                  label1114:
                  if (j == 0) {
                    continue;
                  }
                  label1118:
                  localObject1 = (bcu)localObject1;
                  if (localObject1 == null) {
                    break label1378;
                  }
                  localObject2 = e.a((bcu)localObject1, paramb.dLS);
                  label1141:
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    localObject2 = ((Iterable)localObject4).iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject2).hasNext())
                      {
                        localObject1 = ((Iterator)localObject2).next();
                        l = ((bcw)localObject1).uOx;
                        if (localObject7 == null)
                        {
                          label1196:
                          j = 0;
                          label1198:
                          if (j == 0) {
                            continue;
                          }
                          label1202:
                          localObject1 = (bcw)localObject1;
                          if (localObject1 == null) {
                            break label1447;
                          }
                          p.h(localObject1, "$this$toRVFeed");
                          switch (((bcw)localObject1).LLE)
                          {
                          default: 
                            localObject1 = (bo)new com.tencent.mm.plugin.finder.feed.x((bcw)localObject1);
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
          break label1453;
        }
        Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] this id[" + localObject7 + "] not match any.");
        break label978;
        j = 0;
        break label896;
        label1317:
        i += 1;
        break;
        i = -1;
        break label900;
        label1329:
        i = 0;
        break label906;
        if (l != ((Long)localObject7).longValue()) {
          break label1048;
        }
        j = 1;
        break label1050;
        localObject1 = null;
        break label1054;
        if (l != ((Long)localObject7).longValue()) {
          break label1112;
        }
        j = 1;
        break label1114;
        localObject1 = null;
        break label1118;
        label1378:
        localObject2 = null;
        break label1141;
        label1384:
        i += 1;
        break label1141;
        if (l != ((Long)localObject7).longValue()) {
          break label1196;
        }
        j = 1;
        break label1198;
        localObject1 = null;
        break label1202;
        localObject1 = (bo)new ai((bcw)localObject1);
        continue;
        localObject1 = (bo)new bg((bcw)localObject1);
        continue;
        label1447:
        localObject1 = null;
      }
      label1453:
      paramb.tUz.add(localObject1);
    }
    label1466:
    localObject2 = ((Iterable)paramb.tUz).iterator();
    int j = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (j < 0) {
        j.hxH();
      }
      localObject1 = (bo)localObject1;
      if (((localObject1 instanceof bg)) && (j + 1 < paramb.tUz.size()))
      {
        localObject6 = paramb.tUz.get(j + 1);
        p.g(localObject6, "loadedInfo.incrementList[index + 1]");
        localObject7 = (bo)localObject6;
        if ((localObject7 instanceof BaseFinderFeed))
        {
          ((BaseFinderFeed)localObject7).streamDivider = ((bg)localObject1).tOP;
          localObject6 = new StringBuilder("[handle] has divider ").append(((bg)localObject1).tOP.LLE).append(" wording=").append(((bg)localObject1).tOP.dQx).append(" nickname=");
          localObject1 = ((BaseFinderFeed)localObject7).contact;
          if (localObject1 == null) {
            break label1684;
          }
        }
      }
      label1684:
      for (localObject1 = ((g)localObject1).getNickname();; localObject1 = null)
      {
        Log.i("Finder.HandleLayoutInfoInterceptor", (String)localObject1);
        j += 1;
        break;
      }
    }
    j.c((List)paramb.tUz, (kotlin.g.a.b)c.txE);
    if (i != localLinkedList2.size())
    {
      localObject1 = new StringBuilder("[handle] checkCount[").append(i).append("] != streamList.size[").append(localLinkedList2.size()).append("] rawObjects.size[").append(localLinkedList3.size()).append("] historyList.size[").append(localLinkedList1.size()).append(']');
      localObject2 = ((bcx)localObject5).LMe;
      p.g(localObject2, "layoutInfo.layoutIds");
      localObject5 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (Long)((Iterator)localObject5).next();
        p.g(localObject6, "it");
        ((Collection)localObject2).add(com.tencent.mm.ac.d.zs(((Long)localObject6).longValue()));
      }
      localObject1 = ((StringBuilder)localObject1).append((List)localObject2).append(' ');
      localObject5 = (Iterable)localLinkedList2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((Collection)localObject2).add(com.tencent.mm.ac.d.zs(((bo)((Iterator)localObject5).next()).lT()));
      }
      localObject1 = ((StringBuilder)localObject1).append((List)localObject2).append('}');
      localObject5 = (Iterable)localLinkedList2;
      localObject2 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
      label2060:
      label2099:
      label2104:
      label2133:
      label2145:
      label2148:
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = ((Iterator)localObject5).next();
        localObject7 = (bo)localObject6;
        Object localObject8 = (List)paramb.tUz;
        j = 0;
        localObject8 = ((List)localObject8).iterator();
        int m;
        if (((Iterator)localObject8).hasNext()) {
          if (((bo)((Iterator)localObject8).next()).lT() == ((bo)localObject7).lT())
          {
            m = 1;
            if (m == 0) {
              break label2133;
            }
            if (j >= 0) {
              break label2145;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label2148;
          }
          ((Collection)localObject2).add(localObject6);
          break;
          m = 0;
          break label2099;
          j += 1;
          break label2060;
          j = -1;
          break label2104;
        }
      }
      localObject5 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((Collection)localObject2).add(com.tencent.mm.ac.d.zs(((bo)((Iterator)localObject5).next()).lT()));
      }
      localObject1 = (List)localObject2;
      Log.e("Finder.HandleLayoutInfoInterceptor", (String)localObject1);
      f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "layoutIdError", (a)new d((String)localObject1));
      if (BuildInfo.IS_FLAVOR_PURPLE) {
        com.tencent.mm.ac.d.h((a)e.txG);
      }
      paramb.tUz.clear();
      paramb.tUz.addAll((Collection)localLinkedList3);
    }
    for (;;)
    {
      Log.i("Finder.HandleLayoutInfoInterceptor", "[handle] checkCount[" + i + "] dividerCount[" + ((LinkedList)localObject4).size() + "] cardCount[" + ((List)localObject3).size() + "] streamCount=" + localLinkedList2.size() + " historyCount=" + localLinkedList1.size() + " result=" + paramb.tUz.size() + " historyIndex=" + k);
      break;
      paramb.tUz.addAll((Collection)localLinkedList1);
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
  {
    AppMethodBeat.i(242630);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(242630);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<bcw, Boolean>
  {
    public static final b txD;
    
    static
    {
      AppMethodBeat.i(242623);
      txD = new b();
      AppMethodBeat.o(242623);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<bo, Boolean>
  {
    public static final c txE;
    
    static
    {
      AppMethodBeat.i(242625);
      txE = new c();
      AppMethodBeat.o(242625);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<String>
  {
    d(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<kotlin.x>
  {
    public static final e txG;
    
    static
    {
      AppMethodBeat.i(242627);
      txG = new e();
      AppMethodBeat.o(242627);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.d
 * JD-Core Version:    0.7.0.1
 */