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
  private final com.google.android.exoplayer2.i.m aRR;
  private long bas;
  private final com.google.android.exoplayer2.h.b bfj;
  public b bgA;
  private final int bgp;
  public final l bgq;
  private final l.a bgr;
  private a bgs;
  private a bgt;
  private a bgu;
  private Format bgv;
  private boolean bgw;
  private Format bgx;
  private long bgy;
  public boolean bgz;
  
  public m(com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(92696);
    this.bfj = paramb;
    this.bgp = paramb.uE();
    this.bgq = new l();
    this.bgr = new l.a();
    this.aRR = new com.google.android.exoplayer2.i.m(32);
    this.bgs = new a(0L, this.bgp);
    this.bgt = this.bgs;
    this.bgu = this.bgs;
    AppMethodBeat.o(92696);
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(92706);
    af(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.bgt.aWa - paramLong));
      paramByteBuffer.put(this.bgt.bgC.data, this.bgt.ah(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.bgt.aWa)
      {
        this.bgt = this.bgt.bgD;
        paramLong = l;
        paramInt = i;
      }
    }
    AppMethodBeat.o(92706);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92707);
    af(paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int k = Math.min(i, (int)(this.bgt.aWa - paramLong));
      System.arraycopy(this.bgt.bgC.data, this.bgt.ah(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.bgt.aWa)
      {
        this.bgt = this.bgt.bgD;
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
    this.aRR.fs(1);
    a(l1, this.aRR.data, 1);
    l1 += 1L;
    int m = this.aRR.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (parame.aQT.aQD == null) {
        parame.aQT.aQD = new byte[16];
      }
      a(l1, parame.aQT.aQD, m);
      l1 += m;
      if (i == 0) {
        break label312;
      }
      this.aRR.fs(2);
      a(l1, this.aRR.data, 2);
      j = this.aRR.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label312:
    for (;;)
    {
      localObject2 = parame.aQT.aQE;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = parame.aQT.aQF;
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
      this.aRR.fs(i);
      a(l1, this.aRR.data, i);
      l2 = i;
      this.aRR.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.aRR.readUnsignedShort();
        localObject2[i] = this.aRR.vo();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = parama.aTw;
      parame.aQT.a(j, (int[])localObject1, (int[])localObject2, ((com.google.android.exoplayer2.c.m.a)localObject3).aRL, parame.aQT.aQD, ((com.google.android.exoplayer2.c.m.a)localObject3).aRK, ((com.google.android.exoplayer2.c.m.a)localObject3).aQH, ((com.google.android.exoplayer2.c.m.a)localObject3).aQI);
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
    if (!parama.bgB)
    {
      AppMethodBeat.o(92713);
      return;
    }
    if (this.bgu.bgB) {}
    a[] arrayOfa;
    for (int i = 1;; i = 0)
    {
      arrayOfa = new a[i + (int)(this.bgu.aYu - parama.aYu) / this.bgp];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = parama.bgC;
        parama = parama.tK();
        i += 1;
      }
    }
    this.bfj.a(arrayOfa);
    AppMethodBeat.o(92713);
  }
  
  private void af(long paramLong)
  {
    while (paramLong >= this.bgt.aWa) {
      this.bgt = this.bgt.bgD;
    }
  }
  
  private void ag(long paramLong)
  {
    AppMethodBeat.i(92708);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(92708);
      return;
    }
    while (paramLong >= this.bgs.aWa)
    {
      this.bfj.a(this.bgs.bgC);
      this.bgs = this.bgs.tK();
    }
    if (this.bgt.aYu < this.bgs.aYu) {
      this.bgt = this.bgs;
    }
    AppMethodBeat.o(92708);
  }
  
  private int eU(int paramInt)
  {
    AppMethodBeat.i(92714);
    if (!this.bgu.bgB) {
      this.bgu.a(this.bfj.uD(), new a(this.bgu.aWa, this.bgp));
    }
    paramInt = Math.min(paramInt, (int)(this.bgu.aWa - this.bas));
    AppMethodBeat.o(92714);
    return paramInt;
  }
  
  private void eV(int paramInt)
  {
    this.bas += paramInt;
    if (this.bas == this.bgu.aWa) {
      this.bgu = this.bgu.bgD;
    }
  }
  
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92710);
    paramInt = eU(paramInt);
    paramInt = paramf.read(this.bgu.bgC.data, this.bgu.ah(this.bas), paramInt);
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
    eV(paramInt);
    AppMethodBeat.o(92710);
    return paramInt;
  }
  
  public final int a(k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(92704);
    switch (this.bgq.a(paramk, parame, paramBoolean1, paramBoolean2, this.bgv, this.bgr))
    {
    default: 
      paramk = new IllegalStateException();
      AppMethodBeat.o(92704);
      throw paramk;
    case -5: 
      this.bgv = paramk.aNg;
      AppMethodBeat.o(92704);
      return -5;
    case -4: 
      if (!parame.rV())
      {
        if (parame.timeUs < paramLong) {
          parame.dY(-2147483648);
        }
        if (parame.rZ()) {
          a(parame, this.bgr);
        }
        parame.ea(this.bgr.size);
        a(this.bgr.offset, parame.aQU, this.bgr.size);
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
    if (this.bgw) {
      f(this.bgx);
    }
    if (this.bgz)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.bgq.ae(paramLong)))
      {
        AppMethodBeat.o(92712);
        return;
      }
      this.bgz = false;
    }
    long l1 = this.bgy;
    long l2 = this.bas;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.bgq.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
    AppMethodBeat.o(92712);
  }
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92711);
    while (paramInt > 0)
    {
      int i = eU(paramInt);
      paramm.readBytes(this.bgu.bgC.data, this.bgu.ah(this.bas), i);
      paramInt -= i;
      eV(i);
    }
    AppMethodBeat.o(92711);
  }
  
  public final void ax()
  {
    AppMethodBeat.i(92699);
    this.bgq.ax();
    this.bgt = this.bgs;
    AppMethodBeat.o(92699);
  }
  
  public final void f(Format paramFormat)
  {
    AppMethodBeat.i(92709);
    long l = this.bgy;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.bgq.i(localFormat);
      this.bgx = paramFormat;
      this.bgw = false;
      if ((this.bgA != null) && (bool)) {
        this.bgA.tu();
      }
      AppMethodBeat.o(92709);
      return;
      if ((l != 0L) && (paramFormat.aNc != 9223372036854775807L)) {
        localFormat = paramFormat.G(l + paramFormat.aNc);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final boolean f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92703);
    paramBoolean = this.bgq.f(paramLong, paramBoolean);
    AppMethodBeat.o(92703);
    return paramBoolean;
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(196509);
    ag(this.bgq.g(paramLong, paramBoolean));
    AppMethodBeat.o(196509);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92697);
    this.bgq.reset(paramBoolean);
    a(this.bgs);
    this.bgs = new a(0L, this.bgp);
    this.bgt = this.bgs;
    this.bgu = this.bgs;
    this.bas = 0L;
    this.bfj.trim();
    AppMethodBeat.o(92697);
  }
  
  public final void tI()
  {
    AppMethodBeat.i(92701);
    ag(this.bgq.tG());
    AppMethodBeat.o(92701);
  }
  
  public final void tJ()
  {
    AppMethodBeat.i(92702);
    ag(this.bgq.tH());
    AppMethodBeat.o(92702);
  }
  
  static final class a
  {
    public final long aWa;
    public final long aYu;
    public boolean bgB;
    public a bgC;
    public a bgD;
    
    public a(long paramLong, int paramInt)
    {
      AppMethodBeat.i(92695);
      this.aYu = paramLong;
      this.aWa = (paramInt + paramLong);
      AppMethodBeat.o(92695);
    }
    
    public final void a(a parama, a parama1)
    {
      this.bgC = parama;
      this.bgD = parama1;
      this.bgB = true;
    }
    
    public final int ah(long paramLong)
    {
      return (int)(paramLong - this.aYu) + this.bgC.offset;
    }
    
    public final a tK()
    {
      this.bgC = null;
      a locala = this.bgD;
      this.bgD = null;
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void tu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.m
 * JD-Core Version:    0.7.0.1
 */