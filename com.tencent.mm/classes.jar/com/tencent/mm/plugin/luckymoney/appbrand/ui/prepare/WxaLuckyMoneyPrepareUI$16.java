package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

final class WxaLuckyMoneyPrepareUI$16
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$16(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, ArrayList paramArrayList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42072);
    paramView = new b(this.ojQ.getContext(), this.nXM);
    paramView.Rw(WxaLuckyMoneyPrepareUI.f(this.ojQ));
    paramView.AIW = new WxaLuckyMoneyPrepareUI.16.1(this, paramView);
    paramView.Rv(a.fromDPToPix(this.ojQ.getContext(), 288));
    paramView.show();
    AppMethodBeat.o(42072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.16
 * JD-Core Version:    0.7.0.1
 */