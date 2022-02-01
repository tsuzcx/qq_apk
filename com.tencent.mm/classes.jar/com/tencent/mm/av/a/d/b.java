package com.tencent.mm.av.a.d;

import android.graphics.Bitmap;

public final class b
{
  public Bitmap bitmap;
  public String contentType;
  public byte[] data;
  public int from;
  public int jbH = 0;
  public boolean jbI = false;
  public boolean jbJ = false;
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
  
  public final void tA(int paramInt)
  {
    this.jbH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.d.b
 * JD-Core Version:    0.7.0.1
 */