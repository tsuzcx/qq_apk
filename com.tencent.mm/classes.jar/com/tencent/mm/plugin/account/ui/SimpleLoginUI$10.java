package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class SimpleLoginUI$10
  implements bo.a
{
  SimpleLoginUI$10(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(128766);
    if (parame == null)
    {
      AppMethodBeat.o(128766);
      return;
    }
    parame = parame.aFc();
    g.ajA();
    int i = a.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(128766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.10
 * JD-Core Version:    0.7.0.1
 */