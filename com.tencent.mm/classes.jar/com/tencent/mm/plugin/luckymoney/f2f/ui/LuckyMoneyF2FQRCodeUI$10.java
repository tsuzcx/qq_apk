package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.a;
import java.util.Random;

final class LuckyMoneyF2FQRCodeUI$10
  implements com.tencent.mm.particles.b
{
  LuckyMoneyF2FQRCodeUI$10(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final com.tencent.mm.particles.a.b a(Random paramRandom)
  {
    AppMethodBeat.i(142024);
    int i = paramRandom.nextInt(100);
    if (i < 16)
    {
      if (LuckyMoneyF2FQRCodeUI.i(this.olY) == null) {
        LuckyMoneyF2FQRCodeUI.a(this.olY, LuckyMoneyF2FQRCodeUI.a(this.olY, 2130839394, 36));
      }
      paramRandom = new a(LuckyMoneyF2FQRCodeUI.i(this.olY));
      AppMethodBeat.o(142024);
      return paramRandom;
    }
    if (i < 33)
    {
      if (LuckyMoneyF2FQRCodeUI.j(this.olY) == null) {
        LuckyMoneyF2FQRCodeUI.b(this.olY, LuckyMoneyF2FQRCodeUI.a(this.olY, 2130839395, 36));
      }
      paramRandom = new a(LuckyMoneyF2FQRCodeUI.j(this.olY));
      AppMethodBeat.o(142024);
      return paramRandom;
    }
    if (i < 50)
    {
      if (LuckyMoneyF2FQRCodeUI.k(this.olY) == null) {
        LuckyMoneyF2FQRCodeUI.c(this.olY, LuckyMoneyF2FQRCodeUI.a(this.olY, 2130839396, 36));
      }
      paramRandom = new a(LuckyMoneyF2FQRCodeUI.k(this.olY));
      AppMethodBeat.o(142024);
      return paramRandom;
    }
    if (i < 70)
    {
      if (LuckyMoneyF2FQRCodeUI.l(this.olY) == null) {
        LuckyMoneyF2FQRCodeUI.d(this.olY, LuckyMoneyF2FQRCodeUI.a(this.olY, 2130839389, 36));
      }
      paramRandom = new a(LuckyMoneyF2FQRCodeUI.l(this.olY));
      AppMethodBeat.o(142024);
      return paramRandom;
    }
    if (i < 90)
    {
      if (LuckyMoneyF2FQRCodeUI.m(this.olY) == null) {
        LuckyMoneyF2FQRCodeUI.e(this.olY, LuckyMoneyF2FQRCodeUI.a(this.olY, 2130839390, 36));
      }
      paramRandom = new a(LuckyMoneyF2FQRCodeUI.m(this.olY));
      AppMethodBeat.o(142024);
      return paramRandom;
    }
    if (LuckyMoneyF2FQRCodeUI.n(this.olY) == null) {
      LuckyMoneyF2FQRCodeUI.f(this.olY, LuckyMoneyF2FQRCodeUI.a(this.olY, 2130839391, 36));
    }
    paramRandom = new a(LuckyMoneyF2FQRCodeUI.n(this.olY));
    AppMethodBeat.o(142024);
    return paramRandom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.10
 * JD-Core Version:    0.7.0.1
 */