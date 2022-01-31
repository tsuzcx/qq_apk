package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.sdk.platformtools.bk;

final class CardListSelectedUI$5
  implements View.OnClickListener
{
  CardListSelectedUI$5(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.ivL.ivI)) {
      b.a(this.ivL, this.ivL.ivI, this.ivL.getString(a.g.card_invoice_url_slogan));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.5
 * JD-Core Version:    0.7.0.1
 */