package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.a.c;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;

final class b$13
  implements bk.a
{
  public final void a(e parame)
  {
    AppMethodBeat.i(16094);
    if (parame == null)
    {
      AppMethodBeat.o(16094);
      return;
    }
    String[] arrayOfString = parame.getIPsString(true);
    int i = 0;
    while (i < arrayOfString.length)
    {
      ab.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", new Object[] { Integer.valueOf(i), arrayOfString[i] });
      ab.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), c.wf(arrayOfString[i]).toString() });
      i += 1;
    }
    parame = parame.getIPsString(false);
    i = 0;
    while (i < parame.length)
    {
      ab.d("MicroMsg.CommandProcessor", "dkip short:%d %s", new Object[] { Integer.valueOf(i), parame[i] });
      ab.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), c.wf(parame[i]).toString() });
      i += 1;
    }
    AppMethodBeat.o(16094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.b.13
 * JD-Core Version:    0.7.0.1
 */