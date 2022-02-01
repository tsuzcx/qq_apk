package com.google.android.material.f;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.StateSet;
import androidx.core.graphics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static final int[] bDA;
  private static final int[] bDB;
  private static final int[] bDC;
  private static final int[] bDD;
  private static final int[] bDE;
  public static final boolean bDy;
  private static final int[] bDz;
  private static final int[] wq;
  private static final int[] ws;
  private static final int[] wt;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      bDy = bool;
      ws = new int[] { 16842919 };
      bDz = new int[] { 16843623, 16842908 };
      wq = new int[] { 16842908 };
      bDA = new int[] { 16843623 };
      bDB = new int[] { 16842913, 16842919 };
      bDC = new int[] { 16842913, 16843623, 16842908 };
      bDD = new int[] { 16842913, 16842908 };
      bDE = new int[] { 16842913, 16843623 };
      wt = new int[] { 16842913 };
      return;
    }
  }
  
  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238778);
    if (paramColorStateList != null) {}
    for (int i = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor()); bDy; i = 0)
    {
      i = gb(i);
      AppMethodBeat.o(238778);
      return i;
    }
    AppMethodBeat.o(238778);
    return i;
  }
  
  public static ColorStateList g(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(238774);
    if (bDy)
    {
      arrayOfInt1 = wt;
      i = a(paramColorStateList, bDB);
      arrayOfInt2 = StateSet.NOTHING;
      j = a(paramColorStateList, ws);
      paramColorStateList = new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
      AppMethodBeat.o(238774);
      return paramColorStateList;
    }
    int[] arrayOfInt1 = bDB;
    int i = a(paramColorStateList, bDB);
    int[] arrayOfInt2 = bDC;
    int j = a(paramColorStateList, bDC);
    int[] arrayOfInt3 = bDD;
    int k = a(paramColorStateList, bDD);
    int[] arrayOfInt4 = bDE;
    int m = a(paramColorStateList, bDE);
    int[] arrayOfInt5 = wt;
    int[] arrayOfInt6 = ws;
    int n = a(paramColorStateList, ws);
    int[] arrayOfInt7 = bDz;
    int i1 = a(paramColorStateList, bDz);
    int[] arrayOfInt8 = wq;
    int i2 = a(paramColorStateList, wq);
    int[] arrayOfInt9 = bDA;
    int i3 = a(paramColorStateList, bDA);
    paramColorStateList = new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, j, k, m, 0, n, i1, i2, i3, 0 });
    AppMethodBeat.o(238774);
    return paramColorStateList;
  }
  
  @TargetApi(21)
  private static int gb(int paramInt)
  {
    AppMethodBeat.i(238781);
    paramInt = b.C(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
    AppMethodBeat.o(238781);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.f.a
 * JD-Core Version:    0.7.0.1
 */