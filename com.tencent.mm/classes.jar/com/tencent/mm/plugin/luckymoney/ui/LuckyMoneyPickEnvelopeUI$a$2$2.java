package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.ui.base.n.d;

final class LuckyMoneyPickEnvelopeUI$a$2$2
  implements n.d
{
  LuckyMoneyPickEnvelopeUI$a$2$2(LuckyMoneyPickEnvelopeUI.a.2 param2, LuckyMoneyPickEnvelopeUI.b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(42916);
    if (paramMenuItem.getItemId() == 0) {
      LuckyMoneyPickEnvelopeUI.e(this.ovZ.ovY.ovW, this.owa.opR.materialId);
    }
    AppMethodBeat.o(42916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a.2.2
 * JD-Core Version:    0.7.0.1
 */