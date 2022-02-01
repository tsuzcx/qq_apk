package com.tencent.beacon.c.d;

import com.tencent.beacon.e.a;
import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;

public final class d
  extends c
  implements Cloneable
{
  private static byte[] s;
  public String a = "";
  public String b = "";
  public String c = "";
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  public long g = 0L;
  public long h = 0L;
  public String i = "";
  public long j = 0L;
  public String k = "";
  public String l = "";
  public int m = 0;
  public String n = "";
  private String o = "";
  private int p = 0;
  private int q = 0;
  private byte[] r = null;
  
  public final void a(a parama)
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
    this.o = parama.b(9, false);
    this.j = parama.a(this.j, 10, true);
    this.p = parama.a(this.p, 11, false);
    this.q = parama.a(this.q, 12, false);
    if (s == null)
    {
      arrayOfByte = new byte[1];
      s = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = s;
    this.r = parama.c(13, false);
    this.k = parama.b(14, false);
    this.l = parama.b(15, false);
    this.m = parama.a(this.m, 16, false);
    this.n = parama.b(17, false);
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
    if (this.o != null) {
      paramb.a(this.o, 9);
    }
    paramb.a(this.j, 10);
    paramb.a(this.p, 11);
    paramb.a(this.q, 12);
    if (this.r != null) {
      paramb.a(this.r, 13);
    }
    if (this.k != null) {
      paramb.a(this.k, 14);
    }
    if (this.l != null) {
      paramb.a(this.l, 15);
    }
    paramb.a(this.m, 16);
    if (this.n != null) {
      paramb.a(this.n, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.c.d.d
 * JD-Core Version:    0.7.0.1
 */