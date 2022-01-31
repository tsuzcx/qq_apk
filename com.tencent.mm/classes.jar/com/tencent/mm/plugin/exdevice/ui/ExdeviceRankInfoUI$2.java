package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ExdeviceRankInfoUI$2
  implements MMPullDownView.c
{
  ExdeviceRankInfoUI$2(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean aEW()
  {
    View localView = ExdeviceRankInfoUI.q(this.jFV).getChildAt(ExdeviceRankInfoUI.q(this.jFV).getChildCount() - 1);
    int i = ExdeviceRankInfoUI.q(this.jFV).getCount();
    return (i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceRankInfoUI.q(this.jFV).getHeight()) && (ExdeviceRankInfoUI.q(this.jFV).getLastVisiblePosition() == i - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.2
 * JD-Core Version:    0.7.0.1
 */