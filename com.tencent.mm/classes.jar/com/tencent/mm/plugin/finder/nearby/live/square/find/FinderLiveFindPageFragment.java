package com.tencent.mm.plugin.finder.nearby.live.square.find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.m;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "isFirstOnResume", "", "lastClickActionBarTime", "", "getClickTabId", "", "getReportType", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "plugin-finder-nearby_release"})
public final class FinderLiveFindPageFragment
  extends NearbyLiveSquareFragment
{
  private HashMap _$_findViewCache;
  private boolean zEs = true;
  private long zGr;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(200615);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(200615);
  }
  
  public final String dLv()
  {
    return "8001";
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200599);
    super.onCreate(paramBundle);
    AppMethodBeat.o(200599);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(200605);
    p.k(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() instanceof MMFinderUI))
    {
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(200605);
        throw paramLayoutInflater;
      }
      paramViewGroup = (ConstraintLayout)((FragmentActivity)paramViewGroup).findViewById(f.d.zCX);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener((View.OnClickListener)new a(this));
      }
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(200605);
        throw paramLayoutInflater;
      }
      paramViewGroup = (TextView)((FragmentActivity)paramViewGroup).findViewById(f.d.nearby_menu_live);
      if (paramViewGroup != null) {
        paramViewGroup.setTextSize(1, 15.0F);
      }
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(200605);
        throw paramLayoutInflater;
      }
      paramViewGroup = (TextView)((FragmentActivity)paramViewGroup).findViewById(f.d.zCY);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener((View.OnClickListener)new b(this));
      }
    }
    AppMethodBeat.o(200605);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200613);
    super.onDestroy();
    m localm = m.xuU;
    m.dse();
    AppMethodBeat.o(200613);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200609);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((com.tencent.mm.plugin.finder.nearby.live.square.b)component(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).dMe();
      com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(200609);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200608);
    super.onResume();
    Log.i("NearbyLiveSquareFragment", "onResume() isFirstOnResume:" + this.zEs);
    Object localObject = e.zJs;
    e.dMA();
    if ((!this.zEs) && (getActivity() != null))
    {
      localObject = ((com.tencent.mm.plugin.finder.nearby.live.square.b)component(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).dMe();
      com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.b((AbsNearByFragment)localObject);
    }
    this.zEs = false;
    AppMethodBeat.o(200608);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(200600);
    p.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    super.onUserVisibleFocused();
    AppMethodBeat.o(200600);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderLiveFindPageFragment paramFinderLiveFindPageFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200093);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zGs.dLs();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200093);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderLiveFindPageFragment paramFinderLiveFindPageFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199689);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      long l = System.currentTimeMillis();
      if (l - FinderLiveFindPageFragment.a(this.zGs) < 300L) {
        this.zGs.dLu();
      }
      FinderLiveFindPageFragment.a(this.zGs, l);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199689);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageFragment
 * JD-Core Version:    0.7.0.1
 */