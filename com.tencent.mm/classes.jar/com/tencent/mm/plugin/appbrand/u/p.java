package com.tencent.mm.plugin.appbrand.u;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ae;

public final class p
{
  private static DisplayMetrics hkX = ae.getContext().getResources().getDisplayMetrics();
  
  public static int aqq()
  {
    if (hkX == null) {
      return 16;
    }
    return (int)(hkX.density * 16.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.p
 * JD-Core Version:    0.7.0.1
 */