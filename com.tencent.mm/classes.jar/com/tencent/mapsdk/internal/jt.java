package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jt
{
  public static int a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(224014);
    paramInt = (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
    AppMethodBeat.o(224014);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jt
 * JD-Core Version:    0.7.0.1
 */