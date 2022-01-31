package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.a;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayMainUI$13
  implements p.a
{
  HoneyPayMainUI$13(HoneyPayMainUI paramHoneyPayMainUI, a parama) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41892);
    if (this.nJk.nHb.wKi != null)
    {
      ab.i(this.nJe.TAG, "do realname guide");
      paramString = new Bundle();
      paramString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
      c.a(this.nJe, paramString, this.nJk.nHb.wKi, true);
    }
    AppMethodBeat.o(41892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.13
 * JD-Core Version:    0.7.0.1
 */