package com.e.a.b;

import java.io.EOFException;
import java.io.PrintStream;

public final class h
{
  l ceo;
  private final com.e.a.b.a.a cer;
  int ces;
  com.e.a.c.k<String> cet = new com.e.a.c.k();
  com.e.a.c.k<String> ceu = new com.e.a.c.k();
  
  public h(com.e.a.b.a.a parama)
  {
    this.cer = parama;
  }
  
  private long Bp()
  {
    switch (this.ces)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    case 1: 
      return this.cer.readByte();
    case 2: 
      return this.cer.readShort();
    case 4: 
      return this.cer.readInt();
    }
    return this.cer.readLong();
  }
  
  private void Bq()
  {
    int j = this.cer.readInt();
    int k = this.cer.readInt();
    int m = this.cer.readInt();
    Object localObject = new m[m];
    int i = 0;
    while (i < m)
    {
      l locall = this.ceo;
      long l = Bp();
      localObject[i] = ((m)locall.cfb.ceh.get(l));
      i += 1;
    }
    localObject = new n(j, k, (m[])localObject);
    this.ceo.cfb.cei.d(((n)localObject).cfh, localObject);
  }
  
  private int Br()
  {
    long l = Bp();
    int i = this.cer.readInt();
    Object localObject = this.ceo.gf(i);
    i = this.cer.readInt();
    p localp = p.gj(readUnsignedByte());
    int j = this.ceo.b(localp);
    localObject = new a(l, (n)localObject, localp, i, this.cer.position());
    this.ceo.a(l, (i)localObject);
    i *= j;
    aD(i);
    return i + (this.ces + 4 + 4 + 1);
  }
  
  private int a(k paramk)
  {
    paramk = new j(paramk, Bp());
    this.ceo.a(paramk);
    return this.ces;
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
        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + i + " with " + this.cer.By() + " bytes possibly remaining");
      case 255: 
        paramLong -= a(k.ceJ);
        break;
      case 1: 
        l1 = a(k.ceO);
        Bp();
        paramLong = paramLong - l1 - this.ces;
        break;
      case 2: 
        l1 = Bp();
        i = this.cer.readInt();
        j = this.cer.readInt();
        localObject1 = this.ceo.gg(i);
        localObject1 = this.ceo.bS(((o)localObject1).cfm, j);
        localObject1 = new j(k.ceN, l1, i, (n)localObject1);
        this.ceo.a((j)localObject1);
        paramLong -= this.ces + 4 + 4;
        break;
      case 3: 
        l1 = Bp();
        i = this.cer.readInt();
        j = this.cer.readInt();
        localObject1 = this.ceo.gg(i);
        localObject1 = this.ceo.bS(((o)localObject1).cfm, j);
        localObject1 = new j(k.ceU, l1, i, (n)localObject1);
        this.ceo.a((j)localObject1);
        paramLong -= this.ces + 4 + 4;
        break;
      case 4: 
        l1 = Bp();
        i = this.cer.readInt();
        localObject1 = this.ceo.gg(i);
        localObject1 = this.ceo.gf(((o)localObject1).cfm);
        localObject1 = new j(k.ceV, l1, i, (n)localObject1);
        this.ceo.a((j)localObject1);
        paramLong -= this.ces + 4;
        break;
      case 5: 
        paramLong -= a(k.ceK);
        break;
      case 6: 
        l1 = Bp();
        i = this.cer.readInt();
        localObject1 = this.ceo.gg(i);
        localObject1 = this.ceo.gf(((o)localObject1).cfm);
        localObject1 = new j(k.ceP, l1, i, (n)localObject1);
        this.ceo.a((j)localObject1);
        paramLong -= this.ces + 4;
        break;
      case 7: 
        paramLong -= a(k.ceQ);
        break;
      case 8: 
        l1 = Bp();
        i = this.cer.readInt();
        localObject1 = new o(l1, this.cer.readInt());
        this.ceo.cfb.cek.d(i, localObject1);
        paramLong -= this.ces + 4 + 4;
        break;
      case 32: 
        l1 = Bp();
        i = this.cer.readInt();
        localObject1 = this.ceo.gf(i);
        l2 = Bp();
        long l3 = Bp();
        Bp();
        Bp();
        Bp();
        Bp();
        int k = this.cer.readInt();
        i = this.ces;
        int m = readUnsignedShort();
        j = 0;
        int n;
        for (i = i * 7 + 4 + 4 + 2; j < m; i = n + 1 + 2 + i)
        {
          readUnsignedShort();
          localObject2 = p.gj(readUnsignedByte());
          n = this.ceo.b((p)localObject2);
          aD(n);
          j += 1;
        }
        localObject1 = new c(l1, (n)localObject1, (String)this.ceu.get(l1), this.cer.position());
        ((c)localObject1).cdW = l2;
        ((c)localObject1).cdX = l3;
        m = readUnsignedShort();
        i += 2;
        Object localObject2 = new d[m];
        j = 0;
        while (j < m)
        {
          localObject3 = (String)this.cet.get(Bp());
          p localp = p.gj(this.cer.readByte());
          localObject2[j] = new d(localp, (String)localObject3);
          aD(this.ceo.b(localp));
          i += this.ces + 1 + this.ceo.b(localp);
          j += 1;
        }
        ((c)localObject1).cdZ = ((d[])localObject2);
        m = readUnsignedShort();
        j = i + 2;
        localObject2 = new d[m];
        i = 0;
        while (i < m)
        {
          localObject3 = (String)this.cet.get(Bp());
          localObject2[i] = new d(p.gj(readUnsignedByte()), (String)localObject3);
          j += this.ces + 1;
          i += 1;
        }
        ((c)localObject1).cdY = ((d[])localObject2);
        ((c)localObject1).cea = k;
        localObject2 = this.ceo;
        Object localObject3 = ((l)localObject2).cfb;
        ((g)localObject3).cel.a(l1, localObject1);
        ((g)localObject3).cem.j(((c)localObject1).mClassName, localObject1);
        ((i)localObject1).cex = ((l)localObject2).cfb;
        paramLong -= j;
        break;
      case 33: 
        l1 = Bp();
        i = this.cer.readInt();
        localObject1 = this.ceo.gf(i);
        l2 = Bp();
        i = this.cer.readInt();
        localObject1 = new b(l1, (n)localObject1, this.cer.position());
        ((i)localObject1).cew = l2;
        this.ceo.a(l1, (i)localObject1);
        aD(i);
        paramLong -= this.ces + 4 + this.ces + 4 + i;
        break;
      case 34: 
        l1 = Bp();
        i = this.cer.readInt();
        localObject1 = this.ceo.gf(i);
        i = this.cer.readInt();
        l2 = Bp();
        localObject1 = new a(l1, (n)localObject1, p.cfn, i, this.cer.position());
        ((i)localObject1).cew = l2;
        this.ceo.a(l1, (i)localObject1);
        i = this.ces * i;
        aD(i);
        paramLong -= i + (this.ces + 4 + 4 + this.ces);
        break;
      case 35: 
        paramLong -= Br();
        break;
      case 195: 
        System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
        Br();
        throw new IllegalArgumentException("Don't know how to load a nodata array");
      case 254: 
        i = this.cer.readInt();
        l1 = Bp();
        localObject1 = (String)this.cet.get(l1);
        this.ceo.f(i, (String)localObject1);
        paramLong -= this.ces + 4;
        break;
      case 137: 
        paramLong -= a(k.ceI);
        break;
      case 138: 
        paramLong -= a(k.ceT);
        break;
      case 139: 
        paramLong -= a(k.ceM);
        break;
      case 140: 
        paramLong -= a(k.ceS);
        break;
      case 141: 
        paramLong -= a(k.ceL);
        break;
      case 142: 
        l1 = Bp();
        i = this.cer.readInt();
        j = this.cer.readInt();
        localObject1 = this.ceo.gg(i);
        localObject1 = this.ceo.bS(((o)localObject1).cfm, j);
        localObject1 = new j(k.ceR, l1, i, (n)localObject1);
        this.ceo.a((j)localObject1);
        paramLong -= this.ces + 4 + 4;
        break;
      }
      paramLong -= a(k.ceG);
    }
  }
  
  private void aD(long paramLong)
  {
    this.cer.aG(this.cer.position() + paramLong);
  }
  
  private int readUnsignedByte()
  {
    return this.cer.readByte() & 0xFF;
  }
  
  private int readUnsignedShort()
  {
    return this.cer.readShort() & 0xFFFF;
  }
  
  public final l Bo()
  {
    locall = new l(this.cer);
    this.ceo = locall;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        i = this.cer.readByte();
        if (i != 0)
        {
          localStringBuilder.append((char)i);
          i = this.cer.readByte();
          continue;
        }
        this.ces = this.cer.readInt();
        this.ceo.gi(this.ces);
        this.cer.readLong();
      }
      catch (EOFException localEOFException)
      {
        this.ceo.Bw();
        this.ceo.Bx();
        this.ceu.clear();
        this.cet.clear();
        return locall;
        int i = (int)l;
        int j = this.ces;
        long l = Bp();
        Object localObject = new byte[i - j];
        this.cer.y((byte[])localObject);
        localObject = new String((byte[])localObject, "utf-8");
        this.cet.a(l, localObject);
        continue;
        this.cer.readInt();
        l = Bp();
        this.cer.readInt();
        localObject = (String)this.cet.get(Bp());
        this.ceu.a(l, localObject);
        continue;
        localObject = new m(Bp(), (String)this.cet.get(Bp()), (String)this.cet.get(Bp()), (String)this.cet.get(Bp()), this.cer.readInt(), this.cer.readInt());
        this.ceo.cfb.ceh.a(((m)localObject).MI, localObject);
        continue;
        Bq();
        continue;
        aC(l);
        this.ceo.f(0, "default");
        continue;
        aC(l);
        this.ceo.f(0, "default");
        continue;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!this.cer.hasRemaining()) {
        continue;
      }
      i = readUnsignedByte();
      this.cer.readInt();
      l = this.cer.readInt() & 0xFFFFFFFF;
      switch (i)
      {
      case 1: 
        aD(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.h
 * JD-Core Version:    0.7.0.1
 */