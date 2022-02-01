package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.f;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "(Landroid/support/v4/app/FragmentActivity;)V", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic
  implements LifecycleObserver
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a mSG = new AppBrandRecommendUILogic.a((byte)0);
  final Context context;
  final ArrayList<Integer> mSA;
  final HashMap<String, Long> mSB;
  final HashMap<Integer, String> mSC;
  final l mSD;
  private final p mSE;
  final FragmentActivity mSF;
  private final f mSn;
  private final f mSp;
  private final aq mSq;
  final a mSr;
  final b mSs;
  final LinearLayoutManager mSt;
  final com.tencent.mm.plugin.appbrand.ui.recents.i mSu;
  final h mSv;
  private final f mSw;
  private final k.a mSx;
  private final k.a mSy;
  final ArrayList<Integer> mSz;
  
  public AppBrandRecommendUILogic(FragmentActivity paramFragmentActivity)
  {
    this.mSF = paramFragmentActivity;
    paramFragmentActivity = this.mSF;
    if (paramFragmentActivity == null) {
      throw new v("null cannot be cast to non-null type android.content.Context");
    }
    this.context = ((Context)paramFragmentActivity);
    this.mSn = d.g.O((d.g.a.a)new j(this));
    this.mSp = d.g.O((d.g.a.a)c.mSJ);
    this.mSq = new aq("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.mSr = new a((Activity)this.mSF);
    this.mSs = new b();
    this.mSt = ((LinearLayoutManager)new SmoothScrollLinerLayoutManager(this.context));
    this.mSu = new com.tencent.mm.plugin.appbrand.ui.recents.i(this.mSF, (ViewGroup)bBZ());
    this.mSv = new h();
    this.mSw = d.g.O((d.g.a.a)new i(this));
    this.mSx = ((k.a)new d(this));
    this.mSy = ((k.a)new r(this));
    this.mSz = new ArrayList();
    this.mSA = new ArrayList();
    this.mSB = new HashMap();
    this.mSC = new HashMap();
    this.mSD = new l(this);
    this.mSE = new p(this);
  }
  
  private final void c(ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    Iterator localIterator = paramArrayList.iterator();
    label145:
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (localInteger == null) {}
      for (;;)
      {
        if (!this.mSC.containsKey(localInteger)) {
          break label145;
        }
        String str = (String)this.mSC.get(localInteger);
        Long localLong = (Long)((Map)this.mSB).get(str);
        if ((str == null) || (localLong == null)) {
          break;
        }
        long l = System.currentTimeMillis() - localLong.longValue();
        ae.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localInteger, Long.valueOf(l) });
        this.mSv.W(str, l);
        break;
        if (localInteger.intValue() == 0) {
          break;
        }
      }
    }
    if (paramBoolean) {
      paramArrayList.clear();
    }
  }
  
  private final void t(d.g.a.a<z> parama)
  {
    this.mSq.post((Runnable)new AppBrandRecommendUILogic.k(parama));
  }
  
  public abstract String bBN();
  
  public abstract boolean bBO();
  
  public final LoadMoreRecyclerView bBZ()
  {
    return (LoadMoreRecyclerView)this.mSn.getValue();
  }
  
  final d bCa()
  {
    return (d)this.mSp.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.recents.g bCb()
  {
    return (com.tencent.mm.plugin.appbrand.ui.recents.g)this.mSw.getValue();
  }
  
  public abstract View getContentView();
  
  final void hQ(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    t((d.g.a.a)new e(this, paramBoolean));
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    ae.i(TAG, "onCreate");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    ae.i(TAG, "onDestroy");
    ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).remove(this.mSx);
    com.tencent.mm.plugin.appbrand.app.j.aZl().remove(this.mSy);
    this.mSz.clear();
    this.mSA.clear();
    this.mSB.clear();
    this.mSC.clear();
    this.mSv.tl(bCa().sessionId);
    d locald = bCa();
    if (!bCa().bds().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      locald.jUe = bool;
      bCa().jUf = 0;
      locald = bCa();
      locald.jTZ.a(null);
      locald.jUj = null;
      return;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroyView()
  {
    this.mSq.quit();
    this.mSu.onDetached();
    bCb().onDetached();
    bBZ().b((RecyclerView.m)this.mSD);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    ae.i(TAG, "onPause");
    c(this.mSz, false);
    this.mSv.bBX();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    ae.i(TAG, "onResume");
    this.mSv.bBW();
    Iterator localIterator = this.mSz.iterator();
    label121:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.mSC.containsKey(localObject)) {
          break label121;
        }
        localObject = (String)this.mSC.get(localObject);
        Long localLong = (Long)((Map)this.mSB).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.mSB.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
  public final class b
  {
    volatile int iqd;
    volatile boolean isLoading;
    volatile boolean mSH;
    
    public final boolean bCc()
    {
      return (this.mSH) && (!this.isLoading);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<d>
  {
    public static final c mSJ;
    
    static
    {
      AppMethodBeat.i(51360);
      mSJ = new c();
      AppMethodBeat.o(51360);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements k.a
  {
    d(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51361);
      AppBrandRecommendUILogic.g(this.mSI);
      AppMethodBeat.o(51361);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.q<Integer, LinkedList<csl>, Integer, z>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class h
    implements LoadMoreRecyclerView.a
  {
    h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void bBz()
    {
      AppMethodBeat.i(51366);
      if (AppBrandRecommendUILogic.a(this.mSI).bCc())
      {
        ae.d(AppBrandRecommendUILogic.access$getTAG$cp(), "can load more: let's do fetch");
        AppBrandRecommendUILogic.b(this.mSI);
      }
      AppMethodBeat.o(51366);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.appbrand.ui.recents.g>
  {
    i(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<RecommendRecycleView>
  {
    j(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
  public static final class l
    extends RecyclerView.m
  {
    private boolean mPp;
    private final ArrayList<Integer> mSR;
    private final ArrayList<Integer> mSS;
    
    l()
    {
      AppMethodBeat.i(51372);
      this.mSR = new ArrayList();
      this.mSS = new ArrayList();
      AppMethodBeat.o(51372);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51370);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          paramInt1 = ((LinearLayoutManager)paramRecyclerView).km();
          paramInt2 = ((LinearLayoutManager)paramRecyclerView).ko();
          if ((paramInt1 != 0) || (paramInt2 != 1)) {
            break label146;
          }
          j.b(this.mSI.context, AppBrandRecommendUILogic.d(this.mSI).bBp());
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(51370);
        return;
        paramRecyclerView = null;
        break;
        label146:
        this.mSS.clear();
        if (paramInt1 <= paramInt2)
        {
          if (paramInt1 == 0) {
            j.b(this.mSI.context, AppBrandRecommendUILogic.d(this.mSI).bBp());
          }
          for (;;)
          {
            if (paramInt1 == paramInt2) {
              break label396;
            }
            paramInt1 += 1;
            break;
            paramRecyclerView = this.mSI.bBZ().ci(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.mSS.add(Integer.valueOf(paramInt1));
              if (!this.mSR.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.mSI.bBZ().S(paramRecyclerView);
                ae.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.mSI.mSr.getItemCount())
                {
                  paramRecyclerView = this.mSI.mSr.bBP().get(i);
                  p.g(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (csl)paramRecyclerView;
                  AppBrandRecommendUILogic.f(this.mSI).d(i, paramRecyclerView);
                  this.mSI.mSB.put(paramRecyclerView.mwf, Long.valueOf(System.currentTimeMillis()));
                  this.mSI.mSC.put(Integer.valueOf(paramInt1), paramRecyclerView.mwf);
                  this.mSI.mSz.add(Integer.valueOf(paramInt1));
                }
              }
            }
          }
        }
        label396:
        this.mSI.mSA.clear();
        this.mSR.removeAll((Collection)this.mSS);
        this.mSI.mSA.addAll((Collection)this.mSR);
        this.mSR.clear();
        this.mSR.addAll((Collection)this.mSS);
        this.mSI.mSz.removeAll((Collection)this.mSI.mSA);
        AppBrandRecommendUILogic.a(this.mSI, this.mSI.mSA);
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(51371);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.mPp = bool;
        if (this.mPp) {
          AppBrandRecommendUILogic.f(this.mSI).hP(this.mPp);
        }
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          ((LinearLayoutManager)paramRecyclerView).km();
          int i = ((LinearLayoutManager)paramRecyclerView).ko();
          paramInt = i;
          if (i >= 3) {
            paramInt = i - 1;
          }
          AppBrandRecommendUILogic.c(this.mSI).dMM = paramInt;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(51371);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.m<csl, Integer, z>
  {
    m(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.m<csl, Integer, z>
  {
    n(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.m<csl, Integer, z>
  {
    o(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
  public static final class p {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    q(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class r
    implements k.a
  {
    r(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51377);
      AppBrandRecommendUILogic.g(this.mSI);
      AppMethodBeat.o(51377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */