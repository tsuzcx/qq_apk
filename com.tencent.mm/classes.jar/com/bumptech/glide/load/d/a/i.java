package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.a.f;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

final class i
{
  private static final e aLl;
  
  static
  {
    AppMethodBeat.i(77403);
    aLl = new f()
    {
      public final void g(Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(77403);
  }
  
  static v<Bitmap> a(e parame, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77401);
    Drawable localDrawable = paramDrawable.getCurrent();
    paramDrawable = null;
    if ((localDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)localDrawable).getBitmap();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 != 0) {}
      for (;;)
      {
        parame = d.a(paramDrawable, parame);
        AppMethodBeat.o(77401);
        return parame;
        if ((localDrawable instanceof Animatable)) {
          break label78;
        }
        paramDrawable = b(parame, localDrawable, paramInt1, paramInt2);
        paramInt1 = 1;
        break;
        parame = aLl;
      }
      label78:
      paramInt1 = 0;
    }
  }
  
  private static Bitmap b(e parame, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77402);
    if ((paramInt1 == -2147483648) && (paramDrawable.getIntrinsicWidth() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5)) {
        new StringBuilder("Unable to draw ").append(paramDrawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
      }
      AppMethodBeat.o(77402);
      return null;
    }
    if ((paramInt2 == -2147483648) && (paramDrawable.getIntrinsicHeight() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5)) {
        new StringBuilder("Unable to draw ").append(paramDrawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
      }
      AppMethodBeat.o(77402);
      return null;
    }
    if (paramDrawable.getIntrinsicWidth() > 0) {
      paramInt1 = paramDrawable.getIntrinsicWidth();
    }
    if (paramDrawable.getIntrinsicHeight() > 0) {
      paramInt2 = paramDrawable.getIntrinsicHeight();
    }
    Lock localLock = q.pI();
    localLock.lock();
    parame = parame.b(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    try
    {
      Canvas localCanvas = new Canvas(parame);
      paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramDrawable.draw(localCanvas);
      localCanvas.setBitmap(null);
      return parame;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(77402);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.i
 * JD-Core Version:    0.7.0.1
 */