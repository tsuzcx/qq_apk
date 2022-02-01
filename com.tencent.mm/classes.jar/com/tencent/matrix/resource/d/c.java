package com.tencent.matrix.resource.d;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c
{
  private int eaR = 0;
  private final InputStream fbR;
  
  public c(InputStream paramInputStream)
  {
    this.fbR = paramInputStream;
  }
  
  private int a(int paramInt, b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    int i = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    int j = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    int k = this.fbR.read();
    Object localObject = com.tencent.matrix.resource.d.a.c.nu(k);
    if (localObject == null) {
      throw new IllegalStateException("accept primitive array failed, lost type def of typeId: ".concat(String.valueOf(k)));
    }
    int m = j * ((com.tencent.matrix.resource.d.a.c)localObject).nv(this.eaR);
    localObject = new byte[m];
    com.tencent.matrix.resource.d.b.a.a(this.fbR, (byte[])localObject, m);
    paramb.a(paramInt, localb, i, j, k, (byte[])localObject);
    return this.eaR + 4 + 4 + 1 + m;
  }
  
  private int a(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
    return this.eaR + 4;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    paramd = paramd.b(paramInt1, paramInt2, paramLong);
    long l = paramLong;
    if (paramd == null)
    {
      com.tencent.matrix.resource.d.b.a.b(this.fbR, paramLong);
      return;
      paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
      l = paramLong - this.eaR;
    }
    while (l > 0L)
    {
      paramInt1 = this.fbR.read();
      paramLong = l - 1L;
      switch (paramInt1)
      {
      case 255: 
      default: 
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + paramInt1 + " with " + this.fbR.available() + " bytes possibly remaining");
      case 1: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        com.tencent.matrix.resource.d.b.a.b(this.fbR, this.eaR);
        l = paramLong - (this.eaR << 1);
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
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
        break;
      case 6: 
        l = paramLong - e(paramd);
        break;
      case 7: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
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
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
        break;
      case 138: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
        break;
      case 139: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
        break;
      case 140: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
        break;
      case 141: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
        break;
      case 142: 
        l = paramLong - j(paramd);
        break;
      case 144: 
        paramd.b(paramInt1, com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR));
        l = paramLong - this.eaR;
      }
    }
    paramd.azp();
  }
  
  private void a(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.a(this.fbR, paramLong - this.eaR), paramInt, paramLong);
  }
  
  private int azq()
  {
    int i = this.fbR.read();
    com.tencent.matrix.resource.d.a.c localc = com.tencent.matrix.resource.d.a.c.nu(i);
    if (localc == null) {
      throw new IllegalStateException("failure to skip type, cannot find type def of typeid: ".concat(String.valueOf(i)));
    }
    i = localc.nv(this.eaR);
    com.tencent.matrix.resource.d.b.a.b(this.fbR, i);
    return i + 1;
  }
  
  private int b(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.x(this.fbR));
    return this.eaR + 4 + 4;
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    byte[] arrayOfByte = new byte[(int)paramLong];
    com.tencent.matrix.resource.d.b.a.a(this.fbR, arrayOfByte, paramLong);
    paramd.a(paramInt1, paramInt2, paramLong, arrayOfByte);
  }
  
  private void b(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), paramInt, paramLong);
  }
  
  private void b(d paramd)
  {
    String str = com.tencent.matrix.resource.d.b.a.z(this.fbR);
    int i = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    if ((i <= 0) || (i >= 1073741823)) {
      throw new IOException("bad idSize: ".concat(String.valueOf(i)));
    }
    long l = com.tencent.matrix.resource.d.b.a.y(this.fbR);
    this.eaR = i;
    paramd.a(str, i, l);
  }
  
  private int c(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.x(this.fbR));
    return this.eaR + 4 + 4;
  }
  
  private void c(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.x(this.fbR), paramInt, paramLong);
  }
  
  private void c(d paramd)
  {
    try
    {
      int i = this.fbR.read();
      int j = com.tencent.matrix.resource.d.b.a.x(this.fbR);
      long l = 0xFFFFFFFF & com.tencent.matrix.resource.d.b.a.x(this.fbR);
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
    paramb.a(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR));
    return this.eaR + 4;
  }
  
  private void d(int paramInt, long paramLong, d paramd)
  {
    int j = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    int k = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    int m = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    com.tencent.matrix.resource.d.a.b[] arrayOfb = new com.tencent.matrix.resource.d.a.b[m];
    int i = 0;
    while (i < m)
    {
      arrayOfb[i] = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
      i += 1;
    }
    paramd.a(j, k, arrayOfb, paramInt, paramLong);
  }
  
  private int e(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR));
    return this.eaR + 4;
  }
  
  private int f(b paramb)
  {
    paramb.c(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.x(this.fbR));
    return this.eaR + 4 + 4;
  }
  
  private int g(b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb1 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    int k = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    com.tencent.matrix.resource.d.a.b localb2 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    com.tencent.matrix.resource.d.a.b localb3 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    com.tencent.matrix.resource.d.b.a.b(this.fbR, this.eaR << 2);
    int m = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    int i = this.eaR;
    int n = com.tencent.matrix.resource.d.b.a.w(this.fbR);
    int j = 0;
    int i1;
    for (i = i * 7 + 4 + 4 + 2; j < n; i = i1 + 2 + i)
    {
      com.tencent.matrix.resource.d.b.a.b(this.fbR, 2L);
      i1 = azq();
      j += 1;
    }
    n = com.tencent.matrix.resource.d.b.a.w(this.fbR);
    com.tencent.matrix.resource.d.a.a[] arrayOfa = new com.tencent.matrix.resource.d.a.a[n];
    j = 0;
    i += 2;
    Object localObject2;
    while (j < n)
    {
      localObject1 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
      i1 = this.fbR.read();
      localObject2 = com.tencent.matrix.resource.d.a.c.nu(i1);
      if (localObject2 == null) {
        throw new IllegalStateException("accept class failed, lost type def of typeId: ".concat(String.valueOf(i1)));
      }
      arrayOfa[j] = new com.tencent.matrix.resource.d.a.a(i1, (com.tencent.matrix.resource.d.a.b)localObject1, com.tencent.matrix.resource.d.b.a.a(this.fbR, (com.tencent.matrix.resource.d.a.c)localObject2, this.eaR));
      i1 = this.eaR;
      int i2 = ((com.tencent.matrix.resource.d.a.c)localObject2).nv(this.eaR);
      j += 1;
      i = i1 + 1 + i2 + i;
    }
    n = com.tencent.matrix.resource.d.b.a.w(this.fbR);
    Object localObject1 = new com.tencent.matrix.resource.d.a.a[n];
    j = i + 2;
    i = 0;
    while (i < n)
    {
      localObject2 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
      localObject1[i] = new com.tencent.matrix.resource.d.a.a(this.fbR.read(), (com.tencent.matrix.resource.d.a.b)localObject2, null);
      j += this.eaR + 1;
      i += 1;
    }
    paramb.a(localb1, k, localb2, localb3, m, arrayOfa, (com.tencent.matrix.resource.d.a.a[])localObject1);
    return j;
  }
  
  private int h(b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb1 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    int i = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    com.tencent.matrix.resource.d.a.b localb2 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    int j = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    byte[] arrayOfByte = new byte[j];
    com.tencent.matrix.resource.d.b.a.a(this.fbR, arrayOfByte, j);
    paramb.a(localb1, i, localb2, arrayOfByte);
    return this.eaR + 4 + this.eaR + 4 + j;
  }
  
  private int i(b paramb)
  {
    com.tencent.matrix.resource.d.a.b localb1 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    int i = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    int j = com.tencent.matrix.resource.d.b.a.x(this.fbR);
    com.tencent.matrix.resource.d.a.b localb2 = com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR);
    int k = j * this.eaR;
    byte[] arrayOfByte = new byte[k];
    com.tencent.matrix.resource.d.b.a.a(this.fbR, arrayOfByte, k);
    paramb.a(localb1, i, j, localb2, arrayOfByte);
    return this.eaR + 4 + 4 + this.eaR + k;
  }
  
  private int j(b paramb)
  {
    paramb.d(com.tencent.matrix.resource.d.b.a.d(this.fbR, this.eaR), com.tencent.matrix.resource.d.b.a.x(this.fbR), com.tencent.matrix.resource.d.b.a.x(this.fbR));
    return this.eaR + 4 + 4;
  }
  
  public final void a(d paramd)
  {
    b(paramd);
    c(paramd);
    paramd.azp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.d.c
 * JD-Core Version:    0.7.0.1
 */