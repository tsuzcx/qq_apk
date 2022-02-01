package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap mContentBitmap;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    this.mContentBitmap = paramBitmap;
  }
  
  public Bitmap getBitmap()
  {
    return this.mContentBitmap;
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap) {}
  
  protected Bitmap onGetBitmap()
  {
    return this.mContentBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */