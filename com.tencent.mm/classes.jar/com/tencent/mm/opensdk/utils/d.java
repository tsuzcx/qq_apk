package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean b(String paramString)
  {
    AppMethodBeat.i(128074);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(128074);
      return true;
    }
    AppMethodBeat.o(128074);
    return false;
  }
  
  public static int c(String paramString)
  {
    AppMethodBeat.i(128075);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(128075);
        return 0;
      }
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(128075);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(128075);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.d
 * JD-Core Version:    0.7.0.1
 */