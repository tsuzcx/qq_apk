package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

public abstract interface ImageRegionDecoder
{
  public abstract Bitmap decodeRegion(Rect paramRect, int paramInt);
  
  public abstract Point init(Context paramContext, Uri paramUri);
  
  public abstract boolean isReady();
  
  public abstract void recycle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
 * JD-Core Version:    0.7.0.1
 */