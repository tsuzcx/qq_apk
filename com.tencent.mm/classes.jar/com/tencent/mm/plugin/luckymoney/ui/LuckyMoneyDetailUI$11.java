package com.tencent.mm.plugin.luckymoney.ui;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a;
import com.tencent.mm.particles.b;
import com.tencent.mm.particles.c;
import com.tencent.mm.particles.d;
import com.tencent.mm.particles.e;

final class LuckyMoneyDetailUI$11
  implements Runnable
{
  LuckyMoneyDetailUI$11(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(163725);
    LuckyMoneyDetailUI.a(this.vJe, (ViewGroup)this.vJe.findViewById(2131301813));
    Object localObject = LuckyMoneyDetailUI.I(this.vJe);
    b localb = LuckyMoneyDetailUI.J(this.vJe);
    a locala = new a((ViewGroup)localObject);
    localObject = new c(((ViewGroup)localObject).getContext(), localb, new d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).C(600.0F, 150.0F).D(-1000.0F, 250.0F).ap(-200.0F).aq(1500.0F);
    ((c)localObject).iMh = 600.0F;
    ((c)localObject).iMi = 300.0F;
    localObject = ((c)localObject).aQd();
    ((c)localObject).iLK = e.aQl();
    locala.gYk = ((c)localObject).aQe().aQf();
    locala.D(100, 400L);
    localObject = LuckyMoneyDetailUI.I(this.vJe);
    localb = LuckyMoneyDetailUI.J(this.vJe);
    locala = new a((ViewGroup)localObject);
    localObject = new c(((ViewGroup)localObject).getContext(), localb, new d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).C(-600.0F, 150.0F).D(-1000.0F, 250.0F).ap(200.0F).aq(1500.0F);
    ((c)localObject).iMh = 600.0F;
    ((c)localObject).iMi = 300.0F;
    localObject = ((c)localObject).aQd();
    ((c)localObject).iLK = e.aQl();
    locala.gYk = ((c)localObject).aQe().aQf();
    locala.D(100, 400L);
    AppMethodBeat.o(163725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.11
 * JD-Core Version:    0.7.0.1
 */