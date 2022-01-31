package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoadDelegate
{
  private static final String TAG = "MediaSdk.LoadDelegate";
  private static LoadDelegate.ILoadLibrary sInstance;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(142833);
    sLibraryLoaded = false;
    sInstance = new LoadDelegate.1();
    AppMethodBeat.o(142833);
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(142832);
    if (sLibraryLoaded)
    {
      AppMethodBeat.o(142832);
      return;
    }
    sInstance.loadLibrary("avmedia");
    sInstance.loadLibrary("mediasdk");
    AppMethodBeat.o(142832);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(142830);
    sInstance.loadLibrary(paramString);
    AppMethodBeat.o(142830);
  }
  
  public static void loadLibrary(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(142831);
    sInstance.loadLibrary(paramString, paramClassLoader);
    AppMethodBeat.o(142831);
  }
  
  public static void setInstance(LoadDelegate.ILoadLibrary paramILoadLibrary)
  {
    if (paramILoadLibrary != null) {
      sInstance = paramILoadLibrary;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.hilive.mediasdk.LoadDelegate
 * JD-Core Version:    0.7.0.1
 */