package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j
{
  private static final HashSet<String> cGI;
  private static String cGJ;
  
  static
  {
    AppMethodBeat.i(91953);
    cGI = new HashSet();
    cGJ = "goog.exo.core";
    AppMethodBeat.o(91953);
  }
  
  public static String QQ()
  {
    try
    {
      String str = cGJ;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void cE(String paramString)
  {
    try
    {
      AppMethodBeat.i(91952);
      if (cGI.add(paramString)) {
        cGJ = cGJ + ", " + paramString;
      }
      AppMethodBeat.o(91952);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.j
 * JD-Core Version:    0.7.0.1
 */