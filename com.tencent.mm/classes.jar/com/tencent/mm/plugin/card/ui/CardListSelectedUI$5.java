package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.sdk.platformtools.bo;

final class CardListSelectedUI$5
  implements View.OnClickListener
{
  CardListSelectedUI$5(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88559);
    if (!bo.isNullOrNil(this.kwP.kwM)) {
      b.a(this.kwP, this.kwP.kwM, this.kwP.getString(2131297967));
    }
    AppMethodBeat.o(88559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.5
 * JD-Core Version:    0.7.0.1
 */