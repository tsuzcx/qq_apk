package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class CardHomePageUI$5
  implements View.OnClickListener
{
  CardHomePageUI$5(CardHomePageUI paramCardHomePageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88487);
    paramView = new Intent(this.kwf, CardIndexUI.class);
    paramView.putExtra("key_card_type", 1);
    this.kwf.startActivity(paramView);
    h.qsU.e(11324, new Object[] { "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.5
 * JD-Core Version:    0.7.0.1
 */