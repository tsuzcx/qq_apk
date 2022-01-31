package com.tencent.mm.plugin.fts.a.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
  extends BitmapDrawable
{
  private c$a(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static void a(Resources paramResources, Bitmap paramBitmap, ImageView paramImageView)
  {
    AppMethodBeat.i(114296);
    paramImageView.setImageDrawable(new a(paramResources, paramBitmap));
    paramImageView.postInvalidate();
    AppMethodBeat.o(114296);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(114297);
    if ((getBitmap() != null) && (!getBitmap().isRecycled())) {
      super.draw(paramCanvas);
    }
    AppMethodBeat.o(114297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.c.a
 * JD-Core Version:    0.7.0.1
 */