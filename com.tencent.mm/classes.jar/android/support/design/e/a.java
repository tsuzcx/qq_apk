package android.support.design.e;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v4.graphics.b;
import android.util.StateSet;

public final class a
{
  private static final int[] FOCUSED_STATE_SET;
  private static final int[] PRESSED_STATE_SET;
  private static final int[] SELECTED_STATE_SET;
  public static final boolean lH;
  private static final int[] lI;
  private static final int[] lJ;
  private static final int[] lK;
  private static final int[] lL;
  private static final int[] lM;
  private static final int[] lN;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      lH = bool;
      PRESSED_STATE_SET = new int[] { 16842919 };
      lI = new int[] { 16843623, 16842908 };
      FOCUSED_STATE_SET = new int[] { 16842908 };
      lJ = new int[] { 16843623 };
      lK = new int[] { 16842913, 16842919 };
      lL = new int[] { 16842913, 16843623, 16842908 };
      lM = new int[] { 16842913, 16842908 };
      lN = new int[] { 16842913, 16843623 };
      SELECTED_STATE_SET = new int[] { 16842913 };
      return;
    }
  }
  
  @TargetApi(21)
  private static int E(int paramInt)
  {
    return b.x(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
  }
  
  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    if (paramColorStateList != null) {}
    for (int i = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());; i = 0)
    {
      int j = i;
      if (lH) {
        j = E(i);
      }
      return j;
    }
  }
  
  public static ColorStateList b(ColorStateList paramColorStateList)
  {
    if (lH)
    {
      arrayOfInt1 = SELECTED_STATE_SET;
      i = a(paramColorStateList, lK);
      arrayOfInt2 = StateSet.NOTHING;
      j = a(paramColorStateList, PRESSED_STATE_SET);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
    }
    int[] arrayOfInt1 = lK;
    int i = a(paramColorStateList, lK);
    int[] arrayOfInt2 = lL;
    int j = a(paramColorStateList, lL);
    int[] arrayOfInt3 = lM;
    int k = a(paramColorStateList, lM);
    int[] arrayOfInt4 = lN;
    int m = a(paramColorStateList, lN);
    int[] arrayOfInt5 = SELECTED_STATE_SET;
    int[] arrayOfInt6 = PRESSED_STATE_SET;
    int n = a(paramColorStateList, PRESSED_STATE_SET);
    int[] arrayOfInt7 = lI;
    int i1 = a(paramColorStateList, lI);
    int[] arrayOfInt8 = FOCUSED_STATE_SET;
    int i2 = a(paramColorStateList, FOCUSED_STATE_SET);
    int[] arrayOfInt9 = lJ;
    int i3 = a(paramColorStateList, lJ);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, j, k, m, 0, n, i1, i2, i3, 0 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.e.a
 * JD-Core Version:    0.7.0.1
 */