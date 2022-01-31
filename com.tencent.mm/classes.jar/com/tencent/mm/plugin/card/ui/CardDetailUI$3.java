package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.ab;

final class CardDetailUI$3
  implements e.d
{
  CardDetailUI$3(CardDetailUI paramCardDetailUI) {}
  
  public final void Ie(String paramString)
  {
    AppMethodBeat.i(88275);
    CardDetailUI.a(this.ktq, paramString);
    AppMethodBeat.o(88275);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(88280);
    CardDetailUI.a(this.ktq, paramb);
    CardDetailUI.b(this.ktq, paramb.bbh());
    CardDetailUI.m(this.ktq).kkW = CardDetailUI.n(this.ktq);
    AppMethodBeat.o(88280);
  }
  
  public final void bdo()
  {
    AppMethodBeat.i(88281);
    CardDetailUI.o(this.ktq);
    AppMethodBeat.o(88281);
  }
  
  public final void bdp()
  {
    AppMethodBeat.i(88274);
    CardDetailUI.i(this.ktq);
    AppMethodBeat.o(88274);
  }
  
  public final void bdq()
  {
    AppMethodBeat.i(88276);
    CardDetailUI.j(this.ktq);
    AppMethodBeat.o(88276);
  }
  
  public final void bdr()
  {
    AppMethodBeat.i(88277);
    CardDetailUI.k(this.ktq);
    AppMethodBeat.o(88277);
  }
  
  public final void bds()
  {
    AppMethodBeat.i(88278);
    CardDetailUI.h(this.ktq);
    AppMethodBeat.o(88278);
  }
  
  public final void bdt()
  {
    AppMethodBeat.i(88279);
    CardDetailUI.l(this.ktq);
    AppMethodBeat.o(88279);
  }
  
  public final void bdu()
  {
    AppMethodBeat.i(88282);
    ab.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
    AppMethodBeat.o(88282);
  }
  
  public final void ga(boolean paramBoolean)
  {
    AppMethodBeat.i(88283);
    ab.i("MicroMsg.CardDetailUI", "doMark()");
    CardDetailUI.p(this.ktq);
    CardDetailUI.q(this.ktq);
    CardDetailUI.a(this.ktq, paramBoolean);
    if (CardDetailUI.r(this.ktq).baX())
    {
      am.bcp().W(CardDetailUI.n(this.ktq), l.IH(CardDetailUI.r(this.ktq).bbj()), 2);
      AppMethodBeat.o(88283);
      return;
    }
    am.bcp().W(CardDetailUI.n(this.ktq), l.IH(CardDetailUI.r(this.ktq).bbj()), 1);
    AppMethodBeat.o(88283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI.3
 * JD-Core Version:    0.7.0.1
 */