package com.tencent.mm.plugin.collect.ui;

import android.support.design.widget.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CollectBillListUI$6
  implements Runnable
{
  CollectBillListUI$6(CollectBillListUI paramCollectBillListUI, DatePickerDialogView paramDatePickerDialogView, BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public final void run()
  {
    AppMethodBeat.i(41190);
    ab.d("MicroMsg.CollectBillListUI", "view height: %d", new Object[] { Integer.valueOf(this.kQT.getHeight()) });
    this.kQU.t(this.kQT.getHeight());
    AppMethodBeat.o(41190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.6
 * JD-Core Version:    0.7.0.1
 */