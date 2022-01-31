package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.honey_pay.a.a;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.c.ox;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class HoneyPayMainUI$13
  implements n.a
{
  HoneyPayMainUI$13(HoneyPayMainUI paramHoneyPayMainUI, a parama) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.llO.ljF.sMv != null)
    {
      y.i(this.llJ.TAG, "do realname guide");
      paramString = new Bundle();
      paramString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
      c.a(this.llJ, paramString, this.llO.ljF.sMv, true);
      return;
    }
    HoneyPayMainUI.b(this.llJ, this.llO.ljF.sMw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.13
 * JD-Core Version:    0.7.0.1
 */