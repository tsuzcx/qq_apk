package com.github.henryye.nativeiv;

import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

final class b$b
  implements IBitmap<NativeBitmapStruct>
{
  public final void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    AppMethodBeat.i(127333);
    if (paramInputStream == null)
    {
      paramInputStream = new IOException("Null input stream");
      AppMethodBeat.o(127333);
      throw paramInputStream;
    }
    AppMethodBeat.o(127333);
  }
  
  public final long getDecodeTime()
  {
    return 0L;
  }
  
  public final BitmapType getType()
  {
    return BitmapType.Native;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.b
 * JD-Core Version:    0.7.0.1
 */