package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class CollectBillListUI$10
  implements MMPullDownView.c
{
  CollectBillListUI$10(CollectBillListUI paramCollectBillListUI) {}
  
  public final boolean aEW()
  {
    if (CollectBillListUI.f(this.iKn).getVisibility() == 0) {
      y.d("MicroMsg.CollectBillListUI", "empty view");
    }
    View localView;
    do
    {
      return true;
      localView = CollectBillListUI.e(this.iKn).getChildAt(CollectBillListUI.e(this.iKn).getChildCount() - 1);
    } while ((localView != null) && (localView.getBottom() <= CollectBillListUI.e(this.iKn).getHeight()) && (CollectBillListUI.e(this.iKn).getLastVisiblePosition() == CollectBillListUI.e(this.iKn).getAdapter().getCount() - 1));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.10
 * JD-Core Version:    0.7.0.1
 */