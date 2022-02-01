package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JpegCompressor
{
  public static final int COLOR_SPACE_GRAY = 3;
  public static final int COLOR_SPACE_RGB = 1;
  public static final int COLOR_SPACE_RGBA = 2;
  static boolean soLoadStatus = false;
  private long nativePtr;
  
  static
  {
    try
    {
      jpegcompressLoadSo();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      soLoadStatus = false;
    }
  }
  
  public JpegCompressor(JpegDataDest paramJpegDataDest)
  {
    try
    {
      this.nativePtr = init(paramJpegDataDest);
      return;
    }
    catch (UnsatisfiedLinkError paramJpegDataDest) {}
  }
  
  private native long compressBitMap(long paramLong, Bitmap paramBitmap, byte[] paramArrayOfByte);
  
  private native long compressByteArray(long paramLong, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2);
  
  private native int compressCb(long paramLong, Bitmap paramBitmap);
  
  public static void compressJpeg(Bitmap paramBitmap, String paramString, JpegCompressOptions paramJpegCompressOptions)
    throws Exception
  {
    JpegCompressor localJpegCompressor = new JpegCompressor(new JpegDataDestImpl(paramString));
    paramString = paramJpegCompressOptions;
    if (paramJpegCompressOptions == null) {
      paramString = JpegCompressOptions.DEFAULT;
    }
    try
    {
      localJpegCompressor.setParams(paramString.CompressQuality, paramString.isOptimize, paramString.isProgress, paramString.isArithCode, paramString.isPreferQualityOverSpeed);
      localJpegCompressor.compress(paramBitmap);
      return;
    }
    finally
    {
      localJpegCompressor.close();
    }
  }
  
  private native void destroy(long paramLong);
  
  private native long init(JpegDataDest paramJpegDataDest);
  
  public static void jpegcompressLoadSo()
  {
    if ((!soLoadStatus) && (JpegSoLoad.LoadJpegExtractedSo("jpegc") == 0))
    {
      int i = Color.argb(255, 0, 1, 2);
      Object localObject = Bitmap.Config.ARGB_8888;
      localObject = Bitmap.createBitmap(new int[] { i }, 1, 1, (Bitmap.Config)localObject);
      if (localObject != null) {
        predictPixelStorage((Bitmap)localObject);
      }
      soLoadStatus = true;
    }
  }
  
  private static native void predictPixelStorage(Bitmap paramBitmap);
  
  private native void setParams(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
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
  
  public int compress(Bitmap paramBitmap, byte[] paramArrayOfByte)
    throws Exception
  {
    if (!soLoadStatus) {
      JpegError.throwException(50);
    }
    long l1 = 0L;
    try
    {
      long l2 = compressBitMap(this.nativePtr, paramBitmap, paramArrayOfByte);
      l1 = l2;
      i = (int)(l1 & 0xFFFFFFFF);
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      for (;;)
      {
        int i = 52;
      }
    }
    if (i != 0) {
      JpegError.throwException(i);
    }
    return (int)(l1 >> 32 & 0xFFFFFFFF);
  }
  
  public int compress(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
    throws Exception
  {
    if (!soLoadStatus) {
      JpegError.throwException(50);
    }
    int i = 3;
    switch (paramInt3)
    {
    }
    for (;;)
    {
      if (paramInt1 * paramInt2 * i > paramArrayOfByte1.length) {
        JpegError.throwException(4);
      }
      long l1 = 0L;
      try
      {
        long l2 = compressByteArray(this.nativePtr, paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2);
        l1 = l2;
        paramInt1 = (int)(0xFFFFFFFF & l1);
      }
      catch (UnsatisfiedLinkError paramArrayOfByte1)
      {
        for (;;)
        {
          paramInt1 = 52;
        }
      }
      if (paramInt1 != 0) {
        JpegError.throwException(paramInt1);
      }
      return (int)(l1 >> 32 & 0xFFFFFFFF);
      i = 4;
      continue;
      i = 1;
    }
  }
  
  public void compress(Bitmap paramBitmap)
    throws Exception
  {
    if (!soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = compressCb(this.nativePtr, paramBitmap);
      if (i != 0) {
        JpegError.throwException(i);
      }
      return;
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      for (;;)
      {
        int i = 52;
      }
    }
  }
  
  public int computeOutSize(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null) {
      i = paramBitmap.getHeight() * paramBitmap.getRowBytes() + 2048;
    }
    return i;
  }
  
  public void finalize()
    throws Throwable
  {
    try
    {
      close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void setParams(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      setParams(this.nativePtr, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void setParams(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      setParams(this.nativePtr, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private static class JpegDataDestImpl
    implements JpegDataDest
  {
    private FileOutputStream writer = null;
    
    public JpegDataDestImpl(String paramString)
    {
      paramString = new File(paramString);
      try
      {
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString.createNewFile();
        this.writer = new FileOutputStream(paramString);
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public void dataArrived(ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject)
    {
      try
      {
        paramObject = new byte[paramByteBuffer.capacity()];
        paramByteBuffer.get(paramObject);
        this.writer.write(paramObject, 0, paramObject.length);
        if (!paramBoolean) {}
      }
      catch (Exception paramByteBuffer)
      {
        for (;;)
        {
          try
          {
            this.writer.close();
            return;
          }
          catch (IOException paramByteBuffer)
          {
            paramByteBuffer.printStackTrace();
          }
          paramByteBuffer = paramByteBuffer;
          paramByteBuffer.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegCompressor
 * JD-Core Version:    0.7.0.1
 */