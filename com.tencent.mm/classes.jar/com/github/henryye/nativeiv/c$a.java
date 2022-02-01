package com.github.henryye.nativeiv;

import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

final class c$a
  implements IBitmap<Object>
{
  public final void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    AppMethodBeat.i(127332);
    paramInputStream = new IOException("Stub");
    AppMethodBeat.o(127332);
    throw paramInputStream;
  }
  
  public final long getDecodeTime()
  {
    return 0L;
  }
  
  public final BitmapType getType()
  {
    return BitmapType.Undefined;
  }
  
  public final Object provide()
  {
    return null;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.a
 * JD-Core Version:    0.7.0.1
 */