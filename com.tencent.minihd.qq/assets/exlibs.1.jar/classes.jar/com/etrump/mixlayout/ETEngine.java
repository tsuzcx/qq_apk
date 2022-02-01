package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;

public class ETEngine
{
  private static final int ETRUMP_FONT_SIZE_MINIMUM = 24;
  public static final String TAG = "ETEngine";
  private static Canvas mCanvas;
  private static Paint mPaint;
  private static ETEngine sInstance = null;
  private static final int sMemPoolSize = 1048576;
  private final boolean mEnableCallbackDrawing = true;
  private boolean mInitialized = false;
  
  static
  {
    try
    {
      System.loadLibrary("vipfont");
      mPaint = null;
      mCanvas = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ETEngine", 2, localThrowable.getMessage());
        }
      }
    }
  }
  
  public static ETEngine getInstance()
  {
    if (sInstance == null) {
      sInstance = new ETEngine();
    }
    return sInstance;
  }
  
  public static void sysDrawText(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, int paramInt5)
  {
    if (mPaint == null) {
      mPaint = new Paint();
    }
    mPaint.setColor(paramInt2);
    mPaint.setAntiAlias(true);
    mPaint.setDither(true);
    mPaint.setTextSize(paramInt1);
    float f = mPaint.getFontMetrics().ascent;
    if (mCanvas == null) {
      mCanvas = new Canvas();
    }
    mCanvas.setBitmap(paramBitmap);
    mCanvas.drawText(paramString, paramInt4, paramInt5 - f, mPaint);
  }
  
  public static int sysFontHeight(int paramInt1, int paramInt2)
  {
    if (mPaint == null) {
      mPaint = new Paint();
    }
    mPaint.setTextSize(paramInt1);
    Paint.FontMetrics localFontMetrics = mPaint.getFontMetrics();
    return (int)(localFontMetrics.bottom - localFontMetrics.top);
  }
  
  public static int sysMeasureText(String paramString, int paramInt1, int paramInt2)
  {
    if (mPaint == null) {
      mPaint = new Paint();
    }
    mPaint.setTextSize(paramInt1);
    return (int)mPaint.measureText(paramString);
  }
  
  public void initEngine(int paramInt1, int paramInt2)
  {
    if (!native_initEngine(paramInt1, paramInt2, true)) {
      throw new Exception("init engine fail");
    }
  }
  
  public boolean isEnableCallbackDrawing()
  {
    return true;
  }
  
  public native boolean native_containComplexScript(String paramString);
  
  public native void native_doneEngine();
  
  public native boolean native_drawInRect(String paramString, Bitmap paramBitmap, ETFont paramETFont);
  
  public native boolean native_drawText(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont);
  
  public native boolean native_initEngine(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native boolean native_isFontLoaded(int paramInt);
  
  public native boolean native_isPaintableChar(char paramChar, ETFont paramETFont);
  
  public native boolean native_loadFont(String paramString, int paramInt, boolean paramBoolean);
  
  public native boolean native_measure(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Rect paramRect);
  
  public native boolean native_setPersistentFont(ETFont paramETFont);
  
  public native boolean native_textLayoutHasPreLine(int paramInt);
  
  public native int native_textLayoutLineHeight(int paramInt1, int paramInt2);
  
  public native int native_textLayoutLineRangeFrom(int paramInt1, int paramInt2);
  
  public native int native_textLayoutLineRangeTo(int paramInt1, int paramInt2);
  
  public native int native_textLayoutLineTotal(int paramInt);
  
  public native int native_textLayoutLineWidth(int paramInt1, int paramInt2);
  
  public native int native_textLayoutLock(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ETFont paramETFont);
  
  public native void native_textLayoutUnlock(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETEngine
 * JD-Core Version:    0.7.0.1
 */