package com.github.henryye.nativeiv.bitmap;

import android.graphics.Bitmap.Config;
import android.support.annotation.Keep;
import java.io.InputStream;

public abstract interface IBitmap<Type>
{
  public abstract void decodeInputStream(InputStream paramInputStream, Bitmap.Config paramConfig, c paramc);
  
  public abstract long getDecodeTime();
  
  public abstract BitmapType getType();
  
  public abstract Type provide();
  
  @Keep
  public abstract void recycle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.github.henryye.nativeiv.bitmap.IBitmap
 * JD-Core Version:    0.7.0.1
 */