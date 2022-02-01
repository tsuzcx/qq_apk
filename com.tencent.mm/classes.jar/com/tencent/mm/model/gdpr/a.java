package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public enum a
{
  public final String hqC;
  public final int hqD;
  
  static
  {
    AppMethodBeat.i(40081);
    hqz = new a("MINI_PROGRAM", 0, "miniProgram", 1);
    hqA = new a("BIZ", 1, "officialAccount", 0);
    hqB = new a("OPENSDK", 2, "OPENSDK", 2);
    hqE = new a[] { hqz, hqA, hqB };
    AppMethodBeat.o(40081);
  }
  
  private a(String paramString, int paramInt)
  {
    this.hqC = paramString;
    this.hqD = paramInt;
  }
  
  public static boolean yN(String paramString)
  {
    AppMethodBeat.i(40079);
    if (yO(paramString) != null)
    {
      AppMethodBeat.o(40079);
      return true;
    }
    AppMethodBeat.o(40079);
    return false;
  }
  
  public static a yO(String paramString)
  {
    AppMethodBeat.i(40080);
    if (bs.isNullOrNil(paramString))
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
      if (paramString.equals(locala.hqC))
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