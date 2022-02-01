package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList
  extends AppBrandLauncherUI.Fragment
{
  private static final String TAG = "MicroMsg.AppBrandLauncherRecommendsList";
  public static final AppBrandLauncherRecommendList.a oeA;
  private HashMap _$_findViewCache;
  private final f oez;
  
  static
  {
    AppMethodBeat.i(51309);
    oeA = new AppBrandLauncherRecommendList.a((byte)0);
    TAG = "MicroMsg.AppBrandLauncherRecommendsList";
    AppMethodBeat.o(51309);
  }
  
  public AppBrandLauncherRecommendList()
  {
    AppMethodBeat.i(51316);
    this.oez = kotlin.g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(51316);
  }
  
  private final AppBrandRecommendUILogic bYM()
  {
    AppMethodBeat.i(51310);
    AppBrandRecommendUILogic localAppBrandRecommendUILogic = (AppBrandRecommendUILogic)this.oez.getValue();
    AppMethodBeat.o(51310);
    return localAppBrandRecommendUILogic;
  }
  
  public final void bXb()
  {
    AppMethodBeat.i(51313);
    super.bXb();
    Log.i(TAG, "onTitleDoubleTap");
    LoadMoreRecyclerView localLoadMoreRecyclerView = bYM().bZc();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localLoadMoreRecyclerView, locala.axQ(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localLoadMoreRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localLoadMoreRecyclerView, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(51313);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(51312);
    Object localObject1 = bYM();
    ((AppBrandRecommendUILogic)localObject1).bZc().setLayoutManager((RecyclerView.LayoutManager)((AppBrandRecommendUILogic)localObject1).ofw);
    Object localObject2 = ((AppBrandRecommendUILogic)localObject1).getContentView();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((FrameLayout)localObject2).addView((View)((AppBrandRecommendUILogic)localObject1).bZc(), new ViewGroup.LayoutParams(-1, -1));
    ((AppBrandRecommendUILogic)localObject1).ofu.au(true);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).ofu;
    Object localObject3 = (m)new AppBrandRecommendUILogic.m((AppBrandRecommendUILogic)localObject1);
    p.h(localObject3, "<set-?>");
    ((a)localObject2).oeE = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).ofu;
    localObject3 = (m)new AppBrandRecommendUILogic.n((AppBrandRecommendUILogic)localObject1);
    p.h(localObject3, "<set-?>");
    ((a)localObject2).oeG = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).ofu;
    localObject3 = (m)new AppBrandRecommendUILogic.o((AppBrandRecommendUILogic)localObject1);
    p.h(localObject3, "<set-?>");
    ((a)localObject2).oeF = ((m)localObject3);
    ((AppBrandRecommendUILogic)localObject1).bZc().setAdapter((RecyclerView.a)((AppBrandRecommendUILogic)localObject1).ofu);
    if (((AppBrandRecommendUILogic)localObject1).bYO())
    {
      ((AppBrandRecommendUILogic)localObject1).bZc().addHeaderView(((AppBrandRecommendUILogic)localObject1).ofx.bYp());
      localObject2 = ((AppBrandRecommendUILogic)localObject1).ofx.bYp();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((AppBrandRecommendUILogic)localObject1).ofx.bSx();
      ((AppBrandRecommendUILogic)localObject1).ofx.zu(0);
      ((AppBrandRecommendUILogic)localObject1).ofx.zv(0);
    }
    localObject2 = LayoutInflater.from(((AppBrandRecommendUILogic)localObject1).context).inflate(2131493087, (ViewGroup)((AppBrandRecommendUILogic)localObject1).bZc(), false);
    ((AppBrandRecommendUILogic)localObject1).bZc().addHeaderView((View)localObject2);
    localObject3 = ((View)localObject2).findViewById(2131302319);
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((TextView)localObject3).setText((CharSequence)((AppBrandRecommendUILogic)localObject1).bYN());
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)AppBrandRecommendUILogic.g.ofT);
    ((AppBrandRecommendUILogic)localObject1).bZc().setLoadingView(((AppBrandRecommendUILogic)localObject1).bZe().bYp());
    i.a((AppBrandRecommendUILogic)localObject1, false);
    i.b((AppBrandRecommendUILogic)localObject1, false);
    ((AppBrandRecommendUILogic)localObject1).bZe();
    ((AppBrandRecommendUILogic)localObject1).bZe().bYE();
    ((AppBrandRecommendUILogic)localObject1).ofv.jlo = ((AppBrandRecommendUILogic)localObject1).bZd().kWZ;
    localObject2 = ((AppBrandRecommendUILogic)localObject1).ofv;
    if (((AppBrandRecommendUILogic)localObject1).bZd().kWY > 0)
    {
      bool1 = true;
      ((AppBrandRecommendUILogic.b)localObject2).ofK = bool1;
      ((AppBrandRecommendUILogic)localObject1).bZd().kXf = ((kotlin.g.a.q)new AppBrandRecommendUILogic.f((AppBrandRecommendUILogic)localObject1));
      if ((((AppBrandRecommendUILogic)localObject1).bZd().byK().isEmpty()) || (!((AppBrandRecommendUILogic)localObject1).bZd().kXa)) {
        break label542;
      }
    }
    label542:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AppBrandRecommendUILogic)localObject1).iV(bool1);
      if (!bool1) {
        g.zz(2);
      }
      ((AppBrandRecommendUILogic)localObject1).bZc().setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new AppBrandRecommendUILogic.h((AppBrandRecommendUILogic)localObject1));
      ((AppBrandRecommendUILogic)localObject1).bZc().a((RecyclerView.l)((AppBrandRecommendUILogic)localObject1).ofG);
      ((AppBrandRecommendUILogic)localObject1).ofy.bYX();
      ((AppBrandRecommendUILogic)localObject1).ofu.notifyDataSetChanged();
      AppMethodBeat.o(51312);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51311);
    super.onCreate(paramBundle);
    Log.i(TAG, "onCreate");
    getLifecycle().addObserver((LifecycleObserver)bYM());
    AppMethodBeat.o(51311);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(51314);
    super.onDestroyView();
    Log.i(TAG, "onDestroyView");
    Lifecycle localLifecycle = getLifecycle();
    p.g(localLifecycle, "lifecycle");
    localLifecycle.getCurrentState();
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(51314);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51315);
    super.onPause();
    Log.i(TAG, "onPause");
    AppMethodBeat.o(51315);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<AppBrandLauncherRecommendList.uiLogic.2.1>
  {
    b(AppBrandLauncherRecommendList paramAppBrandLauncherRecommendList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList
 * JD-Core Version:    0.7.0.1
 */