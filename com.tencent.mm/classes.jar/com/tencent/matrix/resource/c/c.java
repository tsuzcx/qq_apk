package com.tencent.matrix.resource.c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c
{
  private int bPk = 0;
  private final InputStream bPt;
  
  public c(InputStream paramInputStream)
  {
    this.bPt = paramInputStream;
  }
  
  private int a(int paramInt, b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    int i = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    int j = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    int k = this.bPt.read();
    Object localObject = com.tencent.matrix.resource.c.a.c.fP(k);
    if (localObject == null) {
      throw new IllegalStateException("accept primitive array failed, lost type def of typeId: ".concat(String.valueOf(k)));
    }
    int m = j * ((com.tencent.matrix.resource.c.a.c)localObject).getSize(this.bPk);
    localObject = new byte[m];
    com.tencent.matrix.resource.c.b.a.a(this.bPt, (byte[])localObject, m);
    paramb.a(paramInt, localb, i, j, k, (byte[])localObject);
    return this.bPk + 4 + 4 + 1 + m;
  }
  
  private int a(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
    return this.bPk + 4;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    paramd = paramd.b(paramInt1, paramInt2, paramLong);
    long l = paramLong;
    if (paramd == null)
    {
      com.tencent.matrix.resource.c.b.a.c(this.bPt, paramLong);
      return;
      paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
      l = paramLong - this.bPk;
    }
    while (l > 0L)
    {
      paramInt1 = this.bPt.read();
      paramLong = l - 1L;
      switch (paramInt1)
      {
      case 255: 
      default: 
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + paramInt1 + " with " + this.bPt.available() + " bytes possibly remaining");
      case 1: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        com.tencent.matrix.resource.c.b.a.c(this.bPt, this.bPk);
        l = paramLong - (this.bPk << 1);
        break;
      case 2: 
        l = paramLong - b(paramd);
        break;
      case 3: 
        l = paramLong - c(paramd);
        break;
      case 4: 
        l = paramLong - d(paramd);
        break;
      case 5: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
        break;
      case 6: 
        l = paramLong - e(paramd);
        break;
      case 7: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
        break;
      case 8: 
        l = paramLong - f(paramd);
        break;
      case 32: 
        l = paramLong - g(paramd);
        break;
      case 33: 
        l = paramLong - h(paramd);
        break;
      case 34: 
        l = paramLong - i(paramd);
        break;
      case 35: 
        l = paramLong - a(paramInt1, paramd);
        break;
      case 195: 
        l = paramLong - a(paramInt1, paramd);
        break;
      case 254: 
        l = paramLong - a(paramd);
        break;
      case 137: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
        break;
      case 138: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
        break;
      case 139: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
        break;
      case 140: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
        break;
      case 141: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
        break;
      case 142: 
        l = paramLong - j(paramd);
        break;
      case 144: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk));
        l = paramLong - this.bPk;
      }
    }
    paramd.zi();
  }
  
  private void a(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.b(this.bPt, paramLong - this.bPk), paramInt, paramLong);
  }
  
  private int b(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.i(this.bPt));
    return this.bPk + 4 + 4;
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    byte[] arrayOfByte = new byte[(int)paramLong];
    com.tencent.matrix.resource.c.b.a.a(this.bPt, arrayOfByte, paramLong);
    paramd.a(paramInt1, paramInt2, paramLong, arrayOfByte);
  }
  
  private void b(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), paramInt, paramLong);
  }
  
  private void b(d paramd)
  {
    String str = com.tencent.matrix.resource.c.b.a.k(this.bPt);
    int i = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    if ((i <= 0) || (i >= 1073741823)) {
      throw new IOException("bad idSize: ".concat(String.valueOf(i)));
    }
    long l = com.tencent.matrix.resource.c.b.a.j(this.bPt);
    this.bPk = i;
    paramd.a(str, i, l);
  }
  
  private int c(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.i(this.bPt));
    return this.bPk + 4 + 4;
  }
  
  private void c(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.i(this.bPt), paramInt, paramLong);
  }
  
  private void c(d paramd)
  {
    try
    {
      int i = this.bPt.read();
      int j = com.tencent.matrix.resource.c.b.a.i(this.bPt);
      long l = 0xFFFFFFFF & com.tencent.matrix.resource.c.b.a.i(this.bPt);
      switch (i)
      {
      }
      for (;;)
      {
        b(i, j, l, paramd);
        break;
        a(j, l, paramd);
        break;
        b(j, l, paramd);
        break;
        c(j, l, paramd);
        break;
        d(j, l, paramd);
        break;
        a(i, j, l, paramd);
        break;
      }
      return;
    }
    catch (EOFException paramd) {}
  }
  
  private int d(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt));
    return this.bPk + 4;
  }
  
  private void d(int paramInt, long paramLong, d paramd)
  {
    int j = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    int k = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    int m = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    com.tencent.matrix.resource.c.a.b[] arrayOfb = new com.tencent.matrix.resource.c.a.b[m];
    int i = 0;
    while (i < m)
    {
      arrayOfb[i] = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
      i += 1;
    }
    paramd.a(j, k, arrayOfb, paramInt, paramLong);
  }
  
  private int e(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt));
    return this.bPk + 4;
  }
  
  private int f(b paramb)
  {
    paramb.c(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.i(this.bPt));
    return this.bPk + 4 + 4;
  }
  
  private int g(b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb1 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    int k = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    com.tencent.matrix.resource.c.a.b localb2 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    com.tencent.matrix.resource.c.a.b localb3 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    com.tencent.matrix.resource.c.b.a.c(this.bPt, this.bPk << 2);
    int m = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    int i = this.bPk;
    int n = com.tencent.matrix.resource.c.b.a.h(this.bPt);
    int j = 0;
    int i1;
    for (i = i * 7 + 4 + 4 + 2; j < n; i = i1 + 2 + i)
    {
      com.tencent.matrix.resource.c.b.a.c(this.bPt, 2L);
      i1 = zj();
      j += 1;
    }
    n = com.tencent.matrix.resource.c.b.a.h(this.bPt);
    com.tencent.matrix.resource.c.a.a[] arrayOfa = new com.tencent.matrix.resource.c.a.a[n];
    j = 0;
    i += 2;
    Object localObject2;
    while (j < n)
    {
      localObject1 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
      i1 = this.bPt.read();
      localObject2 = com.tencent.matrix.resource.c.a.c.fP(i1);
      if (localObject2 == null) {
        throw new IllegalStateException("accept class failed, lost type def of typeId: ".concat(String.valueOf(i1)));
      }
      arrayOfa[j] = new com.tencent.matrix.resource.c.a.a(i1, (com.tencent.matrix.resource.c.a.b)localObject1, com.tencent.matrix.resource.c.b.a.a(this.bPt, (com.tencent.matrix.resource.c.a.c)localObject2, this.bPk));
      i1 = this.bPk;
      int i2 = ((com.tencent.matrix.resource.c.a.c)localObject2).getSize(this.bPk);
      j += 1;
      i = i1 + 1 + i2 + i;
    }
    n = com.tencent.matrix.resource.c.b.a.h(this.bPt);
    Object localObject1 = new com.tencent.matrix.resource.c.a.a[n];
    j = i + 2;
    i = 0;
    while (i < n)
    {
      localObject2 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
      localObject1[i] = new com.tencent.matrix.resource.c.a.a(this.bPt.read(), (com.tencent.matrix.resource.c.a.b)localObject2, null);
      j += this.bPk + 1;
      i += 1;
    }
    paramb.a(localb1, k, localb2, localb3, m, arrayOfa, (com.tencent.matrix.resource.c.a.a[])localObject1);
    return j;
  }
  
  private int h(b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb1 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    int i = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    com.tencent.matrix.resource.c.a.b localb2 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    int j = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    byte[] arrayOfByte = new byte[j];
    com.tencent.matrix.resource.c.b.a.a(this.bPt, arrayOfByte, j);
    paramb.a(localb1, i, localb2, arrayOfByte);
    return this.bPk + 4 + this.bPk + 4 + j;
  }
  
  private int i(b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb1 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    int i = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    int j = com.tencent.matrix.resource.c.b.a.i(this.bPt);
    com.tencent.matrix.resource.c.a.b localb2 = com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk);
    int k = j * this.bPk;
    byte[] arrayOfByte = new byte[k];
    com.tencent.matrix.resource.c.b.a.a(this.bPt, arrayOfByte, k);
    paramb.a(localb1, i, j, localb2, arrayOfByte);
    return this.bPk + 4 + 4 + this.bPk + k;
  }
  
  private int j(b paramb)
  {
    paramb.d(com.tencent.matrix.resource.c.b.a.a(this.bPt, this.bPk), com.tencent.matrix.resource.c.b.a.i(this.bPt), com.tencent.matrix.resource.c.b.a.i(this.bPt));
    return this.bPk + 4 + 4;
  }
  
  private int zj()
  {
    int i = this.bPt.read();
    com.tencent.matrix.resource.c.a.c localc = com.tencent.matrix.resource.c.a.c.fP(i);
    if (localc == null) {
      throw new IllegalStateException("failure to skip type, cannot find type def of typeid: ".concat(String.valueOf(i)));
    }
    i = localc.getSize(this.bPk);
    com.tencent.matrix.resource.c.b.a.c(this.bPt, i);
    return i + 1;
  }
  
  public final void a(d paramd)
  {
    b(paramd);
    c(paramd);
    paramd.zi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.c.c
 * JD-Core Version:    0.7.0.1
 */