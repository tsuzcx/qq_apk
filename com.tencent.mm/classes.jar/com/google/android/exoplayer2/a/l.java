package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  float aSD;
  private k aVU;
  private ShortBuffer aVV;
  long aVW;
  long aVX;
  private int aVk;
  private boolean aVn;
  private ByteBuffer buffer;
  private int channelCount;
  private ByteBuffer outputBuffer;
  float pitch;
  
  public l()
  {
    AppMethodBeat.i(91839);
    this.aSD = 1.0F;
    this.pitch = 1.0F;
    this.channelCount = -1;
    this.aVk = -1;
    this.buffer = aTH;
    this.aVV = this.buffer.asShortBuffer();
    this.outputBuffer = aTH;
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
      this.aVW += i;
      localObject2 = this.aVU;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).aVz;
      k = ((k)localObject2).aVz;
      ((k)localObject2).dL(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).aVF, ((k)localObject2).aVM * ((k)localObject2).aVz, k * j * 2 / 2);
      ((k)localObject2).aVM += j;
      ((k)localObject2).so();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.aVU.aVN * this.channelCount * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label311;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.aVV = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.aVU;
      localObject1 = this.aVV;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.aVz, paramByteBuffer.aVN);
      ((ShortBuffer)localObject1).put(paramByteBuffer.aVH, 0, paramByteBuffer.aVz * j);
      paramByteBuffer.aVN -= j;
      localObject1 = paramByteBuffer.aVH;
      k = paramByteBuffer.aVz;
      localObject2 = paramByteBuffer.aVH;
      int m = paramByteBuffer.aVN;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.aVz * m);
      this.aVX += i;
      this.buffer.limit(i);
      this.outputBuffer = this.buffer;
      AppMethodBeat.o(91842);
      return;
      label311:
      this.buffer.clear();
      this.aVV.clear();
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(91844);
    this.aVU = new k(this.aVk, this.channelCount);
    this.aVU.aSD = this.aSD;
    this.aVU.pitch = this.pitch;
    this.outputBuffer = aTH;
    this.aVW = 0L;
    this.aVX = 0L;
    this.aVn = false;
    AppMethodBeat.o(91844);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(91841);
    if ((Math.abs(this.aSD - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F))
    {
      AppMethodBeat.o(91841);
      return true;
    }
    AppMethodBeat.o(91841);
    return false;
  }
  
  public final boolean rM()
  {
    return (this.aVn) && ((this.aVU == null) || (this.aVU.aVN == 0));
  }
  
  public final int rU()
  {
    return this.channelCount;
  }
  
  public final void rV()
  {
    AppMethodBeat.i(91843);
    k localk = this.aVU;
    int j = localk.aVM;
    float f = localk.aSD / localk.pitch;
    int k = localk.aVN + (int)((j / f + localk.aVO) / localk.pitch + 0.5F);
    localk.dL(localk.aVC * 2 + j);
    int i = 0;
    while (i < localk.aVC * 2 * localk.aVz)
    {
      localk.aVF[(localk.aVz * j + i)] = 0;
      i += 1;
    }
    localk.aVM += localk.aVC * 2;
    localk.so();
    if (localk.aVN > k) {
      localk.aVN = k;
    }
    localk.aVM = 0;
    localk.aVP = 0;
    localk.aVO = 0;
    this.aVn = true;
    AppMethodBeat.o(91843);
  }
  
  public final ByteBuffer rW()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = aTH;
    return localByteBuffer;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91845);
    this.aVU = null;
    this.buffer = aTH;
    this.aVV = this.buffer.asShortBuffer();
    this.outputBuffer = aTH;
    this.channelCount = -1;
    this.aVk = -1;
    this.aVW = 0L;
    this.aVX = 0L;
    this.aVn = false;
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
    if ((this.aVk == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91840);
      return false;
    }
    this.aVk = paramInt1;
    this.channelCount = paramInt2;
    AppMethodBeat.o(91840);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */