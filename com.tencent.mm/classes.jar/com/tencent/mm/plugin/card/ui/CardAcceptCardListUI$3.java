package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.LinkedList;

final class CardAcceptCardListUI$3
  implements View.OnClickListener
{
  CardAcceptCardListUI$3(CardAcceptCardListUI paramCardAcceptCardListUI) {}
  
  public final void onClick(View paramView)
  {
    if (CardAcceptCardListUI.a(this.irE))
    {
      CardAcceptCardListUI.a(this.irE, CardAcceptCardListUI.b(this.irE));
      return;
    }
    paramView = this.irE;
    LinkedList localLinkedList = CardAcceptCardListUI.b(this.irE);
    paramView.ew(true);
    paramView = new com.tencent.mm.plugin.card.model.p(localLinkedList, paramView.bZe, paramView.irz, paramView.irA, paramView.iry);
    g.DO().dJT.a(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.3
 * JD-Core Version:    0.7.0.1
 */