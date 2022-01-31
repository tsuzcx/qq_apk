package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Calendar;

final class CollectBillListUI$4
  implements View.OnClickListener
{
  CollectBillListUI$4(CollectBillListUI paramCollectBillListUI, DatePickerDialogView paramDatePickerDialogView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41188);
    if (CollectBillListUI.b(this.kQS) == null) {
      CollectBillListUI.a(this.kQS, Calendar.getInstance());
    }
    CollectBillListUI.b(this.kQS).clear();
    int i = this.kQT.getYear();
    int j = this.kQT.getMonth();
    int k = this.kQT.getDayOfMonth();
    CollectBillListUI.a(this.kQS, this.kQT.getDatePickerMode());
    long l;
    if (CollectBillListUI.c(this.kQS) == 2)
    {
      CollectBillListUI.b(this.kQS).set(1, i);
      l = CollectBillListUI.b(this.kQS).getTimeInMillis() / 1000L;
    }
    for (;;)
    {
      ab.i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(CollectBillListUI.c(this.kQS)), Long.valueOf(l) });
      CollectBillListUI.a(this.kQS, l);
      CollectBillListUI.d(this.kQS).dismiss();
      AppMethodBeat.o(41188);
      return;
      if (CollectBillListUI.c(this.kQS) == 1)
      {
        CollectBillListUI.b(this.kQS).set(1, i);
        CollectBillListUI.b(this.kQS).set(2, j);
        l = CollectBillListUI.b(this.kQS).getTimeInMillis() / 1000L;
      }
      else
      {
        CollectBillListUI.b(this.kQS).set(i, j, k);
        l = CollectBillListUI.b(this.kQS).getTimeInMillis() / 1000L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.4
 * JD-Core Version:    0.7.0.1
 */