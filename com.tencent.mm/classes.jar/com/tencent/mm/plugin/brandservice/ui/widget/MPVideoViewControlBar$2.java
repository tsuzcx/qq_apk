package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class MPVideoViewControlBar$2
  implements ap.a
{
  MPVideoViewControlBar$2(MPVideoViewControlBar paramMPVideoViewControlBar) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(14587);
    this.kjV.setVisibility(8);
    MPVideoViewControlBar.a(this.kjV).stopTimer();
    AppMethodBeat.o(14587);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.2
 * JD-Core Version:    0.7.0.1
 */