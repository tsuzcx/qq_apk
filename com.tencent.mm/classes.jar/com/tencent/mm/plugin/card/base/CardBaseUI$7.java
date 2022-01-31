package com.tencent.mm.plugin.card.base;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;

final class CardBaseUI$7
  implements a.a
{
  CardBaseUI$7(CardBaseUI paramCardBaseUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean)
    {
      this.ijO.ayZ();
      return true;
    }
    if ((paramFloat2 != -85.0F) && (paramFloat1 != -1000.0F))
    {
      CardBaseUI.a(this.ijO, paramFloat2);
      CardBaseUI.b(this.ijO, paramFloat1);
      am.aAy().N(CardBaseUI.a(this.ijO), CardBaseUI.b(this.ijO));
      this.ijO.ayY();
    }
    if (!CardBaseUI.c(this.ijO))
    {
      CardBaseUI.d(this.ijO);
      o.a(2010, paramFloat1, paramFloat2, (int)paramDouble2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.7
 * JD-Core Version:    0.7.0.1
 */