package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

public final class JpegDecompressor
{
  private boolean idRgb = true;
  public int imageHeight = 0;
  public int imageWidth = 0;
  private int insample = 0;
  private long nativePtr;
  public int outHeight = 0;
  public int outWidth = 0;
  
  static
  {
    try
    {
      if ((!JpegCompressor.soLoadStatus) && (JpegSoLoad.LoadJpegExtractedSo("jpegc") == 0)) {
        JpegCompressor.soLoadStatus = true;
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      JpegCompressor.soLoadStatus = false;
    }
  }
  
  public JpegDecompressor()
  {
    try
    {
      this.nativePtr = init();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private void computeOutWidthHeight()
  {
    computeOutWidthHeight(new Rect(0, 0, this.imageWidth, this.imageHeight));
  }
  
  private void computeOutWidthHeight(Rect paramRect)
  {
    int i = paramRect.right;
    int j = paramRect.left;
    int k = paramRect.bottom;
    int m = paramRect.top;
    if (this.insample <= 0) {
      this.insample = 1;
    }
    this.outWidth = ((this.insample + (i - j) - 1) / this.insample);
    this.outHeight = ((this.insample + (k - m) - 1) / this.insample);
  }
  
  /* Error */
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, JpegOptions paramJpegOptions)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: astore_2
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: getstatic 87	com/tencent/mobileqq/pic/JpegOptions:DEFAULT	Lcom/tencent/mobileqq/pic/JpegOptions;
    //   11: astore_2
    //   12: new 2	com/tencent/mobileqq/pic/JpegDecompressor
    //   15: dup
    //   16: invokespecial 88	com/tencent/mobileqq/pic/JpegDecompressor:<init>	()V
    //   19: astore_1
    //   20: aload_2
    //   21: getfield 91	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   24: ifeq +37 -> 61
    //   27: aload_1
    //   28: aload_0
    //   29: aload_2
    //   30: getfield 95	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   33: invokevirtual 99	com/tencent/mobileqq/pic/JpegDecompressor:computeOutSize	([BLandroid/graphics/Bitmap$Config;)I
    //   36: pop
    //   37: aload_2
    //   38: aload_1
    //   39: getfield 42	com/tencent/mobileqq/pic/JpegDecompressor:imageHeight	I
    //   42: putfield 100	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   45: aload_2
    //   46: aload_1
    //   47: getfield 40	com/tencent/mobileqq/pic/JpegDecompressor:imageWidth	I
    //   50: putfield 101	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   53: aload_3
    //   54: astore_0
    //   55: aload_1
    //   56: invokevirtual 104	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: aload_1
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 107	com/tencent/mobileqq/pic/JpegDecompressor:createBitmap	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   67: astore_0
    //   68: goto -13 -> 55
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 104	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramArrayOfByte	byte[]
    //   0	78	1	paramJpegOptions	JpegOptions
    //   3	61	2	localJpegOptions	JpegOptions
    //   1	53	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	53	71	finally
    //   61	68	71	finally
  }
  
  /* Error */
  public static Bitmap decodeFile(String paramString, JpegOptions paramJpegOptions)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: astore_2
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: getstatic 87	com/tencent/mobileqq/pic/JpegOptions:DEFAULT	Lcom/tencent/mobileqq/pic/JpegOptions;
    //   11: astore_2
    //   12: new 2	com/tencent/mobileqq/pic/JpegDecompressor
    //   15: dup
    //   16: invokespecial 88	com/tencent/mobileqq/pic/JpegDecompressor:<init>	()V
    //   19: astore_1
    //   20: aload_2
    //   21: getfield 91	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   24: ifeq +37 -> 61
    //   27: aload_1
    //   28: aload_0
    //   29: aload_2
    //   30: getfield 95	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   33: invokevirtual 113	com/tencent/mobileqq/pic/JpegDecompressor:computeOutSize	(Ljava/lang/String;Landroid/graphics/Bitmap$Config;)I
    //   36: pop
    //   37: aload_2
    //   38: aload_1
    //   39: getfield 42	com/tencent/mobileqq/pic/JpegDecompressor:imageHeight	I
    //   42: putfield 100	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   45: aload_2
    //   46: aload_1
    //   47: getfield 40	com/tencent/mobileqq/pic/JpegDecompressor:imageWidth	I
    //   50: putfield 101	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   53: aload_3
    //   54: astore_0
    //   55: aload_1
    //   56: invokevirtual 104	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: aload_1
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 115	com/tencent/mobileqq/pic/JpegDecompressor:createBitmap	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   67: astore_0
    //   68: goto -13 -> 55
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 104	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramString	String
    //   0	78	1	paramJpegOptions	JpegOptions
    //   3	61	2	localJpegOptions	JpegOptions
    //   1	53	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	53	71	finally
    //   61	68	71	finally
  }
  
  private native long decompress(long paramLong, byte[] paramArrayOfByte);
  
  private native long decompressBitmap(long paramLong, Bitmap paramBitmap);
  
  private native int decompressFileHeader(long paramLong, String paramString);
  
  private native int decompressHeader(long paramLong, byte[] paramArrayOfByte);
  
  private native long decompressRegion(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native long decompressRegionBitmap(long paramLong, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native int decompressRegionFileHeader(long paramLong, String paramString);
  
  private native int decompressRegionHeader(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void destroy(long paramLong);
  
  private int getPixelSize(Bitmap.Config paramConfig)
  {
    if (this.idRgb) {}
    for (int i = 3; paramConfig == null; i = 1) {
      return i;
    }
    if (Bitmap.Config.ARGB_8888 == paramConfig) {
      i = 4;
    }
    for (;;)
    {
      return i;
      if (Bitmap.Config.RGB_565 == paramConfig) {
        i = 2;
      } else if (Bitmap.Config.ALPHA_8 == paramConfig) {
        i = 1;
      }
    }
  }
  
  private Bitmap getReuseBitmap(Bitmap.Config paramConfig, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (paramBitmap.getWidth() == this.outWidth) && (paramBitmap.getHeight() == this.outHeight) && (paramBitmap.getConfig() == paramConfig)) {
      return paramBitmap;
    }
    return Bitmap.createBitmap(this.outWidth, this.outHeight, paramConfig);
  }
  
  private native long init();
  
  private native void setParams(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public void close()
  {
    try
    {
      if (this.nativePtr != 0L)
      {
        destroy(this.nativePtr);
        this.nativePtr = 0L;
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public int computeOutSize(String paramString, Bitmap.Config paramConfig)
    throws Exception
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = decompressFileHeader(this.nativePtr, paramString);
      if (i != 0) {
        JpegError.throwException(i);
      }
      computeOutWidthHeight();
      return this.outWidth * this.outHeight * getPixelSize(paramConfig);
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        int i = 52;
      }
    }
  }
  
  public int computeOutSize(byte[] paramArrayOfByte, Bitmap.Config paramConfig)
    throws Exception
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = decompressHeader(this.nativePtr, paramArrayOfByte);
      if (i != 0) {
        JpegError.throwException(i);
      }
      computeOutWidthHeight();
      return this.outWidth * this.outHeight * getPixelSize(paramConfig);
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      for (;;)
      {
        int i = 52;
      }
    }
  }
  
  public Bitmap createBitmap(String paramString, JpegOptions paramJpegOptions)
    throws Exception
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    setParams(true, paramJpegOptions.inSampleSize, paramJpegOptions.inPreferQualityOverSpeed);
    computeOutSize(paramString, paramJpegOptions.inPreferredConfig);
    return getBitmap(paramJpegOptions.inPreferredConfig, paramJpegOptions.inBitmap);
  }
  
  public Bitmap createBitmap(byte[] paramArrayOfByte, JpegOptions paramJpegOptions)
    throws Exception
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    setParams(true, paramJpegOptions.inSampleSize, paramJpegOptions.inPreferQualityOverSpeed);
    computeOutSize(paramArrayOfByte, paramJpegOptions.inPreferredConfig);
    return getBitmap(paramJpegOptions.inPreferredConfig, paramJpegOptions.inBitmap);
  }
  
  public int decompress(byte[] paramArrayOfByte)
    throws Exception
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    int j = 0;
    try
    {
      long l = decompress(this.nativePtr, paramArrayOfByte);
      i = (int)(l & 0xFFFFFFFF);
      j = (int)(l >> 32 & 0xFFFFFFFF);
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      for (;;)
      {
        int i = 52;
      }
    }
    if (i != 0) {
      JpegError.throwException(i);
    }
    return j;
  }
  
  void decompressRegion(byte[] paramArrayOfByte, Rect paramRect)
  {
    try
    {
      long l = decompressRegion(this.nativePtr, paramArrayOfByte, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
      i = (int)(0xFFFFFFFF & l);
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      for (;;)
      {
        int i = 52;
      }
    }
    if (i != 0) {
      JpegError.throwException(i);
    }
  }
  
  int decompressRegionBitmap(Bitmap paramBitmap, Rect paramRect)
  {
    try
    {
      long l = decompressRegionBitmap(this.nativePtr, paramBitmap, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
      return (int)(0xFFFFFFFF & l);
    }
    catch (UnsatisfiedLinkError paramBitmap) {}
    return 52;
  }
  
  void decompressRegionFileHeader(String paramString)
  {
    try
    {
      i = decompressRegionFileHeader(this.nativePtr, paramString);
      if (i != 0) {
        JpegError.throwException(i);
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        int i = 52;
      }
    }
  }
  
  void decompressRegionHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = decompressRegionHeader(this.nativePtr, paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != 0) {
        JpegError.throwException(paramInt1);
      }
      return;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      for (;;)
      {
        paramInt1 = 52;
      }
    }
  }
  
  Bitmap getBitmap(Bitmap.Config paramConfig, Bitmap paramBitmap)
  {
    paramBitmap = getReuseBitmap(paramConfig, paramBitmap);
    try
    {
      long l = decompressBitmap(this.nativePtr, paramBitmap);
      i = (int)(0xFFFFFFFF & l);
    }
    catch (UnsatisfiedLinkError paramConfig)
    {
      for (;;)
      {
        int i = 52;
      }
    }
    paramConfig = paramBitmap;
    if (i != 0)
    {
      paramBitmap.recycle();
      paramConfig = null;
      JpegError.throwException(i);
    }
    return paramConfig;
  }
  
  Bitmap getRegionBitmap(Rect paramRect, Bitmap.Config paramConfig, Bitmap paramBitmap)
  {
    computeOutWidthHeight(paramRect);
    paramConfig = getReuseBitmap(paramConfig, paramBitmap);
    int i = decompressRegionBitmap(paramConfig, paramRect);
    paramRect = paramConfig;
    if (i != 0)
    {
      paramConfig.recycle();
      paramRect = null;
      JpegError.throwException(i);
    }
    return paramRect;
  }
  
  public void setParams(boolean paramBoolean)
  {
    try
    {
      setParams(this.nativePtr, paramBoolean, 0, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void setParams(boolean paramBoolean, int paramInt)
  {
    try
    {
      setParams(this.nativePtr, paramBoolean, paramInt, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void setParams(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    try
    {
      this.insample = paramInt;
      setParams(this.nativePtr, paramBoolean1, paramInt, paramBoolean2);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegDecompressor
 * JD-Core Version:    0.7.0.1
 */