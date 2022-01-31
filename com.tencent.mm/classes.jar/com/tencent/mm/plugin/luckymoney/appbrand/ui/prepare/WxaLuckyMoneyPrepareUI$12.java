package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class WxaLuckyMoneyPrepareUI$12
  implements View.OnTouchListener
{
  WxaLuckyMoneyPrepareUI$12(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.lMx.VH();
      this.lMx.XM();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.12
 * JD-Core Version:    0.7.0.1
 */