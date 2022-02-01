package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j
{
  private static final HashSet<String> bdl;
  private static String bdm;
  
  static
  {
    AppMethodBeat.i(91953);
    bdl = new HashSet();
    bdm = "goog.exo.core";
    AppMethodBeat.o(91953);
  }
  
  public static void bb(String paramString)
  {
    try
    {
      AppMethodBeat.i(91952);
      if (bdl.add(paramString)) {
        bdm = bdm + ", " + paramString;
      }
      AppMethodBeat.o(91952);
      return;
    }
    finally {}
  }
  
  public static String tu()
  {
    try
    {
      String str = bdm;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.j
 * JD-Core Version:    0.7.0.1
 */