package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  float aTw;
  private int aVX;
  private k aWH;
  private ShortBuffer aWI;
  long aWJ;
  long aWK;
  private boolean aWa;
  private ByteBuffer buffer;
  private int channelCount;
  private ByteBuffer outputBuffer;
  float pitch;
  
  public l()
  {
    AppMethodBeat.i(91839);
    this.aTw = 1.0F;
    this.pitch = 1.0F;
    this.channelCount = -1;
    this.aVX = -1;
    this.buffer = aUx;
    this.aWI = this.buffer.asShortBuffer();
    this.outputBuffer = aUx;
    AppMethodBeat.o(91839);
  }
  
  public final void f(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91842);
    Object localObject1;
    Object localObject2;
    int j;
    int k;
    if (paramByteBuffer.hasRemaining())
    {
      localObject1 = paramByteBuffer.asShortBuffer();
      i = paramByteBuffer.remaining();
      this.aWJ += i;
      localObject2 = this.aWH;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).aWm;
      k = ((k)localObject2).aWm;
      ((k)localObject2).dK(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).aWs, ((k)localObject2).aWz * ((k)localObject2).aWm, k * j * 2 / 2);
      ((k)localObject2).aWz += j;
      ((k)localObject2).sx();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.aWH.aWA * this.channelCount * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label311;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.aWI = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.aWH;
      localObject1 = this.aWI;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.aWm, paramByteBuffer.aWA);
      ((ShortBuffer)localObject1).put(paramByteBuffer.aWu, 0, paramByteBuffer.aWm * j);
      paramByteBuffer.aWA -= j;
      localObject1 = paramByteBuffer.aWu;
      k = paramByteBuffer.aWm;
      localObject2 = paramByteBuffer.aWu;
      int m = paramByteBuffer.aWA;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.aWm * m);
      this.aWK += i;
      this.buffer.limit(i);
      this.outputBuffer = this.buffer;
      AppMethodBeat.o(91842);
      return;
      label311:
      this.buffer.clear();
      this.aWI.clear();
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(91844);
    this.aWH = new k(this.aVX, this.channelCount);
    this.aWH.aTw = this.aTw;
    this.aWH.pitch = this.pitch;
    this.outputBuffer = aUx;
    this.aWJ = 0L;
    this.aWK = 0L;
    this.aWa = false;
    AppMethodBeat.o(91844);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(91841);
    if ((Math.abs(this.aTw - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F))
    {
      AppMethodBeat.o(91841);
      return true;
    }
    AppMethodBeat.o(91841);
    return false;
  }
  
  public final boolean rX()
  {
    return (this.aWa) && ((this.aWH == null) || (this.aWH.aWA == 0));
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91845);
    this.aWH = null;
    this.buffer = aUx;
    this.aWI = this.buffer.asShortBuffer();
    this.outputBuffer = aUx;
    this.channelCount = -1;
    this.aVX = -1;
    this.aWJ = 0L;
    this.aWK = 0L;
    this.aWa = false;
    AppMethodBeat.o(91845);
  }
  
  public final boolean s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91840);
    if (paramInt3 != 2)
    {
      d.a locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(91840);
      throw locala;
    }
    if ((this.aVX == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91840);
      return false;
    }
    this.aVX = paramInt1;
    this.channelCount = paramInt2;
    AppMethodBeat.o(91840);
    return true;
  }
  
  public final int sd()
  {
    return this.channelCount;
  }
  
  public final void se()
  {
    AppMethodBeat.i(91843);
    k localk = this.aWH;
    int j = localk.aWz;
    float f = localk.aTw / localk.pitch;
    int k = localk.aWA + (int)((j / f + localk.aWB) / localk.pitch + 0.5F);
    localk.dK(localk.aWp * 2 + j);
    int i = 0;
    while (i < localk.aWp * 2 * localk.aWm)
    {
      localk.aWs[(localk.aWm * j + i)] = 0;
      i += 1;
    }
    localk.aWz += localk.aWp * 2;
    localk.sx();
    if (localk.aWA > k) {
      localk.aWA = k;
    }
    localk.aWz = 0;
    localk.aWC = 0;
    localk.aWB = 0;
    this.aWa = true;
    AppMethodBeat.o(91843);
  }
  
  public final ByteBuffer sf()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = aUx;
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */