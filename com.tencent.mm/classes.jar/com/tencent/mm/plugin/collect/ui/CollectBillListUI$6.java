package com.tencent.mm.plugin.collect.ui;

import android.support.design.widget.BottomSheetBehavior;
import com.tencent.mm.sdk.platformtools.y;

final class CollectBillListUI$6
  implements Runnable
{
  CollectBillListUI$6(CollectBillListUI paramCollectBillListUI, DatePickerDialogView paramDatePickerDialogView, BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public final void run()
  {
    y.d("MicroMsg.CollectBillListUI", "view height: %d", new Object[] { Integer.valueOf(this.iKo.getHeight()) });
    this.iKp.u(this.iKo.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.6
 * JD-Core Version:    0.7.0.1
 */