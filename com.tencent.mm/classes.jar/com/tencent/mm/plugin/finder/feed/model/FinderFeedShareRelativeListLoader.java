package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.finder.cgi.bo;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.cd;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "encryptedFeedId", "", "nonceId", "tabType", "", "isFromAd", "", "shareScene", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPostingScene", "(JLjava/lang/String;Ljava/lang/String;IZILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "setFeedId", "(J)V", "fetchCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchCallback", "(Lkotlin/jvm/functions/Function1;)V", "fetchEndCallback", "getFetchEndCallback", "setFetchEndCallback", "finderStreamCards", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getFinderStreamCards", "()Ljava/util/List;", "setFinderStreamCards", "(Ljava/util/List;)V", "finderUserName", "getFinderUserName", "setFinderUserName", "(Ljava/lang/String;)V", "fromUserName", "getFromUserName", "setFromUserName", "hasRefreshFinish", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "isOpenEntranceTipShown", "setOpenEntranceTipShown", "getNonceId", "getSessionId", "getShareScene", "()I", "getTabType", "toUserName", "getToUserName", "setToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "isObservePostEvent", "onFetchDone", "response", "Companion", "FeedShareRelDataFetcher", "FinderShareRelativeListResponse", "UserPageDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedShareRelativeListLoader
  extends BaseFinderFeedLoader
{
  public static final a Bgb;
  final String ABC;
  public List<? extends bwa> ALr;
  final boolean AVa;
  private final boolean Bgc;
  public boolean Bgd;
  public kotlin.g.a.b<? super IResponse<cc>, ah> Bge;
  private boolean Bgf;
  public long feedId;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  public String hHa;
  final int hJx;
  public String hYg;
  final String nonceId;
  final String sessionId;
  final int shareScene;
  public String zDJ;
  
  static
  {
    AppMethodBeat.i(366281);
    Bgb = new a((byte)0);
    AppMethodBeat.o(366281);
  }
  
  public FinderFeedShareRelativeListLoader(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString3, bui parambui, boolean paramBoolean2)
  {
    super(parambui);
    AppMethodBeat.i(366277);
    this.feedId = paramLong;
    this.ABC = paramString1;
    this.nonceId = paramString2;
    this.hJx = paramInt1;
    this.Bgc = paramBoolean1;
    this.shareScene = paramInt2;
    this.sessionId = paramString3;
    this.AVa = paramBoolean2;
    this.zDJ = "";
    this.hYg = "";
    this.hHa = "";
    AppMethodBeat.o(366277);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
  {
    AppMethodBeat.i(366288);
    if (this.Bgc)
    {
      locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new d();
      AppMethodBeat.o(366288);
      return locali;
    }
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new b();
    AppMethodBeat.o(366288);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366293);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(366293);
    return locald;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366308);
    kotlin.g.b.s.u(paramIResponse, "response");
    if ((paramIResponse.getPullType() == 0) || (paramIResponse.getPullType() == 1000))
    {
      this.Bgf = true;
      Log.d(getTAG(), kotlin.g.b.s.X("refresh finish pullType = ", Integer.valueOf(paramIResponse.getPullType())));
    }
    if ((paramIResponse.getPullType() == 2) && (!this.Bgf))
    {
      Log.d(getTAG(), "loadmore before refresh");
      AppMethodBeat.o(366308);
      return;
    }
    if (!isInitOperation(paramIResponse))
    {
      localb = this.Bge;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    if (paramIResponse.getPullType() == 0) {
      paramIResponse.setPullType(2);
    }
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366308);
      return;
    }
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(366308);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$Companion;", "", "()V", "TYPE_GUIDE", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "TaskDataCallbackWrapper", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    private final com.tencent.mm.loader.f.h ADY;
    
    public b()
    {
      AppMethodBeat.i(365925);
      this.ADY = new com.tencent.mm.loader.f.h("FeedShareRelData");
      AppMethodBeat.o(365925);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(365958);
      super.alive();
      this.ADY.start();
      AppMethodBeat.o(365958);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(365970);
      FinderFeedShareRelativeListLoader.c localc = new FinderFeedShareRelativeListLoader.c(0, 0, "", "");
      localc.setPullType(1000);
      Object localObject1 = this.Bgg.getCache();
      int i;
      if (localObject1 != null)
      {
        Object localObject2 = (Collection)((s)localObject1).pUj;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label146;
        }
        i = 1;
        if (i != 0) {
          break label151;
        }
        i = 1;
        label70:
        if (i == 0) {
          break label156;
        }
        label74:
        if (localObject1 != null)
        {
          localObject2 = this.Bgg;
          Log.i(getTAG(), kotlin.g.b.s.X("FeedShareRelDataFetcher callInit: use old data list, size: ", Integer.valueOf(((s)localObject1).pUj.size())));
          localc.setIncrementList((List)((s)localObject1).pUj);
          localObject1 = ((FinderFeedShareRelativeListLoader)localObject2).getCache();
          if (localObject1 != null) {
            break label161;
          }
        }
      }
      label146:
      label151:
      label156:
      label161:
      for (localObject1 = null;; localObject1 = ((s)localObject1).lastBuffer)
      {
        localc.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localObject1 = (IResponse)localc;
        AppMethodBeat.o(365970);
        return localObject1;
        i = 0;
        break;
        i = 0;
        break label70;
        localObject1 = null;
        break label74;
      }
    }
    
    public final void dead()
    {
      AppMethodBeat.i(365964);
      super.dead();
      this.ADY.stop();
      AppMethodBeat.o(365964);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366017);
      kotlin.g.b.s.u(paramp, "scene");
      boolean bool1;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      label243:
      Object localObject6;
      boolean bool3;
      label605:
      label609:
      boolean bool2;
      label667:
      Object localObject7;
      Object localObject8;
      label740:
      label766:
      Object localObject9;
      label778:
      label781:
      label783:
      label872:
      Long localLong;
      long l;
      if ((paramp instanceof ch))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (bool1 = ((ch)paramp).dVN();; bool1 = true)
        {
          localObject2 = this.Bgg;
          localObject1 = c.c.b(((ch)paramp).rr.otC);
          if (localObject1 != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(366017);
          throw paramString;
          localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
          com.tencent.mm.plugin.finder.report.s.d(this.Bgg.hJx, this.Bgg.getContextObj());
        }
        localObject1 = ((baw)localObject1).ZLL;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((bwe)localObject1).ZLJ)
        {
          ((FinderFeedShareRelativeListLoader)localObject2).ALr = ((List)localObject1);
          localObject1 = new FinderFeedShareRelativeListLoader.c(paramInt1, paramInt2, paramString, "");
          localObject2 = ((ch)paramp).dVP();
          paramString = this.Bgg.getContextObj();
          if (paramString == null) {
            break label243;
          }
          localObject3 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (FinderObject)((Iterator)localObject3).next();
            localObject5 = z.FrZ;
            z.a((FinderObject)localObject4, paramString.AJo);
          }
        }
        paramString = ah.aiuX;
        paramString = ah.aiuX;
        paramString = kotlin.a.p.oL((List)this.Bgg.getDataList());
        if ((paramString instanceof BaseFinderFeed)) {}
        for (paramString = (BaseFinderFeed)paramString;; paramString = null)
        {
          if ((((ch)paramp).pullType == 0) && (paramString != null)) {
            kotlin.a.p.e((List)localObject2, (kotlin.g.a.b)new b(paramString));
          }
          localObject3 = (List)new ArrayList();
          localObject4 = (Iterable)localObject2;
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FinderObject)((Iterator)localObject4).next();
            localObject6 = FinderItem.Companion;
            localObject5 = FinderItem.a.e((FinderObject)localObject5, 256);
            localObject6 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString.add(d.a.a((FinderItem)localObject5));
          }
        }
        ((List)localObject3).addAll((Collection)paramString);
        paramString = ah.aiuX;
        paramString = ((ch)paramp).dVO().ZLM;
        if (paramString != null)
        {
          paramString = paramString.ZEn;
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              localObject4 = (aty)paramString.next();
              if (((aty)localObject4).type == 1) {
                ((FinderFeedShareRelativeListLoader.c)localObject1).Bgp = ((aty)localObject4).ZEo;
              }
            }
            paramString = ah.aiuX;
          }
        }
        bool3 = bool1;
        if (((ch)paramp).pullType == 0)
        {
          localObject4 = ((ch)paramp).dVO().ZLL;
          localObject5 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject5).hasNext())
          {
            paramString = ((Iterator)localObject5).next();
            localObject6 = (cc)paramString;
            if (((localObject6 instanceof BaseFinderFeed)) && (((cc)localObject6).bZA() != ((ch)paramp).feedId))
            {
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label766;
              }
              paramString = (cc)paramString;
              bool2 = bool1;
              if (localObject4 == null) {
                break label1070;
              }
              localObject5 = ((bwe)localObject4).ZLJ;
              bool2 = bool1;
              if (localObject5 == null) {
                break label1070;
              }
              localObject6 = (Iterable)localObject5;
              localObject5 = (Collection)new ArrayList();
              localObject6 = ((Iterable)localObject6).iterator();
            }
          }
          for (;;)
          {
            if (!((Iterator)localObject6).hasNext()) {
              break label783;
            }
            localObject7 = ((Iterator)localObject6).next();
            localObject8 = (bwa)localObject7;
            if ((((bwa)localObject8).AYX == 3) && (((bwa)localObject8).object != null))
            {
              localObject8 = ((bwa)localObject8).object;
              kotlin.g.b.s.s(localObject8, "it.`object`");
              if (!((Collection)localObject8).isEmpty())
              {
                paramInt1 = 1;
                if (paramInt1 == 0) {
                  break label778;
                }
              }
            }
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label781;
              }
              ((Collection)localObject5).add(localObject7);
              break label667;
              paramInt1 = 0;
              break label605;
              break;
              paramString = null;
              break label609;
              paramInt1 = 0;
              break label740;
            }
          }
          localObject6 = (Iterable)localObject5;
          localObject5 = this.Bgg;
          localObject6 = ((Iterable)localObject6).iterator();
          if (((Iterator)localObject6).hasNext())
          {
            localObject8 = (bwa)((Iterator)localObject6).next();
            localObject7 = new ah.d();
            localObject9 = ((bwe)localObject4).aaeh;
            kotlin.g.b.s.s(localObject9, "layoutInfo.layoutIds");
            localObject9 = (List)localObject9;
            paramInt1 = 0;
            localObject9 = ((List)localObject9).iterator();
            if (((Iterator)localObject9).hasNext())
            {
              localLong = (Long)((Iterator)localObject9).next();
              l = ((bwa)localObject8).ECY;
              if (localLong != null) {}
            }
          }
        }
      }
      label908:
      label912:
      label1070:
      label1633:
      label1634:
      label1636:
      label1637:
      for (;;)
      {
        paramInt2 = 0;
        if (paramInt2 != 0)
        {
          ((ah.d)localObject7).aixb = paramInt1;
          if (((ah.d)localObject7).aixb > ((List)localObject3).size()) {
            ((ah.d)localObject7).aixb = ((List)localObject3).size();
          }
          if ((paramString == null) || (((ah.d)localObject7).aixb <= 0) || (((ah.d)localObject7).aixb > ((List)localObject3).size())) {
            break label1636;
          }
          paramInt1 = ((ah.d)localObject7).aixb;
          localObject8 = cd.EDI;
          ((List)localObject3).add(paramInt1, cd.eDJ());
          kotlin.a.p.e((List)localObject3, (kotlin.g.a.b)new c((List)localObject3, (ah.d)localObject7));
          this.ADY.clean();
          ((FinderFeedShareRelativeListLoader)localObject5).Bgd = true;
          bool1 = false;
        }
        for (;;)
        {
          break;
          if (localLong.longValue() != l) {
            break label1637;
          }
          paramInt2 = 1;
          break label908;
          paramInt1 += 1;
          break label872;
          paramInt1 = -1;
          break label912;
          localObject5 = ah.aiuX;
          bool2 = bool1;
          bool3 = bool2;
          if (!this.Bgg.Bgd)
          {
            bool3 = bool2;
            if (localObject4 != null)
            {
              localObject5 = ((bwe)localObject4).aadF;
              bool3 = bool2;
              if (localObject5 != null)
              {
                localObject6 = (Iterable)localObject5;
                localObject5 = (Collection)new ArrayList();
                localObject6 = ((Iterable)localObject6).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  localObject7 = ((Iterator)localObject6).next();
                  if (((bwc)localObject7).aadB == 3) {}
                  for (paramInt1 = 1;; paramInt1 = 0)
                  {
                    if (paramInt1 == 0) {
                      break label1190;
                    }
                    ((Collection)localObject5).add(localObject7);
                    break;
                  }
                }
                localObject6 = (Iterable)localObject5;
                localObject5 = this.Bgg;
                localObject6 = ((Iterable)localObject6).iterator();
                bool1 = bool2;
                if (((Iterator)localObject6).hasNext())
                {
                  localObject8 = (bwc)((Iterator)localObject6).next();
                  localObject7 = new ah.d();
                  localObject9 = ((bwe)localObject4).aaeh;
                  kotlin.g.b.s.s(localObject9, "layoutInfo.layoutIds");
                  localObject9 = (List)localObject9;
                  paramInt1 = 0;
                  localObject9 = ((List)localObject9).iterator();
                  if (((Iterator)localObject9).hasNext())
                  {
                    localLong = (Long)((Iterator)localObject9).next();
                    l = ((bwc)localObject8).ECY;
                    if (localLong != null) {}
                  }
                }
              }
            }
          }
          for (;;)
          {
            paramInt2 = 0;
            if (paramInt2 != 0)
            {
              ((ah.d)localObject7).aixb = paramInt1;
              if (((ah.d)localObject7).aixb > ((List)localObject3).size()) {
                ((ah.d)localObject7).aixb = ((List)localObject3).size();
              }
              if ((paramString == null) || (((ah.d)localObject7).aixb <= 0) || (((ah.d)localObject7).aixb > ((List)localObject3).size())) {
                break label1633;
              }
              paramInt1 = ((ah.d)localObject7).aixb;
              localObject8 = cd.EDI;
              ((List)localObject3).add(paramInt1, cd.eDJ());
              kotlin.a.p.e((List)localObject3, (kotlin.g.a.b)new d((List)localObject3, (ah.d)localObject7));
              this.ADY.clean();
              ((FinderFeedShareRelativeListLoader)localObject5).Bgd = true;
              bool1 = false;
            }
            for (;;)
            {
              break;
              if (localLong.longValue() != l) {
                break label1634;
              }
              paramInt2 = 1;
              break label1321;
              paramInt1 += 1;
              break label1285;
              paramInt1 = -1;
              break label1325;
              paramString = ah.aiuX;
              bool3 = bool1;
              ((FinderFeedShareRelativeListLoader.c)localObject1).setIncrementList((List)localObject3);
              paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
              d.a.a((List)localObject2, 1, this.Bgg.getContextObj());
              localObject2 = getTAG();
              paramString = ((FinderFeedShareRelativeListLoader.c)localObject1).getIncrementList();
              if (paramString == null) {}
              for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
              {
                Log.i((String)localObject2, kotlin.g.b.s.X("incrementList size: ", paramString));
                ((FinderFeedShareRelativeListLoader.c)localObject1).setPullType(((ch)paramp).pullType);
                ((FinderFeedShareRelativeListLoader.c)localObject1).setLastBuffer(((ch)paramp).dVJ());
                ((FinderFeedShareRelativeListLoader.c)localObject1).setHasMore(bool3);
                paramp = ((ch)paramp).getWording();
                paramString = paramp;
                if (paramp == null) {
                  paramString = "";
                }
                ((FinderFeedShareRelativeListLoader.c)localObject1).avU(paramString);
                paramString = (IResponse)localObject1;
                AppMethodBeat.o(366017);
                return paramString;
              }
              AppMethodBeat.o(366017);
              return null;
            }
          }
        }
      }
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, final boolean paramBoolean)
    {
      AppMethodBeat.i(365980);
      kotlin.g.b.s.u(paramh, "callback");
      this.ADY.a(new g((kotlin.g.a.b)new e(this, paramObject, paramh, paramBoolean)));
      AppMethodBeat.o(365980);
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(365989);
      if (this.Bgg.AVa)
      {
        AppMethodBeat.o(365989);
        return null;
      }
      Object localObject = new ch(this.Bgg.feedId, this.Bgg.nonceId, this.Bgg.hJx, this.Bgg.getLastBuffer(), null, this.Bgg.shareScene, this.Bgg.hYg, this.Bgg.hHa, this.Bgg.sessionId, this.Bgg.getContextObj(), 0.0F, 0.0F, 6656);
      ((ch)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(365989);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(365952);
      if (this.Bgg.AVa)
      {
        AppMethodBeat.o(365952);
        return null;
      }
      Object localObject = new ch(this.Bgg.feedId, this.Bgg.nonceId, this.Bgg.hJx, this.Bgg.getLastBuffer(), null, this.Bgg.shareScene, this.Bgg.hYg, this.Bgg.hHa, this.Bgg.sessionId, this.Bgg.getContextObj(), 0.0F, 0.0F, 6656);
      ((ch)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(365952);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(365943);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(365943);
      return localList;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher$TaskDataCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "callback", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;Lcom/tencent/mm/loader/loader/SingleTask;Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      implements com.tencent.mm.plugin.finder.feed.model.internal.h<cc>
    {
      private final g Bgh;
      private final com.tencent.mm.plugin.finder.feed.model.internal.h<cc> Bgi;
      
      public a(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
      {
        AppMethodBeat.i(366305);
        this.Bgh = paramh;
        this.Bgi = localObject;
        AppMethodBeat.o(366305);
      }
      
      public final void onFetchDone(IResponse<cc> paramIResponse)
      {
        AppMethodBeat.i(366314);
        kotlin.g.b.s.u(paramIResponse, "response");
        this.Bgi.onFetchDone(paramIResponse);
        this.Bgh.a(com.tencent.mm.loader.f.i.nrG);
        AppMethodBeat.o(366314);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<FinderObject, Boolean>
    {
      b(BaseFinderFeed paramBaseFinderFeed)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<cc, Boolean>
    {
      c(List<cc> paramList, ah.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.b<cc, Boolean>
    {
      d(List<cc> paramList, ah.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements kotlin.g.a.b<g, ah>
    {
      e(FinderFeedShareRelativeListLoader.b paramb, Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "tipsWording", "guideBarItem", "Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;", "(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;)V", "getGuideBarItem", "()Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;", "setGuideBarItem", "(Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;)V", "getTipsWording", "()Ljava/lang/String;", "setTipsWording", "(Ljava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public bbm Bgp;
    public String tipsWording;
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      super(paramInt2, paramString1);
      AppMethodBeat.i(365922);
      this.tipsWording = paramString2;
      this.Bgp = null;
      AppMethodBeat.o(365922);
    }
    
    public final void avU(String paramString)
    {
      AppMethodBeat.i(365937);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.tipsWording = paramString;
      AppMethodBeat.o(365937);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$UserPageDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "getCmdIds", "", "replace", "", "feedFromDetail", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "relFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public d()
    {
      AppMethodBeat.i(365914);
      AppMethodBeat.o(365914);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(365928);
      FinderFeedShareRelativeListLoader.c localc = new FinderFeedShareRelativeListLoader.c(0, 0, "", "");
      localc.setPullType(1000);
      Object localObject1 = this.Bgg.getCache();
      int i;
      if (localObject1 != null)
      {
        Object localObject2 = (Collection)((s)localObject1).pUj;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label146;
        }
        i = 1;
        if (i != 0) {
          break label151;
        }
        i = 1;
        label70:
        if (i == 0) {
          break label156;
        }
        label74:
        if (localObject1 != null)
        {
          localObject2 = this.Bgg;
          Log.i(getTAG(), kotlin.g.b.s.X("UserPageDataFetcher callInit: use old data list, size: ", Integer.valueOf(((s)localObject1).pUj.size())));
          localc.setIncrementList((List)((s)localObject1).pUj);
          localObject1 = ((FinderFeedShareRelativeListLoader)localObject2).getCache();
          if (localObject1 != null) {
            break label161;
          }
        }
      }
      label146:
      label151:
      label156:
      label161:
      for (localObject1 = null;; localObject1 = ((s)localObject1).lastBuffer)
      {
        localc.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localObject1 = (IResponse)localc;
        AppMethodBeat.o(365928);
        return localObject1;
        i = 0;
        break;
        i = 0;
        break label70;
        localObject1 = null;
        break label74;
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(365951);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof bo))
      {
        Object localObject1 = c.c.b(((bo)paramp).rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(365951);
          throw paramString;
        }
        int i;
        FinderFeedShareRelativeListLoader.c localc;
        if (((atl)localObject1).privateLock == 1)
        {
          i = 1;
          if (i != 0) {
            break label730;
          }
          localc = new FinderFeedShareRelativeListLoader.c(paramInt1, paramInt2, paramString, "", (byte)0);
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label166;
          }
        }
        label166:
        for (boolean bool = ((bo)paramp).ABD;; bool = true)
        {
          localc.setPullType(((bo)paramp).pullType);
          paramString = c.c.b(((bo)paramp).rr.otC);
          if (paramString != null) {
            break label172;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(365951);
          throw paramString;
          i = 0;
          break;
        }
        label172:
        localc.setLastBuffer(((atl)paramString).lastBuffer);
        localc.setHasMore(bool);
        paramString = c.c.b(((bo)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(365951);
          throw paramString;
        }
        localObject1 = ((atl)paramString).ZEb;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        localc.avU(paramString);
        paramString = c.c.b(((bo)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(365951);
          throw paramString;
        }
        localObject1 = ((atl)paramString).object;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = new LinkedList();
        }
        localObject1 = this.Bgg.getContextObj();
        Object localObject4;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)paramString).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = z.FrZ;
            z.a((FinderObject)localObject3, ((bui)localObject1).AJo);
          }
        }
        localObject1 = (List)new ArrayList();
        Object localObject3 = (Iterable)paramString;
        Object localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          Object localObject5 = FinderItem.Companion;
          localObject4 = FinderItem.a.e((FinderObject)localObject4, 256);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          ((Collection)localObject2).add(d.a.a((FinderItem)localObject4));
        }
        ((List)localObject1).addAll((Collection)localObject2);
        if ((((bo)paramp).pullType == 0) && (this.Bgg.getDataList().size() == 1) && ((this.Bgg.getDataList().get(0) instanceof BaseFinderFeed)) && (paramString.size() > 0))
        {
          paramp = this.Bgg.getDataList().get(0);
          if (!(paramp instanceof BaseFinderFeed)) {
            break label724;
          }
        }
        label724:
        for (paramp = (BaseFinderFeed)paramp;; paramp = null)
        {
          paramString = (FinderObject)paramString.get(0);
          if ((paramp != null) && (paramString != null) && (paramp.feedObject.getId() == paramString.id))
          {
            paramp = paramp.feedObject.getFeedObject();
            if (paramp.adFlag != paramString.adFlag)
            {
              Log.i(getTAG(), kotlin.g.b.s.X("replace adFlag ", Integer.valueOf(paramp.adFlag)));
              paramString.adFlag = paramp.adFlag;
            }
            if ((paramString.hotWordInfo == null) && (paramp.hotWordInfo != null))
            {
              paramString.hotWordInfo = paramp.hotWordInfo;
              Log.i(getTAG(), kotlin.g.b.s.X("replace hotWordInfo ", paramp.hotWordInfo));
            }
          }
          localc.setIncrementList((List)localObject1);
          paramString = (IResponse)localc;
          AppMethodBeat.o(365951);
          return paramString;
        }
      }
      label730:
      AppMethodBeat.o(365951);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      long l2 = 0L;
      AppMethodBeat.i(365921);
      Object localObject = this.Bgg;
      int i = ((FinderFeedShareRelativeListLoader)localObject).getDataList().size() - 1;
      long l1 = l2;
      if (i >= 0) {}
      for (;;)
      {
        int j = i - 1;
        cc localcc = (cc)((FinderFeedShareRelativeListLoader)localObject).getDataList().get(i);
        if (((localcc instanceof BaseFinderFeed)) && (((BaseFinderFeed)localcc).feedObject.getId() != 0L)) {
          l1 = ((BaseFinderFeed)localcc).feedObject.getId();
        }
        do
        {
          localObject = (com.tencent.mm.am.p)new bo(this.Bgg.zDJ, this.Bgg.feedId, this.Bgg.ABC, l1, this.Bgg.getLastBuffer(), 2, this.Bgg.getContextObj());
          AppMethodBeat.o(365921);
          return localObject;
          l1 = l2;
        } while (j < 0);
        i = j;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(365918);
      List localList = kotlin.a.p.listOf(Integer.valueOf(6692));
      AppMethodBeat.o(365918);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends BaseFeedLoader<cc>.a
  {
    e(FinderFeedShareRelativeListLoader paramFinderFeedShareRelativeListLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(365915);
      AppMethodBeat.o(365915);
    }
    
    public final int findMergeIndex(ArrayList<cc> paramArrayList, List<? extends cc> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(365919);
      kotlin.g.b.s.u(paramArrayList, "srcList");
      kotlin.g.b.s.u(paramList, "newList");
      paramInt = this.Bgg.getDataList().size();
      AppMethodBeat.o(365919);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader
 * JD-Core Version:    0.7.0.1
 */