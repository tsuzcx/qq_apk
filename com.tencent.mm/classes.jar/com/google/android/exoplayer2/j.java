package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j
{
  private static final HashSet<String> bdo;
  private static String bdp;
  
  static
  {
    AppMethodBeat.i(91953);
    bdo = new HashSet();
    bdp = "goog.exo.core";
    AppMethodBeat.o(91953);
  }
  
  public static void bb(String paramString)
  {
    try
    {
      AppMethodBeat.i(91952);
      if (bdo.add(paramString)) {
        bdp = bdp + ", " + paramString;
      }
      AppMethodBeat.o(91952);
      return;
    }
    finally {}
  }
  
  public static String tp()
  {
    try
    {
      String str = bdp;
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