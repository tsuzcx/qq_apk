package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.db;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "refObjectId", "", "refObjectNonceId", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "RetransmitSourceData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRetransmitSourceContract$Loader
  extends BaseFinderFeedLoader
{
  final String ACm;
  final long refObjectId;
  final String refObjectNonceId;
  
  public FinderRetransmitSourceContract$Loader(String paramString1, long paramLong, String paramString2, g paramg, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(363562);
    this.ACm = paramString1;
    this.refObjectId = paramLong;
    this.refObjectNonceId = paramString2;
    AppMethodBeat.o(363562);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(363569);
    i locali = (i)new a();
    AppMethodBeat.o(363569);
    return locali;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader$RetransmitSourceData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends c
  {
    public a()
    {
      AppMethodBeat.i(364094);
      AppMethodBeat.o(364094);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(364121);
      s.u(paramp, "scene");
      db localdb = (db)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localdb.dWq().continueFlag == 0)) {}
      Object localObject1;
      Object localObject2;
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localdb.ACl;
        paramp = (com.tencent.mm.am.p)localObject1;
        if (localObject1 == null) {
          paramp = (List)new LinkedList();
        }
        localObject1 = (Iterable)paramp;
        paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderItem)((Iterator)localObject1).next();
          d.a locala = d.FND;
          paramp.add(d.a.a((FinderItem)localObject2));
        }
      }
      paramp = (List)paramp;
      if (!Util.isNullOrNil(paramp))
      {
        localObject1 = MMApplicationContext.getContext();
        if (((BaseFinderFeed)kotlin.a.p.oK(paramp)).feedObject.getId() == localdb.refObjectId) {
          break label293;
        }
        localObject2 = (BaseFinderFeed)kotlin.a.p.oK(paramp);
        localObject1 = ((Context)localObject1).getString(e.h.finder_deleted_tip2);
        s.s(localObject1, "context.getString(R.string.finder_deleted_tip2)");
        s.u(localObject1, "<set-?>");
        ((BaseFinderFeed)localObject2).headerWording = ((String)localObject1);
      }
      for (;;)
      {
        paramString = new FinderRetransmitSourceContract.b(paramInt1, paramInt2, paramString);
        paramString.setIncrementList(paramp);
        paramString.setPullType(localdb.pullType);
        paramString.setLastBuffer(localdb.dWq().lastBuffer);
        paramString.setHasMore(bool);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(364121);
        return paramString;
        label293:
        if (paramp.size() > 1)
        {
          localObject2 = (BaseFinderFeed)kotlin.a.p.oK(paramp);
          localObject1 = ((Context)localObject1).getString(e.h.finder_deleted_tip3);
          s.s(localObject1, "context.getString(R.string.finder_deleted_tip3)");
          s.u(localObject1, "<set-?>");
          ((BaseFinderFeed)localObject2).footerWording = ((String)localObject1);
        }
      }
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(364110);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new db(this.AYy.ACm, this.AYy.refObjectId, this.AYy.refObjectNonceId, this.AYy.getLastBuffer(), 2);
      AppMethodBeat.o(364110);
      return localp;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(364107);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new db(this.AYy.ACm, this.AYy.refObjectId, this.AYy.refObjectNonceId, this.AYy.getLastBuffer(), 0);
      AppMethodBeat.o(364107);
      return localp;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(364101);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3581));
      AppMethodBeat.o(364101);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader
 * JD-Core Version:    0.7.0.1
 */