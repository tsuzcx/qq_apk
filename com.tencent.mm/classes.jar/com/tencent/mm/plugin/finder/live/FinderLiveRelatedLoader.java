package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.cgi.bq;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "()V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "isFirstFetchLiveLbsResponse", "", "loaderParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "getLoaderParams", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "setLoaderParams", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "setLoaderParam", "params", "BaseDataFetcher", "FinderLiveRelResponse", "NearbyLiveRelatedDataFetcher", "plugin-finder_release"})
public final class FinderLiveRelatedLoader
  extends BaseFeedLoader<f>
{
  kotlin.g.a.b<? super IResponse<f>, x> fetchEndCallback;
  com.tencent.mm.plugin.finder.live.viewmodel.data.j xVT;
  private boolean xVU;
  
  public FinderLiveRelatedLoader()
  {
    super(null, 1, null);
    AppMethodBeat.i(272040);
    this.xVT = new com.tencent.mm.plugin.finder.live.viewmodel.data.j();
    this.xVU = true;
    AppMethodBeat.o(272040);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.j paramj)
  {
    AppMethodBeat.i(272037);
    p.k(paramj, "params");
    this.xVT = paramj;
    AppMethodBeat.o(272037);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<f> createDataFetch()
  {
    AppMethodBeat.i(272038);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new c();
    AppMethodBeat.o(272038);
    return locali;
  }
  
  public final void onFetchDone(IResponse<f> paramIResponse)
  {
    AppMethodBeat.i(272039);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramIResponse);
    a.c("com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    p.k(paramIResponse, "response");
    localObject = this.fetchEndCallback;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
    }
    a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(272039);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "onSceneEnd", "plugin-finder_release"})
  public class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<f>
    implements com.tencent.mm.an.i
  {
    private final Map<q, com.tencent.mm.plugin.finder.feed.model.internal.h<f>> map;
    
    public a()
    {
      AppMethodBeat.i(279594);
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(279594);
    }
    
    public void alive()
    {
      AppMethodBeat.i(279588);
      super.alive();
      com.tencent.mm.kernel.h.aGY().a(getCmdId(), (com.tencent.mm.an.i)this);
      AppMethodBeat.o(279588);
    }
    
    public void dead()
    {
      AppMethodBeat.i(279589);
      super.dead();
      com.tencent.mm.kernel.h.aGY().b(getCmdId(), (com.tencent.mm.an.i)this);
      AppMethodBeat.o(279589);
    }
    
    public void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(279587);
      p.k(paramh, "callback");
      if ((paramObject != null) && ((paramObject instanceof q)))
      {
        this.map.put(paramObject, paramh);
        com.tencent.mm.kernel.h.aGY().b((q)paramObject);
      }
      AppMethodBeat.o(279587);
    }
    
    public void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(279591);
      p.k(paramh, "callback");
      IResponse localIResponse = (IResponse)new com.tencent.mm.plugin.finder.feed.model.internal.e();
      localIResponse.setPullType(1000);
      paramh.onFetchDone(localIResponse);
      AppMethodBeat.o(279591);
    }
    
    public void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(279593);
      p.k(paramh, "callback");
      q localq = genLoadMoreNetScene();
      if ((localq instanceof bq)) {
        ((bq)localq).pullType = 2;
      }
      fetch(localq, paramh);
      AppMethodBeat.o(279593);
    }
    
    public void fetchPreload(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(279590);
      p.k(paramh, "callback");
      q localq = genLoadMoreNetScene();
      if ((localq instanceof bq)) {
        ((bq)localq).pullType = 3;
      }
      fetch(localq, paramh);
      AppMethodBeat.o(279590);
    }
    
    public void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(279592);
      p.k(paramh, "callback");
      fetch(null, paramh);
      AppMethodBeat.o(279592);
    }
    
    public q genLoadMoreNetScene()
    {
      return null;
    }
    
    public int getCmdId()
    {
      return -1;
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(279586);
      p.k(paramq, "scene");
      com.tencent.mm.plugin.finder.feed.model.internal.h localh = (com.tencent.mm.plugin.finder.feed.model.internal.h)this.map.get(paramq);
      if (localh != null)
      {
        this.map.remove(paramq);
        p.k(paramq, "scene");
        FinderLiveRelatedLoader.b localb;
        if ((paramq instanceof bq))
        {
          boolean bool;
          Collection localCollection;
          label181:
          label253:
          long l3;
          long l1;
          label311:
          Object localObject3;
          Object localObject4;
          label416:
          String str;
          Object localObject5;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            localObject1 = ((bq)paramq).rr;
            if (localObject1 == null) {
              p.bGy("rr");
            }
            localObject1 = ((d)localObject1).bhY();
            if (localObject1 == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
              AppMethodBeat.o(279586);
              throw paramString;
            }
            if (((auz)localObject1).xFI == 0)
            {
              bool = false;
              localb = new FinderLiveRelatedLoader.b(paramInt1, paramInt2, paramString);
              paramString = (Iterable)((bq)paramq).dof();
              localCollection = (Collection)new ArrayList(kotlin.a.j.a(paramString, 10));
              Iterator localIterator = paramString.iterator();
              if (!localIterator.hasNext()) {
                break label534;
              }
              FinderObject localFinderObject = (FinderObject)localIterator.next();
              paramString = com.tencent.mm.plugin.finder.storage.data.e.AmW;
              paramString = FinderItem.Companion;
              e.a.o(FinderItem.a.b(localFinderObject, 16384));
              paramString = localFinderObject.objectDesc;
              if (paramString == null) {
                break label505;
              }
              paramString = paramString.media;
              if (paramString == null) {
                break label505;
              }
              paramString = (FinderMedia)kotlin.a.j.lp((List)paramString);
              if (paramString != null)
              {
                localObject1 = p.I(paramString.thumbUrl, Util.nullAsNil(paramString.thumb_url_token));
                paramString = (String)localObject1;
                if (localObject1 != null) {}
              }
              else
              {
                paramString = "";
              }
              l3 = localFinderObject.id;
              localObject1 = localFinderObject.liveInfo;
              if (localObject1 == null) {
                break label510;
              }
              l1 = ((bac)localObject1).liveId;
              localObject2 = localFinderObject.username;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localObject3 = localFinderObject.objectNonceId;
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = "";
              }
              localObject3 = localFinderObject.liveInfo;
              if (localObject3 != null)
              {
                localObject4 = ((bac)localObject3).kih;
                localObject3 = localObject4;
                if (localObject4 != null) {}
              }
              else
              {
                localObject3 = "";
              }
              localObject4 = localFinderObject.liveInfo;
              if (localObject4 == null) {
                break label516;
              }
              localObject4 = ((bac)localObject4).SLN;
              if (localObject4 == null) {
                break label516;
              }
              paramInt1 = ((bch)localObject4).kmi;
              str = localFinderObject.sessionBuffer;
              localObject5 = localFinderObject.nickname;
              localObject4 = localObject5;
              if (localObject5 == null) {
                localObject4 = "";
              }
              localObject5 = localFinderObject.liveInfo;
              if (localObject5 == null) {
                break label528;
              }
            }
          }
          label516:
          label528:
          for (long l2 = ((bac)localObject5).SEj;; l2 = 0L)
          {
            localCollection.add(new f(l3, l1, (String)localObject1, (String)localObject2, paramString, (String)localObject3, paramInt1, str, (String)localObject4, l2));
            break label181;
            bool = true;
            break;
            label505:
            paramString = null;
            break label253;
            label510:
            l1 = 0L;
            break label311;
            localObject4 = e.b.kjz;
            paramInt1 = e.b.aJK();
            break label416;
          }
          label534:
          localb.setIncrementList((List)localCollection);
          Object localObject1 = getTAG();
          Object localObject2 = new StringBuilder("incrementList size: ");
          paramString = localb.getIncrementList();
          if (paramString != null) {}
          for (paramString = Integer.valueOf(paramString.size());; paramString = null)
          {
            Log.i((String)localObject1, paramString);
            localb.setPullType(((bq)paramq).pullType);
            paramString = ((bq)paramq).rr;
            if (paramString == null) {
              p.bGy("rr");
            }
            paramString = paramString.bhY();
            if (paramString != null) {
              break;
            }
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
            AppMethodBeat.o(279586);
            throw paramString;
          }
          localb.setLastBuffer(((auz)paramString).SDI);
          localb.setHasMore(bool);
        }
        for (paramString = (IResponse)localb; paramString != null; paramString = null)
        {
          localh.onFetchDone(paramString);
          AppMethodBeat.o(279586);
          return;
        }
        paramString = this.xVV.fetchEndCallback;
        if (paramString != null)
        {
          paramString.invoke(null);
          AppMethodBeat.o(279586);
          return;
        }
        AppMethodBeat.o(279586);
        return;
      }
      AppMethodBeat.o(279586);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$FinderLiveRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<f>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$NearbyLiveRelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "genLoadMoreNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getCmdId", "", "plugin-finder_release"})
  public final class c
    extends FinderLiveRelatedLoader.a
  {
    public c()
    {
      super();
    }
    
    public final q genLoadMoreNetScene()
    {
      Object localObject1 = null;
      AppMethodBeat.i(280529);
      Object localObject2 = ao.xcj;
      aqe localaqe = ao.dnO();
      localaqe.scene = this.xVV.xVT.xkX;
      localObject2 = new aax();
      ((aax)localObject2).wmL = this.xVV.xVT.wmL;
      localaqe.SDu = ((aax)localObject2);
      bid localbid = new bid();
      localbid.fGo = this.xVV.xVT.xkX;
      localbid.xkX = this.xVV.xVT.xkX;
      Object localObject3;
      Object localObject4;
      if (FinderLiveRelatedLoader.a(this.xVV))
      {
        localObject2 = this.xVV.xVT.xdb;
        localObject3 = this.xVV.xVT;
        localObject4 = this.xVV.xVT.yeL;
        if (localObject4 != null) {
          localObject1 = ((FinderObject)localObject4).live_related_last_buffer;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject3).xaw = ((com.tencent.mm.cd.b)localObject1);
        FinderLiveRelatedLoader.b(this.xVV);
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        long l = this.xVV.xVT.xbk;
        localObject4 = this.xVV.xVT.nonceId;
        localObject3 = this.xVV.xVT.sessionBuffer;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = new bq(l, (String)localObject4, (String)localObject2, this.xVV.xVT.xaw, this.xVV.xVT.xkX, this.xVV.xVT.zeN, this.xVV.xVT.lLr, localaqe, (awq)localObject1, localbid);
        ((bq)localObject1).pullType = 2;
        localObject1 = (q)localObject1;
        AppMethodBeat.o(280529);
        return localObject1;
      }
    }
    
    public final int getCmdId()
    {
      return 6479;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.FinderLiveRelatedLoader
 * JD-Core Version:    0.7.0.1
 */