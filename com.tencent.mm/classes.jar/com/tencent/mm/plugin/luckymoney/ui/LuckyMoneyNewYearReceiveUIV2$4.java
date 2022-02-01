package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;

final class LuckyMoneyNewYearReceiveUIV2$4
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUIV2$4(LuckyMoneyNewYearReceiveUIV2 paramLuckyMoneyNewYearReceiveUIV2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(284122);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "goto BalanceManagerUI!");
    f.bq(this.KEw.getContext(), 1);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(284122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUIV2.4
 * JD-Core Version:    0.7.0.1
 */