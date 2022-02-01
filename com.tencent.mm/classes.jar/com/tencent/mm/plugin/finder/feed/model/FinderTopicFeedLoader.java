package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.a.a;
import d.g.b.p;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "extraUITask", "Lkotlin/Function0;", "", "getExtraUITask", "()Lkotlin/jvm/functions/Function0;", "setExtraUITask", "(Lkotlin/jvm/functions/Function0;)V", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "lattBufferOfTag", "Lcom/tencent/mm/protobuf/ByteString;", "getLattBufferOfTag", "()Lcom/tencent/mm/protobuf/ByteString;", "setLattBufferOfTag", "(Lcom/tencent/mm/protobuf/ByteString;)V", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPoiLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "refObjectId", "", "getRefObjectId", "()Ljava/lang/Long;", "setRefObjectId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTopic", "()Ljava/lang/String;", "getType", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastBuff", "tag", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onSaveLastBuffer", "requestLoadMore", "tabType", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "requestRefresh", "pullType", "saveLastBuff", "buff", "TopicDataFetcher", "TopicLoadMoreRequest", "TopicRefreshRequest", "TopicRequest", "TopicResponse", "plugin-finder_release"})
public final class FinderTopicFeedLoader
  extends BaseFinderFeedLoader
{
  private final String dzZ;
  boolean isLoadingMore;
  public arg rJv;
  private volatile d sch;
  private com.tencent.mm.bx.b sci;
  private a scj;
  public aoy sck;
  public Long scl;
  public a<z> scm;
  private final int type;
  
  public FinderTopicFeedLoader(int paramInt, String paramString, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202505);
    this.type = paramInt;
    this.dzZ = paramString;
    this.scj = new a();
    AppMethodBeat.o(202505);
  }
  
  private void a(String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(202498);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setLastBuffer(paramb);
      AppMethodBeat.o(202498);
      return;
    }
    this.sci = paramb;
    AppMethodBeat.o(202498);
  }
  
  public final void a(int paramInt, cta paramcta)
  {
    AppMethodBeat.i(202501);
    if (this.isLoadingMore)
    {
      ad.d(getTAG(), "already load more,return");
      AppMethodBeat.o(202501);
      return;
    }
    this.isLoadingMore = true;
    if (paramcta != null)
    {
      localObject = paramcta.Hlo;
      if (localObject != null)
      {
        localObject = (asg)((LinkedList)localObject).get(0);
        if (localObject == null) {}
      }
    }
    for (Object localObject = ((asg)localObject).dzZ;; localObject = null)
    {
      localObject = ahs((String)localObject);
      paramcta = new b(this.type, this.dzZ, this.sck, this.scl, (com.tencent.mm.bx.b)localObject, this.rJv, paramInt, paramcta, getContextObj());
      paramcta.cBU();
      BaseFeedLoader.request$default(this, paramcta, null, 2, null);
      this.sch = ((d)paramcta);
      AppMethodBeat.o(202501);
      return;
    }
  }
  
  public final void a(int paramInt1, cta paramcta, int paramInt2)
  {
    AppMethodBeat.i(202499);
    String str2 = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("requestRefresh tag: ");
    if (paramcta != null)
    {
      localObject = paramcta.Hlo;
      if (localObject != null)
      {
        localObject = (asg)((LinkedList)localObject).get(0);
        if (localObject != null)
        {
          String str1 = ((asg)localObject).dzZ;
          localObject = str1;
          if (str1 != null) {
            break label73;
          }
        }
      }
    }
    Object localObject = "null";
    label73:
    ad.d(str2, (String)localObject);
    paramcta = new c(this.type, this.dzZ, this.sck, this.scl, this.rJv, paramInt1, paramcta, paramInt2, getContextObj());
    paramcta.cBU();
    BaseFeedLoader.request$default(this, paramcta, null, 2, null);
    this.sch = ((d)paramcta);
    AppMethodBeat.o(202499);
  }
  
  public final com.tencent.mm.bx.b ahs(String paramString)
  {
    AppMethodBeat.i(202497);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = getLastBuffer();
      AppMethodBeat.o(202497);
      return paramString;
    }
    paramString = this.sci;
    AppMethodBeat.o(202497);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<al> createDataFetch()
  {
    return (com.tencent.mm.plugin.finder.feed.model.internal.g)this.scj;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202504);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new f(this);
    AppMethodBeat.o(202504);
    return localb;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
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
      ad.i((String)localObject3, "onFetchDone %d feeds", new Object[] { localObject1 });
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
      localStringBuilder = localStringBuilder.append(localObject1).append(", totalCount ").append(((e)paramIResponse).rTp).append(", lastBuffer ");
      if (getLastBuffer() != null) {
        break label227;
      }
      localObject1 = "null";
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", resp buffer ");
      if (paramIResponse.getLastBuffer() != null) {
        break label254;
      }
      localObject1 = "null";
      ad.i((String)localObject3, (String)localObject1);
      if (!(this.sch instanceof c)) {
        break label372;
      }
      localObject1 = this.sch;
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
    for (localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();; localObject1 = null)
    {
      localObject1 = ai.B((byte[])localObject1);
      break;
    }
    label254:
    localObject1 = paramIResponse.getLastBuffer();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.bx.b)localObject1).getBytes();; localObject1 = null)
    {
      localObject1 = ai.B((byte[])localObject1);
      break;
    }
    label281:
    localObject1 = ((c)localObject1).saM;
    if (localObject1 != null)
    {
      localObject1 = ((cta)localObject1).Hlo;
      if (localObject1 != null)
      {
        localObject1 = (asg)((LinkedList)localObject1).get(0);
        if (localObject1 != null)
        {
          localObject1 = ((asg)localObject1).dzZ;
          a((String)localObject1, paramIResponse.getLastBuffer());
        }
      }
    }
    for (;;)
    {
      if ((this.sch instanceof c))
      {
        localObject1 = this.sch;
        if (localObject1 == null)
        {
          paramIResponse = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
          AppMethodBeat.o(166066);
          throw paramIResponse;
          localObject1 = null;
          break;
          label372:
          if (!(this.sch instanceof b)) {
            continue;
          }
          localObject1 = this.sch;
          if (localObject1 == null)
          {
            paramIResponse = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
            AppMethodBeat.o(166066);
            throw paramIResponse;
          }
          localObject1 = ((b)localObject1).saM;
          if (localObject1 != null)
          {
            localObject1 = ((cta)localObject1).Hlo;
            if (localObject1 != null)
            {
              localObject1 = (asg)((LinkedList)localObject1).get(0);
              if (localObject1 == null) {}
            }
          }
          for (localObject1 = ((asg)localObject1).dzZ;; localObject1 = null)
          {
            a((String)localObject1, paramIResponse.getLastBuffer());
            break;
          }
        }
        if (((c)localObject1).pullType != -1)
        {
          localObject1 = this.sch;
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
      ad.i(getTAG(), "resp tag: " + ((e)paramIResponse).tag);
      if (!(this.sch instanceof c)) {
        break label786;
      }
      localObject1 = this.sch;
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
    localObject3 = ((c)localObject1).saM;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((cta)localObject3).Hlo;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = (asg)((LinkedList)localObject3).get(0);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((asg)localObject3).dzZ;
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
          ad.i(getTAG(), "resp tag: " + ((e)paramIResponse).tag + " ,not match current tag " + (String)localObject1 + ",return");
          AppMethodBeat.o(166066);
          return;
          i = 0;
        }
        else
        {
          localObject1 = this.scm;
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
      localObject1 = this.scm;
      if (localObject1 != null) {
        ((a)localObject1).invoke();
      }
    }
  }
  
  public final void onSaveLastBuffer(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202503);
    p.h(paramIResponse, "response");
    AppMethodBeat.o(202503);
  }
  
  public final void requestLoadMore() {}
  
  public final void requestRefresh() {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<al>
    implements com.tencent.mm.al.f
  {
    private com.tencent.mm.plugin.finder.feed.model.internal.f<al> scn;
    
    public final void alive()
    {
      AppMethodBeat.i(202487);
      super.alive();
      this.sco.isLoadingMore = false;
      com.tencent.mm.kernel.g.aiU().a(817, (com.tencent.mm.al.f)this);
      AppMethodBeat.o(202487);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202488);
      super.dead();
      com.tencent.mm.kernel.g.aiU().b(817, (com.tencent.mm.al.f)this);
      AppMethodBeat.o(202488);
    }
    
    public final void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.f<al> paramf)
    {
      AppMethodBeat.i(202486);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderTopicFeedLoader.d))
      {
        this.scn = paramf;
        ((FinderTopicFeedLoader.d)paramObject).call();
      }
      AppMethodBeat.o(202486);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<al> paramf)
    {
      AppMethodBeat.i(202485);
      p.h(paramf, "callback");
      paramf.onFetchDone((IResponse)new com.tencent.mm.plugin.finder.feed.model.internal.c());
      AppMethodBeat.o(202485);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.f<al> paramf)
    {
      AppMethodBeat.i(202484);
      p.h(paramf, "callback");
      AppMethodBeat.o(202484);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.f<al> paramf)
    {
      AppMethodBeat.i(202483);
      p.h(paramf, "callback");
      AppMethodBeat.o(202483);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202489);
      ad.i(getTAG(), "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if (paramn != null)
      {
        if (!(paramn instanceof ar))
        {
          AppMethodBeat.o(202489);
          return;
        }
        FinderTopicFeedLoader.e locale = new FinderTopicFeedLoader.e(paramInt1, paramInt2, paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locale.setLastBuffer(((ar)paramn).cyp());
          locale.rTp = ((ar)paramn).cyw();
          Object localObject1 = (Iterable)((ar)paramn).cyv();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.syk;
            localObject2 = FinderItem.a.a((FinderObject)localObject2, 64);
            localObject3 = FinderTopicFeedUI.shU;
            ((Map)FinderTopicFeedUI.cCa()).put(Long.valueOf(((FinderItem)localObject2).getId()), localObject2);
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            paramString.add(b.a.j((FinderItem)localObject2));
          }
          locale.setIncrementList((List)paramString);
          if (((ar)paramn).cyq() != 0) {}
          for (boolean bool = true;; bool = false)
          {
            locale.setHasMore(bool);
            paramString = ((ar)paramn).rr.aEF();
            if (paramString != null) {
              break;
            }
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(202489);
            throw paramString;
          }
          locale.scq = ((aoo)paramString).saJ;
          paramString = ((ar)paramn).rr.aEF();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(202489);
            throw paramString;
          }
          paramString = ((aoo)paramString).Gnk;
          if (paramString == null) {
            break label448;
          }
        }
        label448:
        for (paramString = paramString.Hel;; paramString = null)
        {
          locale.nch = paramString;
          ad.d(getTAG(), "onSceneEnd (" + ((ar)paramn).rJz + ')');
          locale.tag = ((ar)paramn).rJz;
          paramString = this.scn;
          if (paramString == null) {
            break;
          }
          paramString.onFetchDone((IResponse)locale);
          AppMethodBeat.o(202489);
          return;
        }
      }
      AppMethodBeat.o(202489);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "()I", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class b
    extends FinderTopicFeedLoader.d
  {
    private final int duh;
    private final String dzZ;
    private final com.tencent.mm.bx.b lastBuffer;
    private final aoy location;
    private final aqy rIl;
    private final arg rJv;
    final cta saM;
    private final Long scl;
    private final int type;
    
    public b(int paramInt1, String paramString, aoy paramaoy, Long paramLong, com.tencent.mm.bx.b paramb, arg paramarg, int paramInt2, cta paramcta, aqy paramaqy)
    {
      AppMethodBeat.i(202490);
      this.type = paramInt1;
      this.dzZ = paramString;
      this.location = paramaoy;
      this.scl = paramLong;
      this.lastBuffer = paramb;
      this.rJv = paramarg;
      this.duh = paramInt2;
      this.saM = paramcta;
      this.rIl = paramaqy;
      setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
      AppMethodBeat.o(202490);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166059);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.scp != null) {
          com.tencent.mm.kernel.g.aiU().b((n)this.scp);
        }
        AppMethodBeat.o(166059);
        return;
        this.scp = new ar(this.dzZ, this.scl, this.lastBuffer, this.rJv, this.rIl);
        continue;
        aoy localaoy = this.location;
        if (localaoy != null)
        {
          String str = localaoy.Gnu;
          p.g(str, "it.poiClassifyId");
          this.scp = new ar(str, localaoy.dAp, localaoy.dyz, this.scl, this.lastBuffer, this.duh, this.saM, this.rJv, this.rIl);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166058);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", type:").append(this.type).append(", topic:").append(this.dzZ).append(", lastBuffer:");
      if (this.lastBuffer == null)
      {
        localObject = "null";
        localObject = (String)localObject;
        AppMethodBeat.o(166058);
        return localObject;
      }
      Object localObject = this.lastBuffer;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.bx.b)localObject).getBytes();; localObject = null)
      {
        localObject = ai.B((byte[])localObject);
        break;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "()I", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class c
    extends FinderTopicFeedLoader.d
  {
    private final int duh;
    private final String dzZ;
    private final aoy location;
    final int pullType;
    private final aqy rIl;
    private arg rJv;
    final cta saM;
    private final Long scl;
    private final int type;
    
    public c(int paramInt1, String paramString, aoy paramaoy, Long paramLong, arg paramarg, int paramInt2, cta paramcta, int paramInt3, aqy paramaqy)
    {
      AppMethodBeat.i(202491);
      this.type = paramInt1;
      this.dzZ = paramString;
      this.location = paramaoy;
      this.scl = paramLong;
      this.rJv = paramarg;
      this.duh = paramInt2;
      this.saM = paramcta;
      this.pullType = paramInt3;
      this.rIl = paramaqy;
      setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(202491);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166062);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.scp != null) {
          com.tencent.mm.kernel.g.aiU().b((n)this.scp);
        }
        AppMethodBeat.o(166062);
        return;
        this.scp = new ar(this.dzZ, this.scl, null, this.rJv, this.rIl);
        continue;
        aoy localaoy = this.location;
        if (localaoy != null)
        {
          String str = localaoy.Gnu;
          p.g(str, "it.poiClassifyId");
          this.scp = new ar(str, localaoy.dAp, localaoy.dyz, this.scl, null, this.duh, this.saM, this.rJv, this.rIl);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166061);
      String str = "hashCode: " + hashCode() + ", type:" + this.type + ", topic:" + this.dzZ;
      AppMethodBeat.o(166061);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "getScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "setScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;)V", "call", "", "printRequest", "toString", "plugin-finder_release"})
  public static abstract class d
  {
    private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
    ar scp;
    
    public final void cBU()
    {
      ad.i(this.TAG, toString());
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagsData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagsData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<al>
  {
    public String nch;
    public long rTp;
    public cta scq;
    String tag;
    
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(202492);
      this.scq = new cta();
      AppMethodBeat.o(202492);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeLoadMore", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "plugin-finder_release"})
  public static final class f
    extends BaseFeedLoader<al>.a
  {
    f()
    {
      super();
    }
    
    public final void mergeLoadMore(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      int i = 1;
      AppMethodBeat.i(202496);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Lrp;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fQc());
      List localList = paramIResponse.getIncrementList();
      boolean bool;
      if (localList != null)
      {
        bool = localList.isEmpty();
        ((RefreshLoadMoreLayout.c)localObject).iLW = bool;
        ((RefreshLoadMoreLayout.c)localObject).Lri = paramIResponse.getHasMore();
        ((RefreshLoadMoreLayout.c)localObject).scd = paramIResponse;
        if (!paramIResponse.getHasMore()) {
          break label124;
        }
      }
      for (;;)
      {
        com.tencent.mm.ad.c.g((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(202496);
        return;
        bool = true;
        break;
        label124:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      int j = 3;
      AppMethodBeat.i(202495);
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
        final com.tencent.mm.plugin.finder.feed.model.internal.l locall = new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), false, 12);
        localc.scd = paramIResponse;
        com.tencent.mm.ad.c.g((a)new b(this, locall, localc, paramb, paramIResponse));
        AppMethodBeat.o(202495);
        return;
        i = 4;
        break;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements a<z>
    {
      a(FinderTopicFeedLoader.f paramf, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements a<z>
    {
      b(FinderTopicFeedLoader.f paramf, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
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