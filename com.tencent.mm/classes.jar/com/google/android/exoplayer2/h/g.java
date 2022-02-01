package com.google.android.exoplayer2.h;

import android.net.Uri;

public abstract interface g
{
  public abstract long a(j paramj);
  
  public abstract void close();
  
  public abstract Uri getUri();
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static abstract interface a
  {
    public abstract g vi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.g
 * JD-Core Version:    0.7.0.1
 */