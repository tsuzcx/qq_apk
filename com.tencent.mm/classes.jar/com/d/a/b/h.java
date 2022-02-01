package com.d.a.b;

import java.io.EOFException;
import java.io.PrintStream;

public final class h
{
  l cks;
  private final com.d.a.b.a.a ckv;
  int ckw;
  com.d.a.c.l<String> ckx = new com.d.a.c.l();
  com.d.a.c.l<String> cky = new com.d.a.c.l();
  
  public h(com.d.a.b.a.a parama)
  {
    this.ckv = parama;
  }
  
  private long Lb()
  {
    switch (this.ckw)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    case 1: 
      return this.ckv.readByte();
    case 2: 
      return this.ckv.readShort();
    case 4: 
      return this.ckv.readInt();
    }
    return this.ckv.readLong();
  }
  
  private void Lc()
  {
    int j = this.ckv.readInt();
    int k = this.ckv.readInt();
    int m = this.ckv.readInt();
    Object localObject = new m[m];
    int i = 0;
    while (i < m)
    {
      l locall = this.cks;
      long l = Lb();
      localObject[i] = ((m)locall.clf.ckl.aX(l));
      i += 1;
    }
    localObject = new n(j, k, (m[])localObject);
    this.cks.clf.ckm.h(((n)localObject).clj, localObject);
  }
  
  private int Ld()
  {
    long l = Lb();
    int i = this.ckv.readInt();
    Object localObject = this.cks.ij(i);
    i = this.ckv.readInt();
    p localp = p.in(readUnsignedByte());
    int j = this.cks.b(localp);
    localObject = new a(l, (n)localObject, localp, i, this.ckv.Lk());
    this.cks.a(l, (i)localObject);
    i *= j;
    aS(i);
    return i + (this.ckw + 4 + 4 + 1);
  }
  
  private int a(k paramk)
  {
    paramk = new j(paramk, Lb());
    this.cks.a(paramk);
    return this.ckw;
  }
  
  private void aR(long paramLong)
  {
    while (paramLong > 0L)
    {
      int i = readUnsignedByte();
      paramLong -= 1L;
      long l1;
      int j;
      Object localObject1;
      long l2;
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + i + " with " + this.ckv.Ll() + " bytes possibly remaining");
      case 255: 
        paramLong -= a(k.ckN);
        break;
      case 1: 
        l1 = a(k.ckS);
        Lb();
        paramLong = paramLong - l1 - this.ckw;
        break;
      case 2: 
        l1 = Lb();
        i = this.ckv.readInt();
        j = this.ckv.readInt();
        localObject1 = this.cks.ik(i);
        localObject1 = this.cks.ck(((o)localObject1).clo, j);
        localObject1 = new j(k.ckR, l1, i, (n)localObject1);
        this.cks.a((j)localObject1);
        paramLong -= this.ckw + 4 + 4;
        break;
      case 3: 
        l1 = Lb();
        i = this.ckv.readInt();
        j = this.ckv.readInt();
        localObject1 = this.cks.ik(i);
        localObject1 = this.cks.ck(((o)localObject1).clo, j);
        localObject1 = new j(k.ckY, l1, i, (n)localObject1);
        this.cks.a((j)localObject1);
        paramLong -= this.ckw + 4 + 4;
        break;
      case 4: 
        l1 = Lb();
        i = this.ckv.readInt();
        localObject1 = this.cks.ik(i);
        localObject1 = this.cks.ij(((o)localObject1).clo);
        localObject1 = new j(k.ckZ, l1, i, (n)localObject1);
        this.cks.a((j)localObject1);
        paramLong -= this.ckw + 4;
        break;
      case 5: 
        paramLong -= a(k.ckO);
        break;
      case 6: 
        l1 = Lb();
        i = this.ckv.readInt();
        localObject1 = this.cks.ik(i);
        localObject1 = this.cks.ij(((o)localObject1).clo);
        localObject1 = new j(k.ckT, l1, i, (n)localObject1);
        this.cks.a((j)localObject1);
        paramLong -= this.ckw + 4;
        break;
      case 7: 
        paramLong -= a(k.ckU);
        break;
      case 8: 
        l1 = Lb();
        i = this.ckv.readInt();
        localObject1 = new o(l1, this.ckv.readInt());
        this.cks.clf.cko.h(i, localObject1);
        paramLong -= this.ckw + 4 + 4;
        break;
      case 32: 
        l1 = Lb();
        i = this.ckv.readInt();
        localObject1 = this.cks.ij(i);
        l2 = Lb();
        long l3 = Lb();
        Lb();
        Lb();
        Lb();
        Lb();
        int k = this.ckv.readInt();
        i = this.ckw;
        int m = readUnsignedShort();
        j = 0;
        int n;
        for (i = i * 7 + 4 + 4 + 2; j < m; i = n + 1 + 2 + i)
        {
          readUnsignedShort();
          localObject2 = p.in(readUnsignedByte());
          n = this.cks.b((p)localObject2);
          aS(n);
          j += 1;
        }
        localObject1 = new c(l1, (n)localObject1, (String)this.cky.aX(l1), this.ckv.Lk());
        ((c)localObject1).cka = l2;
        ((c)localObject1).ckb = l3;
        m = readUnsignedShort();
        i += 2;
        Object localObject2 = new d[m];
        j = 0;
        while (j < m)
        {
          localObject3 = (String)this.ckx.aX(Lb());
          p localp = p.in(this.ckv.readByte());
          localObject2[j] = new d(localp, (String)localObject3);
          aS(this.cks.b(localp));
          i += this.ckw + 1 + this.cks.b(localp);
          j += 1;
        }
        ((c)localObject1).ckd = ((d[])localObject2);
        m = readUnsignedShort();
        j = i + 2;
        localObject2 = new d[m];
        i = 0;
        while (i < m)
        {
          localObject3 = (String)this.ckx.aX(Lb());
          localObject2[i] = new d(p.in(readUnsignedByte()), (String)localObject3);
          j += this.ckw + 1;
          i += 1;
        }
        ((c)localObject1).ckc = ((d[])localObject2);
        ((c)localObject1).cke = k;
        localObject2 = this.cks;
        Object localObject3 = ((l)localObject2).clf;
        ((g)localObject3).ckp.d(l1, localObject1);
        ((g)localObject3).ckq.k(((c)localObject1).mClassName, localObject1);
        ((i)localObject1).ckB = ((l)localObject2).clf;
        paramLong -= j;
        break;
      case 33: 
        l1 = Lb();
        i = this.ckv.readInt();
        localObject1 = this.cks.ij(i);
        l2 = Lb();
        i = this.ckv.readInt();
        localObject1 = new b(l1, (n)localObject1, this.ckv.Lk());
        ((i)localObject1).ckA = l2;
        this.cks.a(l1, (i)localObject1);
        aS(i);
        paramLong -= this.ckw + 4 + this.ckw + 4 + i;
        break;
      case 34: 
        l1 = Lb();
        i = this.ckv.readInt();
        localObject1 = this.cks.ij(i);
        i = this.ckv.readInt();
        l2 = Lb();
        localObject1 = new a(l1, (n)localObject1, p.clp, i, this.ckv.Lk());
        ((i)localObject1).ckA = l2;
        this.cks.a(l1, (i)localObject1);
        i = this.ckw * i;
        aS(i);
        paramLong -= i + (this.ckw + 4 + 4 + this.ckw);
        break;
      case 35: 
        paramLong -= Ld();
        break;
      case 195: 
        System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
        Ld();
        throw new IllegalArgumentException("Don't know how to load a nodata array");
      case 254: 
        i = this.ckv.readInt();
        l1 = Lb();
        localObject1 = (String)this.ckx.aX(l1);
        this.cks.h(i, (String)localObject1);
        paramLong -= this.ckw + 4;
        break;
      case 137: 
        paramLong -= a(k.ckM);
        break;
      case 138: 
        paramLong -= a(k.ckX);
        break;
      case 139: 
        paramLong -= a(k.ckQ);
        break;
      case 140: 
        paramLong -= a(k.ckW);
        break;
      case 141: 
        paramLong -= a(k.ckP);
        break;
      case 142: 
        l1 = Lb();
        i = this.ckv.readInt();
        j = this.ckv.readInt();
        localObject1 = this.cks.ik(i);
        localObject1 = this.cks.ck(((o)localObject1).clo, j);
        localObject1 = new j(k.ckV, l1, i, (n)localObject1);
        this.cks.a((j)localObject1);
        paramLong -= this.ckw + 4 + 4;
        break;
      }
      paramLong -= a(k.ckK);
    }
  }
  
  private void aS(long paramLong)
  {
    this.ckv.aV(this.ckv.Lk() + paramLong);
  }
  
  private int readUnsignedByte()
  {
    return this.ckv.readByte() & 0xFF;
  }
  
  private int readUnsignedShort()
  {
    return this.ckv.readShort() & 0xFFFF;
  }
  
  public final l La()
  {
    locall = new l(this.ckv);
    this.cks = locall;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        i = this.ckv.readByte();
        if (i != 0)
        {
          localStringBuilder.append((char)i);
          i = this.ckv.readByte();
          continue;
        }
        this.ckw = this.ckv.readInt();
        this.cks.im(this.ckw);
        this.ckv.readLong();
      }
      catch (EOFException localEOFException)
      {
        this.cks.Li();
        this.cks.Lj();
        this.cky.clear();
        this.ckx.clear();
        return locall;
        int i = (int)l;
        int j = this.ckw;
        long l = Lb();
        Object localObject = new byte[i - j];
        this.ckv.J((byte[])localObject);
        localObject = new String((byte[])localObject, "utf-8");
        this.ckx.d(l, localObject);
        continue;
        this.ckv.readInt();
        l = Lb();
        this.ckv.readInt();
        localObject = (String)this.ckx.aX(Lb());
        this.cky.d(l, localObject);
        continue;
        localObject = new m(Lb(), (String)this.ckx.aX(Lb()), (String)this.ckx.aX(Lb()), (String)this.ckx.aX(Lb()), this.ckv.readInt(), this.ckv.readInt());
        this.cks.clf.ckl.d(((m)localObject).dI, localObject);
        continue;
        Lc();
        continue;
        aR(l);
        this.cks.h(0, "default");
        continue;
        aR(l);
        this.cks.h(0, "default");
        continue;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!this.ckv.hasRemaining()) {
        continue;
      }
      i = readUnsignedByte();
      this.ckv.readInt();
      l = this.ckv.readInt() & 0xFFFFFFFF;
      switch (i)
      {
      case 1: 
        aS(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.h
 * JD-Core Version:    0.7.0.1
 */