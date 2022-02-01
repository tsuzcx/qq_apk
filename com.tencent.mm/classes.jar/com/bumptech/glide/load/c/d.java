package com.bumptech.glide.load.c;

import android.util.Log;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d
  implements n<File, ByteBuffer>
{
  static final class a
    implements com.bumptech.glide.load.a.d<ByteBuffer>
  {
    private final File file;
    
    a(File paramFile)
    {
      this.file = paramFile;
    }
    
    public final void a(g paramg, com.bumptech.glide.load.a.d.a<? super ByteBuffer> parama)
    {
      AppMethodBeat.i(77214);
      try
      {
        paramg = com.bumptech.glide.g.a.v(this.file);
        parama.S(paramg);
        AppMethodBeat.o(77214);
        return;
      }
      catch (IOException paramg)
      {
        Log.isLoggable("ByteBufferFileLoader", 3);
        parama.e(paramg);
        AppMethodBeat.o(77214);
      }
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<ByteBuffer> os()
    {
      return ByteBuffer.class;
    }
    
    public final com.bumptech.glide.load.a ot()
    {
      return com.bumptech.glide.load.a.aEG;
    }
  }
  
  public static final class b
    implements o<File, ByteBuffer>
  {
    public final n<File, ByteBuffer> a(r paramr)
    {
      AppMethodBeat.i(77215);
      paramr = new d();
      AppMethodBeat.o(77215);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.d
 * JD-Core Version:    0.7.0.1
 */