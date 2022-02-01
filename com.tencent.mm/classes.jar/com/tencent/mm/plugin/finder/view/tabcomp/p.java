package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.StateSet;
import androidx.core.graphics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  private static final int[] dwA;
  private static final int[] dwB;
  private static final int[] dwC;
  private static final int[] dwD;
  private static final int[] dwE;
  private static final int[] dwF;
  public static final boolean dwz;
  private static final int[] xm;
  private static final int[] xo;
  private static final int[] xp;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      dwz = bool;
      xo = new int[] { 16842919 };
      dwA = new int[] { 16843623, 16842908 };
      xm = new int[] { 16842908 };
      dwB = new int[] { 16843623 };
      dwC = new int[] { 16842913, 16842919 };
      dwD = new int[] { 16842913, 16843623, 16842908 };
      dwE = new int[] { 16842913, 16842908 };
      dwF = new int[] { 16842913, 16843623 };
      xp = new int[] { 16842913 };
      return;
    }
  }
  
  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(345536);
    if (paramColorStateList != null) {}
    for (int i = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor()); dwz; i = 0)
    {
      i = jq(i);
      AppMethodBeat.o(345536);
      return i;
    }
    AppMethodBeat.o(345536);
    return i;
  }
  
  public static ColorStateList g(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(345530);
    if (dwz)
    {
      arrayOfInt1 = xp;
      i = a(paramColorStateList, dwC);
      arrayOfInt2 = StateSet.NOTHING;
      j = a(paramColorStateList, xo);
      paramColorStateList = new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
      AppMethodBeat.o(345530);
      return paramColorStateList;
    }
    int[] arrayOfInt1 = dwC;
    int i = a(paramColorStateList, dwC);
    int[] arrayOfInt2 = dwD;
    int j = a(paramColorStateList, dwD);
    int[] arrayOfInt3 = dwE;
    int k = a(paramColorStateList, dwE);
    int[] arrayOfInt4 = dwF;
    int m = a(paramColorStateList, dwF);
    int[] arrayOfInt5 = xp;
    int[] arrayOfInt6 = xo;
    int n = a(paramColorStateList, xo);
    int[] arrayOfInt7 = dwA;
    int i1 = a(paramColorStateList, dwA);
    int[] arrayOfInt8 = xm;
    int i2 = a(paramColorStateList, xm);
    int[] arrayOfInt9 = dwB;
    int i3 = a(paramColorStateList, dwB);
    paramColorStateList = new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, j, k, m, 0, n, i1, i2, i3, 0 });
    AppMethodBeat.o(345530);
    return paramColorStateList;
  }
  
  private static int jq(int paramInt)
  {
    AppMethodBeat.i(345543);
    paramInt = b.ax(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
    AppMethodBeat.o(345543);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.p
 * JD-Core Version:    0.7.0.1
 */