package com.tencent.mm.d.a;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

final class k$a
{
  SharedV8ArrayBuffer cbA;
  final l cby;
  ByteBuffer cbz;
  private final int mCapacity;
  
  k$a(int paramInt, l paraml)
  {
    AppMethodBeat.i(113829);
    this.cby = paraml;
    this.mCapacity = paramInt;
    this.cbz = ByteBuffer.allocateDirect(this.mCapacity);
    this.cbA = null;
    AppMethodBeat.o(113829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.k.a
 * JD-Core Version:    0.7.0.1
 */