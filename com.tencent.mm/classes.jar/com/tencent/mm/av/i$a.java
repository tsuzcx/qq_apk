package com.tencent.mm.av;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i$a
  extends BitmapDrawable
{
  private i$a(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static void a(Bitmap paramBitmap, ImageView paramImageView)
  {
    AppMethodBeat.i(150564);
    if ((paramImageView == null) || (paramImageView.getResources() == null))
    {
      AppMethodBeat.o(150564);
      return;
    }
    paramBitmap = new a(paramImageView.getResources(), paramBitmap);
    if (paramImageView.getLayerType() == 1)
    {
      paramImageView.destroyDrawingCache();
      paramImageView.setLayerType(0, null);
    }
    paramImageView.setImageDrawable(paramBitmap);
    AppMethodBeat.o(150564);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(150565);
    if ((getBitmap() != null) && (!getBitmap().isRecycled()))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(150565);
      return;
    }
    if (getBitmap() != null) {
      Log.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", new Object[] { getBitmap().toString() });
    }
    AppMethodBeat.o(150565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.i.a
 * JD-Core Version:    0.7.0.1
 */