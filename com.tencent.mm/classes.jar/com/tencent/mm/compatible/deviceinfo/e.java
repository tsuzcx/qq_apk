package com.tencent.mm.compatible.deviceinfo;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements d.a
{
  public static d.a.a f(Looper paramLooper)
  {
    AppMethodBeat.i(155648);
    d.a.a locala = new d.a.a();
    try
    {
      locala.lTN = x.g(paramLooper);
      locala.hYK = 0;
      if (locala.lTN == null)
      {
        AppMethodBeat.o(155648);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(155648);
      return null;
    }
    AppMethodBeat.o(155648);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.e
 * JD-Core Version:    0.7.0.1
 */