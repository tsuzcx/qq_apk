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
    public final boolean aCu;
    
    static
    {
      AppMethodBeat.i(76845);
      aCm = new a("GIF", 0, true);
      aCn = new a("JPEG", 1, false);
      aCo = new a("RAW", 2, false);
      aCp = new a("PNG_A", 3, true);
      aCq = new a("PNG", 4, false);
      aCr = new a("WEBP_A", 5, true);
      aCs = new a("WEBP", 6, false);
      aCt = new a("UNKNOWN", 7, false);
      aCv = new a[] { aCm, aCn, aCo, aCp, aCq, aCr, aCs, aCt };
      AppMethodBeat.o(76845);
    }
    
    private a(boolean paramBoolean)
    {
      this.aCu = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.f
 * JD-Core Version:    0.7.0.1
 */