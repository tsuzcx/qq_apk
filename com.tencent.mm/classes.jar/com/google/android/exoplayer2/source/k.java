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
  private final com.google.android.exoplayer2.i.m aBR;
  private long aKw;
  private final com.google.android.exoplayer2.h.b aPm;
  private final int aQm;
  public final j aQn;
  private final j.a aQo;
  private k.a aQp;
  private k.a aQq;
  private k.a aQr;
  private Format aQs;
  private boolean aQt;
  private Format aQu;
  private long aQv;
  public boolean aQw;
  public k.b aQx;
  
  public k(com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(95529);
    this.aPm = paramb;
    this.aQm = paramb.ql();
    this.aQn = new j();
    this.aQo = new j.a();
    this.aBR = new com.google.android.exoplayer2.i.m(32);
    this.aQp = new k.a(0L, this.aQm);
    this.aQq = this.aQp;
    this.aQr = this.aQp;
    AppMethodBeat.o(95529);
  }
  
  private void V(long paramLong)
  {
    while (paramLong >= this.aQq.aGe) {
      this.aQq = this.aQq.aQA;
    }
  }
  
  private void W(long paramLong)
  {
    AppMethodBeat.i(95540);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(95540);
      return;
    }
    while (paramLong >= this.aQp.aGe)
    {
      this.aPm.a(this.aQp.aQz);
      this.aQp = this.aQp.ps();
    }
    if (this.aQq.aIy < this.aQp.aIy) {
      this.aQq = this.aQp;
    }
    AppMethodBeat.o(95540);
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(95538);
    V(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.aQq.aGe - paramLong));
      paramByteBuffer.put(this.aQq.aQz.data, this.aQq.X(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.aQq.aGe)
      {
        this.aQq = this.aQq.aQA;
        paramLong = l;
        paramInt = i;
      }
    }
    AppMethodBeat.o(95538);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(95539);
    V(paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int k = Math.min(i, (int)(this.aQq.aGe - paramLong));
      System.arraycopy(this.aQq.aQz.data, this.aQq.X(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.aQq.aGe)
      {
        this.aQq = this.aQq.aQA;
        i = j;
        paramLong = l;
      }
    }
    AppMethodBeat.o(95539);
  }
  
  private void a(e parame, j.a parama)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(95537);
    long l1 = parama.offset;
    this.aBR.reset(1);
    a(l1, this.aBR.data, 1);
    l1 += 1L;
    int m = this.aBR.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (parame.aAR.iv == null) {
        parame.aAR.iv = new byte[16];
      }
      a(l1, parame.aAR.iv, m);
      l1 += m;
      if (i == 0) {
        break label312;
      }
      this.aBR.reset(2);
      a(l1, this.aBR.data, 2);
      j = this.aBR.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label312:
    for (;;)
    {
      localObject2 = parame.aAR.numBytesOfClearData;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = parame.aAR.numBytesOfEncryptedData;
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
      this.aBR.reset(i);
      a(l1, this.aBR.data, i);
      l2 = i;
      this.aBR.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.aBR.readUnsignedShort();
        localObject2[i] = this.aBR.qT();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = parama.aDw;
      parame.aAR.a(j, (int[])localObject1, (int[])localObject2, ((m.a)localObject3).aBL, parame.aAR.iv, ((m.a)localObject3).aBK, ((m.a)localObject3).aAF, ((m.a)localObject3).aAG);
      i = (int)(l1 - parama.offset);
      parama.offset += i;
      parama.size -= i;
      AppMethodBeat.o(95537);
      return;
      label404:
      localObject1[0] = 0;
      localObject2[0] = (parama.size - (int)(l1 - parama.offset));
    }
  }
  
  private void a(k.a parama)
  {
    int j = 0;
    AppMethodBeat.i(95545);
    if (!parama.aQy)
    {
      AppMethodBeat.o(95545);
      return;
    }
    if (this.aQr.aQy) {}
    a[] arrayOfa;
    for (int i = 1;; i = 0)
    {
      arrayOfa = new a[i + (int)(this.aQr.aIy - parama.aIy) / this.aQm];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = parama.aQz;
        parama = parama.ps();
        i += 1;
      }
    }
    this.aPm.a(arrayOfa);
    AppMethodBeat.o(95545);
  }
  
  private int dQ(int paramInt)
  {
    AppMethodBeat.i(95546);
    if (!this.aQr.aQy) {
      this.aQr.a(this.aPm.qk(), new k.a(this.aQr.aGe, this.aQm));
    }
    paramInt = Math.min(paramInt, (int)(this.aQr.aGe - this.aKw));
    AppMethodBeat.o(95546);
    return paramInt;
  }
  
  private void dR(int paramInt)
  {
    this.aKw += paramInt;
    if (this.aKw == this.aQr.aGe) {
      this.aQr = this.aQr.aQA;
    }
  }
  
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95542);
    paramInt = dQ(paramInt);
    paramInt = paramf.read(this.aQr.aQz.data, this.aQr.X(this.aKw), paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(95542);
        return -1;
      }
      paramf = new EOFException();
      AppMethodBeat.o(95542);
      throw paramf;
    }
    dR(paramInt);
    AppMethodBeat.o(95542);
    return paramInt;
  }
  
  public final int a(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(95536);
    switch (this.aQn.a(paramk, parame, paramBoolean1, paramBoolean2, this.aQs, this.aQo))
    {
    default: 
      paramk = new IllegalStateException();
      AppMethodBeat.o(95536);
      throw paramk;
    case -5: 
      this.aQs = paramk.axd;
      AppMethodBeat.o(95536);
      return -5;
    case -4: 
      if (!parame.nE())
      {
        if (parame.aAT < paramLong) {
          parame.db(-2147483648);
        }
        if (parame.nI()) {
          a(parame, this.aQo);
        }
        parame.dd(this.aQo.size);
        a(this.aQo.offset, parame.aAS, this.aQo.size);
      }
      AppMethodBeat.o(95536);
      return -4;
    }
    AppMethodBeat.o(95536);
    return -3;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, m.a parama)
  {
    AppMethodBeat.i(95544);
    if (this.aQt) {
      f(this.aQu);
    }
    if (this.aQw)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.aQn.U(paramLong)))
      {
        AppMethodBeat.o(95544);
        return;
      }
      this.aQw = false;
    }
    long l1 = this.aQv;
    long l2 = this.aKw;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.aQn.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
    AppMethodBeat.o(95544);
  }
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(95543);
    while (paramInt > 0)
    {
      int i = dQ(paramInt);
      paramm.readBytes(this.aQr.aQz.data, this.aQr.X(this.aKw), i);
      paramInt -= i;
      dR(i);
    }
    AppMethodBeat.o(95543);
  }
  
  public final void f(Format paramFormat)
  {
    AppMethodBeat.i(95541);
    long l = this.aQv;
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    for (;;)
    {
      boolean bool = this.aQn.i(localFormat);
      this.aQu = paramFormat;
      this.aQt = false;
      if ((this.aQx != null) && (bool)) {
        this.aQx.pb();
      }
      AppMethodBeat.o(95541);
      return;
      if ((l != 0L) && (paramFormat.awY != 9223372036854775807L)) {
        localFormat = paramFormat.w(l + paramFormat.awY);
      } else {
        localFormat = paramFormat;
      }
    }
  }
  
  public final boolean g(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95535);
    paramBoolean = this.aQn.g(paramLong, paramBoolean);
    AppMethodBeat.o(95535);
    return paramBoolean;
  }
  
  public final void i(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95532);
    W(this.aQn.h(paramLong, paramBoolean));
    AppMethodBeat.o(95532);
  }
  
  public final void pq()
  {
    AppMethodBeat.i(95533);
    W(this.aQn.po());
    AppMethodBeat.o(95533);
  }
  
  public final void pr()
  {
    AppMethodBeat.i(95534);
    W(this.aQn.pp());
    AppMethodBeat.o(95534);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(95530);
    this.aQn.reset(paramBoolean);
    a(this.aQp);
    this.aQp = new k.a(0L, this.aQm);
    this.aQq = this.aQp;
    this.aQr = this.aQp;
    this.aKw = 0L;
    this.aPm.trim();
    AppMethodBeat.o(95530);
  }
  
  public final void rewind()
  {
    AppMethodBeat.i(95531);
    this.aQn.rewind();
    this.aQq = this.aQp;
    AppMethodBeat.o(95531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */