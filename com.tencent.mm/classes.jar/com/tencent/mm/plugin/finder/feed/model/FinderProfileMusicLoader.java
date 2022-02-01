package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.f.a.np;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.by;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "finderSelfName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderSelfName", "()Ljava/lang/String;", "getFinderUserName", "musicPlayEventListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1;", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;)V", "addRvFeed", "index", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "findMusicIndex", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "id", "", "handleMusic", "action", "interceptMvFeed", "", "interceptMvPostStart", "isObservePostEvent", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "transformToMusicData", "item", "updateMusic", "updateMusicProgressByLocalId", "localId", "CacheState", "MusicDataFetcher", "MvResponse", "State", "plugin-finder_release"})
public final class FinderProfileMusicLoader
  extends BaseFinderFeedLoader
{
  final String whH;
  public a<x> xEI;
  public d xIP;
  public a xIQ;
  private final e xIR;
  private final f xIS;
  final String xIT;
  
  public FinderProfileMusicLoader(String paramString1, String paramString2, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(279537);
    this.whH = paramString1;
    this.xIT = paramString2;
    this.xIP = d.xIZ;
    this.xIQ = a.xIU;
    this.xIR = new e(this);
    this.xIS = new f(this);
    AppMethodBeat.o(279537);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(279528);
    p.k(paramd, "<set-?>");
    this.xIP = paramd;
    AppMethodBeat.o(279528);
  }
  
  public final void addRvFeed(int paramInt, bu parambu)
  {
    AppMethodBeat.i(279533);
    p.k(parambu, "feed");
    if (((parambu instanceof BaseFinderFeed)) && (((BaseFinderFeed)parambu).feedObject.isMvFeed()) && (!(parambu instanceof bi)))
    {
      getDataList().add(paramInt, transformToMusicData(((BaseFinderFeed)parambu).feedObject));
      AppMethodBeat.o(279533);
      return;
    }
    getDataList().add(paramInt, parambu);
    AppMethodBeat.o(279533);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(279531);
    i locali = (i)new b();
    AppMethodBeat.o(279531);
    return locali;
  }
  
  public final boolean interceptMvFeed()
  {
    return true;
  }
  
  public final boolean interceptMvPostStart()
  {
    return false;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(279529);
    super.onAlive();
    this.xIR.alive();
    this.xIS.alive();
    AppMethodBeat.o(279529);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(279530);
    super.onDead();
    this.xIR.dead();
    this.xIS.dead();
    AppMethodBeat.o(279530);
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(279536);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (getDataListJustForAdapter().size() > 0) {}
    for (a locala = a.xIW;; locala = a.xIV)
    {
      this.xIQ = locala;
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(279536);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.xEI;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(279536);
        return;
      }
    }
    AppMethodBeat.o(279536);
  }
  
  public final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(279532);
    p.k(paramFinderItem, "feedObj");
    if (interceptMvFeed())
    {
      paramFinderItem = transformToMusicData(paramFinderItem);
      AppMethodBeat.o(279532);
      return paramFinderItem;
    }
    paramFinderItem = super.transformFinderObj(paramFinderItem);
    AppMethodBeat.o(279532);
    return paramFinderItem;
  }
  
  public final BaseFinderFeed transformToMusicData(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(279535);
    p.k(paramFinderItem, "item");
    paramFinderItem = (BaseFinderFeed)new bi(paramFinderItem);
    AppMethodBeat.o(279535);
    return paramFinderItem;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(279892);
      a locala1 = new a("INIT", 0);
      xIU = locala1;
      a locala2 = new a("NO_CACHE", 1);
      xIV = locala2;
      a locala3 = new a("WITH_CACHED", 2);
      xIW = locala3;
      xIX = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(279892);
    }
    
    private a() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MusicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "mergeLocalData", "nowList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "userName", "start", "end", "transfromMusicInfoList", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "items", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(227615);
      Object localObject3 = k.Anu;
      Object localObject2 = this.xIY.whH;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = ((k.a)localObject3).ed((String)localObject1, 17);
      localObject3 = this.xIY.whH;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (((CharSequence)localObject1).length() == 0) {}
      for (int i = 1; (i != 0) || ((p.h(localObject1, z.bdh()) ^ true)); i = 0)
      {
        localObject1 = new FinderProfileMusicLoader.c(0, 0, "");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(new bi((FinderItem)((Iterator)localObject3).next()));
        }
      }
      if (i.a.getDEBUG())
      {
        localObject3 = aj.AGc;
        aj.o((List)localObject2, "newList");
      }
      Log.i(getTAG(), "mergeLocalData start 0 end 2147483647");
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      localObject3 = (Iterable)c.a.ai((String)localObject1, 0, 2147483647);
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label294:
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (((FinderItem)localObject4).getFeedObject().objectType == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label294;
          }
          ((Collection)localObject1).add(localObject4);
          break;
        }
      }
      localObject3 = (List)localObject1;
      com.tencent.mm.ae.d.a((ArrayList)localObject3, (b)new a((List)localObject2));
      if (!ag.fe(localObject2)) {}
      for (localObject1 = null;; localObject1 = localObject2)
      {
        if (localObject1 != null) {
          ((List)localObject1).addAll(0, (Collection)localObject3);
        }
        if (i.a.getDEBUG())
        {
          localObject1 = aj.AGc;
          aj.o((List)localObject2, "newList");
        }
        Log.i(getTAG(), "dblist size:" + ((List)localObject3).size());
        localObject1 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (FinderItem)((Iterator)localObject1).next();
          Log.i(getTAG(), "dblist item, localId:" + ((FinderItem)localObject3).getLocalId() + ", id:" + ((FinderItem)localObject3).getId());
        }
        break;
        ((FinderProfileMusicLoader.c)localObject1).setIncrementList((List)localObject2);
        ((FinderProfileMusicLoader.c)localObject1).setLastBuffer(null);
        localObject1 = (IResponse)localObject1;
        AppMethodBeat.o(227615);
        return localObject1;
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(227621);
      p.k(paramq, "scene");
      if ((paramq instanceof by))
      {
        Object localObject2 = this.xIY;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (Object localObject1 = FinderProfileMusicLoader.d.xJb;; localObject1 = FinderProfileMusicLoader.d.xJc)
        {
          ((FinderProfileMusicLoader)localObject2).a((FinderProfileMusicLoader.d)localObject1);
          localObject1 = ((by)paramq).doA();
          paramString = new FinderProfileMusicLoader.c(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bi((FinderItem)((Iterator)localObject2).next()));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setPullType(((by)paramq).pullType);
        localObject1 = ((by)paramq).lKU.bhY();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
          AppMethodBeat.o(227621);
          throw paramString;
        }
        if (((bdv)localObject1).continueFlag == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          paramq = ((by)paramq).lKU.bhY();
          if (paramq != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
          AppMethodBeat.o(227621);
          throw paramString;
        }
        paramString.setLastBuffer(((bdv)paramq).lastBuffer);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(227621);
        return paramString;
      }
      AppMethodBeat.o(227621);
      return null;
    }
    
    public final void fetch(Object paramObject, h<bu> paramh)
    {
      AppMethodBeat.i(227598);
      p.k(paramh, "callback");
      super.fetch(paramObject, paramh);
      this.xIY.a(FinderProfileMusicLoader.d.xJa);
      AppMethodBeat.o(227598);
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(227603);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new by(this.xIY.whH, this.xIY.xIT, this.xIY.getLastBuffer(), 2, this.xIY.getContextObj());
      AppMethodBeat.o(227603);
      return localq;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(227600);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new by(this.xIY.whH, this.xIY.xIT, null, 0, this.xIY.getContextObj());
      AppMethodBeat.o(227600);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(227599);
      List localList = j.listOf(Integer.valueOf(6628));
      AppMethodBeat.o(227599);
      return localList;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements b<FinderItem, Boolean>
    {
      a(List paramList)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MvResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "PRIVATE_LOCK", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(269994);
      d locald1 = new d("INIT", 0);
      xIZ = locald1;
      d locald2 = new d("LOADING", 1);
      xJa = locald2;
      d locald3 = new d("LOADED", 2);
      xJb = locald3;
      d locald4 = new d("FAILURE", 3);
      xJc = locald4;
      d locald5 = new d("PRIVATE_LOCK", 4);
      xJd = locald5;
      xJe = new d[] { locald1, locald2, locald3, locald4, locald5 };
      AppMethodBeat.o(269994);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hr>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends IListener<np>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements a<x>
  {
    g(FinderProfileMusicLoader paramFinderProfileMusicLoader, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileMusicLoader
 * JD-Core Version:    0.7.0.1
 */