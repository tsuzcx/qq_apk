package com.tencent.mm.plugin.finder.nearby.live.square.operation;

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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "clickTabIdFromOut", "", "getClickTabIdFromOut", "()Ljava/lang/String;", "setClickTabIdFromOut", "(Ljava/lang/String;)V", "commentSceneFromOut", "", "getCommentSceneFromOut", "()I", "setCommentSceneFromOut", "(I)V", "isFirstOnResume", "", "lastClickActionBarTime", "", "getClickTabId", "getCommentScene", "getReportType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "plugin-finder-nearby_release"})
public final class FinderLiveOperationFragment
  extends NearbyLiveSquareFragment
{
  private HashMap _$_findViewCache;
  private boolean zEs = true;
  private String zGA = "9001";
  private long zGr;
  private int zGz = 9500001;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(201602);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(201602);
  }
  
  public final String dLv()
  {
    return this.zGA;
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return this.zGz;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201573);
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("key_comment_scene", this.zGz);; i = this.zGz)
    {
      this.zGz = i;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        String str = paramBundle.getString("key_click_tab_id");
        paramBundle = str;
        if (str != null) {}
      }
      else
      {
        paramBundle = this.zGA;
      }
      this.zGA = paramBundle;
      AppMethodBeat.o(201573);
      return;
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(201587);
    p.k(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() instanceof MMFinderUI))
    {
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(201587);
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
        AppMethodBeat.o(201587);
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
        AppMethodBeat.o(201587);
        throw paramLayoutInflater;
      }
      paramViewGroup = (TextView)((FragmentActivity)paramViewGroup).findViewById(f.d.zCY);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener((View.OnClickListener)new b(this));
      }
    }
    AppMethodBeat.o(201587);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201594);
    super.onDestroy();
    m localm = m.xuU;
    m.dse();
    AppMethodBeat.o(201594);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(201593);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((com.tencent.mm.plugin.finder.nearby.live.square.b)component(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).dMe();
      com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(201593);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201590);
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
    AppMethodBeat.o(201590);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(201575);
    p.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    super.onUserVisibleFocused();
    AppMethodBeat.o(201575);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderLiveOperationFragment paramFinderLiveOperationFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200394);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment$onCreateView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zGB.dLs();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment$onCreateView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200394);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderLiveOperationFragment paramFinderLiveOperationFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200741);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      long l = System.currentTimeMillis();
      if (l - FinderLiveOperationFragment.a(this.zGB) < 300L) {
        this.zGB.dLu();
      }
      FinderLiveOperationFragment.a(this.zGB, l);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.operation.FinderLiveOperationFragment
 * JD-Core Version:    0.7.0.1
 */