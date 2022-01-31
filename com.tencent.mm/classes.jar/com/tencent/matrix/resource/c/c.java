package com.tencent.matrix.resource.c;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class c
{
  private int bpi = 0;
  private final InputStream bpr;
  
  public c(InputStream paramInputStream)
  {
    this.bpr = paramInputStream;
  }
  
  private int a(int paramInt, b paramb)
  {
    com.tencent.matrix.resource.c.a.b localb = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
    int i = com.tencent.matrix.resource.c.b.a.h(this.bpr);
    int j = com.tencent.matrix.resource.c.b.a.h(this.bpr);
    int k = this.bpr.read();
    int m = j * com.tencent.matrix.resource.c.a.c.ef(k).getSize(this.bpi);
    byte[] arrayOfByte = new byte[m];
    com.tencent.matrix.resource.c.b.a.a(this.bpr, arrayOfByte, m);
    paramb.a(paramInt, localb, i, j, k, arrayOfByte);
    return this.bpi + 4 + 4 + 1 + m;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    paramd = paramd.a(paramInt1, paramInt2, paramLong);
    long l = paramLong;
    if (paramd == null)
    {
      com.tencent.matrix.resource.c.b.a.b(this.bpr, paramLong);
      return;
      paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
      l = paramLong - this.bpi;
    }
    while (l > 0L)
    {
      paramInt1 = this.bpr.read();
      paramLong = l - 1L;
      com.tencent.matrix.resource.c.a.b localb1;
      int i;
      com.tencent.matrix.resource.c.a.b localb2;
      Object localObject1;
      switch (paramInt1)
      {
      case 255: 
      default: 
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + paramInt1 + " with " + this.bpr.available() + " bytes possibly remaining");
      case 1: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        com.tencent.matrix.resource.c.b.a.b(this.bpr, this.bpi);
        l = paramLong - (this.bpi << 1);
        break;
      case 2: 
        paramd.a(com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.h(this.bpr));
        l = paramLong - (this.bpi + 4 + 4);
        break;
      case 3: 
        paramd.b(com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.h(this.bpr));
        l = paramLong - (this.bpi + 4 + 4);
        break;
      case 4: 
        paramd.a(com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr));
        l = paramLong - (this.bpi + 4);
        break;
      case 5: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
        break;
      case 6: 
        paramd.b(com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr));
        l = paramLong - (this.bpi + 4);
        break;
      case 7: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
        break;
      case 8: 
        paramd.c(com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.h(this.bpr));
        l = paramLong - (this.bpi + 4 + 4);
        break;
      case 32: 
        localb1 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        i = com.tencent.matrix.resource.c.b.a.h(this.bpr);
        localb2 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        localObject1 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        com.tencent.matrix.resource.c.b.a.b(this.bpr, this.bpi << 2);
        int j = com.tencent.matrix.resource.c.b.a.h(this.bpr);
        paramInt1 = this.bpi;
        int k = com.tencent.matrix.resource.c.b.a.g(this.bpr);
        paramInt1 = paramInt1 * 7 + 4 + 4 + 2;
        paramInt2 = 0;
        int m;
        while (paramInt2 < k)
        {
          com.tencent.matrix.resource.c.b.a.b(this.bpr, 2L);
          m = com.tencent.matrix.resource.c.a.c.ef(this.bpr.read()).getSize(this.bpi);
          com.tencent.matrix.resource.c.b.a.b(this.bpr, m);
          paramInt1 += m + 1 + 2;
          paramInt2 += 1;
        }
        k = com.tencent.matrix.resource.c.b.a.g(this.bpr);
        com.tencent.matrix.resource.c.a.a[] arrayOfa = new com.tencent.matrix.resource.c.a.a[k];
        paramInt1 += 2;
        paramInt2 = 0;
        while (paramInt2 < k)
        {
          localObject2 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
          m = this.bpr.read();
          arrayOfa[paramInt2] = new com.tencent.matrix.resource.c.a.a(m, (com.tencent.matrix.resource.c.a.b)localObject2, com.tencent.matrix.resource.c.b.a.a(this.bpr, com.tencent.matrix.resource.c.a.c.ef(m), this.bpi));
          paramInt1 += this.bpi + 1 + com.tencent.matrix.resource.c.a.c.ef(m).getSize(this.bpi);
          paramInt2 += 1;
        }
        k = com.tencent.matrix.resource.c.b.a.g(this.bpr);
        Object localObject2 = new com.tencent.matrix.resource.c.a.a[k];
        paramInt2 = paramInt1 + 2;
        paramInt1 = 0;
        while (paramInt1 < k)
        {
          com.tencent.matrix.resource.c.a.b localb3 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
          localObject2[paramInt1] = new com.tencent.matrix.resource.c.a.a(this.bpr.read(), localb3, null);
          paramInt2 += this.bpi + 1;
          paramInt1 += 1;
        }
        paramd.a(localb1, i, localb2, (com.tencent.matrix.resource.c.a.b)localObject1, j, arrayOfa, (com.tencent.matrix.resource.c.a.a[])localObject2);
        l = paramLong - paramInt2;
        break;
      case 33: 
        localb1 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        paramInt1 = com.tencent.matrix.resource.c.b.a.h(this.bpr);
        localb2 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        paramInt2 = com.tencent.matrix.resource.c.b.a.h(this.bpr);
        localObject1 = new byte[paramInt2];
        com.tencent.matrix.resource.c.b.a.a(this.bpr, (byte[])localObject1, paramInt2);
        paramd.a(localb1, paramInt1, localb2, (byte[])localObject1);
        l = paramLong - (this.bpi + 4 + this.bpi + 4 + paramInt2);
        break;
      case 34: 
        localb1 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        paramInt1 = com.tencent.matrix.resource.c.b.a.h(this.bpr);
        paramInt2 = com.tencent.matrix.resource.c.b.a.h(this.bpr);
        localb2 = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        i = paramInt2 * this.bpi;
        localObject1 = new byte[i];
        com.tencent.matrix.resource.c.b.a.a(this.bpr, (byte[])localObject1, i);
        paramd.a(localb1, paramInt1, paramInt2, localb2, (byte[])localObject1);
        l = paramLong - (this.bpi + 4 + 4 + this.bpi + i);
        break;
      case 35: 
        l = paramLong - a(paramInt1, paramd);
        break;
      case 195: 
        l = paramLong - a(paramInt1, paramd);
        break;
      case 254: 
        paramd.a(com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - (this.bpi + 4);
        break;
      case 137: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
        break;
      case 138: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
        break;
      case 139: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
        break;
      case 140: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
        break;
      case 141: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
        break;
      case 142: 
        paramd.d(com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.h(this.bpr));
        l = paramLong - (this.bpi + 4 + 4);
        break;
      case 144: 
        paramd.b(paramInt1, com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi));
        l = paramLong - this.bpi;
      }
    }
    paramd.rh();
  }
  
  private void a(int paramInt, long paramLong, d paramd)
  {
    int j = com.tencent.matrix.resource.c.b.a.h(this.bpr);
    int k = com.tencent.matrix.resource.c.b.a.h(this.bpr);
    int m = com.tencent.matrix.resource.c.b.a.h(this.bpr);
    com.tencent.matrix.resource.c.a.b[] arrayOfb = new com.tencent.matrix.resource.c.a.b[m];
    int i = 0;
    while (i < m)
    {
      arrayOfb[i] = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
      i += 1;
    }
    paramd.a(j, k, arrayOfb, paramInt, paramLong);
  }
  
  private void b(d paramd)
  {
    try
    {
      int i = this.bpr.read();
      int j = com.tencent.matrix.resource.c.b.a.h(this.bpr);
      long l1 = 0xFFFFFFFF & com.tencent.matrix.resource.c.b.a.h(this.bpr);
      switch (i)
      {
      }
      for (;;)
      {
        Object localObject = new byte[(int)l1];
        com.tencent.matrix.resource.c.b.a.a(this.bpr, (byte[])localObject, l1);
        paramd.a(i, j, l1, (byte[])localObject);
        break;
        localObject = com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi);
        InputStream localInputStream = this.bpr;
        long l2 = l1 - this.bpi;
        byte[] arrayOfByte = new byte[(int)l2];
        com.tencent.matrix.resource.c.b.a.a(localInputStream, arrayOfByte, l2);
        paramd.a((com.tencent.matrix.resource.c.a.b)localObject, new String(arrayOfByte, Charset.forName("UTF-8")), j, l1);
        break;
        paramd.a(com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), j, l1);
        break;
        paramd.a(com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.a(this.bpr, this.bpi), com.tencent.matrix.resource.c.b.a.h(this.bpr), com.tencent.matrix.resource.c.b.a.h(this.bpr), j, l1);
        break;
        a(j, l1, paramd);
        break;
        a(i, j, l1, paramd);
        break;
      }
      return;
    }
    catch (EOFException paramd) {}
  }
  
  public final void a(d paramd)
  {
    Object localObject = this.bpr;
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = ((InputStream)localObject).read(); i != 0; i = ((InputStream)localObject).read()) {
      localStringBuilder.append((char)i);
    }
    localObject = localStringBuilder.toString();
    i = com.tencent.matrix.resource.c.b.a.h(this.bpr);
    long l = com.tencent.matrix.resource.c.b.a.i(this.bpr);
    this.bpi = i;
    paramd.a((String)localObject, i, l);
    b(paramd);
    paramd.rh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.c.c
 * JD-Core Version:    0.7.0.1
 */