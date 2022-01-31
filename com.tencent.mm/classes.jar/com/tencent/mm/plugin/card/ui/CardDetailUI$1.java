package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;

final class CardDetailUI$1
  implements a.a
{
  CardDetailUI$1(CardDetailUI paramCardDetailUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return true;
    }
    if ((CardDetailUI.a(this.isj) == -85.0F) && (CardDetailUI.b(this.isj) == -1000.0F))
    {
      CardDetailUI.a(this.isj, paramFloat2);
      CardDetailUI.b(this.isj, paramFloat1);
      am.aAy().N(CardDetailUI.a(this.isj), CardDetailUI.b(this.isj));
    }
    i locali = CardDetailUI.c(this.isj);
    paramFloat1 = CardDetailUI.b(this.isj);
    paramFloat2 = CardDetailUI.a(this.isj);
    synchronized (locali.ikx)
    {
      locali.dia = paramFloat2;
      locali.dib = paramFloat1;
      if (CardDetailUI.d(this.isj))
      {
        CardDetailUI.e(this.isj);
        CardDetailUI.f(this.isj);
      }
      CardDetailUI.g(this.isj);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI.1
 * JD-Core Version:    0.7.0.1
 */