package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QImage
{
  private int height;
  private long nativeImage;
  private int pixelBytes;
  private int pixelFormat;
  private int width;
  
  public QImage()
  {
    this.width = 0;
    this.height = 0;
    this.nativeImage = 0L;
    this.pixelBytes = 0;
  }
  
  public QImage(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86424);
    CreateImage(paramInt1, paramInt2, 4);
    AppMethodBeat.o(86424);
  }
  
  public static native QImage BindBitmap(Bitmap paramBitmap);
  
  public static native QImage Bitmap2QImage(Bitmap paramBitmap);
  
  public static native byte[] CompressJPEGFromRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int AverageChannels();
  
  public native void CopyExif(QImage paramQImage);
  
  public native void CopyPixels(int[] paramArrayOfInt, int paramInt);
  
  public native void CopyPixelsRGB(int[] paramArrayOfInt, int paramInt);
  
  public native void CreateImage(int paramInt1, int paramInt2, int paramInt3);
  
  public native QImage CreateImageFromQImage();
  
  public native void Dispose();
  
  public native boolean FromBitmap(Bitmap paramBitmap);
  
  public native QImage InplaceBlur8bitQImage(int paramInt1, int paramInt2);
  
  public native void RGB565toRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean ToBitmap(Bitmap paramBitmap);
  
  public native boolean UnBindBitmap(Bitmap paramBitmap);
  
  public native void WrapExif(QImage paramQImage);
  
  public native void YUV420sp2RGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void YUV420sp2YUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void YUV420sp2YUV2(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native void YUV422toRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean alphaMix(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public native QImage createSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native long getByteSize();
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getPixelBytes()
  {
    return this.pixelBytes;
  }
  
  public int getPixelFormat()
  {
    return this.pixelFormat;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public native boolean nativeFlip(int paramInt1, int paramInt2);
  
  public native int[] nativeGetArrayHistogram();
  
  public native int[] nativeGetArrayHistogramChannels();
  
  public native boolean nativeRotate(int paramInt);
  
  public native void nativeUpdateROI();
  
  public native void toGPUTexture(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.QImage
 * JD-Core Version:    0.7.0.1
 */