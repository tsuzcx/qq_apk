package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

final class b$a
  implements IBitmap<Object>
{
  public final void decodeInputStream(InputStream paramInputStream, Bitmap.Config paramConfig, c paramc)
  {
    AppMethodBeat.i(115745);
    paramInputStream = new IOException("Stub");
    AppMethodBeat.o(115745);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.a
 * JD-Core Version:    0.7.0.1
 */