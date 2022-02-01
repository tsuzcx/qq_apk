package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
{
  public static boolean are()
  {
    AppMethodBeat.i(155906);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("samsung".toLowerCase());
    AppMethodBeat.o(155906);
    return bool;
  }
  
  public static boolean avO()
  {
    AppMethodBeat.i(155907);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("HMD Global".toLowerCase());
    AppMethodBeat.o(155907);
    return bool;
  }
  
  public static boolean avP()
  {
    AppMethodBeat.i(155908);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("smartisan".toLowerCase());
    AppMethodBeat.o(155908);
    return bool;
  }
  
  public static boolean avQ()
  {
    AppMethodBeat.i(261385);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("huawei".toLowerCase());
    AppMethodBeat.o(261385);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.util.k
 * JD-Core Version:    0.7.0.1
 */