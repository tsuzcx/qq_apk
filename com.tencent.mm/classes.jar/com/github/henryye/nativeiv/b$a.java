package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import java.io.IOException;
import java.io.InputStream;

final class b$a
  implements IBitmap<Object>
{
  public final void a(InputStream paramInputStream, Bitmap.Config paramConfig)
  {
    throw new IOException("Stub");
  }
  
  public final BitmapType getType()
  {
    return BitmapType.Undefined;
  }
  
  public final long ko()
  {
    return 0L;
  }
  
  public final Object provide()
  {
    return null;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.a
 * JD-Core Version:    0.7.0.1
 */