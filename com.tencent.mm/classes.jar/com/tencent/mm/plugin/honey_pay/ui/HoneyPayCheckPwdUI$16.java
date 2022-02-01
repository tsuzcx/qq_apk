package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r.a;

final class HoneyPayCheckPwdUI$16
  implements r.a
{
  HoneyPayCheckPwdUI$16(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, com.tencent.mm.plugin.honey_pay.a.h paramh) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64738);
    Log.i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
    paramString = new Intent();
    paramString.putExtra("key_modify_create_line_succ", true);
    paramString.putExtra("key_credit_line", this.ylh.yjF);
    this.ylc.setResult(-1, paramString);
    this.ylc.finish();
    com.tencent.mm.plugin.report.service.h.CyF.n(875L, 8L, 1L);
    AppMethodBeat.o(64738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.16
 * JD-Core Version:    0.7.0.1
 */