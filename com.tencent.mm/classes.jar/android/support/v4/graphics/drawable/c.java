package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

final class c
  extends b
{
  protected c(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
  }
  
  public final void getOutline(Outline paramOutline)
  {
    ey();
    paramOutline.setRoundRect(this.Ko, this.Kn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.graphics.drawable.c
 * JD-Core Version:    0.7.0.1
 */