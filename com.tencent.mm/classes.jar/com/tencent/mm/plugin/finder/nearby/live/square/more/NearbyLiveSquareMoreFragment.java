package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.b;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveSquareMoreFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getReportType", "onPause", "", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-nearby_release"})
public final class NearbyLiveSquareMoreFragment
  extends NearbyLiveSquareFragment
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(199896);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(199896);
  }
  
  public final String dLv()
  {
    AppMethodBeat.i(199880);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      AppMethodBeat.o(199880);
      return "8002";
    }
    AppMethodBeat.o(199880);
    return "1004";
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 80;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(199892);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).dMe();
      Object localObject = e.zJs;
      e.e((AbsNearByFragment)localNearbyLiveSquareTabFragment);
      localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(199892);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199883);
    super.onResume();
    Log.i("NearbyLiveSquareUIC", "onResume()");
    e locale = e.zJs;
    e.dMA();
    AppMethodBeat.o(199883);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(199876);
    p.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    super.onUserVisibleFocused();
    AppMethodBeat.o(199876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveSquareMoreFragment
 * JD-Core Version:    0.7.0.1
 */