package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPrepareUI$24
  implements Runnable
{
  LuckyMoneyPrepareUI$24(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(142077);
    Intent localIntent = new Intent();
    localIntent.setClass(this.owL.getContext(), LuckyMoneyIndexUI.class);
    localIntent.addFlags(67108864);
    this.owL.getContext().startActivity(localIntent);
    this.owL.finish();
    AppMethodBeat.o(142077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.24
 * JD-Core Version:    0.7.0.1
 */