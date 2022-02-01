package com.tencent.liteapp.d;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static float density;
  private static SparseIntArray ehY;
  private static float scale;
  
  static
  {
    AppMethodBeat.i(219070);
    density = -1.0F;
    scale = 0.0F;
    ehY = new SparseIntArray();
    AppMethodBeat.o(219070);
  }
  
  public static int bd(Context paramContext)
  {
    AppMethodBeat.i(219064);
    if ((paramContext != null) && (density < 0.0F)) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    int i = Math.round(density * 25.0F);
    AppMethodBeat.o(219064);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.d.e
 * JD-Core Version:    0.7.0.1
 */