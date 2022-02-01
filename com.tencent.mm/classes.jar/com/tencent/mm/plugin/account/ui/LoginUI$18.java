package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class LoginUI$18
  implements bn.a
{
  LoginUI$18(LoginUI paramLoginUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(128220);
    if (parame == null)
    {
      AppMethodBeat.o(128220);
      return;
    }
    parame = parame.aBZ();
    g.agP();
    int i = a.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(128220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.18
 * JD-Core Version:    0.7.0.1
 */