package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;

final class m$5
  implements bv.a
{
  m$5(m paramm) {}
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(128306);
    if (paramg == null)
    {
      AppMethodBeat.o(128306);
      return;
    }
    paramg = paramg.biw();
    h.aHE();
    int i = b.getUin();
    paramg.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(128306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.5
 * JD-Core Version:    0.7.0.1
 */