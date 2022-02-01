package com.google.android.material.b;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static PorterDuffColorFilter a(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(237023);
    if ((paramColorStateList == null) || (paramMode == null))
    {
      AppMethodBeat.o(237023);
      return null;
    }
    paramDrawable = new PorterDuffColorFilter(paramColorStateList.getColorForState(paramDrawable.getState(), 0), paramMode);
    AppMethodBeat.o(237023);
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.b.a
 * JD-Core Version:    0.7.0.1
 */