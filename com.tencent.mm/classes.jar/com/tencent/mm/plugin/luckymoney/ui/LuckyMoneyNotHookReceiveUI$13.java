package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class LuckyMoneyNotHookReceiveUI$13
  implements View.OnClickListener
{
  LuckyMoneyNotHookReceiveUI$13(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65736);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    LuckyMoneyNotHookReceiveUI.e(this.ELl);
    this.ELl.finish();
    h.IzE.a(22105, new Object[] { Integer.valueOf(4), Long.valueOf(Util.ticksToNow(LuckyMoneyNotHookReceiveUI.f(this.ELl)) / 1000L) });
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.13
 * JD-Core Version:    0.7.0.1
 */