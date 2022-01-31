package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public final String ibH;
  
  static
  {
    AppMethodBeat.i(131500);
    ibD = new a("UPDATING", 0, "updating");
    ibE = new a("NO_UPDATE", 1, "noUpdate");
    ibF = new a("UPDATE_READY", 2, "updateReady");
    ibG = new a("UPDATE_FAILED", 3, "updateFailed");
    ibI = new a[] { ibD, ibE, ibF, ibG };
    AppMethodBeat.o(131500);
  }
  
  private a(String paramString)
  {
    this.ibH = paramString;
  }
  
  public static a CP(String paramString)
  {
    AppMethodBeat.i(131499);
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.ibH.equals(paramString))
      {
        AppMethodBeat.o(131499);
        return locala;
      }
      i += 1;
    }
    paramString = new IllegalArgumentException(String.format("Invalid name %s", new Object[] { paramString }));
    AppMethodBeat.o(131499);
    throw paramString;
  }
  
  public final String toString()
  {
    return this.ibH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.a
 * JD-Core Version:    0.7.0.1
 */