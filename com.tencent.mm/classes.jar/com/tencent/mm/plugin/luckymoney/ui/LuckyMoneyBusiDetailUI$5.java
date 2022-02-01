package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyBusiDetailUI$5
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$5(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65454);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.PQ(this.zct.yVv)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    af.a(this.zcr, 1, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.5
 * JD-Core Version:    0.7.0.1
 */