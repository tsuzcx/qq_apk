package com.tencent.mm.plugin.finder.nearby.live.square.nearbylivefriends;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.report.a;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.b;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import java.util.HashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/nearbylivefriends/NearbyLiveFriendsSquareFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "getClickTabId", "", "onAttach", "", "context", "Landroid/content/Context;", "onPause", "plugin-finder-nearby_release"})
public final class NearbyLiveFriendsSquareFragment
  extends NearbyLiveSquareFragment
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(202092);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(202092);
  }
  
  public final String dLv()
  {
    return "1001";
  }
  
  public final void onAttach(Context paramContext)
  {
    AppMethodBeat.i(202090);
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("key_use_dark_style", 0);
    if (getArguments() == null) {
      setArguments(localBundle1);
    }
    for (;;)
    {
      super.onAttach(paramContext);
      AppMethodBeat.o(202090);
      return;
      Bundle localBundle2 = getArguments();
      if (localBundle2 != null) {
        localBundle2.putAll(localBundle1);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(202091);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).dMe();
      a locala = a.zGc;
      a.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(202091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.nearbylivefriends.NearbyLiveFriendsSquareFragment
 * JD-Core Version:    0.7.0.1
 */