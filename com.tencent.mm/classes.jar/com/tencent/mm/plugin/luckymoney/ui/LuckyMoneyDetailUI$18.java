package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.report.service.g;

final class LuckyMoneyDetailUI$18
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$18(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163732);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    g.yxI.f(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.JQ(this.vHv.vAB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    z.a(this.vJe, 1, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.18
 * JD-Core Version:    0.7.0.1
 */