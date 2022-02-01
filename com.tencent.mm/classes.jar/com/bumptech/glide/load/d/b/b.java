package com.bumptech.glide.load.d.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements v<byte[]>
{
  private final byte[] zy;
  
  public b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77452);
    this.zy = ((byte[])j.checkNotNull(paramArrayOfByte, "Argument must not be null"));
    AppMethodBeat.o(77452);
  }
  
  public final int getSize()
  {
    return this.zy.length;
  }
  
  public final Class<byte[]> oV()
  {
    return [B.class;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.b.b
 * JD-Core Version:    0.7.0.1
 */