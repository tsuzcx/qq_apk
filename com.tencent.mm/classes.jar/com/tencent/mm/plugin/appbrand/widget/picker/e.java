package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  public static int[] NS(String paramString)
  {
    AppMethodBeat.i(138087);
    if (bt.isNullOrNil(paramString))
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
    int i = NT(paramString[0]);
    int j = NT(paramString[1]);
    if ((!vo(i)) || (!vn(j)))
    {
      AppMethodBeat.o(138087);
      return null;
    }
    AppMethodBeat.o(138087);
    return new int[] { i, j };
  }
  
  private static int NT(String paramString)
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
  
  public static boolean vn(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 59);
  }
  
  public static boolean vo(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */