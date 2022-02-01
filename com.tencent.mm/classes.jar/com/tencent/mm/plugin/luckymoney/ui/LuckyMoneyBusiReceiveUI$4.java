package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyBusiReceiveUI$4
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$4(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65486);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    if (LuckyMoneyBusiReceiveUI.f(this.zcJ).isChecked()) {
      h.CyF.a(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.zcJ)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(this.zcJ).yWR });
    }
    for (;;)
    {
      LuckyMoneyBusiReceiveUI.i(this.zcJ);
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(65486);
      return;
      h.CyF.a(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.zcJ)), Integer.valueOf(2), "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */