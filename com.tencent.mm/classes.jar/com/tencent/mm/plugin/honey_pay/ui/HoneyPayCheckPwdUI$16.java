package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class HoneyPayCheckPwdUI$16
  implements n.a
{
  HoneyPayCheckPwdUI$16(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, com.tencent.mm.plugin.honey_pay.a.h paramh) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
    paramString = new Intent();
    paramString.putExtra("key_modify_create_line_succ", true);
    paramString.putExtra("key_credit_line", this.llr.ljN);
    this.llm.setResult(-1, paramString);
    this.llm.finish();
    com.tencent.mm.plugin.report.service.h.nFQ.h(875L, 8L, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.16
 * JD-Core Version:    0.7.0.1
 */