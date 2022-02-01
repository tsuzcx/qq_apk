package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LuckyMoneyBusiDetailUI$14
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$14(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65463);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.vHt.finish();
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.14
 * JD-Core Version:    0.7.0.1
 */