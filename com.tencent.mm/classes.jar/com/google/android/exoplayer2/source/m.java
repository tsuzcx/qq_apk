package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.h.a;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.nio.ByteBuffer;

public final class m
  implements com.google.android.exoplayer2.c.m
{
  private final com.google.android.exoplayer2.i.m cLN;
  private long cUn;
  private final com.google.android.exoplayer2.h.b cZc;
  private final int dai;
  public final l daj;
  private final l.a dak;
  private a dal;
  private a dam;
  private a dan;
  private Format dao;
  private boolean dap;
  private Format daq;
  private long dar;
  public boolean das;
  public b dat;
  
  public m(com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(92696);
    this.cZc = paramb;
    this.dai = paramb.Uh();
    this.daj = new l();
    this.dak = new l.a();
    this.cLN = new com.google.android.exoplayer2.i.m(32);
    this.dal = new a(0L, this.dai);
    this.dam = this.dal;
    this.dan = this.dal;
    AppMethodBeat.o(92696);
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(92706);
    ct(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.dam.cPW - paramLong));
      paramByteBuffer.put(this.dam.dav.data, this.dam.cv(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.dam.cPW)
      {
        this.dam = this.dam.daw;
        paramLong = l;
        paramInt = i;
      }
    }
    AppMethodBeat.o(92706);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92707);
    ct(paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int k = Math.min(i, (int)(this.dam.cPW - paramLong));
      System.arraycopy(this.dam.dav.data, this.dam.cv(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.dam.cPW)
      {
        this.dam = this.dam.daw;
        i = j;
        paramLong = l;
      }
    }
    AppMethodBeat.o(92707);
  }
  
  private void a(e parame, l.a parama)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(92705);
    long l1 = parama.offset;
    this.cLN.iF(1);
    a(l1, this.cLN.data, 1);
    l1 += 1L;
    int m = this.cLN.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (parame.cKP.cKz == null) {
        parame.cKP.cKz = new byte[16];
      }
      a(l1, parame.cKP.cKz, m);
      l1 += m;
      if (i == 0) {
        break label312;
      }
      this.cLN.iF(2);
      a(l1, this.cLN.data, 2);
      j = this.cLN.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label312:
    for (;;)
    {
      localObject2 = parame.cKP.cKA;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = parame.cKP.cKB;
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
      this.cLN.iF(i);
      a(l1, this.cLN.data, i);
      l2 = i;
      this.cLN.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.cLN.readUnsignedShort();
        localObject2[i] = this.cLN.UN();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = parama.cNs;
      parame.cKP.a(j, (int[])localObject1, (int[])localObject2, ((com.google.android.exoplayer2.c.m.a)localObject3).cLH, parame.cKP.cKz, ((com.google.android.exoplayer2.c.m.a)localObject3).cLG, ((com.google.android.exoplayer2.c.m.a)localObject3).cKD, ((com.google.android.exoplayer2.c.m.a)localObject3).cKE);
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
    if (!parama.dau)
    {
      AppMethodBeat.o(92713);
      return;
    }
    if (this.dan.dau) {}
    a[] arrayOfa;
    for (int i = 1;; i = 0)
    {
      arrayOfa = new a[i + (int)(this.dan.cSq - parama.cSq) / this.dai];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = parama.dav;
        parama = parama.Tn();
        i += 1;
      }
    }
    this.cZc.a(arrayOfa);
    AppMethodBeat.o(92713);
  }
  
  private void ct(long paramLong)
  {
    while (paramLong >= this.dam.cPW) {
      this.dam = this.dam.daw;
    }
  }
  
  private void cu(long paramLong)
  {
    AppMethodBeat.i(92708);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(92708);
      return;
    }
    while (paramLong >= this.dal.cPW)
    {
      this.cZc.a(this.dal.dav);
      this.dal = this.dal.Tn();
    }
    if (this.dam.cSq < this.dal.cSq) {
      this.dam = this.dal;
    }
    AppMethodBeat.o(92708);
  }
  
  private int ik(int paramInt)
  {
    AppMethodBeat.i(92714);
    if (!this.dan.dau) {
      this.dan.a(this.cZc.Ug(), new a(this.dan.cPW, this.dai));
    }
    paramInt = Math.min(paramInt, (int)(this.dan.cPW - this.cUn));
    AppMethodBeat.o(92714);
    return paramInt;
  }
  
  private void il(int paramInt)
  {
    this.cUn += paramInt;
    if (this.cUn == this.dan.cPW) {
      this.dan = this.dan.daw;
    }
  }
  
  public final void Tl()
  {
    AppMethodBeat.i(92701);
    cu(this.daj.Tj());
    AppMethodBeat.o(92701);
  }
  
  public final void Tm()
  {
    AppMethodBeat.i(92702);
    cu(this.daj.Tk());
    AppMethodBeat.o(92702);
  }
  
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92710);
    paramInt = ik(paramInt);
    paramInt = paramf.read(this.dan.dav.data, this.dan.cv(this.cUn), paramInt);
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
    il(paramInt);
    AppMethodBeat.o(92710);
    return paramInt;
  }
  
  public final int a(k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(92704);
    switch (this.daj.a(paramk, parame, paramBoolean1, paramBoolean2, this.dao, this.dak))
    {
    default: 
      paramk = new IllegalStateException();
      AppMethodBeat.o(92704);
      throw paramk;
    case -5: 
      this.dao = paramk.cHc;
      AppMethodBeat.o(92704);
      return -5;
    case -4: 
      if (!parame.Ry())
      {
        if (parame.timeUs < paramLong) {
          parame.hp(-2147483648);
        }
        if (parame.RC()) {
          a(parame, this.dak);
        }
        parame.hr(this.dak.size);
        a(this.dak.offset, parame.cKQ, this.dak.size);
      }
      AppMethodBeat.o(92704);
      return -4;
    }
    AppMethodBeat.o(92704);
    return -3;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, com.google.android.exoplayer2.c.m.a parama)
  {
    AppMethodBeat.i(92712);
    if (this.dap) {
      f(this.daq);
    }
    if (this.das)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.daj.cs(paramLong)))
      {
        AppMethodBeat.o(92712);
        return;
      }
      this.das = false;
    }
    long l1 = this.dar;
    long l2 = this.cUn;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.daj.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
    AppMethodBeat.o(92712);
  }
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92711);
    while (paramInt > 0)
    {
      int i = ik(paramInt);
      paramm.readBytes(this.dan.dav.data, this.dan.cv(this.cUn), i);
      paramInt -= i;
      il(i);
    }
    AppMethodBeat.o(92711);
  }
  
  public final void bh()
  {
    AppMethodBeat.i(92699);
    this.daj.bh();
    this.dam = this.dal;
    AppMethodBeat.o(92699);
  }
  
  public final void f(Format paramFormat)
  {
    AppMethodBeat.i(92709);
    long l = this.dar;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.daj.i(localFormat);
      this.daq = paramFormat;
      this.dap = false;
      if ((this.dat != null) && (bool)) {
        this.dat.SX();
      }
      AppMethodBeat.o(92709);
      return;
      if ((l != 0L) && (paramFormat.cGY != 9223372036854775807L)) {
        localFormat = paramFormat.bU(l + paramFormat.cGY);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final boolean k(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92703);
    paramBoolean = this.daj.k(paramLong, paramBoolean);
    AppMethodBeat.o(92703);
    return paramBoolean;
  }
  
  public final void m(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(210367);
    cu(this.daj.l(paramLong, paramBoolean));
    AppMethodBeat.o(210367);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92697);
    this.daj.reset(paramBoolean);
    a(this.dal);
    this.dal = new a(0L, this.dai);
    this.dam = this.dal;
    this.dan = this.dal;
    this.cUn = 0L;
    this.cZc.trim();
    AppMethodBeat.o(92697);
  }
  
  static final class a
  {
    public final long cPW;
    public final long cSq;
    public boolean dau;
    public a dav;
    public a daw;
    
    public a(long paramLong, int paramInt)
    {
      AppMethodBeat.i(92695);
      this.cSq = paramLong;
      this.cPW = (paramInt + paramLong);
      AppMethodBeat.o(92695);
    }
    
    public final a Tn()
    {
      this.dav = null;
      a locala = this.daw;
      this.daw = null;
      return locala;
    }
    
    public final void a(a parama, a parama1)
    {
      this.dav = parama;
      this.daw = parama1;
      this.dau = true;
    }
    
    public final int cv(long paramLong)
    {
      return (int)(paramLong - this.cSq) + this.dav.offset;
    }
  }
  
  public static abstract interface b
  {
    public abstract void SX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.m
 * JD-Core Version:    0.7.0.1
 */