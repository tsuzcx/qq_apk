package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "finderSelfName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderSelfName", "()Ljava/lang/String;", "getFinderUserName", "musicPlayEventListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1;", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;)V", "addRvFeed", "index", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "findMusicIndex", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "id", "", "handleMusic", "action", "interceptMvFeed", "", "interceptMvPostStart", "isObservePostEvent", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "transformToMusicData", "item", "updateMusic", "updateMusicProgressByLocalId", "localId", "CacheState", "MusicDataFetcher", "MvResponse", "State", "plugin-finder_release"})
public final class FinderProfileMusicLoader
  extends BaseFinderFeedLoader
{
  final String sBN;
  public kotlin.g.a.a<x> tTS;
  public d tWS;
  public a tWT;
  private final e tWU;
  private final f tWV;
  final String tWW;
  
  public FinderProfileMusicLoader(String paramString1, String paramString2, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244852);
    this.sBN = paramString1;
    this.tWW = paramString2;
    this.tWS = d.tXc;
    this.tWT = a.tWX;
    this.tWU = new e(this);
    this.tWV = new f(this);
    AppMethodBeat.o(244852);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(244844);
    p.h(paramd, "<set-?>");
    this.tWS = paramd;
    AppMethodBeat.o(244844);
  }
  
  public final void addRvFeed(int paramInt, bo parambo)
  {
    AppMethodBeat.i(244849);
    p.h(parambo, "feed");
    if (((parambo instanceof BaseFinderFeed)) && (((BaseFinderFeed)parambo).feedObject.isMvFeed()) && (!(parambo instanceof bf)))
    {
      getDataList().add(paramInt, transformToMusicData(((BaseFinderFeed)parambo).feedObject));
      AppMethodBeat.o(244849);
      return;
    }
    getDataList().add(paramInt, parambo);
    AppMethodBeat.o(244849);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244847);
    g localg = (g)new b();
    AppMethodBeat.o(244847);
    return localg;
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
    AppMethodBeat.i(244845);
    super.onAlive();
    this.tWU.alive();
    this.tWV.alive();
    AppMethodBeat.o(244845);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(244846);
    super.onDead();
    this.tWU.dead();
    this.tWV.dead();
    AppMethodBeat.o(244846);
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244851);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (getDataListJustForAdapter().size() > 0) {}
    for (a locala = a.tWZ;; locala = a.tWY)
    {
      this.tWT = locala;
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(244851);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.tTS;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(244851);
        return;
      }
    }
    AppMethodBeat.o(244851);
  }
  
  public final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(244848);
    p.h(paramFinderItem, "feedObj");
    if (interceptMvFeed())
    {
      paramFinderItem = transformToMusicData(paramFinderItem);
      AppMethodBeat.o(244848);
      return paramFinderItem;
    }
    paramFinderItem = super.transformFinderObj(paramFinderItem);
    AppMethodBeat.o(244848);
    return paramFinderItem;
  }
  
  public final BaseFinderFeed transformToMusicData(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(244850);
    p.h(paramFinderItem, "item");
    paramFinderItem = (BaseFinderFeed)new bf(paramFinderItem);
    AppMethodBeat.o(244850);
    return paramFinderItem;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(244827);
      a locala1 = new a("INIT", 0);
      tWX = locala1;
      a locala2 = new a("NO_CACHE", 1);
      tWY = locala2;
      a locala3 = new a("WITH_CACHED", 2);
      tWZ = locala3;
      tXa = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(244827);
    }
    
    private a() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MusicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "nowList", "userName", "start", "end", "transfromMusicInfoList", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "items", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    private final List<FinderItem> i(List<? extends FinderItem> paramList, String paramString)
    {
      AppMethodBeat.i(244837);
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; (i != 0) || ((p.j(paramString, z.aUg()) ^ true)); i = 0)
      {
        AppMethodBeat.o(244837);
        return paramList;
      }
      if (g.access$getDEBUG$cp())
      {
        localObject1 = y.vXH;
        y.m(paramList, "newList");
      }
      Log.i(getTAG(), "mergeLocalData start 0 end 2147483647");
      Object localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll((Collection)paramList);
      Object localObject2 = c.vGN;
      localObject2 = (Iterable)c.a.af(paramString, 0, 2147483647);
      paramString = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label194:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((FinderItem)localObject3).getFeedObject().objectType == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label194;
          }
          paramString.add(localObject3);
          break;
        }
      }
      paramString = (List)paramString;
      com.tencent.mm.ac.d.a((ArrayList)paramString, (b)new a(paramList));
      ((LinkedList)localObject1).addAll(0, (Collection)paramString);
      if (g.access$getDEBUG$cp())
      {
        paramList = y.vXH;
        y.m((List)localObject1, "newList");
      }
      Log.i(getTAG(), "dblist size:" + paramString.size());
      paramList = ((Iterable)paramString).iterator();
      while (paramList.hasNext())
      {
        paramString = (FinderItem)paramList.next();
        Log.i(getTAG(), "dblist item, localId:" + paramString.getLocalId() + ", id:" + paramString.getId());
      }
      paramList = (List)localObject1;
      AppMethodBeat.o(244837);
      return paramList;
    }
    
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(244835);
      Object localObject3 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      Object localObject2 = this.tXb.sBN;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((l.a)localObject3).dG((String)localObject1, 17);
      localObject2 = this.tXb.sBN;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      i((List)localObject3, (String)localObject1);
      localObject1 = new FinderProfileMusicLoader.c(0, 0, "");
      localObject3 = (Iterable)localObject3;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(new bf((FinderItem)((Iterator)localObject3).next()));
      }
      ((FinderProfileMusicLoader.c)localObject1).setIncrementList((List)localObject2);
      ((FinderProfileMusicLoader.c)localObject1).setLastBuffer(null);
      localObject1 = (IResponse)localObject1;
      AppMethodBeat.o(244835);
      return localObject1;
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244836);
      p.h(paramq, "scene");
      if ((paramq instanceof bv))
      {
        Object localObject2 = this.tXb;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (Object localObject1 = FinderProfileMusicLoader.d.tXe;; localObject1 = FinderProfileMusicLoader.d.tXf)
        {
          ((FinderProfileMusicLoader)localObject2).a((FinderProfileMusicLoader.d)localObject1);
          List localList = ((bv)paramq).cYL();
          localObject2 = this.tXb.sBN;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject1 = i(localList, (String)localObject1);
          paramString = new FinderProfileMusicLoader.c(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bf((FinderItem)((Iterator)localObject2).next()));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setPullType(((bv)paramq).pullType);
        localObject1 = ((bv)paramq).iUB.aYK();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
          AppMethodBeat.o(244836);
          throw paramString;
        }
        if (((ayb)localObject1).continueFlag == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          paramq = ((bv)paramq).iUB.aYK();
          if (paramq != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
          AppMethodBeat.o(244836);
          throw paramString;
        }
        paramString.setLastBuffer(((ayb)paramq).lastBuffer);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(244836);
        return paramString;
      }
      AppMethodBeat.o(244836);
      return null;
    }
    
    public final void fetch(Object paramObject, f<bo> paramf)
    {
      AppMethodBeat.i(244831);
      p.h(paramf, "callback");
      super.fetch(paramObject, paramf);
      this.tXb.a(FinderProfileMusicLoader.d.tXd);
      AppMethodBeat.o(244831);
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244834);
      com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new bv(this.tXb.sBN, this.tXb.tWW, this.tXb.getLastBuffer(), 2, this.tXb.getContextObj());
      AppMethodBeat.o(244834);
      return localq;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244833);
      com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new bv(this.tXb.sBN, this.tXb.tWW, null, 0, this.tXb.getContextObj());
      AppMethodBeat.o(244833);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244832);
      List localList = j.listOf(Integer.valueOf(6628));
      AppMethodBeat.o(244832);
      return localList;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MvResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "PRIVATE_LOCK", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(244838);
      d locald1 = new d("INIT", 0);
      tXc = locald1;
      d locald2 = new d("LOADING", 1);
      tXd = locald2;
      d locald3 = new d("LOADED", 2);
      tXe = locald3;
      d locald4 = new d("FAILURE", 3);
      tXf = locald4;
      d locald5 = new d("PRIVATE_LOCK", 4);
      tXg = locald5;
      tXh = new d[] { locald1, locald2, locald3, locald4, locald5 };
      AppMethodBeat.o(244838);
    }
    
    private d() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hk>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends IListener<mx>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
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