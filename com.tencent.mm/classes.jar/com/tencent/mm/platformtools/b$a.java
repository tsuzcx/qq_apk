package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
{
  public static int b(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(16658);
    new f();
    int i = Math.round(paramContext.getResources().getDisplayMetrics().densityDpi * paramFloat / 160.0F);
    AppMethodBeat.o(16658);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.b.a
 * JD-Core Version:    0.7.0.1
 */