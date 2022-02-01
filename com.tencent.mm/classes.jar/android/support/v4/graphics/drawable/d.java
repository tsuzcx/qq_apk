package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;

public final class d
{
  public static b a(Resources paramResources, Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new c(paramResources, paramBitmap);
    }
    return new a(paramResources, paramBitmap);
  }
  
  static final class a
    extends b
  {
    a(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    final void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
    {
      android.support.v4.view.d.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.graphics.drawable.d
 * JD-Core Version:    0.7.0.1
 */