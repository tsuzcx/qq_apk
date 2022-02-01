package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.interceptor.e;
import com.tencent.mm.plugin.finder.model.bj;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.nearby.trace.b.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;)V", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "fetch", "", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "fetchInternal", "handleLayoutInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "srcObjectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "incrementRVList", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "onFetchDone", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "Callback", "Companion", "plugin-finder-nearby_release"})
public final class c
  extends com.tencent.mm.plugin.finder.life.a
  implements a.a
{
  public static final b zDS;
  com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xbq;
  private final bid xbu;
  private a zDR;
  
  static
  {
    AppMethodBeat.i(200108);
    zDS = new b((byte)0);
    AppMethodBeat.o(200108);
  }
  
  public c(bid parambid)
  {
    AppMethodBeat.i(200107);
    this.xbu = parambid;
    this.xbq = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(200107);
  }
  
  private static ArrayList<bu> a(LinkedList<FinderObject> paramLinkedList, ArrayList<bu> paramArrayList, bjt parambjt)
  {
    AppMethodBeat.i(200106);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() == parambjt.SUa.size())
    {
      Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo return for incrementList:" + paramArrayList.size() + " layoutInfo size:" + parambjt.SUa);
      AppMethodBeat.o(200106);
      return paramArrayList;
    }
    int i = 0;
    Object localObject1 = parambjt.SUa;
    p.j(localObject1, "layoutInfo.layoutIds");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int j = 0;
    int m = 0;
    Long localLong;
    Object localObject2;
    label137:
    long l;
    label173:
    int k;
    if (localIterator.hasNext())
    {
      localLong = (Long)localIterator.next();
      localObject2 = ((Iterable)paramArrayList).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        l = ((bu)localObject1).mf();
        if (localLong == null)
        {
          k = 0;
          label176:
          if (k == 0) {
            break label442;
          }
          label181:
          localObject1 = (bu)localObject1;
          k = m;
          if (localObject1 != null) {
            k = m + 1;
          }
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label584;
          }
          localObject2 = localObject1;
          if (parambjt.STB.size() == 0) {
            break label584;
          }
          localObject1 = parambjt.STB;
          p.j(localObject1, "layoutInfo.divider");
          localObject2 = ((Iterable)localObject1).iterator();
          label251:
          if (!((Iterator)localObject2).hasNext()) {
            break label467;
          }
          localObject1 = ((Iterator)localObject2).next();
          l = ((bjr)localObject1).zAO;
          if (localLong != null) {
            break label450;
          }
          label285:
          m = 0;
          label288:
          if (m == 0) {
            break label465;
          }
          label293:
          localObject1 = (bjr)localObject1;
          if (localObject1 == null) {
            break label473;
          }
          localObject1 = e.a((bjr)localObject1);
          label312:
          localObject2 = localObject1;
          if (localObject1 == null) {
            break label584;
          }
          localObject2 = localObject1;
          if (!(localObject1 instanceof bj)) {
            break label584;
          }
          ((bj)localObject1).index = i;
          Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo find divider: id:" + ((bu)localObject1).bAQ() + " wording:" + ((bj)localObject1).xzB.wording + " index:" + i);
          j += 1;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localArrayList.add(localObject1);
        i += 1;
      }
      for (;;)
      {
        m = k;
        break;
        if (l != localLong.longValue()) {
          break label173;
        }
        k = 1;
        break label176;
        label442:
        break label137;
        localObject1 = null;
        break label181;
        label450:
        if (l != localLong.longValue()) {
          break label285;
        }
        m = 1;
        break label288;
        label465:
        break label251;
        label467:
        localObject1 = null;
        break label293;
        label473:
        localObject1 = null;
        break label312;
        Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo mergeListSize:" + localArrayList.size() + ' ' + "incrementList:" + paramArrayList.size() + " layoutInfo size:" + parambjt.SUa.size() + ' ' + "srcSize:" + paramLinkedList.size() + " feedCount:" + m + " dividerCount:" + j);
        AppMethodBeat.o(200106);
        return localArrayList;
      }
      label584:
      localObject1 = localObject2;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, awp paramawp, NearbyLiveFeedLoader.b paramb)
  {
    AppMethodBeat.i(200102);
    p.k(paramawp, "resp");
    p.k(paramb, "request");
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
    b.a.OL(paramb.zDV).zJw = System.currentTimeMillis();
    localObject1 = new NearbyLiveFeedLoader.c(paramInt1, paramInt2, paramString, (byte)0);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = paramawp.object;
      p.j(paramString, "resp.`object`");
      Object localObject2 = (Iterable)paramString;
      paramString = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (FinderObject)localObject3;
        aj localaj = aj.AGc;
        p.j(localObject4, "it");
        if (aj.a((FinderObject)localObject4, "Finder.FinderLiveFriendsFeedFetcher")) {
          paramString.add(localObject3);
        }
      }
      paramString = (List)paramString;
      if (paramString.size() < paramawp.object.size()) {
        Log.e("Finder.FinderLiveFriendsFeedFetcher", "[onCgiBack] has filter some feed. valid=" + paramString.size() + " raw=" + paramawp.object.size());
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      localObject2 = aj.AGc;
      localObject2 = (Iterable)com.tencent.mm.plugin.finder.storage.logic.c.a.a(paramString, aj.QY(paramb.fEH), this.xbu);
      paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FinderItem)((Iterator)localObject2).next();
        localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        paramString.add(com.tencent.mm.plugin.finder.storage.logic.c.a.a((FinderItem)localObject3));
      }
      localObject2 = new ArrayList((Collection)paramString);
      paramString = d.zJm;
      d.l(paramb.xkX, (List)localObject2);
      Object localObject3 = new StringBuilder("incrementList size: ");
      paramString = ((NearbyLiveFeedLoader.c)localObject1).getIncrementList();
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.size());
        Log.i("Finder.FinderLiveFriendsFeedFetcher", paramString);
        paramString = paramawp.SIh;
        if (paramString == null) {
          break label541;
        }
        localObject3 = paramawp.object;
        p.j(localObject3, "resp.`object`");
        paramString = a((LinkedList)localObject3, (ArrayList)localObject2, paramString);
        if (paramString == null) {
          break label541;
        }
        paramString = (List)paramString;
        label447:
        ((NearbyLiveFeedLoader.c)localObject1).setIncrementList(paramString);
        ((NearbyLiveFeedLoader.c)localObject1).setPullType(paramb.pullType);
        ((NearbyLiveFeedLoader.c)localObject1).setLastBuffer(paramawp.SDI);
        if (paramawp.xFI == 0) {
          break label550;
        }
      }
      label541:
      label550:
      for (boolean bool = true;; bool = false)
      {
        ((NearbyLiveFeedLoader.c)localObject1).setHasMore(bool);
        ((NearbyLiveFeedLoader.c)localObject1).zEa = paramawp.SJl;
        ((NearbyLiveFeedLoader.c)localObject1).zEb = paramawp.SHA;
        paramString = this.zDR;
        if (paramString == null) {
          break label556;
        }
        paramString.a((NearbyLiveFeedLoader.c)localObject1, paramb);
        AppMethodBeat.o(200102);
        return;
        paramString = null;
        break;
        paramString = (List)localObject2;
        break label447;
      }
      label556:
      AppMethodBeat.o(200102);
      return;
    }
    ((NearbyLiveFeedLoader.c)localObject1).setHasMore(false);
    paramString = this.zDR;
    if (paramString != null)
    {
      paramString.a((NearbyLiveFeedLoader.c)localObject1, paramb);
      AppMethodBeat.o(200102);
      return;
    }
    AppMethodBeat.o(200102);
  }
  
  public final void a(NearbyLiveFeedLoader.b paramb, a parama, ab.c paramc)
  {
    AppMethodBeat.i(200100);
    p.k(paramb, "request");
    p.k(parama, "callback");
    this.zDR = parama;
    parama = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
    b.a.OL(paramb.zDV).zJv = System.currentTimeMillis();
    new a(paramb, (a.a)this, paramc, this.xbu).bhW().a((com.tencent.mm.vending.e.b)this.xbq);
    Log.i("Finder.FinderLiveFriendsFeedFetcher", "fetchInternal request:".concat(String.valueOf(paramb)));
    AppMethodBeat.o(200100);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "", "onFetchDone", "", "resp", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "plugin-finder-nearby_release"})
  public static abstract interface a
  {
    public abstract void a(NearbyLiveFeedLoader.c paramc, NearbyLiveFeedLoader.b paramb);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.c
 * JD-Core Version:    0.7.0.1
 */