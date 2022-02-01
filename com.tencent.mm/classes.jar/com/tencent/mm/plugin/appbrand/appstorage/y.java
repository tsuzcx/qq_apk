package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;

public abstract interface y
{
  public static enum a
    implements com.tencent.mm.plugin.appbrand.appstorage.a.a
  {
    static
    {
      AppMethodBeat.i(44458);
      iTB = new a("INSTANCE");
      iTC = new a[] { iTB };
      AppMethodBeat.o(44458);
    }
    
    private a() {}
    
    public final int Ff(String paramString)
    {
      AppMethodBeat.i(44457);
      paramString = com.tencent.mm.plugin.appbrand.a.CR(paramString);
      if ((paramString == null) || (paramString.aNc() == null))
      {
        AppMethodBeat.o(44457);
        return 0;
      }
      int i = paramString.aNc().uin;
      AppMethodBeat.o(44457);
      return i;
    }
  }
  
  public static enum b
    implements com.tencent.mm.plugin.appbrand.appstorage.a.a
  {
    static
    {
      AppMethodBeat.i(44462);
      iTD = new b("INSTANCE");
      iTE = new b[] { iTD };
      AppMethodBeat.o(44462);
    }
    
    private b() {}
    
    public final int Ff(String paramString)
    {
      AppMethodBeat.i(44461);
      g.afz();
      int i = com.tencent.mm.kernel.a.getUin();
      AppMethodBeat.o(44461);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.y
 * JD-Core Version:    0.7.0.1
 */