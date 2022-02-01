package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.bk;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;)V", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "fetch", "", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "consume", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$CgiConsumeCallback;", "fetchInternal", "handleLayoutInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "srcObjectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "incrementRVList", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "onFetchDone", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "cgiProfile", "Lcom/tencent/mm/protocal/protobuf/CgiProfile;", "Callback", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.life.a
  implements a.a
{
  public static final b EIm;
  com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  private final bui Auc;
  a EIn;
  
  static
  {
    AppMethodBeat.i(340651);
    EIm = new b((byte)0);
    AppMethodBeat.o(340651);
  }
  
  public c(bui parambui)
  {
    AppMethodBeat.i(340617);
    this.Auc = parambui;
    this.AAh = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(340617);
  }
  
  private final ArrayList<cc> a(LinkedList<FinderObject> paramLinkedList, ArrayList<cc> paramArrayList, bwe parambwe)
  {
    AppMethodBeat.i(340642);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() == parambwe.aaeh.size())
    {
      Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo return for incrementList:" + paramArrayList.size() + " layoutInfo size:" + parambwe.aaeh);
      AppMethodBeat.o(340642);
      return paramArrayList;
    }
    Object localObject1 = parambwe.aaeh;
    s.s(localObject1, "layoutInfo.layoutIds");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int k = 0;
    int i = 0;
    int m = 0;
    int j = 0;
    Long localLong;
    Object localObject2;
    label141:
    long l;
    label177:
    int n;
    if (localIterator.hasNext())
    {
      localLong = (Long)localIterator.next();
      localObject2 = ((Iterable)paramArrayList).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        l = ((cc)localObject1).bZA();
        if (localLong == null)
        {
          n = 0;
          label180:
          if (n == 0) {
            break label1016;
          }
          label185:
          localObject2 = (cc)localObject1;
          if (localObject2 == null) {
            break label1350;
          }
          m += 1;
        }
      }
    }
    label277:
    label280:
    label285:
    label418:
    label576:
    label579:
    label1350:
    for (;;)
    {
      label243:
      Object localObject3;
      Object localObject4;
      if ((localObject2 == null) && (parambwe.aaei.size() != 0))
      {
        localObject1 = parambwe.aaei;
        s.s(localObject1, "layoutInfo.live_card");
        localObject2 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          l = ((bmz)localObject1).ZVF;
          if (localLong == null)
          {
            n = 0;
            if (n == 0) {
              break label1039;
            }
            localObject2 = (bmz)localObject1;
            if (localObject2 == null) {
              break label1145;
            }
            localObject1 = this.Auc;
            s.u(localObject2, "<this>");
            if (((bmz)localObject2).style != 2) {
              break label1067;
            }
            localObject3 = ((bmz)localObject2).ZIo;
            if (localObject3 == null) {
              break label1067;
            }
            localObject4 = d.FND;
            localObject3 = (FinderItem)p.oK(d.a.a(p.listOf(localObject3), 0, (bui)localObject1));
            localObject4 = new bna();
            localObject1 = ((bmz)localObject2).ZVI;
            if (localObject1 != null) {
              break label1047;
            }
            localObject1 = null;
            label379:
            localObject2 = ((bmz)localObject2).ZVI;
            if (localObject2 != null) {
              break label1057;
            }
            localObject2 = null;
            localObject1 = (cc)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.c((FinderItem)localObject3, (bna)localObject4, true, (String)localObject1, (String)localObject2, 2022);
            if ((localObject1 == null) || (!(localObject1 instanceof bk))) {
              break label1340;
            }
            Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo find divider: id:" + localLong + " type:2021 name:" + ((bk)localObject1).feedObject.getFeedObject().nickname);
            i += 1;
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        n = i;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          n = i;
          if (parambwe.aadF.size() != 0)
          {
            localObject1 = parambwe.aadF;
            s.s(localObject1, "layoutInfo.divider");
            localObject2 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label1168;
            }
            localObject1 = ((Iterator)localObject2).next();
            l = ((bwc)localObject1).ECY;
            if (localLong != null) {
              break label1151;
            }
            n = 0;
            if (n == 0) {
              break label1166;
            }
            label584:
            localObject1 = (bwc)localObject1;
            if (localObject1 != null) {
              break label1174;
            }
            localObject2 = null;
            label599:
            localObject1 = localObject2;
            n = i;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              n = i;
              if ((localObject2 instanceof bn))
              {
                ((bn)localObject2).index = j;
                Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo find divider: id:" + localLong + " type:" + ((bn)localObject2).AWZ.aadB + " dividerSize:" + parambwe.aadF.size() + " wording:" + ((bn)localObject2).AWZ.wording + " index:" + j);
                n = i + 1;
                localObject1 = localObject2;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (parambwe.ZLJ.size() != 0)
          {
            localObject1 = parambwe.ZLJ;
            s.s(localObject1, "layoutInfo.card");
            localObject2 = ((Iterable)localObject1).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = ((Iterator)localObject2).next();
              l = ((bwa)localObject1).ECY;
              if (localLong == null)
              {
                i = 0;
                if (i == 0) {
                  break label1199;
                }
                localObject1 = (bwa)localObject1;
                if (localObject1 != null) {
                  break label1207;
                }
                localObject1 = null;
                label843:
                localObject2 = localObject1;
                if (localObject1 == null) {
                  break label1329;
                }
                localObject2 = localObject1;
                if (!(localObject1 instanceof au)) {
                  break label1329;
                }
                localObject2 = (au)localObject1;
                ((au)localObject2).position = j;
                Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo find card: id:" + localLong + " type:" + ((au)localObject1).bZB() + " pos:" + ((au)localObject2).position + " cardSize:" + parambwe.ZLJ.size() + " size:" + ((au)localObject2).rvFeedList.size());
                i = k + 1;
              }
            }
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localArrayList.add(localObject1);
            j += 1;
          }
          for (;;)
          {
            k = i;
            i = n;
            break;
            if (l != localLong.longValue()) {
              break label177;
            }
            n = 1;
            break label180;
            label1016:
            break label141;
            localObject1 = null;
            break label185;
            if (l != localLong.longValue()) {
              break label277;
            }
            n = 1;
            break label280;
            break label243;
            localObject1 = null;
            break label285;
            localObject1 = ((atw)localObject1).wording;
            break label379;
            localObject2 = ((atw)localObject2).ZDM;
            break label394;
            localObject3 = ((bmz)localObject2).ZIo;
            if (localObject3 != null)
            {
              localObject4 = d.FND;
              localObject1 = (FinderItem)p.oK(d.a.a(p.listOf(localObject3), 0, (bui)localObject1));
              localObject3 = ((bmz)localObject2).ZVH;
              s.s(localObject3, "relate_living");
              localObject1 = (cc)new bk((FinderItem)localObject1, (List)localObject3, ((bmz)localObject2).ZVK);
              break label418;
            }
            label1145:
            localObject1 = null;
            break label418;
            label1151:
            if (l != localLong.longValue()) {
              break label576;
            }
            n = 1;
            break label579;
            break label542;
            localObject1 = null;
            break label584;
            localObject2 = com.tencent.mm.plugin.finder.cgi.interceptor.f.a((bwc)localObject1);
            break label599;
            if (l != localLong.longValue()) {
              break label820;
            }
            i = 1;
            break label823;
            break label786;
            localObject1 = null;
            break label828;
            localObject1 = com.tencent.mm.plugin.finder.cgi.interceptor.f.b((bwa)localObject1, -1);
            break label843;
            Log.i("Finder.FinderLiveFriendsFeedFetcher", "handleLayoutInfo mergeListSize:" + localArrayList.size() + " incrementList:" + paramArrayList.size() + " layoutInfo size:" + parambwe.aaeh.size() + " srcSize:" + paramLinkedList.size() + " feedCount:" + m + " dividerCount:" + i + " cardCount:" + k);
            AppMethodBeat.o(340642);
            return localArrayList;
          }
          i = k;
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, bck parambck, NearbyLiveFeedLoader.c paramc, yf paramyf)
  {
    AppMethodBeat.i(340671);
    s.u(parambck, "resp");
    s.u(paramc, "request");
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(paramc.EIr).ERy = System.currentTimeMillis();
    localObject1 = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
    int i = paramc.hJx;
    localObject1 = parambck.ZIF;
    Object localObject2 = com.tencent.mm.plugin.finder.nearby.report.b.Rb(i);
    if (localObject2 != null)
    {
      Log.i("FinderNearbyLiveLoadingReporter", s.X("onCgiBack tabType: ", Integer.valueOf(i)));
      ((com.tencent.mm.plugin.finder.nearby.report.b.a)localObject2).EQD = cn.bDw();
      ((com.tencent.mm.plugin.finder.nearby.report.b.a)localObject2).EQI = ((com.tencent.mm.bx.b)localObject1);
      ((com.tencent.mm.plugin.finder.nearby.report.b.a)localObject2).EQQ = paramyf;
    }
    localObject2 = new NearbyLiveFeedLoader.d(paramInt1, paramInt2, paramString, (byte)0);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = parambck.object;
      s.s(paramString, "resp.`object`");
      paramyf = (Iterable)paramString;
      paramString = (Collection)new ArrayList();
      paramyf = paramyf.iterator();
      Object localObject3;
      while (paramyf.hasNext())
      {
        localObject1 = paramyf.next();
        localObject3 = (FinderObject)localObject1;
        av localav = av.GiL;
        s.s(localObject3, "it");
        if (av.a((FinderObject)localObject3, "Finder.FinderLiveFriendsFeedFetcher")) {
          paramString.add(localObject1);
        }
      }
      paramString = (List)paramString;
      if (paramString.size() < parambck.object.size()) {
        Log.e("Finder.FinderLiveFriendsFeedFetcher", "[onCgiBack] has filter some feed. valid=" + paramString.size() + " raw=" + parambck.object.size());
      }
      paramyf = d.FND;
      paramyf = av.GiL;
      paramyf = (Iterable)d.a.a(paramString, av.Ui(paramc.hJx), this.Auc);
      paramString = (Collection)new ArrayList(p.a(paramyf, 10));
      paramyf = paramyf.iterator();
      while (paramyf.hasNext())
      {
        localObject1 = (FinderItem)paramyf.next();
        localObject3 = d.FND;
        paramString.add(d.a.a((FinderItem)localObject1));
      }
      localObject1 = new ArrayList((Collection)paramString);
      paramString = e.EQU;
      e.G(paramc.AJo, (List)localObject1);
      paramString = ((NearbyLiveFeedLoader.d)localObject2).getIncrementList();
      if (paramString == null)
      {
        paramString = null;
        Log.i("Finder.FinderLiveFriendsFeedFetcher", s.X("incrementList size: ", paramString));
        paramString = parambck.ZLL;
        if (paramString != null) {
          break label595;
        }
        paramString = null;
        label467:
        paramyf = paramString;
        if (paramString == null) {
          paramyf = (yf)localObject1;
        }
        ((NearbyLiveFeedLoader.d)localObject2).setIncrementList((List)paramyf);
        ((NearbyLiveFeedLoader.d)localObject2).setPullType(paramc.pullType);
        ((NearbyLiveFeedLoader.d)localObject2).setLastBuffer(parambck.ZEQ);
        if (parambck.BeA == 0) {
          break label623;
        }
      }
      label595:
      label623:
      for (boolean bool = true;; bool = false)
      {
        ((NearbyLiveFeedLoader.d)localObject2).setHasMore(bool);
        ((NearbyLiveFeedLoader.d)localObject2).EIH = parambck.ZNv;
        ((NearbyLiveFeedLoader.d)localObject2).EII = parambck.ZKX;
        ((NearbyLiveFeedLoader.d)localObject2).setRefreshInterval(parambck.wrl);
        paramString = this.EIn;
        if (paramString == null) {
          break label654;
        }
        paramString.a((NearbyLiveFeedLoader.d)localObject2, paramc);
        AppMethodBeat.o(340671);
        return;
        paramString = Integer.valueOf(paramString.size());
        break;
        paramyf = parambck.object;
        s.s(paramyf, "resp.`object`");
        paramString = a(paramyf, (ArrayList)localObject1, paramString);
        break label467;
      }
    }
    ((NearbyLiveFeedLoader.d)localObject2).setHasMore(false);
    paramString = this.EIn;
    if (paramString != null) {
      paramString.a((NearbyLiveFeedLoader.d)localObject2, paramc);
    }
    label654:
    AppMethodBeat.o(340671);
  }
  
  public final void a(NearbyLiveFeedLoader.c paramc, a parama, NearbyLiveFeedLoader.a parama1)
  {
    AppMethodBeat.i(340659);
    s.u(paramc, "request");
    s.u(parama, "callback");
    this.EIn = parama;
    parama = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(paramc.EIr).ERx = System.currentTimeMillis();
    parama = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
    int i = paramc.pullType;
    int j = paramc.hJx;
    if (com.tencent.mm.plugin.finder.nearby.report.b.Rc(i)) {
      com.tencent.mm.plugin.finder.nearby.report.b.EQy.remove(Integer.valueOf(j));
    }
    for (;;)
    {
      new a(paramc, (a.a)this, parama1, this.Auc).bFJ().a((com.tencent.mm.vending.e.b)this.AAh);
      Log.i("Finder.FinderLiveFriendsFeedFetcher", s.X("fetchInternal request:", paramc));
      AppMethodBeat.o(340659);
      return;
      parama = com.tencent.mm.plugin.finder.nearby.report.b.Rb(j);
      if (parama != null)
      {
        Log.i("FinderNearbyLiveLoadingReporter", s.X("startCgi tabType: ", Integer.valueOf(j)));
        parama.EQC = cn.bDw();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "", "onFetchDone", "", "resp", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(NearbyLiveFeedLoader.d paramd, NearbyLiveFeedLoader.c paramc);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.c
 * JD-Core Version:    0.7.0.1
 */