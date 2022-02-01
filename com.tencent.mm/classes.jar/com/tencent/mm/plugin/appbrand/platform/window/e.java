package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.Log;
import org.apache.commons.b.a;

public abstract interface e
{
  public abstract void a(b paramb, a parama);
  
  public abstract b cgS();
  
  public static abstract interface a
  {
    public abstract void a(e.b paramb, boolean paramBoolean);
  }
  
  public static enum b
  {
    public static final b[] qGC;
    public final int qGB;
    
    static
    {
      AppMethodBeat.i(176703);
      qGv = new b("PORTRAIT", 0, 1);
      qGw = new b("UNSPECIFIED", 1, -1);
      qGx = new b("LANDSCAPE_SENSOR", 2, 6);
      qGy = new b("LANDSCAPE_LOCKED", 3, 0);
      qGz = new b("LANDSCAPE_LEFT", 4, 8);
      qGA = new b("LANDSCAPE_RIGHT", 5, 0);
      qGD = new b[] { qGv, qGw, qGx, qGy, qGz, qGA };
      qGC = new b[] { qGz, qGA, qGy, qGx };
      AppMethodBeat.o(176703);
    }
    
    private b(int paramInt)
    {
      this.qGB = paramInt;
    }
    
    public static b CE(int paramInt)
    {
      AppMethodBeat.i(176700);
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        b localb = localObject[i];
        if (localb.qGB == paramInt)
        {
          AppMethodBeat.o(176700);
          return localb;
        }
        i += 1;
      }
      localObject = qGw;
      AppMethodBeat.o(176700);
      return localObject;
    }
    
    public static b amy(String paramString)
    {
      String str = null;
      AppMethodBeat.i(176701);
      Object localObject;
      if ("landscape".equals(paramString))
      {
        localObject = qGx;
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
      for (int i = -1;; i = ((b)localObject).qGB)
      {
        Log.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(i) });
        AppMethodBeat.o(176701);
        return localObject;
        if ("portrait".equals(paramString))
        {
          localObject = qGv;
          break;
        }
        if ("landscapeLeft".equals(paramString))
        {
          localObject = qGz;
          break;
        }
        if ("landscapeRight".equals(paramString))
        {
          localObject = qGA;
          break;
        }
        if (("auto".equals(paramString)) || (qGw.name().equalsIgnoreCase(paramString)))
        {
          localObject = qGw;
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
      AppMethodBeat.i(242926);
      boolean bool = a.contains(qGC, paramb);
      AppMethodBeat.o(242926);
      return bool;
    }
    
    public static b h(AppBrandInitConfig paramAppBrandInitConfig)
    {
      AppMethodBeat.i(176702);
      b localb = null;
      if (paramAppBrandInitConfig != null) {
        localb = amy(paramAppBrandInitConfig.cCi);
      }
      paramAppBrandInitConfig = localb;
      if (localb == null) {
        paramAppBrandInitConfig = qGv;
      }
      AppMethodBeat.o(176702);
      return paramAppBrandInitConfig;
    }
    
    public final boolean b(b paramb)
    {
      return (this == paramb) || ((this == qGx) && (paramb == qGy)) || ((this == qGy) && (paramb == qGx));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.e
 * JD-Core Version:    0.7.0.1
 */