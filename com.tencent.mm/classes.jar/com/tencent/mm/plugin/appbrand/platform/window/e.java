package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.Log;
import org.apache.commons.b.a;

public abstract interface e
{
  public abstract void a(b paramb, a parama);
  
  public abstract b btm();
  
  public static abstract interface a
  {
    public abstract void a(e.b paramb, boolean paramBoolean);
  }
  
  public static enum b
  {
    public static final b[] nEs;
    public final int nEr;
    
    static
    {
      AppMethodBeat.i(176703);
      nEl = new b("PORTRAIT", 0, 1);
      nEm = new b("UNSPECIFIED", 1, -1);
      nEn = new b("LANDSCAPE_SENSOR", 2, 6);
      nEo = new b("LANDSCAPE_LOCKED", 3, 0);
      nEp = new b("LANDSCAPE_LEFT", 4, 8);
      nEq = new b("LANDSCAPE_RIGHT", 5, 0);
      nEt = new b[] { nEl, nEm, nEn, nEo, nEp, nEq };
      nEs = new b[] { nEp, nEq, nEo, nEn };
      AppMethodBeat.o(176703);
    }
    
    private b(int paramInt)
    {
      this.nEr = paramInt;
    }
    
    public static b aeE(String paramString)
    {
      String str = null;
      AppMethodBeat.i(176701);
      Object localObject;
      if ("landscape".equals(paramString))
      {
        localObject = nEn;
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
      for (int i = -1;; i = ((b)localObject).nEr)
      {
        Log.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(i) });
        AppMethodBeat.o(176701);
        return localObject;
        if ("portrait".equals(paramString))
        {
          localObject = nEl;
          break;
        }
        if ("landscapeLeft".equals(paramString))
        {
          localObject = nEp;
          break;
        }
        if ("landscapeRight".equals(paramString))
        {
          localObject = nEq;
          break;
        }
        if (("auto".equals(paramString)) || (nEm.name().equalsIgnoreCase(paramString)))
        {
          localObject = nEm;
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
      AppMethodBeat.i(219573);
      boolean bool = a.contains(nEs, paramb);
      AppMethodBeat.o(219573);
      return bool;
    }
    
    public static b h(AppBrandInitConfig paramAppBrandInitConfig)
    {
      AppMethodBeat.i(176702);
      b localb = null;
      if (paramAppBrandInitConfig != null) {
        localb = aeE(paramAppBrandInitConfig.cBG);
      }
      paramAppBrandInitConfig = localb;
      if (localb == null) {
        paramAppBrandInitConfig = nEl;
      }
      AppMethodBeat.o(176702);
      return paramAppBrandInitConfig;
    }
    
    public static b yZ(int paramInt)
    {
      AppMethodBeat.i(176700);
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        b localb = localObject[i];
        if (localb.nEr == paramInt)
        {
          AppMethodBeat.o(176700);
          return localb;
        }
        i += 1;
      }
      localObject = nEm;
      AppMethodBeat.o(176700);
      return localObject;
    }
    
    public final boolean b(b paramb)
    {
      return (this == paramb) || ((this == nEn) && (paramb == nEo)) || ((this == nEo) && (paramb == nEn));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.e
 * JD-Core Version:    0.7.0.1
 */