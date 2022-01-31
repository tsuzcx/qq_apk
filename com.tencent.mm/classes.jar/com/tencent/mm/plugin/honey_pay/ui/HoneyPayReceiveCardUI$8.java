package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class HoneyPayReceiveCardUI$8
  implements n.a
{
  HoneyPayReceiveCardUI$8(HoneyPayReceiveCardUI paramHoneyPayReceiveCardUI, e parame) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.lmk.ljJ.sMv != null)
    {
      y.i(this.lmj.TAG, "do real name");
      paramString = new Bundle();
      paramString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
      c.a(this.lmj, paramString, this.lmk.ljJ.sMv, false);
    }
    for (;;)
    {
      h.nFQ.h(875L, 4L, 1L);
      return;
      HoneyPayReceiveCardUI.b(this.lmj);
      c.Fo(HoneyPayReceiveCardUI.c(this.lmj));
      this.lmj.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.8
 * JD-Core Version:    0.7.0.1
 */