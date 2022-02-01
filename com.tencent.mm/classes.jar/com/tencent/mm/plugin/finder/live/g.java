package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.l;
import com.tencent.mm.plugin.finder.feed.model.internal.q;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.sidebar.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "feedChangeListener", "com/tencent/mm/plugin/finder/live/FinderLivePresenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$feedChangeListener$1;", "hasPreload", "", "liveDataLoader", "Lcom/tencent/mm/plugin/finder/live/FinderLiveDataLoader;", "sideBarDataCache", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$SideBarDataCache;", "getSideBarDataCache", "()Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$SideBarDataCache;", "setSideBarDataCache", "(Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$SideBarDataCache;)V", "viewcall", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "appendToSideBar", "", "incrementList", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "canFlingUp", "canLoadMore", "genNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLiveRelatedList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLiveData", "isEnableNestedScroll", "lastPlayItemPos", "", "loadDataImpl", "loadType", "checkPullType", "pullType", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "loadMoreData", "onAttach", "callback", "onDetach", "onLoadMoreInvalid", "onLoadMoreResult", "oriDataSize", "incrementSize", "onOrderResult", "notifyPos", "upIncrementSize", "downIncrementSize", "onPreloadResult", "lastItemPos", "onSideBarStateChanged", "show", "preloadData", "newPos", "dataSize", "refreshData", "splitList", "fullList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "curLive", "preList", "sufList", "switchList", "targetList", "Companion", "SideBarDataCache", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements c.a
{
  public static final a Bwn;
  private static final boolean Bwt;
  private c.b Bwo;
  private d Bwp;
  private boolean Bwq;
  private b Bwr;
  private final FinderLivePresenter.feedChangeListener.1 Bws;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(350812);
    Bwn = new a((byte)0);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jTV().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Bwt = bool;
      AppMethodBeat.o(350812);
      return;
    }
  }
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(350743);
    this.context = paramContext;
    this.Bws = new FinderLivePresenter.feedChangeListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(350743);
  }
  
  private static int a(ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList1, com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList2, ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList3)
  {
    AppMethodBeat.i(350794);
    Iterator localIterator = ((List)paramArrayList1).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localIterator.next()).Ebr.liveId == paramf.Ebr.liveId)
      {
        j = 1;
        label59:
        if (j == 0) {
          break label129;
        }
      }
    }
    for (;;)
    {
      if (i > 0) {
        paramArrayList2.addAll((Collection)paramArrayList1.subList(0, i));
      }
      if (i < paramArrayList1.size() - 1) {
        paramArrayList3.addAll((Collection)paramArrayList1.subList(i + 1, paramArrayList1.size()));
      }
      AppMethodBeat.o(350794);
      return i;
      j = 0;
      break label59;
      label129:
      i += 1;
      break;
      i = -1;
    }
  }
  
  private final void a(ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList1, ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList2, com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList3, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(350787);
    Object localObject2 = new StringBuilder("sidebar switchList preList:").append(paramArrayList2.size()).append(", sufList:").append(paramArrayList3.size()).append(", lastBuf:");
    Object localObject1;
    label165:
    int i;
    if (paramb == null)
    {
      localObject1 = null;
      Log.i("FinderLivePresenter", localObject1);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll((Collection)paramArrayList1);
      paramArrayList1.clear();
      com.tencent.mm.ae.d.a(paramArrayList2, (kotlin.g.a.b)new c(paramf));
      com.tencent.mm.ae.d.a(paramArrayList3, (kotlin.g.a.b)new d(paramf));
      StringBuilder localStringBuilder = new StringBuilder("sidebar switchList after filter preList:").append(paramArrayList2.size()).append(", sufList:").append(paramArrayList3.size()).append(", lastBuf:");
      if (paramb != null) {
        break label382;
      }
      localObject1 = null;
      Log.i("FinderLivePresenter", localObject1);
      paramArrayList1.addAll((Collection)paramArrayList2);
      paramArrayList1.add(paramf);
      paramArrayList1.addAll((Collection)paramArrayList3);
      k = paramArrayList2.size();
      paramArrayList1 = (List)localObject2;
      i = 0;
      paramArrayList1 = paramArrayList1.iterator();
      label227:
      if (!paramArrayList1.hasNext()) {
        break label411;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.f)paramArrayList1.next()).Ebr.liveId != paramf.Ebr.liveId) {
        break label396;
      }
      j = 1;
      label265:
      if (j == 0) {
        break label402;
      }
      label270:
      paramArrayList1 = aj.CGT;
      paramArrayList1 = aj.egD();
      if (paramArrayList1 != null) {
        paramArrayList1.PV(k);
      }
      paramArrayList1 = aj.CGT;
      paramArrayList1 = aj.egD();
      if (paramArrayList1 != null) {
        break label417;
      }
    }
    label396:
    label402:
    label411:
    label417:
    for (paramArrayList1 = null;; paramArrayList1 = paramArrayList1.Bwy)
    {
      if (paramArrayList1 != null) {
        paramArrayList1.AyB = paramb;
      }
      paramArrayList1 = this.Bwo;
      if (paramArrayList1 == null) {
        break label568;
      }
      paramArrayList1 = paramArrayList1.egG();
      if (paramArrayList1 == null) {
        break label568;
      }
      paramArrayList1 = paramArrayList1.getRecyclerView();
      if (paramArrayList1 == null) {
        break label568;
      }
      paramArrayList1 = paramArrayList1.getAdapter();
      if (paramArrayList1 == null) {
        break label568;
      }
      if (i >= 0) {
        break label425;
      }
      paramArrayList1.bZE.notifyChanged();
      AppMethodBeat.o(350787);
      return;
      localObject1 = Integer.valueOf(paramb.Op.length);
      break;
      label382:
      localObject1 = Integer.valueOf(paramb.Op.length);
      break label165;
      j = 0;
      break label265;
      i += 1;
      break label227;
      i = -1;
      break label270;
    }
    label425:
    int j = ((ArrayList)localObject2).size() - i - 1;
    int k = paramArrayList2.size();
    int m = paramArrayList3.size();
    if (i > 0) {
      paramArrayList1.bB(0, i);
    }
    if (j > 0) {
      paramArrayList1.bB(1, j);
    }
    if (k > 0) {
      paramArrayList1.bA(0, k);
    }
    if (m > 0) {
      paramArrayList1.bA(k + 1, m);
    }
    Log.i("FinderLivePresenter", "sidebar notify originCurPos:" + i + ", preRemoveCount:" + i + ", sufRemoveCount:" + j + ", preInsertCount:" + k + ", sufInsertCount:" + m);
    label568:
    AppMethodBeat.o(350787);
  }
  
  private final boolean a(int paramInt1, boolean paramBoolean, int paramInt2, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(350764);
    Object localObject1 = aj.CGT;
    localObject1 = aj.egD();
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject2;
    int i;
    Object localObject3;
    for (;;)
    {
      if ((localObject1 != null) && (parama != null)) {
        if ((paramBoolean) && (((j)localObject1).CFf != paramInt2))
        {
          Log.i("FinderLivePresenter", "preloadDataImpl loadType:" + paramInt1 + ", pullType:" + paramInt2 + ", pullMoreType:" + ((j)localObject1).CFf);
          AppMethodBeat.o(350764);
          return false;
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Bwy;
        }
        else
        {
          int j = 0;
          paramInt2 = 0;
          ((j)localObject1).hKN = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
          ((j)localObject1).setNonceId(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
          ((j)localObject1).sessionBuffer = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer;
          parama = new LinkedList();
          localObject2 = aj.CGT;
          localObject2 = aj.egD();
          i = j;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject2).Ebx;
            i = j;
            if (localObject2 != null)
            {
              localObject2 = ((Iterable)localObject2).iterator();
              i = paramInt2;
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)((Iterator)localObject2).next();
                if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject3).Ebt) {
                  break label785;
                }
                bly localbly = new bly();
                localbly.object_id = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject3).Ebr.mIH;
                parama.add(localbly);
                if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject3).Ebu) {
                  break label785;
                }
                paramInt2 += 1;
              }
            }
          }
        }
      }
    }
    label785:
    for (;;)
    {
      break;
      localObject2 = ah.aiuX;
      ((j)localObject1).aC(parama);
      parama = (Iterable)((j)localObject1).EbN;
      paramInt2 = 0;
      parama = parama.iterator();
      while (parama.hasNext())
      {
        localObject2 = parama.next();
        if (paramInt2 < 0) {
          p.kkW();
        }
        localObject2 = (bly)localObject2;
        if (((j)localObject1).hKN == ((bly)localObject2).object_id) {
          ((j)localObject1).zVI = (paramInt2 - i);
        }
        paramInt2 += 1;
      }
      parama = this.Bwp;
      if (parama == null)
      {
        AppMethodBeat.o(350764);
        return false;
      }
      s.u(localObject1, "loadParams");
      localObject2 = new StringBuilder("loadData presenter:");
      localObject3 = parama.BvQ;
      if (localObject3 != null)
      {
        paramInt2 = localObject3.hashCode();
        Log.i("FinderLiveDataLoader", paramInt2 + ", curLoadType:" + parama.BvS + ", type:" + paramInt1 + ", loadType:" + parama.BvS + ", loading:" + parama.loading + ", isIgnorePreloadForFeedId=" + d.Bhv + ",thread:" + Thread.currentThread().getName());
        if (!parama.loading) {
          break label606;
        }
        if ((parama.BvS == 3) && ((paramInt1 == 2) || (paramInt1 == 4))) {
          parama.BvS = paramInt1;
        }
      }
      label606:
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label611;
        }
        AppMethodBeat.o(350764);
        return false;
        paramInt2 = 0;
        break;
      }
      label611:
      if (d.Bhv == ((j)localObject1).hKN)
      {
        d.Bhv = -1L;
        AppMethodBeat.o(350764);
        return false;
      }
      parama.loading = true;
      parama.BvS = paramInt1;
      parama.BvT.a((j)localObject1);
      if (parama.BvS == 4) {
        parama.BvT.requestRefresh();
      }
      for (;;)
      {
        AppMethodBeat.o(350764);
        return true;
        BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)parama.BvT, false, 1, null);
      }
      localObject1 = new StringBuilder("preloadDataImpl loaderParams:");
      parama = aj.CGT;
      parama = aj.egD();
      if (parama == null) {}
      for (parama = null;; parama = parama.Bwy)
      {
        parama = ((StringBuilder)localObject1).append(parama).append(",curLiveRoomData:");
        localObject1 = aj.CGT;
        Log.i("FinderLivePresenter", aj.elr());
        AppMethodBeat.o(350764);
        return false;
      }
    }
  }
  
  private static final boolean a(g paramg, com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(350799);
    Object localObject = paramg.Bwp;
    if ((localObject != null) && (((d)localObject).loading == true)) {}
    while (i == 0)
    {
      localObject = d.BvP;
      if ((!d.a.hy(paramInt1, paramInt2)) || (!paramg.egB())) {
        break;
      }
      boolean bool = paramg.a(3, false, 0, parama);
      AppMethodBeat.o(350799);
      return bool;
      i = 0;
    }
    AppMethodBeat.o(350799);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.data.g egY()
  {
    AppMethodBeat.i(350746);
    Object localObject = aj.CGT;
    localObject = aj.egD();
    AppMethodBeat.o(350746);
    return localObject;
  }
  
  private final void gj(List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList)
  {
    int i = 1;
    AppMethodBeat.i(350777);
    Object localObject = this.Bwp;
    c localc;
    if ((localObject != null) && (((d)localObject).owq == 1)) {
      if (i != 0)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        localObject = com.tencent.mm.ui.component.k.nq(this.context).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
        s.s(localObject, "UICProvider.of(context).…veSideBarUIC::class.java)");
        localc = ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGE;
        if (localc != null)
        {
          localObject = aj.CGT;
          localObject = aj.egD();
          if (localObject != null) {
            break label101;
          }
          localObject = null;
        }
      }
    }
    for (;;)
    {
      localc.a(paramList, (com.tencent.mm.bx.b)localObject);
      AppMethodBeat.o(350777);
      return;
      i = 0;
      break;
      label101:
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((j)localObject).AyB;
      }
    }
  }
  
  public final void a(c.b paramb)
  {
    long l = 0L;
    AppMethodBeat.i(350889);
    s.u(paramb, "callback");
    this.Bwo = paramb;
    paramb = aj.CGT;
    paramb = aj.egD();
    if (paramb == null)
    {
      paramb = null;
      if (paramb == null)
      {
        Log.e("FinderLivePresenter", "presenter attach error, live data is null!");
        e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "liveAttachError", false, null, false, null, 60);
      }
      AppMethodBeat.o(350889);
      return;
    }
    Object localObject1 = this.Bwo;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = paramb.getCurPos();
      localObject2 = paramb.exW();
      if (localObject2 != null) {
        break label228;
      }
    }
    for (;;)
    {
      ((c.b)localObject1).a(paramb, i, l);
      this.Bwp = new d();
      paramb = this.Bwp;
      if (paramb != null)
      {
        localObject1 = (c.a)this;
        s.u(localObject1, "presenter");
        paramb.BvQ = ((c.a)localObject1);
        paramb.BvT.setPreload((l)paramb.BvR);
      }
      paramb = this.Bwo;
      if (paramb != null)
      {
        paramb = paramb.egG();
        if (paramb != null)
        {
          localObject1 = this.Bwp;
          if (localObject1 != null)
          {
            localObject1 = ((d)localObject1).BvT;
            if (localObject1 != null) {
              ((FinderLiveRelatedLoader)localObject1).register((com.tencent.mm.view.k)paramb);
            }
          }
        }
      }
      this.Bws.alive();
      paramb = ah.aiuX;
      break;
      label228:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject2).Ebr;
      if (localObject2 != null) {
        l = ((LiveConfig)localObject2).liveId;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(350879);
    c.b localb = this.Bwo;
    if (localb != null) {
      localb.a(paramg, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(350879);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg, int paramInt1, int paramInt2, List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList)
  {
    AppMethodBeat.i(350872);
    s.u(paramList, "incrementList");
    c.b localb = this.Bwo;
    if (localb != null) {
      localb.a(paramg, paramInt1, paramInt2);
    }
    gj(paramList);
    AppMethodBeat.o(350872);
  }
  
  public final boolean a(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(350852);
    if (this.Bwq)
    {
      StringBuilder localStringBuilder = new StringBuilder("preloadData, return for hasPreload(");
      aj localaj = aj.CGT;
      Log.w("FinderLivePresenter", aj.elj() + ')');
      bool = a(this, parama, paramInt1, paramInt2);
      AppMethodBeat.o(350852);
      return bool;
    }
    this.Bwq = true;
    if ((paramInt1 != 0) || (paramInt2 > 1))
    {
      Log.w("FinderLivePresenter", "preloadData, return for newPos:" + paramInt1 + ", dataSize:" + paramInt2);
      bool = a(this, parama, paramInt1, paramInt2);
      AppMethodBeat.o(350852);
      return bool;
    }
    Log.i("FinderLivePresenter", "preloadData");
    boolean bool = a(3, true, 1, parama);
    AppMethodBeat.o(350852);
    return bool;
  }
  
  public final void b(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg, int paramInt1, int paramInt2, List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList)
  {
    AppMethodBeat.i(350883);
    s.u(paramList, "incrementList");
    c.b localb = this.Bwo;
    if (localb != null) {
      localb.b(paramg, paramInt1, paramInt2);
    }
    gj(paramList);
    AppMethodBeat.o(350883);
  }
  
  public final co c(com.tencent.mm.bx.b paramb)
  {
    int k = 0;
    azw localazw = null;
    AppMethodBeat.i(350844);
    Object localObject1 = aj.CGT;
    localObject1 = aj.egD();
    Object localObject2;
    Object localObject3;
    int i;
    label157:
    int j;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = aj.CGT;
      localObject2 = aj.elr();
      if ((localObject1 == null) || (localObject2 == null)) {
        break label553;
      }
      ((j)localObject1).hKN = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      ((j)localObject1).setNonceId(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
      ((j)localObject1).sessionBuffer = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer;
      localObject2 = new LinkedList();
      localObject3 = aj.CGT;
      localObject3 = aj.egD();
      if (localObject3 == null) {
        break label244;
      }
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject3).Ebx;
      if (localObject3 == null) {
        break label244;
      }
      localObject3 = ((Iterable)localObject3).iterator();
      i = 0;
      j = i;
      if (!((Iterator)localObject3).hasNext()) {
        break label246;
      }
      localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)((Iterator)localObject3).next();
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).Ebt) {
        break label628;
      }
      bly localbly = new bly();
      localbly.object_id = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).Ebr.mIH;
      ((LinkedList)localObject2).add(localbly);
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).Ebu) {
        break label628;
      }
      i += 1;
    }
    label481:
    label496:
    label628:
    for (;;)
    {
      break label157;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Bwy;
      break;
      label244:
      j = 0;
      label246:
      localObject3 = ah.aiuX;
      ((j)localObject1).aC((LinkedList)localObject2);
      localObject2 = ((Iterable)((j)localObject1).EbN).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          p.kkW();
        }
        localObject3 = (bly)localObject3;
        if (((j)localObject1).hKN == ((bly)localObject3).object_id) {
          ((j)localObject1).zVI = (i - j);
        }
        i += 1;
      }
      localObject2 = this.Bwp;
      if (localObject2 == null)
      {
        AppMethodBeat.o(350844);
        return null;
      }
      s.u(localObject1, "loadParams");
      localObject3 = new StringBuilder("genNetScene presenter:");
      localObject4 = ((d)localObject2).BvQ;
      i = k;
      if (localObject4 != null) {
        i = localObject4.hashCode();
      }
      Log.i("FinderLiveDataLoader", i + ", type:2, loading:" + ((d)localObject2).loading + ", isIgnorePreloadForFeedId=" + d.Bhv);
      ((d)localObject2).BvT.a((j)localObject1);
      localObject1 = ((d)localObject2).BvT.Bwz;
      if ((localObject1 instanceof FinderLiveRelatedLoader.a))
      {
        localObject1 = (FinderLiveRelatedLoader.a)localObject1;
        if (localObject1 != null) {
          break label527;
        }
        localObject1 = null;
        if (!(localObject1 instanceof co)) {
          break label537;
        }
        localObject1 = (co)localObject1;
        if (localObject1 != null) {
          break label543;
        }
      }
      for (;;)
      {
        if (localazw != null) {
          localazw.ZEQ = paramb;
        }
        AppMethodBeat.o(350844);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = ((FinderLiveRelatedLoader.a)localObject1).genLoadMoreNetScene();
        break label481;
        localObject1 = null;
        break label496;
        localazw = ((co)localObject1).dWa();
      }
      localObject1 = new StringBuilder("preloadDataImpl loaderParams:");
      paramb = aj.CGT;
      paramb = aj.egD();
      if (paramb == null) {}
      for (paramb = null;; paramb = paramb.Bwy)
      {
        paramb = ((StringBuilder)localObject1).append(paramb).append(",curLiveRoomData:");
        localObject1 = aj.CGT;
        Log.i("FinderLivePresenter", aj.elr());
        AppMethodBeat.o(350844);
        return null;
      }
    }
  }
  
  public final boolean dcT()
  {
    AppMethodBeat.i(350860);
    Log.i("FinderLivePresenter", "loadMoreData");
    boolean bool = a(this, 2);
    AppMethodBeat.o(350860);
    return bool;
  }
  
  public final boolean egA()
  {
    AppMethodBeat.i(350822);
    if (!this.Bwq)
    {
      Object localObject = aj.CGT;
      localObject = aj.egD();
      int i;
      StringBuilder localStringBuilder;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
        if ((localObject != null) && (((j)localObject).CFf == 1))
        {
          i = 1;
          if (i == 0) {
            break label123;
          }
          localStringBuilder = new StringBuilder("canLoadMore isLoading:");
          localObject = this.Bwp;
          if (localObject != null) {
            break label109;
          }
        }
      }
      label109:
      for (localObject = null;; localObject = Boolean.valueOf(((d)localObject).BvR.isLoading))
      {
        Log.i("FinderLivePresenter", localObject + " hasPreload:" + this.Bwq);
        AppMethodBeat.o(350822);
        return false;
        i = 0;
        break;
      }
    }
    label123:
    AppMethodBeat.o(350822);
    return true;
  }
  
  public final boolean egB()
  {
    AppMethodBeat.i(350828);
    Object localObject = aj.CGT;
    localObject = aj.egD();
    if (localObject == null)
    {
      AppMethodBeat.o(350828);
      return false;
    }
    j localj = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
    if ((localj != null) && (localj.hJx == 2))
    {
      i = 1;
      if (i == 0)
      {
        localj = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
        if ((localj == null) || (localj.hJx != 2)) {
          break label133;
        }
        i = 1;
        label68:
        if (i == 0)
        {
          localj = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
          if ((localj == null) || (localj.hJx != 1001)) {
            break label138;
          }
          i = 1;
          label93:
          if (i == 0)
          {
            localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
            if ((localObject == null) || (((j)localObject).CFf != 1)) {
              break label143;
            }
          }
        }
      }
    }
    label133:
    label138:
    label143:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label148;
      }
      AppMethodBeat.o(350828);
      return true;
      i = 0;
      break;
      i = 0;
      break label68;
      i = 0;
      break label93;
    }
    label148:
    AppMethodBeat.o(350828);
    return false;
  }
  
  public final boolean egC()
  {
    AppMethodBeat.i(350834);
    Object localObject = aj.CGT;
    localObject = aj.egD();
    if (localObject == null)
    {
      AppMethodBeat.o(350834);
      return false;
    }
    j localj = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
    if ((localj != null) && (localj.hJx == 3))
    {
      i = 1;
      if (i == 0)
      {
        localj = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
        if ((localj == null) || (localj.hJx != 1)) {
          break label133;
        }
        i = 1;
        label68:
        if (i == 0)
        {
          localj = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
          if ((localj == null) || (localj.hJx != 2)) {
            break label138;
          }
          i = 1;
          label91:
          if (i == 0)
          {
            localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
            if ((localObject == null) || (((j)localObject).hJx != 1010)) {
              break label143;
            }
          }
        }
      }
    }
    label133:
    label138:
    label143:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label148;
      }
      AppMethodBeat.o(350834);
      return true;
      i = 0;
      break;
      i = 0;
      break label68;
      i = 0;
      break label91;
    }
    label148:
    AppMethodBeat.o(350834);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.g egD()
  {
    AppMethodBeat.i(350817);
    Object localObject = aj.CGT;
    localObject = aj.egD();
    AppMethodBeat.o(350817);
    return localObject;
  }
  
  public final int egE()
  {
    int k = -1;
    AppMethodBeat.i(350866);
    Object localObject = this.Bwo;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof LinearLayoutManager)) {
        break label217;
      }
      localObject = (LinearLayoutManager)localObject;
      label37:
      if (localObject != null) {
        break label223;
      }
    }
    label217:
    label223:
    for (int i = -1;; i = ((LinearLayoutManager)localObject).Jw())
    {
      localObject = aj.CGT;
      localObject = aj.egD();
      int j = k;
      if (localObject != null)
      {
        localObject = (List)((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Ebx;
        localObject = ((List)localObject).listIterator(((List)localObject).size());
        do
        {
          j = k;
          if (!((ListIterator)localObject).hasPrevious()) {
            break;
          }
        } while (!((com.tencent.mm.plugin.finder.live.viewmodel.data.f)((ListIterator)localObject).previous()).Ebt);
        j = ((ListIterator)localObject).nextIndex();
      }
      Log.i("FinderLivePresenter", "lastVisibleItemPos:" + i + ",lastPlayPos:" + j);
      i = kotlin.k.k.qu(i, j);
      AppMethodBeat.o(350866);
      return i;
      localObject = ((c.b)localObject).egG();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((RecyclerView)localObject).getLayoutManager();
      break;
      localObject = null;
      break label37;
    }
  }
  
  public final void egF()
  {
    AppMethodBeat.i(350918);
    Object localObject1 = RefreshLoadMoreLayout.d.agJr;
    localObject1 = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
    Object localObject2 = this.Bwo;
    if (localObject2 != null)
    {
      localObject2 = ((c.b)localObject2).egG();
      if (localObject2 != null) {
        ((RefreshLoadMoreLayout)localObject2).l((RefreshLoadMoreLayout.d)localObject1);
      }
    }
    AppMethodBeat.o(350918);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(350895);
    Object localObject1 = this.Bwo;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((c.b)localObject1).egG();
      if (localObject1 != null)
      {
        localObject2 = this.Bwp;
        if (localObject2 != null)
        {
          localObject2 = ((d)localObject2).BvT;
          if (localObject2 != null) {
            ((FinderLiveRelatedLoader)localObject2).unregister((com.tencent.mm.view.k)localObject1);
          }
        }
      }
    }
    this.Bwo = null;
    localObject1 = this.Bwp;
    if (localObject1 != null)
    {
      localObject2 = ((d)localObject1).BvR;
      if (localObject2 != null) {
        ((q)localObject2).clearCache();
      }
      ((d)localObject1).loading = false;
      d.Bhv = -1L;
      ((d)localObject1).BvQ = null;
    }
    this.Bws.dead();
    AppMethodBeat.o(350895);
  }
  
  public final void qi(boolean paramBoolean)
  {
    b localb = null;
    AppMethodBeat.i(350912);
    Log.i("FinderLivePresenter", s.X("onSideBarStateChanged ", Boolean.valueOf(paramBoolean)));
    Object localObject1 = this.Bwp;
    int i;
    label70:
    Object localObject2;
    label94:
    Object localObject3;
    label109:
    Object localObject4;
    Object localObject5;
    if (localObject1 != null)
    {
      if (paramBoolean)
      {
        i = 1;
        ((d)localObject1).owq = i;
        ((d)localObject1).BvT.state = ((d)localObject1).owq;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label662;
      }
      localObject1 = this.Bwp;
      if (localObject1 != null) {
        break label386;
      }
      localObject1 = null;
      if (localObject1 != null) {
        ((FinderLiveRelatedLoader)localObject1).BwA = false;
      }
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label394;
      }
      localObject2 = null;
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label403;
      }
      localObject3 = null;
      if ((localObject2 == null) || (localObject3 == null)) {
        break label634;
      }
      localObject4 = new ArrayList();
      localObject5 = new ArrayList();
      i = a((ArrayList)localObject3, (com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject2, (ArrayList)localObject4, (ArrayList)localObject5);
      Log.i("FinderLivePresenter", "sidebar old curPos:" + i + ", preList:" + ((ArrayList)localObject4).size() + ", sufList:" + ((ArrayList)localObject5).size() + ", fullList:" + ((ArrayList)localObject3).size());
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label412;
      }
      localObject1 = null;
      label226:
      this.Bwr = new b((ArrayList)localObject4, (ArrayList)localObject5, (com.tencent.mm.bx.b)localObject1);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.nq(this.context).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
      s.s(localObject1, "UICProvider.of(context).…veSideBarUIC::class.java)");
      localObject5 = (com.tencent.mm.plugin.finder.live.sidebar.d)localObject1;
      localObject1 = ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject5).DGE;
      if (localObject1 != null) {
        break label434;
      }
      localObject1 = null;
      label285:
      if (localObject1 == null) {
        Log.e("FinderLivePresenter", "currentSideBarJumpInfo is empty!");
      }
      localObject1 = ah.aiuX;
      label301:
      if (localObject1 != null) {
        break label655;
      }
      localObject2 = new StringBuilder("show data?.curLiveData liveDataList is null: ");
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label639;
      }
      localObject1 = null;
      label331:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", ");
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label647;
      }
    }
    label386:
    label647:
    for (localObject1 = localb;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Ebx)
    {
      Log.e("FinderLivePresenter", localObject1);
      AppMethodBeat.o(350912);
      return;
      i = 0;
      break;
      localObject1 = ((d)localObject1).BvT;
      break label70;
      label394:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).exW();
      break label94;
      label403:
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Ebx;
      break label109;
      label412:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Bwy;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label226;
      }
      localObject1 = ((j)localObject1).AyB;
      break label226;
      label434:
      localObject1 = ((c)localObject1).etD();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label285;
      }
      localObject4 = (List)((r)localObject1).bsC;
      localObject1 = (com.tencent.mm.bx.b)((r)localObject1).bsD;
      if (localObject1 == null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.model.b)p.oL((List)((com.tencent.mm.plugin.finder.live.sidebar.d)localObject5).DGG);
        if (localObject1 == null) {
          localObject1 = null;
        }
      }
      for (;;)
      {
        localObject5 = new ArrayList();
        ((ArrayList)localObject5).addAll((Collection)localObject4);
        localObject4 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        i = a((ArrayList)localObject5, (com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject2, (ArrayList)localObject4, localArrayList);
        Log.i("FinderLivePresenter", "sidebar new curPos:" + i + ", preList:" + ((ArrayList)localObject4).size() + ", sufList:" + localArrayList.size() + ", fullList:" + ((ArrayList)localObject5).size());
        a((ArrayList)localObject3, (ArrayList)localObject4, (com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject2, localArrayList, (com.tencent.mm.bx.b)localObject1);
        localObject1 = ah.aiuX;
        break;
        localObject1 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDB;
      }
      label634:
      localObject1 = null;
      break label301;
      label639:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).exW();
      break label331;
    }
    label655:
    AppMethodBeat.o(350912);
    return;
    label662:
    localObject1 = aj.CGT;
    localObject1 = aj.egD();
    if (localObject1 == null)
    {
      localObject2 = null;
      localb = this.Bwr;
      if ((localObject2 == null) || (localb == null)) {
        break label843;
      }
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label835;
      }
      localObject1 = null;
      label707:
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ArrayList();
      }
      a((ArrayList)localObject3, localb.Bwu, (com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject2, localb.Bwv, localb.lastBuffer);
      localObject1 = ah.aiuX;
      label750:
      if (localObject1 == null)
      {
        localObject2 = (g)this;
        localObject3 = new StringBuilder("hide data?.curLiveData sideBarDataCache is null: ");
        localObject1 = aj.CGT;
        localObject1 = aj.egD();
        if (localObject1 != null) {
          break label848;
        }
      }
    }
    label835:
    label843:
    label848:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).exW())
    {
      Log.e("FinderLivePresenter", localObject1 + ", " + ((g)localObject2).Bwr);
      this.Bwr = null;
      AppMethodBeat.o(350912);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).exW();
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Ebx;
      break label707;
      localObject1 = null;
      break label750;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$Companion;", "", "()V", "ENABLE_PRELOAD_RVFEED", "", "getENABLE_PRELOAD_RVFEED", "()Z", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$SideBarDataCache;", "", "preList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lkotlin/collections/ArrayList;", "sufList", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPreList", "()Ljava/util/ArrayList;", "getSufList", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> Bwu;
    final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> Bwv;
    final com.tencent.mm.bx.b lastBuffer;
    
    public b(ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList1, ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList2, com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(351009);
      this.Bwu = paramArrayList1;
      this.Bwv = paramArrayList2;
      this.lastBuffer = paramb;
      AppMethodBeat.o(351009);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(351027);
      if (this == paramObject)
      {
        AppMethodBeat.o(351027);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(351027);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.Bwu, paramObject.Bwu))
      {
        AppMethodBeat.o(351027);
        return false;
      }
      if (!s.p(this.Bwv, paramObject.Bwv))
      {
        AppMethodBeat.o(351027);
        return false;
      }
      if (!s.p(this.lastBuffer, paramObject.lastBuffer))
      {
        AppMethodBeat.o(351027);
        return false;
      }
      AppMethodBeat.o(351027);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(351022);
      int j = this.Bwu.hashCode();
      int k = this.Bwv.hashCode();
      if (this.lastBuffer == null) {}
      for (int i = 0;; i = this.lastBuffer.hashCode())
      {
        AppMethodBeat.o(351022);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(351016);
      String str = "SideBarDataCache(preList=" + this.Bwu + ", sufList=" + this.Bwv + ", lastBuffer=" + this.lastBuffer + ')';
      AppMethodBeat.o(351016);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.f, Boolean>
  {
    c(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.f, Boolean>
  {
    d(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.g
 * JD-Core Version:    0.7.0.1
 */