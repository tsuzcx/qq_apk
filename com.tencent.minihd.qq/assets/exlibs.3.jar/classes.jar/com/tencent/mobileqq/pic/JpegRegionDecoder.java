package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Rect;

public final class JpegRegionDecoder
{
  private JpegDecompressor decoder;
  private boolean mRecycled = false;
  
  private JpegRegionDecoder(JpegDecompressor paramJpegDecompressor)
  {
    this.decoder = paramJpegDecompressor;
  }
  
  private void checkRecycled(String paramString)
  {
    if (this.mRecycled) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static JpegRegionDecoder newInstance(String paramString)
  {
    JpegDecompressor localJpegDecompressor = new JpegDecompressor();
    try
    {
      localJpegDecompressor.decompressRegionFileHeader(paramString);
      paramString = new JpegRegionDecoder(localJpegDecompressor);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      localJpegDecompressor.close();
    }
    return null;
  }
  
  public static JpegRegionDecoder newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    JpegDecompressor localJpegDecompressor = new JpegDecompressor();
    try
    {
      localJpegDecompressor.decompressRegionHeader(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new JpegRegionDecoder(localJpegDecompressor);
      return paramArrayOfByte;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      localJpegDecompressor.close();
    }
    return null;
  }
  
  public Bitmap decodeRegion(Rect paramRect, JpegOptions paramJpegOptions)
  {
    checkRecycled("JpegRegionDecoder[Decoder has already been recycled]");
    if ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.right > getWidth()) || (paramRect.bottom > getHeight())) {
      throw new IllegalArgumentException("JpegRegionDecoder[rectangle is not inside the image]");
    }
    if (paramJpegOptions.inJustDecodeBounds)
    {
      paramJpegOptions.outHeight = this.decoder.imageHeight;
      paramJpegOptions.outWidth = this.decoder.imageWidth;
      return null;
    }
    this.decoder.setParams(true, paramJpegOptions.inSampleSize, paramJpegOptions.inPreferQualityOverSpeed);
    return this.decoder.getRegionBitmap(paramRect, paramJpegOptions.inPreferredConfig, paramJpegOptions.inBitmap);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      recycle();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getHeight()
  {
    checkRecycled("JpegRegionDecoder[Decoder has already been recycled]");
    return this.decoder.imageHeight;
  }
  
  public int getWidth()
  {
    checkRecycled("JpegRegionDecoder[Decoder has already been recycled]");
    return this.decoder.imageWidth;
  }
  
  public final boolean isRecycled()
  {
    return this.mRecycled;
  }
  
  public void recycle()
  {
    if (!this.mRecycled)
    {
      this.decoder.close();
      this.mRecycled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegRegionDecoder
 * JD-Core Version:    0.7.0.1
 */