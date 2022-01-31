package com.tencent.magicbrush.handler.a;

import android.graphics.Rect;

abstract interface d
{
  public abstract void a(int paramInt1, int paramInt2, Rect paramRect);
  
  public abstract void init(int paramInt1, int paramInt2);
  
  public abstract void reset();
  
  public static final class c
  {
    public int height;
    public int width;
    public int x;
    public int y;
    
    public final String toString()
    {
      return "[" + this.x + ", " + this.y + ", " + this.width + ", " + this.height + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.d
 * JD-Core Version:    0.7.0.1
 */