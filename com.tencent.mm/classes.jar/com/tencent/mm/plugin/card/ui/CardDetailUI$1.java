package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;

final class CardDetailUI$1
  implements b.a
{
  CardDetailUI$1(CardDetailUI paramCardDetailUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(88272);
    if (!paramBoolean)
    {
      AppMethodBeat.o(88272);
      return true;
    }
    if ((CardDetailUI.a(this.ktq) == -85.0F) && (CardDetailUI.b(this.ktq) == -1000.0F))
    {
      CardDetailUI.a(this.ktq, paramFloat2);
      CardDetailUI.b(this.ktq, paramFloat1);
      am.bcj().S(CardDetailUI.a(this.ktq), CardDetailUI.b(this.ktq));
    }
    i locali = CardDetailUI.c(this.ktq);
    paramFloat1 = CardDetailUI.b(this.ktq);
    paramFloat2 = CardDetailUI.a(this.ktq);
    synchronized (locali.clk)
    {
      locali.dZu = paramFloat2;
      locali.dZv = paramFloat1;
      if (CardDetailUI.d(this.ktq))
      {
        CardDetailUI.e(this.ktq);
        CardDetailUI.f(this.ktq);
      }
      CardDetailUI.g(this.ktq);
      AppMethodBeat.o(88272);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI.1
 * JD-Core Version:    0.7.0.1
 */