package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static boolean ED(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 59);
  }
  
  public static boolean EE(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 23);
  }
  
  public static int[] ahh(String paramString)
  {
    AppMethodBeat.i(138087);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(138087);
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length != 2))
    {
      AppMethodBeat.o(138087);
      return null;
    }
    int i = ahi(paramString[0]);
    int j = ahi(paramString[1]);
    if ((!EE(i)) || (!ED(j)))
    {
      AppMethodBeat.o(138087);
      return null;
    }
    AppMethodBeat.o(138087);
    return new int[] { i, j };
  }
  
  private static int ahi(String paramString)
  {
    AppMethodBeat.i(138088);
    try
    {
      int i = Integer.parseInt(paramString, 10);
      AppMethodBeat.o(138088);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(138088);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */