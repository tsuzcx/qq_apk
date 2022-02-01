package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  public static boolean Xm()
  {
    AppMethodBeat.i(155906);
    boolean bool = bt.bI(Build.MANUFACTURER, "").toLowerCase().contains("samsung".toLowerCase());
    AppMethodBeat.o(155906);
    return bool;
  }
  
  public static boolean abq()
  {
    AppMethodBeat.i(155907);
    boolean bool = bt.bI(Build.MANUFACTURER, "").toLowerCase().contains("HMD Global".toLowerCase());
    AppMethodBeat.o(155907);
    return bool;
  }
  
  public static boolean abr()
  {
    AppMethodBeat.i(155908);
    boolean bool = bt.bI(Build.MANUFACTURER, "").toLowerCase().contains("smartisan".toLowerCase());
    AppMethodBeat.o(155908);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.util.k
 * JD-Core Version:    0.7.0.1
 */