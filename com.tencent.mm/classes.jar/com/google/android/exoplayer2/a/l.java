package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  float bdQ;
  private int bgs;
  private boolean bgv;
  private k bhc;
  private ShortBuffer bhd;
  long bhe;
  long bhf;
  private ByteBuffer buffer;
  private int channelCount;
  private ByteBuffer outputBuffer;
  float pitch;
  
  public l()
  {
    AppMethodBeat.i(91839);
    this.bdQ = 1.0F;
    this.pitch = 1.0F;
    this.channelCount = -1;
    this.bgs = -1;
    this.buffer = beR;
    this.bhd = this.buffer.asShortBuffer();
    this.outputBuffer = beR;
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
      this.bhe += i;
      localObject2 = this.bhc;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).bgH;
      k = ((k)localObject2).bgH;
      ((k)localObject2).dO(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).bgN, ((k)localObject2).bgU * ((k)localObject2).bgH, k * j * 2 / 2);
      ((k)localObject2).bgU += j;
      ((k)localObject2).tW();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.bhc.bgV * this.channelCount * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label311;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.bhd = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.bhc;
      localObject1 = this.bhd;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.bgH, paramByteBuffer.bgV);
      ((ShortBuffer)localObject1).put(paramByteBuffer.bgP, 0, paramByteBuffer.bgH * j);
      paramByteBuffer.bgV -= j;
      localObject1 = paramByteBuffer.bgP;
      k = paramByteBuffer.bgH;
      localObject2 = paramByteBuffer.bgP;
      int m = paramByteBuffer.bgV;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.bgH * m);
      this.bhf += i;
      this.buffer.limit(i);
      this.outputBuffer = this.buffer;
      AppMethodBeat.o(91842);
      return;
      label311:
      this.buffer.clear();
      this.bhd.clear();
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(91844);
    this.bhc = new k(this.bgs, this.channelCount);
    this.bhc.bdQ = this.bdQ;
    this.bhc.pitch = this.pitch;
    this.outputBuffer = beR;
    this.bhe = 0L;
    this.bhf = 0L;
    this.bgv = false;
    AppMethodBeat.o(91844);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(91841);
    if ((Math.abs(this.bdQ - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F))
    {
      AppMethodBeat.o(91841);
      return true;
    }
    AppMethodBeat.o(91841);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91845);
    this.bhc = null;
    this.buffer = beR;
    this.bhd = this.buffer.asShortBuffer();
    this.outputBuffer = beR;
    this.channelCount = -1;
    this.bgs = -1;
    this.bhe = 0L;
    this.bhf = 0L;
    this.bgv = false;
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
    if ((this.bgs == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91840);
      return false;
    }
    this.bgs = paramInt1;
    this.channelCount = paramInt2;
    AppMethodBeat.o(91840);
    return true;
  }
  
  public final int tC()
  {
    return this.channelCount;
  }
  
  public final void tD()
  {
    AppMethodBeat.i(91843);
    k localk = this.bhc;
    int j = localk.bgU;
    float f = localk.bdQ / localk.pitch;
    int k = localk.bgV + (int)((j / f + localk.bgW) / localk.pitch + 0.5F);
    localk.dO(localk.bgK * 2 + j);
    int i = 0;
    while (i < localk.bgK * 2 * localk.bgH)
    {
      localk.bgN[(localk.bgH * j + i)] = 0;
      i += 1;
    }
    localk.bgU += localk.bgK * 2;
    localk.tW();
    if (localk.bgV > k) {
      localk.bgV = k;
    }
    localk.bgU = 0;
    localk.bgX = 0;
    localk.bgW = 0;
    this.bgv = true;
    AppMethodBeat.o(91843);
  }
  
  public final ByteBuffer tE()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = beR;
    return localByteBuffer;
  }
  
  public final boolean tw()
  {
    return (this.bgv) && ((this.bhc == null) || (this.bhc.bgV == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */