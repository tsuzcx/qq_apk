package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends RippleDrawable
{
  a(ColorStateList paramColorStateList, InsetDrawable paramInsetDrawable, Drawable paramDrawable)
  {
    super(paramColorStateList, paramInsetDrawable, paramDrawable);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(209840);
    if (getDrawable(0) != null) {
      ((GradientDrawable)((LayerDrawable)((InsetDrawable)getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(paramColorFilter);
    }
    AppMethodBeat.o(209840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.button.a
 * JD-Core Version:    0.7.0.1
 */