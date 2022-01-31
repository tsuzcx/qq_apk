package com.tencent.mm.plugin.luckymoney.ui;

import android.view.ViewGroup;
import com.tencent.mm.plugin.luckymoney.particles.a;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.particles.c;
import com.tencent.mm.plugin.luckymoney.particles.d;
import com.tencent.mm.plugin.luckymoney.particles.e;

final class LuckyMoneyDetailUI$7
  implements Runnable
{
  LuckyMoneyDetailUI$7(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void run()
  {
    Object localObject = LuckyMoneyDetailUI.t(this.lVz);
    b localb = LuckyMoneyDetailUI.u(this.lVz);
    a locala = new a((ViewGroup)localObject);
    localObject = new c(((ViewGroup)localObject).getContext(), localb, new d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).R(600.0F, 150.0F).S(-1000.0F, 250.0F).at(-200.0F).au(1500.0F);
    ((c)localObject).lSK = 600.0F;
    ((c)localObject).lSL = 300.0F;
    localObject = ((c)localObject).bfP();
    ((c)localObject).lSn = e.bfT();
    locala.lSb = ((c)localObject).bfQ().bfR();
    locala.D(100, 400L);
    localObject = LuckyMoneyDetailUI.t(this.lVz);
    localb = LuckyMoneyDetailUI.u(this.lVz);
    locala = new a((ViewGroup)localObject);
    localObject = new c(((ViewGroup)localObject).getContext(), localb, new d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).R(-600.0F, 150.0F).S(-1000.0F, 250.0F).at(200.0F).au(1500.0F);
    ((c)localObject).lSK = 600.0F;
    ((c)localObject).lSL = 300.0F;
    localObject = ((c)localObject).bfP();
    ((c)localObject).lSn = e.bfT();
    locala.lSb = ((c)localObject).bfQ().bfR();
    locala.D(100, 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.7
 * JD-Core Version:    0.7.0.1
 */