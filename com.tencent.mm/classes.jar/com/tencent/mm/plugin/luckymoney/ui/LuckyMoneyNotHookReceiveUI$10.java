package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LuckyMoneyNotHookReceiveUI$10
  implements View.OnClickListener
{
  LuckyMoneyNotHookReceiveUI$10(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65736);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    LuckyMoneyNotHookReceiveUI.a(this.zgg, true);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.10
 * JD-Core Version:    0.7.0.1
 */