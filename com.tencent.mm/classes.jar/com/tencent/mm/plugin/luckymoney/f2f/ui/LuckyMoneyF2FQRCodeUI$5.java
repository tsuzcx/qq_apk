package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.f2f.a;

final class LuckyMoneyF2FQRCodeUI$5
  implements ShuffleView.b
{
  LuckyMoneyF2FQRCodeUI$5(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void eA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42174);
    if (paramInt2 == 8)
    {
      LuckyMoneyF2FQRCodeUI.F(this.olY).kJ("music" + (paramInt1 + 1) + ".m4a");
      arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.olY);
      arrayOfInt[4] += 1;
      AppMethodBeat.o(42174);
      return;
    }
    LuckyMoneyF2FQRCodeUI.F(this.olY).kJ("touch_card.m4a");
    int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.olY);
    arrayOfInt[2] += 1;
    AppMethodBeat.o(42174);
  }
  
  public final void eB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42176);
    if (paramInt2 == 8)
    {
      LuckyMoneyF2FQRCodeUI.F(this.olY).kJ("music" + (paramInt1 + 1) + ".m4a");
      AppMethodBeat.o(42176);
      return;
    }
    LuckyMoneyF2FQRCodeUI.F(this.olY).kJ("select_card.m4a");
    AppMethodBeat.o(42176);
  }
  
  public final void yj(int paramInt)
  {
    AppMethodBeat.i(42175);
    LuckyMoneyF2FQRCodeUI.J(this.olY);
    if (paramInt != 8)
    {
      LuckyMoneyF2FQRCodeUI.F(this.olY).kJ("select_card.m4a");
      arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.olY);
      arrayOfInt[3] += 1;
      AppMethodBeat.o(42175);
      return;
    }
    int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.olY);
    arrayOfInt[5] += 1;
    AppMethodBeat.o(42175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.5
 * JD-Core Version:    0.7.0.1
 */