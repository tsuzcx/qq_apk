package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.ae;
import org.apache.commons.b.a;

public enum e$b
{
  public static final b[] mtK;
  public final int mtJ;
  
  static
  {
    AppMethodBeat.i(176703);
    mtD = new b("PORTRAIT", 0, 1);
    mtE = new b("UNSPECIFIED", 1, -1);
    mtF = new b("LANDSCAPE_SENSOR", 2, 6);
    mtG = new b("LANDSCAPE_LOCKED", 3, 0);
    mtH = new b("LANDSCAPE_LEFT", 4, 8);
    mtI = new b("LANDSCAPE_RIGHT", 5, 0);
    mtL = new b[] { mtD, mtE, mtF, mtG, mtH, mtI };
    mtK = new b[] { mtH, mtI, mtG, mtF };
    AppMethodBeat.o(176703);
  }
  
  private e$b(int paramInt)
  {
    this.mtJ = paramInt;
  }
  
  public static b UP(String paramString)
  {
    String str = null;
    AppMethodBeat.i(176701);
    Object localObject;
    if ("landscape".equals(paramString))
    {
      localObject = mtF;
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
    for (int i = -1;; i = ((b)localObject).mtJ)
    {
      ae.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(i) });
      AppMethodBeat.o(176701);
      return localObject;
      if ("portrait".equals(paramString))
      {
        localObject = mtD;
        break;
      }
      if ("landscapeLeft".equals(paramString))
      {
        localObject = mtH;
        break;
      }
      if ("landscapeRight".equals(paramString))
      {
        localObject = mtI;
        break;
      }
      if (("auto".equals(paramString)) || (mtE.name().equalsIgnoreCase(paramString)))
      {
        localObject = mtE;
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
    AppMethodBeat.i(207969);
    boolean bool = a.contains(mtK, paramb);
    AppMethodBeat.o(207969);
    return bool;
  }
  
  public static b h(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(176702);
    b localb = null;
    if (paramAppBrandInitConfig != null) {
      localb = UP(paramAppBrandInitConfig.cpm);
    }
    paramAppBrandInitConfig = localb;
    if (localb == null) {
      paramAppBrandInitConfig = mtD;
    }
    AppMethodBeat.o(176702);
    return paramAppBrandInitConfig;
  }
  
  public static b vh(int paramInt)
  {
    AppMethodBeat.i(176700);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      b localb = localObject[i];
      if (localb.mtJ == paramInt)
      {
        AppMethodBeat.o(176700);
        return localb;
      }
      i += 1;
    }
    localObject = mtE;
    AppMethodBeat.o(176700);
    return localObject;
  }
  
  public final boolean b(b paramb)
  {
    return (this == paramb) || ((this == mtF) && (paramb == mtG)) || ((this == mtG) && (paramb == mtF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.e.b
 * JD-Core Version:    0.7.0.1
 */