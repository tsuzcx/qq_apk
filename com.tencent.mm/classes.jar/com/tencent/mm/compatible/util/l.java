package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
{
  public static boolean IM()
  {
    AppMethodBeat.i(93105);
    if (bo.bf(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0)
    {
      AppMethodBeat.o(93105);
      return true;
    }
    AppMethodBeat.o(93105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.l
 * JD-Core Version:    0.7.0.1
 */