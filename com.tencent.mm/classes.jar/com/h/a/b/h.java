package com.h.a.b;

import java.io.EOFException;
import java.io.PrintStream;

public final class h
{
  l eaN;
  private final com.h.a.b.a.a eaQ;
  int eaR;
  com.h.a.c.k<String> eaS = new com.h.a.c.k();
  com.h.a.c.k<String> eaT = new com.h.a.c.k();
  
  public h(com.h.a.b.a.a parama)
  {
    this.eaQ = parama;
  }
  
  private int a(k paramk)
  {
    paramk = new j(paramk, alc());
    this.eaN.a(paramk);
    return this.eaR;
  }
  
  private long alc()
  {
    switch (this.eaR)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    case 1: 
      return this.eaQ.readByte();
    case 2: 
      return this.eaQ.readShort();
    case 4: 
      return this.eaQ.readInt();
    }
    return this.eaQ.readLong();
  }
  
  private void ald()
  {
    int j = this.eaQ.readInt();
    int k = this.eaQ.readInt();
    int m = this.eaQ.readInt();
    Object localObject = new m[m];
    int i = 0;
    while (i < m)
    {
      l locall = this.eaN;
      long l = alc();
      localObject[i] = ((m)locall.ebA.eaG.A(l));
      i += 1;
    }
    localObject = new n(j, k, (m[])localObject);
    this.eaN.ebA.eaH.z(((n)localObject).ebE, localObject);
  }
  
  private int ale()
  {
    long l = alc();
    int i = this.eaQ.readInt();
    Object localObject = this.eaN.lO(i);
    i = this.eaQ.readInt();
    p localp = p.lS(readUnsignedByte());
    int j = this.eaN.b(localp);
    localObject = new a(l, (n)localObject, localp, i, this.eaQ.all());
    this.eaN.a(l, (i)localObject);
    i *= j;
    dl(i);
    return i + (this.eaR + 4 + 4 + 1);
  }
  
  private void dk(long paramLong)
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
        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + i + " with " + this.eaQ.alm() + " bytes possibly remaining");
      case 255: 
        paramLong -= a(k.ebi);
        break;
      case 1: 
        l1 = a(k.ebn);
        alc();
        paramLong = paramLong - l1 - this.eaR;
        break;
      case 2: 
        l1 = alc();
        i = this.eaQ.readInt();
        j = this.eaQ.readInt();
        localObject1 = this.eaN.lP(i);
        localObject1 = this.eaN.cX(((o)localObject1).ebJ, j);
        localObject1 = new j(k.ebm, l1, i, (n)localObject1);
        this.eaN.a((j)localObject1);
        paramLong -= this.eaR + 4 + 4;
        break;
      case 3: 
        l1 = alc();
        i = this.eaQ.readInt();
        j = this.eaQ.readInt();
        localObject1 = this.eaN.lP(i);
        localObject1 = this.eaN.cX(((o)localObject1).ebJ, j);
        localObject1 = new j(k.ebt, l1, i, (n)localObject1);
        this.eaN.a((j)localObject1);
        paramLong -= this.eaR + 4 + 4;
        break;
      case 4: 
        l1 = alc();
        i = this.eaQ.readInt();
        localObject1 = this.eaN.lP(i);
        localObject1 = this.eaN.lO(((o)localObject1).ebJ);
        localObject1 = new j(k.ebu, l1, i, (n)localObject1);
        this.eaN.a((j)localObject1);
        paramLong -= this.eaR + 4;
        break;
      case 5: 
        paramLong -= a(k.ebj);
        break;
      case 6: 
        l1 = alc();
        i = this.eaQ.readInt();
        localObject1 = this.eaN.lP(i);
        localObject1 = this.eaN.lO(((o)localObject1).ebJ);
        localObject1 = new j(k.ebo, l1, i, (n)localObject1);
        this.eaN.a((j)localObject1);
        paramLong -= this.eaR + 4;
        break;
      case 7: 
        paramLong -= a(k.ebp);
        break;
      case 8: 
        l1 = alc();
        i = this.eaQ.readInt();
        localObject1 = new o(l1, this.eaQ.readInt());
        this.eaN.ebA.eaJ.z(i, localObject1);
        paramLong -= this.eaR + 4 + 4;
        break;
      case 32: 
        l1 = alc();
        i = this.eaQ.readInt();
        localObject1 = this.eaN.lO(i);
        l2 = alc();
        long l3 = alc();
        alc();
        alc();
        alc();
        alc();
        int k = this.eaQ.readInt();
        i = this.eaR;
        int m = readUnsignedShort();
        j = 0;
        int n;
        for (i = i * 7 + 4 + 4 + 2; j < m; i = n + 1 + 2 + i)
        {
          readUnsignedShort();
          localObject2 = p.lS(readUnsignedByte());
          n = this.eaN.b((p)localObject2);
          dl(n);
          j += 1;
        }
        localObject1 = new c(l1, (n)localObject1, (String)this.eaT.A(l1), this.eaQ.all());
        ((c)localObject1).eav = l2;
        ((c)localObject1).eaw = l3;
        m = readUnsignedShort();
        i += 2;
        Object localObject2 = new d[m];
        j = 0;
        while (j < m)
        {
          localObject3 = (String)this.eaS.A(alc());
          p localp = p.lS(this.eaQ.readByte());
          localObject2[j] = new d(localp, (String)localObject3);
          dl(this.eaN.b(localp));
          i += this.eaR + 1 + this.eaN.b(localp);
          j += 1;
        }
        ((c)localObject1).eay = ((d[])localObject2);
        m = readUnsignedShort();
        j = i + 2;
        localObject2 = new d[m];
        i = 0;
        while (i < m)
        {
          localObject3 = (String)this.eaS.A(alc());
          localObject2[i] = new d(p.lS(readUnsignedByte()), (String)localObject3);
          j += this.eaR + 1;
          i += 1;
        }
        ((c)localObject1).eax = ((d[])localObject2);
        ((c)localObject1).eaz = k;
        localObject2 = this.eaN;
        Object localObject3 = ((l)localObject2).ebA;
        ((g)localObject3).eaK.f(l1, localObject1);
        ((g)localObject3).eaL.v(((c)localObject1).mClassName, localObject1);
        ((i)localObject1).eaW = ((l)localObject2).ebA;
        paramLong -= j;
        break;
      case 33: 
        l1 = alc();
        i = this.eaQ.readInt();
        localObject1 = this.eaN.lO(i);
        l2 = alc();
        i = this.eaQ.readInt();
        localObject1 = new b(l1, (n)localObject1, this.eaQ.all());
        ((i)localObject1).eaV = l2;
        this.eaN.a(l1, (i)localObject1);
        dl(i);
        paramLong -= this.eaR + 4 + this.eaR + 4 + i;
        break;
      case 34: 
        l1 = alc();
        i = this.eaQ.readInt();
        localObject1 = this.eaN.lO(i);
        i = this.eaQ.readInt();
        l2 = alc();
        localObject1 = new a(l1, (n)localObject1, p.ebK, i, this.eaQ.all());
        ((i)localObject1).eaV = l2;
        this.eaN.a(l1, (i)localObject1);
        i = this.eaR * i;
        dl(i);
        paramLong -= i + (this.eaR + 4 + 4 + this.eaR);
        break;
      case 35: 
        paramLong -= ale();
        break;
      case 195: 
        System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
        ale();
        throw new IllegalArgumentException("Don't know how to load a nodata array");
      case 254: 
        i = this.eaQ.readInt();
        l1 = alc();
        localObject1 = (String)this.eaS.A(l1);
        this.eaN.i(i, (String)localObject1);
        paramLong -= this.eaR + 4;
        break;
      case 137: 
        paramLong -= a(k.ebh);
        break;
      case 138: 
        paramLong -= a(k.ebs);
        break;
      case 139: 
        paramLong -= a(k.ebl);
        break;
      case 140: 
        paramLong -= a(k.ebr);
        break;
      case 141: 
        paramLong -= a(k.ebk);
        break;
      case 142: 
        l1 = alc();
        i = this.eaQ.readInt();
        j = this.eaQ.readInt();
        localObject1 = this.eaN.lP(i);
        localObject1 = this.eaN.cX(((o)localObject1).ebJ, j);
        localObject1 = new j(k.ebq, l1, i, (n)localObject1);
        this.eaN.a((j)localObject1);
        paramLong -= this.eaR + 4 + 4;
        break;
      }
      paramLong -= a(k.ebf);
    }
  }
  
  private void dl(long paramLong)
  {
    this.eaQ.jdMethod_do(this.eaQ.all() + paramLong);
  }
  
  private int readUnsignedByte()
  {
    return this.eaQ.readByte() & 0xFF;
  }
  
  private int readUnsignedShort()
  {
    return this.eaQ.readShort() & 0xFFFF;
  }
  
  public final l alb()
  {
    locall = new l(this.eaQ);
    this.eaN = locall;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        i = this.eaQ.readByte();
        if (i != 0)
        {
          localStringBuilder.append((char)i);
          i = this.eaQ.readByte();
          continue;
        }
        this.eaR = this.eaQ.readInt();
        this.eaN.lR(this.eaR);
        this.eaQ.readLong();
      }
      catch (EOFException localEOFException)
      {
        this.eaN.alj();
        this.eaN.alk();
        this.eaT.clear();
        this.eaS.clear();
        return locall;
        int i = (int)l;
        int j = this.eaR;
        long l = alc();
        Object localObject = new byte[i - j];
        this.eaQ.I((byte[])localObject);
        localObject = new String((byte[])localObject, "utf-8");
        this.eaS.f(l, localObject);
        continue;
        this.eaQ.readInt();
        l = alc();
        this.eaQ.readInt();
        localObject = (String)this.eaS.A(alc());
        this.eaT.f(l, localObject);
        continue;
        localObject = new m(alc(), (String)this.eaS.A(alc()), (String)this.eaS.A(alc()), (String)this.eaS.A(alc()), this.eaQ.readInt(), this.eaQ.readInt());
        this.eaN.ebA.eaG.f(((m)localObject).dI, localObject);
        continue;
        ald();
        continue;
        dk(l);
        this.eaN.i(0, "default");
        continue;
        dk(l);
        this.eaN.i(0, "default");
        continue;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!this.eaQ.hasRemaining()) {
        continue;
      }
      i = readUnsignedByte();
      this.eaQ.readInt();
      l = this.eaQ.readInt() & 0xFFFFFFFF;
      switch (i)
      {
      case 1: 
        dl(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.h
 * JD-Core Version:    0.7.0.1
 */