package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class LoginIndepPass$3
  implements bo.a
{
  LoginIndepPass$3(LoginIndepPass paramLoginIndepPass) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(128148);
    if (parame == null)
    {
      AppMethodBeat.o(128148);
      return;
    }
    parame = parame.aFc();
    g.ajA();
    int i = a.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(128148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.3
 * JD-Core Version:    0.7.0.1
 */