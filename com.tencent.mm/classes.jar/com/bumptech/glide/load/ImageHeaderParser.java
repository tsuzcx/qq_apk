package com.bumptech.glide.load;

import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface ImageHeaderParser
{
  public abstract int a(InputStream paramInputStream, b paramb);
  
  public abstract ImageType a(ByteBuffer paramByteBuffer);
  
  public abstract ImageType c(InputStream paramInputStream);
  
  public static enum ImageType
  {
    private final boolean aEU;
    
    static
    {
      AppMethodBeat.i(76845);
      GIF = new ImageType("GIF", 0, true);
      JPEG = new ImageType("JPEG", 1, false);
      RAW = new ImageType("RAW", 2, false);
      PNG_A = new ImageType("PNG_A", 3, true);
      PNG = new ImageType("PNG", 4, false);
      WEBP_A = new ImageType("WEBP_A", 5, true);
      WEBP = new ImageType("WEBP", 6, false);
      UNKNOWN = new ImageType("UNKNOWN", 7, false);
      $VALUES = new ImageType[] { GIF, JPEG, RAW, PNG_A, PNG, WEBP_A, WEBP, UNKNOWN };
      AppMethodBeat.o(76845);
    }
    
    private ImageType(boolean paramBoolean)
    {
      this.aEU = paramBoolean;
    }
    
    public final boolean hasAlpha()
    {
      return this.aEU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.ImageHeaderParser
 * JD-Core Version:    0.7.0.1
 */