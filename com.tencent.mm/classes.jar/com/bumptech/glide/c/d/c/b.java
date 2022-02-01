package com.bumptech.glide.c.d.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.e.c;
import com.bumptech.glide.h.i;

public abstract class b<T extends Drawable>
  implements q, u<T>
{
  protected final T drawable;
  
  public b(T paramT)
  {
    this.drawable = ((Drawable)i.checkNotNull(paramT, "Argument must not be null"));
  }
  
  public void initialize()
  {
    if ((this.drawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)this.drawable).getBitmap().prepareToDraw();
    }
    while (!(this.drawable instanceof c)) {
      return;
    }
    ((c)this.drawable).pc().prepareToDraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.c.b
 * JD-Core Version:    0.7.0.1
 */