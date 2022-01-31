package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayCheckPwdUI$16
  implements p.a
{
  HoneyPayCheckPwdUI$16(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, com.tencent.mm.plugin.honey_pay.a.h paramh) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41849);
    ab.i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
    paramString = new Intent();
    paramString.putExtra("key_modify_create_line_succ", true);
    paramString.putExtra("key_credit_line", this.nIN.nHj);
    this.nII.setResult(-1, paramString);
    this.nII.finish();
    com.tencent.mm.plugin.report.service.h.qsU.j(875L, 8L, 1L);
    AppMethodBeat.o(41849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.16
 * JD-Core Version:    0.7.0.1
 */