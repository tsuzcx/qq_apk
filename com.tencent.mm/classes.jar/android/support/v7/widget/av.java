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
  static final int[] SELECTED_STATE_SET;
  private static final ThreadLocal<TypedValue> XW = new ThreadLocal();
  static final int[] avJ;
  static final int[] avK;
  private static final int[] avL = new int[1];
  static final int[] gZ;
  static final int[] hl = { -16842910 };
  
  static
  {
    FOCUSED_STATE_SET = new int[] { 16842908 };
    avJ = new int[] { 16843518 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    gZ = new int[] { 16842912 };
    SELECTED_STATE_SET = new int[] { 16842913 };
    avK = new int[] { -16842919, -16842908 };
  }
  
  public static int v(Context paramContext, int paramInt)
  {
    avL[0] = paramInt;
    paramContext = az.a(paramContext, null, avL);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.avP.recycle();
    }
  }
  
  public static ColorStateList w(Context paramContext, int paramInt)
  {
    avL[0] = paramInt;
    paramContext = az.a(paramContext, null, avL);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.avP.recycle();
    }
  }
  
  public static int x(Context paramContext, int paramInt)
  {
    Object localObject = w(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(hl, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)XW.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      XW.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f = ((TypedValue)localObject).getFloat();
    paramInt = v(paramContext, paramInt);
    return b.q(paramInt, Math.round(f * Color.alpha(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.av
 * JD-Core Version:    0.7.0.1
 */