package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class LoginHistoryUI$13
  implements bn.a
{
  LoginHistoryUI$13(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(128098);
    if (parame == null)
    {
      AppMethodBeat.o(128098);
      return;
    }
    parame = parame.aBZ();
    g.agP();
    int i = a.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(128098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.13
 * JD-Core Version:    0.7.0.1
 */