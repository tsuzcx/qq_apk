package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public abstract interface a
{
  public abstract i.a a(b paramb);
  
  public abstract int bSu();
  
  public static final class a
  {
    private static final a nuO;
    
    static
    {
      AppMethodBeat.i(219462);
      nuO = new a()
      {
        public final i.a a(a.b paramAnonymousb)
        {
          return i.nvz;
        }
        
        public final int bSu()
        {
          return -2147483648;
        }
      };
      AppMethodBeat.o(219462);
    }
    
    public static a a(AppBrandRuntime paramAppBrandRuntime, i.a parama)
    {
      AppMethodBeat.i(219461);
      paramAppBrandRuntime = new b(paramAppBrandRuntime, parama);
      AppMethodBeat.o(219461);
      return paramAppBrandRuntime;
    }
    
    public static a ah(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(219460);
      if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()) || (paramAppBrandRuntime.SO))
      {
        paramAppBrandRuntime = nuO;
        AppMethodBeat.o(219460);
        return paramAppBrandRuntime;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.kAx.nvl;
      AppMethodBeat.o(219460);
      return paramAppBrandRuntime;
    }
  }
  
  public static enum b
  {
    final int nuU;
    final int nuV;
    
    static
    {
      AppMethodBeat.i(219465);
      nuP = new b("NORMAL", 0, -1, -1);
      nuQ = new b("LBS", 1, 2131762771, 2131230971);
      nuR = new b("VOICE", 2, 2131762772, 2131230973);
      nuS = new b("VIDEO", 3, -1, 2131230972);
      nuT = new b("LOADING", 4, -1, -1);
      nuW = new b[] { nuP, nuQ, nuR, nuS, nuT };
      AppMethodBeat.o(219465);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.nuU = paramInt1;
      this.nuV = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.a
 * JD-Core Version:    0.7.0.1
 */