package com.tencent.mm.plugin.appbrand.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.ac;
import org.apache.commons.b.a;

public abstract interface e
{
  public abstract void a(b paramb, a parama);
  
  public abstract b aUB();
  
  public static abstract interface a
  {
    public abstract void a(e.b paramb, boolean paramBoolean);
  }
  
  public static enum b
  {
    public static final b[] lOX;
    public final int lOW;
    
    static
    {
      AppMethodBeat.i(176703);
      lOQ = new b("PORTRAIT", 0, 1);
      lOR = new b("UNSPECIFIED", 1, -1);
      lOS = new b("LANDSCAPE_SENSOR", 2, 6);
      lOT = new b("LANDSCAPE_LOCKED", 3, 0);
      lOU = new b("LANDSCAPE_LEFT", 4, 8);
      lOV = new b("LANDSCAPE_RIGHT", 5, 0);
      lOY = new b[] { lOQ, lOR, lOS, lOT, lOU, lOV };
      lOX = new b[] { lOU, lOV, lOT, lOS };
      AppMethodBeat.o(176703);
    }
    
    private b(int paramInt)
    {
      this.lOW = paramInt;
    }
    
    public static b Qz(String paramString)
    {
      String str = null;
      AppMethodBeat.i(176701);
      Object localObject;
      if ("landscape".equals(paramString))
      {
        localObject = lOS;
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
      for (int i = -1;; i = ((b)localObject).lOW)
      {
        ac.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(i) });
        AppMethodBeat.o(176701);
        return localObject;
        if ("portrait".equals(paramString))
        {
          localObject = lOQ;
          break;
        }
        if ("landscapeLeft".equals(paramString))
        {
          localObject = lOU;
          break;
        }
        if ("landscapeRight".equals(paramString))
        {
          localObject = lOV;
          break;
        }
        if (("auto".equals(paramString)) || (lOR.name().equalsIgnoreCase(paramString)))
        {
          localObject = lOR;
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
      AppMethodBeat.i(193508);
      boolean bool = a.contains(lOX, paramb);
      AppMethodBeat.o(193508);
      return bool;
    }
    
    public static b i(AppBrandInitConfig paramAppBrandInitConfig)
    {
      AppMethodBeat.i(176702);
      b localb = null;
      if (paramAppBrandInitConfig != null) {
        localb = Qz(paramAppBrandInitConfig.jBP);
      }
      paramAppBrandInitConfig = localb;
      if (localb == null) {
        paramAppBrandInitConfig = lOQ;
      }
      AppMethodBeat.o(176702);
      return paramAppBrandInitConfig;
    }
    
    public static b uy(int paramInt)
    {
      AppMethodBeat.i(176700);
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        b localb = localObject[i];
        if (localb.lOW == paramInt)
        {
          AppMethodBeat.o(176700);
          return localb;
        }
        i += 1;
      }
      localObject = lOR;
      AppMethodBeat.o(176700);
      return localObject;
    }
    
    public final boolean b(b paramb)
    {
      return (this == paramb) || ((this == lOS) && (paramb == lOT)) || ((this == lOT) && (paramb == lOS));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.e
 * JD-Core Version:    0.7.0.1
 */