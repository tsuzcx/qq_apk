package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.cgi.bk;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "getCurRequest", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "setCurRequest", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "encryptedTopicId", "getEncryptedTopicId", "()Ljava/lang/String;", "setEncryptedTopicId", "(Ljava/lang/String;)V", "eventTopicId", "", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "extraUITask", "Lkotlin/Function0;", "", "getExtraUITask", "()Lkotlin/jvm/functions/Function0;", "setExtraUITask", "(Lkotlin/jvm/functions/Function0;)V", "followId", "getFollowId", "setFollowId", "hasAddFollowFeed", "", "getHasAddFollowFeed", "()Z", "setHasAddFollowFeed", "(Z)V", "hotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", "isLoadingMore", "setLoadingMore", "lattBufferOfTag", "getLattBufferOfTag", "setLattBufferOfTag", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPoiLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "refObjectId", "getRefObjectId", "()Ljava/lang/Long;", "setRefObjectId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTopic", "getType", "userName", "getUserName", "setUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastBuff", "tag", "isObservePostEvent", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onSaveLastBuffer", "requestLoadMore", "tabType", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "requestRefresh", "pullType", "saveLastBuff", "buff", "TopicDataFetcher", "TopicLoadMoreRequest", "TopicRefreshRequest", "TopicRequest", "TopicResponse", "plugin-finder_release"})
public final class FinderTopicFeedLoader
  extends BaseFinderFeedLoader
{
  private final String dST;
  boolean isLoadingMore;
  public String tTG;
  public int tTH;
  public String tTQ;
  public volatile d tXJ;
  private com.tencent.mm.bw.b tXK;
  private a tXL;
  public axt tXM;
  public Long tXN;
  public a<x> tXO;
  public bcc tvs;
  public long twd;
  final int type;
  private String userName;
  
  public FinderTopicFeedLoader(int paramInt, String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244933);
    this.type = paramInt;
    this.dST = paramString;
    this.tXL = new a();
    this.userName = "";
    this.tTG = "";
    this.tTQ = "";
    AppMethodBeat.o(244933);
  }
  
  private void a(String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(244926);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setLastBuffer(paramb);
      AppMethodBeat.o(244926);
      return;
    }
    this.tXK = paramb;
    AppMethodBeat.o(244926);
  }
  
  public final void a(int paramInt, dmk paramdmk)
  {
    AppMethodBeat.i(244929);
    if (this.isLoadingMore)
    {
      Log.d(getTAG(), "already load more,return");
      AppMethodBeat.o(244929);
      return;
    }
    this.isLoadingMore = true;
    if (paramdmk != null)
    {
      localObject = paramdmk.MPW;
      if (localObject != null)
      {
        localObject = (bds)((LinkedList)localObject).get(0);
        if (localObject == null) {}
      }
    }
    for (Object localObject = ((bds)localObject).dST;; localObject = null)
    {
      com.tencent.mm.bw.b localb = atr((String)localObject);
      String str2 = getTAG();
      StringBuilder localStringBuilder = new StringBuilder("requestLoadMore tag: ");
      if (paramdmk != null)
      {
        localObject = paramdmk.MPW;
        if (localObject != null)
        {
          localObject = (bds)((LinkedList)localObject).get(0);
          if (localObject != null)
          {
            String str1 = ((bds)localObject).dST;
            localObject = str1;
            if (str1 != null) {
              break label131;
            }
          }
        }
      }
      localObject = "null";
      label131:
      Log.d(str2, (String)localObject + "  topic:" + this.dST + " innerTabType:" + this.tTH);
      paramdmk = new b(this.type, this.dST, this.tTG, this.twd, this.tTQ, this.tTH, this.tXM, this.tXN, localb, this.tvs, this.userName, paramInt, paramdmk, getContextObj());
      paramdmk.ddB();
      BaseFeedLoader.request$default(this, paramdmk, null, 2, null);
      this.tXJ = ((d)paramdmk);
      AppMethodBeat.o(244929);
      return;
    }
  }
  
  public final void a(int paramInt1, dmk paramdmk, int paramInt2)
  {
    AppMethodBeat.i(244927);
    String str2 = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("requestRefresh tag: ");
    if (paramdmk != null)
    {
      localObject = paramdmk.MPW;
      if (localObject != null)
      {
        localObject = (bds)((LinkedList)localObject).get(0);
        if (localObject != null)
        {
          String str1 = ((bds)localObject).dST;
          localObject = str1;
          if (str1 != null) {
            break label76;
          }
        }
      }
    }
    Object localObject = "null";
    label76:
    Log.d(str2, (String)localObject + "  topic:" + this.dST + " innerTabType:" + this.tTH + " this:" + this);
    paramdmk = new c(this.type, this.dST, this.tTG, this.twd, this.tTQ, this.tTH, this.tXM, this.tXN, this.tvs, this.userName, paramInt1, paramdmk, paramInt2, getContextObj());
    paramdmk.ddB();
    BaseFeedLoader.request$default(this, paramdmk, null, 2, null);
    this.tXJ = ((d)paramdmk);
    AppMethodBeat.o(244927);
  }
  
  public final com.tencent.mm.bw.b atr(String paramString)
  {
    AppMethodBeat.i(244924);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = getLastBuffer();
      AppMethodBeat.o(244924);
      return paramString;
    }
    paramString = this.tXK;
    AppMethodBeat.o(244924);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch()
  {
    return (com.tencent.mm.plugin.finder.feed.model.internal.g)this.tXL;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244932);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new f(this);
    AppMethodBeat.o(244932);
    return localb;
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(244925);
    if ((this.type == 4) || (this.type == 7))
    {
      AppMethodBeat.o(244925);
      return true;
    }
    boolean bool = super.isObservePostEvent();
    AppMethodBeat.o(244925);
    return bool;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    Object localObject2 = null;
    AppMethodBeat.i(166066);
    p.h(paramIResponse, "response");
    Object localObject3 = getTAG();
    Object localObject1 = paramIResponse.getIncrementList();
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((List)localObject1).size());
      Log.i((String)localObject3, "onFetchDone %d feeds", new Object[] { localObject1 });
      if (!(paramIResponse instanceof e)) {
        break label788;
      }
      localObject3 = getTAG();
      localStringBuilder = new StringBuilder("incrementCount ");
      localObject1 = paramIResponse.getIncrementList();
      if (localObject1 == null) {
        break label224;
      }
    }
    label224:
    for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", totalCount ").append(((e)paramIResponse).tTn).append(", lastBuffer ");
      if (getLastBuffer() != null) {
        break label229;
      }
      localObject1 = "null";
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", resp buffer ");
      if (paramIResponse.getLastBuffer() != null) {
        break label256;
      }
      localObject1 = "null";
      Log.i((String)localObject3, (String)localObject1);
      if (!(this.tXJ instanceof c)) {
        break label374;
      }
      localObject1 = this.tXJ;
      if (localObject1 != null) {
        break label283;
      }
      paramIResponse = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(166066);
      throw paramIResponse;
      localObject1 = null;
      break;
    }
    label229:
    localObject1 = getLastBuffer();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).zy;; localObject1 = null)
    {
      localObject1 = MD5Util.getMD5String((byte[])localObject1);
      break;
    }
    label256:
    localObject1 = paramIResponse.getLastBuffer();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).zy;; localObject1 = null)
    {
      localObject1 = MD5Util.getMD5String((byte[])localObject1);
      break;
    }
    label283:
    localObject1 = ((c)localObject1).tUb;
    if (localObject1 != null)
    {
      localObject1 = ((dmk)localObject1).MPW;
      if (localObject1 != null)
      {
        localObject1 = (bds)((LinkedList)localObject1).get(0);
        if (localObject1 != null)
        {
          localObject1 = ((bds)localObject1).dST;
          a((String)localObject1, paramIResponse.getLastBuffer());
        }
      }
    }
    for (;;)
    {
      if ((this.tXJ instanceof c))
      {
        localObject1 = this.tXJ;
        if (localObject1 == null)
        {
          paramIResponse = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
          AppMethodBeat.o(166066);
          throw paramIResponse;
          localObject1 = null;
          break;
          label374:
          if (!(this.tXJ instanceof b)) {
            continue;
          }
          localObject1 = this.tXJ;
          if (localObject1 == null)
          {
            paramIResponse = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          localObject1 = ((b)localObject1).tUb;
          if (localObject1 != null)
          {
            localObject1 = ((dmk)localObject1).MPW;
            if (localObject1 != null)
            {
              localObject1 = (bds)((LinkedList)localObject1).get(0);
              if (localObject1 == null) {}
            }
          }
          for (localObject1 = ((bds)localObject1).dST;; localObject1 = null)
          {
            a((String)localObject1, paramIResponse.getLastBuffer());
            break;
          }
        }
        if (((c)localObject1).pullType != -1)
        {
          localObject1 = this.tXJ;
          if (localObject1 == null)
          {
            paramIResponse = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          paramIResponse.setPullType(((c)localObject1).pullType);
        }
      }
    }
    for (;;)
    {
      Log.i(getTAG(), "resp tag: " + ((e)paramIResponse).tag);
      if (!(this.tXJ instanceof c)) {
        break label788;
      }
      localObject1 = this.tXJ;
      if (localObject1 != null) {
        break;
      }
      paramIResponse = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(166066);
      throw paramIResponse;
      paramIResponse.setPullType(1);
      continue;
      paramIResponse.setPullType(2);
      this.isLoadingMore = false;
    }
    localObject3 = ((c)localObject1).tUb;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((dmk)localObject3).MPW;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = (bds)((LinkedList)localObject3).get(0);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((bds)localObject3).dST;
        }
      }
    }
    localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = ((e)paramIResponse).tag;
        if ((localObject2 != null) && (!((String)localObject2).equals(localObject1)))
        {
          Log.i(getTAG(), "resp tag: " + ((e)paramIResponse).tag + " ,not match current tag " + (String)localObject1 + ",return");
          AppMethodBeat.o(166066);
          return;
          i = 0;
        }
        else
        {
          localObject1 = this.tXO;
          if (localObject1 != null) {
            ((a)localObject1).invoke();
          }
        }
      }
    }
    for (;;)
    {
      label788:
      super.onFetchDone(paramIResponse);
      AppMethodBeat.o(166066);
      return;
      localObject1 = this.tXO;
      if (localObject1 != null) {
        ((a)localObject1).invoke();
      }
    }
  }
  
  public final void onSaveLastBuffer(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244931);
    p.h(paramIResponse, "response");
    AppMethodBeat.o(244931);
  }
  
  public final void requestLoadMore() {}
  
  public final void requestRefresh() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<bo>
    implements i
  {
    private f<bo> tXP;
    
    public final void alive()
    {
      AppMethodBeat.i(244913);
      super.alive();
      this.tXQ.isLoadingMore = false;
      com.tencent.mm.kernel.g.azz().a(817, (i)this);
      AppMethodBeat.o(244913);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(244914);
      super.dead();
      com.tencent.mm.kernel.g.azz().b(817, (i)this);
      AppMethodBeat.o(244914);
    }
    
    public final void fetch(Object paramObject, f<bo> paramf)
    {
      AppMethodBeat.i(244912);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderTopicFeedLoader.d))
      {
        this.tXP = paramf;
        ((FinderTopicFeedLoader.d)paramObject).call();
      }
      AppMethodBeat.o(244912);
    }
    
    public final void fetchInit(f<bo> paramf)
    {
      AppMethodBeat.i(244911);
      p.h(paramf, "callback");
      paramf.onFetchDone((IResponse)new com.tencent.mm.plugin.finder.feed.model.internal.c());
      AppMethodBeat.o(244911);
    }
    
    public final void fetchLoadMore(f<bo> paramf)
    {
      AppMethodBeat.i(244910);
      p.h(paramf, "callback");
      AppMethodBeat.o(244910);
    }
    
    public final void fetchRefresh(f<bo> paramf)
    {
      AppMethodBeat.i(244909);
      p.h(paramf, "callback");
      AppMethodBeat.o(244909);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(244915);
      Log.i(getTAG(), "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramq != null) && ((paramq instanceof bs)))
      {
        FinderTopicFeedLoader.e locale = new FinderTopicFeedLoader.e(paramInt1, paramInt2, ((bs)paramq).cYJ(), paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locale.setLastBuffer(((bs)paramq).cYz());
          locale.tTn = ((bs)paramq).cYI();
          Object localObject2 = (Iterable)((bs)paramq).cYH();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          Object localObject4;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 64);
            localObject4 = FinderTopicFeedUI.udw;
            ((Map)FinderTopicFeedUI.ddO()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            paramString.add(c.a.s((FinderItem)localObject3));
          }
          locale.setIncrementList((List)paramString);
          if (((bs)paramq).tvC == 4)
          {
            paramString = locale.getIncrementList();
            if (paramString != null) {
              paramInt1 = paramString.size();
            }
            while (paramInt1 > 0)
            {
              paramString = locale.getIncrementList();
              if (paramString != null)
              {
                paramString = (bo)paramString.get(0);
                if (paramString != null) {
                  if (paramString == null)
                  {
                    paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(244915);
                    throw paramString;
                    paramInt1 = 0;
                  }
                  else
                  {
                    localObject3 = (BaseFinderFeed)paramString;
                    localObject4 = com.tencent.mm.ac.d.zs(((BaseFinderFeed)paramString).feedObject.field_id);
                    paramString = ((bs)paramq).getBgmInfo();
                    if (paramString != null)
                    {
                      localObject2 = paramString.groupId;
                      paramString = (String)localObject2;
                      if (localObject2 != null) {}
                    }
                    else
                    {
                      paramString = Integer.valueOf(0);
                    }
                    ((BaseFinderFeed)localObject3).isOriginFeed = p.j(localObject4, paramString);
                  }
                }
              }
            }
          }
          locale.setPullType(((bs)paramq).pullType);
          if (((bs)paramq).cYA() != 0) {}
          for (boolean bool = true;; bool = false)
          {
            locale.setHasMore(bool);
            paramString = ((bs)paramq).rr.aYK();
            if (paramString != null) {
              break;
            }
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(244915);
            throw paramString;
          }
          locale.tXS = ((atv)paramString).tTT;
          paramString = ((bs)paramq).rr.aYK();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(244915);
            throw paramString;
          }
          paramString = ((atv)paramString).LEI;
          if (paramString != null) {}
          for (paramString = paramString.MIg;; paramString = null)
          {
            locale.oqZ = paramString;
            paramString = ((bs)paramq).rr.aYK();
            if (paramString != null) {
              break;
            }
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(244915);
            throw paramString;
          }
          localObject2 = ((atv)paramString).LEG;
          paramString = localObject1;
          if (localObject2 != null) {
            paramString = ((bds)localObject2).LJj;
          }
          locale.musicInfo = paramString;
          locale.setBgmInfo(((bs)paramq).getBgmInfo());
          paramString = ((bs)paramq).rr.aYK();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(244915);
            throw paramString;
          }
          paramString = ((atv)paramString).LEG;
          if (paramString != null) {}
          for (paramInt1 = paramString.LNx;; paramInt1 = 0)
          {
            locale.cSx = paramInt1;
            paramString = ((bs)paramq).rr.aYK();
            if (paramString != null) {
              break;
            }
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(244915);
            throw paramString;
          }
          paramString = ((atv)paramString).LEG;
          paramInt1 = i;
          if (paramString != null) {
            paramInt1 = paramString.LNy;
          }
          locale.tTo = paramInt1;
          Log.d(getTAG(), "onSceneEnd (" + ((bs)paramq).tvB + ')');
          locale.tag = ((bs)paramq).tvB;
        }
        paramString = this.tXP;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)locale);
          AppMethodBeat.o(244915);
          return;
        }
      }
      AppMethodBeat.o(244915);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "followId", "eventTopicId", "", "encryptedTopicId", "innerTabType", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "userName", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEncryptedTopicId", "()Ljava/lang/String;", "getEventTopicId", "()J", "getFollowId", "getInnerTabType", "()I", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "getType", "getUserName", "call", "", "toString", "plugin-finder_release"})
  public static final class b
    extends FinderTopicFeedLoader.d
  {
    private final int dLS;
    private final String dST;
    private final com.tencent.mm.bw.b lastBuffer;
    private final axt location;
    private final String tTG;
    private final int tTH;
    private final String tTQ;
    final dmk tUb;
    private final Long tXN;
    private final bbn ttO;
    private final bcc tvs;
    private final long twd;
    private final int type;
    private final String userName;
    
    public b(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt2, axt paramaxt, Long paramLong1, com.tencent.mm.bw.b paramb, bcc parambcc, String paramString4, int paramInt3, dmk paramdmk, bbn parambbn)
    {
      AppMethodBeat.i(244916);
      this.type = paramInt1;
      this.dST = paramString1;
      this.tTG = paramString2;
      this.twd = paramLong;
      this.tTQ = paramString3;
      this.tTH = paramInt2;
      this.location = paramaxt;
      this.tXN = paramLong1;
      this.lastBuffer = paramb;
      this.tvs = parambcc;
      this.userName = paramString4;
      this.dLS = paramInt3;
      this.tUb = paramdmk;
      this.ttO = parambbn;
      setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
      AppMethodBeat.o(244916);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166059);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.tXR != null) {
          com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)this.tXR);
        }
        AppMethodBeat.o(166059);
        return;
        this.tXR = ((ax)new bs(this.dST, this.tXN, this.lastBuffer, this.tvs, this.ttO, (byte)0));
        continue;
        axt localaxt = this.location;
        if (localaxt != null)
        {
          String str = localaxt.LIb;
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          this.tXR = ((ax)new bs((String)localObject, localaxt.dTj, localaxt.latitude, this.tXN, this.lastBuffer, this.dLS, this.tUb, this.tvs, this.ttO));
          continue;
          this.tXR = ((ax)new bk(this.lastBuffer, this.userName));
          continue;
          str = this.tTG;
          localObject = str;
          if (str == null)
          {
            localObject = this.tXN;
            if (localObject == null) {
              break label290;
            }
          }
          label290:
          for (long l = ((Long)localObject).longValue();; l = -1L)
          {
            localObject = com.tencent.mm.ac.d.zs(l);
            this.tXR = ((ax)new bs((String)localObject, this.tXN, this.lastBuffer, this.tvs, this.ttO));
            break;
          }
          this.tXR = ((ax)new bs(this.twd, this.tXN, this.tTQ, this.tTH, this.lastBuffer, this.ttO));
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166058);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", type:").append(this.type).append(", topic:").append(this.dST).append(", lastBuffer:");
      if (this.lastBuffer == null)
      {
        localObject = "null";
        localObject = (String)localObject;
        AppMethodBeat.o(166058);
        return localObject;
      }
      Object localObject = this.lastBuffer;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.bw.b)localObject).zy;; localObject = null)
      {
        localObject = MD5Util.getMD5String((byte[])localObject);
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "followId", "eventTopicId", "", "encryptedTopicId", "innerTabType", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "finderUserName", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEncryptedTopicId", "()Ljava/lang/String;", "getEventTopicId", "()J", "getFinderUserName", "getFollowId", "getInnerTabType", "()I", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class c
    extends FinderTopicFeedLoader.d
  {
    private final int dLS;
    private final String dST;
    private final axt location;
    final int pullType;
    private final String sBN;
    private final String tTG;
    private final int tTH;
    private final String tTQ;
    final dmk tUb;
    private final Long tXN;
    private final bbn ttO;
    private bcc tvs;
    private final long twd;
    private final int type;
    
    public c(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt2, axt paramaxt, Long paramLong1, bcc parambcc, String paramString4, int paramInt3, dmk paramdmk, int paramInt4, bbn parambbn)
    {
      AppMethodBeat.i(244917);
      this.type = paramInt1;
      this.dST = paramString1;
      this.tTG = paramString2;
      this.twd = paramLong;
      this.tTQ = paramString3;
      this.tTH = paramInt2;
      this.location = paramaxt;
      this.tXN = paramLong1;
      this.tvs = parambcc;
      this.sBN = paramString4;
      this.dLS = paramInt3;
      this.tUb = paramdmk;
      this.pullType = paramInt4;
      this.ttO = parambbn;
      setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(244917);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166062);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.tXR != null) {
          com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)this.tXR);
        }
        AppMethodBeat.o(166062);
        return;
        this.tXR = ((ax)new bs(this.dST, this.tXN, null, this.tvs, this.ttO, (byte)0));
        continue;
        axt localaxt = this.location;
        if (localaxt != null)
        {
          String str = localaxt.LIb;
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          this.tXR = ((ax)new bs((String)localObject, localaxt.dTj, localaxt.latitude, this.tXN, null, this.dLS, this.tUb, this.tvs, this.ttO));
          continue;
          this.tXR = ((ax)new bk(null, this.sBN));
          continue;
          str = this.tTG;
          localObject = str;
          if (str == null)
          {
            localObject = this.tXN;
            if (localObject == null) {
              break label278;
            }
          }
          label278:
          for (long l = ((Long)localObject).longValue();; l = -1L)
          {
            localObject = com.tencent.mm.ac.d.zs(l);
            this.tXR = ((ax)new bs((String)localObject, this.tXN, null, this.tvs, this.ttO));
            break;
          }
          this.tXR = ((ax)new bs(this.twd, this.tXN, this.tTQ, this.tTH, null, this.ttO));
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166061);
      String str = "hashCode: " + hashCode() + ", type:" + this.type + ", topic:" + this.dST;
      AppMethodBeat.o(166061);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "getScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "setScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;)V", "call", "", "printRequest", "toString", "plugin-finder_release"})
  public static abstract class d
  {
    private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
    ax tXR;
    
    public abstract void call();
    
    public final void ddB()
    {
      Log.i(this.TAG, toString());
    }
    
    public final void setTAG(String paramString)
    {
      p.h(paramString, "<set-?>");
      this.TAG = paramString;
    }
    
    public String toString()
    {
      return "";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "errMsg", "", "(IILcom/tencent/mm/protocal/protobuf/FinderTopicInfo;Ljava/lang/String;)V", "disableFlag", "getDisableFlag", "()I", "setDisableFlag", "(I)V", "flag", "getFlag", "setFlag", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagsData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagsData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<bo>
  {
    public int cSx;
    public final bds dMU;
    public azk musicInfo;
    public String oqZ;
    public long tTn;
    public int tTo;
    public dmk tXS;
    String tag;
    
    public e(int paramInt1, int paramInt2, bds parambds, String paramString)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(244918);
      this.dMU = parambds;
      this.tXS = new dmk();
      AppMethodBeat.o(244918);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "mergeLoadMore", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "plugin-finder_release"})
  public static final class f
    extends BaseFeedLoader<bo>.a
  {
    f()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<bo> paramArrayList, List<? extends bo> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(244923);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      if ((this.tXQ.type == 4) && (paramList.size() == 1) && ((paramList.get(0) instanceof BaseFinderFeed)))
      {
        Object localObject = paramList.get(0);
        if (localObject == null)
        {
          paramArrayList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(244923);
          throw paramArrayList;
        }
        if (((BaseFinderFeed)localObject).feedObject.getFeedObject().id == 0L)
        {
          AppMethodBeat.o(244923);
          return 1;
        }
      }
      paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, paramObject);
      AppMethodBeat.o(244923);
      return paramInt;
    }
    
    public final void mergeLoadMore(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      int i = 1;
      AppMethodBeat.i(244922);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfU());
      List localList = paramIResponse.getIncrementList();
      boolean bool;
      if (localList != null)
      {
        bool = localList.isEmpty();
        ((RefreshLoadMoreLayout.c)localObject).jLE = bool;
        ((RefreshLoadMoreLayout.c)localObject).Rmj = paramIResponse.getHasMore();
        ((RefreshLoadMoreLayout.c)localObject).tXF = paramIResponse;
        if (!paramIResponse.getHasMore()) {
          break label124;
        }
      }
      for (;;)
      {
        com.tencent.mm.ac.d.h((a)new a(this, new n(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(244922);
        return;
        bool = true;
        break;
        label124:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      int j = 3;
      AppMethodBeat.i(244921);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc;
      if (paramIResponse.getPullType() == 1)
      {
        i = 3;
        localc = new RefreshLoadMoreLayout.c(i);
        if (paramIResponse.getPullType() != 1) {
          break label99;
        }
      }
      label99:
      for (int i = j;; i = 4)
      {
        final n localn = new n(i, paramIResponse.getIncrementList(), false, 12);
        localc.tXF = paramIResponse;
        com.tencent.mm.ac.d.h((a)new b(this, localn, localc, paramb, paramIResponse));
        AppMethodBeat.o(244921);
        return;
        i = 4;
        break;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderTopicFeedLoader.f paramf, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements a<x>
    {
      b(FinderTopicFeedLoader.f paramf, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader
 * JD-Core Version:    0.7.0.1
 */