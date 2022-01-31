package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

@Keep
public class MBCanvasContentHolder
{
  public Bitmap content;
  public int height;
  public int width;
  
  @Keep
  public MBCanvasContentHolder(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.content = paramBitmap;
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.MBCanvasContentHolder
 * JD-Core Version:    0.7.0.1
 */