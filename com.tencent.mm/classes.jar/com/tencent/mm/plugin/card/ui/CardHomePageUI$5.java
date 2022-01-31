package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class CardHomePageUI$5
  implements View.OnClickListener
{
  CardHomePageUI$5(CardHomePageUI paramCardHomePageUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.ivb, CardIndexUI.class);
    paramView.putExtra("key_card_type", 1);
    this.ivb.startActivity(paramView);
    h.nFQ.f(11324, new Object[] { "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.5
 * JD-Core Version:    0.7.0.1
 */