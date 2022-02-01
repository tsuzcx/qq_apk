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
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "(Landroid/support/v4/app/FragmentActivity;)V", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic
  implements LifecycleObserver
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a mNC = new AppBrandRecommendUILogic.a((byte)0);
  final Context context;
  private final p mNA;
  final FragmentActivity mNB;
  private final f mNk;
  private final f mNl;
  private final ap mNm;
  final a mNn;
  final b mNo;
  final LinearLayoutManager mNp;
  final com.tencent.mm.plugin.appbrand.ui.recents.i mNq;
  final h mNr;
  private final f mNs;
  private final k.a mNt;
  private final k.a mNu;
  final ArrayList<Integer> mNv;
  final ArrayList<Integer> mNw;
  final HashMap<String, Long> mNx;
  final HashMap<Integer, String> mNy;
  final l mNz;
  
  public AppBrandRecommendUILogic(FragmentActivity paramFragmentActivity)
  {
    this.mNB = paramFragmentActivity;
    paramFragmentActivity = this.mNB;
    if (paramFragmentActivity == null) {
      throw new v("null cannot be cast to non-null type android.content.Context");
    }
    this.context = ((Context)paramFragmentActivity);
    this.mNk = d.g.O((d.g.a.a)new j(this));
    this.mNl = d.g.O((d.g.a.a)c.mNF);
    this.mNm = new ap("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.mNn = new a((Activity)this.mNB);
    this.mNo = new b();
    this.mNp = ((LinearLayoutManager)new SmoothScrollLinerLayoutManager(this.context));
    this.mNq = new com.tencent.mm.plugin.appbrand.ui.recents.i(this.mNB, (ViewGroup)bBf());
    this.mNr = new h();
    this.mNs = d.g.O((d.g.a.a)new i(this));
    this.mNt = ((k.a)new d(this));
    this.mNu = ((k.a)new r(this));
    this.mNv = new ArrayList();
    this.mNw = new ArrayList();
    this.mNx = new HashMap();
    this.mNy = new HashMap();
    this.mNz = new l(this);
    this.mNA = new p(this);
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
        if (!this.mNy.containsKey(localInteger)) {
          break label145;
        }
        String str = (String)this.mNy.get(localInteger);
        Long localLong = (Long)((Map)this.mNx).get(str);
        if ((str == null) || (localLong == null)) {
          break;
        }
        long l = System.currentTimeMillis() - localLong.longValue();
        ad.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localInteger, Long.valueOf(l) });
        this.mNr.W(str, l);
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
  
  private final void s(d.g.a.a<z> parama)
  {
    this.mNm.post((Runnable)new AppBrandRecommendUILogic.k(parama));
  }
  
  public abstract String bAT();
  
  public abstract boolean bAU();
  
  public final LoadMoreRecyclerView bBf()
  {
    return (LoadMoreRecyclerView)this.mNk.getValue();
  }
  
  final d bBg()
  {
    return (d)this.mNl.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.recents.g bBh()
  {
    return (com.tencent.mm.plugin.appbrand.ui.recents.g)this.mNs.getValue();
  }
  
  public abstract View getContentView();
  
  final void hQ(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    s((d.g.a.a)new e(this, paramBoolean));
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
    ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).remove(this.mNt);
    com.tencent.mm.plugin.appbrand.app.j.aYP().remove(this.mNu);
    this.mNv.clear();
    this.mNw.clear();
    this.mNx.clear();
    this.mNy.clear();
    this.mNr.sY(bBg().sessionId);
    d locald = bBg();
    if (!bBg().bcN().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      locald.jQM = bool;
      bBg().jQN = 0;
      locald = bBg();
      locald.jQH.a(null);
      locald.jQR = null;
      return;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroyView()
  {
    this.mNm.quit();
    this.mNq.onDetached();
    bBh().onDetached();
    bBf().b((RecyclerView.m)this.mNz);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    ad.i(TAG, "onPause");
    c(this.mNv, false);
    this.mNr.bBd();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    ad.i(TAG, "onResume");
    this.mNr.bBc();
    Iterator localIterator = this.mNv.iterator();
    label121:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.mNy.containsKey(localObject)) {
          break label121;
        }
        localObject = (String)this.mNy.get(localObject);
        Long localLong = (Long)((Map)this.mNx).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.mNx.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
  public final class b
  {
    volatile int inj;
    volatile boolean isLoading;
    volatile boolean mND;
    
    public final boolean bBi()
    {
      return (this.mND) && (!this.isLoading);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<d>
  {
    public static final c mNF;
    
    static
    {
      AppMethodBeat.i(51360);
      mNF = new c();
      AppMethodBeat.o(51360);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements k.a
  {
    d(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51361);
      AppBrandRecommendUILogic.g(this.mNE);
      AppMethodBeat.o(51361);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.q<Integer, LinkedList<crr>, Integer, z>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class h
    implements LoadMoreRecyclerView.a
  {
    h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void bAF()
    {
      AppMethodBeat.i(51366);
      if (AppBrandRecommendUILogic.a(this.mNE).bBi())
      {
        ad.d(AppBrandRecommendUILogic.access$getTAG$cp(), "can load more: let's do fetch");
        AppBrandRecommendUILogic.b(this.mNE);
      }
      AppMethodBeat.o(51366);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.appbrand.ui.recents.g>
  {
    i(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<RecommendRecycleView>
  {
    j(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
  public static final class l
    extends RecyclerView.m
  {
    private boolean mKn;
    private final ArrayList<Integer> mNN;
    private final ArrayList<Integer> mNO;
    
    l()
    {
      AppMethodBeat.i(51372);
      this.mNN = new ArrayList();
      this.mNO = new ArrayList();
      AppMethodBeat.o(51372);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51370);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
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
          j.b(this.mNE.context, AppBrandRecommendUILogic.d(this.mNE).bAv());
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
        this.mNO.clear();
        if (paramInt1 <= paramInt2)
        {
          if (paramInt1 == 0) {
            j.b(this.mNE.context, AppBrandRecommendUILogic.d(this.mNE).bAv());
          }
          for (;;)
          {
            if (paramInt1 == paramInt2) {
              break label396;
            }
            paramInt1 += 1;
            break;
            paramRecyclerView = this.mNE.bBf().ci(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.mNO.add(Integer.valueOf(paramInt1));
              if (!this.mNN.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.mNE.bBf().S(paramRecyclerView);
                ad.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.mNE.mNn.getItemCount())
                {
                  paramRecyclerView = this.mNE.mNn.bAV().get(i);
                  p.g(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (crr)paramRecyclerView;
                  AppBrandRecommendUILogic.f(this.mNE).d(i, paramRecyclerView);
                  this.mNE.mNx.put(paramRecyclerView.mrh, Long.valueOf(System.currentTimeMillis()));
                  this.mNE.mNy.put(Integer.valueOf(paramInt1), paramRecyclerView.mrh);
                  this.mNE.mNv.add(Integer.valueOf(paramInt1));
                }
              }
            }
          }
        }
        label396:
        this.mNE.mNw.clear();
        this.mNN.removeAll((Collection)this.mNO);
        this.mNE.mNw.addAll((Collection)this.mNN);
        this.mNN.clear();
        this.mNN.addAll((Collection)this.mNO);
        this.mNE.mNv.removeAll((Collection)this.mNE.mNw);
        AppBrandRecommendUILogic.a(this.mNE, this.mNE.mNw);
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(51371);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.mKn = bool;
        if (this.mKn) {
          AppBrandRecommendUILogic.f(this.mNE).hP(this.mKn);
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
          AppBrandRecommendUILogic.c(this.mNE).dLx = paramInt;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(51371);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.m<crr, Integer, z>
  {
    m(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.m<crr, Integer, z>
  {
    n(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.m<crr, Integer, z>
  {
    o(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
  public static final class p {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    q(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class r
    implements k.a
  {
    r(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51377);
      AppBrandRecommendUILogic.g(this.mNE);
      AppMethodBeat.o(51377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */