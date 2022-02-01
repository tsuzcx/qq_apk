package com.tencent.mm.ext.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.liteapp.a;
import com.tencent.liteapp.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static final SparseIntArray csc;
  private static float density;
  
  static
  {
    AppMethodBeat.i(197825);
    density = -1.0F;
    csc = new SparseIntArray();
    AppMethodBeat.o(197825);
  }
  
  public static int E(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(197824);
    float f1 = paramInt;
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = a.cqJ;
      localContext = a.a.getAppContext();
    }
    float f2 = localContext.getResources().getDisplayMetrics().density;
    density = f2;
    paramInt = Math.round(f1 / f2);
    AppMethodBeat.o(197824);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ext.ui.c
 * JD-Core Version:    0.7.0.1
 */