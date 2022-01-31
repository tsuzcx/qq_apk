package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;

final class b$7
  implements bk.a
{
  public final void a(e parame)
  {
    AppMethodBeat.i(16087);
    if (parame == null)
    {
      AppMethodBeat.o(16087);
      return;
    }
    parame = parame.adI();
    aw.aaz();
    int i = com.tencent.mm.model.c.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(16087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.b.7
 * JD-Core Version:    0.7.0.1
 */