package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e
  extends a
{
  public final b aAR;
  public ByteBuffer aAS;
  public long aAT;
  public final int aAU;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(94739);
    this.aAR = new b();
    this.aAU = paramInt;
    AppMethodBeat.o(94739);
  }
  
  private ByteBuffer de(int paramInt)
  {
    AppMethodBeat.i(94744);
    Object localObject;
    if (this.aAU == 1)
    {
      localObject = ByteBuffer.allocate(paramInt);
      AppMethodBeat.o(94744);
      return localObject;
    }
    if (this.aAU == 2)
    {
      localObject = ByteBuffer.allocateDirect(paramInt);
      AppMethodBeat.o(94744);
      return localObject;
    }
    if (this.aAS == null) {}
    for (int i = 0;; i = this.aAS.capacity())
    {
      localObject = new IllegalStateException("Buffer too small (" + i + " < " + paramInt + ")");
      AppMethodBeat.o(94744);
      throw ((Throwable)localObject);
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(94743);
    super.clear();
    if (this.aAS != null) {
      this.aAS.clear();
    }
    AppMethodBeat.o(94743);
  }
  
  public final void dd(int paramInt)
  {
    AppMethodBeat.i(94740);
    if (this.aAS == null)
    {
      this.aAS = de(paramInt);
      AppMethodBeat.o(94740);
      return;
    }
    int i = this.aAS.capacity();
    int j = this.aAS.position();
    paramInt = j + paramInt;
    if (i >= paramInt)
    {
      AppMethodBeat.o(94740);
      return;
    }
    ByteBuffer localByteBuffer = de(paramInt);
    if (j > 0)
    {
      this.aAS.position(0);
      this.aAS.limit(j);
      localByteBuffer.put(this.aAS);
    }
    this.aAS = localByteBuffer;
    AppMethodBeat.o(94740);
  }
  
  public final boolean nI()
  {
    AppMethodBeat.i(94741);
    boolean bool = dc(1073741824);
    AppMethodBeat.o(94741);
    return bool;
  }
  
  public final void nJ()
  {
    AppMethodBeat.i(94742);
    this.aAS.flip();
    AppMethodBeat.o(94742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */