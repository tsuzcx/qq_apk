package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a
{
  public static int c(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getByteCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.graphics.a
 * JD-Core Version:    0.7.0.1
 */