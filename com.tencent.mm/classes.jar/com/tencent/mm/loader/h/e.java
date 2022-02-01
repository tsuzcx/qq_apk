package com.tencent.mm.loader.h;

import android.graphics.Bitmap;

public final class e<T>
{
  private e<?> kQL;
  public T value;
  
  public e() {}
  
  public e(T paramT)
  {
    this.value = paramT;
  }
  
  public final T aSr()
  {
    return this.value;
  }
  
  public final e aSs()
  {
    return this.kQL;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.e
 * JD-Core Version:    0.7.0.1
 */