package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LuckyMoneyBusiDetailUI$13
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$13(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65462);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    LuckyMoneyBusiDetailUI.f(this.zcr).setVisibility(0);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.13
 * JD-Core Version:    0.7.0.1
 */