package com.bumptech.glide.load.d.a;

import android.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class k
  implements ImageHeaderParser
{
  public final int a(InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(204480);
    int i = new ExifInterface(paramInputStream).getAttributeInt("Orientation", 1);
    if (i == 0)
    {
      AppMethodBeat.o(204480);
      return -1;
    }
    AppMethodBeat.o(204480);
    return i;
  }
  
  public final ImageHeaderParser.ImageType a(ByteBuffer paramByteBuffer)
  {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  public final ImageHeaderParser.ImageType c(InputStream paramInputStream)
  {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.k
 * JD-Core Version:    0.7.0.1
 */