package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bho;
import java.util.HashSet;
import java.util.Set;

public class l
{
  private static volatile l juK;
  private final Set<Object> juL;
  private volatile bho juM;
  private final Object mLock;
  
  public l()
  {
    AppMethodBeat.i(44498);
    this.mLock = new Object();
    this.juL = new HashSet();
    this.juM = null;
    AppMethodBeat.o(44498);
  }
  
  public static l aYC()
  {
    AppMethodBeat.i(44499);
    if (juK == null) {}
    try
    {
      if (juK == null) {
        juK = new l();
      }
      l locall = juK;
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
    int cof;
    
    static
    {
      AppMethodBeat.i(44493);
      juN = new a("FORCE_OFF", 0, 0);
      juO = new a("FORCE_ON", 1, 1);
      juP = new a[] { juN, juO };
      AppMethodBeat.o(44493);
    }
    
    private a(int paramInt)
    {
      this.cof = paramInt;
    }
    
    public static a rx(int paramInt)
    {
      AppMethodBeat.i(44492);
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala.cof == paramInt)
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