package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import com.tencent.mm.ui.base.MMPullDownView.a;
import java.util.List;

final class ExdeviceRankInfoUI$24
  implements MMPullDownView.a
{
  ExdeviceRankInfoUI$24(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.jFV;
    if ((ExdeviceRankInfoUI.a(this.jFV) != null) && (ExdeviceRankInfoUI.a(this.jFV).size() != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ExdeviceRankInfoUI.b(paramMotionEvent, bool);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.24
 * JD-Core Version:    0.7.0.1
 */