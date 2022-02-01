package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;

public final class f
{
  private static final int[] lq = { 2130968815 };
  private static final int[] lr = { 2130968818 };
  
  private static void F(Context paramContext)
  {
    a(paramContext, lq, "Theme.AppCompat");
  }
  
  private static void G(Context paramContext)
  {
    a(paramContext, lr, "Theme.MaterialComponents");
  }
  
  public static TypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  private static void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(1, false);
    paramAttributeSet.recycle();
    if (bool) {
      G(paramContext);
    }
    F(paramContext);
  }
  
  private static void a(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    if (!a(paramContext, paramArrayOfInt)) {
      throw new IllegalArgumentException("The style on this component requires your app theme to be " + paramString + " (or a descendant).");
    }
  }
  
  private static boolean a(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    return bool;
  }
  
  public static az b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return az.a(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  private static void c(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    boolean bool = false;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ThemeEnforcement, paramInt1, paramInt2);
    if (!localTypedArray.getBoolean(2, false))
    {
      localTypedArray.recycle();
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      if (localTypedArray.getResourceId(0, -1) == -1) {}
    }
    for (bool = true;; bool = d(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs))
    {
      localTypedArray.recycle();
      if (bool) {
        break;
      }
      throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }
  }
  
  private static boolean d(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        return false;
      }
      paramInt1 += 1;
    }
    paramContext.recycle();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.internal.f
 * JD-Core Version:    0.7.0.1
 */