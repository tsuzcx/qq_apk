package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyNewYearReceiveUIV2$13
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUIV2$13(LuckyMoneyNewYearReceiveUIV2 paramLuckyMoneyNewYearReceiveUIV2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(284506);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.KEw.finish();
    h.OAn.b(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(284506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUIV2.13
 * JD-Core Version:    0.7.0.1
 */