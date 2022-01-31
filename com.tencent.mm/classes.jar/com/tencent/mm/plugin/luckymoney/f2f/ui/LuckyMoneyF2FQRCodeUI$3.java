package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class LuckyMoneyF2FQRCodeUI$3
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyF2FQRCodeUI$3(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(42172);
    LuckyMoneyF2FQRCodeUI.a(this.olY, new d(this.olY, 1, false));
    LuckyMoneyF2FQRCodeUI.y(this.olY).sao = LuckyMoneyF2FQRCodeUI.x(this.olY);
    LuckyMoneyF2FQRCodeUI.y(this.olY).sap = LuckyMoneyF2FQRCodeUI.z(this.olY);
    LuckyMoneyF2FQRCodeUI.y(this.olY).crd();
    AppMethodBeat.o(42172);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.3
 * JD-Core Version:    0.7.0.1
 */