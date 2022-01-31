package com.tencent.mm.plugin.luckymoney.sns;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsLuckyMoneyPrepareUI$3
  implements DialogInterface.OnClickListener
{
  SnsLuckyMoneyPrepareUI$3(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.lTI.mController.uMN, LuckyMoneyMyRecordUI.class);
    paramDialogInterface.putExtra("key_type", 1);
    this.lTI.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */