package com.tencent.map.geolocation.sapp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationManagerOptions
{
  public static String mKey = "";
  public static boolean sLoadLibrary = true;
  
  public static String getKey()
  {
    return mKey;
  }
  
  public static boolean isLoadLibraryEnabled()
  {
    return sLoadLibrary;
  }
  
  public static boolean setKey(String paramString)
  {
    AppMethodBeat.i(210879);
    if ((paramString != null) && (!paramString.equals("")))
    {
      mKey = paramString;
      AppMethodBeat.o(210879);
      return true;
    }
    AppMethodBeat.o(210879);
    return false;
  }
  
  public static void setLoadLibraryEnabled(boolean paramBoolean)
  {
    sLoadLibrary = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationManagerOptions
 * JD-Core Version:    0.7.0.1
 */