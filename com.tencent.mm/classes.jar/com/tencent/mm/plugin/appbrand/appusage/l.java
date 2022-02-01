package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blw;
import java.util.HashSet;
import java.util.Set;

public class l
{
  private static volatile l jOD;
  private final Set<Object> jOE;
  private volatile blw jOF;
  private final Object mLock;
  
  public l()
  {
    AppMethodBeat.i(44498);
    this.mLock = new Object();
    this.jOE = new HashSet();
    this.jOF = null;
    AppMethodBeat.o(44498);
  }
  
  public static l bca()
  {
    AppMethodBeat.i(44499);
    if (jOD == null) {}
    try
    {
      if (jOD == null) {
        jOD = new l();
      }
      l locall = jOD;
      AppMethodBeat.o(44499);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(44499);
    }
  }
  
  public static enum a
  {
    int cyP;
    
    static
    {
      AppMethodBeat.i(44493);
      jOG = new a("FORCE_OFF", 0, 0);
      jOH = new a("FORCE_ON", 1, 1);
      jOI = new a[] { jOG, jOH };
      AppMethodBeat.o(44493);
    }
    
    private a(int paramInt)
    {
      this.cyP = paramInt;
    }
    
    public static a rX(int paramInt)
    {
      AppMethodBeat.i(44492);
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala.cyP == paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l
 * JD-Core Version:    0.7.0.1
 */