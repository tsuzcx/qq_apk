package com.tencent.mm.plugin.card.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;

final class CardBaseUI$7
  implements b.a
{
  CardBaseUI$7(CardBaseUI paramCardBaseUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(87623);
    if (!paramBoolean)
    {
      this.kkO.baF();
      AppMethodBeat.o(87623);
      return true;
    }
    if ((paramFloat2 != -85.0F) && (paramFloat1 != -1000.0F))
    {
      CardBaseUI.a(this.kkO, paramFloat2);
      CardBaseUI.b(this.kkO, paramFloat1);
      am.bcj().S(CardBaseUI.a(this.kkO), CardBaseUI.b(this.kkO));
      this.kkO.baE();
    }
    if (!CardBaseUI.c(this.kkO))
    {
      CardBaseUI.d(this.kkO);
      o.a(2010, paramFloat1, paramFloat2, (int)paramDouble2);
    }
    AppMethodBeat.o(87623);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.7
 * JD-Core Version:    0.7.0.1
 */