package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class k
  extends JceStruct
{
  static byte[] k;
  static byte[] l;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public String d = "";
  public int e = 0;
  public int f = 0;
  public byte[] g = null;
  public byte[] h = null;
  public int i = 0;
  public int j = 0;
  
  public k() {}
  
  public k(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt6, int paramInt7)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramString;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramArrayOfByte1;
    this.h = paramArrayOfByte2;
    this.i = paramInt6;
    this.j = paramInt7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.readString(3, true);
    this.e = paramJceInputStream.read(this.e, 4, true);
    this.f = paramJceInputStream.read(this.f, 5, true);
    if (k == null)
    {
      k = (byte[])new byte[1];
      ((byte[])k)[0] = 0;
    }
    this.g = ((byte[])paramJceInputStream.read(k, 6, true));
    if (l == null)
    {
      l = (byte[])new byte[1];
      ((byte[])l)[0] = 0;
    }
    this.h = ((byte[])paramJceInputStream.read(l, 7, true));
    this.i = paramJceInputStream.read(this.i, 8, true);
    this.j = paramJceInputStream.read(this.j, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.k
 * JD-Core Version:    0.7.0.1
 */