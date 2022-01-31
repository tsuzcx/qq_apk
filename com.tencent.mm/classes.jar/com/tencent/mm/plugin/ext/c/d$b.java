package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;

public final class d$b
{
  int apf;
  int apg;
  public String bIW;
  byte[] bXE;
  Rect jLf;
  int rotate;
  
  public d$b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect, String paramString)
  {
    this.bXE = paramArrayOfByte;
    this.apf = paramInt1;
    this.apg = paramInt2;
    this.rotate = paramInt3;
    this.jLf = paramRect;
    this.bIW = paramString;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RetrieveResult{yuvDataLength=");
    if (this.bXE != null) {}
    for (Object localObject = Integer.valueOf(this.bXE.length);; localObject = "null") {
      return localObject + ", previewWidth=" + this.apf + ", previewHeight=" + this.apg + ", rotate=" + this.rotate + ", scanRect=" + this.jLf + ", md5=" + this.bIW + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.d.b
 * JD-Core Version:    0.7.0.1
 */