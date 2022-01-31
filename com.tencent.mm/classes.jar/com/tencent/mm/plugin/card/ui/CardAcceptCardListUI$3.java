package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.LinkedList;

final class CardAcceptCardListUI$3
  implements View.OnClickListener
{
  CardAcceptCardListUI$3(CardAcceptCardListUI paramCardAcceptCardListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88217);
    if (CardAcceptCardListUI.a(this.ksL))
    {
      CardAcceptCardListUI.a(this.ksL, CardAcceptCardListUI.b(this.ksL));
      AppMethodBeat.o(88217);
      return;
    }
    paramView = this.ksL;
    LinkedList localLinkedList = CardAcceptCardListUI.b(this.ksL);
    paramView.fV(true);
    paramView = new com.tencent.mm.plugin.card.model.p(localLinkedList, paramView.cHp, paramView.ksG, paramView.ksH, paramView.ksF);
    g.RK().eHt.a(paramView, 0);
    AppMethodBeat.o(88217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.3
 * JD-Core Version:    0.7.0.1
 */