package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.i;

final class LuckyMoneyHistoryEnvelopeUI$6
  implements DialogInterface.OnShowListener
{
  LuckyMoneyHistoryEnvelopeUI$6(LuckyMoneyHistoryEnvelopeUI paramLuckyMoneyHistoryEnvelopeUI, i parami) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(284514);
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramDialogInterface = this.ubf.getWindow().getDecorView();
      i = paramDialogInterface.getSystemUiVisibility();
      if (!aw.isDarkMode()) {
        break label52;
      }
      i &= 0xFFFFDFFF;
    }
    for (;;)
    {
      paramDialogInterface.setSystemUiVisibility(i);
      AppMethodBeat.o(284514);
      return;
      label52:
      i |= 0x2000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.6
 * JD-Core Version:    0.7.0.1
 */