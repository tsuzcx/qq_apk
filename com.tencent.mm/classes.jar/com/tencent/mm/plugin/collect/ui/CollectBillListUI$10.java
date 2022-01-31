package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class CollectBillListUI$10
  implements MMPullDownView.c
{
  CollectBillListUI$10(CollectBillListUI paramCollectBillListUI) {}
  
  public final boolean bim()
  {
    AppMethodBeat.i(41193);
    if (CollectBillListUI.f(this.kQS).getVisibility() == 0)
    {
      ab.d("MicroMsg.CollectBillListUI", "empty view");
      AppMethodBeat.o(41193);
      return true;
    }
    View localView = CollectBillListUI.e(this.kQS).getChildAt(CollectBillListUI.e(this.kQS).getChildCount() - 1);
    if ((localView != null) && (localView.getBottom() <= CollectBillListUI.e(this.kQS).getHeight()) && (CollectBillListUI.e(this.kQS).getLastVisiblePosition() == CollectBillListUI.e(this.kQS).getAdapter().getCount() - 1))
    {
      AppMethodBeat.o(41193);
      return true;
    }
    AppMethodBeat.o(41193);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.10
 * JD-Core Version:    0.7.0.1
 */