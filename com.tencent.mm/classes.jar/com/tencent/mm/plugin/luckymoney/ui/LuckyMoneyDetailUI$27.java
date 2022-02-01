package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyDetailUI$27
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$27(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(270827);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    h.IzE.a(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.We(this.EGT.Ezs)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    ag.a(this.EIF, 1, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.27
 * JD-Core Version:    0.7.0.1
 */