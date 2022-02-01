package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.bn;
import com.tencent.mm.plugin.finder.cgi.bq;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "()V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "loaderParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "getLoaderParams", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "setLoaderParams", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "setLoaderParam", "params", "BaseDataFetcher", "FinderLiveRelResponse", "LiveRelatedDataFetcher", "NearbyLiveRelatedDataFetcher", "plugin-finder_release"})
public final class FinderLiveRelatedLoader
  extends BaseFeedLoader<com.tencent.mm.plugin.finder.live.viewmodel.c>
{
  kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c>, x> fetchEndCallback;
  com.tencent.mm.plugin.finder.live.viewmodel.f ufx;
  
  public FinderLiveRelatedLoader()
  {
    super(null, 1, null);
    AppMethodBeat.i(245821);
    this.ufx = new com.tencent.mm.plugin.finder.live.viewmodel.f();
    AppMethodBeat.o(245821);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.f paramf)
  {
    AppMethodBeat.i(245818);
    p.h(paramf, "params");
    this.ufx = paramf;
    AppMethodBeat.o(245818);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<com.tencent.mm.plugin.finder.live.viewmodel.c> createDataFetch()
  {
    AppMethodBeat.i(245819);
    if (this.ufx.uiy == 1)
    {
      localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new d();
      AppMethodBeat.o(245819);
      return localg;
    }
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new c();
    AppMethodBeat.o(245819);
    return localg;
  }
  
  public final void onFetchDone(IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c> paramIResponse)
  {
    AppMethodBeat.i(245820);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramIResponse);
    a.b("com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    p.h(paramIResponse, "response");
    localObject = this.fetchEndCallback;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
    }
    a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(245820);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "onSceneEnd", "plugin-finder_release"})
  public class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<com.tencent.mm.plugin.finder.live.viewmodel.c>
    implements i
  {
    private final Map<q, com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c>> map;
    
    public a()
    {
      AppMethodBeat.i(245815);
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(245815);
    }
    
    public void alive()
    {
      AppMethodBeat.i(245809);
      super.alive();
      com.tencent.mm.kernel.g.azz().a(getCmdId(), (i)this);
      AppMethodBeat.o(245809);
    }
    
    public void dead()
    {
      AppMethodBeat.i(245810);
      super.dead();
      com.tencent.mm.kernel.g.azz().b(getCmdId(), (i)this);
      AppMethodBeat.o(245810);
    }
    
    public void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> paramf)
    {
      AppMethodBeat.i(245808);
      p.h(paramf, "callback");
      if ((paramObject != null) && ((paramObject instanceof q)))
      {
        this.map.put(paramObject, paramf);
        com.tencent.mm.kernel.g.azz().b((q)paramObject);
      }
      AppMethodBeat.o(245808);
    }
    
    public void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> paramf)
    {
      AppMethodBeat.i(245812);
      p.h(paramf, "callback");
      IResponse localIResponse = (IResponse)new com.tencent.mm.plugin.finder.feed.model.internal.c();
      localIResponse.setPullType(1000);
      paramf.onFetchDone(localIResponse);
      AppMethodBeat.o(245812);
    }
    
    public void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> paramf)
    {
      AppMethodBeat.i(245814);
      p.h(paramf, "callback");
      q localq = genLoadMoreNetScene();
      if ((localq instanceof bn)) {
        ((bn)localq).pullType = 2;
      }
      fetch(localq, paramf);
      AppMethodBeat.o(245814);
    }
    
    public void fetchPreload(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> paramf)
    {
      AppMethodBeat.i(245811);
      p.h(paramf, "callback");
      q localq = genLoadMoreNetScene();
      if ((localq instanceof bn)) {
        ((bn)localq).pullType = 3;
      }
      fetch(localq, paramf);
      AppMethodBeat.o(245811);
    }
    
    public void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> paramf)
    {
      AppMethodBeat.i(245813);
      p.h(paramf, "callback");
      fetch(null, paramf);
      AppMethodBeat.o(245813);
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
      AppMethodBeat.i(245807);
      p.h(paramq, "scene");
      com.tencent.mm.plugin.finder.feed.model.internal.f localf = (com.tencent.mm.plugin.finder.feed.model.internal.f)this.map.get(paramq);
      if (localf != null)
      {
        this.map.remove(paramq);
        p.h(paramq, "scene");
        boolean bool;
        FinderLiveRelatedLoader.b localb;
        Collection localCollection;
        Iterator localIterator;
        label128:
        FinderObject localFinderObject;
        Object localObject1;
        label201:
        long l2;
        long l1;
        Object localObject2;
        String str;
        if ((paramq instanceof bq))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            bool = ((bq)paramq).cYp();
            localb = new FinderLiveRelatedLoader.b(paramInt1, paramInt2, paramString);
            paramString = (Iterable)((bq)paramq).cYr();
            localCollection = (Collection)new ArrayList(j.a(paramString, 10));
            localIterator = paramString.iterator();
            if (!localIterator.hasNext()) {
              break label317;
            }
            localFinderObject = (FinderObject)localIterator.next();
            paramString = localFinderObject.objectDesc;
            if (paramString != null)
            {
              paramString = paramString.media;
              if (paramString != null)
              {
                paramString = (FinderMedia)j.kt((List)paramString);
                if (paramString != null)
                {
                  localObject1 = paramString.thumbUrl;
                  paramString = (String)localObject1;
                  if (localObject1 != null) {
                    break label201;
                  }
                }
              }
            }
            paramString = "";
            p.g(paramString, "feed.objectDesc?.media?.…rstOrNull()?.thumbUrl?:\"\"");
            l2 = localFinderObject.id;
            localObject1 = localFinderObject.liveInfo;
            if (localObject1 == null) {
              break label311;
            }
          }
          label311:
          for (l1 = ((awe)localObject1).liveId;; l1 = 0L)
          {
            localObject2 = localFinderObject.username;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            str = localFinderObject.objectNonceId;
            localObject2 = str;
            if (str == null) {
              localObject2 = "";
            }
            localCollection.add(new com.tencent.mm.plugin.finder.live.viewmodel.c(l2, l1, (String)localObject1, (String)localObject2, paramString, localFinderObject.sessionBuffer));
            break label128;
            bool = true;
            break;
          }
          label317:
          localb.setIncrementList((List)localCollection);
          localObject1 = getTAG();
          localObject2 = new StringBuilder("incrementList size: ");
          paramString = localb.getIncrementList();
          if (paramString != null)
          {
            paramString = Integer.valueOf(paramString.size());
            Log.i((String)localObject1, paramString + " pullType:" + ((bq)paramq).pullType);
            localb.setPullType(((bq)paramq).pullType);
            localb.setLastBuffer(((bq)paramq).cYm());
            localb.setHasMore(bool);
            paramString = (IResponse)localb;
          }
        }
        for (;;)
        {
          if (paramString == null) {
            break label937;
          }
          localf.onFetchDone(paramString);
          AppMethodBeat.o(245807);
          return;
          paramString = null;
          break;
          if ((paramq instanceof bn))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              localObject1 = ((bn)paramq).rr;
              if (localObject1 == null) {
                p.btv("rr");
              }
              localObject1 = ((d)localObject1).aYK();
              if (localObject1 == null)
              {
                paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
                AppMethodBeat.o(245807);
                throw paramString;
              }
              if (((asw)localObject1).tUC == 0)
              {
                bool = false;
                localb = new FinderLiveRelatedLoader.b(paramInt1, paramInt2, paramString);
                paramString = (Iterable)((bn)paramq).cYr();
                localCollection = (Collection)new ArrayList(j.a(paramString, 10));
                localIterator = paramString.iterator();
                label589:
                if (!localIterator.hasNext()) {
                  break label778;
                }
                localFinderObject = (FinderObject)localIterator.next();
                paramString = localFinderObject.objectDesc;
                if (paramString != null)
                {
                  paramString = paramString.media;
                  if (paramString != null)
                  {
                    paramString = (FinderMedia)j.kt((List)paramString);
                    if (paramString != null)
                    {
                      localObject1 = paramString.thumbUrl;
                      paramString = (String)localObject1;
                      if (localObject1 != null) {
                        break label662;
                      }
                    }
                  }
                }
                paramString = "";
                label662:
                p.g(paramString, "feed.objectDesc?.media?.…rstOrNull()?.thumbUrl?:\"\"");
                l2 = localFinderObject.id;
                localObject1 = localFinderObject.liveInfo;
                if (localObject1 == null) {
                  break label772;
                }
              }
            }
            label772:
            for (l1 = ((awe)localObject1).liveId;; l1 = 0L)
            {
              localObject2 = localFinderObject.username;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              str = localFinderObject.objectNonceId;
              localObject2 = str;
              if (str == null) {
                localObject2 = "";
              }
              localCollection.add(new com.tencent.mm.plugin.finder.live.viewmodel.c(l2, l1, (String)localObject1, (String)localObject2, paramString, localFinderObject.sessionBuffer));
              break label589;
              bool = true;
              break;
            }
            label778:
            localb.setIncrementList((List)localCollection);
            localObject1 = getTAG();
            localObject2 = new StringBuilder("incrementList size: ");
            paramString = localb.getIncrementList();
            if (paramString != null) {}
            for (paramString = Integer.valueOf(paramString.size());; paramString = null)
            {
              Log.i((String)localObject1, paramString);
              localb.setPullType(((bn)paramq).pullType);
              paramString = ((bn)paramq).rr;
              if (paramString == null) {
                p.btv("rr");
              }
              paramString = paramString.aYK();
              if (paramString != null) {
                break;
              }
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
              AppMethodBeat.o(245807);
              throw paramString;
            }
            localb.setLastBuffer(((asw)paramString).LDs);
            localb.setHasMore(bool);
            paramString = (IResponse)localb;
          }
          else
          {
            paramString = null;
          }
        }
        label937:
        paramString = this.ufy.fetchEndCallback;
        if (paramString != null)
        {
          paramString.invoke(null);
          AppMethodBeat.o(245807);
          return;
        }
        AppMethodBeat.o(245807);
        return;
      }
      AppMethodBeat.o(245807);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$FinderLiveRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$LiveRelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "genLoadMoreNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getCmdId", "", "plugin-finder_release"})
  public final class c
    extends FinderLiveRelatedLoader.a
  {
    public c()
    {
      super();
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(245816);
      Object localObject = am.tuw;
      localObject = am.cXY();
      ((aov)localObject).scene = this.ufy.ufx.tCE;
      localObject = new bq(this.ufy.ufx.dLS, this.ufy.ufx.hFK, this.ufy.ufx.hwg, this.ufy.ufx.tsO, this.ufy.ufx.scene, this.ufy.ufx.uDl, this.ufy.ufx.iUY, (aov)localObject);
      ((bq)localObject).pullType = 2;
      localObject = (q)localObject;
      AppMethodBeat.o(245816);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3688;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$NearbyLiveRelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "genLoadMoreNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getCmdId", "", "plugin-finder_release"})
  public final class d
    extends FinderLiveRelatedLoader.a
  {
    public d()
    {
      super();
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(245817);
      Object localObject = am.tuw;
      localObject = am.cXY();
      ((aov)localObject).scene = this.ufy.ufx.tCE;
      localObject = new bn(this.ufy.ufx.hFK, this.ufy.ufx.hwg, this.ufy.ufx.tsO, this.ufy.ufx.tCE, this.ufy.ufx.uDl, this.ufy.ufx.iUY, (aov)localObject);
      ((bn)localObject).pullType = 2;
      localObject = (q)localObject;
      AppMethodBeat.o(245817);
      return localObject;
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