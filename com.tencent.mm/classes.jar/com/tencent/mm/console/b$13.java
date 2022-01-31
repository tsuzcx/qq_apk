package com.tencent.mm.console;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.a.c;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$13
  implements bi.a
{
  public final void a(e parame)
  {
    if (parame == null) {}
    for (;;)
    {
      return;
      String[] arrayOfString = parame.getIPsString(true);
      int i = 0;
      while (i < arrayOfString.length)
      {
        y.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", new Object[] { Integer.valueOf(i), arrayOfString[i] });
        y.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), c.oN(arrayOfString[i]).toString() });
        i += 1;
      }
      parame = parame.getIPsString(false);
      i = 0;
      while (i < parame.length)
      {
        y.d("MicroMsg.CommandProcessor", "dkip short:%d %s", new Object[] { Integer.valueOf(i), parame[i] });
        y.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), c.oN(parame[i]).toString() });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.b.13
 * JD-Core Version:    0.7.0.1
 */