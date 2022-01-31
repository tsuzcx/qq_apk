package com.tencent.magicbrush.engine;

import android.os.Environment;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import java.io.File;

public final class d
{
  public static String bkF = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static String bkG = "/tencent/MicroMsg/AppBrandGame";
  public static String bkH = bkF + bkG;
  
  public static void a(String paramString, IBitmap<NativeBitmapStruct> paramIBitmap)
  {
    MBNativeHandlerJNI.nativeOnImageDecoded(paramString, paramIBitmap);
  }
  
  public static MBCanvasContentHolder ec(int paramInt)
  {
    return MBNativeHandlerJNI.nativeCaptureCanvasSnapshot(paramInt);
  }
  
  public static MBCanvasContentHolder qJ()
  {
    return MBNativeHandlerJNI.nativeCaptureScreenshot();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.engine.d
 * JD-Core Version:    0.7.0.1
 */