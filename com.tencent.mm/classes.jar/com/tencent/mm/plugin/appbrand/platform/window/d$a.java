package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d$a
{
  public static int yX(int paramInt)
  {
    AppMethodBeat.i(219572);
    new a();
    int i = a.yY(paramInt);
    Log.i("Luggage.WXA.WindowFullscreenHandler.Factory", "convertActivityOrientation2Direction [%d]->[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(219572);
    return i;
  }
  
  final class a
  {
    static int yY(int paramInt)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.d.a
 * JD-Core Version:    0.7.0.1
 */