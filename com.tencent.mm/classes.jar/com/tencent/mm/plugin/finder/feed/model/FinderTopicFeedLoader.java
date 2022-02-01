package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.cgi.ct;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.viewmodel.k.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "bypassInfo", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "activeTabType", "getActiveTabType", "()I", "setActiveTabType", "(I)V", "getBypassInfo", "()Ljava/lang/String;", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "getCurRequest", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "setCurRequest", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "encryptedTopicId", "getEncryptedTopicId", "setEncryptedTopicId", "(Ljava/lang/String;)V", "eventTopicId", "", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "extraUITask", "Lkotlin/Function0;", "", "getExtraUITask", "()Lkotlin/jvm/functions/Function0;", "setExtraUITask", "(Lkotlin/jvm/functions/Function0;)V", "followId", "getFollowId", "setFollowId", "innerTabType", "getInnerTabType", "setInnerTabType", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "lattBufferOfTag", "Lcom/tencent/mm/protobuf/ByteString;", "getLattBufferOfTag", "()Lcom/tencent/mm/protobuf/ByteString;", "setLattBufferOfTag", "(Lcom/tencent/mm/protobuf/ByteString;)V", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPoiLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "refObjectId", "getRefObjectId", "()Ljava/lang/Long;", "setRefObjectId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCacheVM;", "getTopic", "getType", "userName", "getUserName", "setUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastBuff", "tag", "isObservePostEvent", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchInitDone", "initResponse", "onSaveLastBuffer", "requestLoadMore", "isAuto", "tabType", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "requestRefresh", "pullType", "saveDataToCache", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "dataList", "", "saveLastBuff", "buff", "TopicDataFetcher", "TopicIInitDone", "TopicLoadMoreRequest", "TopicRefreshRequest", "TopicRequest", "TopicResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderTopicFeedLoader
  extends BaseFinderFeedLoader
{
  public bve ACr;
  private final String Aus;
  private final com.tencent.mm.plugin.finder.viewmodel.k Bbe;
  public String Bbs;
  public int Bbt;
  public String Bbz;
  public a<ah> BgD;
  public volatile e Bjt;
  private com.tencent.mm.bx.b Bju;
  private a Bjv;
  public boi Bjw;
  public Long Bjx;
  public int Bjy;
  boolean isLoadingMore;
  public long ocD;
  final String topic;
  final int type;
  private String userName;
  
  public FinderTopicFeedLoader(int paramInt, String paramString1, bui parambui, String paramString2)
  {
    super(parambui);
    AppMethodBeat.i(365939);
    this.type = paramInt;
    this.topic = paramString1;
    this.Aus = paramString2;
    this.Bjv = new a();
    this.userName = "";
    this.Bbs = "";
    this.Bbz = "";
    this.Bjy = -1;
    paramString1 = com.tencent.mm.ui.component.k.aeZF;
    paramString1 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.k.class);
    kotlin.g.b.s.s(paramString1, "UICProvider.of(PluginFin…cFeedCacheVM::class.java)");
    this.Bbe = ((com.tencent.mm.plugin.finder.viewmodel.k)paramString1);
    AppMethodBeat.o(365939);
  }
  
  private void a(String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(365948);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setLastBuffer(paramb);
      AppMethodBeat.o(365948);
      return;
    }
    this.Bju = paramb;
    AppMethodBeat.o(365948);
  }
  
  public final void a(int paramInt, epc paramepc)
  {
    AppMethodBeat.i(365995);
    if (this.isLoadingMore)
    {
      Log.d(getTAG(), "already load more,return");
      AppMethodBeat.o(365995);
      return;
    }
    this.isLoadingMore = true;
    Object localObject;
    com.tencent.mm.bx.b localb;
    String str2;
    StringBuilder localStringBuilder;
    if (paramepc == null)
    {
      localObject = null;
      localb = avY((String)localObject);
      str2 = getTAG();
      localStringBuilder = new StringBuilder("requestLoadMore tag: ");
      if (paramepc != null) {
        break label244;
      }
      localObject = "null";
    }
    for (;;)
    {
      Log.d(str2, (String)localObject + "  topic:" + this.topic + " innerTabType:" + this.Bbt);
      paramepc = new c(this.type, this.topic, this.Bbs, this.ocD, this.Bbz, this.Bbt, this.Bjw, this.Bjx, localb, this.ACr, this.userName, paramInt, paramepc, getContextObj(), this.Aus);
      paramepc.edT();
      BaseFeedLoader.request$default((BaseFeedLoader)this, paramepc, null, 2, null);
      this.Bjt = ((e)paramepc);
      AppMethodBeat.o(365995);
      return;
      localObject = paramepc.abtn;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = (bxv)((LinkedList)localObject).get(0);
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((bxv)localObject).topic;
      break;
      label244:
      localObject = paramepc.abtn;
      if (localObject == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = (bxv)((LinkedList)localObject).get(0);
        if (localObject == null)
        {
          localObject = "null";
        }
        else
        {
          String str1 = ((bxv)localObject).topic;
          localObject = str1;
          if (str1 == null) {
            localObject = "null";
          }
        }
      }
    }
  }
  
  public final void a(int paramInt1, epc paramepc, int paramInt2)
  {
    AppMethodBeat.i(365990);
    String str2 = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("requestRefresh tag: ");
    Object localObject;
    if (paramepc == null) {
      localObject = "null";
    }
    for (;;)
    {
      Log.d(str2, (String)localObject + "  topic:" + this.topic + " innerTabType:" + this.Bbt + " this:" + this);
      paramepc = new d(this.type, this.topic, this.Bbs, this.ocD, this.Bbz, this.Bbt, this.Bjw, this.Bjx, this.ACr, this.userName, paramInt1, paramepc, paramInt2, getContextObj(), this.Aus);
      paramepc.edT();
      BaseFeedLoader.request$default((BaseFeedLoader)this, paramepc, null, 2, null);
      this.Bjt = ((e)paramepc);
      AppMethodBeat.o(365990);
      return;
      localObject = paramepc.abtn;
      if (localObject == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = (bxv)((LinkedList)localObject).get(0);
        if (localObject == null)
        {
          localObject = "null";
        }
        else
        {
          String str1 = ((bxv)localObject).topic;
          localObject = str1;
          if (str1 == null) {
            localObject = "null";
          }
        }
      }
    }
  }
  
  public final com.tencent.mm.bx.b avY(String paramString)
  {
    AppMethodBeat.i(365969);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = getLastBuffer();
      AppMethodBeat.o(365969);
      return paramString;
    }
    paramString = this.Bju;
    AppMethodBeat.o(365969);
    return paramString;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
  {
    return (com.tencent.mm.plugin.finder.feed.model.internal.i)this.Bjv;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366033);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new g(this);
    AppMethodBeat.o(366033);
    return locald;
  }
  
  public boolean isObservePostEvent()
  {
    AppMethodBeat.i(365977);
    if ((this.type == 4) || (this.type == 7) || (this.type == 12))
    {
      AppMethodBeat.o(365977);
      return true;
    }
    boolean bool = super.isObservePostEvent();
    AppMethodBeat.o(365977);
    return bool;
  }
  
  public void onFetchDone(IResponse<cc> paramIResponse)
  {
    Object localObject2 = null;
    AppMethodBeat.i(166066);
    kotlin.g.b.s.u(paramIResponse, "response");
    Object localObject3 = getTAG();
    Object localObject1 = paramIResponse.getIncrementList();
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, "onFetchDone %d feeds", new Object[] { localObject1 });
      if (!(paramIResponse instanceof f)) {
        break label905;
      }
      localObject3 = getTAG();
      localObject4 = new StringBuilder("incrementCount ");
      localObject1 = paramIResponse.getIncrementList();
      if (localObject1 != null) {
        break label216;
      }
    }
    label216:
    for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject1).size()))
    {
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", totalCount ").append(((f)paramIResponse).Bbb).append(", lastBuffer ");
      if (getLastBuffer() != null) {
        break label229;
      }
      localObject1 = "null";
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", resp buffer ");
      if (paramIResponse.getLastBuffer() != null) {
        break label256;
      }
      localObject1 = "null";
      Log.i((String)localObject3, localObject1);
      if (!(this.Bjt instanceof d)) {
        break label470;
      }
      localObject1 = this.Bjt;
      if (localObject1 != null) {
        break label283;
      }
      paramIResponse = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(166066);
      throw paramIResponse;
      localObject1 = Integer.valueOf(((List)localObject1).size());
      break;
    }
    label229:
    localObject1 = getLastBuffer();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).Op)
    {
      localObject1 = MD5Util.getMD5String((byte[])localObject1);
      break;
    }
    label256:
    localObject1 = paramIResponse.getLastBuffer();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).Op)
    {
      localObject1 = MD5Util.getMD5String((byte[])localObject1);
      break;
    }
    label283:
    localObject1 = ((d)localObject1).BbS;
    if (localObject1 == null)
    {
      localObject1 = null;
      a((String)localObject1, paramIResponse.getLastBuffer());
      localObject1 = ((f)paramIResponse).hLt;
      localObject3 = paramIResponse.getIncrementList();
      if (localObject1 != null)
      {
        localObject4 = ((bxv)localObject1).topic;
        if ((localObject4 != null) && (localObject3 != null))
        {
          com.tencent.mm.plugin.finder.viewmodel.k localk = this.Bbe;
          kotlin.g.b.s.u(localObject4, "keyWord");
          kotlin.g.b.s.u(localObject3, "lastDataList");
          localObject4 = localk.aCM((String)localObject4);
          kotlin.g.b.s.u(localObject3, "<set-?>");
          ((k.a)localObject4).GLv = ((List)localObject3);
          ((k.a)localObject4).hLt = ((bxv)localObject1);
        }
      }
    }
    for (;;)
    {
      if ((this.Bjt instanceof d))
      {
        localObject1 = this.Bjt;
        if (localObject1 == null)
        {
          paramIResponse = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
          AppMethodBeat.o(166066);
          throw paramIResponse;
          localObject1 = ((epc)localObject1).abtn;
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = (bxv)((LinkedList)localObject1).get(0);
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = ((bxv)localObject1).topic;
          break;
          label470:
          if (!(this.Bjt instanceof c)) {
            continue;
          }
          localObject1 = this.Bjt;
          if (localObject1 == null)
          {
            paramIResponse = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          localObject1 = ((c)localObject1).BbS;
          if (localObject1 == null) {
            localObject1 = null;
          }
          for (;;)
          {
            a((String)localObject1, paramIResponse.getLastBuffer());
            break;
            localObject1 = ((epc)localObject1).abtn;
            if (localObject1 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = (bxv)((LinkedList)localObject1).get(0);
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((bxv)localObject1).topic;
              }
            }
          }
        }
        if (((d)localObject1).pullType != -1)
        {
          localObject1 = this.Bjt;
          if (localObject1 == null)
          {
            paramIResponse = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          paramIResponse.setPullType(((d)localObject1).pullType);
        }
      }
    }
    for (;;)
    {
      Log.i(getTAG(), kotlin.g.b.s.X("resp tag: ", ((f)paramIResponse).tag));
      if (!(this.Bjt instanceof d)) {
        break label905;
      }
      localObject1 = this.Bjt;
      if (localObject1 != null) {
        break;
      }
      paramIResponse = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(166066);
      throw paramIResponse;
      paramIResponse.setPullType(1);
      continue;
      if (paramIResponse.getPullType() != 1000)
      {
        paramIResponse.setPullType(2);
        this.isLoadingMore = false;
      }
    }
    localObject1 = ((d)localObject1).BbS;
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label879;
      }
      i = 1;
      label751:
      if (i != 0) {
        break label961;
      }
      localObject2 = ((f)paramIResponse).tag;
      if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
        break label884;
      }
    }
    label879:
    label884:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label889;
      }
      Log.i(getTAG(), "resp tag: " + ((f)paramIResponse).tag + " ,not match current tag " + localObject1 + ",return");
      AppMethodBeat.o(166066);
      return;
      localObject3 = ((epc)localObject1).abtn;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = (bxv)((LinkedList)localObject3).get(0);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = ((bxv)localObject3).topic;
      break;
      i = 0;
      break label751;
    }
    label889:
    localObject1 = this.BgD;
    if (localObject1 != null) {
      ((a)localObject1).invoke();
    }
    label905:
    super.onFetchDone(paramIResponse);
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = (com.tencent.mm.plugin.finder.feed.jumper.i)com.tencent.mm.ui.component.k.cn(cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class);
    paramIResponse = paramIResponse.getIncrementList();
    localObject2 = getContextObj();
    if (localObject2 == null) {}
    for (i = 0;; i = ((bui)localObject2).AJo)
    {
      ((com.tencent.mm.plugin.finder.feed.jumper.i)localObject1).D(paramIResponse, i);
      AppMethodBeat.o(166066);
      return;
      label961:
      localObject1 = this.BgD;
      if (localObject1 == null) {
        break;
      }
      ((a)localObject1).invoke();
      break;
    }
  }
  
  public void onFetchInitDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366062);
    kotlin.g.b.s.u(paramIResponse, "initResponse");
    f localf;
    if ((paramIResponse instanceof f))
    {
      localf = (f)paramIResponse;
      if (localf != null)
      {
        localObject = getInitDone();
        if (!(localObject instanceof b)) {
          break label77;
        }
      }
    }
    label77:
    for (Object localObject = (b)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((b)localObject).g(localf.hLt);
      }
      super.onFetchInitDone(paramIResponse);
      AppMethodBeat.o(366062);
      return;
      localf = null;
      break;
    }
  }
  
  public void onSaveLastBuffer(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366000);
    kotlin.g.b.s.u(paramIResponse, "response");
    AppMethodBeat.o(366000);
  }
  
  public void requestLoadMore(boolean paramBoolean) {}
  
  public void requestRefresh() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "sceneSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lkotlin/collections/HashSet;", "getSceneSet", "()Ljava/util/HashSet;", "setSceneSet", "(Ljava/util/HashSet;)V", "alive", "", "dead", "fetch", "request", "", "callback", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchRefresh", "handleScene", "errType", "", "errCode", "errMsg", "", "scene", "onSceneEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<cc>
    implements com.tencent.mm.am.h
  {
    private com.tencent.mm.plugin.finder.feed.model.internal.h<cc> BgE;
    private HashSet<com.tencent.mm.am.p> BgF;
    
    public a()
    {
      AppMethodBeat.i(366487);
      this.BgF = new HashSet();
      AppMethodBeat.o(366487);
    }
    
    private final void f(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(366508);
      FinderTopicFeedLoader.f localf;
      if ((paramp instanceof ct))
      {
        boolean bool = this.BgF.remove(paramp);
        Log.i(getTAG(), kotlin.g.b.s.X("isRemoved :", Boolean.valueOf(bool)));
        if (!bool)
        {
          AppMethodBeat.o(366508);
          return;
        }
        Object localObject2;
        if ((this.Bjz.type == 7) || (this.Bjz.type == 12))
        {
          if ((((ct)paramp).dWh() == 7) && (((ct)paramp).getTabType() != this.Bjz.Bbt))
          {
            Log.i(getTAG(), "activity request ignore not my tab innerTabType:" + this.Bjz.Bbt + "  tabType: " + ((ct)paramp).getTabType());
            AppMethodBeat.o(366508);
            return;
          }
          if (((ct)paramp).dWh() == 12)
          {
            localObject2 = c.b.b(((ct)paramp).rr.otB);
            if (localObject2 == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListRequest");
              AppMethodBeat.o(366508);
              throw paramString;
            }
            if (((bbf)localObject2).ADo != this.Bjz.ocD)
            {
              Log.i(getTAG(), "activity request ignore not my tab innerTabType:" + this.Bjz.Bbt + " eventTopicId:" + this.Bjz.ocD + " tabType: " + ((ct)paramp).getTabType());
              AppMethodBeat.o(366508);
              return;
            }
          }
          if ((((ct)paramp).dWh() != 7) && (((ct)paramp).dWh() != 12))
          {
            Log.i(getTAG(), "other type request if current is activity ignore!! innerTabType:" + this.Bjz.Bbt + "  tabType: " + ((ct)paramp).getTabType());
            AppMethodBeat.o(366508);
            return;
          }
        }
        localf = new FinderTopicFeedLoader.f(paramInt1, paramInt2, ((ct)paramp).dWj(), paramString);
        Log.i(getTAG(), "handleScene errType:" + paramInt1 + " errCode:" + paramInt2);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localf.setLastBuffer(((ct)paramp).dVY());
          localf.Bbb = ((ct)paramp).dWi();
          localObject2 = (Iterable)((ct)paramp).dVW();
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          Object localObject4;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.e((FinderObject)localObject3, 64);
            localObject4 = FinderTopicFeedUI.Bst;
            ((Map)FinderTopicFeedUI.eeA()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString.add(d.a.a((FinderItem)localObject3));
          }
          localf.setIncrementList((List)paramString);
          paramString = getTAG();
          localObject2 = localf.getIncrementList();
          if (localObject2 == null)
          {
            paramInt1 = 0;
            Log.i(paramString, kotlin.g.b.s.X("handleScene incrementList :", Integer.valueOf(paramInt1)));
            if (((ct)paramp).Auy == 4)
            {
              paramString = localf.getIncrementList();
              if (paramString != null) {
                break label813;
              }
              paramInt1 = 0;
              label652:
              if (paramInt1 > 0)
              {
                paramString = localf.getIncrementList();
                if (paramString != null)
                {
                  paramString = (cc)paramString.get(0);
                  if (paramString != null)
                  {
                    localObject3 = (BaseFinderFeed)paramString;
                    localObject4 = com.tencent.mm.ae.d.hF(((BaseFinderFeed)paramString).feedObject.field_id);
                    paramString = ((ct)paramp).getBgmInfo();
                    if (paramString != null) {
                      break label823;
                    }
                    paramString = Integer.valueOf(0);
                    label720:
                    ((BaseFinderFeed)localObject3).isOriginFeed = kotlin.g.b.s.p(localObject4, paramString);
                  }
                }
              }
            }
            localf.setPullType(((ct)paramp).pullType);
            if (((ct)paramp).dVZ() == 0) {
              break label845;
            }
          }
          label813:
          label823:
          label845:
          for (bool = true;; bool = false)
          {
            localf.setHasMore(bool);
            paramString = c.c.b(((ct)paramp).rr.otC);
            if (paramString != null) {
              break label851;
            }
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(366508);
            throw paramString;
            paramInt1 = ((List)localObject2).size();
            break;
            paramInt1 = paramString.size();
            break label652;
            localObject2 = paramString.groupId;
            paramString = (String)localObject2;
            if (localObject2 != null) {
              break label720;
            }
            paramString = Integer.valueOf(0);
            break label720;
          }
          label851:
          localf.BjA = ((bbg)paramString).BbC;
          paramString = c.c.b(((ct)paramp).rr.otC);
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(366508);
            throw paramString;
          }
          paramString = ((bbg)paramString).ZLY;
          if (paramString == null) {}
          for (paramString = null;; paramString = paramString.abky)
          {
            localf.uCW = paramString;
            paramString = c.c.b(((ct)paramp).rr.otC);
            if (paramString != null) {
              break;
            }
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(366508);
            throw paramString;
          }
          paramString = ((bbg)paramString).ZLU;
          if (paramString == null) {}
          for (paramString = localObject1;; paramString = paramString.ZHW)
          {
            localf.musicInfo = paramString;
            localf.setBgmInfo(((ct)paramp).getBgmInfo());
            paramString = c.c.b(((ct)paramp).rr.otC);
            if (paramString != null) {
              break;
            }
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(366508);
            throw paramString;
          }
          paramString = ((bbg)paramString).ZLU;
          if (paramString == null) {}
          for (paramInt1 = 0;; paramInt1 = paramString.aagI)
          {
            localf.eQp = paramInt1;
            paramString = c.c.b(((ct)paramp).rr.otC);
            if (paramString != null) {
              break;
            }
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(366508);
            throw paramString;
          }
          paramString = ((bbg)paramString).ZLU;
          if (paramString != null) {
            break label1205;
          }
        }
      }
      label1205:
      for (paramInt1 = i;; paramInt1 = paramString.aagJ)
      {
        localf.Bbc = paramInt1;
        Log.d(getTAG(), "onSceneEnd (" + ((ct)paramp).ACG + ')');
        localf.tag = ((ct)paramp).ACG;
        paramString = this.BgE;
        if (paramString != null) {
          paramString.onFetchDone((IResponse)localf);
        }
        AppMethodBeat.o(366508);
        return;
      }
    }
    
    public final void alive()
    {
      AppMethodBeat.i(366543);
      super.alive();
      this.Bjz.isLoadingMore = false;
      com.tencent.mm.kernel.h.aZW().a(817, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(366543);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(366554);
      super.dead();
      com.tencent.mm.kernel.h.aZW().b(817, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(366554);
    }
    
    public final void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366533);
      kotlin.g.b.s.u(paramh, "callback");
      if ((paramObject instanceof FinderTopicFeedLoader.e))
      {
        this.BgE = paramh;
        ((FinderTopicFeedLoader.e)paramObject).call();
        this.BgF.add(((FinderTopicFeedLoader.e)paramObject).BgH);
      }
      AppMethodBeat.o(366533);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366526);
      kotlin.g.b.s.u(paramh, "callback");
      Object localObject = FinderTopicFeedLoader.a(this.Bjz).aCM(this.Bjz.topic);
      if (((k.a)localObject).hLt != null)
      {
        if (!((Collection)((k.a)localObject).GLv).isEmpty()) {}
        for (int i = 1; i != 0; i = 0)
        {
          FinderTopicFeedLoader.f localf = new FinderTopicFeedLoader.f(0, 0, ((k.a)localObject).hLt, "");
          localf.setIncrementList(((k.a)localObject).GLv);
          localf.setPullType(1000);
          localObject = ah.aiuX;
          paramh.onFetchDone((IResponse)localf);
          AppMethodBeat.o(366526);
          return;
        }
      }
      paramh.onFetchDone((IResponse)new e());
      AppMethodBeat.o(366526);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366520);
      kotlin.g.b.s.u(paramh, "callback");
      AppMethodBeat.o(366520);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366514);
      kotlin.g.b.s.u(paramh, "callback");
      AppMethodBeat.o(366514);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366565);
      Log.i(getTAG(), "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + " activeTabType:" + this.Bjz.Bjy + " innerTabType:" + this.Bjz.Bbt);
      if ((this.Bjz.type == 7) || (this.Bjz.type == 12))
      {
        if (((this.Bjz.Bjy == -1) || (this.Bjz.Bjy == this.Bjz.Bbt)) && (paramp != null))
        {
          f(paramInt1, paramInt2, paramString, paramp);
          AppMethodBeat.o(366565);
        }
      }
      else if (paramp != null) {
        f(paramInt1, paramInt2, paramString, paramp);
      }
      AppMethodBeat.o(366565);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicIInitDone;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "callInfo", "", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
    extends j
  {
    public abstract void g(bxv parambxv);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "followId", "eventTopicId", "", "encryptedTopicId", "innerTabType", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "userName", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "bypassInfo", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "getBypassInfo", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEncryptedTopicId", "getEventTopicId", "()J", "getFollowId", "getInnerTabType", "()I", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "getType", "getUserName", "call", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends FinderTopicFeedLoader.e
  {
    private final bve ACr;
    private final bui Auc;
    private final String Aus;
    final epc BbS;
    private final String Bbs;
    private final int Bbt;
    private final String Bbz;
    private final Long Bjx;
    private final int hJx;
    private final com.tencent.mm.bx.b lastBuffer;
    private final boi location;
    private final long ocD;
    private final String topic;
    private final int type;
    private final String userName;
    
    public c(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt2, boi paramboi, Long paramLong1, com.tencent.mm.bx.b paramb, bve parambve, String paramString4, int paramInt3, epc paramepc, bui parambui, String paramString5)
    {
      AppMethodBeat.i(366500);
      this.type = paramInt1;
      this.topic = paramString1;
      this.Bbs = paramString2;
      this.ocD = paramLong;
      this.Bbz = paramString3;
      this.Bbt = paramInt2;
      this.location = paramboi;
      this.Bjx = paramLong1;
      this.lastBuffer = paramb;
      this.ACr = parambve;
      this.userName = paramString4;
      this.hJx = paramInt3;
      this.BbS = paramepc;
      this.Auc = parambui;
      this.Aus = paramString5;
      setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
      AppMethodBeat.o(366500);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166059);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.BgH != null) {
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BgH, 0);
        }
        AppMethodBeat.o(166059);
        return;
        this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct(this.topic, this.Bjx, this.lastBuffer, this.ACr, this.Auc, this.Aus, (byte)0));
        continue;
        boi localboi = this.location;
        if (localboi != null)
        {
          String str = localboi.ZWG;
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct((String)localObject, localboi.longitude, localboi.latitude, this.Bjx, this.lastBuffer, this.hJx, this.BbS, this.ACr, this.Auc, this.Aus));
          continue;
          this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ck(this.lastBuffer, this.userName));
          continue;
          str = this.Bbs;
          localObject = str;
          if (str == null)
          {
            localObject = this.Bjx;
            if (localObject != null) {
              break label322;
            }
          }
          label322:
          for (long l = -1L;; l = ((Long)localObject).longValue())
          {
            localObject = com.tencent.mm.ae.d.hF(l);
            this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct((String)localObject, this.Bjx, this.lastBuffer, this.ACr, this.Auc, this.Aus));
            break;
          }
          this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct(this.ocD, this.Bjx, this.Bbz, this.Bbt, this.lastBuffer, this.Auc, this.Aus));
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
        localObject = localObject;
        AppMethodBeat.o(166058);
        return localObject;
      }
      Object localObject = this.lastBuffer;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.bx.b)localObject).Op)
      {
        localObject = MD5Util.getMD5String((byte[])localObject);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "followId", "eventTopicId", "", "encryptedTopicId", "innerTabType", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "finderUserName", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "bypassInfo", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "getBypassInfo", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEncryptedTopicId", "getEventTopicId", "()J", "getFinderUserName", "getFollowId", "getInnerTabType", "()I", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "getType", "call", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends FinderTopicFeedLoader.e
  {
    private bve ACr;
    private final bui Auc;
    private final String Aus;
    final epc BbS;
    private final String Bbs;
    private final int Bbt;
    private final String Bbz;
    private final Long Bjx;
    private final int hJx;
    private final boi location;
    private final long ocD;
    final int pullType;
    private final String topic;
    private final int type;
    private final String zDJ;
    
    public d(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt2, boi paramboi, Long paramLong1, bve parambve, String paramString4, int paramInt3, epc paramepc, int paramInt4, bui parambui, String paramString5)
    {
      AppMethodBeat.i(366513);
      this.type = paramInt1;
      this.topic = paramString1;
      this.Bbs = paramString2;
      this.ocD = paramLong;
      this.Bbz = paramString3;
      this.Bbt = paramInt2;
      this.location = paramboi;
      this.Bjx = paramLong1;
      this.ACr = parambve;
      this.zDJ = paramString4;
      this.hJx = paramInt3;
      this.BbS = paramepc;
      this.pullType = paramInt4;
      this.Auc = parambui;
      this.Aus = paramString5;
      setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(366513);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166062);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.BgH != null) {
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BgH, 0);
        }
        AppMethodBeat.o(166062);
        return;
        this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct(this.topic, this.Bjx, null, this.ACr, this.Auc, this.Aus, (byte)0));
        continue;
        boi localboi = this.location;
        if (localboi != null)
        {
          String str = localboi.ZWG;
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct((String)localObject, localboi.longitude, localboi.latitude, this.Bjx, null, this.hJx, this.BbS, this.ACr, this.Auc, this.Aus));
          continue;
          this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ck(null, this.zDJ));
          continue;
          str = this.Bbs;
          localObject = str;
          if (str == null)
          {
            localObject = this.Bjx;
            if (localObject != null) {
              break label310;
            }
          }
          label310:
          for (long l = -1L;; l = ((Long)localObject).longValue())
          {
            localObject = com.tencent.mm.ae.d.hF(l);
            this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct((String)localObject, this.Bjx, null, this.ACr, this.Auc, this.Aus));
            break;
          }
          this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new ct(this.ocD, this.Bjx, this.Bbz, this.Bbt, null, this.Auc, this.Aus));
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "getScene", "()Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "setScene", "(Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;)V", "call", "", "printRequest", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class e
  {
    com.tencent.mm.plugin.findersdk.b.h BgH;
    private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
    
    public abstract void call();
    
    public final void edT()
    {
      Log.i(this.TAG, toString());
    }
    
    public final void setTAG(String paramString)
    {
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.TAG = paramString;
    }
    
    public String toString()
    {
      return "";
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "errMsg", "", "(IILcom/tencent/mm/protocal/protobuf/FinderTopicInfo;Ljava/lang/String;)V", "disableFlag", "getDisableFlag", "()I", "setDisableFlag", "(I)V", "flag", "getFlag", "setFlag", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagsData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagsData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends IResponse<cc>
  {
    public long Bbb;
    public int Bbc;
    public epc BjA;
    public int eQp;
    public final bxv hLt;
    public bqj musicInfo;
    String tag;
    public String uCW;
    
    public f(int paramInt1, int paramInt2, bxv parambxv, String paramString)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(366465);
      this.hLt = parambxv;
      this.BjA = new epc();
      AppMethodBeat.o(366465);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "mergeLoadMore", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends BaseFeedLoader<cc>.a
  {
    g(FinderTopicFeedLoader paramFinderTopicFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366477);
      AppMethodBeat.o(366477);
    }
    
    public final int findMergeIndex(ArrayList<cc> paramArrayList, List<? extends cc> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(366501);
      kotlin.g.b.s.u(paramArrayList, "srcList");
      kotlin.g.b.s.u(paramList, "newList");
      if ((this.Bjz.type == 4) && (paramList.size() == 1) && ((paramList.get(0) instanceof BaseFinderFeed)) && (((BaseFinderFeed)paramList.get(0)).feedObject.getFeedObject().id == 0L))
      {
        AppMethodBeat.o(366501);
        return 1;
      }
      paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, paramObject);
      AppMethodBeat.o(366501);
      return paramInt;
    }
    
    public final void mergeLoadMore(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int i = 1;
      AppMethodBeat.i(366493);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
      List localList = paramIResponse.getIncrementList();
      boolean bool;
      if (localList == null)
      {
        bool = true;
        ((RefreshLoadMoreLayout.d)localObject).pzq = bool;
        ((RefreshLoadMoreLayout.d)localObject).agJu = paramIResponse.getHasMore();
        ((RefreshLoadMoreLayout.d)localObject).extraData = paramIResponse;
        if (!paramIResponse.getHasMore()) {
          break label128;
        }
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.Bjz, paramb, paramIResponse));
        AppMethodBeat.o(366493);
        return;
        bool = localList.isEmpty();
        break;
        label128:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int j = 3;
      AppMethodBeat.i(366484);
      kotlin.g.b.s.u(paramIResponse, "response");
      final RefreshLoadMoreLayout.d locald;
      if (paramIResponse.getPullType() == 1)
      {
        i = 3;
        locald = new RefreshLoadMoreLayout.d(i);
        if (paramIResponse.getPullType() != 1) {
          break label112;
        }
      }
      label112:
      for (int i = j;; i = 4)
      {
        final r localr = new r(i, paramIResponse.getIncrementList(), false, 12);
        locald.agJu = paramIResponse.getHasMore();
        locald.extraData = paramIResponse;
        com.tencent.mm.ae.d.uiThread((a)new b(this, localr, locald, this.Bjz, paramb, paramIResponse));
        AppMethodBeat.o(366484);
        return;
        i = 4;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderTopicFeedLoader.g paramg, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderTopicFeedLoader paramFinderTopicFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(FinderTopicFeedLoader.g paramg, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderTopicFeedLoader paramFinderTopicFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
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