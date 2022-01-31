package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
{
  public static String lr(String paramString)
  {
    AppMethodBeat.i(93109);
    if (paramString == null)
    {
      AppMethodBeat.o(93109);
      return paramString;
    }
    if (ac.erF.eoX == 2)
    {
      AppMethodBeat.o(93109);
      return paramString;
    }
    if (ac.erF.epi == 1)
    {
      AppMethodBeat.o(93109);
      return paramString;
    }
    if (ac.erF.eoX == 1)
    {
      if (paramString.toString().contains("\n"))
      {
        paramString = paramString.toString().replace("\n", " ");
        AppMethodBeat.o(93109);
        return paramString;
      }
      AppMethodBeat.o(93109);
      return paramString;
    }
    if (Build.VERSION.SDK_INT == 16)
    {
      if (paramString.toString().contains("\n"))
      {
        if (bo.bf(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0)
        {
          AppMethodBeat.o(93109);
          return paramString;
        }
        paramString = paramString.toString().replace("\n", " ");
        AppMethodBeat.o(93109);
        return paramString;
      }
      AppMethodBeat.o(93109);
      return paramString;
    }
    AppMethodBeat.o(93109);
    return paramString;
  }
  
  public static boolean r(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(93108);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(93108);
      return false;
    }
    if (ac.erF.eoX == 1)
    {
      AppMethodBeat.o(93108);
      return true;
    }
    if (Build.VERSION.SDK_INT == 16)
    {
      if (bo.bf(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0)
      {
        AppMethodBeat.o(93108);
        return false;
      }
      AppMethodBeat.o(93108);
      return true;
    }
    AppMethodBeat.o(93108);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.util.o
 * JD-Core Version:    0.7.0.1
 */