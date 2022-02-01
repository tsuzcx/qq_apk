package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$a
{
  int eJM;
  
  static
  {
    AppMethodBeat.i(44493);
    qON = new a("FORCE_OFF", 0, 0);
    qOO = new a("FORCE_ON", 1, 1);
    qOP = new a[] { qON, qOO };
    AppMethodBeat.o(44493);
  }
  
  private k$a(int paramInt)
  {
    this.eJM = paramInt;
  }
  
  public static a zt(int paramInt)
  {
    AppMethodBeat.i(44492);
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.eJM == paramInt)
      {
        AppMethodBeat.o(44492);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(44492);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k.a
 * JD-Core Version:    0.7.0.1
 */