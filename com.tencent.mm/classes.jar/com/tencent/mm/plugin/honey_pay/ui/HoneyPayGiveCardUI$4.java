package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class HoneyPayGiveCardUI$4
  implements View.OnClickListener
{
  HoneyPayGiveCardUI$4(HoneyPayGiveCardUI paramHoneyPayGiveCardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41862);
    ab.d(this.nIX.TAG, "click give btn");
    if (HoneyPayGiveCardUI.a(this.nIX))
    {
      this.nIX.hideTenpayKB();
      HoneyPayGiveCardUI.d(this.nIX);
      AppMethodBeat.o(41862);
      return;
    }
    ab.w(this.nIX.TAG, "over limit when click");
    AppMethodBeat.o(41862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.4
 * JD-Core Version:    0.7.0.1
 */