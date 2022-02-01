package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "(Landroid/support/v4/app/FragmentActivity;)V", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic
  implements LifecycleObserver
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a ofJ = new AppBrandRecommendUILogic.a((byte)0);
  final Context context;
  private final MStorage.IOnStorageChange ofA;
  private final MStorage.IOnStorageChange ofB;
  final ArrayList<Integer> ofC;
  final ArrayList<Integer> ofD;
  final HashMap<String, Long> ofE;
  final HashMap<Integer, String> ofF;
  final l ofG;
  private final p ofH;
  final FragmentActivity ofI;
  private final f ofr;
  private final f ofs;
  private final MMHandler oft;
  final a ofu;
  final b ofv;
  final LinearLayoutManager ofw;
  final com.tencent.mm.plugin.appbrand.ui.recents.i ofx;
  final h ofy;
  private final f ofz;
  
  public AppBrandRecommendUILogic(FragmentActivity paramFragmentActivity)
  {
    this.ofI = paramFragmentActivity;
    paramFragmentActivity = this.ofI;
    if (paramFragmentActivity == null) {
      throw new t("null cannot be cast to non-null type android.content.Context");
    }
    this.context = ((Context)paramFragmentActivity);
    this.ofr = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.ofs = kotlin.g.ah((kotlin.g.a.a)c.ofM);
    this.oft = new MMHandler("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.ofu = new a((Activity)this.ofI);
    this.ofv = new b();
    this.ofw = ((LinearLayoutManager)new SmoothScrollLinerLayoutManager(this.context));
    this.ofx = new com.tencent.mm.plugin.appbrand.ui.recents.i(this.ofI, (ViewGroup)bZc());
    this.ofy = new h();
    this.ofz = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.ofA = ((MStorage.IOnStorageChange)new d(this));
    this.ofB = ((MStorage.IOnStorageChange)new r(this));
    this.ofC = new ArrayList();
    this.ofD = new ArrayList();
    this.ofE = new HashMap();
    this.ofF = new HashMap();
    this.ofG = new l(this);
    this.ofH = new p(this);
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
        if (!this.ofF.containsKey(localInteger)) {
          break label145;
        }
        String str = (String)this.ofF.get(localInteger);
        Long localLong = (Long)((Map)this.ofE).get(str);
        if ((str == null) || (localLong == null)) {
          break;
        }
        long l = System.currentTimeMillis() - localLong.longValue();
        Log.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localInteger, Long.valueOf(l) });
        this.ofy.W(str, l);
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
  
  private final void v(kotlin.g.a.a<x> parama)
  {
    this.oft.post((Runnable)new AppBrandRecommendUILogic.k(parama));
  }
  
  public abstract String bYN();
  
  public abstract boolean bYO();
  
  public final LoadMoreRecyclerView bZc()
  {
    return (LoadMoreRecyclerView)this.ofr.getValue();
  }
  
  final d bZd()
  {
    return (d)this.ofs.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.recents.g bZe()
  {
    return (com.tencent.mm.plugin.appbrand.ui.recents.g)this.ofz.getValue();
  }
  
  public abstract View getContentView();
  
  final void iV(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    v((kotlin.g.a.a)new e(this, paramBoolean));
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    Log.i(TAG, "onCreate");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    Log.i(TAG, "onDestroy");
    ((u)n.W(u.class)).remove(this.ofA);
    n.buC().remove(this.ofB);
    this.ofC.clear();
    this.ofD.clear();
    this.ofE.clear();
    this.ofF.clear();
    this.ofy.Br(bZd().sessionId);
    d locald = bZd();
    if (!bZd().byK().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      locald.kXa = bool;
      bZd().kXb = 0;
      locald = bZd();
      locald.kWV.a(null);
      locald.kXf = null;
      return;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroyView()
  {
    this.oft.quit();
    this.ofx.onDetached();
    bZe().onDetached();
    bZc().b((RecyclerView.l)this.ofG);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    Log.i(TAG, "onPause");
    c(this.ofC, false);
    this.ofy.bZa();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    Log.i(TAG, "onResume");
    this.ofy.bYZ();
    Iterator localIterator = this.ofC.iterator();
    label121:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.ofF.containsKey(localObject)) {
          break label121;
        }
        localObject = (String)this.ofF.get(localObject);
        Long localLong = (Long)((Map)this.ofE).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.ofE.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
  public final class b
  {
    volatile boolean isLoading;
    volatile int jlo;
    volatile boolean ofK;
    
    public final boolean bZf()
    {
      return (this.ofK) && (!this.isLoading);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<d>
  {
    public static final c ofM;
    
    static
    {
      AppMethodBeat.i(51360);
      ofM = new c();
      AppMethodBeat.o(51360);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements MStorage.IOnStorageChange
  {
    d(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(51361);
      AppBrandRecommendUILogic.g(this.ofL);
      AppMethodBeat.o(51361);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, LinkedList<dko>, Integer, x>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class h
    implements LoadMoreRecyclerView.a
  {
    h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void bYy()
    {
      AppMethodBeat.i(51366);
      if (AppBrandRecommendUILogic.a(this.ofL).bZf())
      {
        Log.d(AppBrandRecommendUILogic.access$getTAG$cp(), "can load more: let's do fetch");
        AppBrandRecommendUILogic.b(this.ofL);
      }
      AppMethodBeat.o(51366);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.ui.recents.g>
  {
    i(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RecommendRecycleView>
  {
    j(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
  public static final class l
    extends RecyclerView.l
  {
    private boolean ocr;
    private final ArrayList<Integer> ofU;
    private final ArrayList<Integer> ofV;
    
    l()
    {
      AppMethodBeat.i(51372);
      this.ofU = new ArrayList();
      this.ofV = new ArrayList();
      AppMethodBeat.o(51372);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(51371);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.ocr = bool;
        if (this.ocr) {
          AppBrandRecommendUILogic.f(this.ofL).iU(this.ocr);
        }
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          ((LinearLayoutManager)paramRecyclerView).ks();
          int i = ((LinearLayoutManager)paramRecyclerView).ku();
          paramInt = i;
          if (i >= 3) {
            paramInt = i - 1;
          }
          AppBrandRecommendUILogic.c(this.ofL).eeE = paramInt;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(51371);
        return;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51370);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          paramInt1 = ((LinearLayoutManager)paramRecyclerView).ks();
          paramInt2 = ((LinearLayoutManager)paramRecyclerView).ku();
          if ((paramInt1 != 0) || (paramInt2 != 1)) {
            break label146;
          }
          j.b(this.ofL.context, AppBrandRecommendUILogic.d(this.ofL).bYp());
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
        this.ofV.clear();
        if (paramInt1 <= paramInt2)
        {
          if (paramInt1 == 0) {
            j.b(this.ofL.context, AppBrandRecommendUILogic.d(this.ofL).bYp());
          }
          for (;;)
          {
            if (paramInt1 == paramInt2) {
              break label396;
            }
            paramInt1 += 1;
            break;
            paramRecyclerView = this.ofL.bZc().ch(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.ofV.add(Integer.valueOf(paramInt1));
              if (!this.ofU.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.ofL.bZc().U(paramRecyclerView);
                Log.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.ofL.ofu.getItemCount())
                {
                  paramRecyclerView = this.ofL.ofu.bYP().get(i);
                  p.g(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (dko)paramRecyclerView;
                  AppBrandRecommendUILogic.f(this.ofL).d(i, paramRecyclerView);
                  this.ofL.ofE.put(paramRecyclerView.nHd, Long.valueOf(System.currentTimeMillis()));
                  this.ofL.ofF.put(Integer.valueOf(paramInt1), paramRecyclerView.nHd);
                  this.ofL.ofC.add(Integer.valueOf(paramInt1));
                }
              }
            }
          }
        }
        label396:
        this.ofL.ofD.clear();
        this.ofU.removeAll((Collection)this.ofV);
        this.ofL.ofD.addAll((Collection)this.ofU);
        this.ofU.clear();
        this.ofU.addAll((Collection)this.ofV);
        this.ofL.ofC.removeAll((Collection)this.ofL.ofD);
        AppBrandRecommendUILogic.a(this.ofL, this.ofL.ofD);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements m<dko, Integer, x>
  {
    m(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements m<dko, Integer, x>
  {
    n(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements m<dko, Integer, x>
  {
    o(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
  public static final class p {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    q(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class r
    implements MStorage.IOnStorageChange
  {
    r(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(51377);
      AppBrandRecommendUILogic.g(this.ofL);
      AppMethodBeat.o(51377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */