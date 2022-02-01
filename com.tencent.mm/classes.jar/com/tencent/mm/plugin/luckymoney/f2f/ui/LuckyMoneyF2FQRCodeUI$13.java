package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;

final class LuckyMoneyF2FQRCodeUI$13
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyF2FQRCodeUI$13(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(65078);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    paramView = new Intent(this.KpK, LuckyMoneyBeforeDetailUI.class);
    paramView.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.v(this.KpK));
    paramAdapterView = this.KpK;
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, paramView.aYi(), "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramAdapterView.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(65078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.13
 * JD-Core Version:    0.7.0.1
 */