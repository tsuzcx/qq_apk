package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public enum a
{
  public final String hLN;
  public final int hLO;
  
  static
  {
    AppMethodBeat.i(40081);
    hLK = new a("MINI_PROGRAM", 0, "miniProgram", 1);
    hLL = new a("BIZ", 1, "officialAccount", 0);
    hLM = new a("OPENSDK", 2, "OPENSDK", 2);
    hLP = new a[] { hLK, hLL, hLM };
    AppMethodBeat.o(40081);
  }
  
  private a(String paramString, int paramInt)
  {
    this.hLN = paramString;
    this.hLO = paramInt;
  }
  
  public static boolean Co(String paramString)
  {
    AppMethodBeat.i(40079);
    if (Cp(paramString) != null)
    {
      AppMethodBeat.o(40079);
      return true;
    }
    AppMethodBeat.o(40079);
    return false;
  }
  
  public static a Cp(String paramString)
  {
    AppMethodBeat.i(40080);
    if (bu.isNullOrNil(paramString))
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
      if (paramString.equals(locala.hLN))
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