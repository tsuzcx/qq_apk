package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.k.a;
import com.google.android.exoplayer2.h.a;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.i.j;
import java.io.EOFException;

public final class h
  implements k
{
  public long aDL;
  public final b aIC;
  public final int aID;
  public final g aIE;
  public final g.a aIF;
  public a aIG;
  public a aIH;
  public a aII;
  public Format aIJ;
  private boolean aIK;
  private Format aIL;
  private long aIM;
  public boolean aIN;
  public h.b aIO;
  public final j azv;
  
  public h(b paramb)
  {
    this.aIC = paramb;
    this.aID = paramb.nO();
    this.aIE = new g();
    this.aIF = new g.a();
    this.azv = new j(32);
    this.aIG = new a(0L, this.aID);
    this.aIH = this.aIG;
    this.aII = this.aIG;
  }
  
  private int dk(int paramInt)
  {
    if (!this.aII.aIQ)
    {
      a locala1 = this.aII;
      a locala = this.aIC.nM();
      a locala2 = new a(this.aII.aBz, this.aID);
      locala1.aIR = locala;
      locala1.aIS = locala2;
      locala1.aIQ = true;
    }
    return Math.min(paramInt, (int)(this.aII.aBz - this.aDL));
  }
  
  private void dl(int paramInt)
  {
    this.aDL += paramInt;
    if (this.aDL == this.aII.aBz) {
      this.aII = this.aII.aIS;
    }
  }
  
  public final void N(long paramLong)
  {
    while (paramLong >= this.aIH.aBz) {
      this.aIH = this.aIH.aIS;
    }
  }
  
  public final void O(long paramLong)
  {
    if (paramLong == -1L) {}
    do
    {
      return;
      while (paramLong >= this.aIG.aBz)
      {
        this.aIC.a(this.aIG.aIR);
        this.aIG = this.aIG.mO();
      }
    } while (this.aIH.aIP >= this.aIG.aIP);
    this.aIH = this.aIG;
  }
  
  public final int a(e parame, int paramInt, boolean paramBoolean)
  {
    paramInt = dk(paramInt);
    paramInt = parame.read(this.aII.aIR.data, this.aII.P(this.aDL), paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    dl(paramInt);
    return paramInt;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, k.a parama)
  {
    if (this.aIK) {
      f(this.aIL);
    }
    if (this.aIN)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.aIE.M(paramLong))) {
        return;
      }
      this.aIN = false;
    }
    long l1 = this.aIM;
    long l2 = this.aDL;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.aIE.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
  }
  
  public final void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    N(paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int k = Math.min(i, (int)(this.aIH.aBz - paramLong));
      System.arraycopy(this.aIH.aIR.data, this.aIH.P(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.aIH.aBz)
      {
        this.aIH = this.aIH.aIS;
        i = j;
        paramLong = l;
      }
    }
  }
  
  public final void a(j paramj, int paramInt)
  {
    while (paramInt > 0)
    {
      int i = dk(paramInt);
      paramj.readBytes(this.aII.aIR.data, this.aII.P(this.aDL), i);
      paramInt -= i;
      dl(i);
    }
  }
  
  public final boolean e(long paramLong, boolean paramBoolean)
  {
    return this.aIE.e(paramLong, paramBoolean);
  }
  
  public final void f(Format paramFormat)
  {
    long l = this.aIM;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.aIE.i(localFormat);
      this.aIL = paramFormat;
      this.aIK = false;
      if ((this.aIO != null) && (bool)) {
        this.aIO.mP();
      }
      return;
      if ((l != 0L) && (paramFormat.auG != 9223372036854775807L)) {
        localFormat = paramFormat.x(l + paramFormat.auG);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final void mN()
  {
    O(this.aIE.mM());
  }
  
  public final void rewind()
  {
    this.aIE.rewind();
    this.aIH = this.aIG;
  }
  
  private static final class a
  {
    public final long aBz;
    public final long aIP;
    public boolean aIQ;
    public a aIR;
    public a aIS;
    
    public a(long paramLong, int paramInt)
    {
      this.aIP = paramLong;
      this.aBz = (paramInt + paramLong);
    }
    
    public final int P(long paramLong)
    {
      return (int)(paramLong - this.aIP) + this.aIR.offset;
    }
    
    public final a mO()
    {
      this.aIR = null;
      a locala = this.aIS;
      this.aIS = null;
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.h
 * JD-Core Version:    0.7.0.1
 */