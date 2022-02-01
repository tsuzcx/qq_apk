package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;

public abstract interface aa
{
  public static enum a
    implements com.tencent.mm.plugin.appbrand.appstorage.a.a
  {
    static
    {
      AppMethodBeat.i(44458);
      kTH = new a("INSTANCE");
      kTI = new a[] { kTH };
      AppMethodBeat.o(44458);
    }
    
    private a() {}
    
    public final int Wp(String paramString)
    {
      AppMethodBeat.i(44457);
      paramString = com.tencent.mm.plugin.appbrand.a.TQ(paramString);
      if ((paramString == null) || (paramString.bsC() == null))
      {
        AppMethodBeat.o(44457);
        return 0;
      }
      int i = paramString.bsC().uin;
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
      kTJ = new b("INSTANCE");
      kTK = new b[] { kTJ };
      AppMethodBeat.o(44462);
    }
    
    private b() {}
    
    public final int Wp(String paramString)
    {
      AppMethodBeat.i(44461);
      g.aAf();
      int i = com.tencent.mm.kernel.a.getUin();
      AppMethodBeat.o(44461);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.aa
 * JD-Core Version:    0.7.0.1
 */