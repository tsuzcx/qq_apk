package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bn;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.findersdk.b.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "activeTabType", "getActiveTabType", "()I", "setActiveTabType", "(I)V", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "getCurRequest", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "setCurRequest", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "encryptedTopicId", "getEncryptedTopicId", "()Ljava/lang/String;", "setEncryptedTopicId", "(Ljava/lang/String;)V", "eventTopicId", "", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "extraUITask", "Lkotlin/Function0;", "", "getExtraUITask", "()Lkotlin/jvm/functions/Function0;", "setExtraUITask", "(Lkotlin/jvm/functions/Function0;)V", "followId", "getFollowId", "setFollowId", "hasAddFollowFeed", "", "getHasAddFollowFeed", "()Z", "setHasAddFollowFeed", "(Z)V", "hotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "innerTabType", "getInnerTabType", "setInnerTabType", "isLoadingMore", "setLoadingMore", "lattBufferOfTag", "getLattBufferOfTag", "setLattBufferOfTag", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPoiLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "refObjectId", "getRefObjectId", "()Ljava/lang/Long;", "setRefObjectId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTopic", "getType", "userName", "getUserName", "setUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastBuff", "tag", "isObservePostEvent", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onSaveLastBuffer", "requestLoadMore", "tabType", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "requestRefresh", "pullType", "saveLastBuff", "buff", "TopicDataFetcher", "TopicLoadMoreRequest", "TopicRefreshRequest", "TopicRequest", "TopicResponse", "plugin-finder_release"})
public class FinderTopicFeedLoader
  extends BaseFinderFeedLoader
{
  boolean isLoadingMore;
  private final String topic;
  final int type;
  private String userName;
  public String xEG;
  public String xEv;
  public int xEw;
  public volatile d xJD;
  private com.tencent.mm.cd.b xJE;
  private a xJF;
  public bdm xJG;
  public Long xJH;
  public int xJI;
  public a<x> xJJ;
  public biv xcZ;
  public long xdR;
  
  public FinderTopicFeedLoader(int paramInt, String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(238949);
    this.type = paramInt;
    this.topic = paramString;
    this.xJF = new a();
    this.userName = "";
    this.xEv = "";
    this.xEG = "";
    this.xJI = -1;
    AppMethodBeat.o(238949);
  }
  
  private void a(String paramString, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(238931);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setLastBuffer(paramb);
      AppMethodBeat.o(238931);
      return;
    }
    this.xJE = paramb;
    AppMethodBeat.o(238931);
  }
  
  public final void a(int paramInt, dwb paramdwb)
  {
    AppMethodBeat.i(238937);
    if (this.isLoadingMore)
    {
      Log.d(getTAG(), "already load more,return");
      AppMethodBeat.o(238937);
      return;
    }
    this.isLoadingMore = true;
    if (paramdwb != null)
    {
      localObject = paramdwb.Uca;
      if (localObject != null)
      {
        localObject = (bkr)((LinkedList)localObject).get(0);
        if (localObject == null) {}
      }
    }
    for (Object localObject = ((bkr)localObject).topic;; localObject = null)
    {
      com.tencent.mm.cd.b localb = aBI((String)localObject);
      String str2 = getTAG();
      StringBuilder localStringBuilder = new StringBuilder("requestLoadMore tag: ");
      if (paramdwb != null)
      {
        localObject = paramdwb.Uca;
        if (localObject != null)
        {
          localObject = (bkr)((LinkedList)localObject).get(0);
          if (localObject != null)
          {
            String str1 = ((bkr)localObject).topic;
            localObject = str1;
            if (str1 != null) {
              break label132;
            }
          }
        }
      }
      localObject = "null";
      label132:
      Log.d(str2, (String)localObject + "  topic:" + this.topic + " innerTabType:" + this.xEw);
      paramdwb = new b(this.type, this.topic, this.xEv, this.xdR, this.xEG, this.xEw, this.xJG, this.xJH, localb, this.xcZ, this.userName, paramInt, paramdwb, getContextObj());
      paramdwb.duw();
      BaseFeedLoader.request$default(this, paramdwb, null, 2, null);
      this.xJD = ((d)paramdwb);
      AppMethodBeat.o(238937);
      return;
    }
  }
  
  public final void a(int paramInt1, dwb paramdwb, int paramInt2)
  {
    AppMethodBeat.i(238935);
    String str2 = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("requestRefresh tag: ");
    if (paramdwb != null)
    {
      localObject = paramdwb.Uca;
      if (localObject != null)
      {
        localObject = (bkr)((LinkedList)localObject).get(0);
        if (localObject != null)
        {
          String str1 = ((bkr)localObject).topic;
          localObject = str1;
          if (str1 != null) {
            break label76;
          }
        }
      }
    }
    Object localObject = "null";
    label76:
    Log.d(str2, (String)localObject + "  topic:" + this.topic + " innerTabType:" + this.xEw + " this:" + this);
    paramdwb = new c(this.type, this.topic, this.xEv, this.xdR, this.xEG, this.xEw, this.xJG, this.xJH, this.xcZ, this.userName, paramInt1, paramdwb, paramInt2, getContextObj());
    paramdwb.duw();
    BaseFeedLoader.request$default(this, paramdwb, null, 2, null);
    this.xJD = ((d)paramdwb);
    AppMethodBeat.o(238935);
  }
  
  public final com.tencent.mm.cd.b aBI(String paramString)
  {
    AppMethodBeat.i(238926);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = getLastBuffer();
      AppMethodBeat.o(238926);
      return paramString;
    }
    paramString = this.xJE;
    AppMethodBeat.o(238926);
    return paramString;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.i<bu> createDataFetch()
  {
    return (com.tencent.mm.plugin.finder.feed.model.internal.i)this.xJF;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(238945);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new f(this);
    AppMethodBeat.o(238945);
    return locald;
  }
  
  public boolean isObservePostEvent()
  {
    AppMethodBeat.i(238929);
    if ((this.type == 4) || (this.type == 7))
    {
      AppMethodBeat.o(238929);
      return true;
    }
    boolean bool = super.isObservePostEvent();
    AppMethodBeat.o(238929);
    return bool;
  }
  
  public void onFetchDone(IResponse<bu> paramIResponse)
  {
    Object localObject2 = null;
    AppMethodBeat.i(166066);
    p.k(paramIResponse, "response");
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
      localStringBuilder = localStringBuilder.append(localObject1).append(", totalCount ").append(((e)paramIResponse).xEc).append(", lastBuffer ");
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
      if (!(this.xJD instanceof c)) {
        break label374;
      }
      localObject1 = this.xJD;
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
    for (localObject1 = ((com.tencent.mm.cd.b)localObject1).UH;; localObject1 = null)
    {
      localObject1 = MD5Util.getMD5String((byte[])localObject1);
      break;
    }
    label256:
    localObject1 = paramIResponse.getLastBuffer();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.cd.b)localObject1).UH;; localObject1 = null)
    {
      localObject1 = MD5Util.getMD5String((byte[])localObject1);
      break;
    }
    label283:
    localObject1 = ((c)localObject1).xEX;
    if (localObject1 != null)
    {
      localObject1 = ((dwb)localObject1).Uca;
      if (localObject1 != null)
      {
        localObject1 = (bkr)((LinkedList)localObject1).get(0);
        if (localObject1 != null)
        {
          localObject1 = ((bkr)localObject1).topic;
          a((String)localObject1, paramIResponse.getLastBuffer());
        }
      }
    }
    for (;;)
    {
      if ((this.xJD instanceof c))
      {
        localObject1 = this.xJD;
        if (localObject1 == null)
        {
          paramIResponse = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
          AppMethodBeat.o(166066);
          throw paramIResponse;
          localObject1 = null;
          break;
          label374:
          if (!(this.xJD instanceof b)) {
            continue;
          }
          localObject1 = this.xJD;
          if (localObject1 == null)
          {
            paramIResponse = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          localObject1 = ((b)localObject1).xEX;
          if (localObject1 != null)
          {
            localObject1 = ((dwb)localObject1).Uca;
            if (localObject1 != null)
            {
              localObject1 = (bkr)((LinkedList)localObject1).get(0);
              if (localObject1 == null) {}
            }
          }
          for (localObject1 = ((bkr)localObject1).topic;; localObject1 = null)
          {
            a((String)localObject1, paramIResponse.getLastBuffer());
            break;
          }
        }
        if (((c)localObject1).pullType != -1)
        {
          localObject1 = this.xJD;
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
      if (!(this.xJD instanceof c)) {
        break label788;
      }
      localObject1 = this.xJD;
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
    localObject3 = ((c)localObject1).xEX;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((dwb)localObject3).Uca;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = (bkr)((LinkedList)localObject3).get(0);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((bkr)localObject3).topic;
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
          localObject1 = this.xJJ;
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
      localObject1 = this.xJJ;
      if (localObject1 != null) {
        ((a)localObject1).invoke();
      }
    }
  }
  
  public void onSaveLastBuffer(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(238940);
    p.k(paramIResponse, "response");
    AppMethodBeat.o(238940);
  }
  
  public void requestLoadMore() {}
  
  public void requestRefresh() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "sceneSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lkotlin/collections/HashSet;", "getSceneSet", "()Ljava/util/HashSet;", "setSceneSet", "(Ljava/util/HashSet;)V", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "handleScene", "errType", "", "errCode", "errMsg", "", "scene", "onSceneEnd", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<bu>
    implements com.tencent.mm.an.i
  {
    private com.tencent.mm.plugin.finder.feed.model.internal.h<bu> xJK;
    private HashSet<com.tencent.mm.an.q> xJL;
    
    public a()
    {
      AppMethodBeat.i(272415);
      this.xJL = new HashSet();
      AppMethodBeat.o(272415);
    }
    
    private final void g(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(272414);
      if ((paramq instanceof bv))
      {
        boolean bool = this.xJL.remove(paramq);
        Log.i(getTAG(), "isRemoved :".concat(String.valueOf(bool)));
        if (!bool)
        {
          AppMethodBeat.o(272414);
          return;
        }
        if (this.xJM.type == 7)
        {
          if ((((bv)paramq).dov() == 7) && (((bv)paramq).getTabType() != this.xJM.xEw))
          {
            Log.i(getTAG(), "activity request ignore not my tab innerTabType:" + this.xJM.xEw + "  tabType: " + ((bv)paramq).getTabType());
            AppMethodBeat.o(272414);
            return;
          }
          if (((bv)paramq).dov() != 7)
          {
            Log.i(getTAG(), "other type request if current is activity ignore!! innerTabType:" + this.xJM.xEw + "  tabType: " + ((bv)paramq).getTabType());
            AppMethodBeat.o(272414);
            return;
          }
        }
        FinderTopicFeedLoader.e locale = new FinderTopicFeedLoader.e(paramInt1, paramInt2, ((bv)paramq).doy(), paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locale.setLastBuffer(((bv)paramq).don());
          locale.xEc = ((bv)paramq).dox();
          Object localObject2 = (Iterable)((bv)paramq).dow();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          Object localObject4;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.b((FinderObject)localObject3, 64);
            localObject4 = FinderTopicFeedUI.xTd;
            ((Map)FinderTopicFeedUI.duS()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
            localObject4 = c.AnK;
            paramString.add(c.a.a((FinderItem)localObject3));
          }
          locale.setIncrementList((List)paramString);
          if (((bv)paramq).wXA == 4)
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
                paramString = (bu)paramString.get(0);
                if (paramString != null) {
                  if (paramString == null)
                  {
                    paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(272414);
                    throw paramString;
                    paramInt1 = 0;
                  }
                  else
                  {
                    localObject3 = (BaseFinderFeed)paramString;
                    localObject4 = com.tencent.mm.ae.d.Fw(((BaseFinderFeed)paramString).feedObject.field_id);
                    paramString = ((bv)paramq).getBgmInfo();
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
                    ((BaseFinderFeed)localObject3).isOriginFeed = p.h(localObject4, paramString);
                  }
                }
              }
            }
          }
          locale.setPullType(((bv)paramq).pullType);
          if (((bv)paramq).doo() != 0) {}
          for (bool = true;; bool = false)
          {
            locale.setHasMore(bool);
            paramString = ((bv)paramq).rr.bhY();
            if (paramString != null) {
              break;
            }
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(272414);
            throw paramString;
          }
          locale.xJO = ((avy)paramString).xEJ;
          paramString = ((bv)paramq).rr.bhY();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(272414);
            throw paramString;
          }
          paramString = ((avy)paramString).SIq;
          if (paramString != null) {}
          for (paramString = paramString.TTU;; paramString = null)
          {
            locale.rsw = paramString;
            paramString = ((bv)paramq).rr.bhY();
            if (paramString != null) {
              break;
            }
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(272414);
            throw paramString;
          }
          localObject2 = ((avy)paramString).SIo;
          paramString = localObject1;
          if (localObject2 != null) {
            paramString = ((bkr)localObject2).SPW;
          }
          locale.musicInfo = paramString;
          locale.setBgmInfo(((bv)paramq).getBgmInfo());
          paramString = ((bv)paramq).rr.bhY();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(272414);
            throw paramString;
          }
          paramString = ((avy)paramString).SIo;
          if (paramString != null) {}
          for (paramInt1 = paramString.SVH;; paramInt1 = 0)
          {
            locale.cUP = paramInt1;
            paramString = ((bv)paramq).rr.bhY();
            if (paramString != null) {
              break;
            }
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(272414);
            throw paramString;
          }
          paramString = ((avy)paramString).SIo;
          paramInt1 = i;
          if (paramString != null) {
            paramInt1 = paramString.SVI;
          }
          locale.xEd = paramInt1;
          Log.d(getTAG(), "onSceneEnd (" + ((bv)paramq).xdj + ')');
          locale.tag = ((bv)paramq).xdj;
        }
        paramString = this.xJK;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)locale);
          AppMethodBeat.o(272414);
          return;
        }
      }
      AppMethodBeat.o(272414);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(272411);
      super.alive();
      this.xJM.isLoadingMore = false;
      com.tencent.mm.kernel.h.aGY().a(817, (com.tencent.mm.an.i)this);
      AppMethodBeat.o(272411);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(272412);
      super.dead();
      com.tencent.mm.kernel.h.aGY().b(817, (com.tencent.mm.an.i)this);
      AppMethodBeat.o(272412);
    }
    
    public final void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(272409);
      p.k(paramh, "callback");
      if ((paramObject instanceof FinderTopicFeedLoader.d))
      {
        this.xJK = paramh;
        ((FinderTopicFeedLoader.d)paramObject).call();
        this.xJL.add(((FinderTopicFeedLoader.d)paramObject).xJN);
      }
      AppMethodBeat.o(272409);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(272408);
      p.k(paramh, "callback");
      paramh.onFetchDone((IResponse)new e());
      AppMethodBeat.o(272408);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(272407);
      p.k(paramh, "callback");
      AppMethodBeat.o(272407);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(272406);
      p.k(paramh, "callback");
      AppMethodBeat.o(272406);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(272413);
      Log.i(getTAG(), "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + " activeTabType:" + this.xJM.xJI + " innerTabType:" + this.xJM.xEw);
      if (this.xJM.type == 7)
      {
        if ((this.xJM.xJI == -1) || (this.xJM.xJI == this.xJM.xEw))
        {
          if (paramq != null)
          {
            g(paramInt1, paramInt2, paramString, paramq);
            AppMethodBeat.o(272413);
            return;
          }
          AppMethodBeat.o(272413);
        }
      }
      else if (paramq != null) {
        g(paramInt1, paramInt2, paramString, paramq);
      }
      AppMethodBeat.o(272413);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "followId", "eventTopicId", "", "encryptedTopicId", "innerTabType", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "userName", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEncryptedTopicId", "()Ljava/lang/String;", "getEventTopicId", "()J", "getFollowId", "getInnerTabType", "()I", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "getType", "getUserName", "call", "", "toString", "plugin-finder_release"})
  public static final class b
    extends FinderTopicFeedLoader.d
  {
    private final int fEH;
    private final com.tencent.mm.cd.b lastBuffer;
    private final bdm location;
    private final String topic;
    private final int type;
    private final String userName;
    private final String xEG;
    final dwb xEX;
    private final String xEv;
    private final int xEw;
    private final Long xJH;
    private final bid xbu;
    private final biv xcZ;
    private final long xdR;
    
    public b(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt2, bdm parambdm, Long paramLong1, com.tencent.mm.cd.b paramb, biv parambiv, String paramString4, int paramInt3, dwb paramdwb, bid parambid)
    {
      AppMethodBeat.i(278935);
      this.type = paramInt1;
      this.topic = paramString1;
      this.xEv = paramString2;
      this.xdR = paramLong;
      this.xEG = paramString3;
      this.xEw = paramInt2;
      this.location = parambdm;
      this.xJH = paramLong1;
      this.lastBuffer = paramb;
      this.xcZ = parambiv;
      this.userName = paramString4;
      this.fEH = paramInt3;
      this.xEX = paramdwb;
      this.xbu = parambid;
      setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
      AppMethodBeat.o(278935);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166059);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.xJN != null) {
          com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.xJN);
        }
        AppMethodBeat.o(166059);
        return;
        this.xJN = ((g)new bv(this.topic, this.xJH, this.lastBuffer, this.xcZ, this.xbu, (byte)0));
        continue;
        bdm localbdm = this.location;
        if (localbdm != null)
        {
          String str = localbdm.SOz;
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          this.xJN = ((g)new bv((String)localObject, localbdm.longitude, localbdm.latitude, this.xJH, this.lastBuffer, this.fEH, this.xEX, this.xcZ, this.xbu));
          continue;
          this.xJN = ((g)new bn(this.lastBuffer, this.userName));
          continue;
          str = this.xEv;
          localObject = str;
          if (str == null)
          {
            localObject = this.xJH;
            if (localObject == null) {
              break label290;
            }
          }
          label290:
          for (long l = ((Long)localObject).longValue();; l = -1L)
          {
            localObject = com.tencent.mm.ae.d.Fw(l);
            this.xJN = ((g)new bv((String)localObject, this.xJH, this.lastBuffer, this.xcZ, this.xbu));
            break;
          }
          this.xJN = ((g)new bv(this.xdR, this.xJH, this.xEG, this.xEw, this.lastBuffer, this.xbu));
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166058);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", type:").append(this.type).append(", topic:").append(this.topic).append(", lastBuffer:");
      if (this.lastBuffer == null)
      {
        localObject = "null";
        localObject = (String)localObject;
        AppMethodBeat.o(166058);
        return localObject;
      }
      Object localObject = this.lastBuffer;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.cd.b)localObject).UH;; localObject = null)
      {
        localObject = MD5Util.getMD5String((byte[])localObject);
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "followId", "eventTopicId", "", "encryptedTopicId", "innerTabType", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "finderUserName", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEncryptedTopicId", "()Ljava/lang/String;", "getEventTopicId", "()J", "getFinderUserName", "getFollowId", "getInnerTabType", "()I", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class c
    extends FinderTopicFeedLoader.d
  {
    private final int fEH;
    private final bdm location;
    final int pullType;
    private final String topic;
    private final int type;
    private final String whH;
    private final String xEG;
    final dwb xEX;
    private final String xEv;
    private final int xEw;
    private final Long xJH;
    private final bid xbu;
    private biv xcZ;
    private final long xdR;
    
    public c(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt2, bdm parambdm, Long paramLong1, biv parambiv, String paramString4, int paramInt3, dwb paramdwb, int paramInt4, bid parambid)
    {
      AppMethodBeat.i(272522);
      this.type = paramInt1;
      this.topic = paramString1;
      this.xEv = paramString2;
      this.xdR = paramLong;
      this.xEG = paramString3;
      this.xEw = paramInt2;
      this.location = parambdm;
      this.xJH = paramLong1;
      this.xcZ = parambiv;
      this.whH = paramString4;
      this.fEH = paramInt3;
      this.xEX = paramdwb;
      this.pullType = paramInt4;
      this.xbu = parambid;
      setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(272522);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166062);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.xJN != null) {
          com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.xJN);
        }
        AppMethodBeat.o(166062);
        return;
        this.xJN = ((g)new bv(this.topic, this.xJH, null, this.xcZ, this.xbu, (byte)0));
        continue;
        bdm localbdm = this.location;
        if (localbdm != null)
        {
          String str = localbdm.SOz;
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          this.xJN = ((g)new bv((String)localObject, localbdm.longitude, localbdm.latitude, this.xJH, null, this.fEH, this.xEX, this.xcZ, this.xbu));
          continue;
          this.xJN = ((g)new bn(null, this.whH));
          continue;
          str = this.xEv;
          localObject = str;
          if (str == null)
          {
            localObject = this.xJH;
            if (localObject == null) {
              break label278;
            }
          }
          label278:
          for (long l = ((Long)localObject).longValue();; l = -1L)
          {
            localObject = com.tencent.mm.ae.d.Fw(l);
            this.xJN = ((g)new bv((String)localObject, this.xJH, null, this.xcZ, this.xbu));
            break;
          }
          this.xJN = ((g)new bv(this.xdR, this.xJH, this.xEG, this.xEw, null, this.xbu));
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166061);
      String str = "hashCode: " + hashCode() + ", type:" + this.type + ", topic:" + this.topic;
      AppMethodBeat.o(166061);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "getScene", "()Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "setScene", "(Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;)V", "call", "", "printRequest", "toString", "plugin-finder_release"})
  public static abstract class d
  {
    private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
    g xJN;
    
    public abstract void call();
    
    public final void duw()
    {
      Log.i(this.TAG, toString());
    }
    
    public final void setTAG(String paramString)
    {
      p.k(paramString, "<set-?>");
      this.TAG = paramString;
    }
    
    public String toString()
    {
      return "";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "errMsg", "", "(IILcom/tencent/mm/protocal/protobuf/FinderTopicInfo;Ljava/lang/String;)V", "disableFlag", "getDisableFlag", "()I", "setDisableFlag", "(I)V", "flag", "getFlag", "setFlag", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagsData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagsData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<bu>
  {
    public int cUP;
    public final bkr fGc;
    public bfg musicInfo;
    public String rsw;
    String tag;
    public long xEc;
    public int xEd;
    public dwb xJO;
    
    public e(int paramInt1, int paramInt2, bkr parambkr, String paramString)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(291390);
      this.fGc = parambkr;
      this.xJO = new dwb();
      AppMethodBeat.o(291390);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "mergeLoadMore", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "plugin-finder_release"})
  public static final class f
    extends BaseFeedLoader<bu>.a
  {
    f()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<bu> paramArrayList, List<? extends bu> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(272288);
      p.k(paramArrayList, "srcList");
      p.k(paramList, "newList");
      if ((this.xJM.type == 4) && (paramList.size() == 1) && ((paramList.get(0) instanceof BaseFinderFeed)))
      {
        Object localObject = paramList.get(0);
        if (localObject == null)
        {
          paramArrayList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(272288);
          throw paramArrayList;
        }
        if (((BaseFinderFeed)localObject).feedObject.getFeedObject().id == 0L)
        {
          AppMethodBeat.o(272288);
          return 1;
        }
      }
      paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, paramObject);
      AppMethodBeat.o(272288);
      return paramInt;
    }
    
    public final void mergeLoadMore(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      int i = 1;
      AppMethodBeat.i(272287);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.iht());
      List localList = paramIResponse.getIncrementList();
      boolean bool;
      if (localList != null)
      {
        bool = localList.isEmpty();
        ((RefreshLoadMoreLayout.c)localObject).mCI = bool;
        ((RefreshLoadMoreLayout.c)localObject).YNF = paramIResponse.getHasMore();
        ((RefreshLoadMoreLayout.c)localObject).xJA = paramIResponse;
        if (!paramIResponse.getHasMore()) {
          break label124;
        }
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(272287);
        return;
        bool = true;
        break;
        label124:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      int j = 3;
      AppMethodBeat.i(272286);
      p.k(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc;
      if (paramIResponse.getPullType() == 1)
      {
        i = 3;
        localc = new RefreshLoadMoreLayout.c(i);
        if (paramIResponse.getPullType() != 1) {
          break label108;
        }
      }
      label108:
      for (int i = j;; i = 4)
      {
        final com.tencent.mm.plugin.finder.feed.model.internal.q localq = new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), false, 12);
        localc.YNF = paramIResponse.getHasMore();
        localc.xJA = paramIResponse;
        com.tencent.mm.ae.d.uiThread((a)new b(this, localq, localc, paramb, paramIResponse));
        AppMethodBeat.o(272286);
        return;
        i = 4;
        break;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderTopicFeedLoader.f paramf, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements a<x>
    {
      b(FinderTopicFeedLoader.f paramf, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
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