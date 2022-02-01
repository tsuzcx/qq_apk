package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LuckyMoneyTextInputView$2
  implements View.OnClickListener
{
  LuckyMoneyTextInputView$2(LuckyMoneyTextInputView paramLuckyMoneyTextInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65932);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyTextInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (LuckyMoneyTextInputView.b(this.ziJ) != null) {
      LuckyMoneyTextInputView.b(this.ziJ).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyTextInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView.2
 * JD-Core Version:    0.7.0.1
 */