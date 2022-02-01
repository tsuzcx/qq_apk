package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b<Data>
  implements n<byte[], Data>
{
  private final b<Data> aHg;
  
  public b(b<Data> paramb)
  {
    this.aHg = paramb;
  }
  
  public static final class a
    implements o<byte[], ByteBuffer>
  {
    public final n<byte[], ByteBuffer> a(r paramr)
    {
      AppMethodBeat.i(77206);
      paramr = new b(new b.b()
      {
        public final Class<ByteBuffer> nK()
        {
          return ByteBuffer.class;
        }
      });
      AppMethodBeat.o(77206);
      return paramr;
    }
  }
  
  public static abstract interface b<Data>
  {
    public abstract Data l(byte[] paramArrayOfByte);
    
    public abstract Class<Data> nK();
  }
  
  static final class c<Data>
    implements d<Data>
  {
    private final b.b<Data> aHg;
    private final byte[] aHi;
    
    c(byte[] paramArrayOfByte, b.b<Data> paramb)
    {
      this.aHi = paramArrayOfByte;
      this.aHg = paramb;
    }
    
    public final void a(g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77207);
      parama.P(this.aHg.l(this.aHi));
      AppMethodBeat.o(77207);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<Data> nK()
    {
      AppMethodBeat.i(77208);
      Class localClass = this.aHg.nK();
      AppMethodBeat.o(77208);
      return localClass;
    }
    
    public final a nL()
    {
      return a.aBX;
    }
  }
  
  public static final class d
    implements o<byte[], InputStream>
  {
    public final n<byte[], InputStream> a(r paramr)
    {
      AppMethodBeat.i(77210);
      paramr = new b(new b.b()
      {
        public final Class<InputStream> nK()
        {
          return InputStream.class;
        }
      });
      AppMethodBeat.o(77210);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.b
 * JD-Core Version:    0.7.0.1
 */