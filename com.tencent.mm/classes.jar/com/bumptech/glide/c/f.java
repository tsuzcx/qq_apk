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
    public final boolean aFd;
    
    static
    {
      AppMethodBeat.i(76845);
      aEV = new a("GIF", 0, true);
      aEW = new a("JPEG", 1, false);
      aEX = new a("RAW", 2, false);
      aEY = new a("PNG_A", 3, true);
      aEZ = new a("PNG", 4, false);
      aFa = new a("WEBP_A", 5, true);
      aFb = new a("WEBP", 6, false);
      aFc = new a("UNKNOWN", 7, false);
      aFe = new a[] { aEV, aEW, aEX, aEY, aEZ, aFa, aFb, aFc };
      AppMethodBeat.o(76845);
    }
    
    private a(boolean paramBoolean)
    {
      this.aFd = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.f
 * JD-Core Version:    0.7.0.1
 */