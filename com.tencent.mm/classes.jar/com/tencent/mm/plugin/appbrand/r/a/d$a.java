package com.tencent.mm.plugin.appbrand.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class d$a
{
  public static int uw(int paramInt)
  {
    AppMethodBeat.i(193507);
    new a();
    int i = a.ux(paramInt);
    ac.i("Luggage.WXA.WindowFullscreenHandler.Factory", "convertActivityOrientation2Direction [%d]->[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(193507);
    return i;
  }
  
  final class a
  {
    static int ux(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        return 90;
      case 8: 
        return -90;
      }
      return 180;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.d.a
 * JD-Core Version:    0.7.0.1
 */