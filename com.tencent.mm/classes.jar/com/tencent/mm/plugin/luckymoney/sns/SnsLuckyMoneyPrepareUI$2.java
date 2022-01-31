package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsLuckyMoneyPrepareUI$2
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$2(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.lTI.mController.uMN, LuckyMoneyIndexUI.class);
    localIntent.addFlags(67108864);
    this.lTI.mController.uMN.startActivity(localIntent);
    this.lTI.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */