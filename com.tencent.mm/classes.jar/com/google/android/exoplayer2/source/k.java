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
  private final com.google.android.exoplayer2.i.m aXV;
  private long bgB;
  private final com.google.android.exoplayer2.h.b blr;
  private long bmA;
  public boolean bmB;
  public b bmC;
  private final int bmr;
  public final j bms;
  private final j.a bmt;
  private a bmu;
  private a bmv;
  private a bmw;
  private Format bmx;
  private boolean bmy;
  private Format bmz;
  
  public k(com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(92696);
    this.blr = paramb;
    this.bmr = paramb.uZ();
    this.bms = new j();
    this.bmt = new j.a();
    this.aXV = new com.google.android.exoplayer2.i.m(32);
    this.bmu = new a(0L, this.bmr);
    this.bmv = this.bmu;
    this.bmw = this.bmu;
    AppMethodBeat.o(92696);
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(92706);
    ac(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.bmv.bci - paramLong));
      paramByteBuffer.put(this.bmv.bmE.data, this.bmv.ae(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.bmv.bci)
      {
        this.bmv = this.bmv.bmF;
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
      int k = Math.min(i, (int)(this.bmv.bci - paramLong));
      System.arraycopy(this.bmv.bmE.data, this.bmv.ae(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.bmv.bci)
      {
        this.bmv = this.bmv.bmF;
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
    this.aXV.reset(1);
    a(l1, this.aXV.data, 1);
    l1 += 1L;
    int m = this.aXV.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (parame.aWX.iv == null) {
        parame.aWX.iv = new byte[16];
      }
      a(l1, parame.aWX.iv, m);
      l1 += m;
      if (i == 0) {
        break label312;
      }
      this.aXV.reset(2);
      a(l1, this.aXV.data, 2);
      j = this.aXV.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label312:
    for (;;)
    {
      localObject2 = parame.aWX.numBytesOfClearData;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = parame.aWX.numBytesOfEncryptedData;
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
      this.aXV.reset(i);
      a(l1, this.aXV.data, i);
      l2 = i;
      this.aXV.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.aXV.readUnsignedShort();
        localObject2[i] = this.aXV.vF();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = parama.aZA;
      parame.aWX.a(j, (int[])localObject1, (int[])localObject2, ((m.a)localObject3).aXP, parame.aWX.iv, ((m.a)localObject3).aXO, ((m.a)localObject3).aWL, ((m.a)localObject3).aWM);
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
    if (!parama.bmD)
    {
      AppMethodBeat.o(92713);
      return;
    }
    if (this.bmw.bmD) {}
    a[] arrayOfa;
    for (int i = 1;; i = 0)
    {
      arrayOfa = new a[i + (int)(this.bmw.beC - parama.beC) / this.bmr];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = parama.bmE;
        parama = parama.ui();
        i += 1;
      }
    }
    this.blr.a(arrayOfa);
    AppMethodBeat.o(92713);
  }
  
  private void ac(long paramLong)
  {
    while (paramLong >= this.bmv.bci) {
      this.bmv = this.bmv.bmF;
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
    while (paramLong >= this.bmu.bci)
    {
      this.blr.a(this.bmu.bmE);
      this.bmu = this.bmu.ui();
    }
    if (this.bmv.beC < this.bmu.beC) {
      this.bmv = this.bmu;
    }
    AppMethodBeat.o(92708);
  }
  
  private int eB(int paramInt)
  {
    AppMethodBeat.i(92714);
    if (!this.bmw.bmD) {
      this.bmw.a(this.blr.uY(), new a(this.bmw.bci, this.bmr));
    }
    paramInt = Math.min(paramInt, (int)(this.bmw.bci - this.bgB));
    AppMethodBeat.o(92714);
    return paramInt;
  }
  
  private void eC(int paramInt)
  {
    this.bgB += paramInt;
    if (this.bgB == this.bmw.bci) {
      this.bmw = this.bmw.bmF;
    }
  }
  
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92710);
    paramInt = eB(paramInt);
    paramInt = paramf.read(this.bmw.bmE.data, this.bmw.ae(this.bgB), paramInt);
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
    eC(paramInt);
    AppMethodBeat.o(92710);
    return paramInt;
  }
  
  public final int a(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(92704);
    switch (this.bms.a(paramk, parame, paramBoolean1, paramBoolean2, this.bmx, this.bmt))
    {
    default: 
      paramk = new IllegalStateException();
      AppMethodBeat.o(92704);
      throw paramk;
    case -5: 
      this.bmx = paramk.aTo;
      AppMethodBeat.o(92704);
      return -5;
    case -4: 
      if (!parame.sz())
      {
        if (parame.timeUs < paramLong) {
          parame.dL(-2147483648);
        }
        if (parame.sD()) {
          a(parame, this.bmt);
        }
        parame.dN(this.bmt.size);
        a(this.bmt.offset, parame.aJg, this.bmt.size);
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
    if (this.bmy) {
      f(this.bmz);
    }
    if (this.bmB)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.bms.ab(paramLong)))
      {
        AppMethodBeat.o(92712);
        return;
      }
      this.bmB = false;
    }
    long l1 = this.bmA;
    long l2 = this.bgB;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.bms.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
    AppMethodBeat.o(92712);
  }
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92711);
    while (paramInt > 0)
    {
      int i = eB(paramInt);
      paramm.readBytes(this.bmw.bmE.data, this.bmw.ae(this.bgB), i);
      paramInt -= i;
      eC(i);
    }
    AppMethodBeat.o(92711);
  }
  
  public final void f(Format paramFormat)
  {
    AppMethodBeat.i(92709);
    long l = this.bmA;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.bms.i(localFormat);
      this.bmz = paramFormat;
      this.bmy = false;
      if ((this.bmC != null) && (bool)) {
        this.bmC.tR();
      }
      AppMethodBeat.o(92709);
      return;
      if ((l != 0L) && (paramFormat.aTk != 9223372036854775807L)) {
        localFormat = paramFormat.D(l + paramFormat.aTk);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final boolean f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92703);
    paramBoolean = this.bms.f(paramLong, paramBoolean);
    AppMethodBeat.o(92703);
    return paramBoolean;
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(195775);
    ad(this.bms.g(paramLong, paramBoolean));
    AppMethodBeat.o(195775);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92697);
    this.bms.reset(paramBoolean);
    a(this.bmu);
    this.bmu = new a(0L, this.bmr);
    this.bmv = this.bmu;
    this.bmw = this.bmu;
    this.bgB = 0L;
    this.blr.trim();
    AppMethodBeat.o(92697);
  }
  
  public final void rewind()
  {
    AppMethodBeat.i(92699);
    this.bms.rewind();
    this.bmv = this.bmu;
    AppMethodBeat.o(92699);
  }
  
  public final void ug()
  {
    AppMethodBeat.i(92701);
    ad(this.bms.ue());
    AppMethodBeat.o(92701);
  }
  
  public final void uh()
  {
    AppMethodBeat.i(92702);
    ad(this.bms.uf());
    AppMethodBeat.o(92702);
  }
  
  static final class a
  {
    public final long bci;
    public final long beC;
    public boolean bmD;
    public a bmE;
    public a bmF;
    
    public a(long paramLong, int paramInt)
    {
      AppMethodBeat.i(92695);
      this.beC = paramLong;
      this.bci = (paramInt + paramLong);
      AppMethodBeat.o(92695);
    }
    
    public final void a(a parama, a parama1)
    {
      this.bmE = parama;
      this.bmF = parama1;
      this.bmD = true;
    }
    
    public final int ae(long paramLong)
    {
      return (int)(paramLong - this.beC) + this.bmE.offset;
    }
    
    public final a ui()
    {
      this.bmE = null;
      a locala = this.bmF;
      this.bmF = null;
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void tR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */