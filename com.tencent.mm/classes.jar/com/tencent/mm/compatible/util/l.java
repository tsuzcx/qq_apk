package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  public static boolean aQm()
  {
    AppMethodBeat.i(240830);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("oppo".toLowerCase());
    AppMethodBeat.o(240830);
    return bool;
  }
  
  public static boolean aQn()
  {
    AppMethodBeat.i(240835);
    if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("vivo".toLowerCase()))
    {
      AppMethodBeat.o(240835);
      return true;
    }
    AppMethodBeat.o(240835);
    return false;
  }
  
  public static boolean aQo()
  {
    AppMethodBeat.i(240837);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("huawei".toLowerCase());
    AppMethodBeat.o(240837);
    return bool;
  }
  
  public static boolean aQp()
  {
    AppMethodBeat.i(240839);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("honor".toLowerCase());
    AppMethodBeat.o(240839);
    return bool;
  }
  
  public static boolean isSamsung()
  {
    AppMethodBeat.i(155906);
    boolean bool = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("samsung".toLowerCase());
    AppMethodBeat.o(155906);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.util.l
 * JD-Core Version:    0.7.0.1
 */