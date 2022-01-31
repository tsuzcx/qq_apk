package com.tencent.mm.at.a.d;

import android.graphics.Bitmap;

public final class b
{
  public String aZn;
  public Bitmap bitmap;
  public byte[] data;
  public boolean fHC = false;
  public boolean fHD = false;
  public int from;
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
    this.aZn = paramString;
  }
  
  public b(byte[] paramArrayOfByte, String paramString, byte paramByte)
  {
    this.data = paramArrayOfByte;
    this.from = 2;
    this.aZn = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.at.a.d.b
 * JD-Core Version:    0.7.0.1
 */