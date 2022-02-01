package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyIndexUI$3
  implements View.OnClickListener
{
  LuckyMoneyIndexUI$3(LuckyMoneyIndexUI paramLuckyMoneyIndexUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65600);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    LuckyMoneyIndexUI.a(this.zex, 1);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.3
 * JD-Core Version:    0.7.0.1
 */