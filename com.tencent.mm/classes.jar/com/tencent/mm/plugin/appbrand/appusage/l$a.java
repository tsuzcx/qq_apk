package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l$a
{
  int cqY;
  
  static
  {
    AppMethodBeat.i(44493);
    iUx = new a("FORCE_OFF", 0, 0);
    iUy = new a("FORCE_ON", 1, 1);
    iUz = new a[] { iUx, iUy };
    AppMethodBeat.o(44493);
  }
  
  private l$a(int paramInt)
  {
    this.cqY = paramInt;
  }
  
  public static a qK(int paramInt)
  {
    AppMethodBeat.i(44492);
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.cqY == paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l.a
 * JD-Core Version:    0.7.0.1
 */