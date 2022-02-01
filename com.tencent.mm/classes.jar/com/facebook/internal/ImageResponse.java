package com.facebook.internal;

import android.graphics.Bitmap;

public class ImageResponse
{
  private Bitmap bitmap;
  private Exception error;
  private boolean isCachedRedirect;
  private ImageRequest request;
  
  ImageResponse(ImageRequest paramImageRequest, Exception paramException, boolean paramBoolean, Bitmap paramBitmap)
  {
    this.request = paramImageRequest;
    this.error = paramException;
    this.bitmap = paramBitmap;
    this.isCachedRedirect = paramBoolean;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public Exception getError()
  {
    return this.error;
  }
  
  public ImageRequest getRequest()
  {
    return this.request;
  }
  
  public boolean isCachedRedirect()
  {
    return this.isCachedRedirect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.ImageResponse
 * JD-Core Version:    0.7.0.1
 */