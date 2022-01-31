package com.tencent.mm.plugin.luckymoney.sns;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class SnsLuckyMoneyPrepareUI$18
  implements View.OnTouchListener
{
  SnsLuckyMoneyPrepareUI$18(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.lTI.VH();
      this.lTI.XM();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.18
 * JD-Core Version:    0.7.0.1
 */