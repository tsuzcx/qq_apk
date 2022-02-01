package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import d.a.j;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "type", "", "topic", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetch;", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "lattBufferOfTag", "getLattBufferOfTag", "setLattBufferOfTag", "loadCallback", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "getLoadCallback", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "setLoadCallback", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;)V", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPoiLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "refObjectId", "", "getRefObjectId", "()Ljava/lang/Long;", "setRefObjectId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTopic", "getType", "()I", "getLastBuff", "tag", "onAlive", "", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLoadMore", "tabType", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "requestRefresh", "pullType", "saveLastBuff", "buff", "FeedLoadCallback", "TopicDataFetch", "TopicLoadMoreRequest", "TopicRefreshRequest", "TopicRequest", "TopicResponse", "plugin-finder_release"})
public final class n
  implements com.tencent.mm.ak.g, d<BaseFinderFeed>
{
  final String TAG;
  final anm contextObj;
  final String dol;
  boolean isLoadingMore;
  private com.tencent.mm.bw.b lastBuffer;
  public anu qYj;
  public Long rmi;
  e rnl;
  private com.tencent.mm.bw.b rnm;
  b rnn;
  public a rno;
  public alt rnp;
  final int type;
  
  public n(int paramInt, String paramString, anm paramanm)
  {
    AppMethodBeat.i(202229);
    this.type = paramInt;
    this.dol = paramString;
    this.contextObj = paramanm;
    this.TAG = "Finder.FinderTopicFeedLoader";
    this.rnn = new b(this.contextObj);
    AppMethodBeat.o(202229);
  }
  
  private void a(String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(202224);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.lastBuffer = paramb;
      AppMethodBeat.o(202224);
      return;
    }
    this.rnm = paramb;
    AppMethodBeat.o(202224);
  }
  
  public final void a(final int paramInt, final cnx paramcnx)
  {
    AppMethodBeat.i(202226);
    c.g((a)new g(this, paramcnx, paramInt));
    AppMethodBeat.o(202226);
  }
  
  public final void a(final int paramInt1, final cnx paramcnx, final int paramInt2)
  {
    AppMethodBeat.i(202225);
    c.g((a)new h(this, paramcnx, paramInt1, paramInt2));
    AppMethodBeat.o(202225);
  }
  
  public final com.tencent.mm.bw.b adC(String paramString)
  {
    AppMethodBeat.i(202223);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = this.lastBuffer;
      AppMethodBeat.o(202223);
      return paramString;
    }
    paramString = this.rnm;
    AppMethodBeat.o(202223);
    return paramString;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(202227);
    this.isLoadingMore = false;
    com.tencent.mm.kernel.g.agi().a(817, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(202227);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(202228);
    com.tencent.mm.kernel.g.agi().b(817, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(202228);
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
      ac.i(str, "onFetchDone %d feeds", new Object[] { localObject });
      localObject = this.rno;
      if (localObject == null) {
        break;
      }
      ((a)localObject).a((f)paramIResponse);
      AppMethodBeat.o(166066);
      return;
    }
    AppMethodBeat.o(166066);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    Object localObject1 = null;
    AppMethodBeat.i(166067);
    ac.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    f localf;
    if (paramn != null)
    {
      if (!(paramn instanceof ak))
      {
        AppMethodBeat.o(166067);
        return;
      }
      localf = new f(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localf.setLastBuffer(((ak)paramn).csy());
        if (this.lastBuffer == null)
        {
          localf.rfD = ((ak)paramn).csF();
          paramString = y.KTp;
        }
        Object localObject2 = (Iterable)((ak)paramn).csE();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.rDA;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 64);
          localObject4 = FinderTopicFeedUI.rsI;
          ((Map)FinderTopicFeedUI.cvK()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
          paramString.add(b.a.i((FinderItem)localObject3));
        }
        localf.setIncrementList((List)paramString);
        boolean bool;
        if (((ak)paramn).csz() != 0)
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
          localObject3 = ((StringBuilder)localObject3).append(paramString).append(", totalCount ").append(localf.rfD).append(", lastBuffer ");
          if (this.lastBuffer != null) {
            break label449;
          }
          paramString = "null";
          localObject3 = ((StringBuilder)localObject3).append(paramString).append(", resp buffer ");
          if (localf.getLastBuffer() != null) {
            break label476;
          }
          paramString = "null";
          ac.i((String)localObject2, paramString);
          if (!(this.rnl instanceof d)) {
            break label593;
          }
          paramString = this.rnl;
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
          paramString = ah.B(paramString);
          break;
        }
        label476:
        paramString = localf.getLastBuffer();
        if (paramString != null) {}
        for (paramString = paramString.getBytes();; paramString = null)
        {
          paramString = ah.B(paramString);
          break;
        }
        label504:
        paramString = ((d)paramString).rmh;
        if (paramString != null)
        {
          paramString = paramString.FBb;
          if (paramString != null)
          {
            paramString = (aop)paramString.get(0);
            if (paramString != null)
            {
              paramString = paramString.dol;
              a(paramString, localf.getLastBuffer());
            }
          }
        }
        label593:
        while (!(this.rnl instanceof c)) {
          for (;;)
          {
            paramString = ((ak)paramn).rr.aBD();
            if (paramString != null) {
              break;
            }
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(166067);
            throw paramString;
            paramString = null;
          }
        }
        paramString = this.rnl;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
          AppMethodBeat.o(166067);
          throw paramString;
        }
        paramString = ((c)paramString).rmh;
        if (paramString != null)
        {
          paramString = paramString.FBb;
          if (paramString != null)
          {
            paramString = (aop)paramString.get(0);
            if (paramString == null) {}
          }
        }
        for (paramString = paramString.dol;; paramString = null)
        {
          a(paramString, localf.getLastBuffer());
          break;
        }
        localf.rnr = ((alj)paramString).rmj;
        paramString = ((ak)paramn).rr.aBD();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
          AppMethodBeat.o(166067);
          throw paramString;
        }
        localObject2 = ((alj)paramString).EFe;
        paramString = localObject1;
        if (localObject2 != null) {
          paramString = ((cfx)localObject2).Fug;
        }
        localf.mBH = paramString;
        ac.d(this.TAG, "onSceneEnd (" + ((ak)paramn).qYn + ')');
        localf.tag = ((ak)paramn).qYn;
      }
      if (!(this.rnl instanceof d)) {
        break label927;
      }
      paramString = this.rnl;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
        AppMethodBeat.o(166067);
        throw paramString;
      }
      if (((d)paramString).pullType == -1) {
        break label918;
      }
      paramString = this.rnl;
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "", "onLoadEnd", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(n.f paramf);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "call", "", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "callInitData", "", "init", "plugin-finder_release"})
  public static final class b
    extends e<Object, n.e, BaseFinderFeed>
  {
    public b(anm paramanm)
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "()I", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class c
    extends n.e
  {
    private final anm contextObj;
    private final int diw;
    private final String dol;
    private final com.tencent.mm.bw.b lastBuffer;
    private final alt location;
    private final anu qYj;
    final cnx rmh;
    private final Long rmi;
    private final int type;
    
    public c(int paramInt1, String paramString, alt paramalt, Long paramLong, com.tencent.mm.bw.b paramb, anu paramanu, int paramInt2, cnx paramcnx, anm paramanm)
    {
      AppMethodBeat.i(202220);
      this.type = paramInt1;
      this.dol = paramString;
      this.location = paramalt;
      this.rmi = paramLong;
      this.lastBuffer = paramb;
      this.qYj = paramanu;
      this.diw = paramInt2;
      this.rmh = paramcnx;
      this.contextObj = paramanm;
      setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
      AppMethodBeat.o(202220);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166059);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.rnq != null) {
          com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)this.rnq);
        }
        AppMethodBeat.o(166059);
        return;
        this.rnq = new ak(this.dol, this.rmi, this.lastBuffer, this.qYj, this.contextObj);
        continue;
        alt localalt = this.location;
        if (localalt != null)
        {
          String str = localalt.EFm;
          k.g(str, "it.poiClassifyId");
          this.rnq = new ak(str, localalt.doB, localalt.dmL, this.rmi, this.lastBuffer, this.diw, this.rmh, this.qYj, this.contextObj);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166058);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", type:").append(this.type).append(", topic:").append(this.dol).append(", lastBuffer:");
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
        localObject = ah.B((byte[])localObject);
        break;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "type", "", "topic", "", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getPullType", "()I", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTopic", "()Ljava/lang/String;", "getType", "call", "", "toString", "plugin-finder_release"})
  public static final class d
    extends n.e
  {
    private final anm contextObj;
    private final int diw;
    private final String dol;
    private final alt location;
    final int pullType;
    private anu qYj;
    final cnx rmh;
    private final Long rmi;
    private final int type;
    
    public d(int paramInt1, String paramString, alt paramalt, Long paramLong, anu paramanu, int paramInt2, cnx paramcnx, int paramInt3, anm paramanm)
    {
      AppMethodBeat.i(202221);
      this.type = paramInt1;
      this.dol = paramString;
      this.location = paramalt;
      this.rmi = paramLong;
      this.qYj = paramanu;
      this.diw = paramInt2;
      this.rmh = paramcnx;
      this.pullType = paramInt3;
      this.contextObj = paramanm;
      setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
      AppMethodBeat.o(202221);
    }
    
    public final void call()
    {
      AppMethodBeat.i(166062);
      switch (this.type)
      {
      }
      for (;;)
      {
        if (this.rnq != null) {
          com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)this.rnq);
        }
        AppMethodBeat.o(166062);
        return;
        this.rnq = new ak(this.dol, this.rmi, null, this.qYj, this.contextObj);
        continue;
        alt localalt = this.location;
        if (localalt != null)
        {
          String str = localalt.EFm;
          k.g(str, "it.poiClassifyId");
          this.rnq = new ak(str, localalt.doB, localalt.dmL, this.rmi, null, this.diw, this.rmh, this.qYj, this.contextObj);
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166061);
      String str = "hashCode: " + hashCode() + ", type:" + this.type + ", topic:" + this.dol;
      AppMethodBeat.o(166061);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "getScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "setScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;)V", "call", "", "printRequest", "toString", "plugin-finder_release"})
  public static abstract class e
    implements i
  {
    private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
    ak rnq;
    
    public abstract void call();
    
    public final void cvF()
    {
      ac.i(this.TAG, toString());
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagsData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagsData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "plugin-finder_release"})
  public static final class f
    extends IResponse<BaseFinderFeed>
  {
    public String mBH;
    public long rfD;
    public cnx rnr;
    public String tag;
    
    public f(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      AppMethodBeat.i(202222);
      this.rnr = new cnx();
      AppMethodBeat.o(202222);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    g(n paramn, cnx paramcnx, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<y>
  {
    h(n paramn, cnx paramcnx, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.n
 * JD-Core Version:    0.7.0.1
 */