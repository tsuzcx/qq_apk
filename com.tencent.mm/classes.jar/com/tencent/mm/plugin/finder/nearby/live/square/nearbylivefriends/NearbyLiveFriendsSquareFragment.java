package com.tencent.mm.plugin.finder.nearby.live.square.nearbylivefriends;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.report.a;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.b;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/nearbylivefriends/NearbyLiveFriendsSquareFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "getClickTabId", "", "onAttach", "", "context", "Landroid/content/Context;", "onPause", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLiveFriendsSquareFragment
  extends NearbyLiveSquareFragment
{
  public final String eEt()
  {
    return "1001";
  }
  
  public final void onAttach(Context paramContext)
  {
    AppMethodBeat.i(341113);
    s.u(paramContext, "context");
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("key_use_dark_style", 0);
    if (getArguments() == null) {
      setArguments(localBundle1);
    }
    for (;;)
    {
      super.onAttach(paramContext);
      AppMethodBeat.o(341113);
      return;
      Bundle localBundle2 = getArguments();
      if (localBundle2 != null) {
        localBundle2.putAll(localBundle1);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(341128);
    super.onPause();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).eFC();
      a.ELu.c((AbsNearByFragment)localNearbyLiveSquareTabFragment);
    }
    AppMethodBeat.o(341128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.nearbylivefriends.NearbyLiveFriendsSquareFragment
 * JD-Core Version:    0.7.0.1
 */