package com.davemorrissey.labs.subscaleview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

public abstract interface d
{
  public abstract Bitmap a(Rect paramRect, int paramInt);
  
  public abstract Point d(Context paramContext, Uri paramUri);
  
  public abstract boolean isReady();
  
  public abstract void recycle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.d
 * JD-Core Version:    0.7.0.1
 */