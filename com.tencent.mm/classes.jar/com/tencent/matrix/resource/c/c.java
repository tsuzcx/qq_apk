package com.tencent.matrix.resource.c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c
{
  private final InputStream cHZ;
  private int ces = 0;
  
  public c(InputStream paramInputStream)
  {
    this.cHZ = paramInputStream;
  }
  
  private int II()
  {
    int i = this.cHZ.read();
    com.tencent.matrix.resource.c.a.c localc = com.tencent.matrix.resource.c.a.c.gZ(i);
    if (localc == null) {
      throw new IllegalStateException("failure to skip type, cannot find type def of typeid: ".concat(String.valueOf(i)));
    }
    i = localc.getSize(this.ces);
    com.tencent.matrix.resource.c.b.a.c(this.cHZ, i);
    return i + 1;
  }
  
  private int a(int paramInt, b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    int i = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    int j = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    int k = this.cHZ.read();
    Object localObject = com.tencent.matrix.resource.c.a.c.gZ(k);
    if (localObject == null) {
      throw new IllegalStateException("accept primitive array failed, lost type def of typeId: ".concat(String.valueOf(k)));
    }
    int m = j * ((com.tencent.matrix.resource.c.a.c)localObject).getSize(this.ces);
    localObject = new byte[m];
    com.tencent.matrix.resource.c.b.a.a(this.cHZ, (byte[])localObject, m);
    paramb.a(paramInt, localb, i, j, k, (byte[])localObject);
    return this.ces + 4 + 4 + 1 + m;
  }
  
  private int a(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
    return this.ces + 4;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    paramd = paramd.b(paramInt1, paramInt2, paramLong);
    long l = paramLong;
    if (paramd == null)
    {
      com.tencent.matrix.resource.c.b.a.c(this.cHZ, paramLong);
      return;
      paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
      l = paramLong - this.ces;
    }
    while (l > 0L)
    {
      paramInt1 = this.cHZ.read();
      paramLong = l - 1L;
      switch (paramInt1)
      {
      case 255: 
      default: 
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + paramInt1 + " with " + this.cHZ.available() + " bytes possibly remaining");
      case 1: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        com.tencent.matrix.resource.c.b.a.c(this.cHZ, this.ces);
        l = paramLong - (this.ces << 1);
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
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
        break;
      case 6: 
        l = paramLong - e(paramd);
        break;
      case 7: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
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
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
        break;
      case 138: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
        break;
      case 139: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
        break;
      case 140: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
        break;
      case 141: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
        break;
      case 142: 
        l = paramLong - j(paramd);
        break;
      case 144: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces));
        l = paramLong - this.ces;
      }
    }
    paramd.IH();
  }
  
  private void a(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.b(this.cHZ, paramLong - this.ces), paramInt, paramLong);
  }
  
  private int b(b paramb)
  {
    paramb.a(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.o(this.cHZ));
    return this.ces + 4 + 4;
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    byte[] arrayOfByte = new byte[(int)paramLong];
    com.tencent.matrix.resource.c.b.a.a(this.cHZ, arrayOfByte, paramLong);
    paramd.a(paramInt1, paramInt2, paramLong, arrayOfByte);
  }
  
  private void b(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), paramInt, paramLong);
  }
  
  private void b(d paramd)
  {
    String str = com.tencent.matrix.resource.c.b.a.q(this.cHZ);
    int i = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    if ((i <= 0) || (i >= 1073741823)) {
      throw new IOException("bad idSize: ".concat(String.valueOf(i)));
    }
    long l = com.tencent.matrix.resource.c.b.a.p(this.cHZ);
    this.ces = i;
    paramd.a(str, i, l);
  }
  
  private int c(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.o(this.cHZ));
    return this.ces + 4 + 4;
  }
  
  private void c(int paramInt, long paramLong, d paramd)
  {
    paramd.a(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.o(this.cHZ), paramInt, paramLong);
  }
  
  private void c(d paramd)
  {
    try
    {
      int i = this.cHZ.read();
      int j = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
      long l = 0xFFFFFFFF & com.tencent.matrix.resource.c.b.a.o(this.cHZ);
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
    paramb.a(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ));
    return this.ces + 4;
  }
  
  private void d(int paramInt, long paramLong, d paramd)
  {
    int j = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    int k = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    int m = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    com.tencent.matrix.resource.c.a.b[] arrayOfb = new com.tencent.matrix.resource.c.a.b[m];
    int i = 0;
    while (i < m)
    {
      arrayOfb[i] = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
      i += 1;
    }
    paramd.a(j, k, arrayOfb, paramInt, paramLong);
  }
  
  private int e(b paramb)
  {
    paramb.b(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ));
    return this.ces + 4;
  }
  
  private int f(b paramb)
  {
    paramb.c(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.o(this.cHZ));
    return this.ces + 4 + 4;
  }
  
  private int g(b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb1 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    int k = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    com.tencent.matrix.resource.c.a.b localb2 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    com.tencent.matrix.resource.c.a.b localb3 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    com.tencent.matrix.resource.c.b.a.c(this.cHZ, this.ces << 2);
    int m = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    int i = this.ces;
    int n = com.tencent.matrix.resource.c.b.a.n(this.cHZ);
    int j = 0;
    int i1;
    for (i = i * 7 + 4 + 4 + 2; j < n; i = i1 + 2 + i)
    {
      com.tencent.matrix.resource.c.b.a.c(this.cHZ, 2L);
      i1 = II();
      j += 1;
    }
    n = com.tencent.matrix.resource.c.b.a.n(this.cHZ);
    com.tencent.matrix.resource.c.a.a[] arrayOfa = new com.tencent.matrix.resource.c.a.a[n];
    j = 0;
    i += 2;
    Object localObject2;
    while (j < n)
    {
      localObject1 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
      i1 = this.cHZ.read();
      localObject2 = com.tencent.matrix.resource.c.a.c.gZ(i1);
      if (localObject2 == null) {
        throw new IllegalStateException("accept class failed, lost type def of typeId: ".concat(String.valueOf(i1)));
      }
      arrayOfa[j] = new com.tencent.matrix.resource.c.a.a(i1, (com.tencent.matrix.resource.c.a.b)localObject1, com.tencent.matrix.resource.c.b.a.a(this.cHZ, (com.tencent.matrix.resource.c.a.c)localObject2, this.ces));
      i1 = this.ces;
      int i2 = ((com.tencent.matrix.resource.c.a.c)localObject2).getSize(this.ces);
      j += 1;
      i = i1 + 1 + i2 + i;
    }
    n = com.tencent.matrix.resource.c.b.a.n(this.cHZ);
    Object localObject1 = new com.tencent.matrix.resource.c.a.a[n];
    j = i + 2;
    i = 0;
    while (i < n)
    {
      localObject2 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
      localObject1[i] = new com.tencent.matrix.resource.c.a.a(this.cHZ.read(), (com.tencent.matrix.resource.c.a.b)localObject2, null);
      j += this.ces + 1;
      i += 1;
    }
    paramb.a(localb1, k, localb2, localb3, m, arrayOfa, (com.tencent.matrix.resource.c.a.a[])localObject1);
    return j;
  }
  
  private int h(b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb1 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    int i = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    com.tencent.matrix.resource.c.a.b localb2 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    int j = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    byte[] arrayOfByte = new byte[j];
    com.tencent.matrix.resource.c.b.a.a(this.cHZ, arrayOfByte, j);
    paramb.a(localb1, i, localb2, arrayOfByte);
    return this.ces + 4 + this.ces + 4 + j;
  }
  
  private int i(b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb1 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    int i = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    int j = com.tencent.matrix.resource.c.b.a.o(this.cHZ);
    com.tencent.matrix.resource.c.a.b localb2 = com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces);
    int k = j * this.ces;
    byte[] arrayOfByte = new byte[k];
    com.tencent.matrix.resource.c.b.a.a(this.cHZ, arrayOfByte, k);
    paramb.a(localb1, i, j, localb2, arrayOfByte);
    return this.ces + 4 + 4 + this.ces + k;
  }
  
  private int j(b paramb)
  {
    paramb.d(com.tencent.matrix.resource.c.b.a.a(this.cHZ, this.ces), com.tencent.matrix.resource.c.b.a.o(this.cHZ), com.tencent.matrix.resource.c.b.a.o(this.cHZ));
    return this.ces + 4 + 4;
  }
  
  public final void a(d paramd)
  {
    b(paramd);
    c(paramd);
    paramd.IH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c.c
 * JD-Core Version:    0.7.0.1
 */