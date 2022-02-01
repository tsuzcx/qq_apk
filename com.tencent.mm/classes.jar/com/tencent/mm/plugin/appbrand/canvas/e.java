package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.a.b;

public abstract interface e
  extends b
{
  public abstract Bitmap a(d paramd, String paramString);
  
  public abstract Bitmap a(d paramd, String paramString, Rect paramRect, a parama);
  
  public abstract Bitmap a(d paramd, String paramString, a parama);
  
  public static abstract interface a
  {
    public abstract void a(d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.e
 * JD-Core Version:    0.7.0.1
 */