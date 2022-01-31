package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public enum a
{
  public final String foB;
  public final int foC;
  
  static
  {
    AppMethodBeat.i(1487);
    foy = new a("MINI_PROGRAM", 0, "miniProgram", 1);
    foz = new a("BIZ", 1, "officialAccount", 0);
    foA = new a("OPENSDK", 2, "OPENSDK", 2);
    foD = new a[] { foy, foz, foA };
    AppMethodBeat.o(1487);
  }
  
  private a(String paramString, int paramInt)
  {
    this.foB = paramString;
    this.foC = paramInt;
  }
  
  public static boolean pT(String paramString)
  {
    AppMethodBeat.i(1485);
    if (pU(paramString) != null)
    {
      AppMethodBeat.o(1485);
      return true;
    }
    AppMethodBeat.o(1485);
    return false;
  }
  
  public static a pU(String paramString)
  {
    AppMethodBeat.i(1486);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1486);
      return null;
    }
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (paramString.equals(locala.foB))
      {
        AppMethodBeat.o(1486);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(1486);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.a
 * JD-Core Version:    0.7.0.1
 */