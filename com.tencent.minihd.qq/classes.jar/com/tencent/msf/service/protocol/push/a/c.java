package com.tencent.msf.service.protocol.push.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class c
  extends JceStruct
{
  static ArrayList p;
  static byte[] q;
  static byte[] r;
  public short a = 0;
  public ArrayList b = null;
  public long c = 0L;
  public long d = 0L;
  public byte[] e = null;
  public long f = 0L;
  public byte[] g = null;
  public long h = 0L;
  public long i = 0L;
  public long j = 0L;
  public long k = 0L;
  public long l = 0L;
  public long m = 0L;
  public long n = 0L;
  public short o = 0;
  
  public c() {}
  
  public c(short paramShort1, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, short paramShort2)
  {
    this.a = paramShort1;
    this.b = paramArrayList;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramArrayOfByte1;
    this.f = paramLong3;
    this.g = paramArrayOfByte2;
    this.h = paramLong4;
    this.i = paramLong5;
    this.j = paramLong6;
    this.k = paramLong7;
    this.l = paramLong8;
    this.m = paramLong9;
    this.n = paramLong10;
    this.o = paramShort2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    if (p == null)
    {
      p = new ArrayList();
      a locala = new a();
      p.add(locala);
    }
    this.b = ((ArrayList)paramJceInputStream.read(p, 1, false));
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
    if (q == null)
    {
      q = (byte[])new byte[1];
      ((byte[])q)[0] = 0;
    }
    this.e = ((byte[])paramJceInputStream.read(q, 4, false));
    this.f = paramJceInputStream.read(this.f, 5, false);
    if (r == null)
    {
      r = (byte[])new byte[1];
      ((byte[])r)[0] = 0;
    }
    this.g = ((byte[])paramJceInputStream.read(r, 6, false));
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.read(this.m, 12, false);
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    paramJceOutputStream.write(this.f, 5);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
    paramJceOutputStream.write(this.k, 10);
    paramJceOutputStream.write(this.l, 11);
    paramJceOutputStream.write(this.m, 12);
    paramJceOutputStream.write(this.n, 13);
    paramJceOutputStream.write(this.o, 14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.a.c
 * JD-Core Version:    0.7.0.1
 */