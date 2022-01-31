package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  private k aAB;
  private ShortBuffer aAC;
  long aAD;
  long aAE;
  private int awU;
  private int azR;
  private boolean azU;
  private ByteBuffer azt;
  private ByteBuffer buffer;
  float pitch;
  float speed;
  
  public l()
  {
    AppMethodBeat.i(94728);
    this.speed = 1.0F;
    this.pitch = 1.0F;
    this.awU = -1;
    this.azR = -1;
    this.buffer = ayo;
    this.aAC = this.buffer.asShortBuffer();
    this.azt = ayo;
    AppMethodBeat.o(94728);
  }
  
  public final void c(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(94731);
    Object localObject1;
    Object localObject2;
    int j;
    int k;
    if (paramByteBuffer.hasRemaining())
    {
      localObject1 = paramByteBuffer.asShortBuffer();
      i = paramByteBuffer.remaining();
      this.aAD += i;
      localObject2 = this.aAB;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).aAg;
      k = ((k)localObject2).aAg;
      ((k)localObject2).da(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).aAm, ((k)localObject2).aAt * ((k)localObject2).aAg, k * j * 2 / 2);
      ((k)localObject2).aAt += j;
      ((k)localObject2).nC();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.aAB.aAu * this.awU * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label311;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.aAC = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.aAB;
      localObject1 = this.aAC;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.aAg, paramByteBuffer.aAu);
      ((ShortBuffer)localObject1).put(paramByteBuffer.aAo, 0, paramByteBuffer.aAg * j);
      paramByteBuffer.aAu -= j;
      localObject1 = paramByteBuffer.aAo;
      k = paramByteBuffer.aAg;
      localObject2 = paramByteBuffer.aAo;
      int m = paramByteBuffer.aAu;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.aAg * m);
      this.aAE += i;
      this.buffer.limit(i);
      this.azt = this.buffer;
      AppMethodBeat.o(94731);
      return;
      label311:
      this.buffer.clear();
      this.aAC.clear();
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(94733);
    this.aAB = new k(this.azR, this.awU);
    this.aAB.speed = this.speed;
    this.aAB.pitch = this.pitch;
    this.azt = ayo;
    this.aAD = 0L;
    this.aAE = 0L;
    this.azU = false;
    AppMethodBeat.o(94733);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(94730);
    if ((Math.abs(this.speed - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F))
    {
      AppMethodBeat.o(94730);
      return true;
    }
    AppMethodBeat.o(94730);
    return false;
  }
  
  public final boolean nd()
  {
    return (this.azU) && ((this.aAB == null) || (this.aAB.aAu == 0));
  }
  
  public final int ni()
  {
    return this.awU;
  }
  
  public final void nj()
  {
    AppMethodBeat.i(94732);
    k localk = this.aAB;
    int j = localk.aAt;
    float f = localk.speed / localk.pitch;
    int k = localk.aAu + (int)((j / f + localk.aAv) / localk.pitch + 0.5F);
    localk.da(localk.aAj * 2 + j);
    int i = 0;
    while (i < localk.aAj * 2 * localk.aAg)
    {
      localk.aAm[(localk.aAg * j + i)] = 0;
      i += 1;
    }
    localk.aAt += localk.aAj * 2;
    localk.nC();
    if (localk.aAu > k) {
      localk.aAu = k;
    }
    localk.aAt = 0;
    localk.aAw = 0;
    localk.aAv = 0;
    this.azU = true;
    AppMethodBeat.o(94732);
  }
  
  public final ByteBuffer nk()
  {
    ByteBuffer localByteBuffer = this.azt;
    this.azt = ayo;
    return localByteBuffer;
  }
  
  public final boolean q(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94729);
    if (paramInt3 != 2)
    {
      d.a locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(94729);
      throw locala;
    }
    if ((this.azR == paramInt1) && (this.awU == paramInt2))
    {
      AppMethodBeat.o(94729);
      return false;
    }
    this.azR = paramInt1;
    this.awU = paramInt2;
    AppMethodBeat.o(94729);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94734);
    this.aAB = null;
    this.buffer = ayo;
    this.aAC = this.buffer.asShortBuffer();
    this.azt = ayo;
    this.awU = -1;
    this.azR = -1;
    this.aAD = 0L;
    this.aAE = 0L;
    this.azU = false;
    AppMethodBeat.o(94734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */