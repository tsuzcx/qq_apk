package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ExdeviceRankInfoUI$4
  implements MMPullDownView.d
{
  ExdeviceRankInfoUI$4(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean aEV()
  {
    int i = ExdeviceRankInfoUI.q(this.jFV).getFirstVisiblePosition();
    if (i == 0)
    {
      View localView = ExdeviceRankInfoUI.q(this.jFV).getChildAt(i);
      if ((localView != null) && (localView.getTop() >= 0)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.4
 * JD-Core Version:    0.7.0.1
 */