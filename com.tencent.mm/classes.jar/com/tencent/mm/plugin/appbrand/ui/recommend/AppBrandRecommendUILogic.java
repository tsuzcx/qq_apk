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
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.f;
import d.g.a.q;
import d.g.b.k;
import d.g.b.v.d;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "(Landroid/support/v4/app/FragmentActivity;)V", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic
  implements LifecycleObserver
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a mna = new AppBrandRecommendUILogic.a((byte)0);
  final Context context;
  private final f mmI;
  private final f mmJ;
  private final ao mmK;
  final a mmL;
  final b mmM;
  final LinearLayoutManager mmN;
  final com.tencent.mm.plugin.appbrand.ui.recents.i mmO;
  final h mmP;
  private final f mmQ;
  private final k.a mmR;
  private final k.a mmS;
  final ArrayList<Integer> mmT;
  final ArrayList<Integer> mmU;
  final HashMap<String, Long> mmV;
  final HashMap<Integer, String> mmW;
  final l mmX;
  private final p mmY;
  final FragmentActivity mmZ;
  
  public AppBrandRecommendUILogic(FragmentActivity paramFragmentActivity)
  {
    this.mmZ = paramFragmentActivity;
    paramFragmentActivity = this.mmZ;
    if (paramFragmentActivity == null) {
      throw new d.v("null cannot be cast to non-null type android.content.Context");
    }
    this.context = ((Context)paramFragmentActivity);
    this.mmI = d.g.K((d.g.a.a)new j(this));
    this.mmJ = d.g.K((d.g.a.a)c.mnd);
    this.mmK = new ao("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.mmL = new a((Activity)this.mmZ);
    this.mmM = new b();
    this.mmN = ((LinearLayoutManager)new SmoothScrollLinerLayoutManager(this.context));
    this.mmO = new com.tencent.mm.plugin.appbrand.ui.recents.i(this.mmZ, (ViewGroup)bwZ());
    this.mmP = new h();
    this.mmQ = d.g.K((d.g.a.a)new i(this));
    this.mmR = ((k.a)new d(this));
    this.mmS = ((k.a)new r(this));
    this.mmT = new ArrayList();
    this.mmU = new ArrayList();
    this.mmV = new HashMap();
    this.mmW = new HashMap();
    this.mmX = new l(this);
    this.mmY = new p(this);
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
        if (!this.mmW.containsKey(localInteger)) {
          break label145;
        }
        String str = (String)this.mmW.get(localInteger);
        Long localLong = (Long)((Map)this.mmV).get(str);
        if ((str == null) || (localLong == null)) {
          break;
        }
        long l = System.currentTimeMillis() - localLong.longValue();
        ac.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localInteger, Long.valueOf(l) });
        this.mmP.P(str, l);
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
  
  private final void r(d.g.a.a<y> parama)
  {
    this.mmK.post((Runnable)new AppBrandRecommendUILogic.k(parama));
  }
  
  public abstract String bwN();
  
  public abstract boolean bwO();
  
  public final LoadMoreRecyclerView bwZ()
  {
    return (LoadMoreRecyclerView)this.mmI.getValue();
  }
  
  final d bxa()
  {
    return (d)this.mmJ.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.recents.g bxb()
  {
    return (com.tencent.mm.plugin.appbrand.ui.recents.g)this.mmQ.getValue();
  }
  
  public abstract View getContentView();
  
  final void hG(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    r((d.g.a.a)new e(this, paramBoolean));
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    ac.i(TAG, "onCreate");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    ac.i(TAG, "onDestroy");
    ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).remove(this.mmR);
    com.tencent.mm.plugin.appbrand.app.j.aVu().remove(this.mmS);
    this.mmT.clear();
    this.mmU.clear();
    this.mmV.clear();
    this.mmW.clear();
    this.mmP.qZ(bxa().sessionId);
    d locald = bxa();
    if (!bxa().aZp().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      locald.jwQ = bool;
      bxa().jwR = 0;
      locald = bxa();
      locald.jwL.a(null);
      locald.jwV = null;
      return;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroyView()
  {
    this.mmK.quit();
    this.mmO.onDetached();
    bxb().onDetached();
    bwZ().b((RecyclerView.m)this.mmX);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    ac.i(TAG, "onPause");
    c(this.mmT, false);
    this.mmP.bwX();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    ac.i(TAG, "onResume");
    this.mmP.bwW();
    Iterator localIterator = this.mmT.iterator();
    label121:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.mmW.containsKey(localObject)) {
          break label121;
        }
        localObject = (String)this.mmW.get(localObject);
        Long localLong = (Long)((Map)this.mmV).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.mmV.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
  public final class b
  {
    volatile int hTO;
    volatile boolean isLoading;
    volatile boolean mnb;
    
    public final boolean bxc()
    {
      return (this.mnb) && (!this.isLoading);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<d>
  {
    public static final c mnd;
    
    static
    {
      AppMethodBeat.i(51360);
      mnd = new c();
      AppMethodBeat.o(51360);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements k.a
  {
    d(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51361);
      AppBrandRecommendUILogic.g(this.mnc);
      AppMethodBeat.o(51361);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
  static final class f
    extends d.g.b.l
    implements q<Integer, LinkedList<cmp>, Integer, y>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class h
    implements LoadMoreRecyclerView.a
  {
    h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void bwz()
    {
      AppMethodBeat.i(51366);
      if (AppBrandRecommendUILogic.a(this.mnc).bxc())
      {
        ac.d(AppBrandRecommendUILogic.access$getTAG$cp(), "can load more: let's do fetch");
        AppBrandRecommendUILogic.b(this.mnc);
      }
      AppMethodBeat.o(51366);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.appbrand.ui.recents.g>
  {
    i(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<RecommendRecycleView>
  {
    j(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
  public static final class l
    extends RecyclerView.m
  {
    private boolean mjM;
    private final ArrayList<Integer> mnl;
    private final ArrayList<Integer> mnm;
    
    l()
    {
      AppMethodBeat.i(51372);
      this.mnl = new ArrayList();
      this.mnm = new ArrayList();
      AppMethodBeat.o(51372);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51370);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          paramInt1 = ((LinearLayoutManager)paramRecyclerView).jW();
          paramInt2 = ((LinearLayoutManager)paramRecyclerView).jY();
          if ((paramInt1 != 0) || (paramInt2 != 1)) {
            break label146;
          }
          j.b(this.mnc.context, AppBrandRecommendUILogic.d(this.mnc).bwp());
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
        this.mnm.clear();
        if (paramInt1 <= paramInt2)
        {
          if (paramInt1 == 0) {
            j.b(this.mnc.context, AppBrandRecommendUILogic.d(this.mnc).bwp());
          }
          for (;;)
          {
            if (paramInt1 == paramInt2) {
              break label396;
            }
            paramInt1 += 1;
            break;
            paramRecyclerView = this.mnc.bwZ().ci(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.mnm.add(Integer.valueOf(paramInt1));
              if (!this.mnl.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.mnc.bwZ().S(paramRecyclerView);
                ac.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.mnc.mmL.getItemCount())
                {
                  paramRecyclerView = this.mnc.mmL.bwP().get(i);
                  k.g(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (cmp)paramRecyclerView;
                  AppBrandRecommendUILogic.f(this.mnc).d(i, paramRecyclerView);
                  this.mnc.mmV.put(paramRecyclerView.lRr, Long.valueOf(System.currentTimeMillis()));
                  this.mnc.mmW.put(Integer.valueOf(paramInt1), paramRecyclerView.lRr);
                  this.mnc.mmT.add(Integer.valueOf(paramInt1));
                }
              }
            }
          }
        }
        label396:
        this.mnc.mmU.clear();
        this.mnl.removeAll((Collection)this.mnm);
        this.mnc.mmU.addAll((Collection)this.mnl);
        this.mnl.clear();
        this.mnl.addAll((Collection)this.mnm);
        this.mnc.mmT.removeAll((Collection)this.mnc.mmU);
        AppBrandRecommendUILogic.a(this.mnc, this.mnc.mmU);
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(51371);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.mjM = bool;
        if (this.mjM) {
          AppBrandRecommendUILogic.f(this.mnc).hF(this.mjM);
        }
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          ((LinearLayoutManager)paramRecyclerView).jW();
          int i = ((LinearLayoutManager)paramRecyclerView).jY();
          paramInt = i;
          if (i >= 3) {
            paramInt = i - 1;
          }
          AppBrandRecommendUILogic.c(this.mnc).dzl = paramInt;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(51371);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.m<cmp, Integer, y>
  {
    m(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.m<cmp, Integer, y>
  {
    n(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.m<cmp, Integer, y>
  {
    o(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
  public static final class p {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    q(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class r
    implements k.a
  {
    r(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
    {
      AppMethodBeat.i(51377);
      AppBrandRecommendUILogic.g(this.mnc);
      AppMethodBeat.o(51377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */