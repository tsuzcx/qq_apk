package com.tencent.mm.aw.a.d;

import android.graphics.Bitmap;

public final class b
{
  public Bitmap bitmap;
  public String contentType;
  public byte[] data;
  public int from;
  public int idU = 0;
  public boolean idV = false;
  public boolean idW = false;
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
  
  public final void pJ(int paramInt)
  {
    this.idU = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.d.b
 * JD-Core Version:    0.7.0.1
 */