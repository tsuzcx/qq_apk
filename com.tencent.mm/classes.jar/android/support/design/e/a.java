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
  public static final boolean jP;
  private static final int[] jQ;
  private static final int[] jR;
  private static final int[] jS;
  private static final int[] jT;
  private static final int[] jU;
  private static final int[] jV;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      jP = bool;
      PRESSED_STATE_SET = new int[] { 16842919 };
      jQ = new int[] { 16843623, 16842908 };
      FOCUSED_STATE_SET = new int[] { 16842908 };
      jR = new int[] { 16843623 };
      jS = new int[] { 16842913, 16842919 };
      jT = new int[] { 16842913, 16843623, 16842908 };
      jU = new int[] { 16842913, 16842908 };
      jV = new int[] { 16842913, 16843623 };
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
      if (jP) {
        j = E(i);
      }
      return j;
    }
  }
  
  public static ColorStateList b(ColorStateList paramColorStateList)
  {
    if (jP)
    {
      arrayOfInt1 = SELECTED_STATE_SET;
      i = a(paramColorStateList, jS);
      arrayOfInt2 = StateSet.NOTHING;
      j = a(paramColorStateList, PRESSED_STATE_SET);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
    }
    int[] arrayOfInt1 = jS;
    int i = a(paramColorStateList, jS);
    int[] arrayOfInt2 = jT;
    int j = a(paramColorStateList, jT);
    int[] arrayOfInt3 = jU;
    int k = a(paramColorStateList, jU);
    int[] arrayOfInt4 = jV;
    int m = a(paramColorStateList, jV);
    int[] arrayOfInt5 = SELECTED_STATE_SET;
    int[] arrayOfInt6 = PRESSED_STATE_SET;
    int n = a(paramColorStateList, PRESSED_STATE_SET);
    int[] arrayOfInt7 = jQ;
    int i1 = a(paramColorStateList, jQ);
    int[] arrayOfInt8 = FOCUSED_STATE_SET;
    int i2 = a(paramColorStateList, FOCUSED_STATE_SET);
    int[] arrayOfInt9 = jR;
    int i3 = a(paramColorStateList, jR);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, j, k, m, 0, n, i1, i2, i3, 0 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.e.a
 * JD-Core Version:    0.7.0.1
 */