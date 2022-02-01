package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  float bdN;
  private k bgZ;
  private int bgp;
  private boolean bgs;
  private ShortBuffer bha;
  long bhb;
  long bhc;
  private ByteBuffer buffer;
  private int channelCount;
  private ByteBuffer outputBuffer;
  float pitch;
  
  public l()
  {
    AppMethodBeat.i(91839);
    this.bdN = 1.0F;
    this.pitch = 1.0F;
    this.channelCount = -1;
    this.bgp = -1;
    this.buffer = beO;
    this.bha = this.buffer.asShortBuffer();
    this.outputBuffer = beO;
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
      this.bhb += i;
      localObject2 = this.bgZ;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).bgE;
      k = ((k)localObject2).bgE;
      ((k)localObject2).dJ(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).bgK, ((k)localObject2).bgR * ((k)localObject2).bgE, k * j * 2 / 2);
      ((k)localObject2).bgR += j;
      ((k)localObject2).ub();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.bgZ.bgS * this.channelCount * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label311;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.bha = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.bgZ;
      localObject1 = this.bha;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.bgE, paramByteBuffer.bgS);
      ((ShortBuffer)localObject1).put(paramByteBuffer.bgM, 0, paramByteBuffer.bgE * j);
      paramByteBuffer.bgS -= j;
      localObject1 = paramByteBuffer.bgM;
      k = paramByteBuffer.bgE;
      localObject2 = paramByteBuffer.bgM;
      int m = paramByteBuffer.bgS;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.bgE * m);
      this.bhc += i;
      this.buffer.limit(i);
      this.outputBuffer = this.buffer;
      AppMethodBeat.o(91842);
      return;
      label311:
      this.buffer.clear();
      this.bha.clear();
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(91844);
    this.bgZ = new k(this.bgp, this.channelCount);
    this.bgZ.bdN = this.bdN;
    this.bgZ.pitch = this.pitch;
    this.outputBuffer = beO;
    this.bhb = 0L;
    this.bhc = 0L;
    this.bgs = false;
    AppMethodBeat.o(91844);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(91841);
    if ((Math.abs(this.bdN - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F))
    {
      AppMethodBeat.o(91841);
      return true;
    }
    AppMethodBeat.o(91841);
    return false;
  }
  
  public final boolean p(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91840);
    if (paramInt3 != 2)
    {
      d.a locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(91840);
      throw locala;
    }
    if ((this.bgp == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91840);
      return false;
    }
    this.bgp = paramInt1;
    this.channelCount = paramInt2;
    AppMethodBeat.o(91840);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91845);
    this.bgZ = null;
    this.buffer = beO;
    this.bha = this.buffer.asShortBuffer();
    this.outputBuffer = beO;
    this.channelCount = -1;
    this.bgp = -1;
    this.bhb = 0L;
    this.bhc = 0L;
    this.bgs = false;
    AppMethodBeat.o(91845);
  }
  
  public final boolean tB()
  {
    return (this.bgs) && ((this.bgZ == null) || (this.bgZ.bgS == 0));
  }
  
  public final int tH()
  {
    return this.channelCount;
  }
  
  public final void tI()
  {
    AppMethodBeat.i(91843);
    k localk = this.bgZ;
    int j = localk.bgR;
    float f = localk.bdN / localk.pitch;
    int k = localk.bgS + (int)((j / f + localk.bgT) / localk.pitch + 0.5F);
    localk.dJ(localk.bgH * 2 + j);
    int i = 0;
    while (i < localk.bgH * 2 * localk.bgE)
    {
      localk.bgK[(localk.bgE * j + i)] = 0;
      i += 1;
    }
    localk.bgR += localk.bgH * 2;
    localk.ub();
    if (localk.bgS > k) {
      localk.bgS = k;
    }
    localk.bgR = 0;
    localk.bgU = 0;
    localk.bgT = 0;
    this.bgs = true;
    AppMethodBeat.o(91843);
  }
  
  public final ByteBuffer tJ()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = beO;
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */