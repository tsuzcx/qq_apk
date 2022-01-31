package com.tencent.mm.plugin.luckymoney.ui;

import android.os.CountDownTimer;

final class LuckyMoneyAutoScrollItem$1$1
  extends CountDownTimer
{
  LuckyMoneyAutoScrollItem$1$1(LuckyMoneyAutoScrollItem.1 param1, long paramLong)
  {
    super(paramLong, 50L);
  }
  
  public final void onFinish()
  {
    if (LuckyMoneyAutoScrollItem.b(this.lTY.lTX) != null) {
      LuckyMoneyAutoScrollItem.b(this.lTY.lTX).arA();
    }
  }
  
  public final void onTick(long paramLong)
  {
    this.lTY.lTX.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(this.lTY.lTX));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.1.1
 * JD-Core Version:    0.7.0.1
 */