package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;

final class LoginUI$18
  implements bv.a
{
  LoginUI$18(LoginUI paramLoginUI) {}
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(128220);
    if (paramg == null)
    {
      AppMethodBeat.o(128220);
      return;
    }
    paramg = paramg.biw();
    h.aHE();
    int i = b.getUin();
    paramg.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(128220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.18
 * JD-Core Version:    0.7.0.1
 */