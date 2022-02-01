package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a;
import kotlin.Metadata;

@a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorSecondaryDeviceAffinityUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorSecondaryDeviceUI;", "()V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveAnchorSecondaryDeviceAffinityUI
  extends FinderLiveAnchorSecondaryDeviceUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorSecondaryDeviceAffinityUI
 * JD-Core Version:    0.7.0.1
 */