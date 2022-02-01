package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.ac;
import com.google.android.material.a.b;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static final int[] bDd = { a.b.colorPrimary };
  private static final int[] bDe = { a.b.colorSecondary };
  
  public static TypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    AppMethodBeat.i(238309);
    c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    AppMethodBeat.o(238309);
    return paramContext;
  }
  
  private static void a(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(238337);
    if (!a(paramContext, paramArrayOfInt))
    {
      paramContext = new IllegalArgumentException("The style on this component requires your app theme to be " + paramString + " (or a descendant).");
      AppMethodBeat.o(238337);
      throw paramContext;
    }
    AppMethodBeat.o(238337);
  }
  
  private static boolean a(Context paramContext, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238335);
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    AppMethodBeat.o(238335);
    return bool;
  }
  
  private static void ad(Context paramContext)
  {
    AppMethodBeat.i(238327);
    a(paramContext, bDd, "Theme.AppCompat");
    AppMethodBeat.o(238327);
  }
  
  private static void ae(Context paramContext)
  {
    AppMethodBeat.i(238331);
    a(paramContext, bDe, "Theme.MaterialComponents");
    AppMethodBeat.o(238331);
  }
  
  public static ac b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    AppMethodBeat.i(238311);
    c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    paramContext = ac.a(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    AppMethodBeat.o(238311);
    return paramContext;
  }
  
  private static void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238315);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(a.k.ThemeEnforcement_enforceMaterialTheme, false);
    paramAttributeSet.recycle();
    if (bool) {
      ae(paramContext);
    }
    ad(paramContext);
    AppMethodBeat.o(238315);
  }
  
  private static void c(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    boolean bool = false;
    AppMethodBeat.i(238319);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ThemeEnforcement, paramInt1, paramInt2);
    if (!localTypedArray.getBoolean(a.k.ThemeEnforcement_enforceTextAppearance, false))
    {
      localTypedArray.recycle();
      AppMethodBeat.o(238319);
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      if (localTypedArray.getResourceId(a.k.ThemeEnforcement_android_textAppearance, -1) == -1) {}
    }
    for (bool = true;; bool = d(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs))
    {
      localTypedArray.recycle();
      if (bool) {
        break;
      }
      paramContext = new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
      AppMethodBeat.o(238319);
      throw paramContext;
    }
    AppMethodBeat.o(238319);
  }
  
  private static boolean d(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    AppMethodBeat.i(238324);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        AppMethodBeat.o(238324);
        return false;
      }
      paramInt1 += 1;
    }
    paramContext.recycle();
    AppMethodBeat.o(238324);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.k
 * JD-Core Version:    0.7.0.1
 */