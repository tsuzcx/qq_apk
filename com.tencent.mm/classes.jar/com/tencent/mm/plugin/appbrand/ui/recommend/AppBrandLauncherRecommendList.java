package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList
  extends AppBrandLauncherUI.Fragment
{
  private static final String TAG = "MicroMsg.AppBrandLauncherRecommendsList";
  public static final AppBrandLauncherRecommendList.a rgm;
  private HashMap _$_findViewCache;
  private final f rgl;
  
  static
  {
    AppMethodBeat.i(51309);
    rgm = new AppBrandLauncherRecommendList.a((byte)0);
    TAG = "MicroMsg.AppBrandLauncherRecommendsList";
    AppMethodBeat.o(51309);
  }
  
  public AppBrandLauncherRecommendList()
  {
    AppMethodBeat.i(51316);
    this.rgl = kotlin.g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(51316);
  }
  
  private final AppBrandRecommendUILogic clw()
  {
    AppMethodBeat.i(51310);
    AppBrandRecommendUILogic localAppBrandRecommendUILogic = (AppBrandRecommendUILogic)this.rgl.getValue();
    AppMethodBeat.o(51310);
    return localAppBrandRecommendUILogic;
  }
  
  public final void cjF()
  {
    AppMethodBeat.i(51313);
    super.cjF();
    Log.i(TAG, "onTitleDoubleTap");
    LoadMoreRecyclerView localLoadMoreRecyclerView = clw().clL();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localLoadMoreRecyclerView, locala.aFh(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localLoadMoreRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localLoadMoreRecyclerView, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
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
    Object localObject1 = clw();
    ((AppBrandRecommendUILogic)localObject1).clL().setLayoutManager((RecyclerView.LayoutManager)((AppBrandRecommendUILogic)localObject1).rhh);
    Object localObject2 = ((AppBrandRecommendUILogic)localObject1).getContentView();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((FrameLayout)localObject2).addView((View)((AppBrandRecommendUILogic)localObject1).clL(), new ViewGroup.LayoutParams(-1, -1));
    ((AppBrandRecommendUILogic)localObject1).rhf.aw(true);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).rhf;
    Object localObject3 = (m)new AppBrandRecommendUILogic.m((AppBrandRecommendUILogic)localObject1);
    p.k(localObject3, "<set-?>");
    ((a)localObject2).rgq = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).rhf;
    localObject3 = (m)new AppBrandRecommendUILogic.n((AppBrandRecommendUILogic)localObject1);
    p.k(localObject3, "<set-?>");
    ((a)localObject2).rgs = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).rhf;
    localObject3 = (m)new AppBrandRecommendUILogic.o((AppBrandRecommendUILogic)localObject1);
    p.k(localObject3, "<set-?>");
    ((a)localObject2).rgr = ((m)localObject3);
    ((AppBrandRecommendUILogic)localObject1).clL().setAdapter((RecyclerView.a)((AppBrandRecommendUILogic)localObject1).rhf);
    if (((AppBrandRecommendUILogic)localObject1).cly())
    {
      ((AppBrandRecommendUILogic)localObject1).clL().dI(((AppBrandRecommendUILogic)localObject1).rhi.getItemView());
      localObject2 = ((AppBrandRecommendUILogic)localObject1).rhi.getItemView();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((AppBrandRecommendUILogic)localObject1).rhi.cfx();
      ((AppBrandRecommendUILogic)localObject1).rhi.CX(0);
      ((AppBrandRecommendUILogic)localObject1).rhi.CY(0);
    }
    localObject2 = LayoutInflater.from(((AppBrandRecommendUILogic)localObject1).context).inflate(au.g.app_brand_recommend_list_header_view, (ViewGroup)((AppBrandRecommendUILogic)localObject1).clL(), false);
    ((AppBrandRecommendUILogic)localObject1).clL().dI((View)localObject2);
    localObject3 = ((View)localObject2).findViewById(au.f.header_view_tv);
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((TextView)localObject3).setText((CharSequence)((AppBrandRecommendUILogic)localObject1).clx());
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)AppBrandRecommendUILogic.g.rhE);
    ((AppBrandRecommendUILogic)localObject1).clL().setLoadingView(((AppBrandRecommendUILogic)localObject1).clN().getItemView());
    i.a((AppBrandRecommendUILogic)localObject1, false);
    i.b((AppBrandRecommendUILogic)localObject1, false);
    ((AppBrandRecommendUILogic)localObject1).clN();
    ((AppBrandRecommendUILogic)localObject1).clN().CZ(au.c.transparent);
    ((AppBrandRecommendUILogic)localObject1).rhg.page = ((AppBrandRecommendUILogic)localObject1).clM().nRl;
    localObject2 = ((AppBrandRecommendUILogic)localObject1).rhg;
    if (((AppBrandRecommendUILogic)localObject1).clM().nRk > 0)
    {
      bool1 = true;
      ((AppBrandRecommendUILogic.b)localObject2).rhv = bool1;
      ((AppBrandRecommendUILogic)localObject1).clM().nRr = ((kotlin.g.a.q)new AppBrandRecommendUILogic.f((AppBrandRecommendUILogic)localObject1));
      if ((((AppBrandRecommendUILogic)localObject1).clM().bJY().isEmpty()) || (!((AppBrandRecommendUILogic)localObject1).clM().nRm)) {
        break label545;
      }
    }
    label545:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AppBrandRecommendUILogic)localObject1).jS(bool1);
      if (!bool1) {
        g.Dd(2);
      }
      ((AppBrandRecommendUILogic)localObject1).clL().setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new AppBrandRecommendUILogic.h((AppBrandRecommendUILogic)localObject1));
      ((AppBrandRecommendUILogic)localObject1).clL().a((RecyclerView.l)((AppBrandRecommendUILogic)localObject1).rhr);
      ((AppBrandRecommendUILogic)localObject1).rhj.clG();
      ((AppBrandRecommendUILogic)localObject1).rhf.notifyDataSetChanged();
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
    getLifecycle().a((k)clw());
    AppMethodBeat.o(51311);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(51314);
    super.onDestroyView();
    Log.i(TAG, "onDestroyView");
    androidx.lifecycle.h localh = getLifecycle();
    p.j(localh, "lifecycle");
    localh.jc();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
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