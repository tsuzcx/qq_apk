package com.tencent.mm.plugin.luckymoney.ui;

import android.os.CountDownTimer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyAutoScrollItem$1$1
  extends CountDownTimer
{
  LuckyMoneyAutoScrollItem$1$1(LuckyMoneyAutoScrollItem.1 param1, long paramLong)
  {
    super(paramLong, 50L);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(42560);
    if (LuckyMoneyAutoScrollItem.b(this.orf.ore) != null) {
      LuckyMoneyAutoScrollItem.b(this.orf.ore).aQl();
    }
    AppMethodBeat.o(42560);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(42559);
    this.orf.ore.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(this.orf.ore));
    AppMethodBeat.o(42559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.1.1
 * JD-Core Version:    0.7.0.1
 */