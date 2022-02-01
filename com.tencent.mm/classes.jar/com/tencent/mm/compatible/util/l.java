package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;

public final class l
{
  public static boolean XU()
  {
    AppMethodBeat.i(155909);
    String str = af.get("ro.mediatek.platform");
    if ((str != null) && ((str.startsWith("MT")) || (str.startsWith("mt"))))
    {
      AppMethodBeat.o(155909);
      return true;
    }
    AppMethodBeat.o(155909);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.l
 * JD-Core Version:    0.7.0.1
 */