package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;

final class SnsLuckyMoneyPrepareUI$2
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$2(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(42509);
    Intent localIntent = new Intent();
    localIntent.setClass(this.oqN.getContext(), LuckyMoneyIndexUI.class);
    localIntent.addFlags(67108864);
    this.oqN.getContext().startActivity(localIntent);
    this.oqN.finish();
    AppMethodBeat.o(42509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */