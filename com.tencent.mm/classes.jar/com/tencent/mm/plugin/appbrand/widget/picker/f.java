package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
{
  public static int[] FV(String paramString)
  {
    AppMethodBeat.i(126755);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126755);
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length != 2))
    {
      AppMethodBeat.o(126755);
      return null;
    }
    int i = FW(paramString[0]);
    int j = FW(paramString[1]);
    if ((!qL(i)) || (!qK(j)))
    {
      AppMethodBeat.o(126755);
      return null;
    }
    AppMethodBeat.o(126755);
    return new int[] { i, j };
  }
  
  private static int FW(String paramString)
  {
    AppMethodBeat.i(126756);
    try
    {
      int i = Integer.parseInt(paramString, 10);
      AppMethodBeat.o(126756);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126756);
    }
    return -1;
  }
  
  public static boolean qK(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 59);
  }
  
  public static boolean qL(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.f
 * JD-Core Version:    0.7.0.1
 */