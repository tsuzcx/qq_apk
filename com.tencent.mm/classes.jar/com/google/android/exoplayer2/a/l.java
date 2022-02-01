package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  float aNo;
  private int aPP;
  private boolean aPS;
  private ShortBuffer aQA;
  long aQB;
  long aQC;
  private k aQz;
  private ByteBuffer buffer;
  private int channelCount;
  private ByteBuffer outputBuffer;
  float pitch;
  
  public l()
  {
    AppMethodBeat.i(91839);
    this.aNo = 1.0F;
    this.pitch = 1.0F;
    this.channelCount = -1;
    this.aPP = -1;
    this.buffer = aOp;
    this.aQA = this.buffer.asShortBuffer();
    this.outputBuffer = aOp;
    AppMethodBeat.o(91839);
  }
  
  public final void c(ByteBuffer paramByteBuffer)
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
      this.aQB += i;
      localObject2 = this.aQz;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).aQe;
      k = ((k)localObject2).aQe;
      ((k)localObject2).dX(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).aQk, ((k)localObject2).aQr * ((k)localObject2).aQe, k * j * 2 / 2);
      ((k)localObject2).aQr += j;
      ((k)localObject2).rT();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.aQz.aQs * this.channelCount * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label311;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.aQA = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.aQz;
      localObject1 = this.aQA;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.aQe, paramByteBuffer.aQs);
      ((ShortBuffer)localObject1).put(paramByteBuffer.aQm, 0, paramByteBuffer.aQe * j);
      paramByteBuffer.aQs -= j;
      localObject1 = paramByteBuffer.aQm;
      k = paramByteBuffer.aQe;
      localObject2 = paramByteBuffer.aQm;
      int m = paramByteBuffer.aQs;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.aQe * m);
      this.aQC += i;
      this.buffer.limit(i);
      this.outputBuffer = this.buffer;
      AppMethodBeat.o(91842);
      return;
      label311:
      this.buffer.clear();
      this.aQA.clear();
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(91844);
    this.aQz = new k(this.aPP, this.channelCount);
    this.aQz.aNo = this.aNo;
    this.aQz.pitch = this.pitch;
    this.outputBuffer = aOp;
    this.aQB = 0L;
    this.aQC = 0L;
    this.aPS = false;
    AppMethodBeat.o(91844);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(91841);
    if ((Math.abs(this.aNo - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F))
    {
      AppMethodBeat.o(91841);
      return true;
    }
    AppMethodBeat.o(91841);
    return false;
  }
  
  public final boolean m(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91840);
    if (paramInt3 != 2)
    {
      d.a locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(91840);
      throw locala;
    }
    if ((this.aPP == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91840);
      return false;
    }
    this.aPP = paramInt1;
    this.channelCount = paramInt2;
    AppMethodBeat.o(91840);
    return true;
  }
  
  public final void rA()
  {
    AppMethodBeat.i(91843);
    k localk = this.aQz;
    int j = localk.aQr;
    float f = localk.aNo / localk.pitch;
    int k = localk.aQs + (int)((j / f + localk.aQt) / localk.pitch + 0.5F);
    localk.dX(localk.aQh * 2 + j);
    int i = 0;
    while (i < localk.aQh * 2 * localk.aQe)
    {
      localk.aQk[(localk.aQe * j + i)] = 0;
      i += 1;
    }
    localk.aQr += localk.aQh * 2;
    localk.rT();
    if (localk.aQs > k) {
      localk.aQs = k;
    }
    localk.aQr = 0;
    localk.aQu = 0;
    localk.aQt = 0;
    this.aPS = true;
    AppMethodBeat.o(91843);
  }
  
  public final ByteBuffer rB()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = aOp;
    return localByteBuffer;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91845);
    this.aQz = null;
    this.buffer = aOp;
    this.aQA = this.buffer.asShortBuffer();
    this.outputBuffer = aOp;
    this.channelCount = -1;
    this.aPP = -1;
    this.aQB = 0L;
    this.aQC = 0L;
    this.aPS = false;
    AppMethodBeat.o(91845);
  }
  
  public final boolean rt()
  {
    return (this.aPS) && ((this.aQz == null) || (this.aQz.aQs == 0));
  }
  
  public final int rz()
  {
    return this.channelCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */