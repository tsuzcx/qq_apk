package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyPrepareUI$14
  implements Runnable
{
  LuckyMoneyPrepareUI$14(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.lXg.mController.uMN, LuckyMoneyIndexUI.class);
    localIntent.addFlags(67108864);
    this.lXg.mController.uMN.startActivity(localIntent);
    this.lXg.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.14
 * JD-Core Version:    0.7.0.1
 */