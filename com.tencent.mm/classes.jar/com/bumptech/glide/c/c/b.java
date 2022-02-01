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
  private final b<Data> aJN;
  
  public b(b<Data> paramb)
  {
    this.aJN = paramb;
  }
  
  public static final class a
    implements o<byte[], ByteBuffer>
  {
    public final n<byte[], ByteBuffer> a(r paramr)
    {
      AppMethodBeat.i(77206);
      paramr = new b(new b.b()
      {
        public final Class<ByteBuffer> om()
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
    
    public abstract Class<Data> om();
  }
  
  static final class c<Data>
    implements d<Data>
  {
    private final b.b<Data> aJN;
    private final byte[] aJP;
    
    c(byte[] paramArrayOfByte, b.b<Data> paramb)
    {
      this.aJP = paramArrayOfByte;
      this.aJN = paramb;
    }
    
    public final void a(g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77207);
      parama.S(this.aJN.l(this.aJP));
      AppMethodBeat.o(77207);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<Data> om()
    {
      AppMethodBeat.i(77208);
      Class localClass = this.aJN.om();
      AppMethodBeat.o(77208);
      return localClass;
    }
    
    public final a on()
    {
      return a.aEG;
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
        public final Class<InputStream> om()
        {
          return InputStream.class;
        }
      });
      AppMethodBeat.o(77210);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.b
 * JD-Core Version:    0.7.0.1
 */