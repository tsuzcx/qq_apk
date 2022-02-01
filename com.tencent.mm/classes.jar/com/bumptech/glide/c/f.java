package com.bumptech.glide.c;

import com.bumptech.glide.c.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface f
{
  public abstract int a(InputStream paramInputStream, b paramb);
  
  public abstract a a(ByteBuffer paramByteBuffer);
  
  public abstract a c(InputStream paramInputStream);
  
  public static enum a
  {
    public final boolean aDm;
    
    static
    {
      AppMethodBeat.i(76845);
      aDe = new a("GIF", 0, true);
      aDf = new a("JPEG", 1, false);
      aDg = new a("RAW", 2, false);
      aDh = new a("PNG_A", 3, true);
      aDi = new a("PNG", 4, false);
      aDj = new a("WEBP_A", 5, true);
      aDk = new a("WEBP", 6, false);
      aDl = new a("UNKNOWN", 7, false);
      aDn = new a[] { aDe, aDf, aDg, aDh, aDi, aDj, aDk, aDl };
      AppMethodBeat.o(76845);
    }
    
    private a(boolean paramBoolean)
    {
      this.aDm = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.f
 * JD-Core Version:    0.7.0.1
 */