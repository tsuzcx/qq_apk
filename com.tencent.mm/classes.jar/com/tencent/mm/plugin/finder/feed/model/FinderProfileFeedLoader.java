package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "username", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "onFetchCallback", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileResponse;", "getOnFetchCallback", "setOnFetchCallback", "getUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "", "isObservePostEvent", "onFetchDone", "response", "requestLoadMore", "ProfileDataFetcher", "ProfileResponse", "plugin-finder_release"})
public final class FinderProfileFeedLoader
  extends BaseFinderFeedLoader
{
  private d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  private boolean isLoadingMore;
  private d.g.a.b<? super ProfileResponse, z> onFetchCallback;
  private final String username;
  
  public FinderProfileFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.e parame, String paramString, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202913);
    this.username = paramString;
    AppMethodBeat.o(202913);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<am> createDataFetch()
  {
    AppMethodBeat.i(202911);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new ProfileDataFetcher();
    AppMethodBeat.o(202911);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202912);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderProfileFeedLoader.createDataMerger.1(this);
    AppMethodBeat.o(202912);
    return localb;
  }
  
  public final d.g.a.b<IResponse<am>, z> getFetchEndCallback()
  {
    return this.fetchEndCallback;
  }
  
  public final long getLastItem()
  {
    AppMethodBeat.i(166044);
    int i = getDataList().size() - 1;
    while (i >= 0)
    {
      am localam = (am)getDataList().get(i);
      if (((localam instanceof BaseFinderFeed)) && (((BaseFinderFeed)localam).feedObject.getId() != 0L))
      {
        long l = ((BaseFinderFeed)localam).feedObject.getId();
        AppMethodBeat.o(166044);
        return l;
      }
      i -= 1;
    }
    AppMethodBeat.o(166044);
    return 0L;
  }
  
  public final d.g.a.b<ProfileResponse, z> getOnFetchCallback()
  {
    return this.onFetchCallback;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public final boolean isLoadingMore()
  {
    return this.isLoadingMore;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(166046);
    d.g.b.p.h(paramIResponse, "response");
    d.g.a.b localb;
    if ((!isInitOperation(paramIResponse)) && ((paramIResponse instanceof ProfileResponse)))
    {
      localb = this.onFetchCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    if (2 == paramIResponse.getPullType()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.isLoadingMore = false;
      }
      super.onFetchDone(paramIResponse);
      if ((i == 0) || (paramIResponse.getHasMore())) {
        break;
      }
      localb = this.fetchEndCallback;
      if (localb == null) {
        break;
      }
      localb.invoke(paramIResponse);
      AppMethodBeat.o(166046);
      return;
    }
    AppMethodBeat.o(166046);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(166045);
    if (this.isLoadingMore)
    {
      ae.i(getTAG(), "isLoadingMore return");
      AppMethodBeat.o(166045);
      return;
    }
    this.isLoadingMore = true;
    super.requestLoadMore();
    AppMethodBeat.o(166045);
  }
  
  public final void setFetchEndCallback(d.g.a.b<? super IResponse<am>, z> paramb)
  {
    this.fetchEndCallback = paramb;
  }
  
  public final void setLoadingMore(boolean paramBoolean)
  {
    this.isLoadingMore = paramBoolean;
  }
  
  public final void setOnFetchCallback(d.g.a.b<? super ProfileResponse, z> paramb)
  {
    this.onFetchCallback = paramb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "getCmdId", "mergeLocalData", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "nowList", "username", "start", "end", "plugin-finder_release"})
  public final class ProfileDataFetcher
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    private final List<FinderItem> mergeLocalData(List<? extends FinderItem> paramList, String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202906);
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; (i != 0) || ((d.g.b.p.i(paramString, com.tencent.mm.model.v.aAK()) ^ true)); i = 0)
      {
        AppMethodBeat.o(202906);
        return paramList;
      }
      if (com.tencent.mm.plugin.finder.feed.model.internal.g.access$getDEBUG$cp())
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.k(paramList, "nowList");
      }
      ae.i(getTAG(), "mergeLocalData start " + paramInt1 + " end " + paramInt2);
      Object localObject1 = new LinkedList();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      d.g.b.p.h(paramString, "username");
      paramString = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().ad(paramString, paramInt1, paramInt2);
      ((LinkedList)localObject1).addAll((Collection)paramList);
      localObject2 = (List)localObject1;
      if (((List)localObject2).size() > 1) {
        j.a((List)localObject2, (Comparator)new Comparator()
        {
          public final int compare(T paramAnonymousT1, T paramAnonymousT2)
          {
            AppMethodBeat.i(202897);
            int i = d.b.a.a((Comparable)Integer.valueOf(((FinderItem)paramAnonymousT2).getCreateTime()), (Comparable)Integer.valueOf(((FinderItem)paramAnonymousT1).getCreateTime()));
            AppMethodBeat.o(202897);
            return i;
          }
        });
      }
      c.a(paramString, (d.g.a.b)new q(paramList)
      {
        public final boolean invoke(FinderItem paramAnonymousFinderItem)
        {
          AppMethodBeat.i(202899);
          d.g.b.p.h(paramAnonymousFinderItem, "removeIt");
          Iterator localIterator = ((Iterable)this.$nowList).iterator();
          Object localObject;
          int i;
          if (localIterator.hasNext())
          {
            localObject = localIterator.next();
            FinderItem localFinderItem = (FinderItem)localObject;
            if ((localFinderItem.getLocalId() == paramAnonymousFinderItem.getLocalId()) || ((localFinderItem.field_id != 0L) && (localFinderItem.field_id == paramAnonymousFinderItem.field_id)) || (localFinderItem.getCreateTime() == paramAnonymousFinderItem.getCreateTime()))
            {
              i = 1;
              label99:
              if (i == 0) {
                break label122;
              }
            }
          }
          for (paramAnonymousFinderItem = localObject;; paramAnonymousFinderItem = null)
          {
            if ((FinderItem)paramAnonymousFinderItem == null) {
              break label129;
            }
            AppMethodBeat.o(202899);
            return true;
            i = 0;
            break label99;
            label122:
            break;
          }
          label129:
          AppMethodBeat.o(202899);
          return false;
        }
      });
      ((LinkedList)localObject1).addAll(0, (Collection)paramString);
      if (com.tencent.mm.plugin.finder.feed.model.internal.g.access$getDEBUG$cp())
      {
        paramList = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.k((List)localObject1, "newList");
      }
      ae.i(getTAG(), "dblist size:" + paramString.size());
      paramList = ((Iterable)paramString).iterator();
      while (paramList.hasNext())
      {
        paramString = (FinderItem)paramList.next();
        ae.i(getTAG(), "dblist item, localId:" + paramString.getLocalId() + ", id:" + paramString.getId());
      }
      paramList = (List)localObject1;
      AppMethodBeat.o(202906);
      return paramList;
    }
    
    public final FinderProfileFeedLoader.ProfileResponse callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(202904);
      Object localObject1 = this.this$0.getCache();
      if (localObject1 != null) {}
      Object localObject3;
      Object localObject4;
      for (localObject1 = ((e)localObject1).jhZ; (localObject1 != null) && (((ArrayList)localObject1).size() > 0); localObject1 = null)
      {
        ae.i(getTAG(), "use old data list, size: " + ((ArrayList)localObject1).size());
        localObject3 = new FinderProfileFeedLoader.ProfileResponse(0, 0, "", false, 8, null);
        ((FinderProfileFeedLoader.ProfileResponse)localObject3).setIncrementList((List)localObject1);
        localObject4 = this.this$0.getCache();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((e)localObject4).lastBuffer;
        }
        ((FinderProfileFeedLoader.ProfileResponse)localObject3).setLastBuffer((com.tencent.mm.bw.b)localObject1);
        AppMethodBeat.o(202904);
        return localObject3;
      }
      localObject1 = k.sLb;
      localObject1 = this.this$0.getUsername();
      if (((CharSequence)this.this$0.getUsername()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!d.g.b.p.i(this.this$0.getUsername(), com.tencent.mm.model.v.aAK()))) {
          break label345;
        }
      }
      label345:
      for (int i = 1;; i = 3)
      {
        localObject1 = k.a.dx((String)localObject1, i);
        if (localObject1 != null)
        {
          localObject2 = (FinderItem)j.F((List)localObject1, 0);
          if (localObject2 != null) {
            ((FinderItem)localObject2).getCreateTime();
          }
        }
        if (localObject1 != null)
        {
          localObject2 = (FinderItem)j.F((List)localObject1, ((List)localObject1).size() - 1);
          if (localObject2 != null) {
            ((FinderItem)localObject2).getCreateTime();
          }
        }
        localObject2 = mergeLocalData((List)localObject1, this.this$0.getUsername(), 0, 2147483647);
        localObject1 = new FinderProfileFeedLoader.ProfileResponse(0, 0, "", false, 8, null);
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderItem)((Iterator)localObject3).next();
          b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          ((Collection)localObject2).add(b.a.j((FinderItem)localObject4));
        }
        i = 0;
        break;
      }
      ((FinderProfileFeedLoader.ProfileResponse)localObject1).setIncrementList((List)localObject2);
      ((FinderProfileFeedLoader.ProfileResponse)localObject1).setLastBuffer(null);
      AppMethodBeat.o(202904);
      return localObject1;
    }
    
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202903);
      d.g.b.p.h(paramn, "scene");
      bf localbf = (bf)paramn;
      paramn = localbf.rr.aEV();
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(202903);
        throw paramString;
      }
      if (((FinderUserPageResponse)paramn).privateLock == 1) {}
      for (int i = 1; i != 0; i = 0)
      {
        ae.i(getTAG(), "dealOnSceneEnd private lock");
        paramString = new FinderProfileFeedLoader.ProfileResponse(paramInt1, paramInt2, paramString, true);
        paramString.setIncrementList((List)d.a.v.NhH);
        paramString.setPullType(localbf.pullType);
        paramString.setMaxid(localbf.cAr());
        paramString.setHasMore(false);
        paramString.setLastBuffer(localbf.getLastBuffer());
        paramString = (IResponse)paramString;
        AppMethodBeat.o(202903);
        return paramString;
      }
      boolean bool;
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool = localbf.rRg;
        localObject = localbf.rRC;
        paramn = (n)localObject;
        if (localObject == null) {
          paramn = (List)new LinkedList();
        }
        if (localbf.pullType != 1) {
          break label381;
        }
        paramn = mergeLocalData(paramn, localbf.rRh, 0, 2147483647);
      }
      label381:
      for (;;)
      {
        paramString = new FinderProfileFeedLoader.ProfileResponse(paramInt1, paramInt2, paramString, false, 8, null);
        localObject = (Iterable)paramn;
        paramn = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
            b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            paramn.add(b.a.j(localFinderItem));
            continue;
            bool = true;
            break;
          }
        }
        paramString.setIncrementList((List)paramn);
        paramString.setPullType(localbf.pullType);
        paramString.setMaxid(localbf.cAr());
        paramString.setHasMore(bool);
        paramString.setLastBuffer(localbf.getLastBuffer());
        paramString = (IResponse)paramString;
        AppMethodBeat.o(202903);
        return paramString;
      }
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202902);
      long l = this.this$0.getLastItem();
      n localn = (n)new bf(this.this$0.getUsername(), l, this.this$0.getLastBuffer(), 2, this.this$0.getContextObj());
      AppMethodBeat.o(202902);
      return localn;
    }
    
    public final bf genRefreshNetScene()
    {
      AppMethodBeat.i(202900);
      bf localbf = new bf(this.this$0.getUsername(), 0L, null, 1, this.this$0.getContextObj());
      AppMethodBeat.o(202900);
      return localbf;
    }
    
    public final int getCmdId()
    {
      return 3736;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "isPrivateLock", "", "(IILjava/lang/String;Z)V", "()Z", "maxid", "", "getMaxid", "()J", "setMaxid", "(J)V", "plugin-finder_release"})
  public static final class ProfileResponse
    extends IResponse<am>
  {
    private final boolean isPrivateLock;
    private long maxid;
    
    public ProfileResponse(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
    {
      super(paramInt2, paramString);
      this.isPrivateLock = paramBoolean;
    }
    
    public final long getMaxid()
    {
      return this.maxid;
    }
    
    public final boolean isPrivateLock()
    {
      return this.isPrivateLock;
    }
    
    public final void setMaxid(long paramLong)
    {
      this.maxid = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader
 * JD-Core Version:    0.7.0.1
 */