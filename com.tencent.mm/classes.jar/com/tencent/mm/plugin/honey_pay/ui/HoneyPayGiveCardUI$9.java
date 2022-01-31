package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.ui.widget.MMEditText;

final class HoneyPayGiveCardUI$9
  implements o.a
{
  HoneyPayGiveCardUI$9(HoneyPayGiveCardUI paramHoneyPayGiveCardUI) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(41867);
    this.nIX.hideTenpayKB();
    HoneyPayGiveCardUI.k(this.nIX).setVisibility(8);
    HoneyPayGiveCardUI.e(this.nIX).setVisibility(0);
    HoneyPayGiveCardUI.e(this.nIX).requestFocus();
    this.nIX.showVKB();
    AppMethodBeat.o(41867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.9
 * JD-Core Version:    0.7.0.1
 */