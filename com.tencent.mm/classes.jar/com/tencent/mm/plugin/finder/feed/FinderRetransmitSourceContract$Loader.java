package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bz;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "refObjectId", "", "refObjectNonceId", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "RetransmitSourceData", "plugin-finder_release"})
public final class FinderRetransmitSourceContract$Loader
  extends BaseFinderFeedLoader
{
  final long refObjectId;
  final String refObjectNonceId;
  final String tvp;
  
  public FinderRetransmitSourceContract$Loader(String paramString1, long paramLong, String paramString2, e parame, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244116);
    this.tvp = paramString1;
    this.refObjectId = paramLong;
    this.refObjectNonceId = paramString2;
    AppMethodBeat.o(244116);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244115);
    g localg = (g)new a();
    AppMethodBeat.o(244115);
    return localg;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader$RetransmitSourceData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(244114);
      p.h(paramq, "scene");
      bz localbz = (bz)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localbz.cYZ().continueFlag == 0)) {}
      Object localObject1;
      Object localObject2;
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localbz.tvo;
        paramq = (q)localObject1;
        if (localObject1 == null) {
          paramq = (List)new LinkedList();
        }
        localObject1 = (Iterable)paramq;
        paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderItem)((Iterator)localObject1).next();
          c.a locala = c.vGN;
          paramq.add(c.a.s((FinderItem)localObject2));
        }
      }
      paramq = (List)paramq;
      if (!Util.isNullOrNil(paramq))
      {
        localObject1 = MMApplicationContext.getContext();
        if (((BaseFinderFeed)j.ks(paramq)).feedObject.getId() == localbz.refObjectId) {
          break label292;
        }
        localObject2 = (BaseFinderFeed)j.ks(paramq);
        localObject1 = ((Context)localObject1).getString(2131759666);
        p.g(localObject1, "context.getString(R.string.finder_deleted_tip2)");
        p.h(localObject1, "<set-?>");
        ((BaseFinderFeed)localObject2).headerWording = ((String)localObject1);
      }
      for (;;)
      {
        paramString = new FinderRetransmitSourceContract.b(paramInt1, paramInt2, paramString);
        paramString.setIncrementList(paramq);
        paramString.setPullType(localbz.pullType);
        paramString.setLastBuffer(localbz.cYZ().lastBuffer);
        paramString.setHasMore(bool);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(244114);
        return paramString;
        label292:
        if (paramq.size() > 1)
        {
          localObject2 = (BaseFinderFeed)j.ks(paramq);
          localObject1 = ((Context)localObject1).getString(2131759667);
          p.g(localObject1, "context.getString(R.string.finder_deleted_tip3)");
          p.h(localObject1, "<set-?>");
          ((BaseFinderFeed)localObject2).footerWording = ((String)localObject1);
        }
      }
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244113);
      q localq = (q)new bz(this.tQj.tvp, this.tQj.refObjectId, this.tQj.refObjectNonceId, this.tQj.getLastBuffer(), 2);
      AppMethodBeat.o(244113);
      return localq;
    }
    
    public final q genRefreshNetScene()
    {
      AppMethodBeat.i(244112);
      q localq = (q)new bz(this.tQj.tvp, this.tQj.refObjectId, this.tQj.refObjectNonceId, this.tQj.getLastBuffer(), 0);
      AppMethodBeat.o(244112);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244111);
      List localList = j.listOf(Integer.valueOf(3581));
      AppMethodBeat.o(244111);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader
 * JD-Core Version:    0.7.0.1
 */