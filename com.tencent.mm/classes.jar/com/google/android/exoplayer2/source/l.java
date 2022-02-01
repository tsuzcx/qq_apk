package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.nio.ByteBuffer;

public final class l
  implements com.google.android.exoplayer2.c.m
{
  private final com.google.android.exoplayer2.i.m aXj;
  private long bfV;
  private final com.google.android.exoplayer2.h.b bkM;
  private final int blM;
  public final k blN;
  private final k.a blO;
  private a blP;
  private a blQ;
  private a blR;
  private Format blS;
  public boolean blT;
  private Format blU;
  public long blV;
  public boolean blW;
  public b blX;
  
  public l(com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(92696);
    this.bkM = paramb;
    this.blM = paramb.vf();
    this.blN = new k();
    this.blO = new k.a();
    this.aXj = new com.google.android.exoplayer2.i.m(32);
    this.blP = new a(0L, this.blM);
    this.blQ = this.blP;
    this.blR = this.blP;
    AppMethodBeat.o(92696);
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(92706);
    ab(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.blQ.bbw - paramLong));
      paramByteBuffer.put(this.blQ.blZ.data, this.blQ.ad(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.blQ.bbw)
      {
        this.blQ = this.blQ.bma;
        paramLong = l;
        paramInt = i;
      }
    }
    AppMethodBeat.o(92706);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92707);
    ab(paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int k = Math.min(i, (int)(this.blQ.bbw - paramLong));
      System.arraycopy(this.blQ.blZ.data, this.blQ.ad(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.blQ.bbw)
      {
        this.blQ = this.blQ.bma;
        i = j;
        paramLong = l;
      }
    }
    AppMethodBeat.o(92707);
  }
  
  private void a(e parame, k.a parama)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(92705);
    long l1 = parama.offset;
    this.aXj.reset(1);
    a(l1, this.aXj.data, 1);
    l1 += 1L;
    int m = this.aXj.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (parame.aWk.iv == null) {
        parame.aWk.iv = new byte[16];
      }
      a(l1, parame.aWk.iv, m);
      l1 += m;
      if (i == 0) {
        break label312;
      }
      this.aXj.reset(2);
      a(l1, this.aXj.data, 2);
      j = this.aXj.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label312:
    for (;;)
    {
      localObject2 = parame.aWk.numBytesOfClearData;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = parame.aWk.numBytesOfEncryptedData;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (localObject3.length >= j) {}
      }
      else
      {
        localObject2 = new int[j];
      }
      if (i == 0) {
        break label404;
      }
      i = j * 6;
      this.aXj.reset(i);
      a(l1, this.aXj.data, i);
      l2 = i;
      this.aXj.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.aXj.readUnsignedShort();
        localObject2[i] = this.aXj.vQ();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = parama.aYO;
      parame.aWk.a(j, (int[])localObject1, (int[])localObject2, ((m.a)localObject3).aXd, parame.aWk.iv, ((m.a)localObject3).aXc, ((m.a)localObject3).aVY, ((m.a)localObject3).aVZ);
      i = (int)(l1 - parama.offset);
      parama.offset += i;
      parama.size -= i;
      AppMethodBeat.o(92705);
      return;
      label404:
      localObject1[0] = 0;
      localObject2[0] = (parama.size - (int)(l1 - parama.offset));
    }
  }
  
  private void a(a parama)
  {
    int j = 0;
    AppMethodBeat.i(92713);
    if (!parama.blY)
    {
      AppMethodBeat.o(92713);
      return;
    }
    if (this.blR.blY) {}
    a[] arrayOfa;
    for (int i = 1;; i = 0)
    {
      arrayOfa = new a[i + (int)(this.blR.bdQ - parama.bdQ) / this.blM];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = parama.blZ;
        parama = parama.ua();
        i += 1;
      }
    }
    this.bkM.a(arrayOfa);
    AppMethodBeat.o(92713);
  }
  
  private void ab(long paramLong)
  {
    while (paramLong >= this.blQ.bbw) {
      this.blQ = this.blQ.bma;
    }
  }
  
  private void ac(long paramLong)
  {
    AppMethodBeat.i(92708);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(92708);
      return;
    }
    while (paramLong >= this.blP.bbw)
    {
      this.bkM.a(this.blP.blZ);
      this.blP = this.blP.ua();
    }
    if (this.blQ.bdQ < this.blP.bdQ) {
      this.blQ = this.blP;
    }
    AppMethodBeat.o(92708);
  }
  
  private int eD(int paramInt)
  {
    AppMethodBeat.i(92714);
    if (!this.blR.blY) {
      this.blR.a(this.bkM.ve(), new a(this.blR.bbw, this.blM));
    }
    paramInt = Math.min(paramInt, (int)(this.blR.bbw - this.bfV));
    AppMethodBeat.o(92714);
    return paramInt;
  }
  
  private void eE(int paramInt)
  {
    this.bfV += paramInt;
    if (this.bfV == this.blR.bbw) {
      this.blR = this.blR.bma;
    }
  }
  
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92710);
    paramInt = eD(paramInt);
    paramInt = paramf.read(this.blR.blZ.data, this.blR.ad(this.bfV), paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92710);
        return -1;
      }
      paramf = new EOFException();
      AppMethodBeat.o(92710);
      throw paramf;
    }
    eE(paramInt);
    AppMethodBeat.o(92710);
    return paramInt;
  }
  
  public final int a(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(92704);
    switch (this.blN.a(paramk, parame, paramBoolean1, paramBoolean2, this.blS, this.blO))
    {
    default: 
      paramk = new IllegalStateException();
      AppMethodBeat.o(92704);
      throw paramk;
    case -5: 
      this.blS = paramk.aSv;
      AppMethodBeat.o(92704);
      return -5;
    case -4: 
      if (!parame.sq())
      {
        if (parame.timeUs < paramLong) {
          parame.dM(-2147483648);
        }
        if (parame.su()) {
          a(parame, this.blO);
        }
        parame.dO(this.blO.size);
        a(this.blO.offset, parame.aIq, this.blO.size);
      }
      AppMethodBeat.o(92704);
      return -4;
    }
    AppMethodBeat.o(92704);
    return -3;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, m.a parama)
  {
    AppMethodBeat.i(92712);
    if (this.blT) {
      f(this.blU);
    }
    if (this.blW)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.blN.aa(paramLong)))
      {
        AppMethodBeat.o(92712);
        return;
      }
      this.blW = false;
    }
    long l1 = this.blV;
    long l2 = this.bfV;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.blN.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
    AppMethodBeat.o(92712);
  }
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92711);
    while (paramInt > 0)
    {
      int i = eD(paramInt);
      paramm.readBytes(this.blR.blZ.data, this.blR.ad(this.bfV), i);
      paramInt -= i;
      eE(i);
    }
    AppMethodBeat.o(92711);
  }
  
  public final void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92700);
    ac(this.blN.a(paramLong, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(92700);
  }
  
  public final void eC(int paramInt)
  {
    AppMethodBeat.i(92698);
    this.bfV = this.blN.ey(paramInt);
    if ((this.bfV == 0L) || (this.bfV == this.blP.bdQ))
    {
      a(this.blP);
      this.blP = new a(this.bfV, this.blM);
      this.blQ = this.blP;
      this.blR = this.blP;
      AppMethodBeat.o(92698);
      return;
    }
    for (a locala1 = this.blP; this.bfV > locala1.bbw; locala1 = locala1.bma) {}
    a locala3 = locala1.bma;
    a(locala3);
    locala1.bma = new a(locala1.bbw, this.blM);
    if (this.bfV == locala1.bbw) {}
    for (a locala2 = locala1.bma;; locala2 = locala1)
    {
      this.blR = locala2;
      if (this.blQ == locala3) {
        this.blQ = locala1.bma;
      }
      AppMethodBeat.o(92698);
      return;
    }
  }
  
  public final void f(Format paramFormat)
  {
    AppMethodBeat.i(92709);
    long l = this.blV;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.blN.i(localFormat);
      this.blU = paramFormat;
      this.blT = false;
      if ((this.blX != null) && (bool)) {
        this.blX.tJ();
      }
      AppMethodBeat.o(92709);
      return;
      if ((l != 0L) && (paramFormat.aSr != 9223372036854775807L)) {
        localFormat = paramFormat.B(l + paramFormat.aSr);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final boolean f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92703);
    paramBoolean = this.blN.f(paramLong, paramBoolean);
    AppMethodBeat.o(92703);
    return paramBoolean;
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92697);
    this.blN.reset(paramBoolean);
    a(this.blP);
    this.blP = new a(0L, this.blM);
    this.blQ = this.blP;
    this.blR = this.blP;
    this.bfV = 0L;
    this.bkM.trim();
    AppMethodBeat.o(92697);
  }
  
  public final void rewind()
  {
    AppMethodBeat.i(92699);
    this.blN.rewind();
    this.blQ = this.blP;
    AppMethodBeat.o(92699);
  }
  
  public final void tY()
  {
    AppMethodBeat.i(92701);
    ac(this.blN.tW());
    AppMethodBeat.o(92701);
  }
  
  public final void tZ()
  {
    AppMethodBeat.i(92702);
    ac(this.blN.tX());
    AppMethodBeat.o(92702);
  }
  
  static final class a
  {
    public final long bbw;
    public final long bdQ;
    public boolean blY;
    public a blZ;
    public a bma;
    
    public a(long paramLong, int paramInt)
    {
      AppMethodBeat.i(92695);
      this.bdQ = paramLong;
      this.bbw = (paramInt + paramLong);
      AppMethodBeat.o(92695);
    }
    
    public final void a(a parama, a parama1)
    {
      this.blZ = parama;
      this.bma = parama1;
      this.blY = true;
    }
    
    public final int ad(long paramLong)
    {
      return (int)(paramLong - this.bdQ) + this.blZ.offset;
    }
    
    public final a ua()
    {
      this.blZ = null;
      a locala = this.bma;
      this.bma = null;
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void tJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.l
 * JD-Core Version:    0.7.0.1
 */