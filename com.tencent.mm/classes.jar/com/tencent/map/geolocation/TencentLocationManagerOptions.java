package com.tencent.map.geolocation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationManagerOptions
{
  private static boolean a = true;
  private static String b = "";
  
  public static String getKey()
  {
    return b;
  }
  
  public static boolean isLoadLibraryEnabled()
  {
    return a;
  }
  
  public static boolean setKey(String paramString)
  {
    AppMethodBeat.i(136468);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(136468);
      return false;
    }
    b = paramString;
    AppMethodBeat.o(136468);
    return true;
  }
  
  public static void setLoadLibraryEnabled(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManagerOptions
 * JD-Core Version:    0.7.0.1
 */