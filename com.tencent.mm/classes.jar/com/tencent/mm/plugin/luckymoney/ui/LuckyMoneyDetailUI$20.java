package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class LuckyMoneyDetailUI$20
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$20(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213373);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.LuckyMoneyDetailUI", "click tips icon");
    LuckyMoneyDetailUI.S(this.zee);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.20
 * JD-Core Version:    0.7.0.1
 */