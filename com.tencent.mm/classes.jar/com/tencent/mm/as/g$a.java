package com.tencent.mm.as;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

public final class g$a
  extends BitmapDrawable
{
  private g$a(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static void a(Bitmap paramBitmap, ImageView paramImageView)
  {
    if ((paramImageView == null) || (paramImageView.getResources() == null)) {
      return;
    }
    paramBitmap = new a(paramImageView.getResources(), paramBitmap);
    if (paramImageView.getLayerType() == 1)
    {
      paramImageView.destroyDrawingCache();
      paramImageView.setLayerType(0, null);
    }
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((getBitmap() != null) && (!getBitmap().isRecycled())) {
      super.draw(paramCanvas);
    }
    while (getBitmap() == null) {
      return;
    }
    y.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", new Object[] { getBitmap().toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.as.g.a
 * JD-Core Version:    0.7.0.1
 */