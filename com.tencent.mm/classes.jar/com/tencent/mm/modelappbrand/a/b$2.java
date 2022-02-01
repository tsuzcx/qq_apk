package com.tencent.mm.modelappbrand.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  extends b.m
{
  b$2(b paramb1, ImageView paramImageView, b paramb2, String paramString, Drawable paramDrawable)
  {
    super(paramImageView, paramb2, paramString, null, (byte)0);
  }
  
  public final void bhq()
  {
    AppMethodBeat.i(131337);
    if ((getImageView() != null) && (this.lzb != null)) {
      getImageView().setImageDrawable(this.lzb);
    }
    AppMethodBeat.o(131337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.2
 * JD-Core Version:    0.7.0.1
 */