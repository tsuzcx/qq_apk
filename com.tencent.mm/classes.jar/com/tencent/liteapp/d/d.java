package com.tencent.liteapp.d;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static SparseIntArray csc;
  private static float density;
  private static float scale;
  
  static
  {
    AppMethodBeat.i(197805);
    density = -1.0F;
    scale = 0.0F;
    csc = new SparseIntArray();
    AppMethodBeat.o(197805);
  }
  
  public static int ax(Context paramContext)
  {
    AppMethodBeat.i(197804);
    if ((paramContext != null) && (density < 0.0F)) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    int i = Math.round(density * 25.0F);
    AppMethodBeat.o(197804);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteapp.d.d
 * JD-Core Version:    0.7.0.1
 */