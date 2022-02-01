package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveSquareMoreFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getReportType", "onResume", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class NearbyLiveSquareMoreFragment
  extends NearbyLiveSquareFragment
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249223);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249223);
  }
  
  public final String ack()
  {
    return "1004";
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 80;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249222);
    super.onResume();
    Log.i("NearbyLiveSquareUIC", "onResume()");
    d locald = d.uTq;
    d.dlB();
    AppMethodBeat.o(249222);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(249221);
    p.h(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    super.onUserVisibleFocused();
    AppMethodBeat.o(249221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveSquareMoreFragment
 * JD-Core Version:    0.7.0.1
 */