package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

public abstract interface a
{
  public abstract void a(Bitmap.Config paramConfig);
  
  public abstract void advance();
  
  public abstract void clear();
  
  public abstract ByteBuffer getData();
  
  public abstract int getFrameCount();
  
  public abstract int nZ();
  
  public abstract int oa();
  
  public abstract void ob();
  
  public abstract int oc();
  
  public abstract Bitmap od();
  
  public static abstract interface a
  {
    public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
    
    public abstract byte[] dk(int paramInt);
    
    public abstract int[] dl(int paramInt);
    
    public abstract void f(Bitmap paramBitmap);
    
    public abstract void k(byte[] paramArrayOfByte);
    
    public abstract void o(int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.b.a
 * JD-Core Version:    0.7.0.1
 */