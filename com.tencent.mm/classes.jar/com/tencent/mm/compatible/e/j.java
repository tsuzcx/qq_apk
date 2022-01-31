package com.tencent.mm.compatible.e;

import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class j
  implements d.a
{
  public static d.a.a b(Looper paramLooper)
  {
    AppMethodBeat.i(92932);
    d.a.a locala = new d.a.a();
    try
    {
      locala.eoH = v.c(paramLooper);
      locala.rotate = 0;
      if (locala.eoH == null)
      {
        AppMethodBeat.o(92932);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(92932);
      return null;
    }
    if (Build.DISPLAY.startsWith("Flyme"))
    {
      locala.rotate = 90;
      locala.eoH.setDisplayOrientation(90);
    }
    label174:
    for (;;)
    {
      AppMethodBeat.o(92932);
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
        locala.rotate = 90;
        locala.eoH.setDisplayOrientation(180);
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
            i = bo.getInt(paramLooper[1], 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.e.j
 * JD-Core Version:    0.7.0.1
 */