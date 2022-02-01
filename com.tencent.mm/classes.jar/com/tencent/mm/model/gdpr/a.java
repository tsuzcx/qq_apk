package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public enum a
{
  public final String hIU;
  public final int hIV;
  
  static
  {
    AppMethodBeat.i(40081);
    hIR = new a("MINI_PROGRAM", 0, "miniProgram", 1);
    hIS = new a("BIZ", 1, "officialAccount", 0);
    hIT = new a("OPENSDK", 2, "OPENSDK", 2);
    hIW = new a[] { hIR, hIS, hIT };
    AppMethodBeat.o(40081);
  }
  
  private a(String paramString, int paramInt)
  {
    this.hIU = paramString;
    this.hIV = paramInt;
  }
  
  public static boolean BM(String paramString)
  {
    AppMethodBeat.i(40079);
    if (BN(paramString) != null)
    {
      AppMethodBeat.o(40079);
      return true;
    }
    AppMethodBeat.o(40079);
    return false;
  }
  
  public static a BN(String paramString)
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
      if (paramString.equals(locala.hIU))
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