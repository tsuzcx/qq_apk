package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import java.io.IOException;
import java.io.InputStream;

final class b$b
  implements IBitmap<NativeBitmapStruct>
{
  public final void a(InputStream paramInputStream, Bitmap.Config paramConfig)
  {
    if (paramInputStream == null) {
      throw new IOException("Null input stream");
    }
  }
  
  public final BitmapType getType()
  {
    return BitmapType.Native;
  }
  
  public final long ko()
  {
    return 0L;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.b
 * JD-Core Version:    0.7.0.1
 */