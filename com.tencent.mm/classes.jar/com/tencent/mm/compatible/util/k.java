package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  public static boolean Ua()
  {
    AppMethodBeat.i(155906);
    if (bt.by(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0)
    {
      AppMethodBeat.o(155906);
      return true;
    }
    AppMethodBeat.o(155906);
    return false;
  }
  
  public static boolean XS()
  {
    AppMethodBeat.i(155907);
    if (bt.by(Build.MANUFACTURER, "").toLowerCase().indexOf("HMD Global".toLowerCase()) >= 0)
    {
      AppMethodBeat.o(155907);
      return true;
    }
    AppMethodBeat.o(155907);
    return false;
  }
  
  public static boolean XT()
  {
    AppMethodBeat.i(155908);
    if (bt.by(Build.MANUFACTURER, "").toLowerCase().indexOf("smartisan".toLowerCase()) >= 0)
    {
      AppMethodBeat.o(155908);
      return true;
    }
    AppMethodBeat.o(155908);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.util.k
 * JD-Core Version:    0.7.0.1
 */