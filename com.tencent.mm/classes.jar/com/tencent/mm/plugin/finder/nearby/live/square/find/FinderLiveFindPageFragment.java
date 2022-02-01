package com.tencent.mm.plugin.finder.nearby.live.square.find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.q;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "isFirstOnResume", "", "lastClickActionBarTime", "", "getClickTabId", "", "getReportType", "", "handleClickReport", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFindPageFragment
  extends NearbyLiveSquareFragment
{
  private long ELN;
  private boolean isFirstOnResume = true;
  
  private static final void a(FinderLiveFindPageFragment paramFinderLiveFindPageFragment, View paramView)
  {
    AppMethodBeat.i(341161);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveFindPageFragment);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveFindPageFragment, "this$0");
    long l = System.currentTimeMillis();
    if (l - paramFinderLiveFindPageFragment.ELN < 300L) {
      paramFinderLiveFindPageFragment.eEr();
    }
    paramFinderLiveFindPageFragment.ELN = l;
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341161);
  }
  
  public final String eEt()
  {
    return "8001";
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(341208);
    super.onCreate(paramBundle);
    paramBundle = q.ASF;
    q.eaZ();
    AppMethodBeat.o(341208);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(341259);
    s.u(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() instanceof MMFinderUI))
    {
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(341259);
        throw paramLayoutInflater;
      }
      paramViewGroup = (ConstraintLayout)((MMFinderUI)paramViewGroup).findViewById(f.d.EFR);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener((View.OnClickListener)new FinderLiveFindPageFragment.a(this));
      }
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(341259);
        throw paramLayoutInflater;
      }
      paramViewGroup = (TextView)((MMFinderUI)paramViewGroup).findViewById(f.d.nearby_menu_live);
      if (paramViewGroup != null) {
        paramViewGroup.setTextSize(1, 15.0F);
      }
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(341259);
        throw paramLayoutInflater;
      }
      paramViewGroup = (TextView)((MMFinderUI)paramViewGroup).findViewById(f.d.EFS);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener(new FinderLiveFindPageFragment..ExternalSyntheticLambda0(this));
      }
    }
    AppMethodBeat.o(341259);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(341295);
    super.onDestroy();
    q localq = q.ASF;
    q.eaY();
    AppMethodBeat.o(341295);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(341285);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((com.tencent.mm.plugin.finder.nearby.live.square.b)component(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).eFC();
      com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(341285);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(341277);
    super.onResume();
    Log.i("NearbyLiveSquareFragment", s.X("onResume() isFirstOnResume:", Boolean.valueOf(this.isFirstOnResume)));
    Object localObject = g.ERj;
    g.eGN();
    if ((!this.isFirstOnResume) && (getActivity() != null))
    {
      localObject = ((com.tencent.mm.plugin.finder.nearby.live.square.b)component(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).eFC();
      com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.b((AbsNearByFragment)localObject);
    }
    this.isFirstOnResume = false;
    AppMethodBeat.o(341277);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(341220);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    super.onUserVisibleFocused();
    AppMethodBeat.o(341220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageFragment
 * JD-Core Version:    0.7.0.1
 */