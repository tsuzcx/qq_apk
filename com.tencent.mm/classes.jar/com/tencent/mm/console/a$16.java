package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.a.c;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;

final class a$16
  implements bw.a
{
  public final void b(g paramg)
  {
    AppMethodBeat.i(20127);
    if (paramg == null)
    {
      AppMethodBeat.o(20127);
      return;
    }
    String[] arrayOfString = paramg.getIPsString(true);
    int i = 0;
    while (i < arrayOfString.length)
    {
      Log.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", new Object[] { Integer.valueOf(i), arrayOfString[i] });
      Log.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), c.Rz(arrayOfString[i]).toString() });
      i += 1;
    }
    paramg = paramg.getIPsString(false);
    i = 0;
    while (i < paramg.length)
    {
      Log.d("MicroMsg.CommandProcessor", "dkip short:%d %s", new Object[] { Integer.valueOf(i), paramg[i] });
      Log.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), c.Rz(paramg[i]).toString() });
      i += 1;
    }
    AppMethodBeat.o(20127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.16
 * JD-Core Version:    0.7.0.1
 */