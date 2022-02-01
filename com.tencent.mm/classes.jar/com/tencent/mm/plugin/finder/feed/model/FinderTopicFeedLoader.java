package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.j;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "extraUITask", "Lkotlin/Function0;", "", "getExtraUITask", "()Lkotlin/jvm/functions/Function0;", "setExtraUITask", "(Lkotlin/jvm/functions/Function0;)V", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "lattBufferOfTag", "Lcom/tencent/mm/protobuf/ByteString;", "getLattBufferOfTag", "()Lcom/tencent/mm/protobuf/ByteString;", "setLattBufferOfTag", "(Lcom/tencent/mm/protobuf/ByteString;)V", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPoiLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "refObjectId", "", "getRefObjectId", "()Ljava/lang/Long;", "setRefObjectId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTopic", "()Ljava/lang/String;", "getType", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastBuff", "tag", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onSaveLastBuffer", "requestLoadMore", "tabType", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "requestRefresh", "pullType", "saveLastBuff", "buff", "TopicDataFetcher", "TopicLoadMoreRequest", "TopicRefreshRequest", "TopicRequest", "TopicResponse", "plugin-finder_release"})
public final class FinderTopicFeedLoader
  extends BaseFinderFeedLoader
{
  private final String dBe;
  boolean isLoadingMore;
  public arv rRJ;
  private volatile d skY;
  private com.tencent.mm.bw.b skZ;
  private a sla;
  public apl slb;
  public Long slc;
  public a<z> sld;
  private final int type;
  
  public FinderTopicFeedLoader(int paramInt, String paramString, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202981);
    this.type = paramInt;
    this.dBe = paramString;
    this.sla = new a();
    AppMethodBeat.o(202981);
  }
  
  private void a(String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(202974);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setLastBuffer(paramb);
      AppMethodBeat.o(202974);
      return;
    }
    this.skZ = paramb;
    AppMethodBeat.o(202974);
  }
  
  public final void a(int paramInt, ctu paramctu)
  {
    AppMethodBeat.i(202977);
    if (this.isLoadingMore)
    {
      ae.d(getTAG(), "already load more,return");
      AppMethodBeat.o(202977);
      return;
    }
    this.isLoadingMore = true;
    if (paramctu != null)
    {
      localObject = paramctu.HEO;
      if (localObject != null)
      {
        localObject = (asv)((LinkedList)localObject).get(0);
        if (localObject == null) {}
      }
    }
    for (Object localObject = ((asv)localObject).dBe;; localObject = null)
    {
      localObject = aip((String)localObject);
      paramctu = new b(this.type, this.dBe, this.slb, this.slc, (com.tencent.mm.bw.b)localObject, this.rRJ, paramInt, paramctu, getContextObj());
      paramctu.cDG();
      BaseFeedLoader.request$default(this, paramctu, null, 2, null);
      this.skY = ((d)paramctu);
      AppMethodBeat.o(202977);
      return;
    }
  }
  
  public final void a(int paramInt1, ctu paramctu, int paramInt2)
  {
    AppMethodBeat.i(202975);
    String str2 = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("requestRefresh tag: ");
    if (paramctu != null)
    {
      localObject = paramctu.HEO;
      if (localObject != null)
      {
        localObject = (asv)((LinkedList)localObject).get(0);
        if (localObject != null)
        {
          String str1 = ((asv)localObject).dBe;
          localObject = str1;
          if (str1 != null) {
            break label73;
          }
        }
      }
    }
    Object localObject = "null";
    label73:
    ae.d(str2, (String)localObject);
    paramctu = new c(this.type, this.dBe, this.slb, this.slc, this.rRJ, paramInt1, paramctu, paramInt2, getContextObj());
    paramctu.cDG();
    BaseFeedLoader.request$default(this, paramctu, null, 2, null);
    this.skY = ((d)paramctu);
    AppMethodBeat.o(202975);
  }
  
  public final com.tencent.mm.bw.b aip(String paramString)
  {
    AppMethodBeat.i(202973);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = getLastBuffer();
      AppMethodBeat.o(202973);
      return paramString;
    }
    paramString = this.skZ;
    AppMethodBeat.o(202973);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<am> createDataFetch()
  {
    return (com.tencent.mm.plugin.finder.feed.model.internal.g)this.sla;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202980);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderTopicFeedLoader.f(this);
    AppMethodBeat.o(202980);
    return localb;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
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
      ae.i((String)localObject3, "onFetchDone %d feeds", new Object[] { localObject1 });
      if (!(paramIResponse instanceof e)) {
        break label786;
      }
      localObject3 = getTAG();
      localStringBuilder = new StringBuilder("incrementCount ");
      localObject1 = paramIResponse.getIncrementList();
      if (localObject1 == null) {
        break label222;
      }
    }
    label222:
    for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", totalCount ").append(((e)paramIResponse).sbT).append(", lastBuffer ");
      if (getLastBuffer() != null) {
        break label227;
      }
      localObject1 = "null";
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", resp buffer ");
      if (paramIResponse.getLastBuffer() != null) {
        break label254;
      }
      localObject1 = "null";
      ae.i((String)localObject3, (String)localObject1);
      if (!(this.skY instanceof c)) {
        break label372;
      }
      localObject1 = this.skY;
      if (localObject1 != null) {
        break label281;
      }
      paramIResponse = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(166066);
      throw paramIResponse;
      localObject1 = null;
      break;
    }
    label227:
    localObject1 = getLastBuffer();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();; localObject1 = null)
    {
      localObject1 = aj.B((byte[])localObject1);
      break;
    }
    label254:
    localObject1 = paramIResponse.getLastBuffer();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();; localObject1 = null)
    {
      localObject1 = aj.B((byte[])localObject1);
      break;
    }
    label281:
    localObject1 = ((c)localObject1).sjB;
    if (localObject1 != null)
    {
      localObject1 = ((ctu)localObject1).HEO;
      if (localObject1 != null)
      {
        localObject1 = (asv)((LinkedList)localObject1).get(0);
        if (localObject1 != null)
        {
          localObject1 = ((asv)localObject1).dBe;
          a((String)localObject1, paramIResponse.getLastBuffer());
        }
      }
    }
    for (;;)
    {
      if ((this.skY instanceof c))
      {
        localObject1 = this.skY;
        if (localObject1 == null)
        {
          paramIResponse = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
          AppMethodBeat.o(166066);
          throw paramIResponse;
          localObject1 = null;
          break;
          label372:
          if (!(this.skY instanceof b)) {
            continue;
          }
          localObject1 = this.skY;
          if (localObject1 == null)
          {
            paramIResponse = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          localObject1 = ((b)localObject1).sjB;
          if (localObject1 != null)
          {
            localObject1 = ((ctu)localObject1).HEO;
            if (localObject1 != null)
            {
              localObject1 = (asv)((LinkedList)localObject1).get(0);
              if (localObject1 == null) {}
            }
          }
          for (localObject1 = ((asv)localObject1).dBe;; localObject1 = null)
          {
            a((String)localObject1, paramIResponse.getLastBuffer());
            break;
          }
        }
        if (((c)localObject1).pullType != -1)
        {
          localObject1 = this.skY;
          if (localObject1 == null)
          {
            paramIResponse = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          paramIResponse.setPullType(((c)localObject1).pullType);
        }
      }
    }
    for (;;)
    {
      ae.i(getTAG(), "resp tag: " + ((e)paramIResponse).tag);
      if (!(this.skY instanceof c)) {
        break label786;
      }
      localObject1 = this.skY;
      if (localObject1 != null) {
        break;
      }
      paramIResponse = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(166066);
      throw paramIResponse;
      paramIResponse.setPullType(1);
      continue;
      paramIResponse.setPullType(2);
      this.isLoadingMore = false;
    }
    localObject3 = ((c)localObject1).sjB;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((ctu)localObject3).HEO;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = (asv)((LinkedList)localObject3).get(0);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((asv)localObject3).dBe;
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
          ae.i(getTAG(), "resp tag: " + ((e)paramIResponse).tag + " ,not match current tag " + (String)localObject1 + ",return");
          AppMethodBeat.o(166066);
          return;
          i = 0;
        }
        else
        {
          localObject1 = this.sld;
          if (localObject1 != null) {
            ((a)localObject1).invoke();
          }
        }
      }
    }
    for (;;)
    {
      label786:
      super.onFetchDone(paramIResponse);
      AppMethodBeat.o(166066);
      return;
      localObject1 = this.sld;
      if (localObject1 != null) {
        ((a)localObject1).invoke();
      }
    }
  }
  
  public final void onSaveLastBuffer(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202979);
    p.h(paramIResponse, "response");
    AppMethodBeat.o(202979);
  }
  
  public final void requestLoadMore() {}
  
  public final void requestRefresh() {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<am>
    implements com.tencent.mm.ak.f
  {
    private com.tencent.mm.plugin.finder.feed.model.internal.f<am> sle;
    
    public final void alive()
    {
      AppMethodBeat.i(202963);
      super.alive();
      this.slf.isLoadingMore = false;
      com.tencent.mm.kernel.g.ajj().a(817, (com.tencent.mm.ak.f)this);
      AppMethodBeat.o(202963);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202964);
      super.dead();
      com.tencent.mm.kernel.g.ajj().b(817, (com.tencent.mm.ak.f)this);
      AppMethodBeat.o(202964);
    }
    
    public final void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202962);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderTopicFeedLoader.d))
      {
        this.sle = paramf;
        ((FinderTopicFeedLoader.d)paramObject).call();
      }
      AppMethodBeat.o(202962);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202961);
      p.h(paramf, "callback");
      paramf.onFetchDone((IResponse)new c());
      AppMethodBeat.o(202961);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202960);
      p.h(paramf, "callback");
      AppMethodBeat.o(202960);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202959);
      p.h(paramf, "callback");
      AppMethodBeat.o(202959);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202965);
      ae.i(getTAG(), "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if (paramn != null)
      {
        if (!(paramn instanceof as))
        {
          AppMethodBeat.o(202965);
          return;
        }
        FinderTopicFeedLoader.e locale = new FinderTopicFeedLoader.e(paramInt1, paramInt2, paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locale.setLastBuffer(((as)paramn).czQ());
          locale.sbT = ((as)paramn).czX();
          Object localObject1 = (Iterable)((as)paramn).czW();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.sJb;
            localObject2 = FinderItem.a.a((FinderObject)localObject2, 64);
            localObject3 = FinderTopicFeedUI.sqP;
            ((Map)FinderTopicFeedUI.cDM()).put(Long.valueOf(((FinderItem)localObject2).getId()), localObject2);
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            paramString.add(b.a.j((FinderItem)localObject2));
          }
          locale.setIncrementList((List)paramString);
          if (((as)paramn).czR() != 0) {}
          for (boolean bool = true;; bool = false)
          {
            locale.setHasMore(bool);
            paramString = ((as)paramn).rr.aEV();
            if (paramString != null) {
              break;
            }
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(202965);
            throw paramString;
          }
          locale.slh = ((apb)paramString).sjy;
          paramString = ((as)paramn).rr.aEV();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(202965);
            throw paramString;
          }
          paramString = ((apb)paramString).GGq;
          if (paramString == null) {
            break label448;
          }
        }
        label448:
        for (paramString = paramString.HxL;; paramString = null)
        {
          locale.nhq = paramString;
          ae.d(getTAG(), "onSceneEnd (" + ((as)paramn).rRN + ')');
          locale.tag = ((as)paramn).rRN;
          paramString = this.sle;
          if (paramString == null) {
            break;
          }
          paramString.onFetchDone((IResponse)locale);
          AppMethodBeat.o(202965);
          return;
        }
      }
      AppMethodBeat.o(202965);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "()I", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class b
    extends FinderTopicFeedLoader.d
  {
    private final String dBe;
    private final int dvm;
    private final com.tencent.mm.bw.b lastBuffer;
    private final apl location;
    private final arn rQw;
    private final arv rRJ;
    final ctu sjB;
    private final Long slc;
    private final int type;
    
    public b(int paramInt1, String paramString, apl paramapl, Long paramLong, com.tencent.mm.bw.b paramb, arv paramarv, int paramInt2, ctu paramctu, arn paramarn)
    {
      AppMethodBeat.i(202966);
      this.type = paramInt1;
      this.dBe = paramString;
      this.location = paramapl;
      this.slc = paramLong;
      this.lastBuffer = paramb;
      this.rRJ = paramarv;
      this.dvm = paramInt2;
      this.sjB = paramctu;
      this.rQw = paramarn;
      setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
      AppMethodBeat.o(202966);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166059);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.slg != null) {
          com.tencent.mm.kernel.g.ajj().b((n)this.slg);
        }
        AppMethodBeat.o(166059);
        return;
        this.slg = new as(this.dBe, this.slc, this.lastBuffer, this.rRJ, this.rQw);
        continue;
        apl localapl = this.location;
        if (localapl != null)
        {
          String str2 = localapl.GGA;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          this.slg = new as(str1, localapl.dBu, localapl.dzE, this.slc, this.lastBuffer, this.dvm, this.sjB, this.rRJ, this.rQw);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166058);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", type:").append(this.type).append(", topic:").append(this.dBe).append(", lastBuffer:");
      if (this.lastBuffer == null)
      {
        localObject = "null";
        localObject = (String)localObject;
        AppMethodBeat.o(166058);
        return localObject;
      }
      Object localObject = this.lastBuffer;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.bw.b)localObject).getBytes();; localObject = null)
      {
        localObject = aj.B((byte[])localObject);
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "()I", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class c
    extends FinderTopicFeedLoader.d
  {
    private final String dBe;
    private final int dvm;
    private final apl location;
    final int pullType;
    private final arn rQw;
    private arv rRJ;
    final ctu sjB;
    private final Long slc;
    private final int type;
    
    public c(int paramInt1, String paramString, apl paramapl, Long paramLong, arv paramarv, int paramInt2, ctu paramctu, int paramInt3, arn paramarn)
    {
      AppMethodBeat.i(202967);
      this.type = paramInt1;
      this.dBe = paramString;
      this.location = paramapl;
      this.slc = paramLong;
      this.rRJ = paramarv;
      this.dvm = paramInt2;
      this.sjB = paramctu;
      this.pullType = paramInt3;
      this.rQw = paramarn;
      setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(202967);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166062);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.slg != null) {
          com.tencent.mm.kernel.g.ajj().b((n)this.slg);
        }
        AppMethodBeat.o(166062);
        return;
        this.slg = new as(this.dBe, this.slc, null, this.rRJ, this.rQw);
        continue;
        apl localapl = this.location;
        if (localapl != null)
        {
          String str2 = localapl.GGA;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          this.slg = new as(str1, localapl.dBu, localapl.dzE, this.slc, null, this.dvm, this.sjB, this.rRJ, this.rQw);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166061);
      String str = "hashCode: " + hashCode() + ", type:" + this.type + ", topic:" + this.dBe;
      AppMethodBeat.o(166061);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "getScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "setScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;)V", "call", "", "printRequest", "toString", "plugin-finder_release"})
  public static abstract class d
  {
    private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
    as slg;
    
    public final void cDG()
    {
      ae.i(this.TAG, toString());
    }
    
    public abstract void call();
    
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagsData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagsData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<am>
  {
    public String nhq;
    public long sbT;
    public ctu slh;
    String tag;
    
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(202968);
      this.slh = new ctu();
      AppMethodBeat.o(202968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader
 * JD-Core Version:    0.7.0.1
 */