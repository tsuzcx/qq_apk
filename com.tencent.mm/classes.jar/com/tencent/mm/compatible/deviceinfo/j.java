package com.tencent.mm.compatible.deviceinfo;

import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class j
  implements d.a
{
  public static d.a.a d(Looper paramLooper)
  {
    AppMethodBeat.i(155653);
    d.a.a locala = new d.a.a();
    try
    {
      locala.fBM = w.e(paramLooper);
      locala.dwp = 0;
      if (locala.fBM == null)
      {
        AppMethodBeat.o(155653);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(155653);
      return null;
    }
    if (Build.DISPLAY.startsWith("Flyme"))
    {
      locala.dwp = 90;
      locala.fBM.setDisplayOrientation(90);
    }
    label174:
    for (;;)
    {
      AppMethodBeat.o(155653);
      return locala;
      int i;
      if (!Build.MODEL.equals("M9")) {
        i = -1;
      }
      for (;;)
      {
        if (i < 7093) {
          break label174;
        }
        locala.dwp = 90;
        locala.fBM.setDisplayOrientation(180);
        break;
        paramLooper = Build.DISPLAY;
        if (paramLooper.substring(0, 0).equals("1"))
        {
          i = -1;
        }
        else
        {
          paramLooper = paramLooper.split("-");
          if ((paramLooper == null) || (paramLooper.length < 2)) {
            i = -1;
          } else {
            i = bt.getInt(paramLooper[1], 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.j
 * JD-Core Version:    0.7.0.1
 */