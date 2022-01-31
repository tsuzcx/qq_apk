package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPickEnvelopeUI$c$2$1
  implements Runnable
{
  LuckyMoneyPickEnvelopeUI$c$2$1(LuckyMoneyPickEnvelopeUI.c.2 param2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(42923);
    if ((LuckyMoneyPickEnvelopeUI.c.a(this.owm.owl) != null) && (LuckyMoneyPickEnvelopeUI.c.a(this.owm.owl).isShowing())) {
      LuckyMoneyPickEnvelopeUI.c.a(this.owm.owl).dismiss();
    }
    if (!this.fCf)
    {
      this.owm.owl.owd.setVisibility(0);
      this.owm.owl.owe.setVisibility(0);
      this.owm.owl.owf.setVisibility(8);
      this.owm.owl.owg.setVisibility(0);
      AppMethodBeat.o(42923);
      return;
    }
    this.owm.owl.owd.setVisibility(8);
    AppMethodBeat.o(42923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.c.2.1
 * JD-Core Version:    0.7.0.1
 */