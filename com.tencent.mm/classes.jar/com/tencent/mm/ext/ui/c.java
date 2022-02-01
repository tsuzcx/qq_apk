package com.tencent.mm.ext.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.liteapp.b;
import com.tencent.liteapp.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static float density;
  private static final SparseIntArray ehY;
  
  static
  {
    AppMethodBeat.i(235339);
    density = -1.0F;
    ehY = new SparseIntArray();
    AppMethodBeat.o(235339);
  }
  
  public static int K(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(235334);
    float f1 = paramInt;
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = b.efD;
      localContext = b.a.getAppContext();
    }
    float f2 = localContext.getResources().getDisplayMetrics().density;
    density = f2;
    paramInt = Math.round(f1 / f2);
    AppMethodBeat.o(235334);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.ui.c
 * JD-Core Version:    0.7.0.1
 */