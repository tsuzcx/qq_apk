package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(16470);
    Object[] arrayOfObject = this.fCU.fCL.keySet().toArray();
    int i = 0;
    while (i < arrayOfObject.length)
    {
      String str = (String)arrayOfObject[i];
      if (str.startsWith(this.efI))
      {
        ab.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
        this.fCU.fCL.remove(str);
      }
      i += 1;
    }
    AppMethodBeat.o(16470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ar.c.1
 * JD-Core Version:    0.7.0.1
 */