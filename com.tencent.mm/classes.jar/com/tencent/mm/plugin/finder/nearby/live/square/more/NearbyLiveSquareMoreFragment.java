package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.b;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveSquareMoreFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getReportType", "onPause", "", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLiveSquareMoreFragment
  extends NearbyLiveSquareFragment
{
  public final String eEt()
  {
    AppMethodBeat.i(341192);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      AppMethodBeat.o(341192);
      return "8002";
    }
    AppMethodBeat.o(341192);
    return "1004";
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 80;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(341211);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).eFC();
      g localg = g.ERj;
      g.e((AbsNearByFragment)localNearbyLiveSquareTabFragment);
      com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(341211);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(341202);
    super.onResume();
    Log.i("NearbyLiveSquareUIC", "onResume()");
    g localg = g.ERj;
    g.eGN();
    AppMethodBeat.o(341202);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(341168);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    super.onUserVisibleFocused();
    AppMethodBeat.o(341168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveSquareMoreFragment
 * JD-Core Version:    0.7.0.1
 */