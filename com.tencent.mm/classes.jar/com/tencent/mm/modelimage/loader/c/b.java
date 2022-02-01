package com.tencent.mm.modelimage.loader.c;

import android.graphics.Bitmap;

public final class b
{
  public Bitmap bitmap;
  public String contentType;
  public byte[] data;
  public int from;
  public int oKT = 0;
  public boolean oKU = false;
  public boolean oKV = false;
  public int status;
  
  public b()
  {
    this.status = -1;
  }
  
  public b(Bitmap paramBitmap)
  {
    this.status = 0;
    this.from = 0;
    this.bitmap = paramBitmap;
  }
  
  public b(byte[] paramArrayOfByte, String paramString)
  {
    this.data = paramArrayOfByte;
    this.contentType = paramString;
  }
  
  public b(byte[] paramArrayOfByte, String paramString, byte paramByte)
  {
    this.data = paramArrayOfByte;
    this.from = 2;
    this.contentType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.c.b
 * JD-Core Version:    0.7.0.1
 */