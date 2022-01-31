package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f;
import a.f.a.m;
import a.f.a.q;
import a.f.b.j;
import a.f.b.t;
import a.j.k;
import a.l;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.recents.e;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList
  extends AppBrandLauncherUI.Fragment
{
  private static final String TAG = "MicroMsg.AppBrandLauncherRecommendsList";
  public static final AppBrandLauncherRecommendList.a iVJ;
  private final f iVI;
  
  static
  {
    AppMethodBeat.i(135143);
    eOJ = new k[] { (k)a.f.b.v.a(new t(a.f.b.v.aG(AppBrandLauncherRecommendList.class), "uiLogic", "getUiLogic()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;")) };
    iVJ = new AppBrandLauncherRecommendList.a((byte)0);
    TAG = "MicroMsg.AppBrandLauncherRecommendsList";
    AppMethodBeat.o(135143);
  }
  
  public AppBrandLauncherRecommendList()
  {
    AppMethodBeat.i(135150);
    this.iVI = a.g.j((a.f.a.a)new AppBrandLauncherRecommendList.b(this));
    AppMethodBeat.o(135150);
  }
  
  private final AppBrandRecommendUILogic aNw()
  {
    AppMethodBeat.i(135144);
    AppBrandRecommendUILogic localAppBrandRecommendUILogic = (AppBrandRecommendUILogic)this.iVI.getValue();
    AppMethodBeat.o(135144);
    return localAppBrandRecommendUILogic;
  }
  
  public final void aMd()
  {
    AppMethodBeat.i(135147);
    super.aMd();
    ab.i(TAG, "onTitleDoubleTap");
    aNw().aNK().smoothScrollToPosition(0);
    AppMethodBeat.o(135147);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(135146);
    Object localObject1 = aNw();
    ((AppBrandRecommendUILogic)localObject1).aNK().setLayoutManager((RecyclerView.i)((AppBrandRecommendUILogic)localObject1).iWE);
    Object localObject2 = ((AppBrandRecommendUILogic)localObject1).getContentView();
    if (localObject2 == null)
    {
      localObject1 = new a.v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(135146);
      throw ((Throwable)localObject1);
    }
    ((FrameLayout)localObject2).addView((View)((AppBrandRecommendUILogic)localObject1).aNK(), new ViewGroup.LayoutParams(-1, -1));
    ((AppBrandRecommendUILogic)localObject1).iWC.jv();
    localObject2 = ((AppBrandRecommendUILogic)localObject1).iWC;
    Object localObject3 = (m)new AppBrandRecommendUILogic.m((AppBrandRecommendUILogic)localObject1);
    j.q(localObject3, "<set-?>");
    ((a)localObject2).iVN = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).iWC;
    localObject3 = (m)new AppBrandRecommendUILogic.n((AppBrandRecommendUILogic)localObject1);
    j.q(localObject3, "<set-?>");
    ((a)localObject2).iVP = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).iWC;
    localObject3 = (m)new AppBrandRecommendUILogic.o((AppBrandRecommendUILogic)localObject1);
    j.q(localObject3, "<set-?>");
    ((a)localObject2).iVO = ((m)localObject3);
    ((AppBrandRecommendUILogic)localObject1).aNK().setAdapter((RecyclerView.a)((AppBrandRecommendUILogic)localObject1).iWC);
    if (((AppBrandRecommendUILogic)localObject1).aNy())
    {
      ((AppBrandRecommendUILogic)localObject1).aNK().addHeaderView(((AppBrandRecommendUILogic)localObject1).iWF.aNe());
      localObject2 = ((AppBrandRecommendUILogic)localObject1).iWF.aNe();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((AppBrandRecommendUILogic)localObject1).iWF.aNd();
      ((AppBrandRecommendUILogic)localObject1).iWF.pF(0);
      ((AppBrandRecommendUILogic)localObject1).iWF.pG(0);
    }
    localObject2 = LayoutInflater.from(((AppBrandRecommendUILogic)localObject1).context).inflate(2130968729, (ViewGroup)((AppBrandRecommendUILogic)localObject1).aNK(), false);
    ((AppBrandRecommendUILogic)localObject1).aNK().addHeaderView((View)localObject2);
    localObject3 = ((View)localObject2).findViewById(2131821371);
    if (localObject3 == null)
    {
      localObject1 = new a.v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(135146);
      throw ((Throwable)localObject1);
    }
    ((TextView)localObject3).setText((CharSequence)((AppBrandRecommendUILogic)localObject1).aNx());
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)AppBrandRecommendUILogic.g.iXa);
    ((AppBrandRecommendUILogic)localObject1).aNK().setLoadingView(((AppBrandRecommendUILogic)localObject1).aNM().aNe());
    i.a((AppBrandRecommendUILogic)localObject1, false);
    i.b((AppBrandRecommendUILogic)localObject1, false);
    ((AppBrandRecommendUILogic)localObject1).aNM();
    ((AppBrandRecommendUILogic)localObject1).aNM().aNo();
    ((AppBrandRecommendUILogic)localObject1).iWD.fQF = ((AppBrandRecommendUILogic)localObject1).aNL().hdj;
    localObject2 = ((AppBrandRecommendUILogic)localObject1).iWD;
    if (((AppBrandRecommendUILogic)localObject1).aNL().hdi > 0)
    {
      bool1 = true;
      ((AppBrandRecommendUILogic.b)localObject2).iWR = bool1;
      ((AppBrandRecommendUILogic)localObject1).aNL().hdp = ((q)new AppBrandRecommendUILogic.f((AppBrandRecommendUILogic)localObject1));
      if ((((AppBrandRecommendUILogic)localObject1).aNL().axP().isEmpty()) || (!((AppBrandRecommendUILogic)localObject1).aNL().hdk)) {
        break label541;
      }
    }
    label541:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AppBrandRecommendUILogic)localObject1).eW(bool1);
      if (!bool1) {
        g.pK(2);
      }
      ((AppBrandRecommendUILogic)localObject1).aNK().setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new AppBrandRecommendUILogic.h((AppBrandRecommendUILogic)localObject1));
      ((AppBrandRecommendUILogic)localObject1).aNK().a((RecyclerView.m)((AppBrandRecommendUILogic)localObject1).iWO);
      ((AppBrandRecommendUILogic)localObject1).iWG.aNF();
      ((AppBrandRecommendUILogic)localObject1).iWC.notifyDataSetChanged();
      AppMethodBeat.o(135146);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(135145);
    super.onCreate(paramBundle);
    ab.i(TAG, "onCreate");
    getLifecycle().addObserver((LifecycleObserver)aNw());
    AppMethodBeat.o(135145);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(135148);
    super.onDestroyView();
    ab.i(TAG, "onDestroyView");
    Lifecycle localLifecycle = getLifecycle();
    j.p(localLifecycle, "lifecycle");
    localLifecycle.getCurrentState();
    AppMethodBeat.o(135148);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(135149);
    super.onPause();
    ab.i(TAG, "onPause");
    AppMethodBeat.o(135149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList
 * JD-Core Version:    0.7.0.1
 */