package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.df;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fromScene", "", "getFromScene", "()Ljava/lang/Integer;", "setFromScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "getFromType", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "setFromType", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;)V", "poiPrepare", "Lcom/tencent/mm/protocal/protobuf/PoiPrepare;", "getPoiPrepare", "()Lcom/tencent/mm/protocal/protobuf/PoiPrepare;", "setPoiPrepare", "(Lcom/tencent/mm/protocal/protobuf/PoiPrepare;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderPoiStreamListResponse", "PoiDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiFeedLoader
  extends BaseFinderFeedLoader
{
  public static final a BhF;
  private c BhG;
  public fei BhH;
  public eer BhI;
  public bi.a BhJ;
  public Integer BhK;
  public b<? super IResponse<cc>, ah> fetchEndCallback;
  private boolean hasMore;
  
  static
  {
    AppMethodBeat.i(366253);
    BhF = new a((byte)0);
    AppMethodBeat.o(366253);
  }
  
  private FinderPoiFeedLoader(byte paramByte)
  {
    this();
  }
  
  public FinderPoiFeedLoader(bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366230);
    this.BhG = new c();
    AppMethodBeat.o(366230);
  }
  
  public final i<cc> createDataFetch()
  {
    return (i)this.BhG;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366265);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(366265);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366270);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366270);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    b localb = this.fetchEndCallback;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(366270);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$FinderPoiStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setFinderContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "friendLikeCount", "getFriendLikeCount", "()I", "setFriendLikeCount", "(I)V", "hasFeedData", "", "getHasFeedData", "()Z", "setHasFeedData", "(Z)V", "noticeWording", "getNoticeWording", "()Ljava/lang/String;", "setNoticeWording", "(Ljava/lang/String;)V", "onlyShowPoiName", "getOnlyShowPoiName", "setOnlyShowPoiName", "poiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getPoiDetail", "()Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "setPoiDetail", "(Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;)V", "videoCount", "getVideoCount", "setVideoCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public int AXs;
    public fes BhL;
    public boolean BhM;
    public String BhN = "";
    public boolean BhO;
    public FinderContact BhP;
    public int friendLikeCount;
    
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public c()
    {
      AppMethodBeat.i(366043);
      AppMethodBeat.o(366043);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      boolean bool2 = true;
      AppMethodBeat.i(366083);
      s.u(paramp, "scene");
      if ((paramp instanceof df))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((df)paramp).dVZ() == 0)) {}
        FinderPoiFeedLoader.b localb;
        for (boolean bool1 = false;; bool1 = true)
        {
          localb = new FinderPoiFeedLoader.b(paramInt1, paramInt2, paramString);
          localObject1 = (Iterable)((df)paramp).dWd();
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.Companion;
            localObject2 = FinderItem.a.e((FinderObject)localObject2, 33040);
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString.add(d.a.a((FinderItem)localObject2));
          }
        }
        localb.setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.a(((df)paramp).dWd(), 33040, this.BhQ.getContextObj());
        if (((df)paramp).pullType != 2)
        {
          paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          paramString = localb.getIncrementList();
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(366083);
            throw paramString;
          }
          d.a.c(paramString, 33040, true);
        }
        paramString = localb.getIncrementList();
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
        {
          Log.i("Finder.FinderPoiFeedLoader", s.X("incrementList size: ", paramString));
          localb.setPullType(((df)paramp).pullType);
          localb.setLastBuffer(((df)paramp).dVY());
          localb.setHasMore(bool1);
          paramString = c.c.b(((df)paramp).rr.otC);
          if (paramString != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(366083);
          throw paramString;
        }
        localb.BhL = ((bsk)paramString).aaae;
        if (localb.BhL != null)
        {
          paramString = localb.getIncrementList();
          if (paramString != null) {
            break label430;
          }
          paramInt1 = 0;
          if (paramInt1 <= 0) {
            break label440;
          }
        }
        label430:
        label440:
        for (bool1 = true;; bool1 = false)
        {
          localb.BhM = bool1;
          paramString = c.c.b(((df)paramp).rr.otC);
          if (paramString != null) {
            break label446;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(366083);
          throw paramString;
          paramInt1 = paramString.size();
          break;
        }
        label446:
        Object localObject1 = ((bsk)paramString).YYd;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        localb.BhN = paramString;
        paramString = c.c.b(((df)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(366083);
          throw paramString;
        }
        if (((bsk)paramString).aaai == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localb.BhO = bool1;
          paramString = c.c.b(((df)paramp).rr.otC);
          if (paramString != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(366083);
          throw paramString;
        }
        localb.AXs = ((bsk)paramString).aaaj;
        paramString = c.c.b(((df)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(366083);
          throw paramString;
        }
        localb.BhP = ((bsk)paramString).contact;
        paramString = c.c.b(((df)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(366083);
          throw paramString;
        }
        localb.friendLikeCount = ((bsk)paramString).aaal;
        paramString = this.BhQ;
        paramp = c.c.b(((df)paramp).rr.otC);
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(366083);
          throw paramString;
        }
        paramString.BhI = ((bsk)paramp).aaak;
        paramString = (IResponse)localb;
        AppMethodBeat.o(366083);
        return paramString;
      }
      AppMethodBeat.o(366083);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366067);
      Object localObject = this.BhQ.BhH;
      bi.a locala = this.BhQ.BhJ;
      FinderPoiFeedLoader localFinderPoiFeedLoader = this.BhQ;
      if ((localObject != null) && (locala != null))
      {
        localObject = new df((fei)localObject, locala, localFinderPoiFeedLoader.getLastBuffer(), localFinderPoiFeedLoader.BhK, (byte)0);
        ((df)localObject).pullType = 2;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.am.p)localObject;
        AppMethodBeat.o(366067);
        return localObject;
        localObject = null;
      }
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366060);
      Object localObject = this.BhQ.BhH;
      bi.a locala = this.BhQ.BhJ;
      FinderPoiFeedLoader localFinderPoiFeedLoader = this.BhQ;
      if ((localObject != null) && (locala != null))
      {
        localObject = new df((fei)localObject, locala, localFinderPoiFeedLoader.getLastBuffer(), localFinderPoiFeedLoader.BhK, (byte)0);
        ((df)localObject).pullType = 0;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.am.p)localObject;
        AppMethodBeat.o(366060);
        return localObject;
        localObject = null;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366050);
      List localList = kotlin.a.p.listOf(Integer.valueOf(5225));
      AppMethodBeat.o(366050);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends BaseFeedLoader<cc>.a
  {
    d(FinderPoiFeedLoader paramFinderPoiFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366073);
      AppMethodBeat.o(366073);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final b<? super IResponse<cc>, ah> paramb)
    {
      int j = 1;
      AppMethodBeat.i(366088);
      s.u(paramIResponse, "response");
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(paramIResponse.getPullType());
      boolean bool;
      label77:
      List localList;
      int i;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_timeline_refresh_nothing_tip));
        locald.agJs = 1;
        if (paramIResponse.getPullType() == 0) {
          break label247;
        }
        bool = true;
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        if (((locald.actionType == 0) || (locald.actionType == 4)) && (locald.agJv > 0)) {
          locald.agJt = null;
        }
        Log.i("Finder.FinderPoiFeedLoader", s.X("[onFetchRefreshDone]  reason=", locald));
        localList = paramIResponse.getIncrementList();
        if (localList != null) {
          break label253;
        }
        i = 0;
        label149:
        if (!paramIResponse.getHasMore()) {
          break label264;
        }
        if (i > this.BhQ.getDataList().size()) {
          break label351;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.BhQ, paramb, paramIResponse));
        AppMethodBeat.o(366088);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
        locald.agJs = -1;
        break;
        label247:
        bool = false;
        break label77;
        label253:
        i = localList.size();
        break label149;
        label264:
        if ((this.BhQ.getDataList().size() == 0) || (i == 0) || (this.BhQ.getDataList().size() <= i))
        {
          localList = paramIResponse.getIncrementList();
          if ((localList != null) && (localList.containsAll((Collection)kotlin.a.p.p((Iterable)this.BhQ.getDataList())) == true)) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label351;
            }
            i = 6;
            break;
          }
        }
        label351:
        i = 4;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderPoiFeedLoader.d paramd, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd1, FinderPoiFeedLoader paramFinderPoiFeedLoader, b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader
 * JD-Core Version:    0.7.0.1
 */