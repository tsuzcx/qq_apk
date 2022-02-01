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
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.f;
import d.g.a.q;
import d.g.b.k;
import d.g.b.v.c;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "(Landroid/support/v4/app/FragmentActivity;)V", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic
  implements LifecycleObserver
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a lLd = new AppBrandRecommendUILogic.a((byte)0);
  final Context context;
  private final f lKL;
  private final f lKM;
  private final ap lKN;
  final a lKO;
  final b lKP;
  final LinearLayoutManager lKQ;
  final com.tencent.mm.plugin.appbrand.ui.recents.i lKR;
  final h lKS;
  private final f lKT;
  private final k.a lKU;
  private final k.a lKV;
  final ArrayList<Integer> lKW;
  final ArrayList<Integer> lKX;
  final HashMap<String, Long> lKY;
  final HashMap<Integer, String> lKZ;
  final l lLa;
  private final p lLb;
  final FragmentActivity lLc;
  
  public AppBrandRecommendUILogic(FragmentActivity paramFragmentActivity)
  {
    this.lLc = paramFragmentActivity;
    paramFragmentActivity = this.lLc;
    if (paramFragmentActivity == null) {
      throw new d.v("null cannot be cast to non-null type android.content.Context");
    }
    this.context = ((Context)paramFragmentActivity);
    this.lKL = d.g.E((d.g.a.a)new j(this));
    this.lKM = d.g.E((d.g.a.a)c.lLg);
    this.lKN = new ap("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.lKO = new a((Activity)this.lLc);
    this.lKP = new b();
    this.lKQ = ((LinearLayoutManager)new SmoothScrollLinerLayoutManager(this.context));
    this.lKR = new com.tencent.mm.plugin.appbrand.ui.recents.i(this.lLc, (ViewGroup)bqc());
    this.lKS = new h();
    this.lKT = d.g.E((d.g.a.a)new i(this));
    this.lKU = ((k.a)new d(this));
    this.lKV = ((k.a)new r(this));
    this.lKW = new ArrayList();
    this.lKX = new ArrayList();
    this.lKY = new HashMap();
    this.lKZ = new HashMap();
    this.lLa = new l(this);
    this.lLb = new p(this);
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
        if (!this.lKZ.containsKey(localInteger)) {
          break label145;
        }
        String str = (String)this.lKZ.get(localInteger);
        Long localLong = (Long)((Map)this.lKY).get(str);
        if ((str == null) || (localLong == null)) {
          break;
        }
        long l = System.currentTimeMillis() - localLong.longValue();
        ad.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localInteger, Long.valueOf(l) });
        this.lKS.O(str, l);
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
  
  private final void n(d.g.a.a<y> parama)
  {
    this.lKN.post((Runnable)new AppBrandRecommendUILogic.k(parama));
  }
  
  public abstract String bpQ();
  
  public abstract boolean bpR();
  
  public final LoadMoreRecyclerView bqc()
  {
    return (LoadMoreRecyclerView)this.lKL.getValue();
  }
  
  final d bqd()
  {
    return (d)this.lKM.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.recents.g bqe()
  {
    return (com.tencent.mm.plugin.appbrand.ui.recents.g)this.lKT.getValue();
  }
  
  public abstract View getContentView();
  
  final void hj(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    n((d.g.a.a)new e(this, paramBoolean));
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    ad.i(TAG, "onCreate");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    ad.i(TAG, "onDestroy");
    ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).remove(this.lKU);
    com.tencent.mm.plugin.appbrand.app.j.aOC().remove(this.lKV);
    this.lKW.clear();
    this.lKX.clear();
    this.lKY.clear();
    this.lKZ.clear();
    this.lKS.nn(bqd().sessionId);
    d locald = bqd();
    if (!bqd().aSs().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      locald.iWA = bool;
      bqd().iWB = 0;
      locald = bqd();
      locald.iWv.a(null);
      locald.iWF = null;
      return;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroyView()
  {
    this.lKN.quit();
    this.lKR.onDetached();
    bqe().onDetached();
    bqc().b((RecyclerView.m)this.lLa);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    ad.i(TAG, "onPause");
    c(this.lKW, false);
    this.lKS.bqa();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    ad.i(TAG, "onResume");
    this.lKS.bpZ();
    Iterator localIterator = this.lKW.iterator();
    label121:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.lKZ.containsKey(localObject)) {
          break label121;
        }
        localObject = (String)this.lKZ.get(localObject);
        Long localLong = (Long)((Map)this.lKY).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.lKY.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
  public final class b
  {
    volatile int htm;
    volatile boolean isLoading;
    volatile boolean lLe;
    
    public final boolean bqf()
    {
      return (this.lLe) && (!this.isLoading);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<d>
  {
    public static final c lLg;
    
    static
    {
      AppMethodBeat.i(51360);
      lLg = new c();
      AppMethodBeat.o(51360);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements k.a
  {
    d(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51361);
      AppBrandRecommendUILogic.g(this.lLf);
      AppMethodBeat.o(51361);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
  static final class f
    extends d.g.b.l
    implements q<Integer, LinkedList<chm>, Integer, y>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class h
    implements LoadMoreRecyclerView.a
  {
    h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void bpD()
    {
      AppMethodBeat.i(51366);
      if (AppBrandRecommendUILogic.a(this.lLf).bqf())
      {
        ad.d(AppBrandRecommendUILogic.access$getTAG$cp(), "can load more: let's do fetch");
        AppBrandRecommendUILogic.b(this.lLf);
      }
      AppMethodBeat.o(51366);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.appbrand.ui.recents.g>
  {
    i(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<RecommendRecycleView>
  {
    j(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
  public static final class l
    extends RecyclerView.m
  {
    private boolean lHR;
    private final ArrayList<Integer> lLo;
    private final ArrayList<Integer> lLp;
    
    l()
    {
      AppMethodBeat.i(51372);
      this.lLo = new ArrayList();
      this.lLp = new ArrayList();
      AppMethodBeat.o(51372);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51370);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          paramInt1 = ((LinearLayoutManager)paramRecyclerView).jO();
          paramInt2 = ((LinearLayoutManager)paramRecyclerView).jQ();
          if ((paramInt1 != 0) || (paramInt2 != 1)) {
            break label146;
          }
          j.b(this.lLf.context, AppBrandRecommendUILogic.d(this.lLf).bpu());
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
        this.lLp.clear();
        if (paramInt1 <= paramInt2)
        {
          if (paramInt1 == 0) {
            j.b(this.lLf.context, AppBrandRecommendUILogic.d(this.lLf).bpu());
          }
          for (;;)
          {
            if (paramInt1 == paramInt2) {
              break label396;
            }
            paramInt1 += 1;
            break;
            paramRecyclerView = this.lLf.bqc().cj(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.lLp.add(Integer.valueOf(paramInt1));
              if (!this.lLo.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.lLf.bqc().S(paramRecyclerView);
                ad.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.lLf.lKO.getItemCount())
                {
                  paramRecyclerView = this.lLf.lKO.bpS().get(i);
                  k.g(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (chm)paramRecyclerView;
                  AppBrandRecommendUILogic.f(this.lLf).d(i, paramRecyclerView);
                  this.lLf.lKY.put(paramRecyclerView.lpv, Long.valueOf(System.currentTimeMillis()));
                  this.lLf.lKZ.put(Integer.valueOf(paramInt1), paramRecyclerView.lpv);
                  this.lLf.lKW.add(Integer.valueOf(paramInt1));
                }
              }
            }
          }
        }
        label396:
        this.lLf.lKX.clear();
        this.lLo.removeAll((Collection)this.lLp);
        this.lLf.lKX.addAll((Collection)this.lLo);
        this.lLo.clear();
        this.lLo.addAll((Collection)this.lLp);
        this.lLf.lKW.removeAll((Collection)this.lLf.lKX);
        AppBrandRecommendUILogic.a(this.lLf, this.lLf.lKX);
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(51371);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.lHR = bool;
        if (this.lHR) {
          AppBrandRecommendUILogic.f(this.lLf).hi(this.lHR);
        }
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          ((LinearLayoutManager)paramRecyclerView).jO();
          int i = ((LinearLayoutManager)paramRecyclerView).jQ();
          paramInt = i;
          if (i >= 3) {
            paramInt = i - 1;
          }
          AppBrandRecommendUILogic.c(this.lLf).dBx = paramInt;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(51371);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.m<chm, Integer, y>
  {
    m(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.m<chm, Integer, y>
  {
    n(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.m<chm, Integer, y>
  {
    o(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
  public static final class p {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    q(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class r
    implements k.a
  {
    r(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51377);
      AppBrandRecommendUILogic.g(this.lLf);
      AppMethodBeat.o(51377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */