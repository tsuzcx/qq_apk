package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ke
{
  static final String[] a = { "txmapengine", "txnavengine" };
  private static final String b = "LibraryLoader";
  
  private static void a(Context paramContext)
  {
    AppMethodBeat.i(224748);
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      a(paramContext, arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(224748);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(224758);
    try
    {
      System.loadLibrary(paramString);
      if (Log.isLoggable("LibraryLoader", 4)) {
        new StringBuilder("loadLibary:").append(paramString).append("  successful");
      }
      AppMethodBeat.o(224758);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = kf.a(paramContext, paramString);
      if (Log.isLoggable("LibraryLoader", 4)) {
        new StringBuilder("loadLibary:").append(paramString).append(" result:").append(bool);
      }
      AppMethodBeat.o(224758);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ke
 * JD-Core Version:    0.7.0.1
 */