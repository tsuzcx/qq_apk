package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.n.a;

final class HoneyPayCheckPwdUI$13
  implements n.a
{
  HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, c paramc) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
    paramString = new Intent(this.llm.mController.uMN, HoneyPayMainUI.class);
    paramString.putExtra("key_create_succ", true);
    if (this.llq.ljH.sQe != null)
    {
      paramString.putExtra("key_card_no", this.llq.ljH.sQe.tef);
      paramString.putExtra("key_card_type", this.llq.ljH.sQe.imz);
    }
    Toast.makeText(this.llm.mController.uMN, a.i.honey_pay_create_card_success_word, 1).show();
    this.llm.startActivity(paramString);
    h.nFQ.h(875L, 2L, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.13
 * JD-Core Version:    0.7.0.1
 */