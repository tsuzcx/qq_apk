package com.bumptech.glide.c.d.c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends b<Drawable>
{
  private c(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  static u<Drawable> u(Drawable paramDrawable)
  {
    AppMethodBeat.i(77456);
    if (paramDrawable != null)
    {
      paramDrawable = new c(paramDrawable);
      AppMethodBeat.o(77456);
      return paramDrawable;
    }
    AppMethodBeat.o(77456);
    return null;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77458);
    int i = Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    AppMethodBeat.o(77458);
    return i;
  }
  
  public final Class<Drawable> oo()
  {
    AppMethodBeat.i(77457);
    Class localClass = this.drawable.getClass();
    AppMethodBeat.o(77457);
    return localClass;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.c.c
 * JD-Core Version:    0.7.0.1
 */