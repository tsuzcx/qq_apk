package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public enum a
{
  public final String ooq;
  public final int oor;
  
  static
  {
    AppMethodBeat.i(40081);
    oon = new a("MINI_PROGRAM", 0, "miniProgram", 1);
    ooo = new a("BIZ", 1, "officialAccount", 0);
    oop = new a("OPENSDK", 2, "OPENSDK", 2);
    oos = new a[] { oon, ooo, oop };
    AppMethodBeat.o(40081);
  }
  
  private a(String paramString, int paramInt)
  {
    this.ooq = paramString;
    this.oor = paramInt;
  }
  
  public static boolean Ku(String paramString)
  {
    AppMethodBeat.i(40079);
    if (Kv(paramString) != null)
    {
      AppMethodBeat.o(40079);
      return true;
    }
    AppMethodBeat.o(40079);
    return false;
  }
  
  public static a Kv(String paramString)
  {
    AppMethodBeat.i(40080);
    if (Util.isNullOrNil(paramString))
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
      if (paramString.equals(locala.ooq))
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