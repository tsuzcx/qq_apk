package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
{
  public static String DE(String paramString)
  {
    AppMethodBeat.i(155912);
    if (paramString == null)
    {
      AppMethodBeat.o(155912);
      return paramString;
    }
    if (af.lYj.lUh == 2)
    {
      AppMethodBeat.o(155912);
      return paramString;
    }
    if (af.lYj.lUs == 1)
    {
      AppMethodBeat.o(155912);
      return paramString;
    }
    if (af.lYj.lUh == 1)
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
        if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0)
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
  
  public static boolean I(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(155911);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(155911);
      return false;
    }
    if (af.lYj.lUh == 1)
    {
      AppMethodBeat.o(155911);
      return true;
    }
    if (Build.VERSION.SDK_INT == 16)
    {
      if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.util.p
 * JD-Core Version:    0.7.0.1
 */