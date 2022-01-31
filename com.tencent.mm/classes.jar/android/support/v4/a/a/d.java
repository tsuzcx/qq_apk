package android.support.v4.a.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class d
{
  public static b a(Resources paramResources, Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new c(paramResources, paramBitmap);
    }
    return new d.a(paramResources, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.a.a.d
 * JD-Core Version:    0.7.0.1
 */