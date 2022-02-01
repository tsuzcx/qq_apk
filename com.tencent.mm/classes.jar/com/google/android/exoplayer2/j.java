package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j
{
  private static final HashSet<String> aRY;
  private static String aRZ;
  
  static
  {
    AppMethodBeat.i(91953);
    aRY = new HashSet();
    aRZ = "goog.exo.core";
    AppMethodBeat.o(91953);
  }
  
  public static void ah(String paramString)
  {
    try
    {
      AppMethodBeat.i(91952);
      if (aRY.add(paramString)) {
        aRZ = aRZ + ", " + paramString;
      }
      AppMethodBeat.o(91952);
      return;
    }
    finally {}
  }
  
  public static String rF()
  {
    try
    {
      String str = aRZ;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.j
 * JD-Core Version:    0.7.0.1
 */