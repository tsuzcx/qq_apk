package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class MPVideoViewControlBar$3
  implements ap.a
{
  MPVideoViewControlBar$3(MPVideoViewControlBar paramMPVideoViewControlBar) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(14588);
    if (!MPVideoViewControlBar.b(this.kjV))
    {
      AppMethodBeat.o(14588);
      return false;
    }
    AppMethodBeat.o(14588);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.3
 * JD-Core Version:    0.7.0.1
 */