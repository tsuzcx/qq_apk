package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;

public abstract interface b
{
  public abstract Bitmap getBitmap(int paramInt1, int paramInt2);
  
  public abstract void init();
  
  public abstract void loadBitmapAsync(String paramString);
  
  public abstract IBitmap<NativeBitmapStruct> loadBitmapSync(String paramString);
  
  public abstract void release();
  
  public abstract void releaseBitmap(Bitmap paramBitmap);
  
  public abstract String toDataURL(Bitmap paramBitmap, String paramString, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.b
 * JD-Core Version:    0.7.0.1
 */