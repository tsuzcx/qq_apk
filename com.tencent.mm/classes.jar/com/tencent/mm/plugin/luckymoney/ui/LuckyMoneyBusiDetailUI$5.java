package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.report.service.g;

final class LuckyMoneyBusiDetailUI$5
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$5(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65454);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    g.yxI.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.JO(this.vHv.vAB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    z.a(this.vHt, 1, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.5
 * JD-Core Version:    0.7.0.1
 */