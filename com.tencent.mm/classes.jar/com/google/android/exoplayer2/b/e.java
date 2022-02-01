package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e
  extends a
{
  public ByteBuffer aKP;
  public final b bhp;
  public final int bhq;
  public long timeUs;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(91850);
    this.bhp = new b();
    this.bhq = paramInt;
    AppMethodBeat.o(91850);
  }
  
  private ByteBuffer dN(int paramInt)
  {
    AppMethodBeat.i(91855);
    Object localObject;
    if (this.bhq == 1)
    {
      localObject = ByteBuffer.allocate(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.bhq == 2)
    {
      localObject = ByteBuffer.allocateDirect(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.aKP == null) {}
    for (int i = 0;; i = this.aKP.capacity())
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
    if (this.aKP != null) {
      this.aKP.clear();
    }
    AppMethodBeat.o(91854);
  }
  
  public final void dM(int paramInt)
  {
    AppMethodBeat.i(91851);
    if (this.aKP == null)
    {
      this.aKP = dN(paramInt);
      AppMethodBeat.o(91851);
      return;
    }
    int i = this.aKP.capacity();
    int j = this.aKP.position();
    paramInt = j + paramInt;
    if (i >= paramInt)
    {
      AppMethodBeat.o(91851);
      return;
    }
    ByteBuffer localByteBuffer = dN(paramInt);
    if (j > 0)
    {
      this.aKP.position(0);
      this.aKP.limit(j);
      localByteBuffer.put(this.aKP);
    }
    this.aKP = localByteBuffer;
    AppMethodBeat.o(91851);
  }
  
  public final boolean uh()
  {
    AppMethodBeat.i(91852);
    boolean bool = dL(1073741824);
    AppMethodBeat.o(91852);
    return bool;
  }
  
  public final void ui()
  {
    AppMethodBeat.i(91853);
    this.aKP.flip();
    AppMethodBeat.o(91853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */