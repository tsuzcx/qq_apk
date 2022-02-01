package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyDetailUI$25
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$25(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213377);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.PS(this.zct.yVv)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    af.a(this.zee, 1, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.25
 * JD-Core Version:    0.7.0.1
 */