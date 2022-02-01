package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;

public abstract interface h
{
  public abstract Bitmap getBitmap();
  
  public abstract SurfaceTexture getSurfaceTexture();
  
  public abstract void setImageBitmap(Bitmap paramBitmap);
  
  public abstract void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.h
 * JD-Core Version:    0.7.0.1
 */