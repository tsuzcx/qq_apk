package com.tencent.mm.plugin.finder.feed.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cw;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "finderSelfName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderSelfName", "()Ljava/lang/String;", "getFinderUserName", "musicPlayEventListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1;", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;)V", "addRvFeed", "index", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "findMusicIndex", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "id", "", "handleMusic", "action", "interceptMvFeed", "", "interceptMvPostStart", "isObservePostEvent", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onPostStart", "localId", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "transformToMusicData", "item", "updateMusic", "updateMusicProgressByLocalId", "CacheState", "MusicDataFetcher", "MvResponse", "State", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileMusicLoader
  extends BaseFinderFeedLoader
{
  public a<ah> BbB;
  final String Bil;
  public d Bim;
  public a Bin;
  private final feedProgressListener.1 Bio;
  private final musicPlayEventListener.1 Bip;
  final String zDJ;
  
  public FinderProfileMusicLoader(String paramString1, String paramString2, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366418);
    this.zDJ = paramString1;
    this.Bil = paramString2;
    this.Bim = d.Biv;
    this.Bin = a.Biq;
    this.Bio = new IListener(f.hfK) {};
    this.Bip = new IListener(f.hfK) {};
    AppMethodBeat.o(366418);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(366424);
    s.u(paramd, "<set-?>");
    this.Bim = paramd;
    AppMethodBeat.o(366424);
  }
  
  public final void addRvFeed(int paramInt, cc paramcc)
  {
    AppMethodBeat.i(366480);
    s.u(paramcc, "feed");
    if (((paramcc instanceof BaseFinderFeed)) && (((BaseFinderFeed)paramcc).feedObject.isMvFeed()) && (!(paramcc instanceof bm)))
    {
      getDataList().add(paramInt, transformToMusicData(((BaseFinderFeed)paramcc).feedObject));
      AppMethodBeat.o(366480);
      return;
    }
    getDataList().add(paramInt, paramcc);
    AppMethodBeat.o(366480);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366444);
    i locali = (i)new b();
    AppMethodBeat.o(366444);
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
    AppMethodBeat.i(366431);
    super.onAlive();
    this.Bio.alive();
    this.Bip.alive();
    AppMethodBeat.o(366431);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(366439);
    super.onDead();
    this.Bio.dead();
    this.Bip.dead();
    AppMethodBeat.o(366439);
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366496);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (getDataListJustForAdapter().size() > 0) {}
    for (a locala = a.Bis;; locala = a.Bir)
    {
      this.Bin = locala;
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(366496);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.BbB;
      if (paramIResponse != null) {
        paramIResponse.invoke();
      }
    }
    AppMethodBeat.o(366496);
  }
  
  public final void onPostStart(long paramLong)
  {
    AppMethodBeat.i(366469);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject = d.a.qr(paramLong);
    if ((localObject != null) && (transformFinderObj((FinderItem)localObject).feedObject.isMvFeed())) {
      super.onPostStart(paramLong);
    }
    AppMethodBeat.o(366469);
  }
  
  public final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(366472);
    s.u(paramFinderItem, "feedObj");
    if (interceptMvFeed())
    {
      paramFinderItem = transformToMusicData(paramFinderItem);
      AppMethodBeat.o(366472);
      return paramFinderItem;
    }
    paramFinderItem = super.transformFinderObj(paramFinderItem);
    AppMethodBeat.o(366472);
    return paramFinderItem;
  }
  
  public final BaseFinderFeed transformToMusicData(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(366486);
    s.u(paramFinderItem, "item");
    paramFinderItem = (BaseFinderFeed)new bm(paramFinderItem);
    AppMethodBeat.o(366486);
    return paramFinderItem;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(365974);
      Biq = new a("INIT", 0);
      Bir = new a("NO_CACHE", 1);
      Bis = new a("WITH_CACHED", 2);
      Bit = new a[] { Biq, Bir, Bis };
      AppMethodBeat.o(365974);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MusicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "mergeLocalData", "nowList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "userName", "start", "end", "transfromMusicInfoList", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "items", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(365930);
      AppMethodBeat.o(365930);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(365973);
      Object localObject3 = k.FNg;
      Object localObject2 = this.Biu.zDJ;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = ((k.a)localObject3).eO((String)localObject1, 17);
      localObject3 = this.Biu.zDJ;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (((CharSequence)localObject1).length() == 0) {}
      for (int i = 1; (i != 0) || (!s.p(localObject1, z.bAW())); i = 0)
      {
        localObject1 = new FinderProfileMusicLoader.c(0, 0, "");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(new bm((FinderItem)((Iterator)localObject3).next()));
        }
      }
      if (i.a.getDEBUG())
      {
        localObject3 = av.GiL;
        av.w((List)localObject2, "newList");
      }
      Log.i(getTAG(), "mergeLocalData start 0 end 2147483647");
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject3 = (Iterable)d.a.an((String)localObject1, 0, 2147483647);
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label292:
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (((FinderItem)localObject4).getFeedObject().objectType == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label292;
          }
          ((Collection)localObject1).add(localObject4);
          break;
        }
      }
      localObject3 = (List)localObject1;
      com.tencent.mm.ae.d.a((ArrayList)localObject3, (b)new a((List)localObject2));
      if (an.hC(localObject2)) {}
      for (localObject1 = localObject2;; localObject1 = null)
      {
        if (localObject1 != null) {
          ((List)localObject1).addAll(0, (Collection)localObject3);
        }
        if (i.a.getDEBUG())
        {
          localObject1 = av.GiL;
          av.w((List)localObject2, "newList");
        }
        Log.i(getTAG(), s.X("dblist size:", Integer.valueOf(((List)localObject3).size())));
        localObject1 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (FinderItem)((Iterator)localObject1).next();
          Log.i(getTAG(), "dblist item, localId:" + ((FinderItem)localObject3).getLocalId() + ", id:" + ((FinderItem)localObject3).getId());
        }
        break;
      }
      ((FinderProfileMusicLoader.c)localObject1).setIncrementList((List)localObject2);
      ((FinderProfileMusicLoader.c)localObject1).setLastBuffer(null);
      localObject1 = (IResponse)localObject1;
      AppMethodBeat.o(365973);
      return localObject1;
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(365988);
      s.u(paramp, "scene");
      if ((paramp instanceof cw))
      {
        Object localObject2 = this.Biu;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (Object localObject1 = FinderProfileMusicLoader.d.Bix;; localObject1 = FinderProfileMusicLoader.d.Biy)
        {
          ((FinderProfileMusicLoader)localObject2).a((FinderProfileMusicLoader.d)localObject1);
          localObject1 = ((cw)paramp).dWn();
          paramString = new FinderProfileMusicLoader.c(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bm((FinderItem)((Iterator)localObject2).next()));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setPullType(((cw)paramp).pullType);
        localObject1 = c.c.b(((cw)paramp).oDw.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
          AppMethodBeat.o(365988);
          throw paramString;
        }
        if (((bot)localObject1).continueFlag == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          paramp = c.c.b(((cw)paramp).oDw.otC);
          if (paramp != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
          AppMethodBeat.o(365988);
          throw paramString;
        }
        paramString.setLastBuffer(((bot)paramp).lastBuffer);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(365988);
        return paramString;
      }
      AppMethodBeat.o(365988);
      return null;
    }
    
    public final void fetch(Object paramObject, h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(365938);
      s.u(paramh, "callback");
      super.fetch(paramObject, paramh, paramBoolean);
      this.Biu.a(FinderProfileMusicLoader.d.Biw);
      AppMethodBeat.o(365938);
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(365961);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new cw(this.Biu.zDJ, this.Biu.Bil, this.Biu.getLastBuffer(), 2, this.Biu.getContextObj());
      AppMethodBeat.o(365961);
      return localp;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(365953);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new cw(this.Biu.zDJ, this.Biu.Bil, null, 0, this.Biu.getContextObj());
      AppMethodBeat.o(365953);
      return localp;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(365946);
      List localList = kotlin.a.p.listOf(Integer.valueOf(6628));
      AppMethodBeat.o(365946);
      return localList;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<FinderItem, Boolean>
    {
      a(List<? extends FinderItem> paramList)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MvResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "PRIVATE_LOCK", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(366055);
      Biv = new d("INIT", 0);
      Biw = new d("LOADING", 1);
      Bix = new d("LOADED", 2);
      Biy = new d("FAILURE", 3);
      Biz = new d("PRIVATE_LOCK", 4);
      BiA = new d[] { Biv, Biw, Bix, Biy, Biz };
      AppMethodBeat.o(366055);
    }
    
    private d() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(FinderProfileMusicLoader paramFinderProfileMusicLoader, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileMusicLoader
 * JD-Core Version:    0.7.0.1
 */