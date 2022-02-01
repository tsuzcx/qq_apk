package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LuckyMoneyDetailUI$24
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$24(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163735);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    LuckyMoneyDetailUI.a(this.vJe, true);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.24
 * JD-Core Version:    0.7.0.1
 */