package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ad;

public final class m
{
  public static boolean Ms()
  {
    AppMethodBeat.i(93106);
    String str = ad.get("ro.mediatek.platform");
    if ((str != null) && ((str.startsWith("MT")) || (str.startsWith("mt"))))
    {
      AppMethodBeat.o(93106);
      return true;
    }
    AppMethodBeat.o(93106);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.m
 * JD-Core Version:    0.7.0.1
 */