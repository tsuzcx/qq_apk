package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j
{
  private static final HashSet<String> aST;
  private static String aSU;
  
  static
  {
    AppMethodBeat.i(91953);
    aST = new HashSet();
    aSU = "goog.exo.core";
    AppMethodBeat.o(91953);
  }
  
  public static void ai(String paramString)
  {
    try
    {
      AppMethodBeat.i(91952);
      if (aST.add(paramString)) {
        aSU = aSU + ", " + paramString;
      }
      AppMethodBeat.o(91952);
      return;
    }
    finally {}
  }
  
  public static String rQ()
  {
    try
    {
      String str = aSU;
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