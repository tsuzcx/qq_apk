package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l$a
{
  int bKp;
  
  static
  {
    AppMethodBeat.i(129561);
    hbo = new a("FORCE_OFF", 0, 0);
    hbp = new a("FORCE_ON", 1, 1);
    hbq = new a[] { hbo, hbp };
    AppMethodBeat.o(129561);
  }
  
  private l$a(int paramInt)
  {
    this.bKp = paramInt;
  }
  
  public static a ns(int paramInt)
  {
    AppMethodBeat.i(129560);
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.bKp == paramInt)
      {
        AppMethodBeat.o(129560);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(129560);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l.a
 * JD-Core Version:    0.7.0.1
 */