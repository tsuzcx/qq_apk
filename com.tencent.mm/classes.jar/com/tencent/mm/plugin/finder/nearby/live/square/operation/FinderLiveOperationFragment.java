package com.tencent.mm.plugin.finder.nearby.live.square.operation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "clickTabIdFromOut", "", "getClickTabIdFromOut", "()Ljava/lang/String;", "setClickTabIdFromOut", "(Ljava/lang/String;)V", "commentSceneFromOut", "", "getCommentSceneFromOut", "()I", "setCommentSceneFromOut", "(I)V", "isFirstOnResume", "", "lastClickActionBarTime", "", "getClickTabId", "getCommentScene", "getReportType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveOperationFragment
  extends NearbyLiveSquareFragment
{
  private long ELN;
  private int ELS = 9500001;
  private String ELT = "9001";
  private boolean isFirstOnResume = true;
  
  private static final void a(FinderLiveOperationFragment paramFinderLiveOperationFragment, View paramView)
  {
    AppMethodBeat.i(341155);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveOperationFragment);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveOperationFragment, "this$0");
    paramFinderLiveOperationFragment.eEp();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341155);
  }
  
  private static final void b(FinderLiveOperationFragment paramFinderLiveOperationFragment, View paramView)
  {
    AppMethodBeat.i(341162);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveOperationFragment);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveOperationFragment, "this$0");
    long l = System.currentTimeMillis();
    if (l - paramFinderLiveOperationFragment.ELN < 300L) {
      paramFinderLiveOperationFragment.eEr();
    }
    paramFinderLiveOperationFragment.ELN = l;
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341162);
  }
  
  public final String eEt()
  {
    return this.ELT;
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return this.ELS;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(341184);
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    int i;
    if (paramBundle == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        break label92;
      }
      i = this.ELS;
      label30:
      this.ELS = i;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label100;
      }
    }
    label92:
    label100:
    for (paramBundle = null;; paramBundle = paramBundle.getString("key_click_tab_id"))
    {
      Object localObject = paramBundle;
      if (paramBundle == null) {
        localObject = this.ELT;
      }
      this.ELT = ((String)localObject);
      paramBundle = q.ASF;
      q.eaZ();
      AppMethodBeat.o(341184);
      return;
      paramBundle = Integer.valueOf(paramBundle.getInt("key_from_comment_scene", this.ELS));
      break;
      i = paramBundle.intValue();
      break label30;
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(341223);
    s.u(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() instanceof MMFinderUI))
    {
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(341223);
        throw paramLayoutInflater;
      }
      paramViewGroup = (ConstraintLayout)((MMFinderUI)paramViewGroup).findViewById(f.d.EFR);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener(new FinderLiveOperationFragment..ExternalSyntheticLambda0(this));
      }
      paramViewGroup = getActivity();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(341223);
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
        AppMethodBeat.o(341223);
        throw paramLayoutInflater;
      }
      paramViewGroup = (TextView)((MMFinderUI)paramViewGroup).findViewById(f.d.EFS);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener(new FinderLiveOperationFragment..ExternalSyntheticLambda1(this));
      }
    }
    AppMethodBeat.o(341223);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(341248);
    super.onDestroy();
    q localq = q.ASF;
    q.eaY();
    AppMethodBeat.o(341248);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(341242);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((com.tencent.mm.plugin.finder.nearby.live.square.b)component(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).eFC();
      com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(341242);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(341233);
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
    AppMethodBeat.o(341233);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(341189);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    super.onUserVisibleFocused();
    AppMethodBeat.o(341189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.operation.FinderLiveOperationFragment
 * JD-Core Version:    0.7.0.1
 */