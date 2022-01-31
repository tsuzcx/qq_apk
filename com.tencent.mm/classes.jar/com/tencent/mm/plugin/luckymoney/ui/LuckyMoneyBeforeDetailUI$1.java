package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyBeforeDetailUI$1
  implements Runnable
{
  LuckyMoneyBeforeDetailUI$1(LuckyMoneyBeforeDetailUI paramLuckyMoneyBeforeDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(42576);
    Intent localIntent = new Intent(this.orA.getContext(), LuckyMoneyDetailUI.class);
    localIntent.putExtras(this.orA.getIntent());
    this.orA.startActivity(localIntent);
    this.orA.finish();
    AppMethodBeat.o(42576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI.1
 * JD-Core Version:    0.7.0.1
 */