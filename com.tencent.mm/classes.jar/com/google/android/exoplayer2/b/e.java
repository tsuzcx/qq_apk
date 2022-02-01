package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e
  extends a
{
  public final b cKP;
  public ByteBuffer cKQ;
  public final int cKR;
  public long timeUs;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(91850);
    this.cKP = new b();
    this.cKR = paramInt;
    AppMethodBeat.o(91850);
  }
  
  private ByteBuffer hs(int paramInt)
  {
    AppMethodBeat.i(91855);
    Object localObject;
    if (this.cKR == 1)
    {
      localObject = ByteBuffer.allocate(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.cKR == 2)
    {
      localObject = ByteBuffer.allocateDirect(paramInt);
      AppMethodBeat.o(91855);
      return localObject;
    }
    if (this.cKQ == null) {}
    for (int i = 0;; i = this.cKQ.capacity())
    {
      localObject = new IllegalStateException("Buffer too small (" + i + " < " + paramInt + ")");
      AppMethodBeat.o(91855);
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean RC()
  {
    AppMethodBeat.i(91852);
    boolean bool = hq(1073741824);
    AppMethodBeat.o(91852);
    return bool;
  }
  
  public final void RD()
  {
    AppMethodBeat.i(91853);
    this.cKQ.flip();
    AppMethodBeat.o(91853);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(91854);
    super.clear();
    if (this.cKQ != null) {
      this.cKQ.clear();
    }
    AppMethodBeat.o(91854);
  }
  
  public final void hr(int paramInt)
  {
    AppMethodBeat.i(91851);
    if (this.cKQ == null)
    {
      this.cKQ = hs(paramInt);
      AppMethodBeat.o(91851);
      return;
    }
    int i = this.cKQ.capacity();
    int j = this.cKQ.position();
    paramInt = j + paramInt;
    if (i >= paramInt)
    {
      AppMethodBeat.o(91851);
      return;
    }
    ByteBuffer localByteBuffer = hs(paramInt);
    if (j > 0)
    {
      this.cKQ.position(0);
      this.cKQ.limit(j);
      localByteBuffer.put(this.cKQ);
    }
    this.cKQ = localByteBuffer;
    AppMethodBeat.o(91851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */