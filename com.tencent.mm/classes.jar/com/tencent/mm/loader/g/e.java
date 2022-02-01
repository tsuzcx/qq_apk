package com.tencent.mm.loader.g;

import android.graphics.Bitmap;

public final class e<T>
{
  public e<?> nso;
  public T value;
  
  public e() {}
  
  public e(T paramT)
  {
    this.value = paramT;
  }
  
  public final boolean isValid()
  {
    if (this.value == null) {
      return false;
    }
    if ((this.value instanceof Bitmap)) {
      return !((Bitmap)this.value).isRecycled();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.e
 * JD-Core Version:    0.7.0.1
 */