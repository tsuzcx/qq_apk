package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.a.b;
import android.util.TypedValue;

final class at
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] FOCUSED_STATE_SET;
  static final int[] PRESSED_STATE_SET;
  private static final ThreadLocal<TypedValue> Rp = new ThreadLocal();
  static final int[] SELECTED_STATE_SET;
  static final int[] alQ;
  static final int[] alR;
  private static final int[] alS = new int[1];
  static final int[] cL;
  static final int[] fd = { -16842910 };
  
  static
  {
    FOCUSED_STATE_SET = new int[] { 16842908 };
    alQ = new int[] { 16843518 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    cL = new int[] { 16842912 };
    SELECTED_STATE_SET = new int[] { 16842913 };
    alR = new int[] { -16842919, -16842908 };
  }
  
  public static int q(Context paramContext, int paramInt)
  {
    alS[0] = paramInt;
    paramContext = ax.a(paramContext, null, alS);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.alZ.recycle();
    }
  }
  
  public static ColorStateList r(Context paramContext, int paramInt)
  {
    alS[0] = paramInt;
    paramContext = ax.a(paramContext, null, alS);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.alZ.recycle();
    }
  }
  
  public static int s(Context paramContext, int paramInt)
  {
    Object localObject = r(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(fd, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)Rp.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      Rp.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f = ((TypedValue)localObject).getFloat();
    paramInt = q(paramContext, paramInt);
    return b.p(paramInt, Math.round(f * Color.alpha(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.at
 * JD-Core Version:    0.7.0.1
 */