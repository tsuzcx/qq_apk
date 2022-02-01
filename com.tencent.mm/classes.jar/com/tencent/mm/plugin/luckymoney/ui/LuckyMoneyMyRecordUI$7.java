package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LuckyMoneyMyRecordUI$7
  implements View.OnClickListener
{
  LuckyMoneyMyRecordUI$7(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65642);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.vJK.showDialog(1);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.7
 * JD-Core Version:    0.7.0.1
 */