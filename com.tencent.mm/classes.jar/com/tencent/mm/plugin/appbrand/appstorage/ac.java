package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appstorage.a.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.t;

public abstract interface ac
{
  public static enum a
    implements a
  {
    static
    {
      AppMethodBeat.i(44458);
      nOh = new a("INSTANCE");
      nOi = new a[] { nOh };
      AppMethodBeat.o(44458);
    }
    
    private a() {}
    
    public final int aee(String paramString)
    {
      AppMethodBeat.i(44457);
      paramString = d.abA(paramString);
      if ((paramString == null) || (paramString.bDy() == null))
      {
        AppMethodBeat.o(44457);
        return 0;
      }
      int i = paramString.bDy().uin;
      AppMethodBeat.o(44457);
      return i;
    }
  }
  
  public static enum b
    implements a
  {
    static
    {
      AppMethodBeat.i(44462);
      nOj = new b("INSTANCE");
      nOk = new b[] { nOj };
      AppMethodBeat.o(44462);
    }
    
    private b() {}
    
    public final int aee(String paramString)
    {
      AppMethodBeat.i(44461);
      h.aHE();
      int i = b.getUin();
      AppMethodBeat.o(44461);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ac
 * JD-Core Version:    0.7.0.1
 */