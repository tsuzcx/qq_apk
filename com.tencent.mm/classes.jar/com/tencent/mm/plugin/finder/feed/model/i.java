package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.a.a;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "type", "", "topic", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetch;", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "lattBufferOfTag", "getLattBufferOfTag", "setLattBufferOfTag", "loadCallback", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "getLoadCallback", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "setLoadCallback", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;)V", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPoiLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "refObjectId", "", "getRefObjectId", "()Ljava/lang/Long;", "setRefObjectId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTopic", "getType", "()I", "getLastBuff", "tag", "onAlive", "", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLoadMore", "tabType", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "requestRefresh", "pullType", "saveLastBuff", "buff", "FeedLoadCallback", "TopicDataFetch", "TopicLoadMoreRequest", "TopicRefreshRequest", "TopicRequest", "TopicResponse", "plugin-finder_release"})
public final class i
  implements com.tencent.mm.al.g, e<BaseFinderFeed>
{
  public dzq KJJ;
  private com.tencent.mm.bx.b KQq;
  final String TAG;
  final dzp contextObj;
  final String dqA;
  boolean isLoadingMore;
  private com.tencent.mm.bx.b lastBuffer;
  public Long qxU;
  e qyH;
  b qyI;
  public a qyJ;
  public ajq qyK;
  final int type;
  
  public i(int paramInt, String paramString, dzp paramdzp)
  {
    AppMethodBeat.i(198318);
    this.type = paramInt;
    this.dqA = paramString;
    this.contextObj = paramdzp;
    this.TAG = "Finder.FinderTopicFeedLoader";
    this.qyI = new b(this.contextObj);
    AppMethodBeat.o(198318);
  }
  
  private void b(String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(198313);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.lastBuffer = paramb;
      AppMethodBeat.o(198313);
      return;
    }
    this.KQq = paramb;
    AppMethodBeat.o(198313);
  }
  
  public final void a(final int paramInt, final ebq paramebq)
  {
    AppMethodBeat.i(198315);
    c.g((a)new g(this, paramebq, paramInt));
    AppMethodBeat.o(198315);
  }
  
  public final void a(final int paramInt1, final ebq paramebq, final int paramInt2)
  {
    AppMethodBeat.i(198314);
    c.g((a)new h(this, paramebq, paramInt1, paramInt2));
    AppMethodBeat.o(198314);
  }
  
  public final com.tencent.mm.bx.b aVl(String paramString)
  {
    AppMethodBeat.i(198312);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = this.lastBuffer;
      AppMethodBeat.o(198312);
      return paramString;
    }
    paramString = this.KQq;
    AppMethodBeat.o(198312);
    return paramString;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(198316);
    com.tencent.mm.kernel.g.aeS().a(817, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(198316);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(198317);
    com.tencent.mm.kernel.g.aeS().b(817, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(198317);
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(166066);
    k.h(paramIResponse, "response");
    String str = this.TAG;
    Object localObject = paramIResponse.getIncrementList();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
    {
      ad.i(str, "onFetchDone %d feeds", new Object[] { localObject });
      localObject = this.qyJ;
      if (localObject == null) {
        break;
      }
      ((a)localObject).a((f)paramIResponse);
      AppMethodBeat.o(166066);
      return;
    }
    AppMethodBeat.o(166066);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject1 = null;
    AppMethodBeat.i(166067);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    f localf;
    if (paramn != null)
    {
      if (!(paramn instanceof t))
      {
        AppMethodBeat.o(166067);
        return;
      }
      localf = new f(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localf.setLastBuffer(((t)paramn).ckN());
        if (this.lastBuffer == null)
        {
          localf.qxB = ((t)paramn).ckM();
          paramString = y.JfV;
        }
        Object localObject2 = (Iterable)((t)paramn).fSe();
        paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.qJU;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 64);
          localObject4 = FinderTopicFeedUI.qBH;
          ((Map)FinderTopicFeedUI.cmQ()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
          paramString.add(b.a.h((FinderItem)localObject3));
        }
        localf.setIncrementList((List)paramString);
        boolean bool;
        if (((t)paramn).ckO() != 0)
        {
          bool = true;
          localf.setHasMore(bool);
          localObject2 = this.TAG;
          localObject3 = new StringBuilder("incrementCount ");
          paramString = localf.getIncrementList();
          if (paramString == null) {
            break label444;
          }
        }
        label444:
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          localObject3 = ((StringBuilder)localObject3).append(paramString).append(", totalCount ").append(localf.qxB).append(", lastBuffer ");
          if (this.lastBuffer != null) {
            break label449;
          }
          paramString = "null";
          localObject3 = ((StringBuilder)localObject3).append(paramString).append(", resp buffer ");
          if (localf.getLastBuffer() != null) {
            break label476;
          }
          paramString = "null";
          ad.i((String)localObject2, paramString);
          if (!(this.qyH instanceof d)) {
            break label593;
          }
          paramString = this.qyH;
          if (paramString != null) {
            break label504;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
          AppMethodBeat.o(166067);
          throw paramString;
          bool = false;
          break;
        }
        label449:
        paramString = this.lastBuffer;
        if (paramString != null) {}
        for (paramString = paramString.getBytes();; paramString = null)
        {
          paramString = ai.D(paramString);
          break;
        }
        label476:
        paramString = localf.getLastBuffer();
        if (paramString != null) {}
        for (paramString = paramString.getBytes();; paramString = null)
        {
          paramString = ai.D(paramString);
          break;
        }
        label504:
        paramString = ((d)paramString).KPD;
        if (paramString != null)
        {
          paramString = paramString.LAk;
          if (paramString != null)
          {
            paramString = (dzw)paramString.get(0);
            if (paramString != null)
            {
              paramString = paramString.dqA;
              b(paramString, localf.getLastBuffer());
            }
          }
        }
        label593:
        while (!(this.qyH instanceof c)) {
          for (;;)
          {
            paramString = ((t)paramn).rr.auM();
            if (paramString != null) {
              break;
            }
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(166067);
            throw paramString;
            paramString = null;
          }
        }
        paramString = this.qyH;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
          AppMethodBeat.o(166067);
          throw paramString;
        }
        paramString = ((c)paramString).KPD;
        if (paramString != null)
        {
          paramString = paramString.LAk;
          if (paramString != null)
          {
            paramString = (dzw)paramString.get(0);
            if (paramString == null) {}
          }
        }
        for (paramString = paramString.dqA;; paramString = null)
        {
          b(paramString, localf.getLastBuffer());
          break;
        }
        localf.KQr = ((aji)paramString).KPE;
        paramString = ((t)paramn).rr.auM();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
          AppMethodBeat.o(166067);
          throw paramString;
        }
        localObject2 = ((aji)paramString).LxD;
        paramString = localObject1;
        if (localObject2 != null) {
          paramString = ((ebk)localObject2).LAj;
        }
        localf.lZG = paramString;
        ad.d(this.TAG, "onSceneEnd (" + ((t)paramn).KJN + ')');
        localf.tag = ((t)paramn).KJN;
      }
      if (!(this.qyH instanceof d)) {
        break label927;
      }
      paramString = this.qyH;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
        AppMethodBeat.o(166067);
        throw paramString;
      }
      if (((d)paramString).pullType == -1) {
        break label918;
      }
      paramString = this.qyH;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
        AppMethodBeat.o(166067);
        throw paramString;
      }
      localf.setPullType(((d)paramString).pullType);
    }
    for (;;)
    {
      onFetchDone((IResponse)localf);
      AppMethodBeat.o(166067);
      return;
      label918:
      localf.setPullType(1);
      continue;
      label927:
      localf.setPullType(2);
      this.isLoadingMore = false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "", "onLoadEnd", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(i.f paramf);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "call", "", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "callInitData", "", "init", "plugin-finder_release"})
  public static final class b
    extends f<Object, i.e, BaseFinderFeed>
  {
    public b(dzp paramdzp)
    {
      super();
    }
    
    public final List<BaseFinderFeed> cX(Object paramObject)
    {
      AppMethodBeat.i(166056);
      k.h(paramObject, "init");
      paramObject = Collections.emptyList();
      k.g(paramObject, "Collections.emptyList()");
      AppMethodBeat.o(166056);
      return paramObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "()I", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class c
    extends i.e
  {
    private final int IoU;
    private final dzq KJJ;
    final ebq KPD;
    private final dzp contextObj;
    private final String dqA;
    private final com.tencent.mm.bx.b lastBuffer;
    private final ajq location;
    private final Long qxU;
    private final int type;
    
    public c(int paramInt1, String paramString, ajq paramajq, Long paramLong, com.tencent.mm.bx.b paramb, dzq paramdzq, int paramInt2, ebq paramebq, dzp paramdzp)
    {
      AppMethodBeat.i(198309);
      this.type = paramInt1;
      this.dqA = paramString;
      this.location = paramajq;
      this.qxU = paramLong;
      this.lastBuffer = paramb;
      this.KJJ = paramdzq;
      this.IoU = paramInt2;
      this.KPD = paramebq;
      this.contextObj = paramdzp;
      setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
      AppMethodBeat.o(198309);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166059);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.qyL != null) {
          com.tencent.mm.kernel.g.aeS().b((n)this.qyL);
        }
        AppMethodBeat.o(166059);
        return;
        this.qyL = new t(this.dqA, this.qxU, this.lastBuffer, this.KJJ, this.contextObj);
        continue;
        ajq localajq = this.location;
        if (localajq != null)
        {
          String str = localajq.DlE;
          k.g(str, "it.poiClassifyId");
          this.qyL = new t(str, localajq.dqQ, localajq.dpb, this.qxU, this.lastBuffer, this.IoU, this.KPD, this.KJJ, this.contextObj);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166058);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", type:").append(this.type).append(", topic:").append(this.dqA).append(", lastBuffer:");
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
        localObject = ai.D((byte[])localObject);
        break;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "()I", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class d
    extends i.e
  {
    private final int IoU;
    private dzq KJJ;
    final ebq KPD;
    private final dzp contextObj;
    private final String dqA;
    private final ajq location;
    final int pullType;
    private final Long qxU;
    private final int type;
    
    public d(int paramInt1, String paramString, ajq paramajq, Long paramLong, dzq paramdzq, int paramInt2, ebq paramebq, int paramInt3, dzp paramdzp)
    {
      AppMethodBeat.i(198310);
      this.type = paramInt1;
      this.dqA = paramString;
      this.location = paramajq;
      this.qxU = paramLong;
      this.KJJ = paramdzq;
      this.IoU = paramInt2;
      this.KPD = paramebq;
      this.pullType = paramInt3;
      this.contextObj = paramdzp;
      setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(198310);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166062);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.qyL != null) {
          com.tencent.mm.kernel.g.aeS().b((n)this.qyL);
        }
        AppMethodBeat.o(166062);
        return;
        this.qyL = new t(this.dqA, this.qxU, null, this.KJJ, this.contextObj);
        continue;
        ajq localajq = this.location;
        if (localajq != null)
        {
          String str = localajq.DlE;
          k.g(str, "it.poiClassifyId");
          this.qyL = new t(str, localajq.dqQ, localajq.dpb, this.qxU, null, this.IoU, this.KPD, this.KJJ, this.contextObj);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166061);
      String str = "hashCode: " + hashCode() + ", type:" + this.type + ", topic:" + this.dqA;
      AppMethodBeat.o(166061);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "getScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "setScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;)V", "call", "", "printRequest", "toString", "plugin-finder_release"})
  public static abstract class e
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
    t qyL;
    
    public abstract void call();
    
    public final void cmz()
    {
      ad.i(this.TAG, toString());
    }
    
    public final void setTAG(String paramString)
    {
      k.h(paramString, "<set-?>");
      this.TAG = paramString;
    }
    
    public String toString()
    {
      return "";
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagsData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagsData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "plugin-finder_release"})
  public static final class f
    extends IResponse<BaseFinderFeed>
  {
    public ebq KQr;
    public String lZG;
    public long qxB;
    public String tag;
    
    public f(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(198311);
      this.KQr = new ebq();
      AppMethodBeat.o(198311);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    g(i parami, ebq paramebq, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<y>
  {
    h(i parami, ebq paramebq, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.i
 * JD-Core Version:    0.7.0.1
 */