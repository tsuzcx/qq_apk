package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  private ByteBuffer buffer;
  float cHk;
  private int cJL;
  private boolean cJO;
  private k cKv;
  private ShortBuffer cKw;
  long cKx;
  long cKy;
  private int channelCount;
  private ByteBuffer outputBuffer;
  float pitch;
  
  public l()
  {
    AppMethodBeat.i(91839);
    this.cHk = 1.0F;
    this.pitch = 1.0F;
    this.channelCount = -1;
    this.cJL = -1;
    this.buffer = cIl;
    this.cKw = this.buffer.asShortBuffer();
    this.outputBuffer = cIl;
    AppMethodBeat.o(91839);
  }
  
  public final boolean C(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91840);
    if (paramInt3 != 2)
    {
      d.a locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(91840);
      throw locala;
    }
    if ((this.cJL == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91840);
      return false;
    }
    this.cJL = paramInt1;
    this.channelCount = paramInt2;
    AppMethodBeat.o(91840);
    return true;
  }
  
  public final boolean QU()
  {
    return (this.cJO) && ((this.cKv == null) || (this.cKv.cKo == 0));
  }
  
  public final int Rb()
  {
    return this.channelCount;
  }
  
  public final int Rc()
  {
    return 2;
  }
  
  public final void Rd()
  {
    AppMethodBeat.i(91843);
    k localk = this.cKv;
    int j = localk.cKn;
    float f = localk.cHk / localk.pitch;
    int k = localk.cKo + (int)((j / f + localk.cKp) / localk.pitch + 0.5F);
    localk.ho(localk.cKd * 2 + j);
    int i = 0;
    while (i < localk.cKd * 2 * localk.cKa)
    {
      localk.cKg[(localk.cKa * j + i)] = 0;
      i += 1;
    }
    localk.cKn += localk.cKd * 2;
    localk.Rw();
    if (localk.cKo > k) {
      localk.cKo = k;
    }
    localk.cKn = 0;
    localk.cKq = 0;
    localk.cKp = 0;
    this.cJO = true;
    AppMethodBeat.o(91843);
  }
  
  public final ByteBuffer Re()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = cIl;
    return localByteBuffer;
  }
  
  public final void d(ByteBuffer paramByteBuffer)
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
      this.cKx += i;
      localObject2 = this.cKv;
      j = ((ShortBuffer)localObject1).remaining() / ((k)localObject2).cKa;
      k = ((k)localObject2).cKa;
      ((k)localObject2).ho(j);
      ((ShortBuffer)localObject1).get(((k)localObject2).cKg, ((k)localObject2).cKn * ((k)localObject2).cKa, k * j * 2 / 2);
      ((k)localObject2).cKn += j;
      ((k)localObject2).Rw();
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.cKv.cKo * this.channelCount * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() >= i) {
        break label311;
      }
      this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.cKw = this.buffer.asShortBuffer();
    }
    for (;;)
    {
      paramByteBuffer = this.cKv;
      localObject1 = this.cKw;
      j = Math.min(((ShortBuffer)localObject1).remaining() / paramByteBuffer.cKa, paramByteBuffer.cKo);
      ((ShortBuffer)localObject1).put(paramByteBuffer.cKi, 0, paramByteBuffer.cKa * j);
      paramByteBuffer.cKo -= j;
      localObject1 = paramByteBuffer.cKi;
      k = paramByteBuffer.cKa;
      localObject2 = paramByteBuffer.cKi;
      int m = paramByteBuffer.cKo;
      System.arraycopy(localObject1, j * k, localObject2, 0, paramByteBuffer.cKa * m);
      this.cKy += i;
      this.buffer.limit(i);
      this.outputBuffer = this.buffer;
      AppMethodBeat.o(91842);
      return;
      label311:
      this.buffer.clear();
      this.cKw.clear();
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(91844);
    this.cKv = new k(this.cJL, this.channelCount);
    this.cKv.cHk = this.cHk;
    this.cKv.pitch = this.pitch;
    this.outputBuffer = cIl;
    this.cKx = 0L;
    this.cKy = 0L;
    this.cJO = false;
    AppMethodBeat.o(91844);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(91841);
    if ((Math.abs(this.cHk - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F))
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
    this.cKv = null;
    this.buffer = cIl;
    this.cKw = this.buffer.asShortBuffer();
    this.outputBuffer = cIl;
    this.channelCount = -1;
    this.cJL = -1;
    this.cKx = 0L;
    this.cKy = 0L;
    this.cJO = false;
    AppMethodBeat.o(91845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.l
 * JD-Core Version:    0.7.0.1
 */