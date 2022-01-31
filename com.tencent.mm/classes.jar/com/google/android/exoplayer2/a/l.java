package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  private int auC = -1;
  float auT = 1.0F;
  private int axB = -1;
  private boolean axF;
  private ByteBuffer axd = avY;
  private k aym;
  private ShortBuffer ayn = this.buffer.asShortBuffer();
  long ayo;
  long ayp;
  private ByteBuffer buffer = avY;
  float pitch = 1.0F;
  
  public final void c(ByteBuffer paramByteBuffer)
  {
    Object localObject1;
    Object localObject2;
    int j;
    int k;
    if (paramByteBuffer.hasRemaining())
    {
      localObject1 = paramByteBuffer.asShortBuffer();
      i = paramByteBuffer.remaining();
      this.ayo += i;
      localObject2 = this.aym;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).axR;
      k = ((k)localObject2).axR;
      ((k)localObject2).cF(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).axX, ((k)localObject2).aye * ((k)localObject2).axR, k * j * 2 / 2);
      ((k)localObject2).aye += j;
      ((k)localObject2).lx();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.aym.ayf * this.auC * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label301;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.ayn = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.aym;
      localObject1 = this.ayn;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.axR, paramByteBuffer.ayf);
      ((ShortBuffer)localObject1).put(paramByteBuffer.axZ, 0, paramByteBuffer.axR * j);
      paramByteBuffer.ayf -= j;
      localObject1 = paramByteBuffer.axZ;
      k = paramByteBuffer.axR;
      localObject2 = paramByteBuffer.axZ;
      int m = paramByteBuffer.ayf;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.axR * m);
      this.ayp += i;
      this.buffer.limit(i);
      this.axd = this.buffer;
      return;
      label301:
      this.buffer.clear();
      this.ayn.clear();
    }
  }
  
  public final void flush()
  {
    this.aym = new k(this.axB, this.auC);
    this.aym.auT = this.auT;
    this.aym.pitch = this.pitch;
    this.axd = avY;
    this.ayo = 0L;
    this.ayp = 0L;
    this.axF = false;
  }
  
  public final boolean isActive()
  {
    return (Math.abs(this.auT - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F);
  }
  
  public final boolean kU()
  {
    return (this.axF) && ((this.aym == null) || (this.aym.ayf == 0));
  }
  
  public final int kZ()
  {
    return this.auC;
  }
  
  public final int la()
  {
    return 2;
  }
  
  public final void lb()
  {
    k localk = this.aym;
    int j = localk.aye;
    float f = localk.auT / localk.pitch;
    int k = localk.ayf + (int)((j / f + localk.ayg) / localk.pitch + 0.5F);
    localk.cF(localk.axU * 2 + j);
    int i = 0;
    while (i < localk.axU * 2 * localk.axR)
    {
      localk.axX[(localk.axR * j + i)] = 0;
      i += 1;
    }
    localk.aye += localk.axU * 2;
    localk.lx();
    if (localk.ayf > k) {
      localk.ayf = k;
    }
    localk.aye = 0;
    localk.ayh = 0;
    localk.ayg = 0;
    this.axF = true;
  }
  
  public final ByteBuffer lc()
  {
    ByteBuffer localByteBuffer = this.axd;
    this.axd = avY;
    return localByteBuffer;
  }
  
  public final boolean q(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 2) {
      throw new d.a(paramInt1, paramInt2, paramInt3);
    }
    if ((this.axB == paramInt1) && (this.auC == paramInt2)) {
      return false;
    }
    this.axB = paramInt1;
    this.auC = paramInt2;
    return true;
  }
  
  public final void reset()
  {
    this.aym = null;
    this.buffer = avY;
    this.ayn = this.buffer.asShortBuffer();
    this.axd = avY;
    this.auC = -1;
    this.axB = -1;
    this.ayo = 0L;
    this.ayp = 0L;
    this.axF = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */