package com.c.a.b;

import java.io.EOFException;
import java.io.PrintStream;

public final class h
{
  l coS;
  private final com.c.a.b.a.a coV;
  int coW;
  com.c.a.c.k<String> coX = new com.c.a.c.k();
  com.c.a.c.k<String> coY = new com.c.a.c.k();
  
  public h(com.c.a.b.a.a parama)
  {
    this.coV = parama;
  }
  
  private long Ki()
  {
    switch (this.coW)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    case 1: 
      return this.coV.readByte();
    case 2: 
      return this.coV.readShort();
    case 4: 
      return this.coV.readInt();
    }
    return this.coV.readLong();
  }
  
  private void Kj()
  {
    int j = this.coV.readInt();
    int k = this.coV.readInt();
    int m = this.coV.readInt();
    Object localObject = new m[m];
    int i = 0;
    while (i < m)
    {
      l locall = this.coS;
      long l = Ki();
      localObject[i] = ((m)locall.cpF.coL.get(l));
      i += 1;
    }
    localObject = new n(j, k, (m[])localObject);
    this.coS.cpF.coM.e(((n)localObject).cpJ, localObject);
  }
  
  private int Kk()
  {
    long l = Ki();
    int i = this.coV.readInt();
    Object localObject = this.coS.hq(i);
    i = this.coV.readInt();
    p localp = p.hu(readUnsignedByte());
    int j = this.coS.b(localp);
    localObject = new a(l, (n)localObject, localp, i, this.coV.position());
    this.coS.a(l, (i)localObject);
    i *= j;
    aQ(i);
    return i + (this.coW + 4 + 4 + 1);
  }
  
  private int a(k paramk)
  {
    paramk = new j(paramk, Ki());
    this.coS.a(paramk);
    return this.coW;
  }
  
  private void aP(long paramLong)
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
        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + i + " with " + this.coV.Kq() + " bytes possibly remaining");
      case 255: 
        paramLong -= a(k.cpn);
        break;
      case 1: 
        l1 = a(k.cps);
        Ki();
        paramLong = paramLong - l1 - this.coW;
        break;
      case 2: 
        l1 = Ki();
        i = this.coV.readInt();
        j = this.coV.readInt();
        localObject1 = this.coS.hr(i);
        localObject1 = this.coS.bS(((o)localObject1).cpO, j);
        localObject1 = new j(k.cpr, l1, i, (n)localObject1);
        this.coS.a((j)localObject1);
        paramLong -= this.coW + 4 + 4;
        break;
      case 3: 
        l1 = Ki();
        i = this.coV.readInt();
        j = this.coV.readInt();
        localObject1 = this.coS.hr(i);
        localObject1 = this.coS.bS(((o)localObject1).cpO, j);
        localObject1 = new j(k.cpy, l1, i, (n)localObject1);
        this.coS.a((j)localObject1);
        paramLong -= this.coW + 4 + 4;
        break;
      case 4: 
        l1 = Ki();
        i = this.coV.readInt();
        localObject1 = this.coS.hr(i);
        localObject1 = this.coS.hq(((o)localObject1).cpO);
        localObject1 = new j(k.cpz, l1, i, (n)localObject1);
        this.coS.a((j)localObject1);
        paramLong -= this.coW + 4;
        break;
      case 5: 
        paramLong -= a(k.cpo);
        break;
      case 6: 
        l1 = Ki();
        i = this.coV.readInt();
        localObject1 = this.coS.hr(i);
        localObject1 = this.coS.hq(((o)localObject1).cpO);
        localObject1 = new j(k.cpt, l1, i, (n)localObject1);
        this.coS.a((j)localObject1);
        paramLong -= this.coW + 4;
        break;
      case 7: 
        paramLong -= a(k.cpu);
        break;
      case 8: 
        l1 = Ki();
        i = this.coV.readInt();
        localObject1 = new o(l1, this.coV.readInt());
        this.coS.cpF.coO.e(i, localObject1);
        paramLong -= this.coW + 4 + 4;
        break;
      case 32: 
        l1 = Ki();
        i = this.coV.readInt();
        localObject1 = this.coS.hq(i);
        l2 = Ki();
        long l3 = Ki();
        Ki();
        Ki();
        Ki();
        Ki();
        int k = this.coV.readInt();
        i = this.coW;
        int m = readUnsignedShort();
        j = 0;
        int n;
        for (i = i * 7 + 4 + 4 + 2; j < m; i = n + 1 + 2 + i)
        {
          readUnsignedShort();
          localObject2 = p.hu(readUnsignedByte());
          n = this.coS.b((p)localObject2);
          aQ(n);
          j += 1;
        }
        localObject1 = new c(l1, (n)localObject1, (String)this.coY.get(l1), this.coV.position());
        ((c)localObject1).coA = l2;
        ((c)localObject1).coB = l3;
        m = readUnsignedShort();
        i += 2;
        Object localObject2 = new d[m];
        j = 0;
        while (j < m)
        {
          localObject3 = (String)this.coX.get(Ki());
          p localp = p.hu(this.coV.readByte());
          localObject2[j] = new d(localp, (String)localObject3);
          aQ(this.coS.b(localp));
          i += this.coW + 1 + this.coS.b(localp);
          j += 1;
        }
        ((c)localObject1).coD = ((d[])localObject2);
        m = readUnsignedShort();
        j = i + 2;
        localObject2 = new d[m];
        i = 0;
        while (i < m)
        {
          localObject3 = (String)this.coX.get(Ki());
          localObject2[i] = new d(p.hu(readUnsignedByte()), (String)localObject3);
          j += this.coW + 1;
          i += 1;
        }
        ((c)localObject1).coC = ((d[])localObject2);
        ((c)localObject1).coE = k;
        localObject2 = this.coS;
        Object localObject3 = ((l)localObject2).cpF;
        ((g)localObject3).coP.a(l1, localObject1);
        ((g)localObject3).coQ.r(((c)localObject1).mClassName, localObject1);
        ((i)localObject1).cpb = ((l)localObject2).cpF;
        paramLong -= j;
        break;
      case 33: 
        l1 = Ki();
        i = this.coV.readInt();
        localObject1 = this.coS.hq(i);
        l2 = Ki();
        i = this.coV.readInt();
        localObject1 = new b(l1, (n)localObject1, this.coV.position());
        ((i)localObject1).cpa = l2;
        this.coS.a(l1, (i)localObject1);
        aQ(i);
        paramLong -= this.coW + 4 + this.coW + 4 + i;
        break;
      case 34: 
        l1 = Ki();
        i = this.coV.readInt();
        localObject1 = this.coS.hq(i);
        i = this.coV.readInt();
        l2 = Ki();
        localObject1 = new a(l1, (n)localObject1, p.cpP, i, this.coV.position());
        ((i)localObject1).cpa = l2;
        this.coS.a(l1, (i)localObject1);
        i = this.coW * i;
        aQ(i);
        paramLong -= i + (this.coW + 4 + 4 + this.coW);
        break;
      case 35: 
        paramLong -= Kk();
        break;
      case 195: 
        System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
        Kk();
        throw new IllegalArgumentException("Don't know how to load a nodata array");
      case 254: 
        i = this.coV.readInt();
        l1 = Ki();
        localObject1 = (String)this.coX.get(l1);
        this.coS.g(i, (String)localObject1);
        paramLong -= this.coW + 4;
        break;
      case 137: 
        paramLong -= a(k.cpm);
        break;
      case 138: 
        paramLong -= a(k.cpx);
        break;
      case 139: 
        paramLong -= a(k.cpq);
        break;
      case 140: 
        paramLong -= a(k.cpw);
        break;
      case 141: 
        paramLong -= a(k.cpp);
        break;
      case 142: 
        l1 = Ki();
        i = this.coV.readInt();
        j = this.coV.readInt();
        localObject1 = this.coS.hr(i);
        localObject1 = this.coS.bS(((o)localObject1).cpO, j);
        localObject1 = new j(k.cpv, l1, i, (n)localObject1);
        this.coS.a((j)localObject1);
        paramLong -= this.coW + 4 + 4;
        break;
      }
      paramLong -= a(k.cpk);
    }
  }
  
  private void aQ(long paramLong)
  {
    this.coV.aT(this.coV.position() + paramLong);
  }
  
  private int readUnsignedByte()
  {
    return this.coV.readByte() & 0xFF;
  }
  
  private int readUnsignedShort()
  {
    return this.coV.readShort() & 0xFFFF;
  }
  
  public final l Kh()
  {
    locall = new l(this.coV);
    this.coS = locall;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        i = this.coV.readByte();
        if (i != 0)
        {
          localStringBuilder.append((char)i);
          i = this.coV.readByte();
          continue;
        }
        this.coW = this.coV.readInt();
        this.coS.ht(this.coW);
        this.coV.readLong();
      }
      catch (EOFException localEOFException)
      {
        this.coS.Ko();
        this.coS.Kp();
        this.coY.clear();
        this.coX.clear();
        return locall;
        int i = (int)l;
        int j = this.coW;
        long l = Ki();
        Object localObject = new byte[i - j];
        this.coV.M((byte[])localObject);
        localObject = new String((byte[])localObject, "utf-8");
        this.coX.a(l, localObject);
        continue;
        this.coV.readInt();
        l = Ki();
        this.coV.readInt();
        localObject = (String)this.coX.get(Ki());
        this.coY.a(l, localObject);
        continue;
        localObject = new m(Ki(), (String)this.coX.get(Ki()), (String)this.coX.get(Ki()), (String)this.coX.get(Ki()), this.coV.readInt(), this.coV.readInt());
        this.coS.cpF.coL.a(((m)localObject).MS, localObject);
        continue;
        Kj();
        continue;
        aP(l);
        this.coS.g(0, "default");
        continue;
        aP(l);
        this.coS.g(0, "default");
        continue;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!this.coV.hasRemaining()) {
        continue;
      }
      i = readUnsignedByte();
      this.coV.readInt();
      l = this.coV.readInt() & 0xFFFFFFFF;
      switch (i)
      {
      case 1: 
        aQ(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.h
 * JD-Core Version:    0.7.0.1
 */