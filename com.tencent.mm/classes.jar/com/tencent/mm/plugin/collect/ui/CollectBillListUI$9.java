package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class CollectBillListUI$9
  implements MMPullDownView.d
{
  CollectBillListUI$9(CollectBillListUI paramCollectBillListUI) {}
  
  public final boolean aEV()
  {
    int i = CollectBillListUI.e(this.iKn).getFirstVisiblePosition();
    if (i == 0)
    {
      View localView = CollectBillListUI.e(this.iKn).getChildAt(i);
      if ((localView != null) && (localView.getX() == 0.0F)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.9
 * JD-Core Version:    0.7.0.1
 */