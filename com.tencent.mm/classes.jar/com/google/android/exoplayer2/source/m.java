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
  private final com.google.android.exoplayer2.i.m bin;
  private long bqQ;
  private final com.google.android.exoplayer2.h.b bvH;
  private final int bwN;
  public final l bwO;
  private final l.a bwP;
  private a bwQ;
  private a bwR;
  private a bwS;
  private Format bwT;
  private boolean bwU;
  private Format bwV;
  private long bwW;
  public boolean bwX;
  public b bwY;
  
  public m(com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(92696);
    this.bvH = paramb;
    this.bwN = paramb.wD();
    this.bwO = new l();
    this.bwP = new l.a();
    this.bin = new com.google.android.exoplayer2.i.m(32);
    this.bwQ = new a(0L, this.bwN);
    this.bwR = this.bwQ;
    this.bwS = this.bwQ;
    AppMethodBeat.o(92696);
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(92706);
    ac(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.bwR.bmy - paramLong));
      paramByteBuffer.put(this.bwR.bxa.data, this.bwR.ae(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.bwR.bmy)
      {
        this.bwR = this.bwR.bxb;
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
      int k = Math.min(i, (int)(this.bwR.bmy - paramLong));
      System.arraycopy(this.bwR.bxa.data, this.bwR.ae(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.bwR.bmy)
      {
        this.bwR = this.bwR.bxb;
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
    this.bin.reset(1);
    a(l1, this.bin.data, 1);
    l1 += 1L;
    int m = this.bin.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (parame.bhp.iv == null) {
        parame.bhp.iv = new byte[16];
      }
      a(l1, parame.bhp.iv, m);
      l1 += m;
      if (i == 0) {
        break label312;
      }
      this.bin.reset(2);
      a(l1, this.bin.data, 2);
      j = this.bin.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label312:
    for (;;)
    {
      localObject2 = parame.bhp.numBytesOfClearData;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = parame.bhp.numBytesOfEncryptedData;
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
      this.bin.reset(i);
      a(l1, this.bin.data, i);
      l2 = i;
      this.bin.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.bin.readUnsignedShort();
        localObject2[i] = this.bin.xk();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = parama.bjS;
      parame.bhp.a(j, (int[])localObject1, (int[])localObject2, ((com.google.android.exoplayer2.c.m.a)localObject3).bih, parame.bhp.iv, ((com.google.android.exoplayer2.c.m.a)localObject3).big, ((com.google.android.exoplayer2.c.m.a)localObject3).bhd, ((com.google.android.exoplayer2.c.m.a)localObject3).bhe);
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
    if (!parama.bwZ)
    {
      AppMethodBeat.o(92713);
      return;
    }
    if (this.bwS.bwZ) {}
    a[] arrayOfa;
    for (int i = 1;; i = 0)
    {
      arrayOfa = new a[i + (int)(this.bwS.boS - parama.boS) / this.bwN];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = parama.bxa;
        parama = parama.vM();
        i += 1;
      }
    }
    this.bvH.a(arrayOfa);
    AppMethodBeat.o(92713);
  }
  
  private void ac(long paramLong)
  {
    while (paramLong >= this.bwR.bmy) {
      this.bwR = this.bwR.bxb;
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
    while (paramLong >= this.bwQ.bmy)
    {
      this.bvH.a(this.bwQ.bxa);
      this.bwQ = this.bwQ.vM();
    }
    if (this.bwR.boS < this.bwQ.boS) {
      this.bwR = this.bwQ;
    }
    AppMethodBeat.o(92708);
  }
  
  private int eE(int paramInt)
  {
    AppMethodBeat.i(92714);
    if (!this.bwS.bwZ) {
      this.bwS.a(this.bvH.wC(), new a(this.bwS.bmy, this.bwN));
    }
    paramInt = Math.min(paramInt, (int)(this.bwS.bmy - this.bqQ));
    AppMethodBeat.o(92714);
    return paramInt;
  }
  
  private void eF(int paramInt)
  {
    this.bqQ += paramInt;
    if (this.bqQ == this.bwS.bmy) {
      this.bwS = this.bwS.bxb;
    }
  }
  
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92710);
    paramInt = eE(paramInt);
    paramInt = paramf.read(this.bwS.bxa.data, this.bwS.ae(this.bqQ), paramInt);
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
    eF(paramInt);
    AppMethodBeat.o(92710);
    return paramInt;
  }
  
  public final int a(k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(92704);
    switch (this.bwO.a(paramk, parame, paramBoolean1, paramBoolean2, this.bwT, this.bwP))
    {
    default: 
      paramk = new IllegalStateException();
      AppMethodBeat.o(92704);
      throw paramk;
    case -5: 
      this.bwT = paramk.bdF;
      AppMethodBeat.o(92704);
      return -5;
    case -4: 
      if (!parame.ud())
      {
        if (parame.timeUs < paramLong) {
          parame.dK(-2147483648);
        }
        if (parame.uh()) {
          a(parame, this.bwP);
        }
        parame.dM(this.bwP.size);
        a(this.bwP.offset, parame.aKP, this.bwP.size);
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
    if (this.bwU) {
      f(this.bwV);
    }
    if (this.bwX)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.bwO.ab(paramLong)))
      {
        AppMethodBeat.o(92712);
        return;
      }
      this.bwX = false;
    }
    long l1 = this.bwW;
    long l2 = this.bqQ;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.bwO.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
    AppMethodBeat.o(92712);
  }
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92711);
    while (paramInt > 0)
    {
      int i = eE(paramInt);
      paramm.readBytes(this.bwS.bxa.data, this.bwS.ae(this.bqQ), i);
      paramInt -= i;
      eF(i);
    }
    AppMethodBeat.o(92711);
  }
  
  public final void f(Format paramFormat)
  {
    AppMethodBeat.i(92709);
    long l = this.bwW;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.bwO.i(localFormat);
      this.bwV = paramFormat;
      this.bwU = false;
      if ((this.bwY != null) && (bool)) {
        this.bwY.vw();
      }
      AppMethodBeat.o(92709);
      return;
      if ((l != 0L) && (paramFormat.bdC != 9223372036854775807L)) {
        localFormat = paramFormat.D(l + paramFormat.bdC);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final boolean f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92703);
    paramBoolean = this.bwO.f(paramLong, paramBoolean);
    AppMethodBeat.o(92703);
    return paramBoolean;
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(196061);
    ad(this.bwO.g(paramLong, paramBoolean));
    AppMethodBeat.o(196061);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92697);
    this.bwO.reset(paramBoolean);
    a(this.bwQ);
    this.bwQ = new a(0L, this.bwN);
    this.bwR = this.bwQ;
    this.bwS = this.bwQ;
    this.bqQ = 0L;
    this.bvH.trim();
    AppMethodBeat.o(92697);
  }
  
  public final void rewind()
  {
    AppMethodBeat.i(92699);
    this.bwO.rewind();
    this.bwR = this.bwQ;
    AppMethodBeat.o(92699);
  }
  
  public final void vK()
  {
    AppMethodBeat.i(92701);
    ad(this.bwO.vI());
    AppMethodBeat.o(92701);
  }
  
  public final void vL()
  {
    AppMethodBeat.i(92702);
    ad(this.bwO.vJ());
    AppMethodBeat.o(92702);
  }
  
  static final class a
  {
    public final long bmy;
    public final long boS;
    public boolean bwZ;
    public a bxa;
    public a bxb;
    
    public a(long paramLong, int paramInt)
    {
      AppMethodBeat.i(92695);
      this.boS = paramLong;
      this.bmy = (paramInt + paramLong);
      AppMethodBeat.o(92695);
    }
    
    public final void a(a parama, a parama1)
    {
      this.bxa = parama;
      this.bxb = parama1;
      this.bwZ = true;
    }
    
    public final int ae(long paramLong)
    {
      return (int)(paramLong - this.boS) + this.bxa.offset;
    }
    
    public final a vM()
    {
      this.bxa = null;
      a locala = this.bxb;
      this.bxb = null;
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void vw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.m
 * JD-Core Version:    0.7.0.1
 */