package com.tencent.magicbrush.handler;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.magicbrush.handler.image.b;

public class MBImageHandlerJNI
{
  private static b sProxy;
  
  @Keep
  public static Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    if (sProxy == null) {
      throw new IllegalStateException("ImageHandler not impl");
    }
    return sProxy.getBitmap(paramInt1, paramInt2);
  }
  
  @Keep
  public static void init()
  {
    sProxy.init();
  }
  
  @Keep
  public static void loadBitmapAsync(String paramString)
  {
    if (sProxy == null) {
      throw new IllegalStateException("ImageHandler not impl");
    }
    sProxy.loadBitmapAsync(paramString);
  }
  
  @Keep
  public static IBitmap<NativeBitmapStruct> loadBitmapSync(String paramString)
  {
    if (sProxy == null) {
      throw new IllegalStateException("ImageHandler not impl");
    }
    return sProxy.loadBitmapSync(paramString);
  }
  
  public static void register(b paramb)
  {
    sProxy = paramb;
  }
  
  @Keep
  public static void release()
  {
    sProxy.release();
  }
  
  @Keep
  public static void releaseBitmap(Bitmap paramBitmap)
  {
    if (sProxy == null) {
      throw new IllegalStateException("ImageHandler not impl");
    }
    sProxy.releaseBitmap(paramBitmap);
  }
  
  @Keep
  public static String toDataURL(Bitmap paramBitmap, String paramString, float paramFloat)
  {
    if (sProxy == null) {
      throw new IllegalStateException("ImageHandler not impl");
    }
    return sProxy.toDataURL(paramBitmap, paramString, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MBImageHandlerJNI
 * JD-Core Version:    0.7.0.1
 */