package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class WxaLuckyMoneyPrepareUI$16$1
  implements b.a
{
  WxaLuckyMoneyPrepareUI$16$1(WxaLuckyMoneyPrepareUI.16 param16, b paramb) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(142021);
    this.jxY.hide();
    if (paramBoolean) {
      WxaLuckyMoneyPrepareUI.h(this.ojX.ojQ).setText((CharSequence)paramObject1);
    }
    WxaLuckyMoneyPrepareUI.a(this.ojX.ojQ, this.jxY.dPp());
    AppMethodBeat.o(142021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.16.1
 * JD-Core Version:    0.7.0.1
 */