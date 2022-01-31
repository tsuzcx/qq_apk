package com.tencent.mm.plugin.fts.a.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public final class c$a
  extends BitmapDrawable
{
  private c$a(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static void a(Resources paramResources, Bitmap paramBitmap, ImageView paramImageView)
  {
    paramImageView.setImageDrawable(new a(paramResources, paramBitmap));
    paramImageView.postInvalidate();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((getBitmap() != null) && (!getBitmap().isRecycled())) {
      super.draw(paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.c.a
 * JD-Core Version:    0.7.0.1
 */