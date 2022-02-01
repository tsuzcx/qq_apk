package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.plugin.appbrand.ui.recents.f;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.enb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroidx/lifecycle/LifecycleObserver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroidx/recyclerview/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class AppBrandRecommendUILogic
  implements p
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a uoY = new AppBrandRecommendUILogic.a((byte)0);
  final Context context;
  final FragmentActivity uoZ;
  private final kotlin.j upa;
  private final kotlin.j upb;
  private final MMHandler upc;
  final a upd;
  private final b upe;
  private final LinearLayoutManager upf;
  private final com.tencent.mm.plugin.appbrand.ui.recents.h upg;
  private final h uph;
  private final kotlin.j upi;
  private final MStorage.IOnStorageChange upj;
  private final MStorage.IOnStorageChange upk;
  final ArrayList<Integer> upl;
  final ArrayList<Integer> upm;
  final HashMap<String, Long> upn;
  final HashMap<Integer, String> upo;
  private final h upp;
  private final l upq;
  
  public AppBrandRecommendUILogic(FragmentActivity paramFragmentActivity)
  {
    this.uoZ = paramFragmentActivity;
    this.context = ((Context)this.uoZ);
    this.upa = k.cm((kotlin.g.a.a)new g(this));
    this.upb = k.cm((kotlin.g.a.a)c.upt);
    this.upc = new MMHandler("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.upd = new a((Activity)this.uoZ);
    this.upe = new b();
    this.upf = ((LinearLayoutManager)new SmoothScrollLinerLayoutManager(this.context));
    this.upg = new com.tencent.mm.plugin.appbrand.ui.recents.h(this.uoZ, (ViewGroup)cNd());
    this.uph = new h();
    this.upi = k.cm((kotlin.g.a.a)new f(this));
    this.upj = new AppBrandRecommendUILogic..ExternalSyntheticLambda2(this);
    this.upk = new AppBrandRecommendUILogic..ExternalSyntheticLambda3(this);
    this.upl = new ArrayList();
    this.upm = new ArrayList();
    this.upn = new HashMap();
    this.upo = new HashMap();
    this.upp = new h(this);
    this.upq = new l(this);
  }
  
  private static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    s.u(paramAppBrandRecommendUILogic, "this$0");
    if (paramAppBrandRecommendUILogic.upe.getCanLoadMore())
    {
      Log.d(TAG, "can load more: let's do fetch");
      paramAppBrandRecommendUILogic.lb(false);
    }
  }
  
  private static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, String paramString, MStorageEventData paramMStorageEventData)
  {
    s.u(paramAppBrandRecommendUILogic, "this$0");
    paramAppBrandRecommendUILogic.cNg();
  }
  
  private final void am(kotlin.g.a.a<ah> parama)
  {
    this.upc.post(new AppBrandRecommendUILogic..ExternalSyntheticLambda4(parama));
  }
  
  private static final void aw(kotlin.g.a.a parama)
  {
    s.u(parama, "$action");
    parama.invoke();
  }
  
  private static final void b(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, String paramString, MStorageEventData paramMStorageEventData)
  {
    s.u(paramAppBrandRecommendUILogic, "this$0");
    paramAppBrandRecommendUILogic.cNg();
  }
  
  private final void c(ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    Iterator localIterator = paramArrayList.iterator();
    label196:
    while (localIterator.hasNext())
    {
      Object localObject1 = (Integer)localIterator.next();
      if (localObject1 == null) {}
      for (;;)
      {
        if (!this.upo.containsKey(localObject1)) {
          break label196;
        }
        String str = (String)this.upo.get(localObject1);
        Object localObject2 = (Long)((Map)this.upn).get(str);
        if ((str == null) || (localObject2 == null)) {
          break;
        }
        long l = System.currentTimeMillis() - ((Long)localObject2).longValue();
        Log.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localObject1, Long.valueOf(l) });
        localObject1 = this.uph;
        if (!((h)localObject1).uoV.containsKey(str)) {
          break;
        }
        localObject2 = (aot)((h)localObject1).uoV.get(str);
        ((aot)localObject2).ZvW = ((int)(l + ((aot)localObject2).ZvW));
        ((h)localObject1).uoV.put(str, localObject2);
        break;
        if (((Integer)localObject1).intValue() == 0) {
          break;
        }
      }
    }
    if (paramBoolean) {
      paramArrayList.clear();
    }
  }
  
  private final d cNe()
  {
    return (d)this.upb.getValue();
  }
  
  private final void cNg()
  {
    i.a(this, (kotlin.g.a.a)new m(this));
  }
  
  private static final boolean dN(View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    return true;
  }
  
  private final void lb(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    am((kotlin.g.a.a)new d(this, paramBoolean));
  }
  
  public abstract String cMU();
  
  public abstract boolean cMV();
  
  public final LoadMoreRecyclerView cNd()
  {
    return (LoadMoreRecyclerView)this.upa.getValue();
  }
  
  public final f cNf()
  {
    return (f)this.upi.getValue();
  }
  
  public abstract View getContentView();
  
  public final void initView()
  {
    boolean bool2 = true;
    cNd().setLayoutManager((RecyclerView.LayoutManager)this.upf);
    ((FrameLayout)getContentView()).addView((View)cNd(), new ViewGroup.LayoutParams(-1, -1));
    this.upd.bf(true);
    Object localObject1 = this.upd;
    Object localObject2 = (m)new i(this);
    s.u(localObject2, "<set-?>");
    ((a)localObject1).uor = ((m)localObject2);
    localObject1 = this.upd;
    localObject2 = (m)new j(this);
    s.u(localObject2, "<set-?>");
    ((a)localObject1).uot = ((m)localObject2);
    localObject1 = this.upd;
    localObject2 = (m)new k(this);
    s.u(localObject2, "<set-?>");
    ((a)localObject1).uos = ((m)localObject2);
    cNd().setAdapter((RecyclerView.a)this.upd);
    if (cMV())
    {
      cNd().ev(this.upg.tth);
      localObject1 = this.upg.tth;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      this.upg.iR();
      this.upg.Dt(0);
      this.upg.Du(0);
    }
    localObject1 = LayoutInflater.from(this.context).inflate(ba.g.app_brand_recommend_list_header_view, (ViewGroup)cNd(), false);
    cNd().ev((View)localObject1);
    localObject2 = ((View)localObject1).findViewById(ba.f.header_view_tv);
    if (localObject2 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
    ((TextView)localObject2).setText((CharSequence)cMU());
    ((View)localObject1).setOnLongClickListener(AppBrandRecommendUILogic..ExternalSyntheticLambda0.INSTANCE);
    cNd().setLoadingView(cNf().caK);
    i.a(this, false);
    i.b(this, false);
    cNf();
    localObject1 = cNf();
    int i = ba.c.transparent;
    if (((f)localObject1).une != null) {
      ((f)localObject1).une.setBackgroundResource(i);
    }
    this.upe.oUl = cNe().qQZ;
    localObject1 = this.upe;
    if (cNe().qQY > 0)
    {
      bool1 = true;
      ((b)localObject1).upr = bool1;
      cNe().qRf = ((q)new e(this));
      if ((cNe().cjz().isEmpty()) || (!cNe().qRa)) {
        break label514;
      }
    }
    label514:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      lb(bool1);
      if (!bool1) {
        g.Dy(2);
      }
      cNd().setOnLoadingStateChangedListener(new AppBrandRecommendUILogic..ExternalSyntheticLambda1(this));
      cNd().a((RecyclerView.l)this.upp);
      this.uph.cNb();
      this.upd.bZE.notifyChanged();
      return;
      bool1 = false;
      break;
    }
  }
  
  @z(Ho=j.a.ON_CREATE)
  public final void onCreate()
  {
    Log.i(TAG, "onCreate");
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    Log.i(TAG, "onDestroy");
    ((t)n.ag(t.class)).remove(this.upj);
    n.cfc().remove(this.upk);
    this.upl.clear();
    this.upm.clear();
    this.upn.clear();
    this.upo.clear();
    Object localObject = this.uph;
    long l2 = cNe().sessionId;
    int i;
    if (((h)localObject).uoW.size() == 0) {
      if (((h)localObject).uoV.size() > 0)
      {
        i = 1;
        if (i != 0) {
          break label179;
        }
        Log.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        localObject = cNe();
        if (cNe().cjz().isEmpty()) {
          break label402;
        }
      }
    }
    label397:
    label402:
    for (boolean bool = true;; bool = false)
    {
      ((d)localObject).qRa = bool;
      cNe().qRb = 0;
      localObject = cNe();
      ((d)localObject).qQV.qQO = null;
      ((d)localObject).qRf = null;
      return;
      i = 0;
      break;
      label179:
      Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
      long l1 = Util.nowSecond() - ((h)localObject).uoS;
      label213:
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      if (l1 >= 86400L)
      {
        l1 = 86400L;
        localLinkedList1 = new LinkedList();
        localLinkedList1.addAll(((h)localObject).uoW);
        localLinkedList2 = ((h)localObject).cNc();
        if (!((h)localObject).uoU) {
          break label397;
        }
      }
      for (i = 1;; i = 0)
      {
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(((h)localObject).uoW.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(((h)localObject).uoR) });
        h.a(((h)localObject).uoW, localLinkedList2);
        int j = (int)l1;
        int k = (int)((h)localObject).uoR;
        Log.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
        l.cNm().postToWorker(new f.1(l2, localLinkedList2, localLinkedList1, i, j, k));
        ((h)localObject).cNb();
        break;
        l1 += ((h)localObject).uoT;
        break label213;
      }
    }
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroyView()
  {
    this.upc.quit();
    this.upg.iQ();
    cNf().iQ();
    cNd().b((RecyclerView.l)this.upp);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onPause()
  {
    Log.i(TAG, "onPause");
    c(this.upl, false);
    h localh = this.uph;
    localh.uoT = (Util.nowSecond() - localh.uoS + localh.uoT);
    localh.uoS = Util.nowSecond();
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    Log.i(TAG, "onResume");
    this.uph.uoS = Util.nowSecond();
    Iterator localIterator = this.upl.iterator();
    label124:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.upo.containsKey(localObject)) {
          break label124;
        }
        localObject = (String)this.upo.get(localObject);
        Long localLong = (Long)((Map)this.upn).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.upn.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    volatile boolean isLoading;
    volatile int oUl;
    volatile boolean upr;
    
    public b()
    {
      AppMethodBeat.i(322526);
      AppMethodBeat.o(322526);
    }
    
    public final boolean getCanLoadMore()
    {
      return (this.upr) && (!this.isLoading);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<d>
  {
    public static final c upt;
    
    static
    {
      AppMethodBeat.i(51360);
      upt = new c();
      AppMethodBeat.o(51360);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements q<Integer, LinkedList<enb>, Integer, ah>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<f>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RecommendRecycleView>
  {
    g(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends RecyclerView.l
  {
    private boolean umf;
    private final ArrayList<Integer> upA;
    private final ArrayList<Integer> upz;
    
    h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      AppMethodBeat.i(51372);
      this.upz = new ArrayList();
      this.upA = new ArrayList();
      AppMethodBeat.o(51372);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(322553);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.umf = bool;
        if (this.umf) {
          AppBrandRecommendUILogic.e(this.ups).uoU = this.umf;
        }
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          ((LinearLayoutManager)paramRecyclerView).Ju();
          int i = ((LinearLayoutManager)paramRecyclerView).Jw();
          paramInt = i;
          if (i >= 3) {
            paramInt = i - 1;
          }
          AppBrandRecommendUILogic.c(this.ups).ieV = paramInt;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(322553);
        return;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(322550);
      Object localObject = new b();
      ((b)localObject).cH(paramRecyclerView);
      ((b)localObject).sc(paramInt1);
      ((b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (paramRecyclerView == null) {}
      for (paramRecyclerView = null;; paramRecyclerView = paramRecyclerView.getLayoutManager())
      {
        if ((paramRecyclerView instanceof LinearLayoutManager))
        {
          paramInt1 = ((LinearLayoutManager)paramRecyclerView).Ju();
          paramInt2 = ((LinearLayoutManager)paramRecyclerView).Jw();
          if ((paramInt1 != 0) || (paramInt2 != 1)) {
            break;
          }
          j.b(this.ups.context, AppBrandRecommendUILogic.b(this.ups).tth);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(322550);
        return;
      }
      this.upA.clear();
      if (paramInt1 <= paramInt2) {}
      for (;;)
      {
        if (paramInt1 == 0) {
          j.b(this.ups.context, AppBrandRecommendUILogic.b(this.ups).tth);
        }
        for (;;)
        {
          if (paramInt1 == paramInt2)
          {
            this.ups.upm.clear();
            this.upz.removeAll((Collection)this.upA);
            this.ups.upm.addAll((Collection)this.upz);
            this.upz.clear();
            this.upz.addAll((Collection)this.upA);
            this.ups.upl.removeAll((Collection)this.ups.upm);
            AppBrandRecommendUILogic.a(this.ups, this.ups.upm);
            break;
            paramRecyclerView = this.ups.cNd().fU(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.upA.add(Integer.valueOf(paramInt1));
              if (!this.upz.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.ups.cNd().P(paramRecyclerView);
                Log.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.ups.upd.getItemCount())
                {
                  paramRecyclerView = this.ups.upd.cMW().get(i);
                  s.s(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (enb)paramRecyclerView;
                  localObject = AppBrandRecommendUILogic.e(this.ups);
                  aot localaot;
                  if (((h)localObject).uoV.containsKey(paramRecyclerView.tNS))
                  {
                    localaot = (aot)((h)localObject).uoV.get(paramRecyclerView.tNS);
                    localaot.count += 1;
                    ((h)localObject).uoV.put(paramRecyclerView.tNS, localaot);
                  }
                  for (;;)
                  {
                    this.ups.upn.put(paramRecyclerView.tNS, Long.valueOf(System.currentTimeMillis()));
                    this.ups.upo.put(Integer.valueOf(paramInt1), paramRecyclerView.tNS);
                    this.ups.upl.add(Integer.valueOf(paramInt1));
                    break;
                    localaot = new aot();
                    localaot.username = paramRecyclerView.met;
                    localaot.count = 1;
                    localaot.tNS = paramRecyclerView.tNS;
                    localaot.tNT = paramRecyclerView.tNT;
                    localaot.ZvW = 0;
                    localaot.tNU = paramRecyclerView.tNU;
                    localaot.tNV = paramRecyclerView.tNV;
                    localaot.tNW = paramRecyclerView.tNW;
                    localaot.tNX = paramRecyclerView.tNX;
                    localaot.position = (i + 1);
                    WxaAttributes localWxaAttributes = n.cfc().d(paramRecyclerView.met, new String[0]);
                    if (localWxaAttributes != null) {
                      localaot.appid = localWxaAttributes.field_appId;
                    }
                    ((h)localObject).uoV.put(paramRecyclerView.tNS, localaot);
                  }
                }
              }
            }
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements m<enb, Integer, ah>
  {
    i(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements m<enb, Integer, ah>
  {
    j(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements m<enb, Integer, ah>
  {
    k(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
  {
    l(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<ah>
  {
    m(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */