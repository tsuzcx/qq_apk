package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class LuggageFlockWrapper
{
  private static native int isFileLocked(String paramString);
  
  public static boolean isFileLockedJNI(String paramString)
  {
    AppMethodBeat.i(323254);
    if (isFileLocked(paramString) == 1)
    {
      AppMethodBeat.o(323254);
      return true;
    }
    AppMethodBeat.o(323254);
    return false;
  }
  
  private static native int lockFile(String paramString);
  
  public static void lockFileJNI(String paramString)
  {
    AppMethodBeat.i(323251);
    lockFile(paramString);
    AppMethodBeat.o(323251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageFlockWrapper
 * JD-Core Version:    0.7.0.1
 */