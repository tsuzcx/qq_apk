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
  private static final int[] dwe = { a.b.colorPrimary };
  private static final int[] dwf = { a.b.colorSecondary };
  
  public static TypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    AppMethodBeat.i(209274);
    c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    AppMethodBeat.o(209274);
    return paramContext;
  }
  
  private static void a(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(209366);
    if (!a(paramContext, paramArrayOfInt))
    {
      paramContext = new IllegalArgumentException("The style on this component requires your app theme to be " + paramString + " (or a descendant).");
      AppMethodBeat.o(209366);
      throw paramContext;
    }
    AppMethodBeat.o(209366);
  }
  
  private static boolean a(Context paramContext, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209351);
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    AppMethodBeat.o(209351);
    return bool;
  }
  
  private static void aO(Context paramContext)
  {
    AppMethodBeat.i(209330);
    a(paramContext, dwe, "Theme.AppCompat");
    AppMethodBeat.o(209330);
  }
  
  private static void aP(Context paramContext)
  {
    AppMethodBeat.i(209342);
    a(paramContext, dwf, "Theme.MaterialComponents");
    AppMethodBeat.o(209342);
  }
  
  public static ac b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    AppMethodBeat.i(209285);
    c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    paramContext = ac.a(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    AppMethodBeat.o(209285);
    return paramContext;
  }
  
  private static void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209297);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(a.k.ThemeEnforcement_enforceMaterialTheme, false);
    paramAttributeSet.recycle();
    if (bool) {
      aP(paramContext);
    }
    aO(paramContext);
    AppMethodBeat.o(209297);
  }
  
  private static void c(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    boolean bool = false;
    AppMethodBeat.i(209310);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ThemeEnforcement, paramInt1, paramInt2);
    if (!localTypedArray.getBoolean(a.k.ThemeEnforcement_enforceTextAppearance, false))
    {
      localTypedArray.recycle();
      AppMethodBeat.o(209310);
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
      AppMethodBeat.o(209310);
      throw paramContext;
    }
    AppMethodBeat.o(209310);
  }
  
  private static boolean d(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    AppMethodBeat.i(209324);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        AppMethodBeat.o(209324);
        return false;
      }
      paramInt1 += 1;
    }
    paramContext.recycle();
    AppMethodBeat.o(209324);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.k
 * JD-Core Version:    0.7.0.1
 */