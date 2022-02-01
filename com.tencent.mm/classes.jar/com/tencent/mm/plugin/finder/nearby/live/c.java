package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.nearby.base.d;
import com.tencent.mm.plugin.finder.nearby.base.d.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "commentScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$CgiSwitcher;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "fetch", "", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "memoryCacheFlag", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final c uQG;
  private final int dLS;
  final int tCE;
  com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
  final bbn ttO;
  final b uQF;
  
  static
  {
    AppMethodBeat.i(249031);
    uQG = new c((byte)0);
    AppMethodBeat.o(249031);
  }
  
  public c(int paramInt1, int paramInt2, bbn parambbn)
  {
    AppMethodBeat.i(249030);
    this.dLS = paramInt1;
    this.tCE = paramInt2;
    this.ttO = parambbn;
    this.uQF = new b(this.dLS);
    this.ttK = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(249030);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(NearbyLiveFeedLoader.b paramb);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getTabType", "()I", "plugin-finder_release"})
  public static final class b
  {
    private final int dLS;
    b txe;
    
    public b(int paramInt)
    {
      this.dLS = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "pullType", "plugin-finder_release"})
  public static final class d
    implements a.a
  {
    d(int paramInt, c.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, auj paramauj, int paramInt3)
    {
      AppMethodBeat.i(249029);
      p.h(paramauj, "resp");
      Object localObject1 = d.uQu;
      d.a.JA(this.uQI).uQp = System.currentTimeMillis();
      localObject1 = new NearbyLiveFeedLoader.b(paramInt1, paramInt2, paramString, (byte)0);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uQH.uQF.txe = paramauj.LDs;
        paramString = paramauj.object;
        p.g(paramString, "resp.`object`");
        Object localObject2 = (Iterable)paramString;
        paramString = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject4;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          localObject4 = (FinderObject)localObject3;
          y localy = y.vXH;
          p.g(localObject4, "it");
          if (y.a((FinderObject)localObject4, "Finder.FinderLiveFriendsFeedFetcher")) {
            paramString.add(localObject3);
          }
        }
        paramString = (List)paramString;
        if (paramString.size() < paramauj.object.size()) {
          Log.e("Finder.FinderLiveFriendsFeedFetcher", "[onCgiBack] has filter some feed. valid=" + paramString.size() + " raw=" + paramauj.object.size());
        }
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        localObject2 = y.vXH;
        localObject2 = (Iterable)com.tencent.mm.plugin.finder.storage.logic.c.a.a(paramString, y.LL(c.a(this.uQH)), c.b(this.uQH));
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderItem)((Iterator)localObject2).next();
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          paramString.add(com.tencent.mm.plugin.finder.storage.logic.c.a.s((FinderItem)localObject3));
        }
        localObject2 = new LinkedList((Collection)paramString);
        paramString = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
        com.tencent.mm.plugin.finder.nearby.report.c.j(c.c(this.uQH), (List)localObject2);
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((NearbyLiveFeedLoader.b)localObject1).getIncrementList();
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.size());
          Log.i("Finder.FinderLiveFriendsFeedFetcher", paramString);
          ((NearbyLiveFeedLoader.b)localObject1).setIncrementList((List)localObject2);
          ((NearbyLiveFeedLoader.b)localObject1).setPullType(paramInt3);
          ((NearbyLiveFeedLoader.b)localObject1).setLastBuffer(paramauj.LDs);
          if (paramauj.tUC == 0) {
            break label490;
          }
        }
        label490:
        for (boolean bool = true;; bool = false)
        {
          ((NearbyLiveFeedLoader.b)localObject1).setHasMore(bool);
          ((NearbyLiveFeedLoader.b)localObject1).uQN = paramauj.LFi;
          this.uQJ.a((NearbyLiveFeedLoader.b)localObject1);
          AppMethodBeat.o(249029);
          return;
          paramString = null;
          break;
        }
      }
      ((NearbyLiveFeedLoader.b)localObject1).setHasMore(true);
      AppMethodBeat.o(249029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.c
 * JD-Core Version:    0.7.0.1
 */