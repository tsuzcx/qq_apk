package com.tencent.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class VideoPngDecoder
{
  private static final String TAG = VideoPngDecoder.class.getSimpleName();
  private long bcj;
  private int[] bck;
  private char[] bcl;
  private int bcm;
  private Bitmap bitmap;
  private int height;
  private int width;
  
  static
  {
    System.loadLibrary("getframe");
  }
  
  public VideoPngDecoder(String paramString)
  {
    int[] arrayOfInt = new int[2];
    this.bcj = initDecoder(paramString, arrayOfInt);
    this.width = arrayOfInt[0];
    this.height = (arrayOfInt[1] / 2);
    this.bck = new int[this.width * this.height];
    this.bcl = new char[this.width * this.height * 2 * 3];
    new StringBuilder("init video rgba decoder: width =  ").append(this.width).append(", height = ").append(this.height);
  }
  
  public static native int getNextArgbFrame(long paramLong, int[] paramArrayOfInt);
  
  public static native int getNextRgbFrame(long paramLong, char[] paramArrayOfChar);
  
  public static native long initDecoder(String paramString, int[] paramArrayOfInt);
  
  public static native int releaseDecoder(long paramLong);
  
  public final Bitmap dZ(int paramInt)
  {
    Bitmap localBitmap2 = null;
    this.bcm = getNextArgbFrame(this.bcj, this.bck);
    Bitmap localBitmap1 = localBitmap2;
    try
    {
      Bitmap localBitmap3 = Bitmap.createBitmap(this.bck, this.width, this.height, Bitmap.Config.ARGB_8888);
      localBitmap1 = localBitmap2;
      localBitmap2 = Bitmap.createScaledBitmap(localBitmap3, this.width / paramInt, this.height / paramInt, true);
      if (localBitmap2 != localBitmap3)
      {
        localBitmap1 = localBitmap2;
        localBitmap3.recycle();
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return localBitmap1;
  }
  
  public final boolean pG()
  {
    return this.bcm != 0;
  }
  
  public final void release()
  {
    releaseDecoder(this.bcj);
  }
  
  public final int w(List<String> paramList)
  {
    int i = getNextArgbFrame(this.bcj, this.bck);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      try
      {
        this.bitmap = Bitmap.createBitmap(this.bck, this.width, this.height, Bitmap.Config.ARGB_8888);
        localObject = new FileOutputStream((String)localObject);
        this.bitmap.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)localObject);
        this.bitmap.recycle();
        ((OutputStream)localObject).close();
      }
      catch (Exception localException) {}
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.common.VideoPngDecoder
 * JD-Core Version:    0.7.0.1
 */