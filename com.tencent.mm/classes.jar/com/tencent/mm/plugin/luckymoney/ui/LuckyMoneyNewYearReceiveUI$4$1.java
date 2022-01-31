package com.tencent.mm.plugin.luckymoney.ui;

import android.text.TextUtils;
import com.tencent.mm.j.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class LuckyMoneyNewYearReceiveUI$4$1
  implements Runnable
{
  LuckyMoneyNewYearReceiveUI$4$1(LuckyMoneyNewYearReceiveUI.4 param4, boolean paramBoolean, d paramd) {}
  
  public final void run()
  {
    if (this.lWr)
    {
      y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "the download image data is success!");
      if ((!TextUtils.isEmpty(this.eiR.field_fileId)) && (this.eiR.field_fileId.equals(LuckyMoneyNewYearReceiveUI.e(this.lWs.lWq)))) {
        LuckyMoneyNewYearReceiveUI.f(this.lWs.lWq);
      }
      return;
    }
    y.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image fail!");
    h.bC(this.lWs.lWq, this.lWs.lWq.getString(a.i.lucky_money_download_image_fail_tips));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.4.1
 * JD-Core Version:    0.7.0.1
 */