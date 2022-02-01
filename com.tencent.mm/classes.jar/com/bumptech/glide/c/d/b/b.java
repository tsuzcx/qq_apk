package com.bumptech.glide.c.d.b;

import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements u<byte[]>
{
  private final byte[] zr;
  
  public b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77452);
    this.zr = ((byte[])i.checkNotNull(paramArrayOfByte, "Argument must not be null"));
    AppMethodBeat.o(77452);
  }
  
  public final int getSize()
  {
    return this.zr.length;
  }
  
  public final Class<byte[]> oQ()
  {
    return [B.class;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.b.b
 * JD-Core Version:    0.7.0.1
 */