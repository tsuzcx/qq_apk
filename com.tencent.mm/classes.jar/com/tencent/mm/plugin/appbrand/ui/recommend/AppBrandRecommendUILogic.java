package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f;
import a.f.a.m;
import a.f.a.q;
import a.l;
import a.v;
import a.y;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.ui.recents.e;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic
  implements LifecycleObserver
{
  private static final String TAG = "MicroMsg.Recommend.AppBrandRecommendUILogic";
  public static final AppBrandRecommendUILogic.a iWQ = new AppBrandRecommendUILogic.a((byte)0);
  final Activity activity;
  final Context context;
  private final f iWA;
  private final al iWB;
  final a iWC;
  final AppBrandRecommendUILogic.b iWD;
  final LinearLayoutManager iWE;
  final com.tencent.mm.plugin.appbrand.ui.recents.g iWF;
  final h iWG;
  private final f iWH;
  private final k.a iWI;
  private final k.a iWJ;
  final ArrayList<Integer> iWK;
  final ArrayList<Integer> iWL;
  final HashMap<String, Long> iWM;
  final HashMap<Integer, String> iWN;
  final AppBrandRecommendUILogic.l iWO;
  private final AppBrandRecommendUILogic.p iWP;
  private final f iWz;
  
  public AppBrandRecommendUILogic(Activity paramActivity)
  {
    this.activity = paramActivity;
    paramActivity = this.activity;
    if (paramActivity == null) {
      throw new v("null cannot be cast to non-null type android.content.Context");
    }
    this.context = ((Context)paramActivity);
    this.iWz = a.g.j((a.f.a.a)new AppBrandRecommendUILogic.j(this));
    this.iWA = a.g.j((a.f.a.a)AppBrandRecommendUILogic.c.iWT);
    this.iWB = new al("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
    this.iWC = new a(this.activity);
    this.iWD = new AppBrandRecommendUILogic.b(this);
    this.iWE = ((LinearLayoutManager)new k(this.context));
    this.iWF = new com.tencent.mm.plugin.appbrand.ui.recents.g(this.activity, (ViewGroup)aNK());
    this.iWG = new h();
    this.iWH = a.g.j((a.f.a.a)new AppBrandRecommendUILogic.i(this));
    this.iWI = ((k.a)new AppBrandRecommendUILogic.d(this));
    this.iWJ = ((k.a)new AppBrandRecommendUILogic.r(this));
    this.iWK = new ArrayList();
    this.iWL = new ArrayList();
    this.iWM = new HashMap();
    this.iWN = new HashMap();
    this.iWO = new AppBrandRecommendUILogic.l(this);
    this.iWP = new AppBrandRecommendUILogic.p(this);
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
        if (!this.iWN.containsKey(localInteger)) {
          break label145;
        }
        String str = (String)this.iWN.get(localInteger);
        Long localLong = (Long)((Map)this.iWM).get(str);
        if ((str == null) || (localLong == null)) {
          break;
        }
        long l = System.currentTimeMillis() - localLong.longValue();
        ab.d(TAG, "exposure index: %d, exposureTime:%d", new Object[] { localInteger, Long.valueOf(l) });
        this.iWG.F(str, l);
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
  
  private final void f(a.f.a.a<y> parama)
  {
    this.iWB.ad((Runnable)new AppBrandRecommendUILogic.k(parama));
  }
  
  public final LoadMoreRecyclerView aNK()
  {
    return (LoadMoreRecyclerView)this.iWz.getValue();
  }
  
  final d aNL()
  {
    return (d)this.iWA.getValue();
  }
  
  public final e aNM()
  {
    return (e)this.iWH.getValue();
  }
  
  public abstract String aNx();
  
  public abstract boolean aNy();
  
  final void eW(final boolean paramBoolean)
  {
    i.a(this, true);
    i.b(this, true);
    f((a.f.a.a)new e(this, paramBoolean));
  }
  
  public abstract View getContentView();
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    ab.i(TAG, "onCreate");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    ab.i(TAG, "onDestroy");
    ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).remove(this.iWI);
    com.tencent.mm.plugin.appbrand.app.g.auF().remove(this.iWJ);
    this.iWK.clear();
    this.iWL.clear();
    this.iWM.clear();
    this.iWN.clear();
    this.iWG.hG(aNL().sessionId);
    d locald = aNL();
    if (!aNL().axP().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      locald.hdk = bool;
      aNL().hdl = 0;
      locald = aNL();
      locald.hdf.a(null);
      locald.hdp = null;
      return;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroyView()
  {
    this.iWB.quit();
    this.iWF.onDetached();
    aNM().onDetached();
    aNK().b((RecyclerView.m)this.iWO);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    ab.i(TAG, "onPause");
    c(this.iWK, false);
    this.iWG.aNI();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    ab.i(TAG, "onResume");
    this.iWG.aNH();
    Iterator localIterator = this.iWK.iterator();
    label121:
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        if (!this.iWN.containsKey(localObject)) {
          break label121;
        }
        localObject = (String)this.iWN.get(localObject);
        Long localLong = (Long)((Map)this.iWM).get(localObject);
        if ((localObject == null) || (localLong == null)) {
          break;
        }
        this.iWM.put(localObject, Long.valueOf(System.currentTimeMillis()));
        break;
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class e
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    e(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
  static final class f
    extends a.f.b.k
    implements q<Integer, LinkedList<bsi>, Integer, y>
  {
    f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    public static final g iXa;
    
    static
    {
      AppMethodBeat.i(135189);
      iXa = new g();
      AppMethodBeat.o(135189);
    }
    
    public final boolean onLongClick(View paramView)
    {
      return true;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
  static final class n
    extends a.f.b.k
    implements m<bsi, Integer, y>
  {
    n(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
 * JD-Core Version:    0.7.0.1
 */