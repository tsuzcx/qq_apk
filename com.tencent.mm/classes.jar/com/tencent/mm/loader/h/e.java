package com.tencent.mm.loader.h;

import android.graphics.Bitmap;

public final class e<T>
{
  private e<?> eQg;
  private T value;
  
  public e() {}
  
  public e(T paramT)
  {
    this.value = paramT;
  }
  
  public final e Uc()
  {
    return this.eQg;
  }
  
  public final T getValue()
  {
    return this.value;
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
  
  public final T value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.h.e
 * JD-Core Version:    0.7.0.1
 */