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
  private static final SparseIntArray cqh;
  private static float density;
  
  static
  {
    AppMethodBeat.i(258910);
    density = -1.0F;
    cqh = new SparseIntArray();
    AppMethodBeat.o(258910);
  }
  
  public static int H(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(258909);
    float f1 = paramInt;
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = b.cox;
      localContext = b.a.getAppContext();
    }
    float f2 = localContext.getResources().getDisplayMetrics().density;
    density = f2;
    paramInt = Math.round(f1 / f2);
    AppMethodBeat.o(258909);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.ui.c
 * JD-Core Version:    0.7.0.1
 */