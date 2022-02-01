package com.tencent.mm.plugin.appbrand.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.ad;
import org.apache.commons.b.a;

public enum e$b
{
  public static final b[] moN;
  public final int moM;
  
  static
  {
    AppMethodBeat.i(176703);
    moG = new b("PORTRAIT", 0, 1);
    moH = new b("UNSPECIFIED", 1, -1);
    moI = new b("LANDSCAPE_SENSOR", 2, 6);
    moJ = new b("LANDSCAPE_LOCKED", 3, 0);
    moK = new b("LANDSCAPE_LEFT", 4, 8);
    moL = new b("LANDSCAPE_RIGHT", 5, 0);
    moO = new b[] { moG, moH, moI, moJ, moK, moL };
    moN = new b[] { moK, moL, moJ, moI };
    AppMethodBeat.o(176703);
  }
  
  private e$b(int paramInt)
  {
    this.moM = paramInt;
  }
  
  public static b Uf(String paramString)
  {
    String str = null;
    AppMethodBeat.i(176701);
    Object localObject;
    if ("landscape".equals(paramString))
    {
      localObject = moI;
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
    for (int i = -1;; i = ((b)localObject).moM)
    {
      ad.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(i) });
      AppMethodBeat.o(176701);
      return localObject;
      if ("portrait".equals(paramString))
      {
        localObject = moG;
        break;
      }
      if ("landscapeLeft".equals(paramString))
      {
        localObject = moK;
        break;
      }
      if ("landscapeRight".equals(paramString))
      {
        localObject = moL;
        break;
      }
      if (("auto".equals(paramString)) || (moH.name().equalsIgnoreCase(paramString)))
      {
        localObject = moH;
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
    AppMethodBeat.i(197428);
    boolean bool = a.contains(moN, paramb);
    AppMethodBeat.o(197428);
    return bool;
  }
  
  public static b h(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(176702);
    b localb = null;
    if (paramAppBrandInitConfig != null) {
      localb = Uf(paramAppBrandInitConfig.jVL);
    }
    paramAppBrandInitConfig = localb;
    if (localb == null) {
      paramAppBrandInitConfig = moG;
    }
    AppMethodBeat.o(176702);
    return paramAppBrandInitConfig;
  }
  
  public static b vc(int paramInt)
  {
    AppMethodBeat.i(176700);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      b localb = localObject[i];
      if (localb.moM == paramInt)
      {
        AppMethodBeat.o(176700);
        return localb;
      }
      i += 1;
    }
    localObject = moH;
    AppMethodBeat.o(176700);
    return localObject;
  }
  
  public final boolean b(b paramb)
  {
    return (this == paramb) || ((this == moI) && (paramb == moJ)) || ((this == moJ) && (paramb == moI));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.e.b
 * JD-Core Version:    0.7.0.1
 */