package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class LuckyMoneyNewYearReceiveUI$8
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUI$8(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65671);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
    paramView = new Intent();
    paramView.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.j(this.zft));
    c.b(this.zft, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.8
 * JD-Core Version:    0.7.0.1
 */