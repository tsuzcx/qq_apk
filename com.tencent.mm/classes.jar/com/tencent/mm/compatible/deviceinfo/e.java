package com.tencent.mm.compatible.deviceinfo;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements d.a
{
  public static d.a.a d(Looper paramLooper)
  {
    AppMethodBeat.i(155648);
    d.a.a locala = new d.a.a();
    try
    {
      locala.gGr = w.e(paramLooper);
      locala.dYT = 0;
      if (locala.gGr == null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.e
 * JD-Core Version:    0.7.0.1
 */