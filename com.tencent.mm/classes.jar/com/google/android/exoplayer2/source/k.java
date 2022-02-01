package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.nio.ByteBuffer;

public final class k
  implements com.google.android.exoplayer2.c.m
{
  private final com.google.android.exoplayer2.i.m biq;
  private long bqV;
  private final com.google.android.exoplayer2.h.b bvM;
  private final int bwM;
  public final j bwN;
  private final j.a bwO;
  private a bwP;
  private a bwQ;
  private a bwR;
  private Format bwS;
  private boolean bwT;
  private Format bwU;
  private long bwV;
  public boolean bwW;
  public b bwX;
  
  public k(com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(92696);
    this.bvM = paramb;
    this.bwM = paramb.wy();
    this.bwN = new j();
    this.bwO = new j.a();
    this.biq = new com.google.android.exoplayer2.i.m(32);
    this.bwP = new a(0L, this.bwM);
    this.bwQ = this.bwP;
    this.bwR = this.bwP;
    AppMethodBeat.o(92696);
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(92706);
    ac(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.bwQ.bmD - paramLong));
      paramByteBuffer.put(this.bwQ.bwZ.data, this.bwQ.ae(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.bwQ.bmD)
      {
        this.bwQ = this.bwQ.bxa;
        paramLong = l;
        paramInt = i;
      }
    }
    AppMethodBeat.o(92706);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92707);
    ac(paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int k = Math.min(i, (int)(this.bwQ.bmD - paramLong));
      System.arraycopy(this.bwQ.bwZ.data, this.bwQ.ae(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.bwQ.bmD)
      {
        this.bwQ = this.bwQ.bxa;
        i = j;
        paramLong = l;
      }
    }
    AppMethodBeat.o(92707);
  }
  
  private void a(e parame, j.a parama)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(92705);
    long l1 = parama.offset;
    this.biq.reset(1);
    a(l1, this.biq.data, 1);
    l1 += 1L;
    int m = this.biq.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (parame.bhs.iv == null) {
        parame.bhs.iv = new byte[16];
      }
      a(l1, parame.bhs.iv, m);
      l1 += m;
      if (i == 0) {
        break label312;
      }
      this.biq.reset(2);
      a(l1, this.biq.data, 2);
      j = this.biq.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label312:
    for (;;)
    {
      localObject2 = parame.bhs.numBytesOfClearData;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = parame.bhs.numBytesOfEncryptedData;
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
      this.biq.reset(i);
      a(l1, this.biq.data, i);
      l2 = i;
      this.biq.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.biq.readUnsignedShort();
        localObject2[i] = this.biq.xc();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = parama.bjV;
      parame.bhs.a(j, (int[])localObject1, (int[])localObject2, ((m.a)localObject3).bik, parame.bhs.iv, ((m.a)localObject3).bij, ((m.a)localObject3).bhg, ((m.a)localObject3).bhh);
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
    if (!parama.bwY)
    {
      AppMethodBeat.o(92713);
      return;
    }
    if (this.bwR.bwY) {}
    a[] arrayOfa;
    for (int i = 1;; i = 0)
    {
      arrayOfa = new a[i + (int)(this.bwR.boX - parama.boX) / this.bwM];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = parama.bwZ;
        parama = parama.vH();
        i += 1;
      }
    }
    this.bvM.a(arrayOfa);
    AppMethodBeat.o(92713);
  }
  
  private void ac(long paramLong)
  {
    while (paramLong >= this.bwQ.bmD) {
      this.bwQ = this.bwQ.bxa;
    }
  }
  
  private void ad(long paramLong)
  {
    AppMethodBeat.i(92708);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(92708);
      return;
    }
    while (paramLong >= this.bwP.bmD)
    {
      this.bvM.a(this.bwP.bwZ);
      this.bwP = this.bwP.vH();
    }
    if (this.bwQ.boX < this.bwP.boX) {
      this.bwQ = this.bwP;
    }
    AppMethodBeat.o(92708);
  }
  
  private int eF(int paramInt)
  {
    AppMethodBeat.i(92714);
    if (!this.bwR.bwY) {
      this.bwR.a(this.bvM.wx(), new a(this.bwR.bmD, this.bwM));
    }
    paramInt = Math.min(paramInt, (int)(this.bwR.bmD - this.bqV));
    AppMethodBeat.o(92714);
    return paramInt;
  }
  
  private void eG(int paramInt)
  {
    this.bqV += paramInt;
    if (this.bqV == this.bwR.bmD) {
      this.bwR = this.bwR.bxa;
    }
  }
  
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92710);
    paramInt = eF(paramInt);
    paramInt = paramf.read(this.bwR.bwZ.data, this.bwR.ae(this.bqV), paramInt);
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
    eG(paramInt);
    AppMethodBeat.o(92710);
    return paramInt;
  }
  
  public final int a(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(92704);
    switch (this.bwN.a(paramk, parame, paramBoolean1, paramBoolean2, this.bwS, this.bwO))
    {
    default: 
      paramk = new IllegalStateException();
      AppMethodBeat.o(92704);
      throw paramk;
    case -5: 
      this.bwS = paramk.bdI;
      AppMethodBeat.o(92704);
      return -5;
    case -4: 
      if (!parame.tY())
      {
        if (parame.timeUs < paramLong) {
          parame.dP(-2147483648);
        }
        if (parame.uc()) {
          a(parame, this.bwO);
        }
        parame.dR(this.bwO.size);
        a(this.bwO.offset, parame.aKX, this.bwO.size);
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
    if (this.bwT) {
      f(this.bwU);
    }
    if (this.bwW)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.bwN.ab(paramLong)))
      {
        AppMethodBeat.o(92712);
        return;
      }
      this.bwW = false;
    }
    long l1 = this.bwV;
    long l2 = this.bqV;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.bwN.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
    AppMethodBeat.o(92712);
  }
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92711);
    while (paramInt > 0)
    {
      int i = eF(paramInt);
      paramm.readBytes(this.bwR.bwZ.data, this.bwR.ae(this.bqV), i);
      paramInt -= i;
      eG(i);
    }
    AppMethodBeat.o(92711);
  }
  
  public final void f(Format paramFormat)
  {
    AppMethodBeat.i(92709);
    long l = this.bwV;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.bwN.i(localFormat);
      this.bwU = paramFormat;
      this.bwT = false;
      if ((this.bwX != null) && (bool)) {
        this.bwX.vq();
      }
      AppMethodBeat.o(92709);
      return;
      if ((l != 0L) && (paramFormat.bdF != 9223372036854775807L)) {
        localFormat = paramFormat.D(l + paramFormat.bdF);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final boolean f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92703);
    paramBoolean = this.bwN.f(paramLong, paramBoolean);
    AppMethodBeat.o(92703);
    return paramBoolean;
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(217123);
    ad(this.bwN.g(paramLong, paramBoolean));
    AppMethodBeat.o(217123);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92697);
    this.bwN.reset(paramBoolean);
    a(this.bwP);
    this.bwP = new a(0L, this.bwM);
    this.bwQ = this.bwP;
    this.bwR = this.bwP;
    this.bqV = 0L;
    this.bvM.trim();
    AppMethodBeat.o(92697);
  }
  
  public final void rewind()
  {
    AppMethodBeat.i(92699);
    this.bwN.rewind();
    this.bwQ = this.bwP;
    AppMethodBeat.o(92699);
  }
  
  public final void vF()
  {
    AppMethodBeat.i(92701);
    ad(this.bwN.vD());
    AppMethodBeat.o(92701);
  }
  
  public final void vG()
  {
    AppMethodBeat.i(92702);
    ad(this.bwN.vE());
    AppMethodBeat.o(92702);
  }
  
  static final class a
  {
    public final long bmD;
    public final long boX;
    public boolean bwY;
    public a bwZ;
    public a bxa;
    
    public a(long paramLong, int paramInt)
    {
      AppMethodBeat.i(92695);
      this.boX = paramLong;
      this.bmD = (paramInt + paramLong);
      AppMethodBeat.o(92695);
    }
    
    public final void a(a parama, a parama1)
    {
      this.bwZ = parama;
      this.bxa = parama1;
      this.bwY = true;
    }
    
    public final int ae(long paramLong)
    {
      return (int)(paramLong - this.boX) + this.bwZ.offset;
    }
    
    public final a vH()
    {
      this.bwZ = null;
      a locala = this.bxa;
      this.bxa = null;
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void vq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */