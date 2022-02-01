package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.ui.a.a.a;

final class LuckyMoneyPrepareUI$43
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$43(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, SpannableString paramSpannableString, l paraml1, l paraml2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65879);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!a.a.fyf().fye())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(65879);
      return;
    }
    if (LuckyMoneyPrepareUI.f(this.vAO).getText().toString().equals(this.vkH.toString())) {
      this.vAZ.onClick(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(65879);
      return;
      this.vBa.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.43
 * JD-Core Version:    0.7.0.1
 */