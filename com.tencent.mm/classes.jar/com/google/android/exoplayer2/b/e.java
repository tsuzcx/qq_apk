package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e
  extends a
{
  public final b aQT;
  public ByteBuffer aQU;
  public final int aQV;
  public long timeUs;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(91850);
    this.aQT = new b();
    this.aQV = paramInt;
    AppMethodBeat.o(91850);
  }
  
  private ByteBuffer eb(int paramInt)
  {
    AppMethodBeat.i(91855);
    Object localObject;
    if (this.aQV == 1)
    {
      localObject = ByteBuffer.allocate(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aQV == 2)
    {
      localObject = ByteBuffer.allocateDirect(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aQU == null) {}
    for (int i = 0;; i = this.aQU.capacity())
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
    if (this.aQU != null) {
      this.aQU.clear();
    }
    AppMethodBeat.o(91854);
  }
  
  public final void ea(int paramInt)
  {
    AppMethodBeat.i(91851);
    if (this.aQU == null)
    {
      this.aQU = eb(paramInt);
      AppMethodBeat.o(91851);
      return;
    }
    int i = this.aQU.capacity();
    int j = this.aQU.position();
    paramInt = j + paramInt;
    if (i >= paramInt)
    {
      AppMethodBeat.o(91851);
      return;
    }
    ByteBuffer localByteBuffer = eb(paramInt);
    if (j > 0)
    {
      this.aQU.position(0);
      this.aQU.limit(j);
      localByteBuffer.put(this.aQU);
    }
    this.aQU = localByteBuffer;
    AppMethodBeat.o(91851);
  }
  
  public final boolean rZ()
  {
    AppMethodBeat.i(91852);
    boolean bool = dZ(1073741824);
    AppMethodBeat.o(91852);
    return bool;
  }
  
  public final void sa()
  {
    AppMethodBeat.i(91853);
    this.aQU.flip();
    AppMethodBeat.o(91853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */