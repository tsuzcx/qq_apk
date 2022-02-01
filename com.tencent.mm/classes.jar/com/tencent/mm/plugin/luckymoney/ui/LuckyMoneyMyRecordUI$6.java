package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyMyRecordUI$6
  implements View.OnClickListener
{
  LuckyMoneyMyRecordUI$6(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65641);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!bt.isNullOrNil(this.vxG.vqu)) {
      e.o(this.vxG, this.vxG.vqu, true);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(65641);
      return;
      ad.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.6
 * JD-Core Version:    0.7.0.1
 */