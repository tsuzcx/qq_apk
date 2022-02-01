package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.protocal.protobuf.dud;
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
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroidx/lifecycle/LifecycleObserver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroidx/recyclerview/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic
  implements k
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a rhu = new AppBrandRecommendUILogic.a((byte)0);
  final Context context;
  private final f rhc;
  private final f rhd;
  private final MMHandler rhe;
  final a rhf;
  final b rhg;
  final LinearLayoutManager rhh;
  final com.tencent.mm.plugin.appbrand.ui.recents.i rhi;
  final h rhj;
  private final f rhk;
  private final MStorage.IOnStorageChange rhl;
  private final MStorage.IOnStorageChange rhm;
  final ArrayList<Integer> rhn;
  final ArrayList<Integer> rho;
  final HashMap<String, Long> rhp;
  final HashMap<Integer, String> rhq;
  final l rhr;
  private final p rhs;
  final FragmentActivity rht;
  
  public AppBrandRecommendUILogic(FragmentActivity paramFragmentActivity)
  {
    this.rht = paramFragmentActivity;
    paramFragmentActivity = this.rht;
    if (paramFragmentActivity == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.content.Context");
    }
    this.context = ((Context)paramFragmentActivity);
    this.rhc = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.rhd = kotlin.g.ar((kotlin.g.a.a)c.rhx);
    this.rhe = new MMHandler("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.rhf = new a((Activity)this.rht);
    this.rhg = new b();
    this.rhh = ((LinearLayoutManager)new SmoothScrollLinerLayoutManager(this.context));
    this.rhi = new com.tencent.mm.plugin.appbrand.ui.recents.i(this.rht, (ViewGroup)clL());
    this.rhj = new h();
    this.rhk = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.rhl = ((MStorage.IOnStorageChange)new d(this));
    this.rhm = ((MStorage.IOnStorageChange)new r(this));
    this.rhn = new ArrayList();
    this.rho = new ArrayList();
    this.rhp = new HashMap();
    this.rhq = new HashMap();
    this.rhr = new l(this);
    this.rhs = new p(this);
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
        if (!this.rhq.containsKey(localInteger)) {
          break label145;
        }
        String str = (String)this.rhq.get(localInteger);
        Long localLong = (Long)((Map)this.rhp).get(str);
        if ((str == null) || (localLong == null)) {
          break;
        }
        long l = System.currentTimeMillis() - localLong.longValue();
        Log.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localInteger, Long.valueOf(l) });
        this.rhj.W(str, l);
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
  
  private final void u(kotlin.g.a.a<x> parama)
  {
    this.rhe.post((Runnable)new AppBrandRecommendUILogic.k(parama));
  }
  
  public final LoadMoreRecyclerView clL()
  {
    return (LoadMoreRecyclerView)this.rhc.getValue();
  }
  
  final d clM()
  {
    return (d)this.rhd.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.recents.g clN()
  {
    return (com.tencent.mm.plugin.appbrand.ui.recents.g)this.rhk.getValue();
  }
  
  public abstract String clx();
  
  public abstract boolean cly();
  
  public abstract View getContentView();
  
  final void jS(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    u((kotlin.g.a.a)new e(this, paramBoolean));
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_CREATE)
  public final void onCreate()
  {
    Log.i(TAG, "onCreate");
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_DESTROY)
  public final void onDestroy()
  {
    Log.i(TAG, "onDestroy");
    ((u)com.tencent.mm.plugin.appbrand.app.m.W(u.class)).remove(this.rhl);
    com.tencent.mm.plugin.appbrand.app.m.bFF().remove(this.rhm);
    this.rhn.clear();
    this.rho.clear();
    this.rhp.clear();
    this.rhq.clear();
    this.rhj.HE(clM().sessionId);
    d locald = clM();
    if (!clM().bJY().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      locald.nRm = bool;
      clM().nRn = 0;
      locald = clM();
      locald.nRh.a(null);
      locald.nRr = null;
      return;
    }
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_DESTROY)
  public final void onDestroyView()
  {
    this.rhe.quit();
    this.rhi.cfy();
    clN().cfy();
    clL().b((RecyclerView.l)this.rhr);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_PAUSE)
  public final void onPause()
  {
    Log.i(TAG, "onPause");
    c(this.rhn, false);
    this.rhj.clJ();
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_RESUME)
  public final void onResume()
  {
    Log.i(TAG, "onResume");
    this.rhj.clI();
    Iterator localIterator = this.rhn.iterator();
    label121:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.rhq.containsKey(localObject)) {
          break label121;
        }
        localObject = (String)this.rhq.get(localObject);
        Long localLong = (Long)((Map)this.rhp).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.rhp.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
  public final class b
  {
    volatile boolean isLoading;
    volatile int page;
    volatile boolean rhv;
    
    public final boolean clO()
    {
      return (this.rhv) && (!this.isLoading);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<d>
  {
    public static final c rhx;
    
    static
    {
      AppMethodBeat.i(51360);
      rhx = new c();
      AppMethodBeat.o(51360);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements MStorage.IOnStorageChange
  {
    d(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(51361);
      AppBrandRecommendUILogic.g(this.rhw);
      AppMethodBeat.o(51361);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, LinkedList<dud>, Integer, x>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class h
    implements LoadMoreRecyclerView.a
  {
    h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void clj()
    {
      AppMethodBeat.i(247598);
      if (AppBrandRecommendUILogic.a(this.rhw).clO())
      {
        Log.d(AppBrandRecommendUILogic.access$getTAG$cp(), "can load more: let's do fetch");
        AppBrandRecommendUILogic.b(this.rhw);
      }
      AppMethodBeat.o(247598);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.ui.recents.g>
  {
    i(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RecommendRecycleView>
  {
    j(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
  public static final class l
    extends RecyclerView.l
  {
    private boolean rdZ;
    private final ArrayList<Integer> rhF;
    private final ArrayList<Integer> rhG;
    
    l()
    {
      AppMethodBeat.i(51372);
      this.rhF = new ArrayList();
      this.rhG = new ArrayList();
      AppMethodBeat.o(51372);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(269022);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.rdZ = bool;
        if (this.rdZ) {
          AppBrandRecommendUILogic.f(this.rhw).jR(this.rdZ);
        }
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          ((LinearLayoutManager)paramRecyclerView).kJ();
          int i = ((LinearLayoutManager)paramRecyclerView).kL();
          paramInt = i;
          if (i >= 3) {
            paramInt = i - 1;
          }
          AppBrandRecommendUILogic.c(this.rhw).fYT = paramInt;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(269022);
        return;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(269021);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          paramInt1 = ((LinearLayoutManager)paramRecyclerView).kJ();
          paramInt2 = ((LinearLayoutManager)paramRecyclerView).kL();
          if ((paramInt1 != 0) || (paramInt2 != 1)) {
            break label146;
          }
          j.b(this.rhw.context, AppBrandRecommendUILogic.d(this.rhw).getItemView());
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(269021);
        return;
        paramRecyclerView = null;
        break;
        label146:
        this.rhG.clear();
        if (paramInt1 <= paramInt2)
        {
          if (paramInt1 == 0) {
            j.b(this.rhw.context, AppBrandRecommendUILogic.d(this.rhw).getItemView());
          }
          for (;;)
          {
            if (paramInt1 == paramInt2) {
              break label396;
            }
            paramInt1 += 1;
            break;
            paramRecyclerView = this.rhw.clL().cK(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.rhG.add(Integer.valueOf(paramInt1));
              if (!this.rhF.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.rhw.clL().U(paramRecyclerView);
                Log.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.rhw.rhf.getItemCount())
                {
                  paramRecyclerView = this.rhw.rhf.clz().get(i);
                  p.j(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (dud)paramRecyclerView;
                  AppBrandRecommendUILogic.f(this.rhw).d(i, paramRecyclerView);
                  this.rhw.rhp.put(paramRecyclerView.qJp, Long.valueOf(System.currentTimeMillis()));
                  this.rhw.rhq.put(Integer.valueOf(paramInt1), paramRecyclerView.qJp);
                  this.rhw.rhn.add(Integer.valueOf(paramInt1));
                }
              }
            }
          }
        }
        label396:
        this.rhw.rho.clear();
        this.rhF.removeAll((Collection)this.rhG);
        this.rhw.rho.addAll((Collection)this.rhF);
        this.rhF.clear();
        this.rhF.addAll((Collection)this.rhG);
        this.rhw.rhn.removeAll((Collection)this.rhw.rho);
        AppBrandRecommendUILogic.a(this.rhw, this.rhw.rho);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.m<dud, Integer, x>
  {
    m(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.m<dud, Integer, x>
  {
    n(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.m<dud, Integer, x>
  {
    o(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
  public static final class p {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    q(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class r
    implements MStorage.IOnStorageChange
  {
    r(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(51377);
      AppBrandRecommendUILogic.g(this.rhw);
      AppMethodBeat.o(51377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */