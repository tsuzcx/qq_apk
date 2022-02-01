package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;

final class LuckyMoneyF2FQRCodeUI$13
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyF2FQRCodeUI$13(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(65078);
    paramView = new Intent(this.tbO, LuckyMoneyBeforeDetailUI.class);
    paramView.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.v(this.tbO));
    paramAdapterView = this.tbO;
    paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.adn(), "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramAdapterView.startActivity((Intent)paramView.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(65078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.13
 * JD-Core Version:    0.7.0.1
 */