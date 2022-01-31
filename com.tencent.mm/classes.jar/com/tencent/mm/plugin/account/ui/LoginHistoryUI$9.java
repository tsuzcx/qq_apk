package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class LoginHistoryUI$9
  implements bk.a
{
  LoginHistoryUI$9(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(124920);
    if (parame == null)
    {
      AppMethodBeat.o(124920);
      return;
    }
    parame = parame.adI();
    g.RJ();
    int i = a.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(124920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.9
 * JD-Core Version:    0.7.0.1
 */