package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class LuckyMoneyNewYearReceiveUIV2$3
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUIV2$3(LuckyMoneyNewYearReceiveUIV2 paramLuckyMoneyNewYearReceiveUIV2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(284118);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "goto detail!");
    paramView = new Intent();
    paramView.putExtra("key_native_url", LuckyMoneyNewYearReceiveUIV2.k(this.KEw));
    c.b(this.KEw.getContext(), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(284118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUIV2.3
 * JD-Core Version:    0.7.0.1
 */