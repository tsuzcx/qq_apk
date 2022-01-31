package com.tencent.mm.modelappbrand.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends BitmapDrawable
{
  public e(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(77382);
    if ((getBitmap() != null) && (!getBitmap().isRecycled())) {
      super.draw(paramCanvas);
    }
    AppMethodBeat.o(77382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.e
 * JD-Core Version:    0.7.0.1
 */