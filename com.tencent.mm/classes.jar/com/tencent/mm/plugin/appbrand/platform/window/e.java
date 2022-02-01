package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.Log;
import org.apache.commons.c.a;

public abstract interface e
{
  public abstract void a(b paramb, a parama);
  
  public abstract b cHQ();
  
  public static abstract interface a
  {
    public abstract void onOrientationChanged(e.b paramb, boolean paramBoolean);
  }
  
  public static enum b
  {
    public static final b[] tLo;
    public final int tLn;
    
    static
    {
      AppMethodBeat.i(176703);
      tLh = new b("PORTRAIT", 0, 1);
      tLi = new b("UNSPECIFIED", 1, -1);
      tLj = new b("LANDSCAPE_SENSOR", 2, 6);
      tLk = new b("LANDSCAPE_LOCKED", 3, 0);
      tLl = new b("LANDSCAPE_LEFT", 4, 8);
      tLm = new b("LANDSCAPE_RIGHT", 5, 0);
      tLp = new b[] { tLh, tLi, tLj, tLk, tLl, tLm };
      tLo = new b[] { tLl, tLm, tLk, tLj };
      AppMethodBeat.o(176703);
    }
    
    private b(int paramInt)
    {
      this.tLn = paramInt;
    }
    
    public static b CV(int paramInt)
    {
      AppMethodBeat.i(176700);
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        b localb = localObject[i];
        if (localb.tLn == paramInt)
        {
          AppMethodBeat.o(176700);
          return localb;
        }
        i += 1;
      }
      localObject = tLi;
      AppMethodBeat.o(176700);
      return localObject;
    }
    
    public static b afK(String paramString)
    {
      String str = null;
      AppMethodBeat.i(176701);
      Object localObject;
      if ("landscape".equals(paramString))
      {
        localObject = tLj;
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
      for (int i = -1;; i = ((b)localObject).tLn)
      {
        Log.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(i) });
        AppMethodBeat.o(176701);
        return localObject;
        if ("portrait".equals(paramString))
        {
          localObject = tLh;
          break;
        }
        if ("landscapeLeft".equals(paramString))
        {
          localObject = tLl;
          break;
        }
        if ("landscapeRight".equals(paramString))
        {
          localObject = tLm;
          break;
        }
        if (("auto".equals(paramString)) || (tLi.name().equalsIgnoreCase(paramString)))
        {
          localObject = tLi;
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
      AppMethodBeat.i(317527);
      boolean bool = a.contains(tLo, paramb);
      AppMethodBeat.o(317527);
      return bool;
    }
    
    public static b h(AppBrandInitConfig paramAppBrandInitConfig)
    {
      AppMethodBeat.i(176702);
      b localb = null;
      if (paramAppBrandInitConfig != null) {
        localb = afK(paramAppBrandInitConfig.euP);
      }
      paramAppBrandInitConfig = localb;
      if (localb == null) {
        paramAppBrandInitConfig = tLh;
      }
      AppMethodBeat.o(176702);
      return paramAppBrandInitConfig;
    }
    
    public final boolean b(b paramb)
    {
      return (this == paramb) || ((this == tLj) && (paramb == tLk)) || ((this == tLk) && (paramb == tLj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.e
 * JD-Core Version:    0.7.0.1
 */