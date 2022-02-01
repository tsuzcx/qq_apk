package com.tencent.matrix.resource.d;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c
{
  private int ckw = 0;
  private final InputStream ddp;
  
  public c(InputStream paramInputStream)
  {
    this.ddp = paramInputStream;
  }
  
  private int XK()
  {
    int i = this.ddp.read();
    com.tencent.matrix.resource.d.a.c localc = com.tencent.matrix.resource.d.a.c.jF(i);
    if (localc == null) {
      throw new IllegalStateException("failure to skip type, cannot find type def of typeid: ".concat(String.valueOf(i)));
    }
    i = localc.jG(this.ckw);
    com.tencent.matrix.resource.d.b.a.b(this.ddp, i);
    return i + 1;
  }
  
  private int a(int paramInt, b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    int i = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    int j = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    int k = this.ddp.read();
    Object localObject = com.tencent.matrix.resource.d.a.c.jF(k);
    if (localObject == null) {
      throw new IllegalStateException("accept primitive array failed, lost type def of typeId: ".concat(String.valueOf(k)));
    }
    int m = j * ((com.tencent.matrix.resource.d.a.c)localObject).jG(this.ckw);
    localObject = new byte[m];
    com.tencent.matrix.resource.d.b.a.a(this.ddp, (byte[])localObject, m);
    paramb.a(paramInt, localb, i, j, k, (byte[])localObject);
    return this.ckw + 4 + 4 + 1 + m;
  }
  
  private int a(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
    return this.ckw + 4;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    paramd = paramd.b(paramInt1, paramInt2, paramLong);
    long l = paramLong;
    if (paramd == null)
    {
      com.tencent.matrix.resource.d.b.a.b(this.ddp, paramLong);
      return;
      paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
      l = paramLong - this.ckw;
    }
    while (l > 0L)
    {
      paramInt1 = this.ddp.read();
      paramLong = l - 1L;
      switch (paramInt1)
      {
      case 255: 
      default: 
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + paramInt1 + " with " + this.ddp.available() + " bytes possibly remaining");
      case 1: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        com.tencent.matrix.resource.d.b.a.b(this.ddp, this.ckw);
        l = paramLong - (this.ckw << 1);
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
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
        break;
      case 6: 
        l = paramLong - e(paramd);
        break;
      case 7: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
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
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
        break;
      case 138: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
        break;
      case 139: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
        break;
      case 140: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
        break;
      case 141: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
        break;
      case 142: 
        l = paramLong - j(paramd);
        break;
      case 144: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw));
        l = paramLong - this.ckw;
      }
    }
    paramd.XJ();
  }
  
  private void a(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.a(this.ddp, paramLong - this.ckw), paramInt, paramLong);
  }
  
  private int b(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.m(this.ddp));
    return this.ckw + 4 + 4;
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    byte[] arrayOfByte = new byte[(int)paramLong];
    com.tencent.matrix.resource.d.b.a.a(this.ddp, arrayOfByte, paramLong);
    paramd.a(paramInt1, paramInt2, paramLong, arrayOfByte);
  }
  
  private void b(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), paramInt, paramLong);
  }
  
  private void b(d paramd)
  {
    String str = com.tencent.matrix.resource.d.b.a.o(this.ddp);
    int i = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    if ((i <= 0) || (i >= 1073741823)) {
      throw new IOException("bad idSize: ".concat(String.valueOf(i)));
    }
    long l = com.tencent.matrix.resource.d.b.a.n(this.ddp);
    this.ckw = i;
    paramd.a(str, i, l);
  }
  
  private int c(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.m(this.ddp));
    return this.ckw + 4 + 4;
  }
  
  private void c(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.m(this.ddp), paramInt, paramLong);
  }
  
  private void c(d paramd)
  {
    try
    {
      int i = this.ddp.read();
      int j = com.tencent.matrix.resource.d.b.a.m(this.ddp);
      long l = 0xFFFFFFFF & com.tencent.matrix.resource.d.b.a.m(this.ddp);
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
    paramb.a(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp));
    return this.ckw + 4;
  }
  
  private void d(int paramInt, long paramLong, d paramd)
  {
    int j = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    int k = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    int m = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    com.tencent.matrix.resource.d.a.b[] arrayOfb = new com.tencent.matrix.resource.d.a.b[m];
    int i = 0;
    while (i < m)
    {
      arrayOfb[i] = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
      i += 1;
    }
    paramd.a(j, k, arrayOfb, paramInt, paramLong);
  }
  
  private int e(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp));
    return this.ckw + 4;
  }
  
  private int f(b paramb)
  {
    paramb.c(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.m(this.ddp));
    return this.ckw + 4 + 4;
  }
  
  private int g(b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb1 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    int k = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    com.tencent.matrix.resource.d.a.b localb2 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    com.tencent.matrix.resource.d.a.b localb3 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    com.tencent.matrix.resource.d.b.a.b(this.ddp, this.ckw << 2);
    int m = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    int i = this.ckw;
    int n = com.tencent.matrix.resource.d.b.a.l(this.ddp);
    int j = 0;
    int i1;
    for (i = i * 7 + 4 + 4 + 2; j < n; i = i1 + 2 + i)
    {
      com.tencent.matrix.resource.d.b.a.b(this.ddp, 2L);
      i1 = XK();
      j += 1;
    }
    n = com.tencent.matrix.resource.d.b.a.l(this.ddp);
    com.tencent.matrix.resource.d.a.a[] arrayOfa = new com.tencent.matrix.resource.d.a.a[n];
    j = 0;
    i += 2;
    Object localObject2;
    while (j < n)
    {
      localObject1 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
      i1 = this.ddp.read();
      localObject2 = com.tencent.matrix.resource.d.a.c.jF(i1);
      if (localObject2 == null) {
        throw new IllegalStateException("accept class failed, lost type def of typeId: ".concat(String.valueOf(i1)));
      }
      arrayOfa[j] = new com.tencent.matrix.resource.d.a.a(i1, (com.tencent.matrix.resource.d.a.b)localObject1, com.tencent.matrix.resource.d.b.a.a(this.ddp, (com.tencent.matrix.resource.d.a.c)localObject2, this.ckw));
      i1 = this.ckw;
      int i2 = ((com.tencent.matrix.resource.d.a.c)localObject2).jG(this.ckw);
      j += 1;
      i = i1 + 1 + i2 + i;
    }
    n = com.tencent.matrix.resource.d.b.a.l(this.ddp);
    Object localObject1 = new com.tencent.matrix.resource.d.a.a[n];
    j = i + 2;
    i = 0;
    while (i < n)
    {
      localObject2 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
      localObject1[i] = new com.tencent.matrix.resource.d.a.a(this.ddp.read(), (com.tencent.matrix.resource.d.a.b)localObject2, null);
      j += this.ckw + 1;
      i += 1;
    }
    paramb.a(localb1, k, localb2, localb3, m, arrayOfa, (com.tencent.matrix.resource.d.a.a[])localObject1);
    return j;
  }
  
  private int h(b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb1 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    int i = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    com.tencent.matrix.resource.d.a.b localb2 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    int j = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    byte[] arrayOfByte = new byte[j];
    com.tencent.matrix.resource.d.b.a.a(this.ddp, arrayOfByte, j);
    paramb.a(localb1, i, localb2, arrayOfByte);
    return this.ckw + 4 + this.ckw + 4 + j;
  }
  
  private int i(b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb1 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    int i = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    int j = com.tencent.matrix.resource.d.b.a.m(this.ddp);
    com.tencent.matrix.resource.d.a.b localb2 = com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw);
    int k = j * this.ckw;
    byte[] arrayOfByte = new byte[k];
    com.tencent.matrix.resource.d.b.a.a(this.ddp, arrayOfByte, k);
    paramb.a(localb1, i, j, localb2, arrayOfByte);
    return this.ckw + 4 + 4 + this.ckw + k;
  }
  
  private int j(b paramb)
  {
    paramb.d(com.tencent.matrix.resource.d.b.a.a(this.ddp, this.ckw), com.tencent.matrix.resource.d.b.a.m(this.ddp), com.tencent.matrix.resource.d.b.a.m(this.ddp));
    return this.ckw + 4 + 4;
  }
  
  public final void a(d paramd)
  {
    b(paramd);
    c(paramd);
    paramd.XJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.resource.d.c
 * JD-Core Version:    0.7.0.1
 */