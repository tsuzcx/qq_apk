package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

final class WxaLuckyMoneyPrepareUI$16
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$16(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, ArrayList paramArrayList) {}
  
  public final void onClick(View paramView)
  {
    paramView = new b(this.lMx.mController.uMN, this.lAB);
    paramView.IC(WxaLuckyMoneyPrepareUI.f(this.lMx));
    paramView.wov = new WxaLuckyMoneyPrepareUI.16.1(this, paramView);
    paramView.IB(a.fromDPToPix(this.lMx.mController.uMN, 288));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.16
 * JD-Core Version:    0.7.0.1
 */