package com.tencent.mm.plugin.appbrand.s.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.ad;
import org.apache.commons.b.a;

public abstract interface e
{
  public abstract void a(b paramb, a parama);
  
  public abstract b aNL();
  
  public static abstract interface a
  {
    public abstract void a(e.b paramb, boolean paramBoolean);
  }
  
  public static enum b
  {
    public static final b[] lmV;
    public final int lmU;
    
    static
    {
      AppMethodBeat.i(176703);
      lmO = new b("PORTRAIT", 0, 1);
      lmP = new b("UNSPECIFIED", 1, -1);
      lmQ = new b("LANDSCAPE_SENSOR", 2, 6);
      lmR = new b("LANDSCAPE_LOCKED", 3, 0);
      lmS = new b("LANDSCAPE_LEFT", 4, 8);
      lmT = new b("LANDSCAPE_RIGHT", 5, 0);
      lmW = new b[] { lmO, lmP, lmQ, lmR, lmS, lmT };
      lmV = new b[] { lmS, lmT, lmR, lmQ };
      AppMethodBeat.o(176703);
    }
    
    private b(int paramInt)
    {
      this.lmU = paramInt;
    }
    
    public static b Mq(String paramString)
    {
      String str = null;
      AppMethodBeat.i(176701);
      Object localObject;
      if ("landscape".equals(paramString))
      {
        localObject = lmQ;
        if (localObject != null) {
          break label191;
        }
        label25:
        if (localObject != null) {
          break label200;
        }
      }
      label186:
      label191:
      label200:
      for (int i = -1;; i = ((b)localObject).lmU)
      {
        ad.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(i) });
        AppMethodBeat.o(176701);
        return localObject;
        if ("portrait".equals(paramString))
        {
          localObject = lmO;
          break;
        }
        if ("landscapeLeft".equals(paramString))
        {
          localObject = lmS;
          break;
        }
        if ("landscapeRight".equals(paramString))
        {
          localObject = lmT;
          break;
        }
        if (("auto".equals(paramString)) || (lmP.name().equalsIgnoreCase(paramString)))
        {
          localObject = lmP;
          break;
        }
        b[] arrayOfb = values();
        int j = arrayOfb.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label186;
          }
          b localb = arrayOfb[i];
          localObject = localb;
          if (localb.name().equalsIgnoreCase(paramString)) {
            break;
          }
          i += 1;
        }
        localObject = null;
        break;
        str = ((b)localObject).name();
        break label25;
      }
    }
    
    public static boolean c(b paramb)
    {
      AppMethodBeat.i(194518);
      boolean bool = a.contains(lmV, paramb);
      AppMethodBeat.o(194518);
      return bool;
    }
    
    public static b i(AppBrandInitConfig paramAppBrandInitConfig)
    {
      AppMethodBeat.i(176702);
      b localb = null;
      if (paramAppBrandInitConfig != null) {
        localb = Mq(paramAppBrandInitConfig.jbC);
      }
      paramAppBrandInitConfig = localb;
      if (localb == null) {
        paramAppBrandInitConfig = lmO;
      }
      AppMethodBeat.o(176702);
      return paramAppBrandInitConfig;
    }
    
    public static b tG(int paramInt)
    {
      AppMethodBeat.i(176700);
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        b localb = localObject[i];
        if (localb.lmU == paramInt)
        {
          AppMethodBeat.o(176700);
          return localb;
        }
        i += 1;
      }
      localObject = lmP;
      AppMethodBeat.o(176700);
      return localObject;
    }
    
    public final boolean b(b paramb)
    {
      return (this == paramb) || ((this == lmQ) && (paramb == lmR)) || ((this == lmR) && (paramb == lmQ));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.e
 * JD-Core Version:    0.7.0.1
 */