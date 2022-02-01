package com.tencent.beacon.c.d;

import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;

public final class a
  extends c
  implements Cloneable
{
  private static byte[] p;
  public String a = "";
  public String b = "";
  public String c = "";
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  public long g = 0L;
  public long h = 0L;
  public String i = "";
  public String j = "";
  public long k = 0L;
  public String l = "";
  private int m = 0;
  private int n = 0;
  private byte[] o = null;
  
  public final void a(com.tencent.beacon.e.a parama)
  {
    this.a = parama.b(0, true);
    this.b = parama.b(1, true);
    this.c = parama.b(2, true);
    this.d = parama.a(this.d, 3, true);
    this.e = parama.a(this.e, 4, true);
    this.f = parama.a(this.f, 5, true);
    this.g = parama.a(this.g, 6, true);
    this.h = parama.a(this.h, 7, true);
    this.i = parama.b(8, false);
    this.j = parama.b(9, false);
    this.k = parama.a(this.k, 10, true);
    this.m = parama.a(this.m, 11, false);
    this.n = parama.a(this.n, 12, false);
    if (p == null)
    {
      arrayOfByte = new byte[1];
      p = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = p;
    this.o = parama.c(13, false);
    this.l = parama.b(14, false);
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
    paramb.a(this.e, 4);
    paramb.a(this.f, 5);
    paramb.a(this.g, 6);
    paramb.a(this.h, 7);
    if (this.i != null) {
      paramb.a(this.i, 8);
    }
    if (this.j != null) {
      paramb.a(this.j, 9);
    }
    paramb.a(this.k, 10);
    paramb.a(this.m, 11);
    paramb.a(this.n, 12);
    if (this.o != null) {
      paramb.a(this.o, 13);
    }
    if (this.l != null) {
      paramb.a(this.l, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.c.d.a
 * JD-Core Version:    0.7.0.1
 */