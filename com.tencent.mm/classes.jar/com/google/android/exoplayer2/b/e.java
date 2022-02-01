package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e
  extends a
{
  public ByteBuffer aKX;
  public final b bhs;
  public final int bht;
  public long timeUs;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(91850);
    this.bhs = new b();
    this.bht = paramInt;
    AppMethodBeat.o(91850);
  }
  
  private ByteBuffer dS(int paramInt)
  {
    AppMethodBeat.i(91855);
    Object localObject;
    if (this.bht == 1)
    {
      localObject = ByteBuffer.allocate(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.bht == 2)
    {
      localObject = ByteBuffer.allocateDirect(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aKX == null) {}
    for (int i = 0;; i = this.aKX.capacity())
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
    if (this.aKX != null) {
      this.aKX.clear();
    }
    AppMethodBeat.o(91854);
  }
  
  public final void dR(int paramInt)
  {
    AppMethodBeat.i(91851);
    if (this.aKX == null)
    {
      this.aKX = dS(paramInt);
      AppMethodBeat.o(91851);
      return;
    }
    int i = this.aKX.capacity();
    int j = this.aKX.position();
    paramInt = j + paramInt;
    if (i >= paramInt)
    {
      AppMethodBeat.o(91851);
      return;
    }
    ByteBuffer localByteBuffer = dS(paramInt);
    if (j > 0)
    {
      this.aKX.position(0);
      this.aKX.limit(j);
      localByteBuffer.put(this.aKX);
    }
    this.aKX = localByteBuffer;
    AppMethodBeat.o(91851);
  }
  
  public final boolean uc()
  {
    AppMethodBeat.i(91852);
    boolean bool = dQ(1073741824);
    AppMethodBeat.o(91852);
    return bool;
  }
  
  public final void ud()
  {
    AppMethodBeat.i(91853);
    this.aKX.flip();
    AppMethodBeat.o(91853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */