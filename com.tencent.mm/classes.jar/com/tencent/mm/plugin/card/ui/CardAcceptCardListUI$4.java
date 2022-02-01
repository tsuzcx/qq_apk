package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class CardAcceptCardListUI$4
  implements View.OnClickListener
{
  CardAcceptCardListUI$4(CardAcceptCardListUI paramCardAcceptCardListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113152);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    CardAcceptCardListUI.c(this.oLa);
    a.a(this, "com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(113152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.4
 * JD-Core Version:    0.7.0.1
 */