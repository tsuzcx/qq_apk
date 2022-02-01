package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l$a
{
  int cOr;
  
  static
  {
    AppMethodBeat.i(44493);
    nOV = new a("FORCE_OFF", 0, 0);
    nOW = new a("FORCE_ON", 1, 1);
    nOX = new a[] { nOV, nOW };
    AppMethodBeat.o(44493);
  }
  
  private l$a(int paramInt)
  {
    this.cOr = paramInt;
  }
  
  public static a zg(int paramInt)
  {
    AppMethodBeat.i(44492);
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.cOr == paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l.a
 * JD-Core Version:    0.7.0.1
 */