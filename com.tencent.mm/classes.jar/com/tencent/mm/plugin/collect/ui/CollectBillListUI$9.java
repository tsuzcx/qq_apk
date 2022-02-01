package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class CollectBillListUI$9
  implements MMPullDownView.d
{
  CollectBillListUI$9(CollectBillListUI paramCollectBillListUI) {}
  
  public final boolean cbb()
  {
    AppMethodBeat.i(64054);
    int i = CollectBillListUI.e(this.pdX).getFirstVisiblePosition();
    if (i == 0)
    {
      View localView = CollectBillListUI.e(this.pdX).getChildAt(i);
      if ((localView != null) && (localView.getX() == 0.0F))
      {
        AppMethodBeat.o(64054);
        return true;
      }
    }
    AppMethodBeat.o(64054);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.9
 * JD-Core Version:    0.7.0.1
 */