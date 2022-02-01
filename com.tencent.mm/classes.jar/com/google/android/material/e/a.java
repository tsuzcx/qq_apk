package com.google.android.material.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static ColorStateList b(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    AppMethodBeat.i(209013);
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = androidx.appcompat.a.a.a.l(paramContext, i);
        if (paramContext != null)
        {
          AppMethodBeat.o(209013);
          return paramContext;
        }
      }
    }
    paramContext = paramTypedArray.getColorStateList(paramInt);
    AppMethodBeat.o(209013);
    return paramContext;
  }
  
  public static Drawable c(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    AppMethodBeat.i(209019);
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = androidx.appcompat.a.a.a.m(paramContext, i);
        if (paramContext != null)
        {
          AppMethodBeat.o(209019);
          return paramContext;
        }
      }
    }
    paramContext = paramTypedArray.getDrawable(paramInt);
    AppMethodBeat.o(209019);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.e.a
 * JD-Core Version:    0.7.0.1
 */