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
  public static final boolean iQ;
  private static final int[] iR;
  private static final int[] iS;
  private static final int[] iT;
  private static final int[] iU;
  private static final int[] iV;
  private static final int[] iW;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      iQ = bool;
      PRESSED_STATE_SET = new int[] { 16842919 };
      iR = new int[] { 16843623, 16842908 };
      FOCUSED_STATE_SET = new int[] { 16842908 };
      iS = new int[] { 16843623 };
      iT = new int[] { 16842913, 16842919 };
      iU = new int[] { 16842913, 16843623, 16842908 };
      iV = new int[] { 16842913, 16842908 };
      iW = new int[] { 16842913, 16843623 };
      SELECTED_STATE_SET = new int[] { 16842913 };
      return;
    }
  }
  
  @TargetApi(21)
  private static int E(int paramInt)
  {
    return b.q(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
  }
  
  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    if (paramColorStateList != null) {}
    for (int i = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());; i = 0)
    {
      int j = i;
      if (iQ) {
        j = E(i);
      }
      return j;
    }
  }
  
  public static ColorStateList b(ColorStateList paramColorStateList)
  {
    if (iQ)
    {
      arrayOfInt1 = SELECTED_STATE_SET;
      i = a(paramColorStateList, iT);
      arrayOfInt2 = StateSet.NOTHING;
      j = a(paramColorStateList, PRESSED_STATE_SET);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
    }
    int[] arrayOfInt1 = iT;
    int i = a(paramColorStateList, iT);
    int[] arrayOfInt2 = iU;
    int j = a(paramColorStateList, iU);
    int[] arrayOfInt3 = iV;
    int k = a(paramColorStateList, iV);
    int[] arrayOfInt4 = iW;
    int m = a(paramColorStateList, iW);
    int[] arrayOfInt5 = SELECTED_STATE_SET;
    int[] arrayOfInt6 = PRESSED_STATE_SET;
    int n = a(paramColorStateList, PRESSED_STATE_SET);
    int[] arrayOfInt7 = iR;
    int i1 = a(paramColorStateList, iR);
    int[] arrayOfInt8 = FOCUSED_STATE_SET;
    int i2 = a(paramColorStateList, FOCUSED_STATE_SET);
    int[] arrayOfInt9 = iS;
    int i3 = a(paramColorStateList, iS);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, j, k, m, 0, n, i1, i2, i3, 0 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.e.a
 * JD-Core Version:    0.7.0.1
 */