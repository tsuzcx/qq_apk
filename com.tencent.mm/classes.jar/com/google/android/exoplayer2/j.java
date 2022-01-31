package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j
{
  private static final HashSet<String> awF;
  private static String awG;
  
  static
  {
    AppMethodBeat.i(94839);
    awF = new HashSet();
    awG = "goog.exo.core";
    AppMethodBeat.o(94839);
  }
  
  public static void ak(String paramString)
  {
    try
    {
      AppMethodBeat.i(94838);
      if (awF.add(paramString)) {
        awG = awG + ", " + paramString;
      }
      AppMethodBeat.o(94838);
      return;
    }
    finally {}
  }
  
  public static String mW()
  {
    try
    {
      String str = awG;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.j
 * JD-Core Version:    0.7.0.1
 */