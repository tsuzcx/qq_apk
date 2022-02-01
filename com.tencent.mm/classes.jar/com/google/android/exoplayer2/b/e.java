package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e
  extends a
{
  public ByteBuffer aJg;
  public final b aWX;
  public final int aWY;
  public long timeUs;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(91850);
    this.aWX = new b();
    this.aWY = paramInt;
    AppMethodBeat.o(91850);
  }
  
  private ByteBuffer dO(int paramInt)
  {
    AppMethodBeat.i(91855);
    Object localObject;
    if (this.aWY == 1)
    {
      localObject = ByteBuffer.allocate(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aWY == 2)
    {
      localObject = ByteBuffer.allocateDirect(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aJg == null) {}
    for (int i = 0;; i = this.aJg.capacity())
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
    if (this.aJg != null) {
      this.aJg.clear();
    }
    AppMethodBeat.o(91854);
  }
  
  public final void dN(int paramInt)
  {
    AppMethodBeat.i(91851);
    if (this.aJg == null)
    {
      this.aJg = dO(paramInt);
      AppMethodBeat.o(91851);
      return;
    }
    int i = this.aJg.capacity();
    int j = this.aJg.position();
    paramInt = j + paramInt;
    if (i >= paramInt)
    {
      AppMethodBeat.o(91851);
      return;
    }
    ByteBuffer localByteBuffer = dO(paramInt);
    if (j > 0)
    {
      this.aJg.position(0);
      this.aJg.limit(j);
      localByteBuffer.put(this.aJg);
    }
    this.aJg = localByteBuffer;
    AppMethodBeat.o(91851);
  }
  
  public final boolean sD()
  {
    AppMethodBeat.i(91852);
    boolean bool = dM(1073741824);
    AppMethodBeat.o(91852);
    return bool;
  }
  
  public final void sE()
  {
    AppMethodBeat.i(91853);
    this.aJg.flip();
    AppMethodBeat.o(91853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */