package com.d.a.b;

import java.io.EOFException;
import java.io.PrintStream;

public final class h
{
  l bUb;
  private final com.d.a.b.a.a bUe;
  int bUf;
  com.d.a.c.k<String> bUg = new com.d.a.c.k();
  com.d.a.c.k<String> bUh = new com.d.a.c.k();
  
  public h(com.d.a.b.a.a parama)
  {
    this.bUe = parama;
  }
  
  private int a(k paramk)
  {
    paramk = new j(paramk, zR());
    this.bUb.a(paramk);
    return this.bUf;
  }
  
  private void aC(long paramLong)
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
        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + i + " with " + this.bUe.Aa() + " bytes possibly remaining");
      case 255: 
        paramLong -= a(k.bUw);
        break;
      case 1: 
        l1 = a(k.bUB);
        zR();
        paramLong = paramLong - l1 - this.bUf;
        break;
      case 2: 
        l1 = zR();
        i = this.bUe.readInt();
        j = this.bUe.readInt();
        localObject1 = this.bUb.gd(i);
        localObject1 = this.bUb.bQ(((o)localObject1).bUY, j);
        localObject1 = new j(k.bUA, l1, i, (n)localObject1);
        this.bUb.a((j)localObject1);
        paramLong -= this.bUf + 4 + 4;
        break;
      case 3: 
        l1 = zR();
        i = this.bUe.readInt();
        j = this.bUe.readInt();
        localObject1 = this.bUb.gd(i);
        localObject1 = this.bUb.bQ(((o)localObject1).bUY, j);
        localObject1 = new j(k.bUH, l1, i, (n)localObject1);
        this.bUb.a((j)localObject1);
        paramLong -= this.bUf + 4 + 4;
        break;
      case 4: 
        l1 = zR();
        i = this.bUe.readInt();
        localObject1 = this.bUb.gd(i);
        localObject1 = this.bUb.gc(((o)localObject1).bUY);
        localObject1 = new j(k.bUI, l1, i, (n)localObject1);
        this.bUb.a((j)localObject1);
        paramLong -= this.bUf + 4;
        break;
      case 5: 
        paramLong -= a(k.bUx);
        break;
      case 6: 
        l1 = zR();
        i = this.bUe.readInt();
        localObject1 = this.bUb.gd(i);
        localObject1 = this.bUb.gc(((o)localObject1).bUY);
        localObject1 = new j(k.bUC, l1, i, (n)localObject1);
        this.bUb.a((j)localObject1);
        paramLong -= this.bUf + 4;
        break;
      case 7: 
        paramLong -= a(k.bUD);
        break;
      case 8: 
        l1 = zR();
        i = this.bUe.readInt();
        localObject1 = new o(l1, this.bUe.readInt());
        this.bUb.bUO.bTX.d(i, localObject1);
        paramLong -= this.bUf + 4 + 4;
        break;
      case 32: 
        l1 = zR();
        i = this.bUe.readInt();
        localObject1 = this.bUb.gc(i);
        l2 = zR();
        long l3 = zR();
        zR();
        zR();
        zR();
        zR();
        int k = this.bUe.readInt();
        i = this.bUf;
        int m = readUnsignedShort();
        j = 0;
        int n;
        for (i = i * 7 + 4 + 4 + 2; j < m; i = n + 1 + 2 + i)
        {
          readUnsignedShort();
          localObject2 = p.gg(readUnsignedByte());
          n = this.bUb.b((p)localObject2);
          aD(n);
          j += 1;
        }
        localObject1 = new c(l1, (n)localObject1, (String)this.bUh.get(l1), this.bUe.position());
        ((c)localObject1).bTJ = l2;
        ((c)localObject1).bTK = l3;
        m = readUnsignedShort();
        i += 2;
        Object localObject2 = new d[m];
        j = 0;
        while (j < m)
        {
          localObject3 = (String)this.bUg.get(zR());
          p localp = p.gg(this.bUe.readByte());
          localObject2[j] = new d(localp, (String)localObject3);
          aD(this.bUb.b(localp));
          i += this.bUf + 1 + this.bUb.b(localp);
          j += 1;
        }
        ((c)localObject1).bTM = ((d[])localObject2);
        m = readUnsignedShort();
        j = i + 2;
        localObject2 = new d[m];
        i = 0;
        while (i < m)
        {
          localObject3 = (String)this.bUg.get(zR());
          localObject2[i] = new d(p.gg(readUnsignedByte()), (String)localObject3);
          j += this.bUf + 1;
          i += 1;
        }
        ((c)localObject1).bTL = ((d[])localObject2);
        ((c)localObject1).bTN = k;
        localObject2 = this.bUb;
        Object localObject3 = ((l)localObject2).bUO;
        ((g)localObject3).bTY.a(l1, localObject1);
        ((g)localObject3).bTZ.h(((c)localObject1).mClassName, localObject1);
        ((i)localObject1).bUk = ((l)localObject2).bUO;
        paramLong -= j;
        break;
      case 33: 
        l1 = zR();
        i = this.bUe.readInt();
        localObject1 = this.bUb.gc(i);
        l2 = zR();
        i = this.bUe.readInt();
        localObject1 = new b(l1, (n)localObject1, this.bUe.position());
        ((i)localObject1).bUj = l2;
        this.bUb.a(l1, (i)localObject1);
        aD(i);
        paramLong -= this.bUf + 4 + this.bUf + 4 + i;
        break;
      case 34: 
        l1 = zR();
        i = this.bUe.readInt();
        localObject1 = this.bUb.gc(i);
        i = this.bUe.readInt();
        l2 = zR();
        localObject1 = new a(l1, (n)localObject1, p.bUZ, i, this.bUe.position());
        ((i)localObject1).bUj = l2;
        this.bUb.a(l1, (i)localObject1);
        i = this.bUf * i;
        aD(i);
        paramLong -= i + (this.bUf + 4 + 4 + this.bUf);
        break;
      case 35: 
        paramLong -= zT();
        break;
      case 195: 
        System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
        zT();
        throw new IllegalArgumentException("Don't know how to load a nodata array");
      case 254: 
        i = this.bUe.readInt();
        l1 = zR();
        localObject1 = (String)this.bUg.get(l1);
        this.bUb.f(i, (String)localObject1);
        paramLong -= this.bUf + 4;
        break;
      case 137: 
        paramLong -= a(k.bUv);
        break;
      case 138: 
        paramLong -= a(k.bUG);
        break;
      case 139: 
        paramLong -= a(k.bUz);
        break;
      case 140: 
        paramLong -= a(k.bUF);
        break;
      case 141: 
        paramLong -= a(k.bUy);
        break;
      case 142: 
        l1 = zR();
        i = this.bUe.readInt();
        j = this.bUe.readInt();
        localObject1 = this.bUb.gd(i);
        localObject1 = this.bUb.bQ(((o)localObject1).bUY, j);
        localObject1 = new j(k.bUE, l1, i, (n)localObject1);
        this.bUb.a((j)localObject1);
        paramLong -= this.bUf + 4 + 4;
        break;
      }
      paramLong -= a(k.bUt);
    }
  }
  
  private void aD(long paramLong)
  {
    this.bUe.aG(this.bUe.position() + paramLong);
  }
  
  private int readUnsignedByte()
  {
    return this.bUe.readByte() & 0xFF;
  }
  
  private int readUnsignedShort()
  {
    return this.bUe.readShort() & 0xFFFF;
  }
  
  private long zR()
  {
    switch (this.bUf)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    case 1: 
      return this.bUe.readByte();
    case 2: 
      return this.bUe.readShort();
    case 4: 
      return this.bUe.readInt();
    }
    return this.bUe.readLong();
  }
  
  private void zS()
  {
    int j = this.bUe.readInt();
    int k = this.bUe.readInt();
    int m = this.bUe.readInt();
    Object localObject = new m[m];
    int i = 0;
    while (i < m)
    {
      l locall = this.bUb;
      long l = zR();
      localObject[i] = ((m)locall.bUO.bTU.get(l));
      i += 1;
    }
    localObject = new n(j, k, (m[])localObject);
    this.bUb.bUO.bTV.d(((n)localObject).bUT, localObject);
  }
  
  private int zT()
  {
    long l = zR();
    int i = this.bUe.readInt();
    Object localObject = this.bUb.gc(i);
    i = this.bUe.readInt();
    p localp = p.gg(readUnsignedByte());
    int j = this.bUb.b(localp);
    localObject = new a(l, (n)localObject, localp, i, this.bUe.position());
    this.bUb.a(l, (i)localObject);
    i *= j;
    aD(i);
    return i + (this.bUf + 4 + 4 + 1);
  }
  
  public final l zQ()
  {
    locall = new l(this.bUe);
    this.bUb = locall;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        i = this.bUe.readByte();
        if (i != 0)
        {
          localStringBuilder.append((char)i);
          i = this.bUe.readByte();
          continue;
        }
        this.bUf = this.bUe.readInt();
        this.bUb.gf(this.bUf);
        this.bUe.readLong();
      }
      catch (EOFException localEOFException)
      {
        this.bUb.zY();
        this.bUb.zZ();
        this.bUh.clear();
        this.bUg.clear();
        return locall;
        int i = (int)l;
        int j = this.bUf;
        long l = zR();
        Object localObject = new byte[i - j];
        this.bUe.y((byte[])localObject);
        localObject = new String((byte[])localObject, "utf-8");
        this.bUg.a(l, localObject);
        continue;
        this.bUe.readInt();
        l = zR();
        this.bUe.readInt();
        localObject = (String)this.bUg.get(zR());
        this.bUh.a(l, localObject);
        continue;
        localObject = new m(zR(), (String)this.bUg.get(zR()), (String)this.bUg.get(zR()), (String)this.bUg.get(zR()), this.bUe.readInt(), this.bUe.readInt());
        this.bUb.bUO.bTU.a(((m)localObject).KQ, localObject);
        continue;
        zS();
        continue;
        aC(l);
        this.bUb.f(0, "default");
        continue;
        aC(l);
        this.bUb.f(0, "default");
        continue;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!this.bUe.hasRemaining()) {
        continue;
      }
      i = readUnsignedByte();
      this.bUe.readInt();
      l = this.bUe.readInt() & 0xFFFFFFFF;
      switch (i)
      {
      case 1: 
        aD(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.h
 * JD-Core Version:    0.7.0.1
 */