package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.a;
import java.util.List;

final class ExdeviceRankInfoUI$24
  implements MMPullDownView.a
{
  ExdeviceRankInfoUI$24(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20162);
    paramMotionEvent = this.lPt;
    if ((ExdeviceRankInfoUI.a(this.lPt) != null) && (ExdeviceRankInfoUI.a(this.lPt).size() != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ExdeviceRankInfoUI.b(paramMotionEvent, bool);
      AppMethodBeat.o(20162);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.24
 * JD-Core Version:    0.7.0.1
 */