package com.tencent.mm.plugin.collect.ui;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class CollectBillListUI$6
  implements Runnable
{
  CollectBillListUI$6(CollectBillListUI paramCollectBillListUI, DatePickerDialogView paramDatePickerDialogView, BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public final void run()
  {
    AppMethodBeat.i(64052);
    Log.d("MicroMsg.CollectBillListUI", "view height: %d", new Object[] { Integer.valueOf(this.xch.getHeight()) });
    this.xci.setPeekHeight(this.xch.getHeight());
    AppMethodBeat.o(64052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.6
 * JD-Core Version:    0.7.0.1
 */