package com.tencent.mm.modelappbrand.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

final class e
  extends BitmapDrawable
{
  e(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((getBitmap() != null) && (!getBitmap().isRecycled())) {
      super.draw(paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.e
 * JD-Core Version:    0.7.0.1
 */