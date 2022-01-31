package com.tencent.mm.compatible.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements d.a
{
  public static d.a.a b(Looper paramLooper)
  {
    AppMethodBeat.i(92927);
    d.a.a locala = new d.a.a();
    try
    {
      locala.eoH = v.c(paramLooper);
      locala.rotate = 0;
      if (locala.eoH == null)
      {
        AppMethodBeat.o(92927);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(92927);
      return null;
    }
    AppMethodBeat.o(92927);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.e.e
 * JD-Core Version:    0.7.0.1
 */