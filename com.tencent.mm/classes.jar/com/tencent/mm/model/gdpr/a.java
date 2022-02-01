package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public enum a
{
  public final String gQc;
  public final int gQd;
  
  static
  {
    AppMethodBeat.i(40081);
    gPZ = new a("MINI_PROGRAM", 0, "miniProgram", 1);
    gQa = new a("BIZ", 1, "officialAccount", 0);
    gQb = new a("OPENSDK", 2, "OPENSDK", 2);
    gQe = new a[] { gPZ, gQa, gQb };
    AppMethodBeat.o(40081);
  }
  
  private a(String paramString, int paramInt)
  {
    this.gQc = paramString;
    this.gQd = paramInt;
  }
  
  public static boolean uH(String paramString)
  {
    AppMethodBeat.i(40079);
    if (uI(paramString) != null)
    {
      AppMethodBeat.o(40079);
      return true;
    }
    AppMethodBeat.o(40079);
    return false;
  }
  
  public static a uI(String paramString)
  {
    AppMethodBeat.i(40080);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(40080);
      return null;
    }
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (paramString.equals(locala.gQc))
      {
        AppMethodBeat.o(40080);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(40080);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.a
 * JD-Core Version:    0.7.0.1
 */