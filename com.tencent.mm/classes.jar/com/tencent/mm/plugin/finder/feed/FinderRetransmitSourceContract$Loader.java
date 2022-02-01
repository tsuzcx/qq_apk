package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cc;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bid;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "refObjectId", "", "refObjectNonceId", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "RetransmitSourceData", "plugin-finder_release"})
public final class FinderRetransmitSourceContract$Loader
  extends BaseFinderFeedLoader
{
  final long refObjectId;
  final String refObjectNonceId;
  final String xcW;
  
  public FinderRetransmitSourceContract$Loader(String paramString1, long paramLong, String paramString2, g paramg, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(286757);
    this.xcW = paramString1;
    this.refObjectId = paramLong;
    this.refObjectNonceId = paramString2;
    AppMethodBeat.o(286757);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(286756);
    i locali = (i)new a();
    AppMethodBeat.o(286756);
    return locali;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader$RetransmitSourceData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(266898);
      p.k(paramq, "scene");
      cc localcc = (cc)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localcc.doR().continueFlag == 0)) {}
      Object localObject1;
      Object localObject2;
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localcc.xcV;
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
          c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          paramq.add(c.a.a((FinderItem)localObject2));
        }
      }
      paramq = (List)paramq;
      if (!Util.isNullOrNil(paramq))
      {
        localObject1 = MMApplicationContext.getContext();
        if (((BaseFinderFeed)j.lo(paramq)).feedObject.getId() == localcc.refObjectId) {
          break label293;
        }
        localObject2 = (BaseFinderFeed)j.lo(paramq);
        localObject1 = ((Context)localObject1).getString(b.j.finder_deleted_tip2);
        p.j(localObject1, "context.getString(R.string.finder_deleted_tip2)");
        p.k(localObject1, "<set-?>");
        ((BaseFinderFeed)localObject2).headerWording = ((String)localObject1);
      }
      for (;;)
      {
        paramString = new FinderRetransmitSourceContract.b(paramInt1, paramInt2, paramString);
        paramString.setIncrementList(paramq);
        paramString.setPullType(localcc.pullType);
        paramString.setLastBuffer(localcc.doR().lastBuffer);
        paramString.setHasMore(bool);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(266898);
        return paramString;
        label293:
        if (paramq.size() > 1)
        {
          localObject2 = (BaseFinderFeed)j.lo(paramq);
          localObject1 = ((Context)localObject1).getString(b.j.finder_deleted_tip3);
          p.j(localObject1, "context.getString(R.string.finder_deleted_tip3)");
          p.k(localObject1, "<set-?>");
          ((BaseFinderFeed)localObject2).footerWording = ((String)localObject1);
        }
      }
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(266897);
      q localq = (q)new cc(this.xAZ.xcW, this.xAZ.refObjectId, this.xAZ.refObjectNonceId, this.xAZ.getLastBuffer(), 2);
      AppMethodBeat.o(266897);
      return localq;
    }
    
    public final q genRefreshNetScene()
    {
      AppMethodBeat.i(266895);
      q localq = (q)new cc(this.xAZ.xcW, this.xAZ.refObjectId, this.xAZ.refObjectNonceId, this.xAZ.getLastBuffer(), 0);
      AppMethodBeat.o(266895);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(266894);
      List localList = j.listOf(Integer.valueOf(3581));
      AppMethodBeat.o(266894);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader
 * JD-Core Version:    0.7.0.1
 */