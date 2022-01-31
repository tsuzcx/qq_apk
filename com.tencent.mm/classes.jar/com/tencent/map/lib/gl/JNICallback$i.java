package com.tencent.map.lib.gl;

import com.tencent.tencentmap.mapsdk.a.la;
import java.util.Arrays;

public class JNICallback$i
{
  public float a;
  public int b;
  public int c;
  public int d;
  public boolean e;
  byte[] f = new byte[4];
  
  public void a(byte[] paramArrayOfByte)
  {
    Arrays.fill(this.f, (byte)0);
    System.arraycopy(paramArrayOfByte, 0, this.f, 0, 4);
    this.a = la.c(this.f);
    System.arraycopy(paramArrayOfByte, 4, this.f, 0, 4);
    this.b = la.a(this.f);
    System.arraycopy(paramArrayOfByte, 8, this.f, 0, 4);
    this.c = la.a(this.f);
    System.arraycopy(paramArrayOfByte, 12, this.f, 0, 4);
    this.d = la.a(this.f);
    System.arraycopy(paramArrayOfByte, 16, this.f, 0, 1);
    this.e = la.b(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.lib.gl.JNICallback.i
 * JD-Core Version:    0.7.0.1
 */