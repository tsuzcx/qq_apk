package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.cm;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "curRequest", "Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordRequest;", "getCurRequest", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordRequest;", "setCurRequest", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordRequest;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordDataFetcher;", "extraUITask", "Lkotlin/Function0;", "", "getExtraUITask", "()Lkotlin/jvm/functions/Function0;", "setExtraUITask", "(Lkotlin/jvm/functions/Function0;)V", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "lattBufferOfTag", "Lcom/tencent/mm/protobuf/ByteString;", "getLattBufferOfTag", "()Lcom/tencent/mm/protobuf/ByteString;", "setLattBufferOfTag", "(Lcom/tencent/mm/protobuf/ByteString;)V", "passByInfo", "", "getPassByInfo", "()Ljava/lang/String;", "setPassByInfo", "(Ljava/lang/String;)V", "sceneType", "getSceneType", "()I", "setSceneType", "(I)V", "getType", "userName", "getUserName", "setUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastBuff", "tag", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onSaveLastBuffer", "requestLoadMore", "isAuto", "requestRefresh", "pullType", "saveLastBuff", "buff", "HotWordDataFetcher", "HotWordLoadMoreRequest", "HotWordRefreshRequest", "HotWordRequest", "HotWordResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderHotWordFeedLoader
  extends BaseFinderFeedLoader
{
  public volatile d BgA;
  private a BgB;
  public String BgC;
  private a<ah> BgD;
  boolean isLoadingMore;
  public int sceneType;
  private final int type;
  private String userName;
  
  public FinderHotWordFeedLoader(int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366388);
    this.type = paramInt;
    this.BgB = new a();
    this.userName = "";
    this.sceneType = -1;
    AppMethodBeat.o(366388);
  }
  
  public i<cc> createDataFetch()
  {
    return (i)this.BgB;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366419);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new f(this);
    AppMethodBeat.o(366419);
    return locald;
  }
  
  public void onFetchDone(IResponse<cc> paramIResponse)
  {
    Object localObject2 = null;
    AppMethodBeat.i(366412);
    kotlin.g.b.s.u(paramIResponse, "response");
    String str = getTAG();
    Object localObject1 = paramIResponse.getIncrementList();
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, "onFetchDone %d feeds", new Object[] { localObject1 });
      if ((paramIResponse instanceof e))
      {
        str = getTAG();
        StringBuilder localStringBuilder = new StringBuilder("incrementCount ");
        localObject1 = paramIResponse.getIncrementList();
        if (localObject1 != null) {
          break label223;
        }
        localObject1 = null;
        label80:
        localStringBuilder = localStringBuilder.append(localObject1).append("lastBuffer ");
        if (getLastBuffer() != null) {
          break label236;
        }
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(", resp buffer ");
        if (paramIResponse.getLastBuffer() != null) {
          break label263;
        }
        localObject1 = "null";
        Log.i(str, localObject1);
        if (!(this.BgA instanceof c)) {
          break label290;
        }
        setLastBuffer(paramIResponse.getLastBuffer());
        label158:
        if (!(this.BgA instanceof c)) {
          break label311;
        }
        paramIResponse.setPullType(1);
      }
    }
    for (;;)
    {
      if ((this.BgA instanceof c))
      {
        localObject1 = this.BgD;
        if (localObject1 != null) {
          ((a)localObject1).invoke();
        }
      }
      super.onFetchDone(paramIResponse);
      AppMethodBeat.o(366412);
      return;
      localObject1 = Integer.valueOf(((List)localObject1).size());
      break;
      label223:
      localObject1 = Integer.valueOf(((List)localObject1).size());
      break label80;
      label236:
      localObject1 = getLastBuffer();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).Op)
      {
        localObject1 = MD5Util.getMD5String((byte[])localObject1);
        break;
      }
      label263:
      localObject1 = paramIResponse.getLastBuffer();
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.bx.b)localObject1).Op)
      {
        localObject1 = MD5Util.getMD5String((byte[])localObject1);
        break;
      }
      label290:
      if (!(this.BgA instanceof b)) {
        break label158;
      }
      setLastBuffer(paramIResponse.getLastBuffer());
      break label158;
      label311:
      paramIResponse.setPullType(2);
      this.isLoadingMore = false;
    }
  }
  
  public void onSaveLastBuffer(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366401);
    kotlin.g.b.s.u(paramIResponse, "response");
    AppMethodBeat.o(366401);
  }
  
  public void requestLoadMore(boolean paramBoolean)
  {
    AppMethodBeat.i(366394);
    if (this.isLoadingMore)
    {
      Log.i(getTAG(), "already load more,return");
      AppMethodBeat.o(366394);
      return;
    }
    this.isLoadingMore = true;
    com.tencent.mm.bx.b localb = getLastBuffer();
    Log.i(getTAG(), "requestLoadMore tag");
    Object localObject = (CharSequence)this.BgC;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label170;
      }
      localObject = this.BgC;
      if (localObject != null) {
        break label152;
      }
      localObject = null;
    }
    label89:
    for (localObject = new com.tencent.mm.bx.b((byte[])localObject);; localObject = null)
    {
      localObject = new b(this.sceneType, (com.tencent.mm.bx.b)localObject, localb, getContextObj());
      ((b)localObject).edT();
      BaseFeedLoader.request$default((BaseFeedLoader)this, localObject, null, 2, null);
      this.BgA = ((d)localObject);
      AppMethodBeat.o(366394);
      return;
      i = 0;
      break;
      localObject = ((String)localObject).getBytes(kotlin.n.d.UTF_8);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      break label89;
    }
  }
  
  public void requestRefresh() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "sceneSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lkotlin/collections/HashSet;", "getSceneSet", "()Ljava/util/HashSet;", "setSceneSet", "(Ljava/util/HashSet;)V", "alive", "", "dead", "fetch", "request", "", "callback", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchRefresh", "handleScene", "errType", "", "errCode", "errMsg", "", "scene", "onSceneEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends i<cc>
    implements com.tencent.mm.am.h
  {
    private com.tencent.mm.plugin.finder.feed.model.internal.h<cc> BgE;
    private HashSet<com.tencent.mm.am.p> BgF;
    
    public a()
    {
      AppMethodBeat.i(366006);
      this.BgF = new HashSet();
      AppMethodBeat.o(366006);
    }
    
    private final void f(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366021);
      if ((paramp instanceof cm))
      {
        bool = this.BgF.remove(paramp);
        Log.i(getTAG(), kotlin.g.b.s.X("isRemoved :", Boolean.valueOf(bool)));
        if (!bool)
        {
          AppMethodBeat.o(366021);
          return;
        }
        paramString = new FinderHotWordFeedLoader.e(paramInt1, paramInt2, paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Object localObject1 = c.c.b(((cm)paramp).rr.otC);
          if (localObject1 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderHotWordStreamResp");
            AppMethodBeat.o(366021);
            throw paramString;
          }
          paramString.setLastBuffer(((bbt)localObject1).ZEQ);
          Object localObject2 = (Iterable)((cm)paramp).dVW();
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.e((FinderObject)localObject3, 69632);
            localObject4 = FinderTopicFeedUI.Bst;
            ((Map)FinderTopicFeedUI.eeA()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            ((Collection)localObject1).add(d.a.a((FinderItem)localObject3));
          }
          paramString.setIncrementList((List)localObject1);
          paramp = c.c.b(((cm)paramp).rr.otC);
          if (paramp == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderHotWordStreamResp");
            AppMethodBeat.o(366021);
            throw paramString;
          }
          if (((bbt)paramp).BeA == 0) {
            break label351;
          }
        }
      }
      label351:
      for (boolean bool = true;; bool = false)
      {
        paramString.setHasMore(bool);
        Log.i(getTAG(), "onSceneEnd");
        paramp = this.BgE;
        if (paramp != null) {
          paramp.onFetchDone((IResponse)paramString);
        }
        AppMethodBeat.o(366021);
        return;
      }
    }
    
    public final void alive()
    {
      AppMethodBeat.i(366053);
      super.alive();
      this.BgG.isLoadingMore = false;
      com.tencent.mm.kernel.h.aZW().a(4007, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(366053);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(366059);
      super.dead();
      com.tencent.mm.kernel.h.aZW().b(4007, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(366059);
    }
    
    public final void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366046);
      kotlin.g.b.s.u(paramh, "callback");
      if ((paramObject instanceof FinderHotWordFeedLoader.d))
      {
        this.BgE = paramh;
        ((FinderHotWordFeedLoader.d)paramObject).call();
        this.BgF.add(((FinderHotWordFeedLoader.d)paramObject).BgH);
      }
      AppMethodBeat.o(366046);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366040);
      kotlin.g.b.s.u(paramh, "callback");
      paramh.onFetchDone((IResponse)new e());
      AppMethodBeat.o(366040);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366035);
      kotlin.g.b.s.u(paramh, "callback");
      AppMethodBeat.o(366035);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366028);
      kotlin.g.b.s.u(paramh, "callback");
      AppMethodBeat.o(366028);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366066);
      Log.i(getTAG(), "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if (paramp != null) {
        f(paramInt1, paramInt2, paramString, paramp);
      }
      AppMethodBeat.o(366066);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordLoadMoreRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordRequest;", "sceneType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "byPassInfo", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getByPassInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLastBuffer", "getSceneType", "()I", "call", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends FinderHotWordFeedLoader.d
  {
    private final com.tencent.mm.bx.b AEB;
    private final bui Auc;
    private final com.tencent.mm.bx.b lastBuffer;
    private final int sceneType;
    
    public b(int paramInt, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, bui parambui)
    {
      AppMethodBeat.i(366002);
      this.sceneType = paramInt;
      this.lastBuffer = paramb1;
      this.AEB = paramb2;
      this.Auc = parambui;
      setTAG("Finder.FinderTopicFeedLoader.HotWordLoadMoreRequest");
      AppMethodBeat.o(366002);
    }
    
    public final void call()
    {
      AppMethodBeat.i(366020);
      this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new cm(this.lastBuffer, this.sceneType, this.AEB, this.Auc));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BgH, 0);
      AppMethodBeat.o(366020);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(366011);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", sceneType:").append(this.sceneType).append(", lastBuffer:");
      if (this.lastBuffer == null)
      {
        str = "null";
        localStringBuilder = localStringBuilder.append(str).append(", byPassInfo:");
        if (this.AEB != null) {
          break label100;
        }
      }
      label100:
      for (String str = "null";; str = MD5Util.getMD5String(this.AEB.Op))
      {
        str = str;
        AppMethodBeat.o(366011);
        return str;
        str = MD5Util.getMD5String(this.lastBuffer.Op);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordRefreshRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordRequest;", "sceneType", "", "byPassInfo", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getByPassInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getSceneType", "()I", "call", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends FinderHotWordFeedLoader.d
  {
    private final com.tencent.mm.bx.b AEB;
    private final bui Auc;
    private final int sceneType;
    
    public c(int paramInt, com.tencent.mm.bx.b paramb, bui parambui)
    {
      AppMethodBeat.i(366007);
      this.sceneType = paramInt;
      this.AEB = paramb;
      this.Auc = parambui;
      setTAG("Finder.FinderTopicFeedLoader.HotWordRefreshRequest");
      AppMethodBeat.o(366007);
    }
    
    public final void call()
    {
      AppMethodBeat.i(366024);
      this.BgH = ((com.tencent.mm.plugin.findersdk.b.h)new cm(null, this.sceneType, this.AEB, this.Auc));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BgH, 0);
      AppMethodBeat.o(366024);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(366013);
      StringBuilder localStringBuilder = new StringBuilder("hashCode: ").append(hashCode()).append(", sceneType:").append(this.sceneType).append(", byPassInfo:");
      if (this.AEB == null) {}
      for (String str = "null";; str = MD5Util.getMD5String(this.AEB.Op))
      {
        str = str;
        AppMethodBeat.o(366013);
        return str;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordRequest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "scene", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "getScene", "()Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "setScene", "(Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;)V", "call", "", "printRequest", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class d
  {
    com.tencent.mm.plugin.findersdk.b.h BgH;
    private String TAG = "Finder.FinderTopicFeedLoader.HotWordRequest";
    
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$HotWordResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends IResponse<cc>
  {
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeLoadMore", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends BaseFeedLoader<cc>.a
  {
    f(FinderHotWordFeedLoader paramFinderHotWordFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(365903);
      AppMethodBeat.o(365903);
    }
    
    public final void mergeLoadMore(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int i = 1;
      AppMethodBeat.i(365917);
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
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.BgG, paramb, paramIResponse));
        AppMethodBeat.o(365917);
        return;
        bool = localList.isEmpty();
        break;
        label128:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int j = 1;
      AppMethodBeat.i(365910);
      kotlin.g.b.s.u(paramIResponse, "response");
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
          break label258;
        }
        bool = true;
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        locald.extraData = paramIResponse;
        if (((locald.actionType == 0) || (locald.actionType == 4)) && (locald.agJv > 0)) {
          locald.agJt = null;
        }
        Log.i(this.BgG.getTAG(), kotlin.g.b.s.X("[onFetchRefreshDone]  reason=", locald));
        localList = paramIResponse.getIncrementList();
        if (localList != null) {
          break label264;
        }
        i = 0;
        label160:
        if (!paramIResponse.getHasMore()) {
          break label275;
        }
        if (i > this.BgG.getDataList().size()) {
          break label362;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new b(this, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.BgG, paramb, paramIResponse));
        AppMethodBeat.o(365910);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
        locald.agJs = -1;
        break;
        label258:
        bool = false;
        break label77;
        label264:
        i = localList.size();
        break label160;
        label275:
        if ((this.BgG.getDataList().size() == 0) || (i == 0) || (this.BgG.getDataList().size() <= i))
        {
          localList = paramIResponse.getIncrementList();
          if ((localList != null) && (localList.containsAll((Collection)kotlin.a.p.p((Iterable)this.BgG.getDataList())) == true)) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label362;
            }
            i = 6;
            break;
          }
        }
        label362:
        i = 4;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderHotWordFeedLoader.f paramf, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderHotWordFeedLoader paramFinderHotWordFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(FinderHotWordFeedLoader.f paramf, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderHotWordFeedLoader paramFinderHotWordFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader
 * JD-Core Version:    0.7.0.1
 */