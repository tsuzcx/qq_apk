package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.bk;

public final class l
{
  public static boolean wx()
  {
    return bk.aM(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.l
 * JD-Core Version:    0.7.0.1
 */