package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;

class MBNativeHandlerJNI
{
  static {}
  
  @Keep
  static native MBCanvasContentHolder nativeCaptureCanvasSnapshot(int paramInt);
  
  @Keep
  static native MBCanvasContentHolder nativeCaptureScreenshot();
  
  @Keep
  static native void nativeOnImageDecoded(String paramString, IBitmap<NativeBitmapStruct> paramIBitmap);
  
  @Keep
  static native void nativeSetSDCardPath(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  @Keep
  static native void nativeSetSecureCanvasModeEnable(boolean paramBoolean);
  
  @Keep
  static native void nativeSetV8Debug(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.engine.MBNativeHandlerJNI
 * JD-Core Version:    0.7.0.1
 */