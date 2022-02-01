package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e
  extends a
{
  public ByteBuffer aIq;
  public final b aWk;
  public final int aWm;
  public long timeUs;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(91850);
    this.aWk = new b();
    this.aWm = paramInt;
    AppMethodBeat.o(91850);
  }
  
  private ByteBuffer dP(int paramInt)
  {
    AppMethodBeat.i(91855);
    Object localObject;
    if (this.aWm == 1)
    {
      localObject = ByteBuffer.allocate(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aWm == 2)
    {
      localObject = ByteBuffer.allocateDirect(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aIq == null) {}
    for (int i = 0;; i = this.aIq.capacity())
    {
      localObject = new IllegalStateException("Buffer too small (" + i + " < " + paramInt + ")");
      AppMethodBeat.o(91855);
      throw ((Throwable)localObject);
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(91854);
    super.clear();
    if (this.aIq != null) {
      this.aIq.clear();
    }
    AppMethodBeat.o(91854);
  }
  
  public final void dO(int paramInt)
  {
    AppMethodBeat.i(91851);
    if (this.aIq == null)
    {
      this.aIq = dP(paramInt);
      AppMethodBeat.o(91851);
      return;
    }
    int i = this.aIq.capacity();
    int j = this.aIq.position();
    paramInt = j + paramInt;
    if (i >= paramInt)
    {
      AppMethodBeat.o(91851);
      return;
    }
    ByteBuffer localByteBuffer = dP(paramInt);
    if (j > 0)
    {
      this.aIq.position(0);
      this.aIq.limit(j);
      localByteBuffer.put(this.aIq);
    }
    this.aIq = localByteBuffer;
    AppMethodBeat.o(91851);
  }
  
  public final boolean su()
  {
    AppMethodBeat.i(91852);
    boolean bool = dN(1073741824);
    AppMethodBeat.o(91852);
    return bool;
  }
  
  public final void sv()
  {
    AppMethodBeat.i(91853);
    this.aIq.flip();
    AppMethodBeat.o(91853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */