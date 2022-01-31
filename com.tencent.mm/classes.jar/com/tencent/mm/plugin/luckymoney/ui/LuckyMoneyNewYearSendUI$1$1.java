package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import com.tencent.mm.j.d;
import com.tencent.mm.plugin.luckymoney.b.k.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class LuckyMoneyNewYearSendUI$1$1
  implements k.a
{
  LuckyMoneyNewYearSendUI$1$1(LuckyMoneyNewYearSendUI.1 param1) {}
  
  public final void a(d paramd, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image success, to send HB");
      LuckyMoneyNewYearSendUI.a(this.lWI.lWH, paramd.field_fileId);
      LuckyMoneyNewYearSendUI.b(this.lWI.lWH, paramd.field_aesKey);
      LuckyMoneyNewYearSendUI.a(this.lWI.lWH, paramd.field_fileLength);
      LuckyMoneyNewYearSendUI.j(this.lWI.lWH).post(new LuckyMoneyNewYearSendUI.1.1.1(this));
      return;
    }
    LuckyMoneyNewYearSendUI.j(this.lWI.lWH).post(new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image fail!");
        if ((LuckyMoneyNewYearSendUI.k(LuckyMoneyNewYearSendUI.1.1.this.lWI.lWH) != null) && (LuckyMoneyNewYearSendUI.k(LuckyMoneyNewYearSendUI.1.1.this.lWI.lWH).isShowing())) {
          LuckyMoneyNewYearSendUI.k(LuckyMoneyNewYearSendUI.1.1.this.lWI.lWH).hide();
        }
        h.bC(LuckyMoneyNewYearSendUI.1.1.this.lWI.lWH, LuckyMoneyNewYearSendUI.1.1.this.lWI.lWH.getString(a.i.lucky_money_upload_image_fail_tips));
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.1.1
 * JD-Core Version:    0.7.0.1
 */