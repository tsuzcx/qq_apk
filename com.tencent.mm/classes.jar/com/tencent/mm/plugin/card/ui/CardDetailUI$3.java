package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.y;

final class CardDetailUI$3
  implements e.d
{
  CardDetailUI$3(CardDetailUI paramCardDetailUI) {}
  
  public final void aBA()
  {
    CardDetailUI.k(this.isj);
  }
  
  public final void aBB()
  {
    CardDetailUI.h(this.isj);
  }
  
  public final void aBC()
  {
    CardDetailUI.l(this.isj);
  }
  
  public final void aBD()
  {
    y.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
  }
  
  public final void aBx()
  {
    CardDetailUI.o(this.isj);
  }
  
  public final void aBy()
  {
    CardDetailUI.i(this.isj);
  }
  
  public final void aBz()
  {
    CardDetailUI.j(this.isj);
  }
  
  public final void b(b paramb)
  {
    CardDetailUI.a(this.isj, paramb);
    CardDetailUI.b(this.isj, paramb.azB());
    CardDetailUI.m(this.isj).ijW = CardDetailUI.n(this.isj);
  }
  
  public final void eB(boolean paramBoolean)
  {
    y.i("MicroMsg.CardDetailUI", "doMark()");
    CardDetailUI.p(this.isj);
    CardDetailUI.q(this.isj);
    CardDetailUI.a(this.isj, paramBoolean);
    if (CardDetailUI.r(this.isj).azr())
    {
      am.aAE().I(CardDetailUI.n(this.isj), l.yY(CardDetailUI.r(this.isj).azD()), 2);
      return;
    }
    am.aAE().I(CardDetailUI.n(this.isj), l.yY(CardDetailUI.r(this.isj).azD()), 1);
  }
  
  public final void yD(String paramString)
  {
    CardDetailUI.a(this.isj, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI.3
 * JD-Core Version:    0.7.0.1
 */