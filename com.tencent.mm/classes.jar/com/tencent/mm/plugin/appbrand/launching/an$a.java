package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum an$a
{
  static
  {
    AppMethodBeat.i(131997);
    imR = new a("Ok", 0);
    imS = new a("Fail", 1);
    imT = new a("Timeout", 2);
    imU = new a("CgiFail", 3);
    imV = new a("ResponseInvalid", 4);
    imW = new a("AwaitFail", 5);
    imX = new a[] { imR, imS, imT, imU, imV, imW };
    AppMethodBeat.o(131997);
  }
  
  private an$a() {}
  
  public static a oI(int paramInt)
  {
    AppMethodBeat.i(131996);
    if (paramInt < 0)
    {
      AppMethodBeat.o(131996);
      return null;
    }
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.ordinal() == paramInt)
      {
        AppMethodBeat.o(131996);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(131996);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.an.a
 * JD-Core Version:    0.7.0.1
 */