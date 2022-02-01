package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "relatedTopic", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getRelatedTopic", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setRelatedTopic", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "getType", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderTopicTimelineResponse", "TopicTimelineDataFetcher", "plugin-finder_release"})
public final class FinderTopicTimelineUIContract$Loader
  extends BaseFinderFeedLoader
{
  private String TAG;
  final String dzZ;
  final aoy location;
  final arg rJv;
  public d.g.a.a<z> rTm;
  public long refObjectId;
  public cta saJ;
  final int type;
  
  public FinderTopicTimelineUIContract$Loader(int paramInt, String paramString, aoy paramaoy, e parame, arg paramarg, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202304);
    this.type = paramInt;
    this.dzZ = paramString;
    this.location = paramaoy;
    this.rJv = paramarg;
    this.TAG = "Finder.FinderTopicTimelineLoader";
    AppMethodBeat.o(202304);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202303);
    g localg = (g)new b();
    AppMethodBeat.o(202303);
    return localg;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(165995);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(165995);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.rTm;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(165995);
        return;
      }
    }
    AppMethodBeat.o(165995);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(165993);
    p.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(165993);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "totalCount", "", "errType", "", "errCode", "errMsg", "", "(JIILjava/lang/String;)V", "getTotalCount", "()J", "plugin-finder_release"})
  public static final class a
    extends IResponse<al>
  {
    private final long rTp;
    
    public a(long paramLong, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      this.rTp = paramLong;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$TopicTimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202301);
      p.h(paramn, "scene");
      ar localar = (ar)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localar.cyq() == 0)) {}
      FinderTopicTimelineUIContract.Loader.a locala;
      for (boolean bool = false;; bool = true)
      {
        locala = new FinderTopicTimelineUIContract.Loader.a(localar.cyw(), paramInt1, paramInt2, paramString);
        paramn = (Iterable)((ar)paramn).cyv();
        paramString = (Collection)new ArrayList(j.a(paramn, 10));
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          localObject1 = (FinderObject)paramn.next();
          Object localObject2 = FinderItem.syk;
          localObject1 = FinderItem.a.a((FinderObject)localObject1, 64);
          localObject2 = FinderTopicFeedUI.shU;
          ((Map)FinderTopicFeedUI.cCa()).put(Long.valueOf(((FinderItem)localObject1).getId()), localObject1);
          localObject2 = b.sAs;
          paramString.add(b.a.j((FinderItem)localObject1));
        }
      }
      locala.setIncrementList((List)paramString);
      paramn = getTAG();
      Object localObject1 = new StringBuilder("incrementList size: ");
      paramString = locala.getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        ad.i(paramn, paramString);
        locala.setPullType(localar.pullType);
        locala.setLastBuffer(localar.cyp());
        locala.setHasMore(bool);
        paramString = (IResponse)locala;
        AppMethodBeat.o(202301);
        return paramString;
      }
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202300);
      Object localObject;
      switch (this.saK.type)
      {
      default: 
        localObject = null;
      }
      for (;;)
      {
        localObject = (n)localObject;
        AppMethodBeat.o(202300);
        return localObject;
        localObject = new ar(this.saK.dzZ, Long.valueOf(this.saK.refObjectId), this.saK.getLastBuffer(), this.saK.rJv, this.saK.getContextObj());
        ((ar)localObject).pullType = 2;
        continue;
        localObject = this.saK.location.Gnu;
        p.g(localObject, "location.poiClassifyId");
        localObject = new ar((String)localObject, this.saK.location.dAp, this.saK.location.dyz, Long.valueOf(this.saK.refObjectId), this.saK.getLastBuffer(), this.saK.saJ, this.saK.rJv, this.saK.getContextObj());
        ((ar)localObject).pullType = 2;
      }
    }
    
    public final n genRefreshNetScene()
    {
      return null;
    }
    
    public final int getCmdId()
    {
      return 817;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader
 * JD-Core Version:    0.7.0.1
 */