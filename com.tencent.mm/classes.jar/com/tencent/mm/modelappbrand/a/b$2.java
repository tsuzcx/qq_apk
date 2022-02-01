package com.tencent.mm.modelappbrand.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  extends b.m
{
  b$2(b paramb1, ImageView paramImageView, b paramb2, Drawable paramDrawable)
  {
    super(paramImageView, paramb2, (byte)0);
  }
  
  public final void aEt()
  {
    AppMethodBeat.i(131337);
    if ((getImageView() != null) && (this.hNS != null)) {
      getImageView().setImageDrawable(this.hNS);
    }
    AppMethodBeat.o(131337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.2
 * JD-Core Version:    0.7.0.1
 */