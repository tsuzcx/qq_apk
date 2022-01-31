package android.support.v4.a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a
{
  static final a.c zR = new a.c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      zR = new a.b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      zR = new a.a();
      return;
    }
  }
  
  public static int c(Bitmap paramBitmap)
  {
    return zR.c(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.a.a
 * JD-Core Version:    0.7.0.1
 */