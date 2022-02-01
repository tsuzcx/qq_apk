package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.bu;

public final class o
{
  public static boolean v(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(155911);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(155911);
      return false;
    }
    if (ae.geX.gbp == 1)
    {
      AppMethodBeat.o(155911);
      return true;
    }
    if (Build.VERSION.SDK_INT == 16)
    {
      if (bu.bI(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0)
      {
        AppMethodBeat.o(155911);
        return false;
      }
      AppMethodBeat.o(155911);
      return true;
    }
    AppMethodBeat.o(155911);
    return false;
  }
  
  public static String vR(String paramString)
  {
    AppMethodBeat.i(155912);
    if (paramString == null)
    {
      AppMethodBeat.o(155912);
      return paramString;
    }
    if (ae.geX.gbp == 2)
    {
      AppMethodBeat.o(155912);
      return paramString;
    }
    if (ae.geX.gbA == 1)
    {
      AppMethodBeat.o(155912);
      return paramString;
    }
    if (ae.geX.gbp == 1)
    {
      if (paramString.toString().contains("\n"))
      {
        paramString = paramString.toString().replace("\n", " ");
        AppMethodBeat.o(155912);
        return paramString;
      }
      AppMethodBeat.o(155912);
      return paramString;
    }
    if (Build.VERSION.SDK_INT == 16)
    {
      if (paramString.toString().contains("\n"))
      {
        if (bu.bI(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0)
        {
          AppMethodBeat.o(155912);
          return paramString;
        }
        paramString = paramString.toString().replace("\n", " ");
        AppMethodBeat.o(155912);
        return paramString;
      }
      AppMethodBeat.o(155912);
      return paramString;
    }
    AppMethodBeat.o(155912);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.util.o
 * JD-Core Version:    0.7.0.1
 */