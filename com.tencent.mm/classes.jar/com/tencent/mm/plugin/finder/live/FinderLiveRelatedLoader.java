package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "()V", "dataFetch", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$NearbyLiveRelatedDataFetcher;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "isFirstFetchLiveLbsResponse", "", "()Z", "setFirstFetchLiveLbsResponse", "(Z)V", "loaderParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "getLoaderParams", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "setLoaderParams", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;)V", "state", "", "getState", "()I", "setState", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "getDataFetcher", "onFetchDone", "response", "setLoaderParam", "params", "BaseDataFetcher", "FinderLiveRelResponse", "NearbyLiveRelatedDataFetcher", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveRelatedLoader
  extends BaseFeedLoader<f>
{
  boolean BwA;
  j Bwy;
  final c Bwz;
  kotlin.g.a.b<? super IResponse<f>, ah> fetchEndCallback;
  int state;
  
  public FinderLiveRelatedLoader()
  {
    super(null, 1, null);
    AppMethodBeat.i(350703);
    this.Bwy = new j();
    this.Bwz = new c();
    this.BwA = true;
    AppMethodBeat.o(350703);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(350708);
    kotlin.g.b.s.u(paramj, "params");
    this.Bwy = paramj;
    AppMethodBeat.o(350708);
  }
  
  public final i<f> createDataFetch()
  {
    return (i)this.Bwz;
  }
  
  public final void onFetchDone(IResponse<f> paramIResponse)
  {
    AppMethodBeat.i(350718);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramIResponse);
    a.c("com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    kotlin.g.b.s.u(paramIResponse, "response");
    localObject = this.fetchEndCallback;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
    }
    a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(350718);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "onSceneEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class a
    extends i<f>
    implements com.tencent.mm.am.h
  {
    private final Map<com.tencent.mm.am.p, com.tencent.mm.plugin.finder.feed.model.internal.h<f>> map;
    
    public a()
    {
      AppMethodBeat.i(350661);
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(350661);
    }
    
    public void alive()
    {
      AppMethodBeat.i(350688);
      super.alive();
      com.tencent.mm.kernel.h.aZW().a(getCmdId(), (com.tencent.mm.am.h)this);
      AppMethodBeat.o(350688);
    }
    
    public void dead()
    {
      AppMethodBeat.i(350694);
      super.dead();
      com.tencent.mm.kernel.h.aZW().b(getCmdId(), (com.tencent.mm.am.h)this);
      AppMethodBeat.o(350694);
    }
    
    public void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(350684);
      kotlin.g.b.s.u(paramh, "callback");
      if ((paramObject != null) && ((paramObject instanceof com.tencent.mm.am.p)))
      {
        this.map.put(paramObject, paramh);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramObject, 0);
      }
      AppMethodBeat.o(350684);
    }
    
    public void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(350707);
      kotlin.g.b.s.u(paramh, "callback");
      IResponse localIResponse = (IResponse)new com.tencent.mm.plugin.finder.feed.model.internal.e();
      localIResponse.setPullType(1000);
      ah localah = ah.aiuX;
      paramh.onFetchDone(localIResponse);
      AppMethodBeat.o(350707);
    }
    
    public void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(350717);
      kotlin.g.b.s.u(paramh, "callback");
      com.tencent.mm.am.p localp = genLoadMoreNetScene();
      int i;
      if ((localp instanceof co))
      {
        avb localavb = this.BwB.Bwy.ACu;
        if ((localavb == null) || (localavb.ZFr != 3)) {
          break label86;
        }
        i = 1;
        if (i == 0) {
          break label91;
        }
        ((co)localp).MX(16);
      }
      for (;;)
      {
        i.fetch$default((i)this, localp, paramh, false, 4, null);
        AppMethodBeat.o(350717);
        return;
        label86:
        i = 0;
        break;
        label91:
        ((co)localp).MX(2);
      }
    }
    
    public void fetchPreload(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(350702);
      kotlin.g.b.s.u(paramh, "callback");
      com.tencent.mm.am.p localp = genLoadMoreNetScene();
      int i;
      if ((localp instanceof co))
      {
        avb localavb = this.BwB.Bwy.ACu;
        if ((localavb == null) || (localavb.ZFr != 3)) {
          break label82;
        }
        i = 1;
        if (i == 0) {
          break label87;
        }
        ((co)localp).MX(16);
      }
      for (;;)
      {
        i.fetch$default((i)this, localp, paramh, false, 4, null);
        AppMethodBeat.o(350702);
        return;
        label82:
        i = 0;
        break;
        label87:
        ((co)localp).MX(3);
      }
    }
    
    public void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<f> paramh)
    {
      AppMethodBeat.i(350713);
      kotlin.g.b.s.u(paramh, "callback");
      com.tencent.mm.am.p localp = genLoadMoreNetScene();
      int i;
      if ((localp instanceof co))
      {
        avb localavb = this.BwB.Bwy.ACu;
        if ((localavb == null) || (localavb.ZFr != 3)) {
          break label82;
        }
        i = 1;
        if (i == 0) {
          break label87;
        }
        ((co)localp).MX(16);
      }
      for (;;)
      {
        i.fetch$default((i)this, localp, paramh, false, 4, null);
        AppMethodBeat.o(350713);
        return;
        label82:
        i = 0;
        break;
        label87:
        ((co)localp).MX(4);
      }
    }
    
    public com.tencent.mm.am.p genLoadMoreNetScene()
    {
      return null;
    }
    
    public int getCmdId()
    {
      return -1;
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(350679);
      kotlin.g.b.s.u(paramp, "scene");
      com.tencent.mm.plugin.finder.feed.model.internal.h localh = (com.tencent.mm.plugin.finder.feed.model.internal.h)this.map.get(paramp);
      if (localh != null)
      {
        FinderLiveRelatedLoader localFinderLiveRelatedLoader = this.BwB;
        this.map.remove(paramp);
        kotlin.g.b.s.u(paramp, "scene");
        label113:
        FinderLiveRelatedLoader.b localb;
        if ((paramp instanceof co))
        {
          boolean bool;
          int i;
          Collection localCollection;
          label222:
          long l3;
          long l1;
          label284:
          String str1;
          String str2;
          label336:
          String str3;
          label356:
          label371:
          String str4;
          label385:
          Object localObject2;
          long l2;
          label428:
          label443:
          bip localbip;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            bool = ((co)paramp).dVN();
            localObject1 = this.BwB.Bwy.ACu;
            if ((localObject1 == null) || (((avb)localObject1).ZFr != 3)) {
              break label519;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = this.BwB.Bwy.ACu;
              if (localObject1 != null) {
                ((avb)localObject1).ZFs = null;
              }
              localObject1 = this.BwB.Bwy.ACu;
              if (localObject1 != null) {
                ((avb)localObject1).ZFr = 0;
              }
            }
            localb = new FinderLiveRelatedLoader.b(((co)paramp).ACp, paramInt1, paramInt2, paramString);
            paramString = (Iterable)((co)paramp).dVP();
            localCollection = (Collection)new ArrayList(kotlin.a.p.a(paramString, 10));
            Iterator localIterator = paramString.iterator();
            if (!localIterator.hasNext()) {
              break label680;
            }
            localObject3 = (FinderObject)localIterator.next();
            paramString = com.tencent.mm.plugin.finder.storage.data.e.FMN;
            paramString = FinderItem.Companion;
            e.a.s(FinderItem.a.e((FinderObject)localObject3, 16384));
            l3 = ((FinderObject)localObject3).id;
            paramString = ((FinderObject)localObject3).liveInfo;
            if (paramString != null) {
              break label525;
            }
            l1 = 0L;
            paramString = ((FinderObject)localObject3).username;
            str1 = paramString;
            if (paramString == null) {
              str1 = "";
            }
            paramString = ((FinderObject)localObject3).objectNonceId;
            str2 = paramString;
            if (paramString == null) {
              str2 = "";
            }
            paramString = aw.Gjk;
            paramString = ((FinderObject)localObject3).objectDesc;
            if (paramString != null) {
              break label534;
            }
            paramString = null;
            str3 = aw.e(paramString);
            paramString = ((FinderObject)localObject3).liveInfo;
            if (paramString != null) {
              break label562;
            }
            paramString = "";
            localObject1 = ((FinderObject)localObject3).liveInfo;
            if (localObject1 != null) {
              break label583;
            }
            localObject1 = null;
            if (localObject1 != null) {
              break label614;
            }
            localObject1 = e.b.mKf;
            paramInt1 = e.b.bcu();
            str4 = ((FinderObject)localObject3).sessionBuffer;
            localObject1 = ((FinderObject)localObject3).nickname;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            localObject1 = ((FinderObject)localObject3).liveInfo;
            if (localObject1 != null) {
              break label623;
            }
            l2 = 0L;
            localObject1 = ((FinderObject)localObject3).liveInfo;
            if (localObject1 != null) {
              break label633;
            }
            localObject1 = null;
            localbip = ((FinderObject)localObject3).liveInfo;
            if (localbip != null) {
              break label661;
            }
            paramInt2 = 0;
            label457:
            localObject3 = ((FinderObject)localObject3).liveInfo;
            if (localObject3 != null) {
              break label670;
            }
          }
          label519:
          label525:
          label534:
          label670:
          for (Object localObject3 = null;; localObject3 = ((bip)localObject3).ZSn)
          {
            localCollection.add(new f(l3, l1, str1, str2, str3, paramString, paramInt1, str4, (String)localObject2, l2, (byte[])localObject1, paramInt2, (bgr)localObject3));
            break label222;
            bool = true;
            break;
            i = 0;
            break label113;
            l1 = paramString.liveId;
            break label284;
            paramString = paramString.media;
            if (paramString == null)
            {
              paramString = null;
              break label336;
            }
            paramString = (FinderMedia)kotlin.a.p.oL((List)paramString);
            break label336;
            label562:
            localObject1 = paramString.mIE;
            paramString = (String)localObject1;
            if (localObject1 != null) {
              break label356;
            }
            paramString = "";
            break label356;
            label583:
            localObject1 = ((bip)localObject1).ZRQ;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label371;
            }
            localObject1 = Integer.valueOf(((bmi)localObject1).mNn);
            break label371;
            label614:
            paramInt1 = ((Integer)localObject1).intValue();
            break label385;
            label623:
            l2 = ((bip)localObject1).ZFH;
            break label428;
            label633:
            localObject1 = ((bip)localObject1).ZOg;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label443;
            }
            localObject1 = ((dix)localObject1).toByteArray();
            break label443;
            paramInt2 = localbip.ZSl;
            break label457;
          }
          label661:
          label680:
          localb.setIncrementList((List)localCollection);
          localb.setPullType(((co)paramp).pullType);
          localb.setLastBuffer(((co)paramp).dVJ());
          localb.setHasMore(bool);
          paramString = g.Ebv;
          paramp = ((co)paramp).rr;
          paramString = paramp;
          if (paramp == null)
          {
            kotlin.g.b.s.bIx("rr");
            paramString = null;
          }
          paramString = c.c.b(paramString.otC);
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
            AppMethodBeat.o(350679);
            throw paramString;
          }
          g.PW(((azx)paramString).wrl * 1000);
          paramp = getTAG();
          Object localObject1 = new StringBuilder("incrementList size: ");
          paramString = localb.getIncrementList();
          if (paramString == null)
          {
            paramString = null;
            paramString = ((StringBuilder)localObject1).append(paramString).append(",refresh_interval:");
            localObject1 = g.Ebv;
            Log.i(paramp, g.exY());
          }
        }
        for (paramString = (IResponse)localb;; paramString = null)
        {
          if (paramString == null) {
            break label902;
          }
          localh.onFetchDone(paramString);
          AppMethodBeat.o(350679);
          return;
          paramString = Integer.valueOf(paramString.size());
          break;
        }
        label902:
        paramString = localFinderLiveRelatedLoader.fetchEndCallback;
        if (paramString != null) {
          paramString.invoke(null);
        }
      }
      AppMethodBeat.o(350679);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$FinderLiveRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "state", "", "errType", "errCode", "errMsg", "", "(IIILjava/lang/String;)V", "getState", "()I", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<f>
  {
    final int state;
    
    public b(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      super(paramInt3, paramString);
      this.state = paramInt1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$NearbyLiveRelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "dumpReadInfo", "", "genLoadMoreNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getCmdId", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends FinderLiveRelatedLoader.a
  {
    public c()
    {
      super();
      AppMethodBeat.i(350664);
      AppMethodBeat.o(350664);
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(350676);
      Object localObject1 = bi.ABn;
      Object localObject4 = bi.dVu();
      Object localObject2 = this.BwB;
      ((atz)localObject4).scene = ((FinderLiveRelatedLoader)localObject2).Bwy.AJo;
      localObject1 = new acx();
      ((acx)localObject1).zIO = ((FinderLiveRelatedLoader)localObject2).Bwy.zIO;
      localObject2 = ah.aiuX;
      ((atz)localObject4).ZEs = ((acx)localObject1);
      bui localbui = new bui();
      localObject1 = this.BwB;
      localbui.hLK = ((FinderLiveRelatedLoader)localObject1).Bwy.AJo;
      localbui.AJo = ((FinderLiveRelatedLoader)localObject1).Bwy.AJo;
      localObject1 = null;
      Object localObject3;
      if (this.BwB.BwA)
      {
        localObject2 = this.BwB.Bwy.ACt;
        localObject3 = this.BwB.Bwy;
        localObject1 = this.BwB.Bwy.CFj;
        if (localObject1 != null) {
          break label432;
        }
      }
      label432:
      for (localObject1 = null;; localObject1 = ((FinderObject)localObject1).live_related_last_buffer)
      {
        ((j)localObject3).AyB = ((com.tencent.mm.bx.b)localObject1);
        this.BwB.BwA = false;
        localObject1 = localObject2;
        long l = this.BwB.Bwy.hKN;
        String str = this.BwB.Bwy.nonceId;
        localObject3 = this.BwB.Bwy.sessionBuffer;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = new co(l, str, (String)localObject2, this.BwB.Bwy.AyB, this.BwB.Bwy.AJo, this.BwB.Bwy.EbM, this.BwB.Bwy.oDT, (atz)localObject4, (bcl)localObject1, localbui, this.BwB.Bwy.ACu, this.BwB.Bwy.EbN, this.BwB.Bwy.zVI, this.BwB.Bwy.ACw);
        localObject2 = this.BwB;
        ((co)localObject1).MX(2);
        ((co)localObject1).enterScene = ((FinderLiveRelatedLoader)localObject2).Bwy.enterScene;
        ((co)localObject1).ACp = ((FinderLiveRelatedLoader)localObject2).state;
        localObject2 = new StringBuilder();
        localObject3 = ((Iterable)this.BwB.Bwy.EbN).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bly)((Iterator)localObject3).next();
          ((StringBuilder)localObject2).append("objectId:" + ((bly)localObject4).object_id + ',');
        }
      }
      ((StringBuilder)localObject2).append(kotlin.g.b.s.X("curIndex:", Integer.valueOf(this.BwB.Bwy.zVI)));
      Log.d(getTAG(), kotlin.g.b.s.X("genLoadMoreNetScene ", localObject2));
      localObject1 = (com.tencent.mm.am.p)localObject1;
      AppMethodBeat.o(350676);
      return localObject1;
    }
    
    public final int getCmdId()
    {
      return 6479;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.FinderLiveRelatedLoader
 * JD-Core Version:    0.7.0.1
 */