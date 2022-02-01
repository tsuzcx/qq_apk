package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class g$2
  implements bn.a
{
  g$2(g paramg) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(128260);
    if (parame == null)
    {
      AppMethodBeat.o(128260);
      return;
    }
    parame = parame.aBZ();
    com.tencent.mm.kernel.g.agP();
    int i = a.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(128260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g.2
 * JD-Core Version:    0.7.0.1
 */