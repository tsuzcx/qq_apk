package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bk;

public final class o
{
  public static String ff(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return paramString;
        } while ((q.dyn.dwZ == 2) || (q.dyn.dxk == 1));
        if (q.dyn.dwZ != 1) {
          break;
        }
      } while (!paramString.toString().contains("\n"));
      return paramString.toString().replace("\n", " ");
    } while ((Build.VERSION.SDK_INT != 16) || (!paramString.toString().contains("\n")) || (bk.aM(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0));
    return paramString.toString().replace("\n", " ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.util.o
 * JD-Core Version:    0.7.0.1
 */