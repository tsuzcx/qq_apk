package com.bumptech.glide.load.d.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.e.c;

public abstract class b<T extends Drawable>
  implements r, v<T>
{
  protected final T drawable;
  
  public b(T paramT)
  {
    this.drawable = ((Drawable)j.checkNotNull(paramT, "Argument must not be null"));
  }
  
  public void initialize()
  {
    if ((this.drawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)this.drawable).getBitmap().prepareToDraw();
    }
    while (!(this.drawable instanceof c)) {
      return;
    }
    ((c)this.drawable).pJ().prepareToDraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.c.b
 * JD-Core Version:    0.7.0.1
 */