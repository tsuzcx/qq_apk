package com.bumptech.glide.load.d.b;

import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.a.e.a;
import java.nio.ByteBuffer;

public final class a
  implements e<ByteBuffer>
{
  private final ByteBuffer buffer;
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.buffer = paramByteBuffer;
  }
  
  public final void cleanup() {}
  
  public static final class a
    implements e.a<ByteBuffer>
  {
    public final Class<ByteBuffer> os()
    {
      return ByteBuffer.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.b.a
 * JD-Core Version:    0.7.0.1
 */