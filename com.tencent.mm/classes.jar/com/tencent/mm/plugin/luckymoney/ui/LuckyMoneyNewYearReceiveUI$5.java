package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyNewYearReceiveUI$5
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUI$5(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65665);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.KEd.finish();
    h.OAn.b(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.5
 * JD-Core Version:    0.7.0.1
 */