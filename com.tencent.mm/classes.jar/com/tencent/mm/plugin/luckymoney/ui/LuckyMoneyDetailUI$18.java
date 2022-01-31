package com.tencent.mm.plugin.luckymoney.ui;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a;
import com.tencent.mm.particles.b;
import com.tencent.mm.particles.c;
import com.tencent.mm.particles.d;
import com.tencent.mm.particles.e;

final class LuckyMoneyDetailUI$18
  implements Runnable
{
  LuckyMoneyDetailUI$18(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(42667);
    Object localObject = LuckyMoneyDetailUI.J(this.otz);
    b localb = LuckyMoneyDetailUI.K(this.otz);
    a locala = new a((ViewGroup)localObject);
    localObject = new c(((ViewGroup)localObject).getContext(), localb, new d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).H(600.0F, 150.0F).I(-1000.0F, 250.0F).ai(-200.0F).aj(1500.0F);
    ((c)localObject).ghz = 600.0F;
    ((c)localObject).ghA = 300.0F;
    localObject = ((c)localObject).anR();
    ((c)localObject).ghc = e.aoa();
    locala.ggQ = ((c)localObject).anS().anT();
    locala.A(100, 400L);
    localObject = LuckyMoneyDetailUI.J(this.otz);
    localb = LuckyMoneyDetailUI.K(this.otz);
    locala = new a((ViewGroup)localObject);
    localObject = new c(((ViewGroup)localObject).getContext(), localb, new d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).H(-600.0F, 150.0F).I(-1000.0F, 250.0F).ai(200.0F).aj(1500.0F);
    ((c)localObject).ghz = 600.0F;
    ((c)localObject).ghA = 300.0F;
    localObject = ((c)localObject).anR();
    ((c)localObject).ghc = e.aoa();
    locala.ggQ = ((c)localObject).anS().anT();
    locala.A(100, 400L);
    AppMethodBeat.o(42667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.18
 * JD-Core Version:    0.7.0.1
 */