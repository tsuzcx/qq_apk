package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ah;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends ah
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public static final int oxo;
  
  static
  {
    AppMethodBeat.i(124174);
    oxo = j.oyk.oyn;
    info = ah.aJm();
    AppMethodBeat.o(124174);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public static enum a
  {
    private final int eQp;
    
    static
    {
      AppMethodBeat.i(239499);
      oxp = new a("ALL", 0, 2);
      oxq = new a("DEPARTMENT", 1, 32);
      oxr = new a("EXTERNAL", 2, 128);
      oxs = new a("NORMAL", 3, 0);
      oxt = new a[] { oxp, oxq, oxr, oxs };
      AppMethodBeat.o(239499);
    }
    
    private a(int paramInt)
    {
      this.eQp = paramInt;
    }
    
    public static a vT(int paramInt)
    {
      AppMethodBeat.i(239498);
      Object localObject = values();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        a locala = localObject[i];
        if ((locala.eQp & paramInt) != 0) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(239498);
          return locala;
        }
        i += 1;
      }
      localObject = oxs;
      AppMethodBeat.o(239498);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.a
 * JD-Core Version:    0.7.0.1
 */