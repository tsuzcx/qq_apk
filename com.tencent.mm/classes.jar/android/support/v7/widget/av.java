package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.graphics.b;
import android.util.TypedValue;

final class av
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] FOCUSED_STATE_SET;
  static final int[] PRESSED_STATE_SET;
  private static final ThreadLocal<TypedValue> QX = new ThreadLocal();
  static final int[] SELECTED_STATE_SET;
  static final int[] aoi;
  static final int[] aoj;
  private static final int[] aok = new int[1];
  static final int[] dP;
  static final int[] gc = { -16842910 };
  
  static
  {
    FOCUSED_STATE_SET = new int[] { 16842908 };
    aoi = new int[] { 16843518 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    dP = new int[] { 16842912 };
    SELECTED_STATE_SET = new int[] { 16842913 };
    aoj = new int[] { -16842919, -16842908 };
  }
  
  public static int u(Context paramContext, int paramInt)
  {
    aok[0] = paramInt;
    paramContext = az.a(paramContext, null, aok);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.aoo.recycle();
    }
  }
  
  public static ColorStateList v(Context paramContext, int paramInt)
  {
    aok[0] = paramInt;
    paramContext = az.a(paramContext, null, aok);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.aoo.recycle();
    }
  }
  
  public static int w(Context paramContext, int paramInt)
  {
    Object localObject = v(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(gc, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)QX.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      QX.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f = ((TypedValue)localObject).getFloat();
    paramInt = u(paramContext, paramInt);
    return b.p(paramInt, Math.round(f * Color.alpha(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.av
 * JD-Core Version:    0.7.0.1
 */