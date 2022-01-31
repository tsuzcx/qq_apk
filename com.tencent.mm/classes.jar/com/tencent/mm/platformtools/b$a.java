package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class b$a
{
  public static int b(Context paramContext, float paramFloat)
  {
    new f();
    return Math.round(paramContext.getResources().getDisplayMetrics().densityDpi * paramFloat / 160.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.b.a
 * JD-Core Version:    0.7.0.1
 */