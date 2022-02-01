package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzf;
import java.util.HashSet;
import java.util.Set;

public class l
{
  private static volatile l kUF;
  private final Set<Object> kUG;
  private volatile bzf kUH;
  private final Object mLock;
  
  public l()
  {
    AppMethodBeat.i(44498);
    this.mLock = new Object();
    this.kUG = new HashSet();
    this.kUH = null;
    AppMethodBeat.o(44498);
  }
  
  public static l bxU()
  {
    AppMethodBeat.i(44499);
    if (kUF == null) {}
    try
    {
      if (kUF == null) {
        kUF = new l();
      }
      l locall = kUF;
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
    int cND;
    
    static
    {
      AppMethodBeat.i(44493);
      kUI = new a("FORCE_OFF", 0, 0);
      kUJ = new a("FORCE_ON", 1, 1);
      kUK = new a[] { kUI, kUJ };
      AppMethodBeat.o(44493);
    }
    
    private a(int paramInt)
    {
      this.cND = paramInt;
    }
    
    public static a vV(int paramInt)
    {
      AppMethodBeat.i(44492);
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala.cND == paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l
 * JD-Core Version:    0.7.0.1
 */