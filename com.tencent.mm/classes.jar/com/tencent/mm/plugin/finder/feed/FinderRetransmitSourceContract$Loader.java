package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "refObjectId", "", "refObjectNonceId", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "RetransmitSourceData", "plugin-finder_release"})
public final class FinderRetransmitSourceContract$Loader
  extends BaseFinderFeedLoader
{
  final String rRD;
  final long refObjectId;
  final String refObjectNonceId;
  
  public FinderRetransmitSourceContract$Loader(String paramString1, long paramLong, String paramString2, e parame, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202490);
    this.rRD = paramString1;
    this.refObjectId = paramLong;
    this.refObjectNonceId = paramString2;
    AppMethodBeat.o(202490);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202489);
    g localg = (g)new a();
    AppMethodBeat.o(202489);
    return localg;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader$RetransmitSourceData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202488);
      p.h(paramn, "scene");
      aw localaw = (aw)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localaw.cAi().continueFlag == 0)) {}
      Object localObject1;
      Object localObject2;
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localaw.rRC;
        paramn = (n)localObject1;
        if (localObject1 == null) {
          paramn = (List)new LinkedList();
        }
        localObject1 = (Iterable)paramn;
        paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderItem)((Iterator)localObject1).next();
          b.a locala = b.sLq;
          paramn.add(b.a.j((FinderItem)localObject2));
        }
      }
      paramn = (List)paramn;
      if (!bu.ht(paramn))
      {
        localObject1 = ak.getContext();
        if (((BaseFinderFeed)j.jl(paramn)).feedObject.getId() == localaw.refObjectId) {
          break label292;
        }
        localObject2 = (BaseFinderFeed)j.jl(paramn);
        localObject1 = ((Context)localObject1).getString(2131759189);
        p.g(localObject1, "context.getString(R.string.finder_deleted_tip2)");
        p.h(localObject1, "<set-?>");
        ((BaseFinderFeed)localObject2).headerWording = ((String)localObject1);
      }
      for (;;)
      {
        paramString = new FinderRetransmitSourceContract.b(paramInt1, paramInt2, paramString);
        paramString.setIncrementList(paramn);
        paramString.setPullType(localaw.pullType);
        paramString.setLastBuffer(localaw.cAi().lastBuffer);
        paramString.setHasMore(bool);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(202488);
        return paramString;
        label292:
        if (paramn.size() > 1)
        {
          localObject2 = (BaseFinderFeed)j.jl(paramn);
          localObject1 = ((Context)localObject1).getString(2131759190);
          p.g(localObject1, "context.getString(R.string.finder_deleted_tip3)");
          p.h(localObject1, "<set-?>");
          ((BaseFinderFeed)localObject2).footerWording = ((String)localObject1);
        }
      }
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202487);
      n localn = (n)new aw(this.sgC.rRD, this.sgC.refObjectId, this.sgC.refObjectNonceId, this.sgC.getLastBuffer(), 2);
      AppMethodBeat.o(202487);
      return localn;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202486);
      n localn = (n)new aw(this.sgC.rRD, this.sgC.refObjectId, this.sgC.refObjectNonceId, this.sgC.getLastBuffer(), 0);
      AppMethodBeat.o(202486);
      return localn;
    }
    
    public final int getCmdId()
    {
      return 3581;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader
 * JD-Core Version:    0.7.0.1
 */