package com.d.a.b;

import java.io.EOFException;
import java.io.PrintStream;

public final class h
{
  l bWt;
  private final com.d.a.b.a.a bWw;
  int bWx;
  com.d.a.c.k<String> bWy = new com.d.a.c.k();
  com.d.a.c.k<String> bWz = new com.d.a.c.k();
  
  public h(com.d.a.b.a.a parama)
  {
    this.bWw = parama;
  }
  
  private long Ae()
  {
    switch (this.bWx)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    case 1: 
      return this.bWw.readByte();
    case 2: 
      return this.bWw.readShort();
    case 4: 
      return this.bWw.readInt();
    }
    return this.bWw.readLong();
  }
  
  private void Af()
  {
    int j = this.bWw.readInt();
    int k = this.bWw.readInt();
    int m = this.bWw.readInt();
    Object localObject = new m[m];
    int i = 0;
    while (i < m)
    {
      l locall = this.bWt;
      long l = Ae();
      localObject[i] = ((m)locall.bXg.bWm.get(l));
      i += 1;
    }
    localObject = new n(j, k, (m[])localObject);
    this.bWt.bXg.bWn.d(((n)localObject).bXl, localObject);
  }
  
  private int Ag()
  {
    long l = Ae();
    int i = this.bWw.readInt();
    Object localObject = this.bWt.gr(i);
    i = this.bWw.readInt();
    p localp = p.gv(readUnsignedByte());
    int j = this.bWt.b(localp);
    localObject = new a(l, (n)localObject, localp, i, this.bWw.position());
    this.bWt.a(l, (i)localObject);
    i *= j;
    aH(i);
    return i + (this.bWx + 4 + 4 + 1);
  }
  
  private int a(k paramk)
  {
    paramk = new j(paramk, Ae());
    this.bWt.a(paramk);
    return this.bWx;
  }
  
  private void aG(long paramLong)
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
        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + i + " with " + this.bWw.An() + " bytes possibly remaining");
      case 255: 
        paramLong -= a(k.bWO);
        break;
      case 1: 
        l1 = a(k.bWT);
        Ae();
        paramLong = paramLong - l1 - this.bWx;
        break;
      case 2: 
        l1 = Ae();
        i = this.bWw.readInt();
        j = this.bWw.readInt();
        localObject1 = this.bWt.gs(i);
        localObject1 = this.bWt.bT(((o)localObject1).bXq, j);
        localObject1 = new j(k.bWS, l1, i, (n)localObject1);
        this.bWt.a((j)localObject1);
        paramLong -= this.bWx + 4 + 4;
        break;
      case 3: 
        l1 = Ae();
        i = this.bWw.readInt();
        j = this.bWw.readInt();
        localObject1 = this.bWt.gs(i);
        localObject1 = this.bWt.bT(((o)localObject1).bXq, j);
        localObject1 = new j(k.bWZ, l1, i, (n)localObject1);
        this.bWt.a((j)localObject1);
        paramLong -= this.bWx + 4 + 4;
        break;
      case 4: 
        l1 = Ae();
        i = this.bWw.readInt();
        localObject1 = this.bWt.gs(i);
        localObject1 = this.bWt.gr(((o)localObject1).bXq);
        localObject1 = new j(k.bXa, l1, i, (n)localObject1);
        this.bWt.a((j)localObject1);
        paramLong -= this.bWx + 4;
        break;
      case 5: 
        paramLong -= a(k.bWP);
        break;
      case 6: 
        l1 = Ae();
        i = this.bWw.readInt();
        localObject1 = this.bWt.gs(i);
        localObject1 = this.bWt.gr(((o)localObject1).bXq);
        localObject1 = new j(k.bWU, l1, i, (n)localObject1);
        this.bWt.a((j)localObject1);
        paramLong -= this.bWx + 4;
        break;
      case 7: 
        paramLong -= a(k.bWV);
        break;
      case 8: 
        l1 = Ae();
        i = this.bWw.readInt();
        localObject1 = new o(l1, this.bWw.readInt());
        this.bWt.bXg.bWp.d(i, localObject1);
        paramLong -= this.bWx + 4 + 4;
        break;
      case 32: 
        l1 = Ae();
        i = this.bWw.readInt();
        localObject1 = this.bWt.gr(i);
        l2 = Ae();
        long l3 = Ae();
        Ae();
        Ae();
        Ae();
        Ae();
        int k = this.bWw.readInt();
        i = this.bWx;
        int m = readUnsignedShort();
        j = 0;
        int n;
        for (i = i * 7 + 4 + 4 + 2; j < m; i = n + 1 + 2 + i)
        {
          readUnsignedShort();
          localObject2 = p.gv(readUnsignedByte());
          n = this.bWt.b((p)localObject2);
          aH(n);
          j += 1;
        }
        localObject1 = new c(l1, (n)localObject1, (String)this.bWz.get(l1), this.bWw.position());
        ((c)localObject1).bWb = l2;
        ((c)localObject1).bWc = l3;
        m = readUnsignedShort();
        i += 2;
        Object localObject2 = new d[m];
        j = 0;
        while (j < m)
        {
          localObject3 = (String)this.bWy.get(Ae());
          p localp = p.gv(this.bWw.readByte());
          localObject2[j] = new d(localp, (String)localObject3);
          aH(this.bWt.b(localp));
          i += this.bWx + 1 + this.bWt.b(localp);
          j += 1;
        }
        ((c)localObject1).bWe = ((d[])localObject2);
        m = readUnsignedShort();
        j = i + 2;
        localObject2 = new d[m];
        i = 0;
        while (i < m)
        {
          localObject3 = (String)this.bWy.get(Ae());
          localObject2[i] = new d(p.gv(readUnsignedByte()), (String)localObject3);
          j += this.bWx + 1;
          i += 1;
        }
        ((c)localObject1).bWd = ((d[])localObject2);
        ((c)localObject1).bWf = k;
        localObject2 = this.bWt;
        Object localObject3 = ((l)localObject2).bXg;
        ((g)localObject3).bWq.a(l1, localObject1);
        ((g)localObject3).bWr.h(((c)localObject1).mClassName, localObject1);
        ((i)localObject1).bWC = ((l)localObject2).bXg;
        paramLong -= j;
        break;
      case 33: 
        l1 = Ae();
        i = this.bWw.readInt();
        localObject1 = this.bWt.gr(i);
        l2 = Ae();
        i = this.bWw.readInt();
        localObject1 = new b(l1, (n)localObject1, this.bWw.position());
        ((i)localObject1).bWB = l2;
        this.bWt.a(l1, (i)localObject1);
        aH(i);
        paramLong -= this.bWx + 4 + this.bWx + 4 + i;
        break;
      case 34: 
        l1 = Ae();
        i = this.bWw.readInt();
        localObject1 = this.bWt.gr(i);
        i = this.bWw.readInt();
        l2 = Ae();
        localObject1 = new a(l1, (n)localObject1, p.bXr, i, this.bWw.position());
        ((i)localObject1).bWB = l2;
        this.bWt.a(l1, (i)localObject1);
        i = this.bWx * i;
        aH(i);
        paramLong -= i + (this.bWx + 4 + 4 + this.bWx);
        break;
      case 35: 
        paramLong -= Ag();
        break;
      case 195: 
        System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
        Ag();
        throw new IllegalArgumentException("Don't know how to load a nodata array");
      case 254: 
        i = this.bWw.readInt();
        l1 = Ae();
        localObject1 = (String)this.bWy.get(l1);
        this.bWt.f(i, (String)localObject1);
        paramLong -= this.bWx + 4;
        break;
      case 137: 
        paramLong -= a(k.bWN);
        break;
      case 138: 
        paramLong -= a(k.bWY);
        break;
      case 139: 
        paramLong -= a(k.bWR);
        break;
      case 140: 
        paramLong -= a(k.bWX);
        break;
      case 141: 
        paramLong -= a(k.bWQ);
        break;
      case 142: 
        l1 = Ae();
        i = this.bWw.readInt();
        j = this.bWw.readInt();
        localObject1 = this.bWt.gs(i);
        localObject1 = this.bWt.bT(((o)localObject1).bXq, j);
        localObject1 = new j(k.bWW, l1, i, (n)localObject1);
        this.bWt.a((j)localObject1);
        paramLong -= this.bWx + 4 + 4;
        break;
      }
      paramLong -= a(k.bWL);
    }
  }
  
  private void aH(long paramLong)
  {
    this.bWw.aK(this.bWw.position() + paramLong);
  }
  
  private int readUnsignedByte()
  {
    return this.bWw.readByte() & 0xFF;
  }
  
  private int readUnsignedShort()
  {
    return this.bWw.readShort() & 0xFFFF;
  }
  
  public final l Ad()
  {
    locall = new l(this.bWw);
    this.bWt = locall;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        i = this.bWw.readByte();
        if (i != 0)
        {
          localStringBuilder.append((char)i);
          i = this.bWw.readByte();
          continue;
        }
        this.bWx = this.bWw.readInt();
        this.bWt.gu(this.bWx);
        this.bWw.readLong();
      }
      catch (EOFException localEOFException)
      {
        this.bWt.Al();
        this.bWt.Am();
        this.bWz.clear();
        this.bWy.clear();
        return locall;
        int i = (int)l;
        int j = this.bWx;
        long l = Ae();
        Object localObject = new byte[i - j];
        this.bWw.A((byte[])localObject);
        localObject = new String((byte[])localObject, "utf-8");
        this.bWy.a(l, localObject);
        continue;
        this.bWw.readInt();
        l = Ae();
        this.bWw.readInt();
        localObject = (String)this.bWy.get(Ae());
        this.bWz.a(l, localObject);
        continue;
        localObject = new m(Ae(), (String)this.bWy.get(Ae()), (String)this.bWy.get(Ae()), (String)this.bWy.get(Ae()), this.bWw.readInt(), this.bWw.readInt());
        this.bWt.bXg.bWm.a(((m)localObject).JV, localObject);
        continue;
        Af();
        continue;
        aG(l);
        this.bWt.f(0, "default");
        continue;
        aG(l);
        this.bWt.f(0, "default");
        continue;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!this.bWw.hasRemaining()) {
        continue;
      }
      i = readUnsignedByte();
      this.bWw.readInt();
      l = this.bWw.readInt() & 0xFFFFFFFF;
      switch (i)
      {
      case 1: 
        aH(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.h
 * JD-Core Version:    0.7.0.1
 */